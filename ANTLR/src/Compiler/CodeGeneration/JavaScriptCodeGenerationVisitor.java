package Compiler.CodeGeneration;

import Compiler.AntlrGenerated.BuffBaseVisitor;
import Compiler.AntlrGenerated.BuffParser.*;
import Compiler.ContextualAnalysis.Lambda;

import java.util.ArrayList;
import java.util.List;

// WARNING: This might be a bad idea !!!
// This imports all of our enums from LangLexer,
// so that we don't have to write LangLexer.NUMBERTYPE,
// instead we can just write NUMBERTYPE
import static Compiler.AntlrGenerated.BuffLexer.*;

public class JavaScriptCodeGenerationVisitor extends BuffBaseVisitor<String> {

    /**
     * This is the result, which is returned, when we visit empty productions.
     * @return An empty string.
     */
    @Override
    protected String defaultResult() {
        return "";
    }

    /**
     * The root of the tree.
     */
    @Override
    public String visitProg(ProgContext ctx) {
        int codeSize = ctx.getRuleContexts(CodeContext.class).size();
        return getStringFromTokenList(i -> visit(ctx.code(i)), codeSize);
    }

    @Override
    public String visitCodeFuncdef(CodeFuncdefContext ctx) {
        return visit(ctx.funcDef());
    }

    @Override
    public String visitCodeStmt(CodeStmtContext ctx) {
        return visit(ctx.stmt());
    }


    /**
     * Generates code for an if function definition node.
     * @param ctx The tree node in question.
     * @return A string of the form: {@code "function id(param0, param1 , ... , paramN) &#123; functionBody &#125;}".
     */
    @Override
    public String visitMultiLineFunction(MultiLineFunctionContext ctx) {
        String result = initiateFuncDef(ctx.typeAndId(), ctx.funcDefParams());

        int stmtsSize =  ctx.getRuleContexts(StmtsContext.class).size();

        result += getStringFromTokenList(i -> visit(ctx.stmts(i)),  stmtsSize);

        result += endFunction(ctx.returnStmt());

        return result;

    }

    @Override
    public String visitOneLineFunction(OneLineFunctionContext ctx) {
        return initiateFuncDef(ctx.typeAndId(), ctx.funcDefParams()) + endFunction(ctx.stmt());
    }

    private String initiateFuncDef(TypeAndIdContext typeAndId, FuncDefParamsContext funcParams){
        String result = "function ";

        // The function will have the same id in the generated code.
        result += visit(typeAndId);
        result += "(";
        if(funcParams != null){
            result += visit(funcParams);
        }
        result += ") { ";

        return result;
    }

    private String endFunction(StmtContext stmt){
        return "return " + visit(stmt) + "} ";
    }

    private String endFunction(ReturnStmtContext returnStmt){
        return visit(returnStmt) + "} ";
    }

    @Override
    public String visitReturnStmt(ReturnStmtContext ctx) {
        return "return " + visit(ctx.stmt());
    }

    /**
     * Generates code for a function definition's parameter list.
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code param0, param1, ... , paramN}".
     */
    @Override
    public String visitFuncDefParams(FuncDefParamsContext ctx) {
        //Gets lists of parameter nodes in the formal parameters
        int paramsSize =  ctx.getRuleContexts(TypeAndIdContext.class).size();
        // Visit the first parameter outside the for-loop to be able to place the comma correctly inside the loop
        String result = visit(ctx.typeAndId(0));

        result += getStringFromTokenList(i -> visit(ctx.typeAndId(i)), 1, paramsSize, ", ");

        return result;
    }

    @Override
    public String visitTypeAndId(TypeAndIdContext ctx) {
        return ctx.ID().getText();
    }


    /**
     * Generates code for an if-statement.
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code if(expression) return statement statements}".
     */
    @Override
    public String visitStmts(StmtsContext ctx) {
        String result = "if(";

        result += visit(ctx.expr());
        result += ") ";
        result += visit(ctx.returnStmt());

        return result;
    }

    @Override
    public String visitStmt(StmtContext ctx) {
        return visit(ctx.expr()) + "; ";
    }


    @Override
    public String visitExprUnaryOp(ExprUnaryOpContext ctx) {
        return "!" + visit(ctx.expr());
    }

    /**
     * Generates code for a binary operation.
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code expr operator expr}" - unless in the special case of the {@code POW} (power) operator,
     * then the string of the form "{@code Math.pow(expr, expr)}" is returned instead.
     */
    @Override
    public String visitExprBinaryOp(ExprBinaryOpContext ctx) {
        String expr1 = visit(ctx.expr(0));
        String expr2 = visit(ctx.expr(1));

        // Special case
        if(ctx.op.getType() == POW) {
            return String.format("Math.pow(%s, %s)", expr1, expr2);
        }

        String result = expr1;
        result += switch (ctx.op.getType()) {
            case DIVIDE ->         "/";
            case MULTIPLY ->       "*";
            case PLUS ->           "+";
            case MINUS ->          "-";
            case LOGLESS ->        "<";
            case LOGGREATER ->     ">";
            case LOGLESSOREQ ->    "<=";
            case LOGGREATEROREQ -> ">=";
            case LOGEQ ->          "===";
            case LOGNOTEQ ->       "!==";
            case LOGAND ->         "&&";
            case LOGOR ->          "||";
            default -> throw new IllegalArgumentException(
                    "Could not recognize " + ctx.op.getText() + "as a binary operator.");
        };

        return result + expr2;
    }

    @Override
    public String visitExprParenthesised(ExprParenthesisedContext ctx) {
        return "(" + visit(ctx.expr()) + ")";
    }

    @Override
    public String visitExprFunccall(ExprFunccallContext ctx) {
        return visit(ctx.funcCall());
    }

    /**
     * Generates code for a function call, where the result has to get printed to the user's screen.
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code console.log(id(param0, param1, ... , paramN) => result)}"
     */
    @Override
    public String visitExprFunccallPrint(ExprFunccallPrintContext ctx) {
        String exprParams = visit(ctx.funcCall().exprParams());

        String result = initiatePrintFunction(ctx, exprParams);

        if (!exprParams.isEmpty()) {
            String[] exprParamsArray = exprParams.split(",");

            // Adds result of the parameters to the string
            result += getStringFromTokenList(i -> String.format("${%s},", exprParamsArray[i]),
                    exprParamsArray.length - 1);

            // Adds result of the last parameter to the string
            result += String.format("${%s}", exprParamsArray[exprParamsArray.length - 1]);
        }

        result += terminatePrintFunction();
        return result;
    }

    private String initiatePrintFunction(ExprFunccallPrintContext ctx, String exprParams){
        String result = "(()=>{";
        result += String.format("let res = %s(%s);", GetFuncName(ctx.funcCall()), exprParams);
        result += String.format("console.log(`%s(", GetFuncName(ctx.funcCall()));
        return result;
    }

    private String terminatePrintFunction(){
        return ") => ${res}`); return res;})()";
    }

    /**
     *
     * @param ctx The tree node in question
     * @return the ID (name) of the function call
     */
    String GetFuncName(FuncCallContext ctx){
        return ctx.ID().getText();
    }
    /**
     * Generates code for a number.
     * @param ctx The tree node in question.
     * @return The same number as in the source code.
     */
    @Override
    public String visitExprNumber(ExprNumberContext ctx) {
        return ctx.NUMLITERAL().getText();
    }

    /**
     * Generates code for a boolean.
     * @param ctx The tree node in question.
     * @return The same boolean as in the source code.
     * Therefore, the string, which is returned, can either be "{@code true}" or "{@code false}").
     */
    @Override
    public String visitExprBoolean(ExprBooleanContext ctx) {
        return ctx.BOOLLITERAL().getText();
    }

    /**
     * Generates code for an ID.
     * @param ctx The tree node in question.
     * @return The same ID as in the source code..
     */
    @Override
    public String visitExprId(ExprIdContext ctx) {
        return ctx.ID().getText();
    }

    /**
     * Generates code for a function call
     * @param ctx The tree node in question.
     * @return the ID followed by ( Expr params )
     */
    @Override
    public String visitFuncCall(FuncCallContext ctx) {
        return ctx.ID().getText() + "(" + visit(ctx.exprParams()) + ")";
    }

    /**
     * Generates code for a function call's parameter list.
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code expr0, expr1, ... , exprN}".
     */
    @Override
    public String visitExprParams(ExprParamsContext ctx) {
        //Gets lists of parameter nodes in the formal parameters
        int paramsSize =  ctx.getRuleContexts(ExprContext.class).size();
        String result = visit(ctx.expr(0));

        result += getStringFromTokenList(i -> visit(ctx.expr(i)), 1, paramsSize, ", ");

        return result;
    }

    /**
     * Returns a string from a list of tokens.
     * @param manipulateTokens A lambda function which will be performed on the list of tokens
     * @param amountOfTokens The end index
     * @return The resulting string
     */
    private String getStringFromTokenList(Lambda<String> manipulateTokens, Integer amountOfTokens){
        return getStringFromTokenList(manipulateTokens, 0, amountOfTokens, "");
    }

    /**
     * Returns a string from a list of tokens.
     * @param manipulateTokens A lambda function which will be performed on the list of tokens
     * @param from The start index
     * @param to The end index
     * @param delimiter The delimiter you want a string to be seperated by
     * @return The resulting string
     */
    private String getStringFromTokenList(Lambda<String> manipulateTokens, Integer from, Integer to, String delimiter){
        String result = "";
        for (int i = from; i < to; i++) {
            result += delimiter;
            result += manipulateTokens.execute(i);
        }
        return result;
    }

}
