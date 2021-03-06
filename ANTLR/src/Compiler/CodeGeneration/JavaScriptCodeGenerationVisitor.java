package Compiler.CodeGeneration;

import Compiler.AntlrGenerated.BuffBaseVisitor;
import Compiler.AntlrGenerated.BuffParser.*;
import Compiler.Lambda;

import static Compiler.AntlrGenerated.BuffLexer.DIVIDE;
import static Compiler.AntlrGenerated.BuffLexer.LOGAND;
import static Compiler.AntlrGenerated.BuffLexer.LOGEQ;
import static Compiler.AntlrGenerated.BuffLexer.LOGGREATER;
import static Compiler.AntlrGenerated.BuffLexer.LOGGREATEROREQ;
import static Compiler.AntlrGenerated.BuffLexer.LOGLESS;
import static Compiler.AntlrGenerated.BuffLexer.LOGLESSOREQ;
import static Compiler.AntlrGenerated.BuffLexer.LOGNOTEQ;
import static Compiler.AntlrGenerated.BuffLexer.LOGOR;
import static Compiler.AntlrGenerated.BuffLexer.MINUS;
import static Compiler.AntlrGenerated.BuffLexer.MULTIPLY;
import static Compiler.AntlrGenerated.BuffLexer.PLUS;
import static Compiler.AntlrGenerated.BuffLexer.POW;

public class JavaScriptCodeGenerationVisitor extends BuffBaseVisitor<String> {

    /**
     * This is the result, which is returned, when we visit empty productions.
     *
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
        int codeSize = ctx.code().size();
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
     *
     * @param ctx The tree node in question.
     * @return A string of the form: {@code "function id(param0, param1 , ... , paramN) &#123; functionBody &#125;}".
     */
    @Override
    public String visitMultiLineFunction(MultiLineFunctionContext ctx) {
        String result = initiateFuncDef(ctx.typeAndId(), ctx.funcDefParams());

        int stmtsSize = ctx.stmts().size();

        result += getStringFromTokenList(i -> visit(ctx.stmts(i)), stmtsSize);

        result += endFunction(ctx.returnStmt());

        return result;

    }

    /**
     * Generates the JS code for a one line function
     *
     * @param ctx The node from the CST
     * @return Returns a string containing the function definition
     */
    @Override
    public String visitOneLineFunction(OneLineFunctionContext ctx) {
        return initiateFuncDef(ctx.typeAndId(), ctx.funcDefParams()) + endFunction(ctx.stmt());
    }

    /**
     * Initiates the start of a function definition
     *
     * @param typeAndId  Used to get the name of the function
     * @param funcParams Used to get the parameters of the function
     * @return Returns as string with the function signature
     */
    private String initiateFuncDef(TypeAndIdContext typeAndId, FuncDefParamsContext funcParams) {
        String result = "function ";

        // The function will have the same id in the generated code.
        result += visit(typeAndId);
        result += "(";
        if (funcParams != null) {
            result += visit(funcParams);
        }
        result += ") { ";

        return result;
    }

    /**
     * Gives the end of a multilinefunction (requires the 'return' keyword)
     *
     * @param stmt The return statement
     * @return Returns a string containing the return statement of a multiLineFunction
     */
    private String endFunction(StmtContext stmt) {
        return "return " + visit(stmt) + "} ";
    }

    /**
     * Gives the end of a oneLineFunction
     *
     * @param returnStmt The return statement
     * @return Returns a string containing the end of a oneLineFunction
     */
    private String endFunction(ReturnStmtContext returnStmt) {
        return visit(returnStmt) + "} ";
    }

    @Override
    public String visitReturnStmt(ReturnStmtContext ctx) {
        return "return " + visit(ctx.stmt());
    }

    /**
     * Generates code for a function definition's parameter list.
     *
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code param0, param1, ... , paramN}".
     */
    @Override
    public String visitFuncDefParams(FuncDefParamsContext ctx) {
        //Gets lists of parameter nodes in the formal parameters
        int paramsSize = ctx.typeAndId().size();
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
     *
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

    @Override
    public String visitExprMinusPrefix(ExprMinusPrefixContext ctx) {
        return "-" + visit(ctx.expr());
    }

    /**
     * Generates code for a binary operation.
     *
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code expr operator expr}" - unless in the special case of the {@code POW} (power) operator,
     * then the string of the form "{@code Math.pow(expr, expr)}" is returned instead.
     */
    @Override
    public String visitExprBinaryOp(ExprBinaryOpContext ctx) {
        String expr1 = visit(ctx.expr(0));
        String expr2 = visit(ctx.expr(1));

        // Special case
        if (ctx.op.getType() == POW) {
            return String.format("Math.pow(%s, %s)", expr1, expr2);
        }

        String result = expr1;
        result += switch (ctx.op.getType()) {
            case DIVIDE -> "/";
            case MULTIPLY -> "*";
            case PLUS -> "+";
            case MINUS -> "-";
            case LOGLESS -> "<";
            case LOGGREATER -> ">";
            case LOGLESSOREQ -> "<=";
            case LOGGREATEROREQ -> ">=";
            case LOGEQ -> "===";
            case LOGNOTEQ -> "!==";
            case LOGAND -> "&&";
            case LOGOR -> "||";
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
     *
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code console.log(id(param0, param1, ... , paramN) => result)}"
     */
    @Override
    public String visitExprFunccallPrint(ExprFunccallPrintContext ctx) {
        String exprParams = "";
        if (ctx.funcCall().exprParams() != null)
            exprParams = visit(ctx.funcCall().exprParams());

        String result = initiatePrintFunction(ctx, exprParams);

        if (!exprParams.isEmpty()) {
            String[] exprParamsArray = exprParams.split(",");

            // Adds result of the parameters to the string (parameters can be expressions)
            result += getStringFromTokenList(i -> String.format("${%s},", exprParamsArray[i]),
                    exprParamsArray.length - 1);

            // Adds result of the last parameter to the string (parameters can be expressions)
            result += String.format("${%s}", exprParamsArray[exprParamsArray.length - 1]);
        }

        result += terminatePrintFunction();
        return result;
    }

    /**
     * Initiates a function that should be printed by wrapping it in an anonymous functioncall
     *
     * @param ctx        The funcCallPrint node in hand
     * @param exprParams The parameters of the function
     * @return A string containing an anonymous function call which prints the function and the results
     */
    private String initiatePrintFunction(ExprFunccallPrintContext ctx, String exprParams) {
        String result = "(()=>{";
        result += String.format("const res = %s(%s);", GetFuncName(ctx.funcCall()), exprParams);
        result += String.format("console.log(`%s(", GetFuncName(ctx.funcCall()));
        return result;
    }

    private String terminatePrintFunction() {
        return ") => ${res}`); return res;})()";
    }

    /**
     * @param ctx The tree node in question
     * @return the ID (name) of the function call
     */
    String GetFuncName(FuncCallContext ctx) {
        return ctx.ID().getText();
    }

    /**
     * Generates code for a number.
     *
     * @param ctx The tree node in question.
     * @return The same number as in the source code.
     */
    @Override
    public String visitExprNumber(ExprNumberContext ctx) {
        return ctx.NUMLITERAL().getText();
    }

    /**
     * Generates code for a boolean.
     *
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
     *
     * @param ctx The tree node in question.
     * @return The same ID as in the source code..
     */
    @Override
    public String visitExprId(ExprIdContext ctx) {
        return ctx.ID().getText();
    }

    /**
     * Generates code for a function call
     *
     * @param ctx The tree node in question.
     * @return the ID followed by ( Expr params )
     */
    @Override
    public String visitFuncCall(FuncCallContext ctx) {
        return ctx.ID().getText() + "(" + visit(ctx.exprParams()) + ")";
    }

    /**
     * Generates code for a function call's parameter list.
     *
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code expr0, expr1, ... , exprN}".
     */
    @Override
    public String visitExprParams(ExprParamsContext ctx) {
        //Gets lists of parameter nodes in the formal parameters
        int paramsSize = ctx.expr().size();
        String result = visit(ctx.expr(0));

        result += getStringFromTokenList(i -> visit(ctx.expr(i)), 1, paramsSize, ", ");

        return result;
    }

    /**
     * Returns a string from a list of tokens.
     *
     * @param manipulateTokens A lambda function which will be performed on the list of tokens
     * @param amountOfTokens   The end index
     * @return The resulting string
     */
    private String getStringFromTokenList(Lambda<String, Integer> manipulateTokens, Integer amountOfTokens) {
        return getStringFromTokenList(manipulateTokens, 0, amountOfTokens, "");
    }

    /**
     * Returns a string from a list of tokens.
     *
     * @param manipulateTokens A lambda function which will be performed on the list of tokens
     * @param from             The start index
     * @param to               The end index
     * @param delimiter        The delimiter you want a string to be seperated by
     * @return The resulting string
     */
    private String getStringFromTokenList(Lambda<String, Integer> manipulateTokens, Integer from, Integer to, String delimiter) {
        StringBuilder result = new StringBuilder();
        for (int i = from; i < to; i++) {
            result.append(delimiter);
            result.append(manipulateTokens.execute(i));
        }
        return result.toString();
    }

}
