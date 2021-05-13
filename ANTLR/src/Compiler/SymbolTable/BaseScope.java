package Compiler.SymbolTable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The base implementation of the Scope interface.
 */
public class BaseScope implements Scope {
    protected Scope enclosingScope;

    protected Map<String, Symbol> symbols = new LinkedHashMap<>();

    //Only use this to create the global scope
    public BaseScope() {
    }

    public BaseScope(Scope enclosingScope) {
        setEnclosingScope(enclosingScope);
    }

    @Override
    public Scope getEnclosingScope() {
        return this.enclosingScope;
    }

    @Override
    public void setEnclosingScope(Scope scope) {
        this.enclosingScope = scope;
    }

    /**
     * Define a symbol in the scope. Throws an IllegalArgumentException if the symbol is already defined.
     *
     * @param symbol The symbol that should be defined
     * @throws IllegalArgumentException Throws an exception if the symbol has already been defined.
     */
    @Override
    public void defineSymbol(Symbol symbol) throws IllegalArgumentException {
        if (symbols.containsKey(symbol.getName())) {
            throw new IllegalArgumentException("duplicate symbol " + symbol.getName());
        }
        symbols.put(symbol.getName(), symbol);
    }

    /**
     * Recursively gets a symbol from this scope. If not found, calls the same function in this scopes enclosing scope.
     * Returns {@code null} if it is not found.
     *
     * @param name The name of the symbol that should be returned
     * @return The symbol with the given name
     */
    @Override
    public Symbol getSymbol(String name) {
        Symbol s = symbols.get(name);
        if (s != null) {
            return s;
        }
        // if not here, check any enclosing scope
        if (this.enclosingScope != null) return this.enclosingScope.getSymbol(name);
        // Below return statement only happens when symbol is not found in globalscope
        return null;
    }
}
