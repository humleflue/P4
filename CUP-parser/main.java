import java_cup.runtime.*;
import java.util.*;
import java.io.*;


class main {
    public static void main(String[] args) throws Exception {
        Reader file = new FileReader("./sampleCode.txt");

        Lexer lexer = new Lexer(file);

        parser minimalParser = new parser(lexer);
        minimalParser.parse();

        System.out.println("Parse successful.");
    }
}
