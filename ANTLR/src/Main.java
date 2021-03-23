import Buff.Buff_1_1Lexer;
import Buff.Buff_1_1Parser;
import Buff.BuildASTVisitor;
import Buff.Nodes.Abstract.*;
import Buff.Nodes.Nodes.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.StringReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String test = System.console().readLine();
        CodePointCharStream stream = CharStreams.fromReader(new StringReader(test));
        Buff_1_1Lexer lexer = new Buff_1_1Lexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Buff_1_1Parser parser = new Buff_1_1Parser(tokens);
        try{
            ParseTree tree = parser.prog();
            System.out.println("building cst");
            Node ast = new BuildASTVisitor().visit(tree);
            System.out.println("building ast");
        }
        catch (Exception exception){
            System.out.println("shit" + exception.getMessage());
        }
    }
}
