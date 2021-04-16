grammar Cli;

prog : id SUFFIX optionaloptions #compile
     | '-help'                   #help
     ;
id : ID ;
optionaloptions : '-o' id #outfile
                |         #empty
                ;

WS: (' '|'\t')+ -> skip;
SUFFIX : '.buff' ;

ID : ['A-Za-z]['A-Za-z_0-9]* ;
