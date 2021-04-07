import Compiler.AntlrGenerated.LangLexer;
import Compiler.AntlrGenerated.LangParser;
import Compiler.SymbolTable.SymbolDefListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class tempTest {
    public ParseTree createTree(String test) throws IOException {
        CodePointCharStream stream = CharStreams.fromReader(new StringReader(test));
        LangLexer lexer = new LangLexer(stream);
        var tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);
        ParseTree tree = parser.prog();
        return tree;
    }

    private SymbolDefListener walker(String sourceProg) throws IOException {
        ParseTree tree = createTree(sourceProg);

        ParseTreeWalker walker = new ParseTreeWalker();

        SymbolDefListener symbolDefListener = new SymbolDefListener();
        walker.walk(symbolDefListener, tree);
        return symbolDefListener;
    }

    @Test
    @DisplayName("Check type for 'number func' - given bool - is false")
    public void funcDefWithNumber_GivenNumberType_ReturnsFalse() throws IOException {
        // Arrange
        SymbolDefListener symbolTable = walker("number func() = return 1; endf");

        // Act
        int expected = LangLexer.BOOLTYPE;
        int actual = symbolTable.globalScope.getSymbol("func").getType().getVal();

        // Assert
        assertFalse(expected == actual);
    }

    @Test
    @DisplayName("Check type for 'bool func' - given bool - is true")
    public void funcDefWithBool_GivenBoolType_ReturnsTrue() throws IOException {
        // Arrange
        SymbolDefListener symbolTable = walker("bool func() = return 1; endf");

        // Act
        int expected = LangLexer.BOOLTYPE;
        int actual = symbolTable.globalScope.getSymbol("func").getType().getVal();

        // Assert
        assertEquals(expected, actual);
    }
}
