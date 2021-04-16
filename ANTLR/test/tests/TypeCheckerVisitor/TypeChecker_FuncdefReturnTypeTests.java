package tests.TypeCheckerVisitor;

import Compiler.ContextualAnalysis.TypeCheckerVisitor;
import Compiler.ErrorHandling.UnderlineErrorListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.Auxiliary.MockErrorListener;

import java.io.IOException;

public class TypeChecker_FuncdefReturnTypeTests extends TypeCheckerTestsBase{
    @ParameterizedTest
    @CsvFileSource(resources = testPath + "correspondingReturnTypes.csv", numLinesToSkip = 1)
    public void CorrespondingReturnTypes_ShouldPass(String type, String expr) throws IOException {
        // Arrange
        generateTreeWithSymbols(String.format("%s f() = return %s; endf", type, expr));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(
                symbolTableGeneratorListener.globalScope, symbolTableGeneratorListener.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> visitor.visit(tree));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "differentReturnTypes.csv", numLinesToSkip = 1)
    public void DifferentReturnTypes_ShouldThrow(String type, String expr) throws IOException {
        // Arrange
        generateTreeWithSymbols(String.format("%s f() = return %s; endf", type, expr));
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(symbolTableGeneratorListener.globalScope, symbolTableGeneratorListener.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @Test
    public void DifferentReturnTypesInFirstIf_ShouldThrow() throws IOException {
        // Arrange
        generateTreeWithSymbols("number f() =\n" +
                "    if(true) return true;\n" +
                "    if(false) return 2;\n" +
                "    return 2;\n" +
                "    endf");
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(symbolTableGeneratorListener.globalScope, symbolTableGeneratorListener.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }

    @Test
    public void DifferentReturnTypesInSecondIf_ShouldThrow() throws IOException {
        // Arrange
        generateTreeWithSymbols("number f() =\n" +
                "    if(true) return 2;\n" +
                "    if(false) return true;\n" +
                "    return 2;\n" +
                "    endf");
        ParseTreeVisitor<Integer> visitor = new TypeCheckerVisitor(symbolTableGeneratorListener.globalScope, symbolTableGeneratorListener.scopes, new MockErrorListener());
        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> visitor.visit(tree));
    }
}
