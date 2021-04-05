package B.Nodes.Nodes;

import B.Nodes.Abstract.*;

public class CodeFuncDef implements Node {
    public CodeFuncDef(Node funcDef, Node code) {
        FuncDef = funcDef;
        Code = code;
    }

    public Node FuncDef;
    public Node Code;
}
