package Buff.Nodes.Nodes;

import Buff.Nodes.Abstract.Node;

public class FunctionCallDebug extends FuncCall{
    public FunctionCallDebug(String identifer, Node stmtParams) {
        super(identifer, stmtParams);
    }

    String NodeType = "FunctionCallDebug";
}
