
#!/bin/bash
echo Running antlr...
java -Xmx500M -cp "/usr/local/lib/antlr-4.9-complete.jar:$CLASSPATH" org.antlr.v4.Tool -package Compiler.Lang Lang.g4
echo Done.


