import java_cup.runtime.*;
import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception {
        String sourceFilePath = "";
        Reader file = new FileReader("./samleText.txt");

        Buff buff = new Buff(file);

        parser minimalParser = new parser(buff);
        minimalParser.parse();
    }
}