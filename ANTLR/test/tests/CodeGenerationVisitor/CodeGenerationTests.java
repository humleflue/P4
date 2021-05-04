package tests.CodeGenerationVisitor;

import Compiler.CodeGeneration.JavaScriptCodeGenerationVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.Auxiliary.BaseTest;

import java.io.IOException;

public class CodeGenerationTests extends BaseTest {
    JavaScriptCodeGenerationVisitor codeGenerator = new JavaScriptCodeGenerationVisitor();

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "buffCodeAndTargetCode.csv", numLinesToSkip = 1)
    public void GeneratedCodeAndExpectedCodeTheSame_ShouldPass(String buffCode, String targetCode ) throws IOException {
        // Arrange 
        ParseTree tree = createTree(buffCode);
         // Act
        String generatedCode = codeGenerator.visit(tree);
        // Assert
        Assertions.assertEquals(targetCode, generatedCode);
    }
    
}
