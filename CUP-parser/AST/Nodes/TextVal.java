package AST.Nodes;

import AST.Abstract.*;

public class TextVal extends Terminal {
    public TextVal(String spelling) {
        this.Spelling = spelling;
    }

    public String NodeType = "TextVal";
    public String Spelling;
}
