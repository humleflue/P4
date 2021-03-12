package AST.Nodes;

import AST.Abstract.*;

public class FuncCall extends Factor {
    public FuncCall(Identifier id, AST.Abstract.StmtParams stmtParams) {
        Id = id;
        StmtParams = stmtParams;
    }

    public String NodeType = "FuncCall";
    public Identifier Id;
    public StmtParams StmtParams;
}
