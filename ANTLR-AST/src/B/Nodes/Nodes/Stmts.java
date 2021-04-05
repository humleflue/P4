package B.Nodes.Nodes;


import B.Nodes.Abstract.Node;

public class Stmts extends Stmt {
    public Stmts(Node expr, Node stmt, Node stmts) {
        super(expr);
        Stmt = stmt;
        Stmts = stmts;
    }

    public Node Stmt;
    public Node Stmts;
}
