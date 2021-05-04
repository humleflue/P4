package tests.LexerAndParser;

import Compiler.AntlrGenerated.BuffLexer;
import tests.Auxiliary.BaseTest;
import tests.Auxiliary.TestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LexerTests extends BaseTest {
    @ParameterizedTest
    @CsvFileSource(resources = testPath + "newLineTests.csv")
    void newlinesInSourceCode_ShouldPass(String sourceCode) throws IOException { 
        createCommonTokenStream(sourceCode);
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "declarationTests.csv")
    void declarationsInSourceCode_ShouldPass(String sourceCode) throws IOException {
        createCommonTokenStream(sourceCode);
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "expressionsTest.csv", numLinesToSkip = 1)
    void expressionsInSourceCode_ShouldPass(String sourceCode) throws IOException {
        createCommonTokenStream(sourceCode);
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "ifElseTests.csv")
    void ifChainInSourceCode_ShouldPass(String sourceCode) throws IOException {
        createCommonTokenStream(sourceCode);
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "functionsTest.csv")
    void functionCallsInSourceCode_ShouldPass(String sourceCode) throws IOException {
        createCommonTokenStream(sourceCode);
    }

    @Nested
    class LexerTokensTests {
        @Test
        void functionDefinition() {
            // Arrange
            String test = "number test() = return 2; endf";
            //System.out.println(test);
            TestCase testCase = new TestCase(test, Arrays.asList(BuffLexer.NUMBERTYPE, BuffLexer.ID,
                    BuffLexer.LPAREN, BuffLexer.RPAREN, BuffLexer.ASSIGN, BuffLexer.RETURN, BuffLexer.NUMLITERAL, BuffLexer.SEMICOLON,
                    BuffLexer.ENDF, BuffLexer.EOF));

            // Act
            boolean result = testCase.test();

            // Assert
            assertTrue(result);
        }
    }
}