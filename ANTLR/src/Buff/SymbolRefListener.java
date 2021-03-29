package Buff;

import Buff.SymbolTable.BaseScope;
import Buff.SymbolTable.Scope;
import Buff.SymbolTable.Symbol;
import Buff.SymbolTable.Type;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import javax.swing.*;

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
    public void exitOneLineStmt(Buff_1_1Parser.OneLineStmtContext ctx) {
        CheckSymbolType(ctx.ID().getSymbol().getText(), ctx.start.getType());

        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterMultiLineStmt(Buff_1_1Parser.MultiLineStmtContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitMultiLineStmt(Buff_1_1Parser.MultiLineStmtContext ctx) {
        CheckSymbolType(ctx.ID().getSymbol().getText(), ctx.start.getType());

        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterDclParam(Buff_1_1Parser.DclParamContext ctx) {
        CheckSymbolType(ctx.ID().getSymbol().getText(), ctx.start.getType());
    }

    @Override
    public void exitTermVal(Buff_1_1Parser.TermValContext ctx) {
        if (ctx.ID() != null){
            System.out.println("TermVal: " + ctx.ID().toString());
            CheckSymbolType(ctx.ID().getSymbol().getText(), ctx.start.getType());
        }
    }

    @Override
    public void exitFuncCall(Buff_1_1Parser.FuncCallContext ctx) {
        CheckSymbolType(ctx.ID().getSymbol().getText(), ctx.start.getType());
    }

    void CheckSymbolType(String name, int typeVal) throws IllegalArgumentException {
        Symbol symbol = currentScope.getSymbol(name);
        if ( symbol==null ) {
            throw new IllegalArgumentException(name + " is not defined");
        }
    }

}

