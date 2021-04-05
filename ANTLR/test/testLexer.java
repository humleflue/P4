//package Compiler.Test;
import Compiler.Lang.LangLexer;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import testCase.LangTestCase;

// import Compiler.Lang.BuildASTVisitor;
// import Compiler.Lang.Nodes.Abstract.Node;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class testLexer {
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

        Boolean testCaseSuccess = testCase.test();

        assertTrue(testCaseSuccess);
    }

    @ParameterizedTest
    @DisplayName("Declaration tests")
    @CsvFileSource(resources = testPath + "declarationTests.csv", numLinesToSkip = 1, delimiter=';')
    void declarations(String testAsString, int shouldPass) throws IOException {
        LangTestCase testCase = new LangTestCase(unescape(testAsString), (shouldPass == 1));

        Boolean testCaseSuccess = testCase.test();

        assertTrue(testCaseSuccess);
    }

    @ParameterizedTest
    @DisplayName("Expressions test")
    @CsvFileSource(resources = testPath + "expressionsTest.csv", numLinesToSkip = 1, delimiter=';')
    void expressions(String testAsString, int shouldPass) throws IOException {
        LangTestCase testCase = new LangTestCase(unescape(testAsString), (shouldPass == 1));

        Boolean testCaseSuccess = testCase.test();

        assertTrue(testCaseSuccess);
    }

    @ParameterizedTest
    @DisplayName("if else tests")
    @CsvFileSource(resources = testPath + "ifElseTests.csv", numLinesToSkip = 1, delimiter=';')
    void ifelse(String testAsString, int shouldPass) throws IOException {
        LangTestCase testCase = new LangTestCase(unescape(testAsString), (shouldPass == 1));

        Boolean testCaseSuccess = testCase.test();

        assertTrue(testCaseSuccess);
    }

    @ParameterizedTest
    @DisplayName("Functions test")
    @CsvFileSource(resources = testPath + "functionsTest.csv", numLinesToSkip = 1, delimiter=';')
    void functionsTest(String testAsString, int shouldPass) throws IOException {
        LangTestCase testCase = new LangTestCase(unescape(testAsString), (shouldPass == 1));

        Boolean testCaseSuccess = testCase.test();

        assertTrue(testCaseSuccess);
    }
    @Test
    @DisplayName("Testcases that should be valid")
    public void TestLexerCases() throws IOException {
        Assertions.assertAll(
                () -> assertTrue(new LangTestCase("number test() = 2;", Arrays.asList(LangLexer.NUMBERTYPE, LangLexer.ID,
                                    LangLexer.LPAREN, LangLexer.RPAREN, LangLexer.ASSIGN, LangLexer.NUMLITERAL, LangLexer.SEMICOLON,
                                    LangLexer.EOF)).test()),
                () -> assertTrue(new LangTestCase("number test(number numb1) = 2;", Arrays.asList(LangLexer.NUMBERTYPE,
                                    LangLexer.ID, LangLexer.LPAREN, LangLexer.NUMBERTYPE, LangLexer.ID, LangLexer.RPAREN,
                                    LangLexer.ASSIGN, LangLexer.NUMLITERAL, LangLexer.SEMICOLON, LangLexer.EOF)).test())
        );
    }
}