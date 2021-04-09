package tests.Auxiliary;

import Compiler.AntlrGenerated.LangLexer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.Auxiliary.TestCase;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the LangTestCase class we created
 */
public class TestTestCase {
    @Test
    @DisplayName("Generate Parser from tokens")
    void  parameterizedFunctionDefinition() throws Exception {
        // Test that LangTestCase.getParserFromTokens() works.
        tests.Auxiliary.TestCase.getParserFromTokens(Arrays.asList(LangLexer.NUMBERTYPE, LangLexer.ID,
                    LangLexer.LPAREN, LangLexer.RPAREN, LangLexer.ASSIGN, LangLexer.RETURN, LangLexer.NUMLITERAL, LangLexer.SEMICOLON,
                    LangLexer.ENDF, LangLexer.EOF));
        
        // If error not thrown test was successful
        assertTrue(true);
    }
}