import Compiler.AntlrGenerated.LangLexer;
import Compiler.AntlrGenerated.LangParser;
import Compiler.SymbolTable.SymbolDefListener;
import Compiler.SymbolTable.SymbolRefListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSymboltable {

    public ParseTree createTree(String test) throws IOException {
        CodePointCharStream stream = CharStreams.fromReader(new StringReader(test));
        LangLexer lexer = new LangLexer(stream);
        var tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);
        ParseTree tree = parser.prog();
        return tree;
    }

    private SymbolDefListener walker(ParseTree tree) throws IOException {
        ParseTreeWalker walker = new ParseTreeWalker();

        SymbolDefListener symbolDefListener = new SymbolDefListener();
        walker.walk(symbolDefListener, tree);
        return symbolDefListener;
    }

    @Test
    @DisplayName("Check type for 'number func' - given number - is true")
    public void funcDef_GivenNumberType_ReturnsNumberType() throws IOException {
        // Arrange
        ParseTree tree = createTree("number func() = return 1; endf");
        SymbolDefListener symbolTable = walker(tree);

        // Act
        int expected = LangLexer.NUMBERTYPE;
        int actual = symbolTable.globalScope.getSymbol("func").getType().getVal();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check scopes'")
    public void scopeCheck() throws IOException {
        // Arrange
        ParseTree tree = createTree("number func() = func2(); endf");
        SymbolDefListener symbolTable = walker(tree);

        // Act
        int expected = LangLexer.NUMBERTYPE;
        //Type func = symbolTable.globalScope.getSymbol("func").getType()
        //symbolTable.
        // Assert
        System.out.println("test");
        assertEquals(expected, true);
    }
}
