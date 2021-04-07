package Compiler.TypeChecker;

import Compiler.AntlrGenerated.LangBaseVisitor;
import Compiler.AntlrGenerated.LangParser.*;
import Compiler.SymbolTable.Scope;
import Compiler.SymbolTable.Symbol;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

// WARNING: This might be a bad idea !!!
// This imports all of our enums from LangLexer,
// so that we don't have to write LangLexer.NUMBERTYPE,
// instead we can just write NUMBERTYPE
import static Compiler.AntlrGenerated.LangLexer.*;

public class TypeCheckerVisitor extends LangBaseVisitor<Integer> {
    // Scope stuff
    Scope globalScope;
    ParseTreeProperty<Scope> scopes;
    Scope currentScope;

    // Type stuff
//    ParseTreeProperty<Type> types = new ParseTreeProperty<Type>();

    public TypeCheckerVisitor(Scope globalScope, ParseTreeProperty<Scope> scopes) {
        this.scopes = scopes;
        this.globalScope = globalScope;
    }

    private Integer checkType(int left, int right, BinaryOpContext ctx, int expectedType) {
        Integer returnType = null;
        if(left == expectedType && right == expectedType) {
            returnType =  expectedType;
        }
        else {
            throwTypeError(left, right, "On operation " + ctx.op.getText());
        }

        return returnType;
    }

    private void throwTypeError(int type1, int type2) {
        throwTypeError(type1, type2, "");
    }
    private void throwTypeError(int left, int right, String optionalText) {
        String leftType = VOCABULARY.getLiteralName(left);
        String rightType = VOCABULARY.getLiteralName(right);
        throw new IllegalArgumentException(
                String.format("Incompatible type: Type %s is incompatible with %s. %s.",
                        leftType, rightType, optionalText)
        );
    }

    @Override
    public Integer visitBinaryOp(BinaryOpContext ctx) {
        Integer returnType;

        int left = visit(ctx.left);
        int right = visit(ctx.right);

        switch (ctx.op.getType()) {
            case PLUS, MINUS, MULTIPLY, DIVIDE, POW ->
                returnType = checkType(left, right, ctx, NUMBERTYPE);
            case LOGEQ, LOGNOTEQ, LOGLESS, LOGGREATER, LOGLESSOREQ, LOGGREATEROREQ, LOGAND, LOGOR ->
                returnType = checkType(left, right, ctx, BOOLTYPE);
            default -> throw new IllegalArgumentException("This should not happen.");
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

    @Override
    public Integer visitFunccall(FunccallContext ctx) {
        currentScope = scopes.get(ctx);
        Symbol symbol = globalScope.getSymbol(ctx.ID().getText());
        return symbol.getType();
    }

    @Override
    public Integer visitValId(ValIdContext ctx) {
        currentScope = scopes.get(ctx);
        Symbol symbol = currentScope.getSymbol(ctx.ID().getText());
        return symbol.getType();
    }

    @Override
    public Integer visitFuncdef(FuncdefContext ctx) {
        Integer returnType = null;

        // Retrieve the function's return type from the symbol table
        currentScope = scopes.get(ctx);
        Symbol symbol = globalScope.getSymbol(ctx.ID().getText());
        Integer funcdefReturnType = symbol.getType();
        int stmtType = visit(ctx.stmt());

        if(funcdefReturnType == stmtType) {
            returnType = funcdefReturnType;
        }
        else {
            throwTypeError(
                    funcdefReturnType, stmtType, "In function definition: " + ctx.ID().getText());
        }

        // Visit the rest of the children
        visit(ctx.type());
        visit(ctx.funcdefparams());
        visit(ctx.stmts());

        return returnType;
    }

    @Override
    public Integer visitStmt(StmtContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitStmtsNotEmpty(StmtsNotEmptyContext ctx) {
        Integer returnType = null;

        int StmtsNotEmptyExprReturnType = visit(ctx.expr());
        Integer expectedType = BOOLTYPE;

        if(StmtsNotEmptyExprReturnType == expectedType){
            returnType = StmtsNotEmptyExprReturnType;
        }
        else {
            throwTypeError(
                    StmtsNotEmptyExprReturnType, expectedType, "In an if statement");
        }

        // Visit the rest of the children
        visit(ctx.stmt());
        visit(ctx.stmts());

        return returnType;
    }
}
