import java_cup.runtime.*;
import java.util.*;

%%
%class Lexer
%unicode
%line
%column
%cup
%{
    StringBuffer string = new StringBuffer();
    
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

LineTerminator = \r\n|\r|\n
InputCharacter = [^\r\n]
WhiteSpace     = [ \t\f] | {LineTerminator}

/* comments */
Comment              = {TraditionalComment} | {EndOfLineComment}
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?

Identifier       = [:jletter:] [:jletterdigit:]*
DecNumberLiteral = -?[0-9]+.[0-9]+|0|-?[1-9][0-9]*
%%

/* keywords */
<YYINITIAL> "number"               { return symbol(sym.numberdcl); }

<YYINITIAL> {
    /* identifiers */ 
    {Identifier}                   { return symbol(sym.id); }
    
    /* literals */
    {DecNumberLiteral}             { return symbol(sym.numberval); }

    /* operators */
    "="                            { return symbol(sym.assign); }
    "+"                            { return symbol(sym.plus); }
    "-"                            { return symbol(sym.minus); }

    /* function call/def stuff */
    "("                            { return symbol(sym.lparen); }
    ")"                            { return symbol(sym.rparen); }
    ","                            { return symbol(sym.comma); }

    /* comments */
    {Comment}                      { /* ignore */ }
    
    /* statement terminator */
    ";"                            { return symbol(sym.semi); }

    /* whitespace */
    {WhiteSpace}                   { /* ignore */ }
}

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                    yytext()+">"); }
