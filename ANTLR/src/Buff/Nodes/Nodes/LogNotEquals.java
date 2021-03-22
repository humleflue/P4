package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.BinaryNode;
import Buff.Nodes.Abstract.Node;

public class LogNotEquals extends BinaryNode {
    public LogNotEquals(Node left, Node right) {
        super(left, right);
    }

    public String NodeType = "LogNotEquals";
}
