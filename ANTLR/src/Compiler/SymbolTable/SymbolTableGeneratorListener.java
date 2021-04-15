package Compiler.SymbolTable;

import Compiler.AntlrGenerated.LangBaseListener;
import Compiler.AntlrGenerated.LangParser.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.List;

public class SymbolTableGeneratorListener extends LangBaseListener{
    public ParseTreeProperty<Scope> scopes = new ParseTreeProperty<>();
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
        ArrayList<Integer> argumentList = new ArrayList<>();
        for (FuncdefparamContext param : params){
            argumentList.add(param.start.getType());
        }

        FuncdefSymbol symbol = new FuncdefSymbol(ctx.ID().getText(), ctx.start.getType(), argumentList);
        currentScope.defineSymbol(symbol);
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
        currentScope.defineSymbol(paramSymbol);
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

    void attachScope(ParserRuleContext ctx, Scope s) { scopes.put(ctx, s); }
}
