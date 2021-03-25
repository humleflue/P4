 grammar B; // B for Buff

prog : code EOF ;
code : funcdef code                                                           #codeFuncdef
     | stmt code                                                              #codeStmt
     |                                                                        #codeEmpty
     ;
funcdef : type ID LPAREN funcdefparams RPAREN ASSIGN stmts RETURN stmt ENDF ;
type : NUMBERTYPE
     | BOOLTYPE ;
funcdefparams : funcdefparam funcdefmoreparams                                #funcdefparamsNotEmpty
              |                                                               #funcdefparamsEmpty
              ;
funcdefmoreparams : COMMA funcdefparam funcdefmoreparams                      #funcdefmoreparamsNotEmpty
                  |                                                           #funcdefmoreparamsEmpty
                  ;
funcdefparam : type ID ;
stmts : IF LPAREN expr RPAREN RETURN stmt stmts                               #stmtsNotEmpty
      |                                                                       #stmtsEmpty
      ;
stmt : expr SEMICOLON ;
expr : left=logexpr op=LOGOR right=expr                                       #logOr
     | logexpr                                                                #log
     ;                                                             
logexpr : left=logexpr2 op=LOGAND right=logexpr                               #logAnd
         | logexpr2                                                           #log2
         ;                                                         
logexpr2 : left=logexpr3 op=LOGEQ right=logexpr2                              #logEqualsOp
          | left=logexpr3 op=LOGNOTEQ right=logexpr2                          #logEqualsOp
          | logexpr3                                                          #log3
          ;
logexpr3 : left=mathexpr op=LOGLESS right=logexpr3                            #logOp
          | left=mathexpr op=LOGGREATER right=logexpr3                        #logOp
          | left=mathexpr op=LOGLESSOREQ right=logexpr3                       #logOp
          | left=mathexpr op=LOGGREATEROREQ right=logexpr3                    #logOp
          | mathexpr                                                          #math
          ;
mathexpr : left=mathexpr2 op=PLUS right=mathexpr                              #plusMinus
         | left=mathexpr2 op=MINUS right=mathexpr                             #plusMinus
         | mathexpr2                                                          #math2
         ;
mathexpr2 : left=mathexpr3 op=MULTIPLY right=mathexpr2                        #multDiv
          | left=mathexpr3 op=DIVIDE right=mathexpr2                          #multDiv
          | mathexpr3                                                         #math3
          ;
mathexpr3 : left=logexpr4 op=POW right=mathexpr3                              #pow
          | logexpr4                                                          #log4
          ;
logexpr4 : op=NEGATE val                                                      #negate
          | val                                                               #value 
          ;
val : LPAREN expr RPAREN                                                      #valParenthesisedExpr
    | funccall                                                                #valFunccall
    | funccall PRINTCHAR                                                      #valFunccallPrint
    | NUMLITERAL                                                              #valNumber
    | BOOLLITERAL                                                             #valBoolean
    | ID                                                                      #valId
    ;
funccall : ID LPAREN exprparams RPAREN ;
exprparams : expr exprmoreparams                                              #exprparamsNotEmpty
           |                                                                  #exprparamsEmpty
           ;
exprmoreparams : COMMA expr exprmoreparams                                    #exprmoreparamsNotEmpty
               |                                                              #exprmoreparamsEmpty
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