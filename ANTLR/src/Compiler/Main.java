package Compiler;

import Compiler.AntlrGenerated.LangLexer;
import Compiler.AntlrGenerated.LangParser;
import Compiler.ErrorHandling.UnderlineErrorListener;
import Compiler.SymbolTable.SymbolDefListener;
import Compiler.SymbolTable.SymbolRefListener;
import Compiler.TypeChecker.TypeCheckerVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Arrays;

public class Main {

    public static void main(String[] args)  {
        String input = "number plus(number x, number y) = if (false) return 2; return 3; endf\n" +
                "number mult(number x, number y) = \n return x * y; endf\n" +
                "plus(2, 3);\n" +
                "bool returnsBool() = return true; endf";

        try{
            UnderlineErrorListener errorListener = new UnderlineErrorListener();

            CharStream stream = CharStreams.fromString(input);
            LangLexer lexer = new LangLexer(stream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(errorListener);
            //lexer.
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            LangParser parser = new LangParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);

            System.out.println("Building CST...");
            ParseTree tree = parser.prog();
            System.out.println(">>> Pretty printing tree <<<");
            System.out.println(tree.getText());
            System.out.println(">>> End of pretty print <<<");

            // Symbol table stuff
            ParseTreeWalker walker = new ParseTreeWalker();
            SymbolDefListener symbolDefListener = new SymbolDefListener(errorListener);
            walker.walk(symbolDefListener, tree);
            SymbolRefListener symbolRefListener =
                    new SymbolRefListener(symbolDefListener.globalScope, symbolDefListener.scopes, errorListener);
            walker.walk(symbolRefListener, tree);

            // Type checking stuff
            ParseTreeVisitor visitor = new TypeCheckerVisitor(symbolDefListener.globalScope, symbolDefListener.scopes, errorListener);
            visitor.visit(tree);
        } catch (Exception e){
            //Nothing is currently being done as i am unsure what makes sense to do here.
        }

    }
}
