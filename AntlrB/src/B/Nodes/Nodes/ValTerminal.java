package B.Nodes.Nodes;

import B.Nodes.Abstract.Node;

public class ValTerminal implements Node {
    public ValTerminal(String spelling) {
        Spelling = spelling;
    }

    public String NodeType = "ValTerminal";
    public String Spelling;
}
