package Compiler.SymbolTable;

import Compiler.SymbolTable.*;
import Compiler.Lang.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class SymbolDefListener extends LangBaseListener{
    public ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    public BaseScope globalScope = new BaseScope();
    Scope currentScope;

    @Override
    public void enterProg(LangParser.ProgContext ctx) {
        currentScope = globalScope;
    }

    @Override
    public void enterFuncdef(LangParser.FuncdefContext ctx) {
        currentScope.defineSymbol(new Symbol(ctx.ID().getText(), new BaseType(ctx.start.getType())));
        Scope newScope = new BaseScope(currentScope);
        saveScope(ctx, newScope);
        currentScope = newScope;
    }

    @Override
    public void exitFuncdef(LangParser.FuncdefContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void exitFuncdefparam(LangParser.FuncdefparamContext ctx) {
        Type paramType = new BaseType(ctx.start.getType());
        Symbol paramSymbol = new Symbol(ctx.ID().getText(), paramType);
        currentScope.defineSymbol(paramSymbol);
    }

    void saveScope(ParserRuleContext ctx, Scope s) { scopes.put(ctx, s); }
}
