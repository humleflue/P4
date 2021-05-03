package Compiler.CodeGeneration;

import Compiler.AntlrGenerated.BuffBaseVisitor;
import Compiler.AntlrGenerated.BuffParser.*;

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
        List<CodeContext> codes = ctx.getRuleContexts(CodeContext.class);
        String result = "";
        for (int i = 0; i < codes.size(); i++)
            result += visit(ctx.code(i));
        return result;
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
     * Generates code for a function definition node.
     * @param ctx The tree node in question.
     * @return A string of the form: {@code "function id(param0, param1 , ... , paramN) &#123; functionBody &#125;}".
     */
    @Override
    public String visitFuncDef(FuncDefContext ctx) {
        String result = "function ";

        // The function will have the same id in the generated code.
        result += ctx.typeAndId().ID().getText();
        result += "(";
        result += visit(ctx.funcDefParams());
        result += ") { ";

        List<StmtsContext> stmts =  ctx.getRuleContexts(StmtsContext.class);
        for(int i = 0; i < stmts.size(); i++)
            result += visit(ctx.stmts(i)) + " ";

        result += visitReturnStmt(ctx.returnStmt());
        result += "} ";

        return result;
    }

    @Override
    public String visitReturnStmt(ReturnStmtContext ctx) {
        String result = "return ";
        result += visit(ctx.stmt());
        return result;
    }

    /**
     * Generates code for a function definition's parameter list.
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code param0, param1, ... , paramN}".
     */
    @Override
    public String visitFuncDefParams(FuncDefParamsContext ctx) {
        //Gets lists of parameter nodes in the formal parameters
        List<TypeAndIdContext> params =  ctx.getRuleContexts(TypeAndIdContext.class);
        // Visit the first parameter outside the for-loop to be able to place the comma correctly inside the loop
        String result = visit(ctx.typeAndId(0));

        for(int i = 1; i < params.size(); i++) {
            result += ", ";
            result += visit(ctx.typeAndId(i));
        }

        return result;
    }

    @Override
    public String visitTypeAndId(TypeAndIdContext ctx) {
        String result = "";
        result += visit(ctx.type()) + " ";
        result += ctx.ID().getText();
        return result;
    }

    @Override
    public String visitType(TypeContext ctx) {
        return "";
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

        String result = "(()=>{";
        result += String.format("let res = %s(%s);", GetFuncName(ctx.funcCall()), exprParams);
        result += String.format("console.log(`%s(", GetFuncName(ctx.funcCall()));

        if (!exprParams.isEmpty()) {
            String[] exprParamsArray = exprParams.split(",");

            for (int i = 0; i < exprParamsArray.length - 1; i++) {
                result += String.format("${%s},", exprParamsArray[i]);
            }
            result += String.format("${%s}", exprParamsArray[exprParamsArray.length - 1]);
        }

        result += ") => ${res}`); return res;})()";
        return result;
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

    @Override
    public String visitExprBoolean(ExprBooleanContext ctx) {
        return ctx.BOOLLITERAL().getText();
    }

    @Override
    public String visitExprId(ExprIdContext ctx) {
        return ctx.getText();
    }

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
        List<ExprContext> params =  ctx.getRuleContexts(ExprContext.class);
        String result = visit(ctx.expr(0));

        for(int i = 1; i < params.size(); i++) {
            result += ", ";
            result += visit(ctx.expr(i));
        }

        return result;
    }
}
