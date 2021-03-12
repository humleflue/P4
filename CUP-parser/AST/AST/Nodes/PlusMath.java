package AST.Nodes;

import AST.Abstract.*;

public class PlusMath extends MathExp {
    public PlusMath(AST.Abstract.Term term, MathExp math) {
        Term = term;
        Math = math;
    }

    public String NodeType = "PlusMath";
    public Term Term;
    public MathExp Math;
}
