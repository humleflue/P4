package B.Nodes.Nodes;

import B.Nodes.Abstract.*;

public class CodeFuncDef extends Code {
    public CodeFuncDef(Node funcDef, Node code) {
        FuncDef = funcDef;
        Code = code;
    }

    public String NodeType = "CodeFuncDef";
    public Node FuncDef;
    public Node Code;
}
