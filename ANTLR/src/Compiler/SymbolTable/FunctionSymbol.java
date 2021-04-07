package Compiler.SymbolTable;

import java.util.ArrayList;

public class FunctionSymbol extends Symbol {
    private ArrayList<Integer> parameterTypes;

    public FunctionSymbol(String name, Integer symbol, ArrayList<Integer> parameterTypes) {
        super(name, symbol);
        this.parameterTypes = parameterTypes;
    }

    public ArrayList<Integer> getParameterTypes() {
        return parameterTypes;
    }
}
