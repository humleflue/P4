package Compiler.ErrorHandling;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

public interface BuffErrorListener {
    public void ThrowError(String errorMsg, ArrayList<Token> offendingTokens);
    public  void ThrowError(String errorMsg, Token offendingToken, Token... additionalOffendingTokens);
}
