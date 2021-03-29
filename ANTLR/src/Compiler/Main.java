package Compiler;

import Compiler.Lang.LangLexer;
import Compiler.Lang.LangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.StringReader;

public class Main {

    public static void main(String[] args) {
        try {
            String input = "number plus(number x, number y) = return x + y; endf\nplus(1,2)?;";
            System.out.println("Testing with program:\n```\n" + input + "\n```");
            CodePointCharStream stream = CharStreams.fromReader(new StringReader(input));
            LangLexer lexer = new LangLexer(stream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LangParser parser = new LangParser(tokens);
            System.out.println("Building CST...");
            ParseTree tree = parser.code();
            System.out.println("Done building CST.");
        }
        catch (Exception exception){
            System.out.println(exception.getStackTrace());
        }
    }
}
