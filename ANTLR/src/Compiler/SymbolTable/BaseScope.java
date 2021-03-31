package Compiler.SymbolTable;

import java.util.LinkedHashMap;
import java.util.Map;

public class BaseScope implements Scope{
    protected Scope enclosingScope;

    protected Map<String, Symbol> symbols = new LinkedHashMap<>();

    //Only use this to create the global scope
    public BaseScope() { }

    public BaseScope(Scope enclosingScope){
        setEnclosingScope(enclosingScope);
    }

    @Override
    public Scope getEnclosingScope() {
        return enclosingScope;
    }

    @Override
    public void setEnclosingScope(Scope scope) {
        this.enclosingScope = scope;
    }

    @Override
    public void defineSymbol(Symbol symbol) throws IllegalArgumentException {
        if ( symbols.containsKey(symbol.getName()) ) {
            throw new IllegalArgumentException("duplicate symbol "+symbol.getName());
        }
        symbols.put(symbol.getName(), symbol);
    }

    @Override
    public Symbol getSymbol(String name) {
        Symbol s = symbols.get(name);
        if (s != null) {
            return s;
        }
        // if not here, check any enclosing scope
        if ( enclosingScope != null ) return enclosingScope.getSymbol(name);
        // Below return statement only happens when symbol is not found in globalscope
        return null;
    }
}
