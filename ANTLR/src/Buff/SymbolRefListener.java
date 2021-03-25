package Buff;

import Buff.SymbolTable.BaseScope;
import Buff.SymbolTable.Scope;
import Buff.SymbolTable.Symbol;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class SymbolRefListener extends Buff_1_1BaseListener{
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    BaseScope globalScope;
    Scope currentScope;

    public SymbolRefListener(BaseScope globalScope, ParseTreeProperty<Scope> scopes) {
        this.scopes = scopes;
        this.globalScope = globalScope;
    }

    @Override
    public void enterStart(Buff_1_1Parser.StartContext ctx) {
        currentScope = globalScope;
    }

    @Override
    public void enterOneLineStmt(Buff_1_1Parser.OneLineStmtContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitOneLineStmt(Buff_1_1Parser.OneLineStmtContext ctx) throws IllegalArgumentException {
        String name = ctx.ID().getSymbol().getText();
        Symbol symbol = currentScope.getSymbol(name);
        if ( symbol==null ) {
            throw new IllegalArgumentException(name + " is not defined");
        }
        if ( symbol.getType().getVal() != ctx.start.getType()) {
            throw new IllegalArgumentException(name + " is called as a wrong type");
        }

        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterMultiLineStmt(Buff_1_1Parser.MultiLineStmtContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitMultiLineStmt(Buff_1_1Parser.MultiLineStmtContext ctx) {
        String name = ctx.ID().getSymbol().getText();
        Symbol symbol = currentScope.getSymbol(name);
        if ( symbol==null ) {
            throw new IllegalArgumentException(name + " is not defined");
        }
        if ( symbol.getType().getVal() != ctx.start.getType()) {
            throw new IllegalArgumentException(name + " is called as a wrong type"); // Svært at teste da vi kun har en type.
        }

        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterDclParam(Buff_1_1Parser.DclParamContext ctx) {
        String name = ctx.ID().getSymbol().getText();
        Symbol symbol = currentScope.getSymbol(name);
        if ( symbol==null ) {
            throw new IllegalArgumentException(name + " is not defined");
        }
        if ( symbol.getType().getVal() != ctx.start.getType()) {
            throw new IllegalArgumentException(name + " is called as a wrong type. " + symbol.getType().getVal());
        }
    }
}
