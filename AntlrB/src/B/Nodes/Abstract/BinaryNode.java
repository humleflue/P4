package B.Nodes.Abstract;

public class BinaryNode implements Node{
    public BinaryNode(Node left, Node right) {
        Left = left;
        Right = right;
    }
    public String NodeType = "BinaryNode";
    public Node Left;
    public Node Right;
}
