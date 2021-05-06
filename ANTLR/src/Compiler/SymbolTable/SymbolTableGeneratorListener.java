package Compiler.SymbolTable;

import Compiler.AntlrGenerated.BuffBaseListener;
import Compiler.AntlrGenerated.BuffParser.*;
import Compiler.ErrorHandling.BuffErrorListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Listener responsible for making the symbol table. Provides {@code scopes} and {@code globalScope}
 * for use by other listeners/visitors
 */
public class SymbolTableGeneratorListener extends BuffBaseListener{
    private BuffErrorListener errorListener;
    public ParseTreeProperty<Scope> scopes = new ParseTreeProperty<>();
    public BaseScope globalScope = new BaseScope();
    Scope currentScope;

    public SymbolTableGeneratorListener(BuffErrorListener errorListener) {
        this.errorListener = errorListener;
    }

    @Override
    public void enterProg(ProgContext ctx) {
        currentScope = globalScope;
    }

    @Override
    public void enterFuncdef(FuncdefContext ctx) {
        //Gets lists of parameters as ParseRuleContexts
        List<FuncdefparamContext> params =  ctx.getRuleContext(FuncdefparamsContext.class, 0)
                .getRuleContexts(FuncdefparamContext.class);

        //Might be useful for type-checking. Delete otherwise
        ArrayList<Integer> argumentList = new ArrayList<>();
        for (FuncdefparamContext param : params){
            argumentList.add(param.start.getType());
        }

        FuncdefSymbol symbol = new FuncdefSymbol(ctx.ID().getText(), ctx.start.getType(), argumentList);
        try {
            currentScope.defineSymbol(symbol);
        } catch (Exception e){
            errorListener.ThrowError(e.getMessage(), ctx.ID().getSymbol());
        }

        // Making new scope for function body
        Scope newScope = new BaseScope(currentScope);
        attachScope(ctx, newScope);
        currentScope = newScope;
    }

    @Override
    public void exitFuncdef(FuncdefContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void exitFuncdefparam(FuncdefparamContext ctx) {
        Integer paramType = ctx.start.getType();
        Symbol paramSymbol = new Symbol(ctx.ID().getText(), paramType);
        try {
            currentScope.defineSymbol(paramSymbol);
        } catch (Exception e){
            errorListener.ThrowError(e.getMessage(), ctx.ID().getSymbol());
        }

        attachScope(ctx, currentScope);
    }

    // Scopes attatched to ID and Funccall for easy access in type checking using scopes.get(ctx)
    @Override
    public void exitValId(ValIdContext ctx) {
        attachScope(ctx, currentScope);
    }

    @Override
    public void exitFunccall(FunccallContext ctx) {
        attachScope(ctx, currentScope);
    }

    /**
     * Adds a scope as a ParseTreeProperty to a node
     * @param ctx The node which should have a reference to a scope
     * @param s The scope which should be added to a node.
     */
    void attachScope(ParserRuleContext ctx, Scope s) { scopes.put(ctx, s); }
}
