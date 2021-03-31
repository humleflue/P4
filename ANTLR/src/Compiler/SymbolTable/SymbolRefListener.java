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
        CheckSymbol(ctx.ID().getSymbol().getText());

        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void exitValId(LangParser.ValIdContext ctx) {
        System.out.println("Found valID: " + ctx.ID().getText());
        CheckSymbol(ctx.ID().getSymbol().getText());
    }

    @Override
    public void exitFunccall(LangParser.FunccallContext ctx) throws IllegalArgumentException {
        CheckSymbol(ctx.ID().getSymbol().getText());

        int callArgCount = 0;
        //Check for null required, as it would otherwise crash when getting Expressions
        if(ctx.getRuleContext(LangParser.ExprparamsNotEmptyContext.class,0) != null){
            callArgCount = ctx.getRuleContext(LangParser.ExprparamsNotEmptyContext.class,0)
                              .getRuleContexts(LangParser.ExprContext.class)
                              .size();
        }
        int expectedArgCount = ((FunctionType)(currentScope.getSymbol(ctx.ID().getText()).getType())).getArgumentList().size();

        if(callArgCount != expectedArgCount) {
            throw new IllegalArgumentException(ctx.ID().getText() + " expects " + expectedArgCount + " arguments but was called with " + callArgCount);
        }

    }

    void CheckSymbol(String name) throws IllegalArgumentException {
        Symbol symbol = currentScope.getSymbol(name);
        if ( symbol==null ) {
            throw new IllegalArgumentException(name + " is not defined");
        }
    }

}

