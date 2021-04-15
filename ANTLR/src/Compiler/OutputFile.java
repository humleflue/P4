package Compiler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * This class has the responsibility of generating an output file for the user.
 */
public class OutputFile {
    private String outputFilePath = "a.js";
    private String targetCode;
    private List<String> args;

    /**
     * OutputFile constructor.
     * @param targetCode The target code in String format.
     * @param args The command line arguments provided by the user.
     */
    OutputFile(String targetCode, String[] args) {
        this.targetCode = targetCode;
        this.args = Arrays.asList(args);
        parseCommandLineArguments();
    }

    /**
     * Parses and evaluates the command line arguments provided by the user.
     * WARNING! This method should not ever throw an exception, as it is called from the constructor!
     * Instead; create a new method, which can be executed by the caller.
     */
    private void parseCommandLineArguments() {
        if(args.contains("-o")) {
            int index = args.indexOf("-o");
            outputFilePath = args.get(index + 1) + ".js";
        }
    }

    /**
     * Writes the content of {@link OutputFile#targetCode} field variable to the {@link OutputFile#outputFilePath}.
     * @throws IOException
     */
    public void execute() throws IOException {
        Files.writeString(Path.of(this.outputFilePath), targetCode);
    }
}
