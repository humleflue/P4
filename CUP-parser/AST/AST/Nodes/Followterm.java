package AST.Nodes;

import AST.Master.Node;

public class Followterm implements Node {
    public Followterm(Simpleops simpleops, Math math) {
        Simpleops = simpleops;
        this.Math = math;
    }

    public String NodeType = "Followterm";
    public Simpleops Simpleops;
    public Math Math;
}
