package tests.TypeCheckerVisitor;

import Compiler.ContextualAnalysis.TypeCheckerVisitor;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.Auxiliary.MockErrorListener;

public class TypeChecker_BooleanExpressionTests extends TypeCheckerTestsBase {
    @ParameterizedTest
    @CsvFileSource(resources = testPath + "binaryBooleanComparisonOperators.csv")
    public void BooleanComparisonOperators_ShouldPass(String operator) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp("true", operator);

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "equalityOperators.csv")
    public void EqualityOperators_ShouldPass(String operator) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp("true", operator);

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberComparisonOperators.csv")
    public void NumberComparisonOperators_ShouldThrow(String operator) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp("true", operator);

        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "booleanLiterals.csv")
    public void logicalNot_ShouldThrow(String booleanLiteral) {
        // Arrange
        createTreeWithSymbols("!" + booleanLiteral + ";");
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }
}
