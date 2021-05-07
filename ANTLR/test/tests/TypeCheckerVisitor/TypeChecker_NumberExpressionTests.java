package tests.TypeCheckerVisitor;

import Compiler.ContextualAnalysis.TypeCheckerVisitor;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.Auxiliary.MockErrorListener;

public class TypeChecker_NumberExpressionTests extends TypeCheckerTestsBase {
    private ParseTreeVisitor<Integer> generateVisitorForLiteralWithBinaryOp(String literal, String op) {
        // Arrange
        generateTreeWithSymbols(literal + op + literal + ";");
        return new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void plus_ShouldPass(String number) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp(number, "+");

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void minus_ShouldPass(String number) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp("(" + number + ")", "-");

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void mult_ShouldPass(String number) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp(number, "*");

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void div_ShouldPass(String number) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp(number, "/");

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void pow_ShouldPass(String number) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp(number, "^");

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void equals_ShouldPass(String number) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp(number, "==");

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void notEquals_ShouldPass(String number) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp(number, "!=");

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void greaterThan_ShouldPass(String number) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp(number, ">");

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void lessThan_ShouldPass(String number) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp(number, "<");

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void greaterThanEquals_ShouldPass(String number) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp(number, ">=");

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void lessThanEquals_ShouldPass(String number) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp(number, "<=");

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void logicalAnd_ShouldThrow(String number) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp(number, "&&");

        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void logicalOr_ShouldThrow(String number) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitorForLiteralWithBinaryOp(number, "||");

        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "numberLiterals.csv")
    public void logicalNot_ShouldThrow(String number) {
        // Arrange
        generateTreeWithSymbols("!" + number + ";");
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());

        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }
}
