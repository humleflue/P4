grammar Cli;

args : INFILENAME optionalOptions? #compile
     | '-help'                     #help
     ;
optionalOptions : '-o' OUTFILENAME ;

WS: (' '|'\t')+ -> skip;

INFILENAME : ID'.buff' ;
OUTFILENAME : ID('.js')? ;

ID : [A-Za-z][A-Za-z_0-9-]* ;