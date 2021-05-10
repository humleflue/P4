package tests.Auxiliary;

import Compiler.ErrorHandling.BuffErrorListener;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.BitSet;

public class MockErrorListener extends BaseErrorListener implements BuffErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new RuntimeException();
    }

    @Override
    public void ThrowError(String errorMsg, ArrayList<Token> offendingTokens) {
        throw new RuntimeException();
    }

    @Override
    public void ThrowError(String errorMsg, Token offendingToken, Token... additionalOffendingTokens) {
        throw new RuntimeException();
    }

    @Override
    public void ThrowError(String errorMsg, ParseTree tree, Token... additionalOffendingTokens) {
        throw new RuntimeException();
    }
}
