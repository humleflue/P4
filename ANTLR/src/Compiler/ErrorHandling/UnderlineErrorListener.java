package Compiler.ErrorHandling;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Comparator;

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
        Interval offendingTokenInterval = new Interval(offendingToken.getStartIndex(), offendingToken.getStopIndex());

        ThrowUnderlinedError(msg, offendingToken);
    }

    /**
     * A method that simplifies calling GeneralError, to reduce copy-paste code in the other Listeners/Visitors.
     *
     * @param errorMsg The text explaining what caused the error
     * @param errorToken The token which caused the error. If the error was caused by a terminal use:
     *                   "example.getSymbol()" with example replaced with the name of the terminal
     */
    public void ThrowUnderlinedError(String errorMsg, Token errorToken, Token... additionalErrorTokens) {
        //Gets the source code line in which the error occurred.
        int lineNumber = errorToken.getLine();
        String line = errorToken.getInputStream().toString().split("\n")[lineNumber - 1];

        //Gets the interval of the errorToken and adds it to list.
        ArrayList<Interval> underlineIntervals = new ArrayList<Interval>();
        underlineIntervals.add(GetTokenInterval(errorToken));

        //Gets the interval of the additional tokens
        for (Token token : additionalErrorTokens) {
            underlineIntervals.add(GetTokenInterval(token));
        }
        underlineIntervals.sort(Comparator.comparingInt(interval -> interval.a));

        //Gets the start position of all offending tokens.
        ArrayList<Integer> offendingTokensStartPos = new ArrayList<Integer>();
        for (Interval interval : underlineIntervals) {
            offendingTokensStartPos.add(interval.a);
        }

        printErrorMsg(errorMsg, line, lineNumber, offendingTokensStartPos);
        printUnderlinedError(line, underlineIntervals);

        throw new ParseCancellationException("Error");
    }

    private Interval GetTokenInterval(Token token) {
        int tokenStartPos = token.getCharPositionInLine();
        int tokenEndpos = tokenStartPos + token.getText().length() - 1;

        return new Interval(tokenStartPos, tokenEndpos);
    }

    protected void printErrorMsg(String errorMsg, String line, int lineNumber, ArrayList<Integer> tokenPositions){
        String result = "";
        result += "Error at line " + lineNumber;
        result += ", position " + tokenPositions.get(0);
        if(tokenPositions.size() > 1){
            for (int i = 1; i < tokenPositions.size(); i++) {
                result += " and " + tokenPositions.get(i);
            }
        }
        result += " : "  + errorMsg + "\n";
        result += line;

        System.err.println(result);
    }

    /**
     * Prints a line of source code ander underlines the chars between badTokenStartPos and badTokenEndPos
     */
    protected void printUnderlinedError(String line, ArrayList<Interval> offendingTokenInterval) {
        int printPos = 0;

        for (Interval interval : offendingTokenInterval){
            while (printPos < interval.a) {
                System.err.print(" ");
                printPos++;
            }
            if ( interval.a >= 0 && interval.b >= 0) {
                for (int i = interval.a; i <= interval.b; i++) {
                    System.err.print("^");
                    printPos++;
                }
            }
            System.err.println();
        }

    }
}