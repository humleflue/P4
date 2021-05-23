package Compiler.CodeGeneration;

import Compiler.AntlrGenerated.BuffBaseListener;
import Compiler.AntlrGenerated.BuffParser.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class FunctionDefinitionLinkerListener  extends BuffBaseListener {
    public Map<String, FuncDefContext> functionDefinitions = new LinkedHashMap<>();

    @Override
    public void enterOneLineFunction(OneLineFunctionContext ctx) {
        functionDefinitions.put(ctx.typeAndId().ID().getText(), ctx);
    }

    @Override
    public void enterMultiLineFunction(MultiLineFunctionContext ctx) {
        functionDefinitions.put(ctx.typeAndId().ID().getText(), ctx);
    }
}
