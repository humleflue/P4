package tests.SymbolTable;

import Compiler.AntlrGenerated.BuffLexer;
import Compiler.SymbolTable.SymbolTableGeneratorListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.*;
import tests.Auxiliary.TestCase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * DENNE FIL ER IKKE KLAR TIL REVIEW ENDNU!
 */

public class SymbolTableTests {
    private SymbolTableGeneratorListener getWalker(ParseTree tree) {
        ParseTreeWalker walker = new ParseTreeWalker();

        SymbolTableGeneratorListener symbolTableGeneratorListener = new SymbolTableGeneratorListener();
        walker.walk(symbolTableGeneratorListener, tree);
        return symbolTableGeneratorListener;
    }

    @Test
    @DisplayName("Check type for 'number func' - given number - is true")
    public void GivenNumberType_ReturnsNumberType() throws IOException {
        // Arrange
        ParseTree tree = TestCase.createTree("number func() = return 1; endf");
        SymbolTableGeneratorListener symbolTable = getWalker(tree);

        // Act
        int expected = BuffLexer.NUMBERTYPE;
        int actual = symbolTable.globalScope.getSymbol("func").getType();

        // Assert
        assertEquals(expected, actual);
    }

    /* Work in progress...
    @Test
    @DisplayName("Check scopes'")
    public void scopeCheck() throws IOException {
        // Arrange
        ParseTree tree = createTree("number func() = func2(); endf");
        SymbolDefListener symbolTable = walker(tree);

        // Act
        int expected = BuffLexer.NUMBERTYPE;
        //Type func = symbolTable.globalScope.getSymbol("func").getType()
        //symbolTable.
        // Assert
        System.out.println("test");
        assertEquals(expected, true);
    }
    */
}
