package AST.Nodes;

import AST.Abstract.Stmt;
import AST.Master.Node;

public class Stmts implements Node {
    public Stmts(Stmt statement, Stmts statements) {
        Statement = statement;
        Statements = statements;
    }

    public String NodeType = "Stmts";
    public Stmt Statement;
    public Stmts Statements;
}
