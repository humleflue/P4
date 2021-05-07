package tests.TypeCheckerVisitor;

import Compiler.ErrorHandling.UnderlineErrorListener;
import Compiler.SymbolTable.SymbolTableGeneratorListener;
import Compiler.ContextualAnalysis.ReferenceCheckerListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import tests.Auxiliary.MockErrorListener;
import tests.Auxiliary.TestCase;

/**
 * Shared functionality for all TypeCheckerVisitor test classes.
 */
public abstract class TypeCheckerTestsBase {
    protected ParseTree tree;
    protected SymbolTableGeneratorListener symbolTable;
    final String testPath = "./Data/";

    protected void generateTreeWithSymbols(String testSourceCode) {
        try {
            tree = TestCase.createTree(testSourceCode);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        ParseTreeWalker walker = new ParseTreeWalker();

        symbolTable = new SymbolTableGeneratorListener(new UnderlineErrorListener());
        walker.walk(symbolTable, tree);
        ReferenceCheckerListener referenceCheckerListener = new ReferenceCheckerListener(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        walker.walk(referenceCheckerListener, tree);
    }
}
