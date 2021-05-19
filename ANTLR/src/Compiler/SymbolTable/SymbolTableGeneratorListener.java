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
public class SymbolTableGeneratorListener extends BuffBaseListener {
    private final BuffErrorListener errorListener;
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
    public void enterMultiLineFunction(MultiLineFunctionContext ctx) {
        //Gets lists of parameters and converts them into a list of types
        FuncDefParamsContext FuncDefParams = ctx.getRuleContext(FuncDefParamsContext.class, 0);
        ArrayList<Integer> argumentList = getFuncDefParamTypes(FuncDefParams);
        FuncdefSymbol symbol = new FuncdefSymbol(ctx.typeAndId().ID().getText(), ctx.typeAndId().type().start.getType(), argumentList);
        try {
            currentScope.defineSymbol(symbol);
        } catch (Exception e) {
            errorListener.ThrowError(e.getMessage(), ctx.typeAndId().ID().getSymbol());
        }

        // Making new scope for function body
        makeAndAttachNewScope(ctx);
    }

    @Override
    public void exitMultiLineFunction(MultiLineFunctionContext ctx) {
        closeScope();
    }


    @Override
    public void enterOneLineFunction(OneLineFunctionContext ctx) {
        //Gets lists of parameters and converts them into a list of types
        FuncDefParamsContext FuncDefParams = ctx.getRuleContext(FuncDefParamsContext.class, 0);
        ArrayList<Integer> argumentList = getFuncDefParamTypes(FuncDefParams);
        FuncdefSymbol symbol = new FuncdefSymbol(ctx.typeAndId().ID().getText(), ctx.typeAndId().type().start.getType(), argumentList);
        try {
            currentScope.defineSymbol(symbol);
        } catch (Exception e) {
            errorListener.ThrowError(e.getMessage(), ctx.typeAndId().ID().getSymbol());
        }

        // Making new scope for function body
        makeAndAttachNewScope(ctx);
    }

    @Override
    public void exitOneLineFunction(OneLineFunctionContext ctx) {
        closeScope();
    }

    /**
     * Iterates through all typeAndIds in a FuncDefParamsContext and returns a list of the types.
     *
     * @param ctx The node in question.
     * @return A list of types
     */
    private ArrayList<Integer> getFuncDefParamTypes(FuncDefParamsContext ctx) {
        ArrayList<Integer> argumentList = new ArrayList<>();
        if (ctx != null) {
            ctx.typeAndId().forEach(x -> argumentList.add(x.type().getStart().getType()));
        }
        return argumentList;
    }

    /**
     * Sets the current scope to be the enclosing scope of the current scope
     */
    private void closeScope() {
        currentScope = currentScope.getEnclosingScope();
    }

    /**
     * Creates a new scope, attatches the current scope to ctx and sets current scope to the new scope.
     *
     * @param ctx The node in question.
     */
    private void makeAndAttachNewScope(ParserRuleContext ctx) {
        Scope newScope = new BaseScope(currentScope);
        attachScope(ctx, newScope);
        currentScope = newScope;
    }

    @Override
    public void exitFuncDefParams(FuncDefParamsContext ctx) {
        List<TypeAndIdContext> params = ctx.getRuleContexts(TypeAndIdContext.class);
        for (TypeAndIdContext param : params)
            DefineParamSymbol(param);
    }

    public void DefineParamSymbol(TypeAndIdContext ctx) {
        Integer paramType = ctx.type().start.getType();
        Symbol paramSymbol = new Symbol(ctx.ID().getText(), paramType);
        try {
            currentScope.defineSymbol(paramSymbol);
        } catch (Exception e) {
            errorListener.ThrowError(e.getMessage(), ctx.ID().getSymbol());
        }

        attachScope(ctx, currentScope);
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
     *
     * @param ctx The node which should have a reference to a scope
     * @param s   The scope which should be added to a node.
     */
    void attachScope(ParserRuleContext ctx, Scope s) {
        scopes.put(ctx, s);
    }
}
