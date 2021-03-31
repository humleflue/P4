package Compiler.SymbolTable;

import java.util.List;

public class FunctionType implements Type{
    protected int val;
    protected List<Type> argumentList;

    public FunctionType(int val, List<Type> argumentList){
        this.val = val;
        this.argumentList = argumentList;
    }

    @Override
    public int getVal() {
        return val;
    }
}
