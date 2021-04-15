package Compiler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class OutputFile {
    private String outputFilePath = "a.js";
    private String targetCode;
    private List<String> argsList;

    OutputFile(String targetCode, String[] args) {
        this.targetCode = targetCode;
        this.argsList = Arrays.asList(args);
        evaluateCommandLineArguments();
    }

    public void execute() throws IOException {
        Files.writeString(Path.of(this.outputFilePath), targetCode);
    }

    private void evaluateCommandLineArguments() {
        if(argsList.contains("-o")) {
            int index = argsList.indexOf("-o");
            outputFilePath = argsList.get(index + 1) + ".js";
        }
    }
}
