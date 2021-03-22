package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.BinaryNode;
import Buff.Nodes.Abstract.Node;

public class LogEquals extends BinaryNode {
    public LogEquals(Node left, Node right) {
        super(left, right);
    }

    public String NodeType = "LogEquals";
}
