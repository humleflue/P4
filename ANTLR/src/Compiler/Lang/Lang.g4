 grammar lang;

prog : code EOF ;
code : funcdef code                                                           #codeFuncdef
     | stmt code                                                              #codeStmt
     |                                                                        #codeEmpty
     ;
funcdef : type ID LPAREN funcdefparams RPAREN ASSIGN stmts RETURN stmt ENDF ;
type : NUMBERTYPE
     | BOOLTYPE ;
funcdefparams : funcdefparam (COMMA funcdefparam)*                            #funcdefparamsNotEmpty //dclparams
              |                                                               #funcdefparamsEmpty
              ;
funcdefparam : type ID ;
stmts : IF LPAREN expr RPAREN RETURN stmt stmts                               #stmtsNotEmpty
      |                                                                       #stmtsEmpty
      ;
stmt : expr SEMICOLON ;
expr : val                                                                    #value
     | op=NEGATE val                                                          #uneryOp
     | left=expr op=POW right=expr                                            #binaryOp
     | left=expr op=DIVIDE right=expr                                         #binaryOp
     | left=expr op=MULTIPLY right=expr                                       #binaryOp
     | left=expr op=PLUS right=expr                                           #binaryOp
     | left=expr op=MINUS right=expr                                          #binaryOp
     | left=expr op=LOGEQ right=expr                                          #binaryOp
     | left=expr op=LOGNOTEQ right=expr                                       #binaryOp
     | left=expr op=LOGLESS right=expr                                        #binaryOp
     | left=expr op=LOGGREATER right=expr                                     #binaryOp
     | left=expr op=LOGLESSOREQ right=expr                                    #binaryOp
     | left=expr op=LOGGREATEROREQ right=expr                                 #binaryOp
     | left=expr op=LOGAND right=expr                                         #binaryOp
     | left=expr op=LOGOR right=expr                                          #binaryOp
     ;

val : LPAREN expr RPAREN                                                      #valParenthesisedExpr //parensexp
    | funccall                                                                #valFunccall
    | funccall PRINTCHAR                                                      #valFunccallPrint  //valfunccalldebug
    | NUMLITERAL                                                              #valNumber //valterminal
    | BOOLLITERAL                                                             #valBoolean
    | ID                                                                      #valId
    ;
funccall : ID LPAREN exprparams RPAREN ;
exprparams : expr (COMMA expr)*                                               #exprparamsNotEmpty //stmtparamscontained
           |                                                                  #exprparamsEmpty
           ;

// *** Lexing *** //
// Reserved keywords gets matched first
// Types
NUMBERTYPE : 'number' ;
BOOLTYPE : 'bool' ;
// Literals
BOOLLITERAL : 'true' | 'false' ;
NUMLITERAL : ('0'..'9')+|('0'..'9')+'.'('0'..'9')+;
// Other reserved keywords
ENDF    : 'endf' ;
RETURN : 'return' ;
IF : 'if' ;

// Now match special characters
PRINTCHAR : '?' ;
LPAREN : '(' ;
RPAREN : ')' ;
LCURLY : '{' ;
RCURLY : '}' ;
LOGOR : '||' ;
LOGAND : '&&' ;
LOGEQ : '==' ;
LOGNOTEQ : '!=' ;
LOGLESS : '<' ;
LOGGREATER : '>' ;
LOGLESSOREQ : '<=' ;
LOGGREATEROREQ : '>=' ;
NEGATE : '!' ;
POW : '^' ;
COMMA : ',' ;
ASSIGN : '=' ;
PLUS : '+' ;
MINUS : '-' ;
MULTIPLY : '*' ;
DIVIDE : '/' ;
SEMICOLON : ';' ;

// Match white space and new lines
WS: (' '|'\t' | NEWLINE)+ -> skip;
NEWLINE : ('\r\n'|'\n'|'\r');

// If none of the above regular expressions were true
// Check if we have an ID (which cannot start with a number)
ID : ['A-Za-z]['A-Za-z_0-9]* ;
