package B.Nodes.Nodes;

import B.Nodes.Abstract.Node;

public class ExprParams implements Node {
    public ExprParams(Node expr, Node exprMoreParams) {
        Expr = expr;
        ExprMoreParams = exprMoreParams;
    }

    public String NodeType = "ExprParams";
    public Node Expr;
    public Node ExprMoreParams;
}
