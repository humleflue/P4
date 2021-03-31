package Compiler.SymbolTable;

import Compiler.Lang.LangBaseListener;
import Compiler.Lang.LangParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.List;

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
        //Gets lists of parameters as ParseRuleContexts
        List<LangParser.FuncdefparamContext> params =  ctx.getRuleContext(LangParser.FuncdefparamsContext.class, 0)
                .getRuleContexts(LangParser.FuncdefparamContext.class);

        List<Type> argumentList = new ArrayList<Type>() ;
        for (LangParser.FuncdefparamContext param : params){
            argumentList.add(new BaseType(param.start.getType()));
        }

        Type type = new FunctionType(ctx.start.getType(), argumentList);
        currentScope.defineSymbol(new Symbol(ctx.ID().getText(), type));

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
