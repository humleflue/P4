package B.Nodes.Nodes;

import B.Nodes.Abstract.Node;

public class FuncDefParam implements Node {
    public FuncDefParam(Node type, String identifier) {
        Type = type;
        Identifier = identifier;
    }

    public Node Type;
    public String Identifier;
}
