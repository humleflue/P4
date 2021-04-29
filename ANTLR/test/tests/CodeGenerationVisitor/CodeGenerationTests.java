package tests.CodeGenerationVisitor;


import Compiler.AntlrGenerated.BuffParser;
import Compiler.CodeGeneration.JavaScriptCodeGenerationVisitor;
import Compiler.ContextualAnalysis.TypeCheckerVisitor;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.Auxiliary.BaseTest;
import tests.Auxiliary.MockErrorListener;

import java.io.IOException;

public class CodeGenerationTests extends BaseTest {
    JavaScriptCodeGenerationVisitor codeGenerator = new JavaScriptCodeGenerationVisitor();

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "buffCodeAndTargetCode.csv", numLinesToSkip = 1)
    public void GeneratedCodeAndExpectedCodeTheSame_ShouldPass(String buffCode, String targetCode ) throws IOException {
        // Arrange 
        BuffParser parser = createParser(buffCode);
        ParseTree tree = parser.prog();
        String generatedCode = codeGenerator.visit(tree);
        // Act & Assert
        Assertions.assertEquals(targetCode, generatedCode);
    }

    @Test
    public void GeneratedCodeNotEqualToExpectedCode_ShouldPass() throws IOException {
        // Arrange 
        String buffCode = "number foo(number x) = return 2; endf";
        String targetCode = "";
        BuffParser parser = createParser(buffCode);
        ParseTree tree = parser.prog();
        String generatedCode = codeGenerator.visit(tree);
        // Act & Assert
        Assertions.assertNotEquals(targetCode, generatedCode);
    }
    
}
