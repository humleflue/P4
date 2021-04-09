package tests.TypeCheckerVisitor;

import Compiler.SymbolTable.SymbolDefListener;
import Compiler.SymbolTable.SymbolRefListener;
import Compiler.TypeChecker.TypeCheckerVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.Auxiliary.TestCase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TypeCheckerTests {
    private ParseTree tree;
    private SymbolDefListener symbolDefListener;
    final String testPath = "./Data/";

    private void generateTreeWithSymbols(String testSourceCode) throws IOException {
        tree = TestCase.createTree(testSourceCode);

        ParseTreeWalker walker = new ParseTreeWalker();
        symbolDefListener = new SymbolDefListener();
        walker.walk(symbolDefListener, tree);
        SymbolRefListener symbolRefListener = new SymbolRefListener(symbolDefListener.globalScope, symbolDefListener.scopes);
        walker.walk(symbolRefListener, tree);
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "correctReturnType.csv")
    public void GivenCorrespondingReturnTypes_ShouldPass(String testSourceCode) throws IOException {
        // Arrange
        generateTreeWithSymbols(testSourceCode);
        ParseTreeVisitor visitor = new TypeCheckerVisitor(symbolDefListener.globalScope, symbolDefListener.scopes);
        // Act & Assert
        assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "incorrectReturnType.csv")
    public void GivenIncorrectReturnTypes_ShouldThrow(String testSourceCode) throws IOException {
        // Arrange
        generateTreeWithSymbols(testSourceCode);
        ParseTreeVisitor visitor = new TypeCheckerVisitor(symbolDefListener.globalScope, symbolDefListener.scopes);
        // Act & Assert
        assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

}
