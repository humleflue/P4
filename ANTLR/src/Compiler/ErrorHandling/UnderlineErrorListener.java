package Compiler.ErrorHandling;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class UnderlineErrorListener extends BaseErrorListener {
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

        GeneralError(msg, errorLine, line, offendingToken.getStartIndex(), offendingToken.getStopIndex());
    }

    /**
     * Stops the compiler and prints out an error message with the line, line number and position of the error origin.
     *
     * @param errorMsg The text explaining what caused the error
     * @param line The source code line in which the error occurred
     * @param lineNumber The line number for the line in which the error occurred
     * @param badTokenStartPos The number for the first char in the token that caused the error
     * @param badTokenEndPos The number for the last char in the token that caused the error
     */
    public void GeneralError(String errorMsg, String line, int lineNumber, int badTokenStartPos, int badTokenEndPos) {
        System.err.println("Error at line " + lineNumber + ", position " + badTokenStartPos + " : " + errorMsg);

        printUnderlinedError(line, badTokenStartPos, badTokenEndPos);

        throw new ParseCancellationException("Error");
    }

    /**
     * A method that simplifies calling GeneralError, to reduce copy-paste code in the other Listeners/Visitors.
     *
     * @param errorMsg The text explaining what caused the error
     * @param errorToken The token which caused the error. If the error was caused by a terminal use:
     *                   "example.getSymbol()" with example replaced with the name of the terminal
     */
    public void GeneralError(String errorMsg, Token errorToken) {
        int lineNumber = errorToken.getLine();
        String line = errorToken.getInputStream().toString().split("\n")[lineNumber - 1];
        int badTokenStartPos = errorToken.getCharPositionInLine();
        int badTokenEndpos = badTokenStartPos + errorToken.getText().length() - 1;

        GeneralError(errorMsg, line, lineNumber, badTokenStartPos, badTokenEndpos);
    }

    /**
     * Prints a line of source code ander underlines the chars between badTokenStartPos and badTokenEndPos
     *
     * @param line The input line from the source file
     * @param badTokenStartPos The start position of the token that should be underlined
     * @param badTokenEndPos THe end position of the token that should be underlined
     */
    protected void printUnderlinedError(String line, int badTokenStartPos, int badTokenEndPos) {
        System.err.println(line);

        for (int i = 0; i < badTokenStartPos; i++) {
            System.err.print(" ");
        }
        if ( badTokenStartPos>=0 && badTokenEndPos>=0 ) {
            for (int i=badTokenStartPos; i<=badTokenEndPos; i++) System.err.print("^");
        }
        System.err.println();
    }
}