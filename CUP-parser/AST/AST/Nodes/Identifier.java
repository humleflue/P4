package AST.Nodes;

import AST.Abstract.Terminal;
import AST.Abstract.Val;

public class Identifier extends Terminal {
    public Identifier(String spelling, Val value) {
        Spelling = spelling;
        Value = value;
    }

    public String Spelling;
    public Val Value;
}
