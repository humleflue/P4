package tests.Auxiliary;

import Compiler.AntlrGenerated.BuffLexer;
import Compiler.AntlrGenerated.BuffParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import java.io.StringReader;

public class BaseTest {
    protected final String testPath = "./Data/";

    protected CodePointCharStream createCharStream(String sourceCode) throws IOException {
        return CharStreams.fromReader(new StringReader(sourceCode));
    }

    protected BuffLexer createLexer(String sourceCode) throws IOException {
        CodePointCharStream stream = createCharStream(sourceCode);
        return new BuffLexer(stream);
    }

    protected CommonTokenStream createCommonTokenStream(String sourceCode) throws IOException {
        BuffLexer lexer = createLexer(sourceCode);
        return new CommonTokenStream(lexer);
    }

    protected BuffParser createParser(String sourceCode) throws IOException {
        CommonTokenStream tokens = createCommonTokenStream(sourceCode);
        return new BuffParser(tokens);
    }

    protected ParseTree createTree(String sourceCode) throws IOException {
        BuffParser parser = createParser(sourceCode);
        return parser.prog();
    }

}
