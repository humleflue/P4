package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.*;

public class MultiLineStmt extends OneLineStmt{
    public MultiLineStmt(Node type, Node dclParams, Node stmt, String identifier, Node stmts) {
        super(type, dclParams, stmt, identifier);
        Stmts = stmts;
    }


    public String NodeType = "MultiLineStmt";
    public Node Stmts;

}
