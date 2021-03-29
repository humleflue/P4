package B.Nodes.Nodes;

import B.Nodes.Abstract.BinaryNode;
import B.Nodes.Abstract.Node;

public class LogEquals extends BinaryNode {
    public LogEquals(Node left, Node right) {
        super(left, right);
    }

    public String NodeType = "LogEquals";
}
