package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.Node;

public class ExprMoreParams extends StmtParams{
    public ExprMoreParams(Node stmt, Node stmtMoreParams) {
        super(stmt, stmtMoreParams);
    }

    public String NodeType = "StmtMoreParams";
}
