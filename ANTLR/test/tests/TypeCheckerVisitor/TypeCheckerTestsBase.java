package tests.TypeCheckerVisitor;

import Compiler.ErrorHandling.UnderlineErrorListener;
import Compiler.SymbolTable.SymbolDefListener;
import Compiler.SymbolTable.SymbolRefListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import tests.Auxiliary.TestCase;

import java.io.IOException;

/**
 * Shared functionality for all TypeCheckerVisitor test classes.
 */
public abstract class TypeCheckerTestsBase {
    protected ParseTree tree;
    protected SymbolDefListener symbolDefListener;
    final String testPath = "./Data/";

    protected void generateTreeWithSymbols(String testSourceCode) throws IOException {
        tree = TestCase.createTree(testSourceCode);

        ParseTreeWalker walker = new ParseTreeWalker();
        symbolDefListener = new SymbolDefListener(new UnderlineErrorListener());
        walker.walk(symbolDefListener, tree);
        SymbolRefListener symbolRefListener = new SymbolRefListener(symbolDefListener.globalScope, symbolDefListener.scopes, new UnderlineErrorListener());
        walker.walk(symbolRefListener, tree);
    }
}
