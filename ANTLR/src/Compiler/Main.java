package Compiler;

import Compiler.AntlrGenerated.LangLexer;
import Compiler.AntlrGenerated.LangParser;
import Compiler.AntlrGenerated.LangVisitor;
import Compiler.SymbolTable.SymbolDefListener;
import Compiler.SymbolTable.SymbolRefListener;
import Compiler.TypeChecker.TypeChecker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    public static void main(String[] args)  {
        String input = "number plus(number x, number y) = return 2 * 2; endf\nplus(1,2)?;";

        CharStream stream = CharStreams.fromString(input);
        LangLexer lexer = new LangLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);

        System.out.println("Building CST...");
        ParseTree tree = parser.prog();
        System.out.println(">>> Pretty printing tree <<<");
        System.out.println(tree.getText());
        System.out.println(">>> End of pretty print <<<");

        // Symbol table stuff
        ParseTreeWalker walker = new ParseTreeWalker();
        SymbolDefListener symbolDefListener = new SymbolDefListener();
        walker.walk(symbolDefListener, tree);
        SymbolRefListener symbolRefListener = new SymbolRefListener(symbolDefListener.globalScope, symbolDefListener.scopes);
        walker.walk(symbolRefListener, tree);

        // Type checking stuff
        ParseTreeVisitor visitor = new TypeChecker(symbolDefListener.globalScope, symbolDefListener.scopes);
        visitor.visit(tree);
    }
}
