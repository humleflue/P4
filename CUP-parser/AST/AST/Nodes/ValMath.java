package AST.Nodes;

import AST.Abstract.*;

public class ValMath extends Val {
    public ValMath(MathExp math) {
        Math = math;
    }

    public String NodeType = "ValMath";
    public MathExp Math;
}
