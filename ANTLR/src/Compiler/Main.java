package Compiler;

import Compiler.AntlrGenerated.CliLexer;
import Compiler.AntlrGenerated.CliParser;
import Compiler.AntlrGenerated.BuffLexer;
import Compiler.AntlrGenerated.BuffParser;
import Compiler.CodeGeneration.JavaScriptCodeGenerationVisitor;
import Compiler.ContextualAnalysis.CliListener;
import Compiler.SymbolTable.SymbolTableGeneratorListener;
import Compiler.ContextualAnalysis.ReferenceCheckerListener;
import Compiler.ContextualAnalysis.TypeCheckerVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        // Parse command line input
        CharStream stream = CharStreams.fromString(String.join(" ", args));
        CliLexer lexer = new CliLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CliParser parser = new CliParser(tokens);
        ParseTree tree = parser.args();

        ParseTreeWalker walker = new ParseTreeWalker();
        CliListener parsedUserInput = new CliListener();
        walker.walk(parsedUserInput, tree);

        if(parsedUserInput.wantsHelp())
            displayHelp();
        else
            compile(parsedUserInput);
    }

    private static void displayHelp() {
        try {
            System.out.println(Files.readString(Path.of("helpMessage.txt")));
        }
        catch(IOException e) {
            System.out.println("usage: buff <file>");
        }
    }

    private static void compile(CliListener userInput) throws IOException {
        CharStream stream = CharStreams.fromFileName(userInput.getInputFileName());

        try{
            //Error handling
            UnderlineErrorListener errorListener = new UnderlineErrorListener();

            // Syntax analysis
            BuffLexer lexer = new BuffLexer(stream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(errorListener);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BuffParser parser = new BuffParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);
            ParseTree tree = parser.prog();

            // Symbol table generation
            ParseTreeWalker walker = new ParseTreeWalker();
            SymbolTableGeneratorListener symbolTable = new SymbolTableGeneratorListener(errorListener);
            walker.walk(symbolTable, tree);

            // Contextual analysis
            ReferenceCheckerListener referenceChecker =
                    new ReferenceCheckerListener(symbolTable.globalScope, symbolTable.scopes, errorListener);
            walker.walk(referenceChecker, tree);

            TypeCheckerVisitor typeChecker =
                    new TypeCheckerVisitor(symbolTable.globalScope, symbolTable.scopes, errorListener);
            typeChecker.visit(tree);


            // Code generation
            JavaScriptCodeGenerationVisitor codeGenerator = new JavaScriptCodeGenerationVisitor();
            String targetCode = codeGenerator.visit(tree);

            Files.writeString(Path.of(userInput.getOutfileName()), targetCode);

            }catch (Exception e){
                /** Whenever an error is thrown in the BuffErrorListener or ANTLRErrorListener, the user has already been
                 *  given a message explaining the error and nothing more should be done here.
                 */
            }

    }
}
