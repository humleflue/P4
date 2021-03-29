package B.Nodes.Nodes;

import B.Nodes.Abstract.BinaryNode;
import B.Nodes.Abstract.Node;

public class LogOr extends BinaryNode {
    public LogOr(Node left, Node right) {
        super(left, right);
    }

    public String NodeType = "LogOr";
}
