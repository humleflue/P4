package tests.Auxiliary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Compiler.AntlrGenerated.BuffLexer;
import Compiler.AntlrGenerated.BuffParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.*;

/**
 * Class holding test data for testing of parser and lexer, and the {@link #test()}, method for executing the test.
 *
 * Use constructor <code>testCase(String test, Boolean shouldPass)</code> to test
 * if input program is passed successfully my ANTLER parser.
 *
 * Use constructor <code>testCase(String test, List<Integer> lexerValues)</code> to test
 * if input program produce ANTLER lexer tokens matching provided list of ANTLER tokens.
 * An ANTLER token is etc. <code>BuffLexer.NUMBERTYPE</code>.
 */
public class TestCase {
    public String test;
    public List<Integer> lexerTokens = new ArrayList<>();
    public String lexerTokensStr = null;
    public Boolean shouldPass = null;

    private boolean tokensOutOfRange;
    private boolean tokensDoesMatch;

    // Colors used for System.out text
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";
    private final String RED = "\u001B[31m";
    private final String RED_SPACE = "\u001B[41m \u001B[49m";
    private final String GRAY = "\u001B[37m";
    private final String RESET = "\u001B[0m";

    // Contains errors from ANTLER
    private ByteArrayOutputStream capturedErrorOutput;

    /**
     *  Tests case for checking input program is parsed by ANTLER parser
     * @param test          Test input as a String
     * @param shouldPass    <code>true</code> if test should pass, and <code>false</code> if test should fail
     */
    public TestCase(String test, Boolean shouldPass) {
        this.test = test;
        this.shouldPass = shouldPass;
    }

    /**
     * Test case for checking input program produce ANTLER lexer tokens matching provided list of ANTLER tokens
     * @param test          Test input program as a String
     * @param lexerValues   List of Lexer Tokens denoted by etc. <code>BuffLexer.NUMBERTYPE</code> (enum)
     */
    // Lexer values are enums and are therefor integers.
    public TestCase(String test, List<Integer> lexerValues){
        this.test = test;
        this.lexerTokens = lexerValues;

        StringBuilder lexerTokensStringBuilder = new StringBuilder();
        // Convert Lexer tokens to user readable string
        for (int tokenEnum : lexerTokens) {
            lexerTokensStringBuilder.append("<")
                                    .append(BuffLexer.VOCABULARY.getSymbolicName(tokenEnum))
                                    .append("> ");
        }

        // Remove last space
        this.lexerTokensStr = lexerTokensStringBuilder.toString().replaceFirst(".$","");
    }

    /**
     *  Captures output instead of sending it to error output. This is used for proper formatting of errors.
     */
    private void captureErrOut(){
        // Makes sure all output is out of the buffer.
        System.err.flush();
        
        // This variable is used to read errors from, by using .toString();
        capturedErrorOutput = new ByteArrayOutputStream();
        
        // Sets the error output to go to 'capturedErrorOutput' instead of the console.
        System.setErr(new PrintStream(capturedErrorOutput));
    }

    /**
     * @return returns captured error output
     */
    private String stopCapturingErrOut(){
        System.err.flush();
        
        // Set errors to go to console again.
        System.setErr(System.out);
        
        return capturedErrorOutput.toString();
    }

    /**
     * Runs this test.
     * @return <code>true</code> for pass and <code>false</code> for failure.
     */
    public boolean test()
    {
        boolean testCaseSuccess = true;
        CommonTokenStream tokens = null;

        // Capture error from ANTLER and don't send them to System.out yet.
        captureErrOut();

        try{
            tokens = compileProg();
        }
        catch (Exception exception){
            errorOccurred("Fatal ANTLER error occurred", this, new String[]{exception.getMessage()});
            testCaseSuccess = false;
        }

        // Stop capturing ANTLER errors and save them to class variable 'baos'
        stopCapturingErrOut();

        if (this.lexerTokens.isEmpty() == false){
            assert tokens != null;
            testCaseSuccess = lexerTokensValidation(tokens);
        }
        // If test should pass and error occurred OR test passed but should fail
        else if (this.shouldPass != null && this.shouldPass != capturedErrorOutput.toString().isEmpty()){
            errorOccurred((this.shouldPass) ? "Failed but should succeed"
                                            : "Succeeded but should fail",
                                    this, new String[]{});
            testCaseSuccess = false;
        }

        return testCaseSuccess;
    }

    private CommonTokenStream compileProg() throws IOException {
        CommonTokenStream tokens;

        CodePointCharStream stream = CharStreams.fromReader(new StringReader(this.test));
        BuffLexer lexer = new BuffLexer(stream);
        tokens = new CommonTokenStream(lexer);
        BuffParser parser = new BuffParser(tokens);
        ParseTree tree = parser.code();

        return tokens;
    }

    private boolean lexerTokensValidation(CommonTokenStream tokens){
        boolean testSuccess = false;
        String actualLexerTokenStr = checkAndPrettyPrintTokens(tokens.getTokens());

        if (tokensOutOfRange == true)
            errorOccurred("Pass failed because expected token stream and actual token stream did not have the same size",
                    this, new String[]{"Size of actual token stream:   " + tokens.getTokens().size() + tokens.get(7).getText(),
                            "Size of expected token stream: " + this.lexerTokens.size(),
                            "Expected Token Stream: " + this.lexerTokensStr,
                            "Actual Token Stream:   " + actualLexerTokenStr});
        else if (tokensDoesMatch == false)
            errorOccurred("Pass failed because expected token stream and actual token stream did not match and/or wrong grammar",
                    this, new String[]{"Expected Token Stream: " + this.lexerTokensStr,
                            "Actual Token Stream:   " + actualLexerTokenStr});
        else
            testSuccess = true;

        return testSuccess;
    }

    public String checkAndPrettyPrintTokens(List<Token> tokens){
        int tokenNumb = 0;
        tokensDoesMatch = true;
        tokensOutOfRange = false;
        StringBuilder prettyPrintedTokens = new StringBuilder();

        for (Token token : tokens){
            if (this.lexerTokens.size() <= tokenNumb)
                tokensOutOfRange = true;
            else if (token.getType() != this.lexerTokens.get(tokenNumb))
                tokensDoesMatch = false;

            prettyPrintedTokens.append("<")
                               .append(BuffLexer.VOCABULARY.getSymbolicName(token.getType()))
                               .append("> ");
            tokenNumb++;
        }

        // Remove last space
        return prettyPrintedTokens.toString().replaceFirst(".$","");
    }

    /**
     * Handle Error. See {@link #printTestResult(String, TestCase, String[])} for more details.
     */
    private void errorOccurred(String description, TestCase testCase, String[] points){
        printTestResult(description, testCase, points);
    }

    /**
     * Prints test results
     * @param description   Short description describing the problem
     * @param testCase  The test program input as String
     * @param points        Further information about the problem (string array)
     */
    private void printTestResult(String description, TestCase testCase, String[] points){
        String[] antlrErrors = capturedErrorOutput.toString().split("\n");
        String[] testInput = testCase.test.split("\n");

        // Add ANTLER errors if any exist
        if (capturedErrorOutput.toString().isEmpty() == false)
            testInput = addRedColorsToTestInput(testInput, antlrErrors);

        System.out.println(YELLOW + description);

        int lineNumber = 1;
        System.out.println("\t---------- Test Input ----------");
        for (String test : testInput){
            System.out.println(GRAY + lineNumber + YELLOW + "\t" + test);
            lineNumber++;
        }
        System.out.println("\t--------------------------------");

        // Further information describing the problem
        for (String point : points) {
            for (String line : point.split("\n")){
                System.out.println("\t" + line);
            }
        }

        // Print saved output from parser, or other antlr errors.
        for (String line : antlrErrors){
            System.out.println("\t" + line);
        }

        System.out.println(RESET);
    }

    /**
     * Reads ANTLER test errors and turns test Input red according to the errors.
     * @return String formatted with red colors at error positions.
     */
    private String[] addRedColorsToTestInput(String[] testInput, String[] antlrErrors){
        // Extract data about error.
        // Data: linenumber (group 1), position of char (group 2) and length of error (group 4).
        Pattern inputPattern = Pattern.compile("line ([\\d]+):([\\d]+).*(input|at:?) '([^']+)'");
        Matcher matcher;

        for (String line : antlrErrors){
            matcher = inputPattern.matcher(line);
            // Matches RegEx and finds first result.
            if (matcher.find())
                testInput = addRedColorError(matcher, testInput);
            else
                throw new IndexOutOfBoundsException("Could not understand ANTLER error:\n\t".concat(line));
        }
        return testInput;
    }

    private int errorPrevLineNumber = -1;
    private int errorLineNumber = -1;
    private int skipChars;

    private String[] addRedColorError(Matcher matcher, String[] testInput){
        String mismatchedString;
        errorPrevLineNumber = errorLineNumber;
        errorLineNumber = Integer.parseInt(matcher.group(1));
        int errorPosition = Integer.parseInt(matcher.group(2));
        int errorTestInputLength = matcher.group(4).length();
        String testInputLine = testInput[errorLineNumber-1];

        // Skip UTF8 color chars then there are multiple errors on same line.
        if (errorLineNumber != errorPrevLineNumber)
            skipChars = 0;
        errorPosition += skipChars;

        // Catch 'mismatchedString' being out of bound.
        // This should only happen then it matches something at string end etc. missing <EOF>
        try {
            // Get input line from test case input program
            mismatchedString = testInputLine.substring(errorPosition, errorPosition + errorTestInputLength);

            testInput[errorLineNumber-1] = testInputLine.substring(0, errorPosition) +
                    RED + mismatchedString +
                    YELLOW + testInputLine.substring(errorPosition + errorTestInputLength);
            skipChars += RED.length() + YELLOW.length();
        }
        catch (StringIndexOutOfBoundsException e){
            // Add space with red background to end of line
            testInput[errorLineNumber-1] += RED_SPACE;
            skipChars += RED_SPACE.length();
        }

        return testInput;
    }

    /**
     * Converts list of tokens represented by integers to a parser.
     * @param tokensAsIntegers List of tokens represented by integers. Use <code>BuffLexer.INSERT_TYPE_HERE</code> to get integer.
     * @return A ANTLER parser
     */
    static public BuffParser getParserFromTokens(List<Integer> tokensAsIntegers) {
        List<CommonToken> commonTokens = new ArrayList<CommonToken>();
        for (int i : tokensAsIntegers){
            commonTokens.add(new CommonToken(i));
        }

        ListTokenSource ts = new ListTokenSource(commonTokens);

        CommonTokenStream tokens = new CommonTokenStream(ts);

        return new BuffParser(tokens);
    }
    
}
