package tests.TypeCheckerVisitor;

import Compiler.ContextualAnalysis.TypeCheckerVisitor;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.Assertions;
import tests.Auxiliary.MockErrorListener;

import java.io.IOException;

public class TypeChecker_IfSentenceTests extends TypeCheckerTestsBase {
    @ParameterizedTest
    @CsvFileSource(resources = testPath + "simpleBooleanTypes.csv", numLinesToSkip = 1)
    public void SimpleBooleanTypeInIfSentence_ShouldPass(String trueOrFalse) throws IOException {
        // Arrange
        createTreeWithSymbols(String.format("bool f() = if(%s) return true; return true; endf", trueOrFalse));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTableGeneratorListener.globalScope, symbolTableGeneratorListener.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numbers.csv")
    public void NumberTypeInIfSentence_ShouldThrow(String number) throws IOException {
        // Arrange
        createTreeWithSymbols(String.format("bool f() = if(%s) return true; return true; endf", number));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTableGeneratorListener.globalScope, symbolTableGeneratorListener.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "binaryBooleanTypes.csv", numLinesToSkip = 1)
    public void BinaryBooleanTypeInIfSentence_ShouldPass(String binaryBoolOperator) throws IOException {
        // Arrange
        createTreeWithSymbols(String.format(
                "bool f() = if(true %s true) return true; return true; endf", binaryBoolOperator));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTableGeneratorListener.globalScope, symbolTableGeneratorListener.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @Test
    public void NegateWithBoolInIfSentence_ShouldPass() throws IOException {
        // Arrange
        createTreeWithSymbols("bool f() = if(!true) return true; return true; endf");
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTableGeneratorListener.globalScope, symbolTableGeneratorListener.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @Test
    public void NegateWithNumberInIfSentence_ShouldThrow() throws IOException {
        // Arrange
        createTreeWithSymbols("bool f() = if(!1) return true; return true; endf");
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTableGeneratorListener.globalScope, symbolTableGeneratorListener.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "comparisonBooleanTypes.csv", numLinesToSkip = 1)
    public void NumberComparisonInIfSentence_ShouldPass(String operator) throws IOException {
        // Arrange
        createTreeWithSymbols(String.format("bool f() = if(1 %s 1) return true; return true; endf", operator));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTableGeneratorListener.globalScope, symbolTableGeneratorListener.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "comparisonBooleanTypes.csv", numLinesToSkip = 1)
    public void BoolNumberComparisonInIfSentence_ShouldThrow(String operator) throws IOException {
        // Arrange
        createTreeWithSymbols(String.format("bool f() = if(true %s 1) return true; return true; endf", operator));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTableGeneratorListener.globalScope, symbolTableGeneratorListener.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "comparisonBooleanTypes.csv", numLinesToSkip = 1)
    public void BoolComparisonInIfSentence_ShouldThrow(String operator) throws IOException {
        // Arrange
        createTreeWithSymbols(String.format("bool f() = if(true %s true) return true; return true; endf", operator));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTableGeneratorListener.globalScope, symbolTableGeneratorListener.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }
}
