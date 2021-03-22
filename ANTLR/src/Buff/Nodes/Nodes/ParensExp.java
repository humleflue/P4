package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.Node;

public class ParensExp implements Node {
    public ParensExp(Node exp) {
        Exp = exp;
    }

    public String NodeType = "ParensExp";
    public Node Exp;
}
