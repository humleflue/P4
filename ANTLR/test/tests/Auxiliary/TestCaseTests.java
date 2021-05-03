package tests.Auxiliary;

import Compiler.AntlrGenerated.BuffLexer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.Auxiliary.TestCase;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the LangTestCase class we created
 */
public class TestCaseTests {
    @Test
    @DisplayName("Generate Parser from tokens")
    void  parameterizedFunctionDefinition() throws Exception {
        // Test that LangTestCase.getParserFromTokens() works.
        tests.Auxiliary.TestCase.getParserFromTokens(Arrays.asList(BuffLexer.NUMTYPE, BuffLexer.ID,
                    BuffLexer.LPAREN, BuffLexer.RPAREN, BuffLexer.ASSIGN, BuffLexer.RETURN, BuffLexer.NUMLITERAL, BuffLexer.SEMICOLON,
                    BuffLexer.END, BuffLexer.EOF));
        
        // If error not thrown test was successful
        assertTrue(true);
    }
}
