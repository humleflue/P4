package mypackage;

import mypackage.ASTNodes.Abstract.Node;

public class BuildASTVisitor extends BuffBaseVisitor<Node>{
    @Override public Node visitProg(BuffParser.ProgContext ctx){
        ctx.dcls();
        ctx.stmts()
    }
}




