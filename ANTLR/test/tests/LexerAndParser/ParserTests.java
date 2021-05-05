package tests.LexerAndParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.Auxiliary.BaseTest;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTests extends BaseTest {
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
    
}
