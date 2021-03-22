package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.Node;

public class Negate implements Node {
    public Negate(Node val) {
        Val = val;
    }

    public String NodeType = "Negate";
    public Node Val;
}
