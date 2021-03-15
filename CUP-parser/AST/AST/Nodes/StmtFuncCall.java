package AST.Nodes;

import AST.Abstract.Stmt;

public class StmtFuncCall extends Stmt {
    public StmtFuncCall(FuncCall funcCall) {
        FuncCall = funcCall;
    }

    public String NodeType = "StmtFuncCall";
    public FuncCall FuncCall;
}
