import java_cup.runtime.*;
import java.util.*;

%%
%class Lexer
%unicode
%line
%column
%cup
%standalone
%{
    StringBuffer string = new StringBuffer();
    
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

    List<String> numbers = new ArrayList();
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = [ \t\f]|\r|\n|\r\n

/* comments */
Comment              = {TraditionalComment} | {EndOfLineComment}
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?

Identifier       = [:jletter:] [:jletterdigit:]*
DecNumberLiteral = -?[0-9]+.[0-9]+|0|-?[1-9][0-9]*

%eof{
    System.out.print("Numbers: ");
    for(int i=0; i< numbers.size(); i++) {
        if(i == numbers.size()-1)
            System.out.print(numbers.get(i));
        else {
            System.out.print(numbers.get(i) + ", ");
        }
    }
%eof}
%%

/* keywords */
<YYINITIAL> "number"               { return symbol(sym.numberdcl); }

<YYINITIAL> {
    /* identifiers */ 
    {Identifier}                   { return symbol(sym.id); }
    
    /* literals */
    {DecNumberLiteral}             { numbers.add(yytext()); return symbol(sym.numberval); }

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
    
    /* whitespace */
    ";"                            { return symbol(sym.semi); }
    {WhiteSpace}                   { /* ignore */ }
}

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                    yytext()+">"); }
