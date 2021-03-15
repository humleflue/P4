grammar Buff;


prog            : dcls stmts EOF;
dcls            : dcl SEMI dcls | ;
dcl             : type ID LPAREN dclParams RPAREN ASSIGN stmt ;
type            : NUMBERDCl | TEXTDCL ;
dclParams       : dclParam dclMoreParams | ;
dclMoreParams   : COMMA dclParam dclMoreParams | ;
dclParam        : type ID ;
stmts           : stmt SEMI stmts | ;
stmt            : math | TEXTVAL ;
math            : term followTerm | NUMBER;
followTerm      : simpleOps math ;
term            : funcCall | val ;
simpleOps       : PLUS | MINUS ;
val             : LPAREN math RPAREN | NUMBER;
funcCall        : ID LPAREN stmtParams RPAREN ;
stmtParams      : stmt stmtMoreParams | ;
stmtMoreParams  : COMMA stmt stmtMoreParams | ;

NEWLINE : ('\r\n'|'\n'|'\r');
NUMBER : ('0'..'9')+|('0'..'9')+'.'('0'..'9')+;
WHITESPACE : (' ' | NEWLINE)+ -> skip;
LPAREN : '(' ;
RPAREN : ')' ;
ASSIGN : '=' ;
COMMA : ',' ;
PLUS : '+' ;
MINUS : '-' ;
TEXTVAL : ('a'..'z''_')('a'..'z''0'..'9''_''-')* ;
SEMI : ';' ;
NUMBERDCL : 'number' ;
TEXTDCL : 'text' ;
ID : TEXTVAL ;