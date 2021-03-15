package AST.Abstract;

import AST.Master.Node;

public abstract class BinaryOp implements Node{
    public BinaryOp(Node left, Node right, String operator) {
        Left = left;
        Right = right;
        Operator = operator;
    }

    public String NodeType;
    public Node Left;
    public Node Right;
    public String Operator;
}
