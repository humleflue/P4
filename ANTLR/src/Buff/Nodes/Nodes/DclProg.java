package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.*;

public class DclProg extends Prog {
    public DclProg(Node dcl, Node prog) {
        Dcl = dcl;
        Prog = prog;
    }

    public String NodeType = "DclProg";
    public Node Dcl;
    public Node Prog;
}
