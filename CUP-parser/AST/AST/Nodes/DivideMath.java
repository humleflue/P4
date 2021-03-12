package AST.Nodes;

import AST.Abstract.*;

public class DivideMath extends Term {
    public DivideMath(AST.Abstract.Form form, AST.Abstract.Term term) {
        Form = form;
        Term = term;
    }

    public String NodeType = "DivideMath";
    public Form Form;
    public Term Term;
}
