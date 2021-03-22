package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.BinaryNode;
import Buff.Nodes.Abstract.Node;

public class LogGreaterOrEqual extends BinaryNode {
    public LogGreaterOrEqual(Node left, Node right) {
        super(left, right);
    }

    public String NodeType = "LogGreaterOrEqual";
}
