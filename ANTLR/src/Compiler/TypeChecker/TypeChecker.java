package Compiler.TypeChecker;

import Compiler.AntlrGenerated.LangBaseVisitor;
import Compiler.AntlrGenerated.LangParser.*;
import Compiler.SymbolTable.BaseType;
import Compiler.SymbolTable.Scope;
import Compiler.SymbolTable.Symbol;
import Compiler.SymbolTable.Type;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

// WARNING: This might be a bad idea !!!
// This imports all of our enums from LangLexer,
// so that we don't have to write LangLexer.NUMBERTYPE,
// instead we can just write NUMBERTYPE
import static Compiler.AntlrGenerated.LangLexer.*;

public class TypeChecker extends LangBaseVisitor<Type> {
    // Scope stuff
    Scope globalScope;
    ParseTreeProperty<Scope> scopes;
    Scope currentScope;

    // Type stuff
//    ParseTreeProperty<Type> types = new ParseTreeProperty<Type>();

    public TypeChecker(Scope globalScope, ParseTreeProperty<Scope> scopes) {
        this.scopes = scopes;
        this.globalScope = globalScope;
    }

    private Type checkType(int left, int right, BinaryOpContext ctx, int expectedType) {
        Type returnType = null;
        if(left == expectedType && right == expectedType) {
            returnType =  new BaseType(expectedType);
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
    public Type visitBinaryOp(BinaryOpContext ctx) {
        Type returnType;

        int left = visit(ctx.left).getType();
        int right = visit(ctx.right).getType();

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
    public Type visitValNumber(ValNumberContext ctx) {
        return new BaseType(NUMBERTYPE);
    }

    @Override
    public Type visitValBoolean(ValBooleanContext ctx) {
        return new BaseType(BOOLTYPE);
    }

    @Override
    public Type visitFunccall(FunccallContext ctx) {
        currentScope = scopes.get(ctx);
        Symbol symbol = globalScope.getSymbol(ctx.ID().getText());
        return symbol.getType();
    }

    @Override
    public Type visitValId(ValIdContext ctx) {
        currentScope = scopes.get(ctx);
        Symbol symbol = currentScope.getSymbol(ctx.ID().getText());
        return symbol.getType();
    }

    @Override
    public Type visitFuncdef(FuncdefContext ctx) {
        Type returnType = null;

        currentScope = scopes.get(ctx);
        Symbol symbol = globalScope.getSymbol(ctx.ID().getText());
        Type funcdefReturnType = symbol.getType();
        int stmtType = visit(ctx.stmt()).getType();

        if(funcdefReturnType.getType() == stmtType) {
            returnType = funcdefReturnType;
        }
        else {
            throwTypeError(
                    funcdefReturnType.getType(), stmtType, "In function definition: " + ctx.ID().getText());
        }
        return returnType;
    }

    @Override
    public Type visitStmt(StmtContext ctx) {
        return visit(ctx.expr());
    }
}
