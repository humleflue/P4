package tests;

import Compiler.AntlrGenerated.BuffLexer;
import Compiler.AntlrGenerated.BuffParser;
import Compiler.ErrorHandling.UnderlineErrorListener;
import Compiler.SymbolTable.SymbolTableGeneratorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;


public class temp {
    public ParseTree createTree(String test) throws IOException {
        CodePointCharStream stream = CharStreams.fromReader(new StringReader(test));
        BuffLexer lexer = new BuffLexer(stream);
        var tokens = new CommonTokenStream(lexer);
        BuffParser parser = new BuffParser(tokens);
        return parser.prog();
    }

    private SymbolTableGeneratorListener walker(String sourceProg) throws IOException {
        ParseTree tree = createTree(sourceProg);

        ParseTreeWalker walker = new ParseTreeWalker();

        SymbolTableGeneratorListener symbolTableGeneratorListener = new SymbolTableGeneratorListener(new UnderlineErrorListener());
        walker.walk(symbolTableGeneratorListener, tree);
        return symbolTableGeneratorListener;
    }

    @Test
    @DisplayName("Check type for 'number func' - given bool - is false")
    public void funcDefWithNumber_GivenNumberType_ReturnsFalse() throws IOException {
        // Arrange
        SymbolTableGeneratorListener symbolTable = walker("number func() = return 1; end");

        // Act
        int expected = BuffLexer.BOOLTYPE;
        int actual = symbolTable.globalScope.getSymbol("func").getType();

        // Assert
        assertNotEquals(expected, actual);
    }

    @Test
    @DisplayName("Check type for 'bool func' - given bool - is true")
    public void funcDefWithBool_GivenBoolType_ReturnsTrue() throws IOException {
        // Arrange
        SymbolTableGeneratorListener symbolTable = walker("boolean func() = return 1; end");

        // Act
        int expected = BuffLexer.BOOLTYPE;
        int actual = symbolTable.globalScope.getSymbol("func").getType();

        // Assert
        assertEquals(expected, actual);
    }
}
