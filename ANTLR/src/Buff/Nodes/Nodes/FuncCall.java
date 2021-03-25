package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.Node;

public class FuncCall implements Node{
    public FuncCall(String identifier, Node stmtParams, boolean withDebug) {
        StmtParams = stmtParams;
        Identifer = identifier;
        WithDebug = withDebug;
    }
    public FuncCall(String identifier, Node stmtParams) {
        StmtParams = stmtParams;
        Identifer = identifier;
    }

    public String NodeType = "FuncCall";
    public String Identifer;
    public Node StmtParams;
    public boolean WithDebug = false;

}
