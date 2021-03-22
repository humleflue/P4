package Buff.Nodes.Nodes;


import Buff.Nodes.Abstract.Node;

public class Stmts extends Stmt {
    public Stmts(Node expr, Node stmt, Node stmts) {
        super(expr);
        Stmt = stmt;
        Stmts = stmts;
    }

    public String NodeType = "Stmts";
    public Node Stmt;
    public Node Stmts;
}
