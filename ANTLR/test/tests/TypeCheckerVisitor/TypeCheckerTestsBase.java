package tests.TypeCheckerVisitor;

import Compiler.AntlrGenerated.BuffLexer;
import Compiler.AntlrGenerated.BuffParser;
import Compiler.ErrorHandling.UnderlineErrorListener;
import Compiler.SymbolTable.SymbolTableGeneratorListener;
import Compiler.ContextualAnalysis.ReferenceCheckerListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import tests.Auxiliary.MockErrorListener;
import tests.Auxiliary.TestCase;

import java.io.IOException;
import java.io.StringReader;

/**
 * Shared functionality for all TypeCheckerVisitor test classes.
 */
public abstract class TypeCheckerTestsBase {
    protected ParseTree tree;
    protected SymbolTableGeneratorListener symbolTableGeneratorListener;
    final String testPath = "./Data/";

    protected void generateTreeWithSymbols(String testSourceCode) {
        try {
            tree = TestCase.createTree(testSourceCode);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        ParseTreeWalker walker = new ParseTreeWalker();

        symbolTableGeneratorListener = new SymbolTableGeneratorListener(new UnderlineErrorListener());
        walker.walk(symbolTableGeneratorListener, tree);
        ReferenceCheckerListener referenceCheckerListener = new ReferenceCheckerListener(
                symbolTableGeneratorListener.globalScope, symbolTableGeneratorListener.scopes, new MockErrorListener());
        walker.walk(referenceCheckerListener, tree);
    }
}
