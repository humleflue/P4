package tests.TypeCheckerVisitor;

import Compiler.ContextualAnalysis.TypeCheckerVisitor;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.Auxiliary.MockErrorListener;

public class TypeChecker_FuncdefReturnTypeTests extends TypeCheckerTestsBase {
    @ParameterizedTest
    @CsvFileSource(resources = testPath + "correspondingTypes.csv", numLinesToSkip = 1)
    public void CorrespondingReturnTypes_ShouldPass(String type, String expr) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitor(String.format("%s f() = return %s; end", type, expr));
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "conflictingTypes.csv", numLinesToSkip = 1)
    public void ConflictingReturnTypes_ShouldThrow(String type, String expr) {
        // Arrange
        ParseTreeVisitor<Integer> visitor = generateVisitor(String.format("%s f() = return %s; end", type, expr));
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @Test
    public void DifferentReturnTypesInFirstIf_ShouldThrow() {
        // Arrange
        createTreeWithSymbols("""
                number f() =
                    if(true) return true;
                    if(false) return 2;
                    return 2;
                    end""");
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @Test
    public void DifferentReturnTypesInSecondIf_ShouldThrow() {
        // Arrange
        createTreeWithSymbols("""
                number f() =
                    if(true) return 2;
                    if(false) return true;
                    return 2;
                    end""");
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(symbolTable.globalScope, symbolTable.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }
}
