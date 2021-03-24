Compile Antlr4 project

Go to folder containing Buff_1_1.g4

in terminal:
antlr4 -package Buff Buff_1_1.g4
javac Buff_1_1*.java
javac Gen.java
java Gen.java

This should generate all the neccesary files.
Now run
cd ..
javac Main.java
java Main // if it doesn't work run java Main.java

The project should now be working