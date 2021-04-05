package AST.Nodes;

import AST.Abstract.*;

public class Math extends Stmt {
    public Math(AST.Abstract.Term term, AST.Nodes.Followterm followterm) {
        this.Term = term;
        this.Followterm = followterm;
    }

    public String NodeType = "Math";
    public Term Term;
    public Followterm Followterm;
}
