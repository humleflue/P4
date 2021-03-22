package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.BinaryNode;
import Buff.Nodes.Abstract.Node;

public class Minus extends BinaryNode {
    public Minus(Node left, Node right) {
        super(left, right);
    }

    public String NodeType = "Minus";
}
