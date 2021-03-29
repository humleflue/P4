package Buff.SymbolTable;

public class Symbol {
    protected String name;
    protected Type type;

    public Symbol(String name, Type symbol){
        this.name = name;
        this.type = symbol;
    }

    public String getName(){
        return this.name;
    }

    public Type getType() {return this.type; }

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