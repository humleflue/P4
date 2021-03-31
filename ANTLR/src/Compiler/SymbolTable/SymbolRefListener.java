package Compiler.SymbolTable;

import Compiler.Lang.LangBaseListener;
import Compiler.Lang.LangParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class SymbolRefListener extends LangBaseListener{
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    BaseScope globalScope;
    Scope currentScope;

    public SymbolRefListener(BaseScope globalScope, ParseTreeProperty<Scope> scopes) {
        this.scopes = scopes;
        this.globalScope = globalScope;
    }

    @Override
    public void enterProg(LangParser.ProgContext ctx) {
        currentScope = globalScope;
    }

    @Override
    public void enterFuncdef(LangParser.FuncdefContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitFuncdef(LangParser.FuncdefContext ctx) {
        CheckSymbolType(ctx.ID().getSymbol().getText(), ctx.start.getType());

        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void exitFuncdefparam(LangParser.FuncdefparamContext ctx) {
        CheckSymbolType(ctx.ID().getSymbol().getText(), ctx.start.getType());
    }

    @Override
    public void exitValId(LangParser.ValIdContext ctx) {
        System.out.println("Found valID: " + ctx.ID().getText());
        CheckSymbolType(ctx.ID().getSymbol().getText(), ctx.start.getType());
    }

    @Override
    public void exitFunccall(LangParser.FunccallContext ctx) {
        CheckSymbolType(ctx.ID().getSymbol().getText(), ctx.start.getType());
    }

    void CheckSymbolType(String name, int typeVal) throws IllegalArgumentException {
        Symbol symbol = currentScope.getSymbol(name);
        if ( symbol==null ) {
            throw new IllegalArgumentException(name + " is not defined");
        }
    }

}

