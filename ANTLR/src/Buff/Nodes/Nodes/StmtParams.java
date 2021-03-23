package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.Node;

public class StmtParams implements Node {
    public StmtParams(Node expr, Node exprMoreParams) {
        Expr = expr;
        ExprMoreParams = exprMoreParams;
    }

    public String NodeType = "StmtParams";
    public Node Expr;
    public Node ExprMoreParams;
}
