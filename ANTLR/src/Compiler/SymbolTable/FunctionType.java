package Compiler.SymbolTable;

import java.util.List;

public class FunctionType implements Type{
    protected int returnType;
    protected List<Type> argumentTypeList;

    public FunctionType(int returnType, List<Type> argumentTypeList){
        this.returnType = returnType;
        this.argumentTypeList = argumentTypeList;
    }

    @Override
    public int getType() {
        return this.returnType;
    }

    public List<Type> getArgumentTypeList(){
        return this.argumentTypeList;
    }
}
