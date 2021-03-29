#!/bin/bash
echo Running antlr...
antlr4 -package Compiler.Lang Lang.g4
#echo Compiling...
#javac *.java
echo Done.

