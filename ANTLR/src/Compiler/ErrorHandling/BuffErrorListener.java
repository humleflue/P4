package Compiler.ErrorHandling;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;

public interface BuffErrorListener {
    public void ThrowError(String errorMsg, ArrayList<Token> offendingTokens);
    public  void ThrowError(String errorMsg, Token offendingToken, Token... additionalOffendingTokens);
    public  void ThrowError(String errorMsg, ParseTree tree, Token... additionalOffendingTokens);
}
