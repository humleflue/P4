import Buff.*;
import Buff.Nodes.Abstract.Node;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.StringReader;

public class CheckSymbols {
    public static void main(String[] args) throws IOException {
        CharStream stream = CharStreams.fromFileName("test.lang");
        Buff_1_1Lexer lexer = new Buff_1_1Lexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Buff_1_1Parser parser = new Buff_1_1Parser(tokens);

        ParseTree tree = parser.start();
        System.out.println("building cst");
        System.out.println(tree.getText());

        SymbolDefListener symbolDefListener = new SymbolDefListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(symbolDefListener, tree);

        SymbolRefListener symbolRefListener = new SymbolRefListener(symbolDefListener.globalScope, symbolDefListener.scopes);
        walker.walk(symbolRefListener, tree);
    }
}
