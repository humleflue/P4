package Compiler.ContextualAnalysis;

import Compiler.AntlrGenerated.BuffBaseListener;
import Compiler.AntlrGenerated.BuffParser.*;
import Compiler.ErrorHandling.BuffErrorListener;
import Compiler.SymbolTable.BaseScope;
import Compiler.SymbolTable.FuncdefSymbol;
import Compiler.SymbolTable.Scope;
import Compiler.SymbolTable.Symbol;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Listener responsible for checking that the functions called and parameters used are actually defined.
 */
public class ReferenceCheckerListener extends BuffBaseListener {
    BuffErrorListener errorListener;
    ParseTreeProperty<Scope> scopes;
    Scope globalScope;
    Scope currentScope;

    /**
     *
     * @param globalScope The global scope provided by the SymbolTableGeneratorListener.
     * @param scopes The Scope ParseTreeProperty provided by the SymbolTableGeneratorListener.
     * @param errorListener The BuffErrorListener that will recieve the errors found.
     */
    public ReferenceCheckerListener(BaseScope globalScope, ParseTreeProperty<Scope> scopes, BuffErrorListener errorListener) {
        this.scopes = scopes;
        this.globalScope = globalScope;
        this.errorListener = errorListener;
    }

    // The following small enter and exit functions exist to maintain the correct scoping while traversing the tree
    @Override
    public void enterProg(ProgContext ctx) {
        currentScope = globalScope;
    }

    @Override
    public void enterMultiLineFunction(MultiLineFunctionContext ctx) {
        openScope(ctx);
    }

    @Override
    public void exitMultiLineFunction(MultiLineFunctionContext ctx) {
        closeScope();
    }

    @Override
    public void enterOneLineFunction(OneLineFunctionContext ctx) {
        openScope(ctx);
    }

    @Override
    public void exitOneLineFunction(OneLineFunctionContext ctx) {
        closeScope();
    }

    /**
     * This function checks that both functions and parameters exist, as they both use the ExprId production.
     * @param ctx The ExprId's tree node.
     */
    @Override
    public void exitExprId(ExprIdContext ctx) {
        CheckSymbol(ctx.ID().getSymbol().getText(), ctx.ID().getSymbol());
    }

    /**
     * Checks that the number of arguments given in a function call matches the expected count
     * expected in the function definition.
     * @param ctx The FuncCall's tree node.
     */
    @Override
    public void exitFuncCall(FuncCallContext ctx) {
        CheckSymbol(ctx.ID().getSymbol().getText(), ctx.ID().getSymbol());

        int callArgCount = 0;
        //Check for null required, as it would otherwise crash when getting Expressions
        if (ctx.exprParams() != null)
            callArgCount = ctx.exprParams().expr().size();

        FuncdefSymbol function = (FuncdefSymbol) currentScope.getSymbol(ctx.ID().getText());
        int expectedArgCount = function.getParameterTypes().size();

        if (callArgCount != expectedArgCount) {
            String errorMsg = " Function " + ctx.ID().getText() + " expects " + expectedArgCount +
                    " arguments but was called with " + callArgCount;
            errorListener.ThrowError(errorMsg, ctx.exprParams().getStart());
        }
    }

    /**
     * Sets the current scope to be the scope of the given node
     *
     * @param ctx The node which scope we want
     */
    private void openScope(ParserRuleContext ctx) {
        currentScope = scopes.get(ctx);
    }

    /**
     * Sets the current scope to be the enclosing scope of the current scope
     */
    private void closeScope() {
        currentScope = currentScope.getEnclosingScope();
    }

    /**
     * Checks if a symbol exists in the current scope.
     *
     * @param name  Name of the Symbol
     * @param token The token for the symbol. Used to point it out in the Error Listener.
     */
    void CheckSymbol(String name, Token token) {
        Symbol symbol = currentScope.getSymbol(name);
        if (symbol == null) {
            errorListener.ThrowError(name + " is not defined", token);
        }
    }

}

