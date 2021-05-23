package Compiler.CodeGeneration;

import Compiler.AntlrGenerated.BuffBaseVisitor;
import Compiler.AntlrGenerated.BuffParser.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static Compiler.AntlrGenerated.BuffLexer.*;
import static Compiler.AntlrGenerated.BuffLexer.BOOLTYPE;

public class FunnyCodeGenerationVisitor extends BuffBaseVisitor<ReturnValue> {
    public Map<String, FuncDefContext> functionDefinitions;
    private Map<String, ReturnValue> parameters;

    public FunnyCodeGenerationVisitor(Map<String, FuncDefContext> functionDefinitions) {
        this.functionDefinitions = functionDefinitions;
    }

    public FunnyCodeGenerationVisitor(Map<String, FuncDefContext> functionDefinitions, Map<String, ReturnValue> parameters) {
        this.functionDefinitions = functionDefinitions;
        this.parameters = parameters;
    }

    @Override
    public ReturnValue visitProg(ProgContext ctx) {
        List<CodeContext> codeContexts = ctx.code();
        for (CodeContext code : codeContexts) {
            if(code.getRuleContext().getClass() == CodeStmtContext.class)
                visit(code);
        }
        // Prog has no need to return anything
        return null;
    }

    @Override
    public ReturnValue visitOneLineFunction(OneLineFunctionContext ctx) {
        return visit(ctx.stmt());
    }

    @Override
    public ReturnValue visitMultiLineFunction(MultiLineFunctionContext ctx) {
        List<StmtsContext> stmtsContextList = ctx.stmts();
        // Evaluates whether or not the if-statement for a stmts is true, and returns its expression if it is.
        for(StmtsContext stmts : stmtsContextList){
            if((Boolean)visit(stmts.expr()).value){
                return visit(stmts.returnStmt());
            }
        }

        return visit(ctx.returnStmt());
    }

    @Override
    public ReturnValue visitStmt(StmtContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ReturnValue visitExprParenthesised(ExprParenthesisedContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ReturnValue visitFuncCall(FuncCallContext ctx) {
        Map<String, ReturnValue> actualArguments = new LinkedHashMap<>();

        if(ctx.exprParams() != null){
            actualArguments = makeArgumentsMapForFuncCall(ctx.ID().getText(), ctx.exprParams());
        }
        FunnyCodeGenerationVisitor funcCallEvaluator = new FunnyCodeGenerationVisitor(functionDefinitions, actualArguments);

        return funcCallEvaluator.visit(functionDefinitions.get(ctx.ID().getText()));
    }

    private Map<String, ReturnValue> makeArgumentsMapForFuncCall(String functionName, ExprParamsContext exprParams){
        Map<String, ReturnValue> actualArguments = new LinkedHashMap<>();

        int exprCount = exprParams.expr().size();
        for (int i = 0; i < exprCount; i++) {
            // Gets the name of the i-th parameter in the function, and puts it in the arguments map with the value
            FuncDefContext funcDef = functionDefinitions.get(functionName);

            if(funcDef.getRuleContext().getClass() == OneLineFunctionContext.class)
                actualArguments.put(((OneLineFunctionContext)funcDef).funcDefParams().typeAndId(i).ID().getText(), visit(exprParams.expr(i)));

            if(funcDef.getRuleContext().getClass() == MultiLineFunctionContext.class)
                actualArguments.put(((MultiLineFunctionContext)funcDef).funcDefParams().typeAndId(i).ID().getText(), visit(exprParams.expr(i)));
        }
        return actualArguments;
    }

    @Override
    public ReturnValue visitExprFunccallPrint(ExprFunccallPrintContext ctx) {
        ReturnValue returnValue = visit(ctx.funcCall());
        System.out.println(ctx.funcCall().getText() + " => " + returnValue.value);
        return returnValue;
    }

    @Override
    public ReturnValue visitExprNumber(ExprNumberContext ctx) {
        double value = Double.parseDouble(ctx.NUMLITERAL().getText());
        return new ReturnValue<Double>(value, NUMTYPE);
    }

    @Override
    public ReturnValue visitExprBoolean(ExprBooleanContext ctx) {
        boolean value = Boolean.parseBoolean(ctx.BOOLLITERAL().getText());
        return new ReturnValue<Boolean>(value, BOOLTYPE);
    }

    @Override
    public ReturnValue visitExprId(ExprIdContext ctx) {
        return parameters.get(ctx.ID().getText());
    }

    @Override
    public ReturnValue visitExprMinusPrefix(ExprMinusPrefixContext ctx) {
        ReturnValue<Double> returnValue = visit(ctx.expr());
        returnValue.value = -returnValue.value;
        return returnValue;
    }

    @Override
    public ReturnValue visitExprUnaryOp(ExprUnaryOpContext ctx) {
        ReturnValue<Boolean> returnValue = visit(ctx.expr());
        returnValue.value = returnValue.value ? false : true;
        return returnValue;
    }

    @Override
    public ReturnValue visitExprBinaryOp(ExprBinaryOpContext ctx) {
        return switch (ctx.op.getType()) {
            case DIVIDE -> new ReturnValue<Double>((Double)visit(ctx.left).value / (Double)visit(ctx.right).value, NUMTYPE);
            case MULTIPLY -> new ReturnValue<Double>((Double)visit(ctx.left).value * (Double)visit(ctx.right).value, NUMTYPE);
            case PLUS -> new ReturnValue<Double>((Double)visit(ctx.left).value + (Double)visit(ctx.right).value, NUMTYPE);
            case MINUS -> new ReturnValue<Double>((Double)visit(ctx.left).value - (Double)visit(ctx.right).value, NUMTYPE);
            case LOGLESS -> new ReturnValue<Boolean>((Double)visit(ctx.left).value < (Double) visit(ctx.right).value, BOOLTYPE);
            case LOGGREATER -> new ReturnValue<Boolean>((Double)visit(ctx.left).value > (Double) visit(ctx.right).value, BOOLTYPE);
            case LOGLESSOREQ -> new ReturnValue<Boolean>((Double)visit(ctx.left).value <= (Double) visit(ctx.right).value, BOOLTYPE);
            case LOGGREATEROREQ -> new ReturnValue<Boolean>((Double)visit(ctx.left).value >= (Double) visit(ctx.right).value, BOOLTYPE);
            case LOGEQ -> new ReturnValue<Boolean>(visit(ctx.left).value.equals(visit(ctx.right).value), BOOLTYPE);
            case LOGNOTEQ -> new ReturnValue<Boolean>(!visit(ctx.left).value.equals(visit(ctx.right).value), BOOLTYPE);
            case LOGAND -> new ReturnValue<Boolean>((Boolean) visit(ctx.left).value && (Boolean) visit(ctx.right).value, BOOLTYPE);
            case LOGOR -> new ReturnValue<Boolean>((Boolean) visit(ctx.left).value || (Boolean) visit(ctx.right).value, BOOLTYPE);
            default -> throw new IllegalArgumentException(
                    "Could not recognize " + ctx.op.getText() + "as a binary operator.");
        };
    }

    @Override
    public ReturnValue visitExprPrint(ExprPrintContext ctx) {
        ReturnValue returnValue = visit(ctx.expr());
        System.out.println(ctx.expr().getText() + " => " + returnValue.value);
        return returnValue;
    }
}
