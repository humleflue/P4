package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.BinaryNode;
import Buff.Nodes.Abstract.Node;

public class LogOr extends BinaryNode {
    public LogOr(Node left, Node right) {
        super(left, right);
    }

    public String NodeType = "LogOr";
}
