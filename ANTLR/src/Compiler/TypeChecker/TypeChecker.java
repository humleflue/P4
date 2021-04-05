package Compiler.TypeChecker;

import Compiler.AntlrGenerated.LangBaseVisitor;
import Compiler.AntlrGenerated.LangLexer;
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

    @Override
    public Type visitBinaryOp(BinaryOpContext ctx) {
        Type returnType;

        int left = visit(ctx.left).getType();
        int right = visit(ctx.right).getType();

        switch (ctx.op.getType()) {
            case MULTIPLY:
                if(left == NUMBERTYPE && right == NUMBERTYPE) {
                    returnType = new BaseType(NUMBERTYPE);
                }
                else {
                    throw new IllegalArgumentException("SHiiet");
                }
                break;
            default: throw new IllegalArgumentException("This should not happen.");
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

    //    @Override
//    public Type visitFunccall(FunccallContext ctx) {
//        currentScope = scopes.get(ctx);
//        Symbol symbol = globalScope.getSymbol(ctx.ID().getText());
//        return symbol.getType();
//    }

    @Override
    public Type visitValId(ValIdContext ctx) {
        currentScope = scopes.get(ctx);
        Symbol symbol = currentScope.getSymbol(ctx.ID().getText());
        return symbol.getType();
    }
}
