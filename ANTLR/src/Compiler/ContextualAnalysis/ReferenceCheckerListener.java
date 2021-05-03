package Compiler.ContextualAnalysis;

import Compiler.AntlrGenerated.BuffBaseListener;
import Compiler.AntlrGenerated.BuffParser.*;
import Compiler.ErrorHandling.BuffErrorListener;
import Compiler.ErrorHandling.UnderlineErrorListener;
import Compiler.SymbolTable.BaseScope;
import Compiler.SymbolTable.FuncdefSymbol;
import Compiler.SymbolTable.Scope;
import Compiler.SymbolTable.Symbol;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class ReferenceCheckerListener extends BuffBaseListener{
    BuffErrorListener errorListener;
    ParseTreeProperty<Scope> scopes;
    Scope globalScope;
    Scope currentScope;

    public ReferenceCheckerListener(BaseScope globalScope, ParseTreeProperty<Scope> scopes, BuffErrorListener errorListener) {
        this.scopes = scopes;
        this.globalScope = globalScope;
        this.errorListener = errorListener;
    }

    @Override
    public void enterProg(ProgContext ctx) {
        currentScope = globalScope;
    }

    @Override
    public void enterFuncDef(FuncDefContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitFuncDef(FuncDefContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void exitExprId(ExprIdContext ctx) {
        CheckSymbol(ctx.ID().getSymbol().getText(), ctx.ID().getSymbol());
    }

    @Override
    public void exitFuncCall(FuncCallContext ctx) throws IllegalArgumentException {
        CheckSymbol(ctx.ID().getSymbol().getText(), ctx.ID().getSymbol());

        int callArgCount = 0;
        //Check for null required, as it would otherwise crash when getting Expressions
        if(ctx.getRuleContext(ExprParamsContext.class,0) != null){
            callArgCount = ctx.getRuleContext(ExprParamsContext.class,0)
                              .getRuleContexts(ExprContext.class)
                              .size();
        }

        FuncdefSymbol function = (FuncdefSymbol) currentScope.getSymbol(ctx.ID().getText());
        Integer functionType = function.getType();
        int expectedArgCount = function.getParameterTypes().size();

        if(callArgCount != expectedArgCount) {
            String errorMsg = " Function " + ctx.ID().getText() + " expects " + expectedArgCount +
                    " arguments but was called with " + callArgCount;
            errorListener.ThrowError(errorMsg, ctx.exprParams().getStart());
        }
    }

    /**
     * Checks if a symbol exists in the current scope.
     *
     * @param name Name of the Symbol
     * @param token The token for the symbol. Used to point it out in the Error Listener.
     */
    void CheckSymbol(String name, Token token) {
        Symbol symbol = currentScope.getSymbol(name);
        if ( symbol==null ) {
            errorListener.ThrowError(name + " is not defined", token);
        }
    }

}

