package Compiler.ContextualAnalysis;

import Compiler.AntlrGenerated.CliBaseListener;
import Compiler.AntlrGenerated.CliParser;

public class CliListener extends CliBaseListener {
    private boolean wantsHelp = false;
    private String inputFileName = null;
    private String outfileName = "a";
    private final String outFileDefaultType = ".js";

    @Override
    public void enterCompile(CliParser.CompileContext ctx) {
        String fileName = ctx.id().ID().getText();
        String suffix = ctx.SUFFIX().getText();
        inputFileName = fileName + suffix;

    }

    @Override
    public void enterHelp(CliParser.HelpContext ctx) {
        wantsHelp = true;
    }

    @Override
    public void enterOutfile(CliParser.OutfileContext ctx) {
        outfileName = ctx.id().ID().getText();
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
