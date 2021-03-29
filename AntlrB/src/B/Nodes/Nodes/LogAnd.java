package B.Nodes.Nodes;

import B.Nodes.Abstract.BinaryNode;
import B.Nodes.Abstract.Node;

public class LogAnd extends BinaryNode {
    public LogAnd(Node left, Node right) {
        super(left, right);
    }

    public String NodeType = "LogAnd";
}
