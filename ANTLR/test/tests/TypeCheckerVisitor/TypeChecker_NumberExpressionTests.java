package tests.TypeCheckerVisitor;

import Compiler.ContextualAnalysis.TypeCheckerVisitor;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.Auxiliary.MockErrorListener;

public class TypeChecker_NumberExpressionTests extends TypeCheckerTestsBase {
    @ParameterizedTest
    @CsvFileSource(resources = testPath + "binaryBooleanComparisonOperators.csv")
    public void BooleanComparisonOnNumbers_ShouldThrow(String operator) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp("1", operator);

        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "equalityOperators.csv")
    public void EqualityComparisonOnNumbers_ShouldPass(String operator) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp("1", operator);

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberComparisonOperators.csv")
    public void NumberComparisonOnNumbers_ShouldPass(String operator) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp("1", operator);

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void LogicalNotOnNumber_ShouldThrow(String numberLiteral) {
        // Arrange
        createTreeWithSymbols("!" + numberLiteral + ";");
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());

        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }
}
