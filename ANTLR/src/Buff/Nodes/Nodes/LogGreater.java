package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.BinaryNode;
import Buff.Nodes.Abstract.Node;

public class LogGreater extends BinaryNode {
    public LogGreater(Node left, Node right) {
        super(left, right);
    }

    public String NodeType = "LogGreater";
}
