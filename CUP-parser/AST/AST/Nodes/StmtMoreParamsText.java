package AST.Nodes;

import AST.Abstract.*;

public class StmtMoreParamsText extends StmtMoreParams {
    public StmtMoreParamsText(AST.Abstract.StmtMoreParams stmtMoreParams, String textValue) {
        StmtMoreParams = stmtMoreParams;
        TextValue = textValue;
    }

    public String NodeType ="StmtMoreParamsText";
    public StmtMoreParams StmtMoreParams;
    public String TextValue;
}
