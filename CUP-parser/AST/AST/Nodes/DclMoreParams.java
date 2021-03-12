package AST.Nodes;

import AST.Master.Node;

public class DclMoreParams implements Node {
    public DclMoreParams(AST.Nodes.DclParam dclParam, AST.Nodes.DclMoreParams dclMoreParams) {
        DclParam = dclParam;
        DclMoreParams = dclMoreParams;
    }

    public String NodeType = "DclMoreParams";
    public DclParam DclParam;
    public DclMoreParams DclMoreParams;
}
