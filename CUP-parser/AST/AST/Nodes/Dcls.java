package AST.Nodes;

import AST.Master.Node;

public class Dcls implements Node {
    public Dcls(AST.Nodes.Dcl dcl, AST.Nodes.Dcls dcls) {
        Dcl = dcl;
        Dcls = dcls;
    }

    String NodeType = "Dcls";
    Dcl Dcl;
    Dcls Dcls;
}
