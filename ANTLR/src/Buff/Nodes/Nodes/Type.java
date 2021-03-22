package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.Node;

public class Type implements Node {
    public Type(String spelling) {
        Spelling = spelling;
    }

    public String NodeType = "Type";
    public String Spelling;
}
