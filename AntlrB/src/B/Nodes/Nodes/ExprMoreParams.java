package B.Nodes.Nodes;

import B.Nodes.Abstract.Node;

public class ExprMoreParams extends ExprParams {
    public ExprMoreParams(Node stmt, Node stmtMoreParams) {
        super(stmt, stmtMoreParams);
    }

    public String NodeType = "StmtMoreParams";
}
