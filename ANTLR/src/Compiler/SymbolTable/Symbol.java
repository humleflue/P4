package Compiler.SymbolTable;

public class Symbol {
    protected String name;
    protected Integer type;

    public Symbol(String name, Integer type){
        this.name = name;
        this.type = type;
    }

    public String getName(){
        return this.name;
    }

    public Integer getType() {return this.type; }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if ( !(obj instanceof Symbol) ) {
            return false;
        }
        if ( obj==this ) {
            return true;
        }
        return name.equals(((Symbol)obj).getName());
    }
}
