grammar B; // B for Buff

prog : code EOF ;
code : funcdef code                                                           #codeFuncdef
     | stmt code                                                              #codeStmt
     |                                                                        #codeEmpty
     ;
funcdef : type ID LPAREN funcdefparams RPAREN ASSIGN stmts RETURN stmt ENDF ;
type : NUMBERTYPE
     | BOOLTYPE ;
funcdefparams : funcdefparam funcdefmoreparams                                #funcdefparamsIncluded
              |                                                               #funcdefparamsEmpty
              ;
funcdefmoreparams : COMMA funcdefparam funcdefmoreparams                      #funcdefmoreparamsIncluded
                  |                                                           #funcdefmoreparamsEmpty
                  ;
funcdefparam : type ID ;
stmts : IF LPAREN expr RPAREN RETURN stmt stmts                               #stmtsIncluded
      |                                                                       #stmtsEmpty
      ;
stmt : expr SEMICOLON ;
expr : left=logexpr op=LOGOR right=expr                                       #logOr
     | logexpr                                                                #logExpr
     ;                                                             
logexpr : left=logexpr2 op=LOGAND right=logexpr                               #logAnd
         | logexpr2                                                           #logExpr2
         ;                                                         
logexpr2 : left=logexpr3 op=LOGEQ right=logexpr2 
          | left=logexpr3 op=LOGNOTEQ right=logexpr2 
          | logexpr3 ;
logexpr3 : left=mathexpr op=LOGLESS right=logexpr3 
          | left=mathexpr op=LOGGREATER right=logexpr3 
          | left=mathexpr op=LOGLESSOREQ right=logexpr3 
          | left=mathexpr op=LOGGREATEROREQ right=logexpr3 
          | mathexpr ;
mathexpr : left=mathexpr2 op=PLUS right=mathexpr 
         | left=mathexpr2 op=MINUS right=mathexpr 
         | mathexpr2 ;
mathexpr2 : left=mathexpr3 op=MULTIPLY right=mathexpr2 
          | left=mathexpr3 op=DIVIDE right=mathexpr2 
          | mathexpr3 ;
mathexpr3 : left=logexpr4 op=POW right=mathexpr3 
          | logexpr4 ;
logexpr4 : op=NEGATE val 
          | val ;
val : LPAREN expr RPAREN
    | funccall
    | funccall PRINTCHAR
    | NUMLITERAL 
    | BOOLLITERAL 
    | ID ;
funccall : ID LPAREN exprparams RPAREN ;
exprparams : expr exprmoreparams
           | 
           ;
exprmoreparams : COMMA expr exprmoreparams
               | 
               ;

start : prog EOF;
prog : dcl prog                                                                 #dclProg
      | stmt prog                                                               #stmtProg
      |                                                                         #progEmpty
      ;
dcl : type ID LPAREN dclParams RPAREN ASSIGN stmt                               #oneLineStmt
     | type ID LPAREN dclParams RPAREN ASSIGN LCURLY stmts RETURN stmt RCURLY ENDF   #multiLineStmt
     ;
type : NUMBERDCL
      | BOOLEAN ;
dclParams : dclParam dclMoreParams                                 #dclParamscontained
           |                                                       #dclParamsEmpty
           ;
dclMoreParams : COMMA dclParam dclMoreParams                       #dclMoreParamscontained
               |                                                   #dclMoreParamsEmpty
               ;
dclParam : type ID ;
stmts : IF LPAREN expr RPAREN RETURN stmt stmts                    #stmtsContained
       |                                                           #stmtsEmpty
       ;
stmt : expr SEMICOLON ;
expr : left=lgclExpr op=LOGOR right=expr                            #logOr
      | lgclExpr                                                    #logExp
      ;
lgclExpr : left=lgclExpr2 op=LOGAND right=lgclExpr                  #logAnd
          | lgclExpr2                                               #log2
          ;
lgclExpr2 :  left=lgclExpr3 op=LOGEQUALS  right=lgclExpr2           #logEqualsOp
           | left=lgclExpr3 op=LOGNEQUALS right=lgclExpr2           #logEqualsOp
           | lgclExpr3                                              #mathLog
           ;
lgclExpr3 :  left=mathExpr op=LOGLESS right=lgclExpr3               #logicalOp
           | left=mathExpr op=LOGGREATER right=lgclExpr3            #logicalOp
           | left=mathExpr op=LOGLESSOREQUAL right=lgclExpr3        #logicalOp
           | left=mathExpr op=LOGGREATEROREQUAL right=lgclExpr3     #logicalOp
           | mathExpr                                               #math
           ;
mathExpr :  left=mathExpr2 op=PLUS  right=mathExpr                  #binaryOpPlusMinus
          | left=mathExpr2 op=MINUS right=mathExpr                  #binaryOpPlusMinus
          | mathExpr2                                               #mathDivMul
          ;
mathExpr2 :  left=mathExpr3 op=MULTIPLY right=mathExpr2             #binaryOpDivMul
           | left=mathExpr3 op=DIVIDE   right=mathExpr2             #binaryOpDivMul
           | mathExpr3                                              #mathPow
           ;
mathExpr3 :  left=lgclExpr4 op=POWER right=mathExpr3                #binaryOpPow
           | lgclExpr4                                              #logUnary
           ;
lgclExpr4 : op=NEGATE val                                           #negate
           | val                                                    #value
           ;
val : LPAREN expr RPAREN                                            #parensExp
     | funcCall                                                     #valFuncCall
     | funcCall PRINTDEBUG                                          #valFuncCallDebug
     | termVal                                                      #valTerminal
     ;
termVal : NUMBERVAL
        | BOOLVAL
        | ID ;
funcCall : ID LPAREN stmtParams RPAREN ;
stmtParams : expr exprMoreParams                                    #stmtParamscontained
            |                                                       #stmtParamsEmpty
            ;
exprMoreParams : COMMA stmt exprMoreParams                          #exprMoreParamsContained
                |                                                   #exprMoreParamsEmpty
                ;

// Reserved keywords gets matched first
NUMBERTYPE : 'number' ;
BOOLTYPE : 'bool' ;
ENDF    : 'endf' ;
PRINTCHAR : '?' ;
RETURN : 'return' ;
IF : 'if' ;

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
WS: (' '|'\t' | NEWLINE)+ -> skip;
NEWLINE : ('\r\n'|'\n'|'\r');

ID : TEXTLITERAL ;
TEXTLITERAL : ['A-Za-z]['A-Za-z_0-9]* ;
NUMLITERAL : ('0'..'9')+|('0'..'9')+'.'('0'..'9')+;
BOOLLITERAL : 'true' | 'false' ;