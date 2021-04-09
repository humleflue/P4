package tests.TypeCheckerVisitor;

import Compiler.SymbolTable.SymbolDefListener;
import Compiler.SymbolTable.SymbolRefListener;
import Compiler.TypeChecker.TypeCheckerVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.Assertions;
import tests.Auxiliary.TestCase;

import java.io.IOException;

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
    @CsvFileSource(resources = testPath + "correspondingReturnTypes.csv", numLinesToSkip = 1)
    public void CorrespondingReturnTypes_ShouldPass(String type, String expr) throws IOException {
        // Arrange
        generateTreeWithSymbols(String.format("%s f() = return %s; endf", type, expr));
        ParseTreeVisitor visitor = new TypeCheckerVisitor(symbolDefListener.globalScope, symbolDefListener.scopes);
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "differentReturnTypes.csv", numLinesToSkip = 1)
    public void DifferentReturnTypes_ShouldThrow(String type, String expr) throws IOException {
        // Arrange
        generateTreeWithSymbols(String.format("%s f() = return %s; endf", type, expr));
        ParseTreeVisitor visitor = new TypeCheckerVisitor(symbolDefListener.globalScope, symbolDefListener.scopes);
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "simpleBooleanTypes.csv", numLinesToSkip = 1)
    public void SimpleBooleanTypeInIfSentence_ShouldPass(String trueOrFalse) throws IOException {
        // Arrange
        generateTreeWithSymbols(String.format("bool f() = if(%s) return true; return true; endf", trueOrFalse));
        ParseTreeVisitor visitor = new TypeCheckerVisitor(symbolDefListener.globalScope, symbolDefListener.scopes);
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "binaryBooleanTypes.csv", numLinesToSkip = 1)
    public void BinaryBooleanTypeInIfSentence_ShouldPass(String binaryBoolOperator) throws IOException {
        // Arrange
        generateTreeWithSymbols(String.format(
                "bool f() = if(true %s true) return true; return true; endf", binaryBoolOperator));
        ParseTreeVisitor visitor = new TypeCheckerVisitor(symbolDefListener.globalScope, symbolDefListener.scopes);
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @Test
    public void UnaryBooleanTypeInIfSentence_ShouldPass() throws IOException {
        // Arrange
        generateTreeWithSymbols("bool f() = if(!true) return true; return true; endf");
        ParseTreeVisitor visitor = new TypeCheckerVisitor(symbolDefListener.globalScope, symbolDefListener.scopes);
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @Test
    public void IncorrectUseOfUnaryOpInIfSentence_ShouldThrow() throws IOException {
        // Arrange
        generateTreeWithSymbols("bool f() = if(!1) return true; return true; endf");
        ParseTreeVisitor visitor = new TypeCheckerVisitor(symbolDefListener.globalScope, symbolDefListener.scopes);
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "comparisonBooleanTypes.csv", numLinesToSkip = 1)
    public void ComparisonBooleanTypeInIfSentence_ShouldPass(String operator) throws IOException {
        // Arrange
        generateTreeWithSymbols(String.format("bool f() = if(1 %s 1) return true; return true; endf", operator));
        ParseTreeVisitor visitor = new TypeCheckerVisitor(symbolDefListener.globalScope, symbolDefListener.scopes);
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }


}
