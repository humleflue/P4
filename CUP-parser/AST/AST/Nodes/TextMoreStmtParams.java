package AST.Nodes;

import AST.Abstract.*;

public class TextMoreStmtParams extends StmtParams {
    public TextMoreStmtParams(String textValue, AST.Abstract.StmtMoreParams stmtMoreParams) {
        TextValue = textValue;
        StmtMoreParams = stmtMoreParams;
    }

    public String NodeType = "TextMoreStmtParams";
    public String TextValue;
    public StmtMoreParams StmtMoreParams;
}
