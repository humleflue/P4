package B.Nodes.Nodes;

import B.Nodes.Abstract.*;

public class CodeStmt extends Code {
    public CodeStmt(Node stmt, Node code) {
        Stmt = stmt;
        Code = code;
    }

    public String NodeType = "StmtCode";
    public Node Stmt;
    public Node Code;
}
