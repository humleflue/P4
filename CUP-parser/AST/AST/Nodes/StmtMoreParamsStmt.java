package AST.Nodes;

import AST.Abstract.*;

public class StmtMoreParamsStmt extends AST.Abstract.StmtMoreParams {
    public StmtMoreParamsStmt(AST.Abstract.StmtMoreParams stmtMoreParams, AST.Abstract.Stmt stmt) {
        StmtMoreParams = stmtMoreParams;
        Stmt = stmt;
    }

    public String NodeType = "StmtMoreParamsStmt";
    public StmtMoreParams StmtMoreParams;
    public Stmt Stmt;
}
