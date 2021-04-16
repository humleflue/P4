package Compiler.ContextualAnalysis;

import Compiler.AntlrGenerated.CliBaseListener;
import Compiler.AntlrGenerated.CliParser;

public class CliListener extends CliBaseListener {
    private boolean wantsHelp = false;
    private String inputFileName = null;
    private String outfileName = "a";
    private String outFileDefaultType = ".js";

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
        String outfile = ctx.id().ID().getText();

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

    public String getInputFileName() {
        return inputFileName;
    }
}
