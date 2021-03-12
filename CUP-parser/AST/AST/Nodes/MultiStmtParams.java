package AST.Nodes;

import AST.Abstract.*;

public class MultiStmtParams extends StmtParams {
    public MultiStmtParams(AST.Abstract.StmtMoreParams stmtMoreParams, AST.Abstract.Stmt stmt) {
        StmtMoreParams = stmtMoreParams;
        Stmt = stmt;
    }

    public String NodeType = "MultiStmtParams";
    public StmtMoreParams StmtMoreParams;
    public Stmt Stmt;
}
