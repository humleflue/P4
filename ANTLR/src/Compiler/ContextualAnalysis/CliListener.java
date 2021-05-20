package Compiler.ContextualAnalysis;

import Compiler.AntlrGenerated.CliBaseListener;
import Compiler.AntlrGenerated.CliParser;

public class CliListener extends CliBaseListener {
    private final String outFileDefaultType = ".js";
    private boolean wantsHelp = false;
    private String inputFileName = null;
    private String outfileName = "a";

    /**
     * Starts the compilation of the tree
     * @param ctx The node from where the compilation should start
     */
    @Override
    public void enterCompile(CliParser.CompileContext ctx) {
        inputFileName = ctx.INFILENAME().getText();
    }

    /**
     * Determines whether or not the user has typed the -help option
     * @param ctx The node in question
     */
    @Override
    public void enterHelp(CliParser.HelpContext ctx) {
        wantsHelp = true;
    }

    /**
     * Gets the filename if specified
     * @param ctx The node in question
     */
    @Override
    public void enterOptionalOptions(CliParser.OptionalOptionsContext ctx) {
        outfileName = ctx.OUTFILENAME().getText();
    }

    /**
     * Gets the filetype
     * @return the file signature
     */
    public String getOutfileName() {
        if (outfileName.contains(".")) {
            return outfileName;
        } else {
            return outfileName + outFileDefaultType;
        }
    }

    /**
     * Getter method which determines if the user has asked for help
     * @return The boolean 'wantsHelp'
     */
    public boolean wantsHelp() {
        return wantsHelp;
    }

    /**
     *
     * @return The string 'inputFileName'
     */
    public String getInputFileName() {
        return inputFileName;
    }
}
