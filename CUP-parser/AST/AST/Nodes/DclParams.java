package AST.Nodes;
import AST.Master.Node;


public class DclParams implements Node {
    public DclParams(AST.Nodes.DclParam dclParam, AST.Nodes.DclMoreParams dclMoreParams) {
        DclParam = dclParam;
        DclMoreParams = dclMoreParams;
    }

    public String NodeType ="DclParams";
    public DclParam DclParam;
    public DclMoreParams DclMoreParams;


}
