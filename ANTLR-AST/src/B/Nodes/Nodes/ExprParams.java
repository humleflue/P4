package B.Nodes.Nodes;

import B.Nodes.Abstract.Node;

public class ExprParams implements Node {
    public ExprParams(Node expr, Node exprMoreParams) {
        Expr = expr;
        ExprMoreParams = exprMoreParams;
    }

    public Node Expr;
    public Node ExprMoreParams;
}
