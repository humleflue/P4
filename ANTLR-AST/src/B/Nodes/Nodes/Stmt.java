package B.Nodes.Nodes;

import B.Nodes.Abstract.Node;

public class Stmt implements Node {
    public Stmt(Node expr) {
        Expr = expr;
    }

    public Node Expr;
}
