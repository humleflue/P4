package B.Nodes.Nodes;

import B.Nodes.Abstract.*;

public class FuncDef implements Node{
    public FuncDef(Node type, String identifier, Node funcDefParams, Node stmts, Node stmt) {
        Type = type;
        FuncDefParams = funcDefParams;
        Stmt = stmt;
        Identifier = identifier;
        Stmts = stmts;
    }

    public Node Type;
    public Node FuncDefParams;
    public Node Stmt;
    public Node Stmts;
    public String Identifier;
}
