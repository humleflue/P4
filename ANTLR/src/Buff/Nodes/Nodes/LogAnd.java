package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.BinaryNode;
import Buff.Nodes.Abstract.Node;

public class LogAnd extends BinaryNode {
    public LogAnd(Node left, Node right) {
        super(left, right);
    }

    public String NodeType = "LogAnd";
}
