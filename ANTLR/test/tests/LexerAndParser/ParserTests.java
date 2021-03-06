package tests.LexerAndParser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.Auxiliary.BaseTest;

public class ParserTests extends BaseTest {
    @ParameterizedTest
    @CsvFileSource(resources = testPath + "invalidDeclarationTests.csv")
    void invalidDeclarationsInSourceCode_ShouldThrow(String sourceCode) {
        Assertions.assertThrows(Exception.class, () -> createTree(sourceCode));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "invalidTokenOrder.csv")
    void invalidTokenOrder_ShouldThrow(String sourceCode) {
        Assertions.assertThrows(Exception.class, () -> createTree(sourceCode));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "validDeclarationTests.csv")
    void validDeclarationsInSourceCode_ShouldPass(String sourceCode) {
        Assertions.assertDoesNotThrow(() -> createTree(sourceCode));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "expressionsTest.csv")
    void expressionsInSourceCode_ShouldPass(String sourceCode) {
        Assertions.assertDoesNotThrow(() -> createTree(sourceCode));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "ifChainTests.csv")
    void ifChainInSourceCode_ShouldPass(String sourceCode) {
        Assertions.assertDoesNotThrow(() -> createTree(sourceCode));
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "functionsTest.csv")
    void functionCallsInSourceCode_ShouldPass(String sourceCode) {
        Assertions.assertDoesNotThrow(() -> createTree(sourceCode));
    }

}
