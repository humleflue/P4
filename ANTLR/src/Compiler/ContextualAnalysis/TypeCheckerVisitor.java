package Compiler.ContextualAnalysis;

import Compiler.AntlrGenerated.BuffBaseVisitor;
import Compiler.AntlrGenerated.BuffParser.*;
import Compiler.ErrorHandling.BuffErrorListener;
import Compiler.Lambda;
import Compiler.SymbolTable.FuncdefSymbol;
import Compiler.SymbolTable.Scope;
import Compiler.SymbolTable.Symbol;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Compiler.AntlrGenerated.BuffLexer.BOOLTYPE;
import static Compiler.AntlrGenerated.BuffLexer.DIVIDE;
import static Compiler.AntlrGenerated.BuffLexer.LOGAND;
import static Compiler.AntlrGenerated.BuffLexer.LOGEQ;
import static Compiler.AntlrGenerated.BuffLexer.LOGGREATER;
import static Compiler.AntlrGenerated.BuffLexer.LOGGREATEROREQ;
import static Compiler.AntlrGenerated.BuffLexer.LOGLESS;
import static Compiler.AntlrGenerated.BuffLexer.LOGLESSOREQ;
import static Compiler.AntlrGenerated.BuffLexer.LOGNOTEQ;
import static Compiler.AntlrGenerated.BuffLexer.LOGOR;
import static Compiler.AntlrGenerated.BuffLexer.MINUS;
import static Compiler.AntlrGenerated.BuffLexer.MULTIPLY;
import static Compiler.AntlrGenerated.BuffLexer.NUMTYPE;
import static Compiler.AntlrGenerated.BuffLexer.PLUS;
import static Compiler.AntlrGenerated.BuffLexer.POW;
import static Compiler.AntlrGenerated.BuffLexer.VOCABULARY;

/**
 * The type checker validates the type for:
 * - return statement/return type correspondence in function definition
 * - if-statement conditions (should be of type bool)
 * - expression operations
 * - function call parameters/function definition type correspondence
 */
public class TypeCheckerVisitor extends BuffBaseVisitor<Integer> {
    BuffErrorListener errorListener;
    Scope globalScope;
    ParseTreeProperty<Scope> scopes;

    /**
     * The constructor for the TypeCheckerVisitor class.
     *
     * @param globalScope The global scope defined by the symbol table.
     * @param scopes      A hash map used for finding the scope of a tree node.
     */
    public TypeCheckerVisitor(Scope globalScope, ParseTreeProperty<Scope> scopes, BuffErrorListener errorListener) {
        this.globalScope = globalScope;
        this.scopes = scopes;
        this.errorListener = errorListener;
    }

    /**
     * An auxiliary method for throwing a type related error.
     *
     * @param type1        The first type.
     * @param type2        The second type.
     * @param optionalText Text to be shown in the error message
     */
    private void throwTypeError(Integer type1, Integer type2, String optionalText,
                                Token offendingToken, Token... additionalOffendingTokens) {
        String leftType = VOCABULARY.getLiteralName(type1);
        String rightType = VOCABULARY.getLiteralName(type2);
        String errorMsg = String.format("Incompatible type: Type %s is incompatible with %s. %s",
                leftType, rightType, optionalText);

        ArrayList<Token> allOffendingTokens = new ArrayList<>(Arrays.asList(additionalOffendingTokens));
        allOffendingTokens.add(offendingToken);

        errorListener.ThrowError(errorMsg, allOffendingTokens);
    }

    /**
     * Checks the types of a binary operation
     *
     * @param ctx The node in question
     * @return Returns the type of the expression
     */
    @Override
    public Integer visitExprBinaryOp(ExprBinaryOpContext ctx) {
        int returnType;

        // Visit the children to thereby get their type.
        Integer left = visit(ctx.left);
        Integer right = visit(ctx.right);

        // Now we know that the two operators are of the same type: 'left == right' // true
        String errorText = "On operation " + ctx.op.getText() + ". Must be number type";
        switch (ctx.op.getType()) {
            case PLUS, MINUS, MULTIPLY, DIVIDE, POW -> {
                if (left != NUMTYPE || right != NUMTYPE)
                    throwTypeError(left, right, errorText, ctx.op);
                returnType = NUMTYPE;
            }
            case LOGLESS, LOGGREATER, LOGLESSOREQ, LOGGREATEROREQ -> {
                if (left != NUMTYPE || right != NUMTYPE)
                    throwTypeError(left, right, errorText, ctx.op);
                returnType = BOOLTYPE;
            }
            case LOGAND, LOGOR -> {
                if (left != BOOLTYPE || right != BOOLTYPE)
                    throwTypeError(left, right, errorText, ctx.op);
                returnType = BOOLTYPE;
            }
            case LOGEQ, LOGNOTEQ -> {
                if (!left.equals(right))
                    throwTypeError(left, right, errorText, ctx.op);
                returnType = BOOLTYPE;
            }
            default -> throw new IllegalArgumentException("Type not found by typechecker.");
        }

        return returnType;
    }

    /**
     * Checks the type of a unary operation
     *
     * @param ctx The node in question
     * @return The type of the operation
     */
    @Override
    public Integer visitExprUnaryOp(ExprUnaryOpContext ctx) {
        isExprTypeOfExpectedType(ctx.expr(),
                BOOLTYPE,
                ctx.op,
                typeName -> String.format("Incompatible type: Type %s is incompatible on operation NOT.", typeName));
        return BOOLTYPE;
    }

    /**
     * Checks that the type of a minus expression is a number
     *
     * @param ctx The node in question
     * @return The type of the expression
     */
    @Override
    public Integer visitExprMinusPrefix(ExprMinusPrefixContext ctx) {
        isExprTypeOfExpectedType(ctx.expr(),
                NUMTYPE,
                ctx.op,
                typeName -> String.format("Incompatible type: Type %s cannot be negative.", typeName));
        return NUMTYPE;
    }

    /**
     * Type checks an expression in an unary operation
     *
     * @param ctx                 The node in question
     * @param operator            The unary operator
     * @param produceErrorMessage The Lambda function should take the string representation of the type of the
     *                            expression as input, and produce a string, which will be the error message to
     *                            the user
     */
    private void isExprTypeOfExpectedType(ExprContext ctx, Integer expectedType, Token operator, Lambda<String, String> produceErrorMessage) {
        Integer exprType = visit(ctx);
        if (!exprType.equals(expectedType)) {
            String typeName = VOCABULARY.getLiteralName(exprType);
            String errorMsg = produceErrorMessage.execute(typeName);
            errorListener.ThrowError(errorMsg, operator);
        }
    }

    @Override
    public Integer visitExprParenthesised(ExprParenthesisedContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitExprNumber(ExprNumberContext ctx) {
        return NUMTYPE;
    }

    @Override
    public Integer visitExprBoolean(ExprBooleanContext ctx) {
        return BOOLTYPE;
    }

    /**
     * Retrieves the function's return type from the symbol table and returns it.
     *
     * @param ctx The function's tree node.
     * @return The function's return type.
     */
    @Override
    public Integer visitFuncCall(FuncCallContext ctx) {
        Symbol symbol = globalScope.getSymbol(ctx.ID().getText());
        visitChildren(ctx);
        return symbol.getType();
    }

    /**
     * Type checks the print functioncall functionality by calling visit on the
     * ctx's funccall() property
     *
     * @param ctx The function parameters' tree node.
     * @return the function's return type
     */
    @Override
    public Integer visitExprFunccallPrint(ExprFunccallPrintContext ctx) {
        return visit(ctx.funcCall());
    }

    /**
     * Type checks a function's parameters.
     *
     * @param ctx The function parameters' tree node.
     * @return An arbitrary Integer as this value is not used.
     */
    @Override
    public Integer visitExprParams(ExprParamsContext ctx) {
        //Gets lists of expression nodes in the actual parameters
        List<ExprContext> params = ctx.expr();

        // Visits each expression node in the actual params,
        // and thereby gets their types.
        ArrayList<Integer> actualTypes = visitAndGetChildrenTypes(i -> visit(ctx.expr(i)), params.size());

        // Retrieves the formal parameter's types
        // from the function definition found in the symbol table.
        FuncCallContext funccallContext = (FuncCallContext) ctx.parent;
        FuncdefSymbol symbol = (FuncdefSymbol) globalScope.getSymbol(funccallContext.ID().getText());
        List<Integer> formalParamTypes = symbol.getParameterTypes();

        // Check that the types correspond to each other.
        for (int i = 0; i < actualTypes.size(); i++) {
            checkFormalVsActualParams(actualTypes.get(i), formalParamTypes.get(i), funccallContext, params, i);
        }

        return this.defaultResult(); // This is an arbitrary Integer as this value is not used
    }

    /**
     * Checks whether or not the actual and formal parameter types match
     *
     * @param actual   The actual parameter
     * @param formal   The formal parameter
     * @param funccall The Funccall in hand
     * @param params   The list of parameters
     * @param index    The index of the parameter
     */
    private void checkFormalVsActualParams(Integer actual, Integer formal, FuncCallContext funccall, List<ExprContext> params,
                                           Integer index) {
        if (!actual.equals(formal))
            throwTypeError(actual, formal,
                    "Parameter type at \"" + funccall.ID().getText() +
                            "\" call does not match expected type from definition", params.get(index).start);
    }

    /**
     * Retrieves the id from the symbol table and returns its type.
     *
     * @param ctx The id's tree node.
     * @return The id's type.
     */
    @Override
    public Integer visitExprId(ExprIdContext ctx) {
        Scope currentScope = scopes.get(ctx);
        Symbol symbol = currentScope.getSymbol(ctx.ID().getText());
        return symbol.getType();
    }


    /**
     * Type check the function definition's return types corresponds to it's return statement's type.
     *
     * @param ctx The function definition's tree node.
     * @return The return type of the function definition.
     */
    @Override
    public Integer visitMultiLineFunction(MultiLineFunctionContext ctx) {
        // Check return statement's return type
        Integer returnType = getReturnType(ctx.typeAndId());
        Integer returnStmtType = visit(ctx.returnStmt());
        checkReturnTypeCorrespondence(returnStmtType, ctx.typeAndId(), ctx.returnStmt().stmt(), returnType);

        //Gets lists of stmt nodes in the actual parameters
        Integer stmtsLength = ctx.stmts().size();

        // Visits each stmts node, and thereby gets their types.
        ArrayList<Integer> stmtsTypes = visitAndGetChildrenTypes(i -> visit(ctx.stmts(i)), stmtsLength);
        int amountOfStmts = stmtsTypes.size();
        for (int i = 0; i < amountOfStmts; i++) {
            checkReturnTypeCorrespondence(stmtsTypes.get(i), ctx.typeAndId(), ctx.stmts().get(i).returnStmt().stmt(), returnType);
        }

        // Visit the rest of the children
        // Check if any funcDefParams exist as if none exist the test will throw an error
        if (ctx.funcDefParams() != null)
            visit(ctx.funcDefParams());

        // Returns the type of the function
        return returnType;
    }

    /**
     * Type check the functions definition's return type corresponds to it's return statement's type.
     *
     * @param ctx The function definition's tree node.
     * @return The return type of the function definition.
     */
    @Override
    public Integer visitOneLineFunction(OneLineFunctionContext ctx) {
        Integer returnStmtType = visit(ctx.stmt());
        checkReturnTypeCorrespondence(returnStmtType, ctx.typeAndId(), ctx.stmt(), getReturnType(ctx.typeAndId()));
        return returnStmtType;
    }

    /**
     * Gets the children types of a given node
     *
     * @param visitChild The node in question
     * @param size       The amount of children
     * @return A list of the children types
     */
    private ArrayList<Integer> visitAndGetChildrenTypes(Lambda<Integer, Integer> visitChild, Integer size) {
        ArrayList<Integer> types = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Integer type = visitChild.execute(i);
            types.add(type);
        }
        return types;
    }

    /**
     * Checks whether or not a functions return statement type matches the type defined in function definition.
     * Calls ThrowError in the errorListener if not.
     *
     * @param stmtType The type that the statement returns
     * @param ctx      The node for the function definition
     * @param stmt     The node for the statement being checked. Used for underlining
     */
    private void checkReturnTypeCorrespondence(Integer stmtType, TypeAndIdContext ctx, StmtContext stmt, Integer funcDefReturnType) {
        // Evaluate if the types are the same.
        if (!funcDefReturnType.equals(stmtType)) {
            String errorMsg = String.format("Incompatible type: Type %s is incompatible with %s. ",
                    VOCABULARY.getLiteralName(funcDefReturnType), VOCABULARY.getLiteralName(stmtType));
            errorMsg += "Does not return expected type in function definition: " + ctx.ID().getText();
            errorListener.ThrowError(errorMsg, stmt, ctx.type().start);
        }
    }

    /**
     * Gets the return type of a typeAndId production
     *
     * @param ctx The node in question
     * @return The type
     */
    private Integer getReturnType(TypeAndIdContext ctx) {
        String functionId = ctx.ID().getText();

        // Retrieve the function's return type from the symbol table
        Symbol symbol = globalScope.getSymbol(functionId);
        return symbol.getType();
    }

    @Override
    public Integer visitStmt(StmtContext ctx) {
        return visit(ctx.expr());
    }

    /**
     * Check if-condition for type errors.
     *
     * @param ctx The if-conditon's tree node.
     * @return Returns the type of the expression.
     */
    @Override
    public Integer visitStmts(StmtsContext ctx) {
        // Check if statement expression type
        Integer actualType = visit(ctx.expr());
        Integer expectedType = BOOLTYPE;

        if (!actualType.equals(expectedType))
            throwTypeError(actualType, expectedType, "In an if statement", ctx.expr().start);

        return visit(ctx.returnStmt());
    }

    @Override
    public Integer visitReturnStmt(ReturnStmtContext ctx) {
        return visit(ctx.stmt());
    }
}
