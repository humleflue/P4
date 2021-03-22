package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.BinaryNode;
import Buff.Nodes.Abstract.Node;

public class LogLess extends BinaryNode {
    public LogLess(Node left, Node right) {
        super(left, right);
    }

    public String NodeType = "LogLess";
}
