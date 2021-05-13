package tests.TypeChecker;

import Compiler.ContextualAnalysis.ReferenceCheckerListener;
import Compiler.ContextualAnalysis.TypeCheckerVisitor;
import Compiler.ErrorHandling.UnderlineErrorListener;
import Compiler.SymbolTable.SymbolTableGeneratorListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import tests.Auxiliary.BaseTest;
import tests.Auxiliary.MockErrorListener;

/**
 * Shared functionality for all TypeCheckerVisitor test classes.
 */
public abstract class TypeCheckerTestsBase extends BaseTest {
    protected ParseTree tree;
    protected SymbolTableGeneratorListener symbolTable;

    protected void createTreeWithSymbols(String sourceCode) {
        try {
            tree = createTree(sourceCode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ParseTreeWalker walker = new ParseTreeWalker();
        symbolTable = new SymbolTableGeneratorListener(new UnderlineErrorListener());
        walker.walk(symbolTable, tree);
        ReferenceCheckerListener referenceCheckerListener = new ReferenceCheckerListener(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        walker.walk(referenceCheckerListener, tree);
    }

    protected ParseTreeVisitor<Integer> generateVisitorForLiteralWithBinaryOp(String literal, String op) {
        return generateVisitor(literal + " " + op + " " + literal + ";");
    }

    protected ParseTreeVisitor<Integer> generateVisitor(String sourceCode) {
        createTreeWithSymbols(sourceCode);
        return new TypeCheckerVisitor(symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
    }
}
