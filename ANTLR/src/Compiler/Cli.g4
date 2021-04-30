grammar Cli;

args : ID SUFFIX optionaloptions #compile
     | '-help'                   #help
     ;
optionaloptions : '-o' ID #outfile
                |         #empty
                ;

WS: (' '|'\t')+ -> skip;
SUFFIX : '.buff' ;

ID : ['A-Za-z]['A-Za-z_0-9]* ;
