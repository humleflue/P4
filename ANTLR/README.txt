Compile Antlr4 project

Go to folder containing Buff_1_1.g4

in terminal:
antlr4 Buff_1_1.g4
javac Buff_1_1*.java

Now go back one folder and run


This should generate all the neccesary files.
Now run

javac Main.java
java Main.java // if this does not work write Main .java

The project should now be working