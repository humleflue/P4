package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.BinaryNode;
import Buff.Nodes.Abstract.Node;

public class Power extends BinaryNode {
    public Power(Node left, Node right) {
        super(left, right);
    }

    public String NodeType = "Power";
}
