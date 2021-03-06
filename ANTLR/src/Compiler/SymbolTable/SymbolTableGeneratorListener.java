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

    /**
     * Creates a FuncdefSymbol from the functions return type, name and parameters.
     * Defines the FuncdefSymbol in the current scope, and makes a new scope.
     *
     * @param ctx The MultiLineFunction's tree node
     */
    @Override
    public void enterMultiLineFunction(MultiLineFunctionContext ctx) {
        defineFunctionDefinitionSymbol(ctx.typeAndId(), ctx.funcDefParams());
        // Making new scope for function body
        makeAndAttachNewScope(ctx);
    }

    @Override
    public void exitMultiLineFunction(MultiLineFunctionContext ctx) {
        closeScope();
    }

    /**
     * Creates a FuncdefSymbol from the functions return type, name and parameters.
     * Defines the FuncdefSymbol in the current scope, and makes a new scope.
     *
     * @param ctx The OneLineFunctionContext tree node
     */
    @Override
    public void enterOneLineFunction(OneLineFunctionContext ctx) {
        defineFunctionDefinitionSymbol(ctx.typeAndId(), ctx.funcDefParams());
        // Making new scope for function body
        makeAndAttachNewScope(ctx);
    }

    /**
     * Might throw! Auxiliary function, which defines the function definition as a new symbol in the symbol table.
     * Throws an error, if the ID has already been defined as a symbol in the symbol table.
     *
     * @param typeAndIdCtx The function definition's type and id tree node.
     * @param funcDefParamsCtx The function definition's parameter(s) tree node.
     */
    private void defineFunctionDefinitionSymbol(TypeAndIdContext typeAndIdCtx, FuncDefParamsContext funcDefParamsCtx) {
        // Gets lists of parameters and converts them into a list of types
        ArrayList<Integer> argumentList = getFuncDefParamTypes(funcDefParamsCtx);
        FuncdefSymbol symbol = new FuncdefSymbol(typeAndIdCtx.ID().getText(), typeAndIdCtx.type().start.getType(), argumentList);
        try {
            currentScope.defineSymbol(symbol);
        } catch (Exception e) {
            errorListener.ThrowError(e.getMessage(), typeAndIdCtx.ID().getSymbol());
        }
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
     * Scopes attatched to ID and Funccall for easy access in type checking using scopes.get(ctx)
     * @param ctx The ExprId's tree node
     */
    @Override
    public void exitExprId(ExprIdContext ctx) {
        attachScope(ctx, currentScope);
    }

    /**
     * Scopes attatched to ID and Funccall for easy access in type checking using scopes.get(ctx)
     * @param ctx The FuncCall's tree node
     */
    @Override
    public void exitFuncCall(FuncCallContext ctx) {
        attachScope(ctx, currentScope);
    }

    /**
     * Iterates through all parameters in a function definition,
     * and defines them all in the current scope.
     *
     * @param ctx The FuncDefParams' tree node.
     */
    @Override
    public void exitFuncDefParams(FuncDefParamsContext ctx) {
        List<TypeAndIdContext> params = ctx.typeAndId();
        for (TypeAndIdContext param : params)
            defineParamSymbol(param);
    }

    /**
     * Creates a Symbol object from a TypeAndIdContext, and defines it in the current scope.
     *
     * @param ctx A TypeAndId's tree node.
     */
    public void defineParamSymbol(TypeAndIdContext ctx) {
        Integer paramType = ctx.type().start.getType();
        Symbol paramSymbol = new Symbol(ctx.ID().getText(), paramType);
        try {
            currentScope.defineSymbol(paramSymbol);
        } catch (Exception e) {
            errorListener.ThrowError(e.getMessage(), ctx.ID().getSymbol());
        }

        attachScope(ctx, currentScope);
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

    /**
     * Adds a scope as a ParseTreeProperty to a node
     *
     * @param ctx The node which should have a reference to a scope
     * @param s   The scope which should be added to a node.
     */
    private void attachScope(ParserRuleContext ctx, Scope s) {
        scopes.put(ctx, s);
    }
}
