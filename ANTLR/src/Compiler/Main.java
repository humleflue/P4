package Compiler;

import Compiler.Lang.LangLexer;
import Compiler.Lang.LangParser;
import Compiler.SymbolTable.SymbolDefListener;
import Compiler.SymbolTable.SymbolRefListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    public static void main(String[] args) {
        try {
            String input = "number plus(number x, number y) = return x + z; endf\nplus(1,2)?;";

            CharStream stream = CharStreams.fromString(input);
            LangLexer lexer = new LangLexer(stream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LangParser parser = new LangParser(tokens);

            ParseTree tree = parser.prog();
            System.out.println("building cst");
            System.out.println(tree.getText());

            ParseTreeWalker walker = new ParseTreeWalker();

            SymbolDefListener symbolDefListener = new SymbolDefListener();
            walker.walk(symbolDefListener, tree);

            SymbolRefListener symbolRefListener = new SymbolRefListener(symbolDefListener.globalScope, symbolDefListener.scopes);
            walker.walk(symbolRefListener, tree);
        }
        catch (Exception exception){
            System.out.println("ERROR: " + exception.getMessage());
        }
    }
}
