package Compiler.ContextualAnalysis;

import Compiler.AntlrGenerated.LangBaseListener;
import Compiler.AntlrGenerated.LangParser.*;
import Compiler.SymbolTable.BaseScope;
import Compiler.SymbolTable.FuncdefSymbol;
import Compiler.SymbolTable.Scope;
import Compiler.SymbolTable.Symbol;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class ReferenceCheckerListener extends LangBaseListener{
    ParseTreeProperty<Scope> scopes;
    Scope globalScope;
    Scope currentScope;

    public ReferenceCheckerListener(BaseScope globalScope, ParseTreeProperty<Scope> scopes) {
        this.scopes = scopes;
        this.globalScope = globalScope;
    }

    @Override
    public void enterProg(ProgContext ctx) {
        currentScope = globalScope;
    }

    @Override
    public void enterFuncdef(FuncdefContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitFuncdef(FuncdefContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void exitValId(ValIdContext ctx) {
        CheckSymbol(ctx.ID().getSymbol().getText());
    }

    @Override
    public void exitFunccall(FunccallContext ctx) throws IllegalArgumentException {
        CheckSymbol(ctx.ID().getSymbol().getText());

        int callArgCount = 0;
        //Check for null required, as it would otherwise crash when getting Expressions
        if(ctx.getRuleContext(ExprparamsNotEmptyContext.class,0) != null){
            callArgCount = ctx.getRuleContext(ExprparamsNotEmptyContext.class,0)
                              .getRuleContexts(ExprContext.class)
                              .size();
        }

        FuncdefSymbol function = (FuncdefSymbol) currentScope.getSymbol(ctx.ID().getText());
        Integer functionType = function.getType();
        int expectedArgCount = function.getParameterTypes().size();

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

