package Compiler.SymbolTable;

import Compiler.AntlrGenerated.LangBaseListener;
import Compiler.AntlrGenerated.LangParser.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.List;

public class SymbolDefListener extends LangBaseListener{
    public ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    public BaseScope globalScope = new BaseScope();
    Scope currentScope;

    @Override
    public void enterProg(ProgContext ctx) {
        currentScope = globalScope;
    }

    @Override
    public void enterFuncdef(FuncdefContext ctx) {
        //Gets lists of parameters as ParseRuleContexts
        List<FuncdefparamContext> params =  ctx.getRuleContext(FuncdefparamsContext.class, 0)
                .getRuleContexts(FuncdefparamContext.class);

        //Might be usefull for type-checking. Delete otherwise
        List<Type> argumentList = new ArrayList<Type>();
        for (FuncdefparamContext param : params){
            argumentList.add(new BaseType(param.start.getType()));
        }

        Type type = new FunctionType(ctx.start.getType(), argumentList);
        currentScope.defineSymbol(new Symbol(ctx.ID().getText(), type));

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
        Type paramType = new BaseType(ctx.start.getType());
        Symbol paramSymbol = new Symbol(ctx.ID().getText(), paramType);
        currentScope.defineSymbol(paramSymbol);
    }

    void attachScope(ParserRuleContext ctx, Scope s) { scopes.put(ctx, s); }
}
