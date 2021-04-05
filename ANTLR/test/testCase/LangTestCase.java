package testCase;//package Compiler.TestCase;
// import Compiler.TestCase.LangTestCase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Compiler.AntlrGenerated.LangLexer;
import Compiler.AntlrGenerated.LangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.*;

public class LangTestCase {
    public String test;
    public List<Integer> lexerTokens = new ArrayList<>();
    public String lexerTokensStr = null;
    public Boolean shouldPass = null;

    // Colors used for System.out text
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";
    private final String RED = "\u001B[31m";
    private final String GRAY = "\u001B[37m";
    private final String RESET = "\u001B[0m";

    // Used to capture Error output
    private ByteArrayOutputStream baos;
    private PrintStream old;

    public LangTestCase(String test, Boolean shouldPass) {
        this.test = test;
        this.shouldPass = shouldPass;
    }

    // Lexer values are enums and are therefor integers.
    public LangTestCase(String test, List<Integer> lexerValues){
        this.test = test;
        this.lexerTokens = lexerValues;
        this.lexerTokensStr = "";

        // Convert Lexer tokens to user readable string
        for (int tokenEnum : lexerTokens) {
            this.lexerTokensStr += "<" + LangLexer.VOCABULARY.getSymbolicName(tokenEnum) + "> ";
        }

        // Remove last space
        this.lexerTokensStr.replaceFirst(".$","");
    }

    // Copied from: https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
    // Captures output insted of sending it to stdout. This is used for propper formatting of errors.
    private void CaptureStdout(){
        // Create a stream to hold the output
        baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // IMPORTANT: Save the old System.out!
        old = System.err;
        // Tell Java to use your special stream
        System.setErr(ps);
    }

    // Copied from: https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
    private String SaveAndFlushCaptureStdout(){
        // Put things back
        System.out.flush();
        System.setErr(old);
        return baos.toString();
    }

    public boolean test() throws IOException
    {
        boolean testCaseSuccess = true;
        CommonTokenStream tokens = null;

        CaptureStdout();

        try{
            CodePointCharStream stream = CharStreams.fromReader(new StringReader(this.test));
            LangLexer lexer = new LangLexer(stream);
            tokens = new CommonTokenStream(lexer);
            LangParser parser = new LangParser(tokens);
            ParseTree tree = parser.code();
            /*Node ast = new BuildASTVisitor().visit(tree);*/
        }
        catch (Exception exception){
            errorOccurred("Antlr error occured", this, new String[]{exception.getMessage()});
            testCaseSuccess = false;
        }

        SaveAndFlushCaptureStdout();

        if (this.lexerTokens.isEmpty() == false){
            testCaseSuccess = lexerTokensValidation(tokens);
        }
        else if (this.shouldPass != null && this.shouldPass != baos.toString().isEmpty()){
            errorOccurred((this.shouldPass) ? "Failed but should succeed"
                                            : "Succeeded but should fail",
                                    this, new String[]{});
            testCaseSuccess = false;
        }

        return testCaseSuccess;
    }

    private boolean lexerTokensValidation(CommonTokenStream tokens){
        int tokenNumb = 0;
        String actualLexerTokenStr = "";
        boolean doesMatch = true;
        boolean outOfRange = false;

        for (Token token : tokens.getTokens()){
            if (this.lexerTokens.size() <= tokenNumb)
                outOfRange = true;
            else if (token.getType() != this.lexerTokens.get(tokenNumb))
                doesMatch = false;
            actualLexerTokenStr += "<" + LangLexer.VOCABULARY.getSymbolicName(token.getType()) + "> ";
            tokenNumb++;
        }

        // Remove last space
        actualLexerTokenStr.replaceFirst(".$","");

        if (outOfRange == true){
            errorOccurred("Pass failed because expected token stream and actual token stream did not have the same size",
                    this, new String[]{"Size of actual token stream:   " + tokens.getTokens().size() + tokens.get(7).getText(),
                            "Size of expected token stream: " + this.lexerTokens.size(),
                            "Expected Token Stream: " + this.lexerTokensStr,
                            "Actual Token Stream:   " + actualLexerTokenStr});
            return false;
        }
        else if (doesMatch == false){
            errorOccurred("Pass failed because expected token stream and actual token stream did not match",
                    this, new String[]{"Expected Token Stream: " + this.lexerTokensStr,
                            "Actual Token Stream:   " + actualLexerTokenStr});
            return false;
        }
        return true;
    }

    private void errorOccurred(String description, LangTestCase langTestCase, String[] points){
        printTestResult(description, langTestCase, points);
    }

    // points are further information descriping the problem.
    private void printTestResult(String description, LangTestCase langTestCase, String[] points){
        String[] antlrErrors = baos.toString().split("\n");
        String[] testInput = langTestCase.test.split("\n");

        testInput = addRedColorsToTestInput(testInput, antlrErrors);

        System.out.println(YELLOW + description);

        int lineNumber = 1;
        System.out.println("\t---------- Test Input ----------");
        for (String test : testInput){
            System.out.println(GRAY + lineNumber + YELLOW + "\t" + test);
            lineNumber++;
        }
        System.out.println("\t--------------------------------");

        // Futher information describing the problem
        for (String point : points) {
            for (String line : point.split("\n")){
                System.out.println("\t" + line);
            }
        }

        // Print saved output from Lexer, or other antlr errors.
        for (String line : antlrErrors){
            System.out.println("\t" + line);
        }

        System.out.println(RESET);
    }

    private String[] addRedColorsToTestInput(String[] testInput, String[] antlrErrors){
        Pattern inputPattern = Pattern.compile("line ([\\d]+):([\\d]+).*input '([^']+)'");
        Matcher matcher;
        int lineNumber, position;
        String mismatchedString, testInputLine;

        for (String line : antlrErrors){
            matcher = inputPattern.matcher(line);
            // Finds first result
            if (matcher.find()) {
                lineNumber = Integer.parseInt(matcher.group(1));
                position = Integer.parseInt(matcher.group(2));
                mismatchedString = matcher.group(3);
                testInputLine = testInput[lineNumber-1];

                testInput[lineNumber-1] = testInputLine.substring(0, position) +
                                          RED + mismatchedString +
                                          YELLOW + testInputLine.substring(position + mismatchedString.length());
            }
        }
        return testInput;
    }
}