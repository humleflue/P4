package AST.Nodes;

import AST.Abstract.*;

public class MinusMath extends MathExp {
    public MinusMath(AST.Abstract.Term term, MathExp math) {
        Term = term;
        Math = math;
    }

    public String NodeType = "MinusMath";
    public Term Term;
    public MathExp Math;
}
