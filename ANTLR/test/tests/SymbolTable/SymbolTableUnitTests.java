package tests.SymbolTable;

import Compiler.SymbolTable.BaseScope;
import Compiler.SymbolTable.Scope;
import Compiler.SymbolTable.Symbol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SymbolTableUnitTests {

    @Test
    public void enclosingScopeDefined_shouldBeAbleToRetrieve() {
        // Arrange
        Scope outerScope = new BaseScope();
        Scope innerScope = new BaseScope(outerScope);

        // Act
        var enclosingScope = innerScope.getEnclosingScope();
        // Assert
        Assertions.assertEquals(enclosingScope, outerScope);
    }

    @Test
    public void symbolDefinedInScope_shouldBeAbleToRetrieve() {
        // Arrange
        Symbol symbol = new Symbol("test", 1);
        Scope scope = new BaseScope();

        // Act
        scope.defineSymbol(symbol);

        // Assert
        Assertions.assertEquals(scope.getSymbol("test"), symbol);
    }

    @Test
    public void symbolDefinedInOuterScope_shouldBeAbleToRetrieveFromInner() {
        // Arrange
        Symbol symbol = new Symbol("test", 1);
        Scope outerScope = new BaseScope();
        Scope innerScope = new BaseScope(outerScope);

        // Act
        outerScope.defineSymbol(symbol);

        // Assert
        Assertions.assertEquals(innerScope.getSymbol("test"), symbol);
    }

    @Test
    public void definingTwoSymbolsWithSameId_throws() {
        // Arrange
        Symbol symbol1 = new Symbol("test", 1);
        Symbol symbol2 = new Symbol("test", 1);
        Scope scope = new BaseScope();
        scope.defineSymbol(symbol1);

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> scope.defineSymbol(symbol2));
    }
}
