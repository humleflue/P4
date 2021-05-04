package tests.LexerAndParser;
import tests.Auxiliary.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LexerTests extends BaseTest {
    @ParameterizedTest
    @CsvFileSource(resources = testPath + "newLineTests.csv")
    void newlinesInSourceCode_ShouldPass(String sourceCode) throws IOException { 
        createCommonTokenStream(sourceCode);
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "invalidDeclarationTests.csv")
    void invalidDeclarationsInSourceCode_ShouldThrow(String sourceCode) throws IOException {
        assertThrows(Exception.class, () -> {
            createTree(sourceCode);
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "validDeclarationTests.csv")
    void declarationsInSourceCode_ShouldPass(String sourceCode) throws IOException { 
        createCommonTokenStream(sourceCode);
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "expressionsTest.csv")
    void expressionsInSourceCode_ShouldPass(String sourceCode) throws IOException {
        createCommonTokenStream(sourceCode);
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "ifChainTests.csv")
    void ifChainInSourceCode_ShouldPass(String sourceCode) throws IOException {
        createCommonTokenStream(sourceCode);
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "functionsTest.csv")
    void functionCallsInSourceCode_ShouldPass(String sourceCode) throws IOException {
        createCommonTokenStream(sourceCode);
    }
    
}