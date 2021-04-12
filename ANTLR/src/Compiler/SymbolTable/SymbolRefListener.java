package Compiler.SymbolTable;

import Compiler.AntlrGenerated.LangBaseListener;
import Compiler.AntlrGenerated.LangParser.*;
import Compiler.ErrorHandling.UnderlineErrorListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class SymbolRefListener extends LangBaseListener{
    //Would like to make the Error Listener more generic, but that would be at the cost of more code in each listener.
    private UnderlineErrorListener errorListener;
    ParseTreeProperty<Scope> scopes;
    Scope globalScope;
    Scope currentScope;

    public SymbolRefListener(BaseScope globalScope, ParseTreeProperty<Scope> scopes, UnderlineErrorListener errorListener) {
        this.scopes = scopes;
        this.globalScope = globalScope;
        this.errorListener = errorListener;
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
        CheckSymbol(ctx.ID().getSymbol().getText(), ctx.ID().getSymbol());
    }

    @Override
    public void exitFunccall(FunccallContext ctx) throws IllegalArgumentException {
        CheckSymbol(ctx.ID().getSymbol().getText(), ctx.ID().getSymbol());

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
            String errorMsg = " Function " + ctx.ID().getText() + " expects " + expectedArgCount +
                    " arguments but was called with " + callArgCount;
            errorListener.GeneralError(errorMsg, ctx.exprparams().getStart());
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
            errorListener.GeneralError(name + " is not defined", token);
        }
    }

}

