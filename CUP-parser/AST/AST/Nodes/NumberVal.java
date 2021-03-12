package AST.Nodes;

import AST.Abstract.Terminal;

public class NumberVal extends Terminal {
    public NumberVal(String spelling) {
        Spelling = spelling;
    }

    public String NodeType = "NumberVal";
    public String Spelling;
}
