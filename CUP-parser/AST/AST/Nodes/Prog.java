package AST.Nodes;
import AST.Master.Node;


public class Prog implements Node {
    public Prog(Dcls dcls, Stmts stmts) {
        Dcls = dcls;
        Stmts = stmts;
    }

    String NodeType = "Prog";
    public Dcls Dcls;
    public Stmts Stmts;
}