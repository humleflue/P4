package Compiler.SymbolTable;

import Compiler.AntlrGenerated.BuffBaseListener;
import Compiler.AntlrGenerated.BuffParser.*;
import Compiler.ContextualAnalysis.Lambda;
import Compiler.ErrorHandling.BuffErrorListener;
import Compiler.ErrorHandling.UnderlineErrorListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import javax.swing.*;
import java.lang.reflect.Array;
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
    public void enterFuncDef(FuncDefContext ctx) {
        //Gets lists of parameters as ParseRuleContexts
        FuncDefParamsContext FuncDefParams =  ctx.getRuleContext(FuncDefParamsContext.class, 0);

        ArrayList<Integer> argumentList = new ArrayList<>();
        if (FuncDefParams != null) {
            //Might be useful for type-checking. Delete otherwise
            for (int i = 0; i < FuncDefParams.typeAndId().size(); i++)
                argumentList.add(FuncDefParams.typeAndId(i).type().start.getType());
        }

        FuncdefSymbol symbol = new FuncdefSymbol(ctx.typeAndId().ID().getText(), ctx.typeAndId().type().start.getType(), argumentList);
        try {
            currentScope.defineSymbol(symbol);
        } catch (Exception e){
            errorListener.ThrowError(e.getMessage(), ctx.typeAndId().ID().getSymbol());
        }

        // Making new scope for function body
        Scope newScope = new BaseScope(currentScope);
        attachScope(ctx, newScope);
        currentScope = newScope;
    }

    @Override
    public void exitFuncDef(FuncDefContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void exitFuncDefParams(FuncDefParamsContext ctx) {
        List<TypeAndIdContext> params = ctx.getRuleContexts(TypeAndIdContext.class);
        for (int i = 0; i < params.size(); i++)
            DefineParamSymbol(params.get(i));
    }

    public Void DefineParamSymbol(TypeAndIdContext ctx) {
        Integer paramType = ctx.type().start.getType();
        Symbol paramSymbol = new Symbol(ctx.ID().getText(), paramType);
        try {
            currentScope.defineSymbol(paramSymbol);
        } catch (Exception e){
            errorListener.ThrowError(e.getMessage(), ctx.ID().getSymbol());
        }

        attachScope(ctx, currentScope);
        return null;
    }

    // Scopes attatched to ID and Funccall for easy access in type checking using scopes.get(ctx)
    @Override
    public void exitExprId(ExprIdContext ctx) {
        attachScope(ctx, currentScope);
    }

    @Override
    public void exitFuncCall(FuncCallContext ctx) {
        attachScope(ctx, currentScope);
    }

    /**
     * Adds a scope as a ParseTreeProperty to a node
     * @param ctx The node which should have a reference to a scope
     * @param s The scope which should be added to a node.
     */
    void attachScope(ParserRuleContext ctx, Scope s) { scopes.put(ctx, s); }

    /**
     * Takes an that should be used to act on a list in any way
     * @param act The action that should be carried out
     * @param from The start index
     * @param to The end index
     */
}
