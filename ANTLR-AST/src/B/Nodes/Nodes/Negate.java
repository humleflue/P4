package B.Nodes.Nodes;

import B.Nodes.Abstract.Node;

public class Negate implements Node {
    public Negate(Node val) {
        Val = val;
    }

    public Node Val;
}
