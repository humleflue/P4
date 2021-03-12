package AST.Nodes;

import AST.Abstract.*;

public class PowerMath extends Form {
    public PowerMath(AST.Abstract.Factor factor, AST.Abstract.Form form) {
        Factor = factor;
        Form = form;
    }

    public String NodeType = "PowerMath";
    public Factor Factor;
    public Form Form;
}
