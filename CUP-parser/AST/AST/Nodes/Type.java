package AST.Nodes;

import AST.Master.Node;

enum ValType{
    number,
    text,
}
public class Type implements Node {
    public Type(ValType type) {
        this.type = type;
    }

    public String NodeType = "Type";
    public ValType type;
}
