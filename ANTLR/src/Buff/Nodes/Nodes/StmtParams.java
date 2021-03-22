package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.Node;

public class StmtParams implements Node {
    public StmtParams(Node stmt, Node stmtMoreParams) {
        Stmt = stmt;
        StmtMoreParams = stmtMoreParams;
    }

    public String NodeType = "StmtParams";
    public Node Stmt;
    public Node StmtMoreParams;
}
