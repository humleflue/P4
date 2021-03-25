package Buff;

import Buff.SymbolTable.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class SymbolDefListener extends Buff_1_1BaseListener{
    public ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    public BaseScope globalScope = new BaseScope();
    Scope currentScope;

    @Override
    public void enterStart(Buff_1_1Parser.StartContext ctx) {
        currentScope = globalScope;
    }

    @Override
    public void enterOneLineStmt(Buff_1_1Parser.OneLineStmtContext ctx) {
        currentScope.defineSymbol(new Symbol(ctx.ID().toString(), new BaseType(ctx.start.getType())));
        Scope newScope = new BaseScope(currentScope);
        saveScope(ctx, newScope);
        currentScope = newScope;
    }

    @Override
    public void enterMultiLineStmt(Buff_1_1Parser.MultiLineStmtContext ctx) {
        currentScope.defineSymbol(new Symbol(ctx.ID().toString(), new BaseType(ctx.start.getType())));
        Scope newScope = new BaseScope(currentScope);
        saveScope(ctx, newScope);
        currentScope = newScope;
    }

    @Override
    public void exitMultiLineStmt(Buff_1_1Parser.MultiLineStmtContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void exitOneLineStmt(Buff_1_1Parser.OneLineStmtContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void exitDclParam(Buff_1_1Parser.DclParamContext ctx) {
        currentScope.defineSymbol(new Symbol(ctx.ID().toString(), new BaseType(ctx.start.getType())));
    }

    void saveScope(ParserRuleContext ctx, Scope s) { scopes.put(ctx, s); }
}
