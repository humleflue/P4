package AST.Nodes;

import AST.Master.Node;
import AST.Abstract.*;

public class Dcl implements Node {
    public Dcl(Identifier id, AST.Nodes.Type type, DclParams params, Stmt statement) {
        Id = id;
        Type = type;
        Params = params;
        Statement = statement;
    }

    public String NodeType = "Dcl";
    public Identifier Id;
    public Type Type;
    public DclParams Params;
    public Stmt Statement;
}
