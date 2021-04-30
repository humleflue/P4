package tests.TypeCheckerVisitor;

import Compiler.ErrorHandling.UnderliningErrorListener;
import Compiler.SymbolTable.SymbolTableGeneratorListener;
import Compiler.ContextualAnalysis.ReferenceCheckerListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import tests.Auxiliary.MockErrorListener;
import tests.Auxiliary.TestCase;

import java.io.IOException;

/**
 * Shared functionality for all TypeCheckerVisitor test classes.
 */
public abstract class TypeCheckerTestsBase {
    protected ParseTree tree;
    protected SymbolTableGeneratorListener symbolTableGeneratorListener;
    final String testPath = "./Data/";

    protected void generateTreeWithSymbols(String testSourceCode) throws IOException {
        tree = TestCase.createTree(testSourceCode);

        ParseTreeWalker walker = new ParseTreeWalker();

        symbolTableGeneratorListener = new SymbolTableGeneratorListener(new UnderliningErrorListener());
        walker.walk(symbolTableGeneratorListener, tree);
        ReferenceCheckerListener referenceCheckerListener = new ReferenceCheckerListener(
                symbolTableGeneratorListener.globalScope, symbolTableGeneratorListener.scopes, new MockErrorListener());
        walker.walk(referenceCheckerListener, tree);
    }
}
