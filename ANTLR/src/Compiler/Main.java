package Compiler;

import Compiler.AntlrGenerated.LangLexer;
import Compiler.AntlrGenerated.LangParser;
import Compiler.AntlrGenerated.LangVisitor;
import Compiler.SymbolTable.SymbolDefListener;
import Compiler.SymbolTable.SymbolRefListener;
import Compiler.TypeChecker.TypeCheckerVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        String input = "number plus(number x, number y) = return x + y; endf\nplus(1,2)?;";

        CharStream stream = CharStreams.fromString(input);
        LangLexer lexer = new LangLexer(stream);
        //lexer.
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        LangParser parser = new LangParser(tokens);

        System.out.println("Building CST...");
        ParseTree tree = parser.prog();
        System.out.println(">>> Pretty printing tree <<<");
        System.out.println(tree.getText());
        System.out.println(">>> End of pretty print <<<");

        ParseTreeWalker walker = new ParseTreeWalker();
        InitializeSymbolTable(walker, tree);

        ParseTreeVisitor visitor = new TypeChecker();
        PerformTypeChecking(visitor, tree);


        //LangParser.TypeContext typectx = new LangParser.TypeContext(new ParserRuleContext(), 0);
        //LangParser.FuncdefContext funcDef = LangParser.FuncdefContext;


    }

    public static void InitializeSymbolTable(ParseTreeWalker walker, ParseTree tree) {
        SymbolDefListener symbolDefListener = new SymbolDefListener();
        walker.walk(symbolDefListener, tree);

        SymbolRefListener symbolRefListener = new SymbolRefListener(symbolDefListener.globalScope, symbolDefListener.scopes);
        walker.walk(symbolRefListener, tree);
    }

    public static void PerformTypeChecking(ParseTreeVisitor visitor, ParseTree tree) {

    }
}
