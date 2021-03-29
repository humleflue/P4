package B.Nodes.Nodes;

import B.Nodes.Abstract.Node;

public class FuncDefParams implements Node {
    public FuncDefParams(Node funcDefParam, Node funcDefMoreParams) {
        FuncDefParam = funcDefParam;
        FuncDefMoreParams = funcDefMoreParams;
    }

    public String NodeType = "FuncDefParams";
    public Node FuncDefParam;
    public Node FuncDefMoreParams;
}
