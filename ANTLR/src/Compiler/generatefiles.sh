#!/bin/bash
echo Running antlr...
java -Xmx500M -cp "/usr/local/lib/antlr-4.9-complete.jar:$CLASSPATH" org.antlr.v4.Tool -package Compiler.AntlrGenerated Buff.g4 -o AntlrGenerated -visitor
java -Xmx500M -cp "/usr/local/lib/antlr-4.9-complete.jar:$CLASSPATH" org.antlr.v4.Tool -package Compiler.AntlrGenerated Cli.g4 -o AntlrGenerated -visitor
echo Done.

