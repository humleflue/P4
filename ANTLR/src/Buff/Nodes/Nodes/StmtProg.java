package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.*;

public class StmtProg extends Prog {
    public StmtProg(Node stmt, Node prog) {
        Stmt = stmt;
        Prog = prog;
    }

    public String NodeType = "StmtProg";
    public Node Stmt;
    public Node Prog;
}
