package Compiler;

import Compiler.Lang.*;
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
        LangLexer lexer = new LangLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);
        try{
            ParseTree tree = parser.code();
            System.out.println("building cst");
            System.out.println("done building cst");
        }
        catch (Exception exception){
            System.out.println("shit" + exception.getMessage());
        }
    }
}
