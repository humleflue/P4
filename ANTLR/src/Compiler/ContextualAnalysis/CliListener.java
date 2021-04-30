package Compiler.ContextualAnalysis;

import Compiler.AntlrGenerated.CliBaseListener;
import Compiler.AntlrGenerated.CliParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CliListener extends CliBaseListener {
    private boolean wantsHelp = false;
    private String inFileName = null;
    private String outfileName = "a";
    private String outFileDefaultType = ".js";
    private CharStream charStream = null;

    @Override
    public void enterCompile(CliParser.CompileContext ctx) {
        String fileName = ctx.ID().getText();
        String suffix = ctx.SUFFIX().getText();
        inFileName = fileName + suffix;

    }

    @Override
    public void enterHelp(CliParser.HelpContext ctx) {
        wantsHelp = true;
    }

    @Override
    public void enterOutfile(CliParser.OutfileContext ctx) {
        String outfile = ctx.ID().getText();

        if(outfile.contains(".")) {
            outfileName = outfile;
        }
        else {
            outfileName = outfile + outFileDefaultType;
        }
    }

    public String getOutfileName() {
        return outfileName;
    }

    public boolean wantsHelp() {
        return wantsHelp;
    }

    public String getInFileName() {
        return inFileName;
    }

    public CharStream getCharStream() {
        if(this.charStream == null) {
            try {
                // Load libraries
                // Add libraries to this string by concatenating
                String libraries = Files.readString(Path.of("mathlib.buff"));

                // Load libraries after source code to keep correct line count.
                String sourceCode = Files.readString(Path.of(inFileName));
                this.charStream = CharStreams.fromString(sourceCode + libraries);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return charStream;
    }
}
