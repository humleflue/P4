import B.BLexer;
import B.BParser;
import B.BuildASTVisitor;
import B.Nodes.Abstract.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.StringReader;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Please enter a source program:");
        String test = System.console().readLine();
        CodePointCharStream stream = CharStreams.fromReader(new StringReader(test));
        BLexer lexer = new BLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BParser parser = new BParser(tokens);
        try{
            ParseTree tree = parser.code();
            System.out.println("building cst");
            Node ast = new BuildASTVisitor().visit(tree);
            System.out.println("building ast");
            System.out.println("done building ast");
        }
        catch (Exception exception){
            System.out.println("shit" + exception.getMessage());
        }
    }
}
