package B.Nodes.Nodes;

import B.Nodes.Abstract.Node;

public class ParensExp implements Node {
    public ParensExp(Node exp) {
        Exp = exp;
    }

    public String NodeType = "ParensExp";
    public Node Exp;
}
