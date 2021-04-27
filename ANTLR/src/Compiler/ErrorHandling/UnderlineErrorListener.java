package Compiler.ErrorHandling;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * An error listener that can be used by both ANTLR generated components as the parser and lexer
 * and custom listeners/visitors to print out underlined error messages to the console.sssssd
 */
public class UnderlineErrorListener extends BaseErrorListener implements BuffErrorListener {

    /**
     * Contains information about a line that caused an error, allows easy printing to console.
     */
    private class LineWithError {
        String line;
        Integer lineNumber;
        ArrayList<Interval> errorIntervals = new ArrayList<Interval>();

        public LineWithError(String line, Integer lineNumber){
            this.line = line;
            this.lineNumber = lineNumber;
        }

        /**
         * Adds the interval of a token to the errorIntervals list
         * @param token The token that should be added
         */
        public void addTokenToInterval(Token token) {
            int tokenStartPos = token.getCharPositionInLine();
            int tokenEndpos = tokenStartPos + token.getText().length() - 1;

            this.errorIntervals.add(new Interval(tokenStartPos, tokenEndpos));
        }

    }

    /**
     * Called by the parser whenever an error is found. Should not be used by us
     */
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) throws ParseCancellationException
    {
        //Gets the specific line that the error occurred on.
        CommonTokenStream tokens = (CommonTokenStream)recognizer.getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        String[] lines = input.split("\n");
        String errorLine = lines[line - 1];

        //Gets the token that caused the error. Gets parsed from Object to token to get position
        Token offendingToken = (Token)offendingSymbol;
        Interval offendingTokenInterval = new Interval(offendingToken.getStartIndex(), offendingToken.getStopIndex());

        ThrowError(msg, offendingToken);
    }

    /**
     * Throws a ParseCancellationException and prints the lines that caused the error with the offending tokens highlighted.
     * @param errorMsg Message that explains the cause of the error
     * @param offendingTokens The list of tokens which will be underlined
     */
    public void ThrowError(String errorMsg, ArrayList<Token> offendingTokens) {
        //Gets the source code line in which the error occurred.
        ArrayList<LineWithError> errorLines = GetLineWithErrorArray(offendingTokens);

        //Sorts the lines so that they are printed in the same order as in the source code.
        errorLines.sort(Comparator.comparingInt(x -> x.lineNumber));
        errorLines.forEach(errorLine -> errorLine.errorIntervals.sort(Comparator.comparingInt(x -> x.a)));

        printRed(errorMsg);
        System.out.println("\n--------------------");
        for (LineWithError lineWithError : errorLines) {
            PrintUnderlinedError(lineWithError);
        }

        throw new ParseCancellationException("Error");
    }

    /**
     *  An auxiliary function that simplifies calling ThrowUnderlinedError() without making a List
     * @param errorMsg Message that explains the cause of the error
     * @param offendingToken A tokens which will be underlined
     * @param additionalOffendingTokens The additional tokens which will be underlined
     */
    public void ThrowError(String errorMsg, Token offendingToken, Token... additionalOffendingTokens) {
        ArrayList<Token> allOffendingTokens = new ArrayList<Token>();
        allOffendingTokens.add(offendingToken);

        for (Token token : additionalOffendingTokens){
            allOffendingTokens.add(token);
        }

        ThrowError(errorMsg, allOffendingTokens);
    }

    /**
     * Converts a list of tokens to a list of LineWithError's. Checks whether or not offending tokens are on the same line.
     * @param offendingTokens A tokens which will be underlined
     * @return An ArrayList of LineWithError.
     */
    private ArrayList<LineWithError> GetLineWithErrorArray(ArrayList<Token> offendingTokens) {
        ArrayList<LineWithError> errorLines = new ArrayList<LineWithError>();

        for (Token offendingToken : offendingTokens) {
            int lineNumber = offendingToken.getLine();

            //Checks whether or not an existing offending token is present in a line.
            LineWithError errorLine = null;
            for (LineWithError line : errorLines){
                if (line.lineNumber == lineNumber){
                    errorLine = line;
                }
            }

            if (errorLine == null){
                //Gets the source code for the line in which the offending token occurred
                String line = offendingToken.getInputStream().toString().split("\n")[lineNumber - 1];
                LineWithError lineWithError = new LineWithError(line, lineNumber);
                lineWithError.addTokenToInterval(offendingToken);
                errorLines.add(lineWithError);
            }
            else {
                errorLine.addTokenToInterval(offendingToken);
            }
        }
        return errorLines;
    }

    /**
     * Prints a line of source code, the line number and hightligts the offending tokens
     * @param lineWithError The line that should be printed
     */
    private void PrintUnderlinedError(LineWithError lineWithError) {
        System.out.println("At line " + lineWithError.lineNumber + ":\n");
        System.out.println(lineWithError.line);
        printUnderlinedIntervals(lineWithError.errorIntervals);
    }

    /**
     * Prints out the "^" symbol under offending tokens
     * @param offendingTokenInterval
     */
    private void printUnderlinedIntervals(ArrayList<Interval> offendingTokenInterval) {
        int printPos = 0;

        for (Interval interval : offendingTokenInterval){
            if (printPos < interval.a) {
                System.out.print(" ".repeat(interval.a - printPos));
                printPos = interval.a;
            }
            if ( interval.a >= 0 && interval.b >= 0) {
                printRed("^".repeat(interval.b - interval.a + 1));
                printPos += interval.b - interval.a + 1;
            }
        }
        System.out.println("\n--------------------");

    }

    /**
     * Prints a message in a red color. Works in most terminals but not cmd :(
     * @param msg The message that sould be printed red
     */
    private void printRed(String msg) {
        System.out.print("\u001b[31m" + msg +  "\u001b[0m");
    }
}