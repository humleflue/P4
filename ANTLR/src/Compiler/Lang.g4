grammar Lang;

prog : code EOF ;
code : funcdef code #codeFuncdef
     | stmt code    #codeStmt
     |              #codeEmpty
     ;
funcdef : type id LPAREN funcdefparams RPAREN ASSIGN stmts returnstmt ENDF ;
returnstmt : RETURN stmt ;
type : NUMBERTYPE
     | BOOLTYPE ;
funcdefparams : funcdefparam (COMMA funcdefparam)* #funcdefparamsNotEmpty
              |                                    #funcdefparamsEmpty
              ;
funcdefparam : type id ;
id : ID ;
stmts : IF LPAREN expr RPAREN returnstmt stmts #stmtsNotEmpty
      |                                        #stmtsEmpty
      ;
stmt : expr SEMICOLON ;
expr : LPAREN expr RPAREN                                                             #exprParenthesised
     | funccall                                                                       #exprFunccall
     | funccall PRINTCHAR                                                             #exprFunccallPrint
     | NUMLITERAL                                                                     #exprNumber
     | BOOLLITERAL                                                                    #exprBoolean
     | id                                                                             #exprId
     | op=NEGATE expr                                                                 #exprUnaryOp
     | left=expr op=POW right=expr                                                    #exprBinaryOp
     | left=expr op=(DIVIDE|MULTIPLY) right=expr                                      #exprBinaryOp
     | left=expr op=(PLUS|MINUS) right=expr                                           #exprBinaryOp
     | left=expr op=(LOGLESS | LOGGREATER | LOGLESSOREQ | LOGGREATEROREQ) right=expr  #exprBinaryOp
     | left=expr op=(LOGEQ | LOGNOTEQ) right=expr                                     #exprBinaryOp
     | left=expr op=LOGAND right=expr                                                 #exprBinaryOp
     | left=expr op=LOGOR right=expr                                                  #exprBinaryOp
     ;

funccall : id LPAREN exprparams RPAREN ;
exprparams : expr (COMMA expr)* #exprparamsNotEmpty
           |                    #exprparamsEmpty
           ;

// *** Lexing *** //
// Reserved keywords gets matched first
// Types
NUMBERTYPE : 'number' ;
BOOLTYPE : 'boolean' ;
// Literals
BOOLLITERAL : 'true' | 'false' ;
NUMLITERAL : '-'?(('0'..'9')+|('0'..'9')+'.'('0'..'9')+);
// Other reserved keywords
ENDF    : 'end' ;
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
