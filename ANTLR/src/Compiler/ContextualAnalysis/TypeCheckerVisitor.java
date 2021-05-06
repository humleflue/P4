package Compiler.ContextualAnalysis;

import Compiler.AntlrGenerated.BuffBaseVisitor;
import Compiler.AntlrGenerated.BuffParser.*;
import Compiler.ErrorHandling.BuffErrorListener;
import Compiler.SymbolTable.FuncdefSymbol;
import Compiler.SymbolTable.Scope;
import Compiler.SymbolTable.Symbol;
import Compiler.SymbolTable.Action;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// WARNING: This might be a bad idea !!!
// This imports all of our enums from LangLexer,
// so that we don't have to write LangLexer.NUMBERTYPE,
// instead we can just write NUMBERTYPE
import static Compiler.AntlrGenerated.BuffLexer.*;

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
     * @param globalScope The global scope defined by the symbol table.
     * @param scopes A hash map used for finding the scope of a tree node.
     */
    public TypeCheckerVisitor(Scope globalScope, ParseTreeProperty<Scope> scopes, BuffErrorListener errorListener) {
        this.globalScope = globalScope;
        this.scopes = scopes;
        this.errorListener = errorListener;
    }

    /**
     * An auxiliary method for throwing a type related error.
     * @param type1 The first type.
     * @param type2 The second type.
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

    @Override
    public Integer visitExprBinaryOp(ExprBinaryOpContext ctx) {
        int returnType; // initialized to -1 to check if switchcase evaluated

        // Visit the children to thereby get their type.
        Integer left = visit(ctx.left);
        Integer right = visit(ctx.right);

        if(!left.equals(right))
            throwTypeError(left, right, "On operation " + ctx.op.getText(), ctx.op);

        // Now we know that the two operators are of the same type: 'left == right' // true

        switch (ctx.op.getType()) {
            case PLUS, MINUS, MULTIPLY, DIVIDE, POW ->
                returnType = NUMTYPE;
            case LOGAND, LOGOR ->
                returnType = BOOLTYPE;
            case LOGEQ, LOGNOTEQ -> {
                if (left != right)
                    throwTypeError(left, right, "On operation" + ctx.op.getText() + ". Must be same type", ctx.op);
                returnType = BOOLTYPE; // left and right contains same value (integer presenting their type)
            }
            case LOGLESS, LOGGREATER, LOGLESSOREQ, LOGGREATEROREQ -> {
                if (left != NUMTYPE || right != NUMTYPE)
                    throwTypeError(left, right, "On operation" + ctx.op.getText() + ". Must be number type", ctx.op);
                returnType = BOOLTYPE; // left and right contains same value (integer presenting their type)
            }
            default -> throw new IllegalArgumentException("Type not found by typechecker.");
        }

        return returnType;
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
     * @param ctx The function parameters' tree node.
     * @return the function's return type
     */
    @Override
    public Integer visitExprFunccallPrint(ExprFunccallPrintContext ctx) {
        return visit(ctx.funcCall());
    }

    /**
     * Type checks a function's parameters.
     * @param ctx The function parameters' tree node.
     * @return An arbitrary Integer as this value is not used.
     */
    @Override
    public Integer visitExprParams(ExprParamsContext ctx) {
        //Gets lists of expression nodes in the actual parameters
        List<ExprContext> params =  ctx.getRuleContexts(ExprContext.class);

        // Visits each expression node in the actual params,
        // and thereby gets their types.
        ArrayList<Integer> actualTypes = visitAndGetChildrenTypes(i -> visit(ctx.expr(i)), params.size());

        // Retrieves the formal parameter's types
        // from the function definition found in the symbol table.
        FuncCallContext funccallContext = (FuncCallContext) ctx.parent;
        FuncdefSymbol symbol = (FuncdefSymbol) globalScope.getSymbol(funccallContext.ID().getText());
        List<Integer> formalParamTypes = symbol.getParameterTypes();

        // Check that the types correspond to each other.
        checkTypes(i -> checkFormalVsActualParams(actualTypes.get(i), formalParamTypes.get(i),
                funccallContext, params, i), 0, actualTypes.size());

        return this.defaultResult(); // This is an arbitrary Integer as this value is not used
    }

    /**
     * Checks whether or not the actual and formal parameter types match
     * @param actual The actual parameter
     * @param formal The formal parameter
     * @param funccall The Funccall in hand
     * @param params The list of parameters
     * @param index The index of the parameter
     */
    private void checkFormalVsActualParams(Integer actual, Integer formal, FuncCallContext funccall, List<ExprContext> params,
                                           Integer index){
        if(!actual.equals(formal))
            throwTypeError(actual, formal,
                    "Parameter type at \"" + funccall.ID().getText() +
                            "\" call does not match expected type from definition", params.get(index).start);
    }

    /**
     * Retrieves the id from the symbol table and returns its type.
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
     * @param ctx The function definition's tree node.
     * @return The return type of the function definition.
     */
    @Override
    public Integer visitIfFunction(IfFunctionContext ctx) {
        // Check return statement's return type
        Integer returnType = getReturnType(ctx.typeAndId());
        Integer returnStmtType = visit(ctx.returnStmt());
        checkReturnTypeCorrespondence(returnStmtType, ctx.typeAndId(), ctx.returnStmt().stmt(), returnType);

        //Gets lists of stmt nodes in the actual parameters
        Integer stmtsLength =  ctx.getRuleContexts(StmtsContext.class).size();

        // Visits each stmts node, and thereby gets their types.
        ArrayList<Integer> stmtsTypes = visitAndGetChildrenTypes(i -> visit(ctx.stmts(i)), stmtsLength);
        Integer amountOfStmts = stmtsTypes.size();

        checkTypes(i -> checkReturnTypeCorrespondence(stmtsTypes.get(i), ctx.typeAndId(), ctx.stmts().get(i).returnStmt().stmt(), returnType),
                    0, amountOfStmts);

        // Visit the rest of the children
        // Check if any funcDefParams exist as if none exist the test will throw an error
        if (ctx.funcDefParams() != null)
            visit(ctx.funcDefParams());

        // Returns the type of the function
        return returnType;
    }

    /**
     * Type check the functions definition's return type corresponds to it's return statement's type.
     * @param ctx The function definition's tree node.
     * @return The return type of the function definition.
     */
    @Override
    public Integer visitOneLineFunction(OneLineFunctionContext ctx) {
        Integer returnStmtType = visit(ctx.stmt());
        checkReturnTypeCorrespondence(returnStmtType, ctx.typeAndId(), ctx.stmt(), getReturnType(ctx.typeAndId()));
        return returnStmtType;
    }


    private ArrayList<Integer> visitAndGetChildrenTypes(Lambda<Integer> visitChild, Integer size) {
        ArrayList<Integer> types = new ArrayList<>();
        for (int i = 0; i < size; i++){
            Integer type = visitChild.execute(i);
            types.add(type);
        }
        return types;
    }

    /**
     * Checks whether or not a functions return statement type matches the type defined in function definition.
     * Calls ThrowError in the errorListener if not.
     * @param stmtType The type that the statement returns
     * @param ctx The node for the function definition
     * @param stmt The node for the statement being checked. Used for underlining
     */
    private void checkReturnTypeCorrespondence(Integer stmtType, TypeAndIdContext ctx, StmtContext stmt, Integer funcDefReturnType) {
        // Evaluate if the types are the same.
        if(!funcDefReturnType.equals(stmtType)){
            String errorMsg = String.format("Incompatible type: Type %s is incompatible with %s. ",
                    VOCABULARY.getLiteralName(funcDefReturnType), VOCABULARY.getLiteralName(stmtType));
            errorMsg += "Does not return expected type in function definition: " + ctx.ID().getText();
            errorListener.ThrowError(errorMsg, stmt, ctx.type().start);
        }
    }

    private Integer getReturnType(TypeAndIdContext ctx){
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
     * @param ctx The if-conditon's tree node.
     * @return Returns the type of the expression.
     */
    @Override
    public Integer visitStmts(StmtsContext ctx) {
        // Check if statement expression type
        Integer actualType = visit(ctx.expr());
        Integer expectedType = BOOLTYPE;

        if(!actualType.equals(expectedType))
            throwTypeError(actualType, expectedType, "In an if statement", ctx.expr().start);

        return visit(ctx.returnStmt());
    }

    @Override
    public Integer visitReturnStmt(ReturnStmtContext ctx) {
        return visit(ctx.stmt());
    }


    /**
     * Checks type correspondence on given checkFunction
     * @param checkFunction The function used to test the correspondance
     * @param from The start index
     * @param to The end index
     */
    private void checkTypes(Action checkFunction, Integer from, Integer to){
        for (int i = from; i < to; i ++)
            checkFunction.execute(i);
    }
}


