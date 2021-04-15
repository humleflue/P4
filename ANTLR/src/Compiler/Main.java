package Compiler;

import Compiler.AntlrGenerated.LangLexer;
import Compiler.AntlrGenerated.LangParser;
import Compiler.CodeGeneration.JavaScriptCodeGenerationVisitor;
import Compiler.SymbolTable.SymbolTableGeneratorListener;
import Compiler.ContextualAnalysis.ReferenceCheckerListener;
import Compiler.ContextualAnalysis.TypeCheckerVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        if(args.length < 1)
            throw new IOException("You must provide the filepath to the file you wish to compile.");
        else if(!args[0].endsWith(".buff"))
            throw new IOException("Filename must have the suffix: '.buff'.");

        CharStream stream = CharStreams.fromFileName(args[0]);

        // Syntax analysis
        LangLexer lexer = new LangLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);
        ParseTree tree = parser.prog();

        // Symbol table generation
        ParseTreeWalker walker = new ParseTreeWalker();
        SymbolTableGeneratorListener symbolTable = new SymbolTableGeneratorListener();
        walker.walk(symbolTable, tree);


        // Contextual analysis
        ReferenceCheckerListener referenceChecker = new ReferenceCheckerListener(symbolTable.globalScope, symbolTable.scopes);
        walker.walk(referenceChecker, tree);

        TypeCheckerVisitor typeChecker = new TypeCheckerVisitor(symbolTable.globalScope, symbolTable.scopes);
        typeChecker.visit(tree);


        // Code generation
        JavaScriptCodeGenerationVisitor codeGenerator = new JavaScriptCodeGenerationVisitor();
        String targetCode = codeGenerator.visit(tree);

        OutputFile output = new OutputFile(targetCode, args);
        output.execute();
    }
}
