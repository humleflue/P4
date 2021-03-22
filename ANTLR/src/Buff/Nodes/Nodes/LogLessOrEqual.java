package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.BinaryNode;
import Buff.Nodes.Abstract.Node;

public class LogLessOrEqual extends BinaryNode {
    public LogLessOrEqual(Node left, Node right) {
        super(left, right);
    }

    public String NodeType = "LogOr";
}
