package Compiler;

import Compiler.Lang.*;
import Compiler.SymbolTable.SymbolDefListener;
import Compiler.SymbolTable.SymbolRefListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class CheckSymbols {
    public static void main(String[] args) throws IOException {
        CharStream stream = CharStreams.fromString("number test(number a, number b) = return a; endf test(1, 2);");
        LangLexer lexer = new LangLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);

        ParseTree tree = parser.prog();
        System.out.println("building cst");
        System.out.println(tree.getText());

        SymbolDefListener symbolDefListener = new SymbolDefListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(symbolDefListener, tree);

        SymbolRefListener symbolRefListener = new SymbolRefListener(symbolDefListener.globalScope, symbolDefListener.scopes);
        walker.walk(symbolRefListener, tree);
    }
}
