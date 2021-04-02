package B.Nodes.Nodes;

import B.Nodes.Abstract.*;

public class CodeStmt implements Node {
    public CodeStmt(Node stmt, Node code) {
        Stmt = stmt;
        Code = code;
    }

    public Node Stmt;
    public Node Code;
}
