package tests.TypeChecker;

import Compiler.ContextualAnalysis.TypeCheckerVisitor;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.Auxiliary.MockErrorListener;

public class TypeChecker_BooleanExpressionTests extends TypeCheckerTestsBase {
    @ParameterizedTest
    @CsvFileSource(resources = testPath + "binaryBooleanComparisonOperators.csv")
    public void BooleanComparisonOnBooleans_ShouldPass(String operator) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp("true", operator);

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "equalityOperators.csv")
    public void EqualityComparisonOnBooleans_ShouldPass(String operator) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp("true", operator);

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberComparisonOperators.csv")
    public void NumberComparisonOnBooleans_ShouldThrow(String operator) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp("true", operator);

        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "booleanLiterals.csv")
    public void LogicalNotOnBoolean_ShouldPass(String booleanLiteral) {
        // Arrange
        createTreeWithSymbols("NOT " + booleanLiteral + ";");
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "booleanLiterals.csv")
    public void MinusPrefixOnBoolean_ShouldThrow(String booleanLiteral) {
        // Arrange
        createTreeWithSymbols("- " + booleanLiteral + ";");
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());

        // Act & Assert
        Assertions.assertThrows(Exception.class, () -> visitor.visit(tree));
    }
}
