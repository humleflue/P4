package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.Node;

public class FuncCall implements Node {
    public FuncCall(String identifer, Node stmtParams) {
        Identifer = identifer;
        StmtParams = stmtParams;
    }

    public String NodeType = "FuncCall";
    public String Identifer;
    public Node StmtParams;
}
