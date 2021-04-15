package Compiler.ContextualAnalysis;

import Compiler.AntlrGenerated.LangBaseVisitor;
import Compiler.AntlrGenerated.LangParser.*;
import Compiler.SymbolTable.FuncdefSymbol;
import Compiler.SymbolTable.Scope;
import Compiler.SymbolTable.Symbol;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.List;

// WARNING: This might be a bad idea !!!
// This imports all of our enums from LangLexer,
// so that we don't have to write LangLexer.NUMBERTYPE,
// instead we can just write NUMBERTYPE
import static Compiler.AntlrGenerated.LangLexer.*;

/**
 * The type checker validates the type for:
 * - return statement/return type correspondence in function definition
 * - if-statement conditions (should be of type bool)
 * - expression operations
 * - function call parameters/function definition type correspondence
 */
public class TypeCheckerVisitor extends LangBaseVisitor<Integer> {
    Scope globalScope;
    ParseTreeProperty<Scope> scopes;

    /**
     * The constructor for the TypeCheckerVisitor class.
     * @param globalScope The global scope defined by the symbol table.
     * @param scopes A hash map used for finding the scope of a tree node.
     */
    public TypeCheckerVisitor(Scope globalScope, ParseTreeProperty<Scope> scopes) {
        this.globalScope = globalScope;
        this.scopes = scopes;
    }

    /**
     * An auxiliary method for throwing a type related error.
     * @param type1 The first type.
     * @param type2 The second type.
     */
    private void throwTypeError(Integer type1, Integer type2) {
        throwTypeError(type1, type2, "");
    }

    /**
     * An auxiliary method for throwing a type related error.
     * @param type1 The first type.
     * @param type2 The second type.
     * @param optionalText Text to be shown in the error message
     */
    private void throwTypeError(Integer type1, Integer type2, String optionalText) {
        String leftType = VOCABULARY.getLiteralName(type1);
        String rightType = VOCABULARY.getLiteralName(type2);
        throw new IllegalArgumentException(
                String.format("Incompatible type: Type %s is incompatible with %s. %s",
                        leftType, rightType, optionalText)
        );
    }

    @Override
    public Integer visitBinaryOp(BinaryOpContext ctx) {
        int returnType;

        // Visit the children to thereby get their type.
        Integer left = visit(ctx.left);
        Integer right = visit(ctx.right);

        if(!left.equals(right)) {
            throwTypeError(left, right, "On operation " + ctx.op.getText());
        }

        // Now we know that the two operators are of the same type: 'left == right' // true

        switch (ctx.op.getType()) {
            case PLUS, MINUS, MULTIPLY, DIVIDE, POW ->
                returnType = NUMBERTYPE;
            case LOGAND, LOGOR ->
                returnType = BOOLTYPE;
            case LOGEQ, LOGNOTEQ, LOGLESS, LOGGREATER, LOGLESSOREQ, LOGGREATEROREQ -> {
                if(left != NUMBERTYPE) // You cannot compare eg. 'true == true'
                    throwTypeError(left, right, "On operation " + ctx.op.getText());
                returnType = BOOLTYPE;
            }
            default -> throw new IllegalArgumentException("Type not found by typechecker.");
        }

        return returnType;
    }

    @Override
    public Integer visitValNumber(ValNumberContext ctx) {
        return NUMBERTYPE;
    }

    @Override
    public Integer visitValBoolean(ValBooleanContext ctx) {
        return BOOLTYPE;
    }

    /**
     * Retrieves the function's return type from the symbol table and returns it.
     * @param ctx The function's tree node.
     * @return The function's return type.
     */
    @Override
    public Integer visitFunccall(FunccallContext ctx) {
        Symbol symbol = globalScope.getSymbol(ctx.ID().getText());
        visitChildren(ctx);
        return symbol.getType();
    }

    /**
     * Type checks a function's parameters.
     * @param ctx The function parameters' tree node.
     * @return An arbitrary Integer as this value is not used.
     */
    @Override
    public Integer visitExprparamsNotEmpty(ExprparamsNotEmptyContext ctx) {
        //Gets lists of expression nodes in the actual parameters
        List<ExprContext> params =  ctx.getRuleContexts(ExprContext.class);

        // Visits each expression node in the actual params,
        // and thereby gets their type.
        ArrayList<Integer> actualTypes = new ArrayList<>();
        for(int i = 0; i < params.size(); i++) {
            Integer type = visit(ctx.expr(i));
            actualTypes.add(type);
        }

        // Retrieves the formal parameter's types
        // from the function definition found in the symbol table.
        FunccallContext funccallContext = (FunccallContext) ctx.parent;
        FuncdefSymbol symbol = (FuncdefSymbol) globalScope.getSymbol(funccallContext.ID().getText());
        List<Integer> formalParamTypes = symbol.getParameterTypes();

        // Check that the types correspond to each other.
        for (int i = 0; i < actualTypes.size(); i++) {
            Integer actualType = actualTypes.get(i);
            Integer formalType = formalParamTypes.get(i);
            if(!actualType.equals(formalType)) {
                throwTypeError(actualType, formalType);
            }
        }

        return this.defaultResult(); // This is an arbitrary Integer as this value is not used
    }

    /**
     * Retrieves the id from the symbol table and returns its type.
     * @param ctx The id's tree node.
     * @return The id's type.
     */
    @Override
    public Integer visitValId(ValIdContext ctx) {
        Scope currentScope = scopes.get(ctx);
        Symbol symbol = currentScope.getSymbol(ctx.ID().getText());
        return symbol.getType();
    }

    /**
     * Type check the functions definition's return type corresponds to it's return statement's type.
     * @param ctx The function definition's tree node.
     * @return The return type of the function definition.
     */
    @Override
    public Integer visitFuncdef(FuncdefContext ctx) {
        // Retrieve the function's return type from the symbol table
        Symbol symbol = globalScope.getSymbol(ctx.ID().getText());
        Integer funcdefReturnType = symbol.getType();

        // Retrieve the statement's return type
        Integer stmtType = visit(ctx.stmt());

        // Evaluate if the types are the same.
        if(!funcdefReturnType.equals(stmtType)) {
            throwTypeError(
                    funcdefReturnType, stmtType, "In function definition: " + ctx.ID().getText());
        }

        // Visit the rest of the children
        visit(ctx.type());
        visit(ctx.funcdefparams());
        visit(ctx.stmts());

        return funcdefReturnType;
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
    public Integer visitStmtsNotEmpty(StmtsNotEmptyContext ctx) {
        Integer actualType = visit(ctx.expr());
        Integer expectedType = BOOLTYPE;

        if(!actualType.equals(expectedType)){
            throwTypeError(actualType, expectedType, "In an if statement");
        }

        // Visit the rest of the children
        visit(ctx.stmt());
        visit(ctx.stmts());

        return expectedType;
    }
}
