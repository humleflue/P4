package AST.Nodes;

import AST.Abstract.*;

public class MultiplyMath extends Term {
    public MultiplyMath(AST.Abstract.Form form, AST.Abstract.Term term) {
        Form = form;
        Term = term;
    }

    public String NodeType = "MultiplyMath";
    public Form Form;
    public Term Term;
}
