package tests.LexerAndParser;
import Compiler.AntlrGenerated.BuffLexer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.Auxiliary.BaseTest;
import tests.Auxiliary.TestCase;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTests extends BaseTest {
    @ParameterizedTest
    @CsvFileSource(resources = testPath + "newLineTests.csv")
    void newlinesInSourceCode_ShouldThrow(String sourceCode) throws IOException {
        assertThrows(Exception.class, () -> {
            createTree(sourceCode);
        });
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
    void validDeclarationsInSourceCode_ShouldPass(String sourceCode) throws IOException {
        try{
            createTree(sourceCode);
        } catch (Exception err){
            fail();
        }
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = testPath + "expressionsTest.csv")
    void expressionsInSourceCode_ShouldPass(String sourceCode) throws IOException {
        try{
            createTree(sourceCode);
        } catch (Exception err){
            fail();
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "ifChainTests.csv")
    void ifChainInSourceCode_ShouldPass(String sourceCode) throws IOException {
        try{
            createTree(sourceCode);
        } catch (Exception err){
            fail();
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "functionsTest.csv")
    void functionCallsInSourceCode_ShouldPass(String sourceCode) throws IOException {
        try{
            createTree(sourceCode);
        } catch (Exception err){
            fail();
        }
    }

    @Nested
    class LexerTokensTests {
        @Test
        void functionDefinition_ShouldPass() {
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
