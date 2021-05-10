package tests.LexerAndParser;
import tests.Auxiliary.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class LexerTests extends BaseTest {
    @ParameterizedTest
    @CsvFileSource(resources = testPath + "invalidDeclarationTests.csv")
    void invalidDeclarationsInSourceCode_ShouldThrow(String sourceCode) throws Exception {
        assertThrows(Exception.class, () -> {
           int errors = getNumberOfSyntaxErrors(sourceCode);
           if (errors > 0){
               throw new Exception();
           }
        });
        
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "validDeclarationTests.csv")
    void validDeclarationsInSourceCode_ShouldPass(String sourceCode) throws IOException {
        //arrange
        int errors = getNumberOfSyntaxErrors(sourceCode);
        //act
        //assert
        if (errors > 0){
            fail();
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "expressionsTest.csv")
    void expressionsInSourceCode_ShouldPass(String sourceCode) throws IOException {
        //arrange
        int errors = getNumberOfSyntaxErrors(sourceCode);
        //act
        //assert
        if (errors > 0){
            fail();
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "ifChainTests.csv")
    void ifChainInSourceCode_ShouldPass(String sourceCode) throws IOException {
        //arrange
        int errors = getNumberOfSyntaxErrors(sourceCode);
        //act
        //assert
        if (errors > 0){
            fail();
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "functionsTest.csv")
    void functionCallsInSourceCode_ShouldPass(String sourceCode) throws IOException {
        //arrange
        int errors = getNumberOfSyntaxErrors(sourceCode);
        //act
        //assert
        if (errors > 0){
            fail();
        }
    }
    
}
