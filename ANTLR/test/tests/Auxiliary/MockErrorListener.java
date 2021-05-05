package tests.Auxiliary;

import Compiler.ErrorHandling.BuffErrorListener;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;

public class MockErrorListener implements BuffErrorListener {
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
