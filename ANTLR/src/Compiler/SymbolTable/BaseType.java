package Compiler.SymbolTable;

public class BaseType implements Type {
    protected int val;

    public BaseType (int val){
        this.val = val;
    }

    @Override
    public int getType() {
        return val;
    }
}
