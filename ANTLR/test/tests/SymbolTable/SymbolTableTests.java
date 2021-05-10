package tests.SymbolTable;

import Compiler.AntlrGenerated.BuffLexer;
import Compiler.ErrorHandling.UnderlineErrorListener;
import Compiler.SymbolTable.SymbolTableGeneratorListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.*;
import tests.Auxiliary.BaseTest;
import tests.Auxiliary.MockErrorListener;
import tests.Auxiliary.TestCase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SymbolTableTests extends BaseTest {
    private SymbolTableGeneratorListener getWalker(ParseTree tree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        SymbolTableGeneratorListener symbolTableGeneratorListener = new SymbolTableGeneratorListener(new MockErrorListener());
        walker.walk(symbolTableGeneratorListener, tree);
        return symbolTableGeneratorListener;
    }

    @Test
    @DisplayName("Check type for 'number func' - given number - is true")
    public void GivenNumberType_ReturnsNumberType() throws IOException {
        // Arrange
        ParseTree tree = createTree("number func() = return 1; endf");
        SymbolTableGeneratorListener symbolTable = getWalker(tree);

        // Act
        int expected = BuffLexer.NUMBERTYPE;
        int actual = symbolTable.globalScope.getSymbol("func").getType();

        // Assert
        assertEquals(expected, actual);
    }
    
}
