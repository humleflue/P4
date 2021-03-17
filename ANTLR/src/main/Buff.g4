grammar Buff;

prog : dcls stmts EOF ;
dcls : dcl SEMICOLON dcls
      |  ;
dcl : type ID LPAREN dclparams RPAREN ASSIGN stmt ;
type : NUMBERDCL
      | TEXTDCL ;
dclparams : dclparam dclmoreparams
           |  ;
dclmoreparams : COMMA dclparam dclmoreparams
               |  ;
dclparam : type ID ;

stmts : stmt SEMICOLON stmts
      |  ;
stmt : math
      | TEXTVAL ;
math : term followterm ;
followterm : simpleops math
            |  ;
term : funccall
      | val ;
simpleops : PLUS
           | MINUS ;
val : LPAREN math RPAREN
     | NUMBERVAL ;
funccall : ID LPAREN stmtparams RPAREN ;
stmtparams : stmt stmtmoreparams
            |  ;
stmtmoreparams : COMMA stmt stmtmoreparams
                |  ;


NUMBERDCL : 'number' ;
TEXTDCL : 'text' ;

ID : TEXTVAL ;
TEXTVAL : ['A-Za-z]['A-Za-z_0-9]+ ;
NUMBERVAL : ('0'..'9')+|('0'..'9')+'.'('0'..'9')+;

LPAREN : '(' ;
RPAREN : ')' ;
ASSIGN : '=' ;
COMMA : ',' ;
PLUS : '+' ;
MINUS : '-' ;
SEMICOLON : ';' ;
WS: (' '|'\t' | NEWLINE)+ -> skip;
NEWLINE : ('\r\n'|'\n'|'\r');