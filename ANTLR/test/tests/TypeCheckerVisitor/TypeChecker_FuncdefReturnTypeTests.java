package tests.TypeCheckerVisitor;

import Compiler.TypeChecker.TypeCheckerVisitor;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;

public class TypeChecker_FuncdefReturnTypeTests extends TypeCheckerTestsBase{
    @ParameterizedTest
    @CsvFileSource(resources = testPath + "correspondingReturnTypes.csv", numLinesToSkip = 1)
    public void CorrespondingReturnTypes_ShouldPass(String type, String expr) throws IOException {
        // Arrange
        generateTreeWithSymbols(String.format("%s f() = return %s; endf", type, expr));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(symbolDefListener.globalScope, symbolDefListener.scopes);
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "differentReturnTypes.csv", numLinesToSkip = 1)
    public void DifferentReturnTypes_ShouldThrow(String type, String expr) throws IOException {
        // Arrange
        generateTreeWithSymbols(String.format("%s f() = return %s; endf", type, expr));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(symbolDefListener.globalScope, symbolDefListener.scopes);
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }
}
