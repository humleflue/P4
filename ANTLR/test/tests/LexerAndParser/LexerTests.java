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
    @DisplayName("Newlines in sourcecode")
    @CsvFileSource(resources = testPath + "newLineTests.csv", delimiter=';')
    void newlinesInSourceCode_ShouldPass(String sourceCode) throws IOException { 
        createCommonTokenStream(sourceCode);
    }

    @ParameterizedTest
    @DisplayName("Declarations in sourcecode")
    @CsvFileSource(resources = testPath + "declarationTests.csv", delimiter=';')
    void declarationsInSourceCode_ShouldPass(String sourceCode) throws IOException {
        createCommonTokenStream(sourceCode);
    }

    @ParameterizedTest
    @DisplayName("Expressions in sourcecode")
    @CsvFileSource(resources = testPath + "expressionsTest.csv", numLinesToSkip = 1, delimiter=';')
    void expressionsInSourceCode_ShouldPass(String sourceCode) throws IOException {
        createCommonTokenStream(sourceCode);
    }

    @ParameterizedTest
    @DisplayName("If statement chain in sourcecode")
    @CsvFileSource(resources = testPath + "ifElseTests.csv", delimiter=';')
    void ifChainInSourceCode(String sourceCode) throws IOException {
        createCommonTokenStream(sourceCode);
    }

    @ParameterizedTest
    @DisplayName("Function calls in sourcecode")
    @CsvFileSource(resources = testPath + "functionsTest.csv", delimiter=';')
    void functionCallsInSourceCode(String sourceCode) throws IOException {
        createCommonTokenStream(sourceCode);
    }

    @Nested
    @DisplayName("Tests by Lexer tokens order, types and amount")
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