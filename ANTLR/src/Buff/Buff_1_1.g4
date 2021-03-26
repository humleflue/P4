grammar Buff_1_1;
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

NUMBERDCL : 'number' ;
TEXTDCL : 'text' ;
BOOLEAN : 'bool' ;
ENDF    : 'endf' ;
PRINTDEBUG : '?' ;

ID : TEXTVAL ;
TEXTVAL : ['A-Za-z]['A-Za-z_0-9]* ;
NUMBERVAL : ('0'..'9')+|('0'..'9')+'.'('0'..'9')+;
BOOLVAL : 'true' | 'false' ;

LPAREN : '(' ;
RPAREN : ')' ;
LCURLY : '{' ;
RCURLY : '}' ;
RETURN : 'return' ;
LOGAND : '&&' ;
LOGOR : '||' ;
IF : 'if' ;
LOGEQUALS : '==' ;
LOGNEQUALS : '!=' ;
LOGLESS : '<' ;
LOGGREATER : '>' ;
LOGLESSOREQUAL : '<=' ;
LOGGREATEROREQUAL : '>=' ;
NEGATE : '!' ;
POWER : '^' ;
COMMA : ',' ;
ASSIGN : '=' ;
PLUS : '+' ;
MINUS : '-' ;
MULTIPLY : '*' ;
DIVIDE : '/' ;
SEMICOLON : ';' ;
WS: (' '|'\t' | NEWLINE)+ -> skip;
NEWLINE : ('\r\n'|'\n'|'\r');