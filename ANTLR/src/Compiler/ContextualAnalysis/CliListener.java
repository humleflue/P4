package Compiler.ContextualAnalysis;

import Compiler.AntlrGenerated.CliBaseListener;
import Compiler.AntlrGenerated.CliParser;

public class CliListener extends CliBaseListener {
    private final String outFileDefaultType = ".js";
    private boolean wantsHelp = false;
    private String inputFileName = null;
    private String outfileName = "a";

    @Override
    public void enterCompile(CliParser.CompileContext ctx) {
        inputFileName = ctx.INFILENAME().getText();
    }

    @Override
    public void enterHelp(CliParser.HelpContext ctx) {
        wantsHelp = true;
    }

    @Override
    public void enterOptionalOptions(CliParser.OptionalOptionsContext ctx) {
        outfileName = ctx.OUTFILENAME().getText();
    }

    public String getOutfileName() {
        if (outfileName.contains(".")) {
            return outfileName;
        } else {
            return outfileName + outFileDefaultType;
        }
    }

    public boolean wantsHelp() {
        return wantsHelp;
    }

    public String getInputFileName() {
        return inputFileName;
    }
}
