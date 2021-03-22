package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.Node;

public class DclParams implements Node {
    public DclParams(Node dclParam, Node dclMoreParams) {
        DclParam = dclParam;
        DclMoreParams = dclMoreParams;
    }

    public String NodeType = "DclParams";
    public Node DclParam;
    public Node DclMoreParams;
}
