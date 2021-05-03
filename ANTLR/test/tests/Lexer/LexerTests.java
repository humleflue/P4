package tests.Lexer;

import Compiler.AntlrGenerated.BuffLexer;
import tests.Auxiliary.TestCase;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LexerTests {
    private final String testPath = "./Data/";
    // Converts etc. "\n" to actual newline in string.
    private String unescape(String str){
        return StringEscapeUtils.unescapeJava(str);
    }

    @ParameterizedTest
    @DisplayName("New line tests")
    @CsvFileSource(resources = testPath + "newLineTests.csv", numLinesToSkip = 1, delimiter=';')
    void newLine(String testAsString, int shouldPass) throws IOException {
        TestCase testCase = new TestCase(unescape(testAsString), (shouldPass == 1));

        boolean testCaseSuccess = testCase.test();

        assertTrue(testCaseSuccess);
    }

    @ParameterizedTest
    @DisplayName("Declaration tests")
    @CsvFileSource(resources = testPath + "declarationTests.csv", numLinesToSkip = 1, delimiter=';')
    void declarations(String testAsString, int shouldPass) throws IOException {
        TestCase testCase = new TestCase(unescape(testAsString), (shouldPass == 1));

        boolean testCaseSuccess = testCase.test();

        assertTrue(testCaseSuccess);
    }

    @ParameterizedTest
    @DisplayName("Expressions test")
    @CsvFileSource(resources = testPath + "expressionsTest.csv", numLinesToSkip = 1, delimiter=';')
    void expressions(String testAsString, int shouldPass) throws IOException {
        TestCase testCase = new TestCase(unescape(testAsString), (shouldPass == 1));

        boolean testCaseSuccess = testCase.test();

        assertTrue(testCaseSuccess);
    }

    @ParameterizedTest
    @DisplayName("if else tests")
    @CsvFileSource(resources = testPath + "ifElseTests.csv", numLinesToSkip = 1, delimiter=';')
    void if_else(String testAsString, int shouldPass) throws IOException {
        TestCase testCase = new TestCase(unescape(testAsString), (shouldPass == 1));

        boolean testCaseSuccess = testCase.test();

        assertTrue(testCaseSuccess);
    }

    @ParameterizedTest
    @DisplayName("Functions test")
    @CsvFileSource(resources = testPath + "functionsTest.csv", numLinesToSkip = 1, delimiter=';')
    void functionsTest(String testAsString, int shouldPass) throws IOException {
        TestCase testCase = new TestCase(unescape(testAsString), (shouldPass == 1));

        boolean testCaseSuccess = testCase.test();

        assertTrue(testCaseSuccess);
    }

    @Nested
    @DisplayName("Tests by Lexer tokens order, types and amount")
    class LexerTokensTests {
        @Test
        void functionDefinition() throws IOException{
            // Arrange
            String test = "number test() = return 2; endf";
            //System.out.println(test);
            TestCase testCase = new TestCase(test, Arrays.asList(BuffLexer.NUMTYPE, BuffLexer.ID,
                    BuffLexer.LPAREN, BuffLexer.RPAREN, BuffLexer.ASSIGN, BuffLexer.RETURN, BuffLexer.NUMLITERAL, BuffLexer.SEMICOLON,
                    BuffLexer.END, BuffLexer.EOF));

            // Act
            boolean result = testCase.test();

            // Assert
            assertTrue(result);
        }
    }
}