//package Compiler.Test;

import Compiler.AntlrGenerated.LangLexer;
import Compiler.AntlrGenerated.LangParser;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ListTokenSource;
import org.antlr.v4.runtime.Token;
import testCase.LangTestCase;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLexer {
    private final String testPath = "TestLexerData/";
    // Converts etc. "\n" to actual newline in string.
    private String unescape(String str){
        return StringEscapeUtils.unescapeJava(str);
    }

    @ParameterizedTest
    @DisplayName("New line tests")
    @CsvFileSource(resources = testPath + "newLineTests.csv", numLinesToSkip = 1, delimiter=';')
    void newLine(String testAsString, int shouldPass) throws IOException {
        LangTestCase testCase = new LangTestCase(unescape(testAsString), (shouldPass == 1));

        boolean testCaseSuccess = testCase.test();

        assertTrue(testCaseSuccess);
    }

    @ParameterizedTest
    @DisplayName("Declaration tests")
    @CsvFileSource(resources = testPath + "declarationTests.csv", numLinesToSkip = 1, delimiter=';')
    void declarations(String testAsString, int shouldPass) throws IOException {
        LangTestCase testCase = new LangTestCase(unescape(testAsString), (shouldPass == 1));

        boolean testCaseSuccess = testCase.test();

        assertTrue(testCaseSuccess);
    }

    @ParameterizedTest
    @DisplayName("Expressions test")
    @CsvFileSource(resources = testPath + "expressionsTest.csv", numLinesToSkip = 1, delimiter=';')
    void expressions(String testAsString, int shouldPass) throws IOException {
        LangTestCase testCase = new LangTestCase(unescape(testAsString), (shouldPass == 1));

        boolean testCaseSuccess = testCase.test();

        assertTrue(testCaseSuccess);
    }

    @ParameterizedTest
    @DisplayName("if else tests")
    @CsvFileSource(resources = testPath + "ifElseTests.csv", numLinesToSkip = 1, delimiter=';')
    void if_else(String testAsString, int shouldPass) throws IOException {
        LangTestCase testCase = new LangTestCase(unescape(testAsString), (shouldPass == 1));

        boolean testCaseSuccess = testCase.test();

        assertTrue(testCaseSuccess);
    }

    @ParameterizedTest
    @DisplayName("Functions test")
    @CsvFileSource(resources = testPath + "functionsTest.csv", numLinesToSkip = 1, delimiter=';')
    void functionsTest(String testAsString, int shouldPass) throws IOException {
        LangTestCase testCase = new LangTestCase(unescape(testAsString), (shouldPass == 1));

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
            LangTestCase testCase = new LangTestCase(test, Arrays.asList(LangLexer.NUMBERTYPE, LangLexer.ID,
                    LangLexer.LPAREN, LangLexer.RPAREN, LangLexer.ASSIGN, LangLexer.RETURN, LangLexer.NUMLITERAL, LangLexer.SEMICOLON,
                    LangLexer.ENDF, LangLexer.EOF));

            // Act
            boolean result = testCase.test();

            // Assert
            assertTrue(result);
        }
    }
}