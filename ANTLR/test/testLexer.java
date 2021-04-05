//package Compiler.Test;
import testCase.LangTestCase;

// import Compiler.Lang.BuildASTVisitor;
// import Compiler.Lang.Nodes.Abstract.Node;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;

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
}