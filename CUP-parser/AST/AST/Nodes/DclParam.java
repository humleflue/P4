package AST.Nodes;

import AST.Master.Node;

public class DclParam implements Node {
    public DclParam(AST.Nodes.Type type, Identifier id) {
        Type = type;
        Id = id;
    }

    public String NodeType ="DclParam";
    public Type Type;
    public Identifier Id;
}
