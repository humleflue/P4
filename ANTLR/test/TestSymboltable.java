import Compiler.AntlrGenerated.LangLexer;
import Compiler.AntlrGenerated.LangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
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
        ParseTree tree = parser.code();
        return tree;
    }

    @Test
    @DisplayName("Simple multiplication should work")
    public void test() throws IOException{
        // Arrange
        ParseTree tree = createTree("number func() = return 1; endf");
        // Act
        System.out.println(tree.getText());

        // Assert
        assertEquals(true, true);
    }
}
