package tests.SymbolTable;

import Compiler.AntlrGenerated.BuffParser.*;
import Compiler.SymbolTable.Scope;
import Compiler.SymbolTable.Symbol;
import Compiler.SymbolTable.SymbolTableGeneratorListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.Auxiliary.BaseTest;
import tests.Auxiliary.MockErrorListener;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SymbolTableTests extends BaseTest {
    private SymbolTableGeneratorListener getWalker(ParseTree tree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        SymbolTableGeneratorListener symbolTableGeneratorListener = new SymbolTableGeneratorListener(new MockErrorListener());
        walker.walk(symbolTableGeneratorListener, tree);
        return symbolTableGeneratorListener;
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "functionReturnTypeTest.csv")
    public void GivenRetunType_ReturnsGivenType(String sourceCode, int type) {
        // Arrange
        ParseTree tree = createTree(sourceCode);
        SymbolTableGeneratorListener symbolTable = getWalker(tree);

        // Act
        int actual = symbolTable.globalScope.getSymbol("func").getType();

        // Assert
        assertEquals(actual, type);
    }

    @ParameterizedTest
    @CsvFileSource(resources = testPath + "functionParameterTest.csv")
    public void functionParameterExists_CanBeFoundInSymbolTable(String sourceCode, String parameter, int type) {
        // Arrange
        ParseTree tree = createTree(sourceCode);
        SymbolTableGeneratorListener symbolTable = getWalker(tree);
        // Act
        // Gets the scope for the specific function. Requires that the tree is parsed to a ParseRuleContext.
        Scope functionScope = symbolTable.scopes.get(((ProgContext)tree).getChild(CodeFuncdefContext.class, 0).funcDef());
        int actualType = functionScope.getSymbol(parameter).getType();

        // Assert
        assertEquals(type, actualType);
    }

    @Test
    public void lookUpFunctionInEnclosedScope_FunctionIsFound(){
        // Arrange
        ParseTree tree = createTree("number func() = 1;");
        SymbolTableGeneratorListener symbolTable = getWalker(tree);

        // Act
        Scope functionScope = symbolTable.scopes.get(((ProgContext)tree).getChild(CodeFuncdefContext.class, 0).funcDef());
        Symbol symbol = functionScope.getSymbol("func");

        // Assert
        Assertions.assertNotNull(symbol);
    }

    @Test
    public void lookUpFunctionThatDoesNotExist_returnsNull(){
        // Arrange
        ParseTree tree = createTree("number func() = 1;");
        SymbolTableGeneratorListener symbolTable = getWalker(tree);

        // Act
        Symbol symbol = symbolTable.globalScope.getSymbol("funcDoesNotExist");

        // Assert
        Assertions.assertNull(symbol);
    }

    @Test
    public void twoParametersWithSameName_throws(){
        // Arrange
        ParseTree tree = createTree("number func(number x, boolean x) = 1;");

        // Act
        // Assert
        Assertions.assertThrows(Exception.class, () -> getWalker(tree));
    }

    @Test
    public void twoFunctionsWithSameName_throws(){
        // Arrange
        ParseTree tree = createTree("number func() = 1; boolean func() = true;");

        // Act
        // Assert
        Assertions.assertThrows(Exception.class, () -> getWalker(tree));
    }
}
