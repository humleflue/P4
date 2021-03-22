package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.BinaryNode;
import Buff.Nodes.Abstract.Node;

public class Divide extends BinaryNode {
    public Divide(Node left, Node right) {
        super(left, right);
    }

    public String NodeType = "Divide";
}
