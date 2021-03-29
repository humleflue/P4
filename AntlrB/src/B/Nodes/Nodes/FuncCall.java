package B.Nodes.Nodes;

import B.Nodes.Abstract.Node;

public class FuncCall implements Node{
    public FuncCall(String identifier, Node exprParams, boolean withDebug) {
        ExprParams = exprParams;
        Identifer = identifier;
        WithDebug = withDebug;
    }
    public FuncCall(String identifier, Node exprParams) {
        ExprParams = exprParams;
        Identifer = identifier;
    }

    public String NodeType = "FuncCall";
    public String Identifer;
    public Node ExprParams;
    public boolean WithDebug = false;

}
