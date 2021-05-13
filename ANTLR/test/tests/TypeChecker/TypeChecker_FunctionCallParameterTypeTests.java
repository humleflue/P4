package tests.TypeChecker;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TypeChecker_FunctionCallParameterTypeTests extends TypeCheckerTestsBase {
    @ParameterizedTest
    @CsvFileSource(resources = testPath + "correspondingTypes.csv", numLinesToSkip = 1)
    public void CorrespondingParameterTypes_ShouldPass(String type, String expr) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitor(String.format("""
                    number f(%s param) = return 1; end
                    f(%s);
                """, type, expr));
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "conflictingTypes.csv", numLinesToSkip = 1)
    public void ConflictingParameterTypes_ShouldThrow(String type, String expr) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitor(String.format("""
                    number f(%s param) = return 1; end
                    f(%s);
                """, type, expr));
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }
}
