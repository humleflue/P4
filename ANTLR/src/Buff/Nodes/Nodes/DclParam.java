package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.Node;

public class DclParam implements Node {
    public DclParam(Node type, String identifier) {
        Type = type;
        Identifier = identifier;
    }

    public String NodeType = "DclParam";
    public Node Type;
    public String Identifier;
}
