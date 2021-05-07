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
    public void SimpleBooleanTypeInIfSentence_ShouldPass(String trueOrFalse) {
        // Arrange
        generateTreeWithSymbols(String.format("boolean f() = if(%s) return true; return true; end", trueOrFalse));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numbers.csv")
    public void NumberTypeInIfSentence_ShouldThrow(String number) {
        // Arrange
        generateTreeWithSymbols(String.format("boolean f() = if(%s) return true; return true; end", number));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "binaryBooleanTypes.csv", numLinesToSkip = 1)
    public void BinaryBooleanTypeInIfSentence_ShouldPass(String binaryBoolOperator) {
        // Arrange
        generateTreeWithSymbols(String.format(
                "boolean f() = if(true %s true) return true; return true; end", binaryBoolOperator));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @Test
    public void NegateWithBoolInIfSentence_ShouldPass() {
        // Arrange
        generateTreeWithSymbols("boolean f() = if(!true) return true; return true; end");
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @Test
    public void NegateWithNumberInIfSentence_ShouldThrow() {
        // Arrange
        generateTreeWithSymbols("boolean f() = if(!1) return true; return true; end");
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "comparisonBooleanTypes.csv", numLinesToSkip = 1)
    public void NumberComparisonInIfSentence_ShouldPass(String operator) {
        // Arrange
        generateTreeWithSymbols(String.format("boolean f() = if(1 %s 1) return true; return true; end", operator));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "comparisonBooleanTypes.csv", numLinesToSkip = 1)
    public void BoolNumberComparisonInIfSentence_ShouldThrow(String operator) {
        // Arrange
        generateTreeWithSymbols(String.format("boolean f() = if(true %s 1) return true; return true; end", operator));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "comparisonBooleanTypes.csv", numLinesToSkip = 1)
    public void BoolComparisonInIfSentence_ShouldThrow(String operator) {
        // Arrange
        generateTreeWithSymbols(String.format("boolean f() = if(true %s true) return true; return true; end", operator));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "comparisonEqualityTypes.csv", numLinesToSkip = 1)
    public void BoolEqualityComparisonInIfSentence_ShouldPass(String operator) {
        // Arrange
        generateTreeWithSymbols(String.format("boolean f() = if(true %s true) return true; return true; end", operator));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "comparisonEqualityTypes.csv", numLinesToSkip = 1)
    public void NumberEqualityComparisonInIfSentence_ShouldPass(String operator) {
        // Arrange
        generateTreeWithSymbols(String.format("boolean f() = if(12 %s 12) return true; return true; end", operator));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "comparisonEqualityTypes.csv", numLinesToSkip = 1)
    public void EqualityComparisonInIfSentence_ShouldThrow(String operator) {
        // Arrange
        generateTreeWithSymbols(String.format("boolean f() = if(12 %s true) return true; return true; end", operator));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }
}
