package tests.Auxiliary;

import Compiler.AntlrGenerated.BuffLexer;
import Compiler.AntlrGenerated.BuffParser;
import Compiler.ErrorHandling.UnderlineErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.StringReader;

public class BaseTest {
    protected final String testPath = "./Data/";
    UnderlineErrorListener errorListener = new UnderlineErrorListener();


    protected CodePointCharStream createCharStream(String sourceCode) {
        try {
            return CharStreams.fromReader(new StringReader(sourceCode));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // Something has to be returned.
            return null;
        }
    }

    protected BuffLexer createLexer(String sourceCode) {
        CodePointCharStream stream = createCharStream(sourceCode);
        return new BuffLexer(stream);
    }

    protected CommonTokenStream createCommonTokenStream(String sourceCode) {
        BuffLexer lexer = createLexer(sourceCode);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        return new CommonTokenStream(lexer);
    }

    protected BuffParser createParser(String sourceCode) {
        CommonTokenStream tokens = createCommonTokenStream(sourceCode);
        return new BuffParser(tokens);
    }

    protected ParseTree createTree(String sourceCode) {
        BuffParser parser = createParser(sourceCode);
        parser.addErrorListener(errorListener);
        return parser.prog();
    }

    protected int getNumberOfSyntaxErrors(String sourceCode) {
        BuffParser parser = createParser(sourceCode);
        parser.prog();
        return parser.getNumberOfSyntaxErrors();
    }

}
