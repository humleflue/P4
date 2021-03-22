package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.BinaryNode;
import Buff.Nodes.Abstract.Node;

public class Plus extends BinaryNode {
    public Plus(Node left, Node right) {
        super(left, right);
    }
    public String NodeType = "Plus";

}
