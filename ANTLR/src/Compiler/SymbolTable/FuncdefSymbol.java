package Compiler.SymbolTable;

import java.util.ArrayList;

public class FuncdefSymbol extends Symbol {
    private ArrayList<Integer> parameterTypes;

    public FuncdefSymbol(String name, Integer symbol, ArrayList<Integer> parameterTypes) {
        super(name, symbol);
        this.parameterTypes = parameterTypes;
    }

    public ArrayList<Integer> getParameterTypes() {
        return parameterTypes;
    }
}
