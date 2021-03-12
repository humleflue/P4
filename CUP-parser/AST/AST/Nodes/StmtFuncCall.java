package AST.Nodes;

import AST.Abstract.Stmt;

public class StmtFuncCall extends Stmt {
    public StmtFuncCall(FuncCall funcCall) {
        FuncCall = funcCall;
    }

    public String Nodetype = "StmtFuncCall";
    public FuncCall FuncCall;
}
