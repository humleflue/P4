package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.*;

public class OneLineStmt extends Dcl {
    public OneLineStmt(Node type, Node dclParams, Node stmt, String identifier) {
        Type = type;
        DclParams = dclParams;
        Stmt = stmt;
        Identifier = identifier;
    }

    public String NodeType = "OneLineStmt";
    public Node Type;
    public Node DclParams;
    public Node Stmt;
    public String Identifier;
}
