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
        return visit(ctx.code());
    }

    @Override
    public String visitCodeFuncdef(CodeFuncdefContext ctx) {
        return visit(ctx.funcdef()) + visit(ctx.code());
    }

    @Override
    public String visitCodeStmt(CodeStmtContext ctx) {
        return visit(ctx.stmt()) + visit(ctx.code());
    }

    /**
     * Generates code for a function definition node.
     * @param ctx The tree node in question.
     * @return A string of the form: {@code "function id(param0, param1 , ... , paramN) &#123; functionBody &#125;}".
     */
    @Override
    public String visitFuncdef(FuncdefContext ctx) {
        String result = "function ";

        // The function will have the same id in the generated code.
        result += ctx.ID().getText();
        result += "(";
        result += visit(ctx.funcdefparams());
        result += ") { ";

        List<StmtsContext> stmts =  ctx.getRuleContexts(StmtsContext.class);
        for(int i = 0; i < stmts.size(); i++)
            result += visit(ctx.stmts(i)) + " ";

        result += "return ";
        result += visit(ctx.stmt());
        result += "} ";

        return result;
    }

    /**
     * Generates code for a function definition's parameter list.
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code param0, param1, ... , paramN}".
     */
    @Override
    public String visitFuncdefparamsNotEmpty(FuncdefparamsNotEmptyContext ctx) {
        //Gets lists of parameter nodes in the formal parameters
        List<FuncdefparamContext> params =  ctx.getRuleContexts(FuncdefparamContext.class);
        // Visit the first parameter outside the for-loop to be able to place the comma correctly inside the loop
        String result = visit(ctx.funcdefparam(0));

        for(int i = 1; i < params.size(); i++) {
            result += ", ";
            result += visit(ctx.funcdefparam(i));
        }

        return result;
    }

    /**
     * Generates code for a function definition's parameter
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code id}", as JavaScript is loosely typed, no type has to be provided.
     */
    @Override
    public String visitFuncdefparam(FuncdefparamContext ctx) {
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
        result += ") return ";
        result += visit(ctx.stmt());

        return result;
    }

    @Override
    public String visitStmt(StmtContext ctx) {
        return visit(ctx.expr()) + "; ";
    }

    @Override
    public String visitValue(ValueContext ctx) {
        return visit(ctx.val());
    }

    @Override
    public String visitUneryOp(UneryOpContext ctx) {
        return "!" + visit(ctx.val());
    }

    /**
     * Generates code for a binary operation.
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code expr operator expr}" - unless in the special case of the {@code POW} (power) operator,
     * then the string of the form "{@code Math.pow(expr, expr)}" is returned instead.
     */
    @Override
    public String visitBinaryOp(BinaryOpContext ctx) {
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
            case LOGEQ ->          "==";
            case LOGNOTEQ ->       "!=";
            case LOGAND ->         "&&";
            case LOGOR ->          "||";
            default -> throw new IllegalArgumentException(
                    "Could not recognize " + ctx.op.getText() + "as a binary operator.");
        };

        return result + expr2;
    }

    @Override
    public String visitValParenthesisedExpr(ValParenthesisedExprContext ctx) {
        return "(" + visit(ctx.expr()) + ")";
    }

    @Override
    public String visitValFunccall(ValFunccallContext ctx) {
        return visit(ctx.funccall());
    }

    /**
     * Generates code for a function call, where the result has to get printed to the user's screen.
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code console.log(id(param0, param1, ... , paramN) => result)}"
     */
    @Override
    public String visitValFunccallPrint(ValFunccallPrintContext ctx) {
        String exprParams = visit(ctx.funccall().exprparams());

        String result = "(()=>{";
        result += String.format("let res = %s(%s);", GetFuncName(ctx.funccall()), exprParams);
        result += String.format("console.log(`%s(", GetFuncName(ctx.funccall()));

        if (!exprParams.isEmpty()) {
            String[] exprParamsArray = exprParams.split(",");

            for (int i = 0; i < exprParamsArray.length; i++) {
                if (i == exprParamsArray.length - 1)
                    result += String.format("${%s}", exprParamsArray[i]);
                else
                    result += String.format("${%s},", exprParamsArray[i]);
            }
            
        }

        result += ") => ${res}`); return res;})()";
        return result;
    }

    /**
     *
     * @param ctx The tree node in question
     * @return the ID (name) of the function call
     */
    String GetFuncName(FunccallContext ctx){
        return ctx.ID().getText();
    }
    /**
     * Generates code for a number.
     * @param ctx The tree node in question.
     * @return The same number as in the source code.
     */
    @Override
    public String visitValNumber(ValNumberContext ctx) {
        return ctx.NUMLITERAL().getText();
    }

    /**
     * Generates code for a boolean.
     * @param ctx The tree node in question.
     * @return The same boolean as in the source code.
     * Therefore, the string, which is returned, can either be "{@code true}" or "{@code false}").
     */
    @Override
    public String visitValBoolean(ValBooleanContext ctx) {
        return ctx.BOOLLITERAL().getText();
    }


    @Override
    public String visitValId(ValIdContext ctx) {
        return ctx.ID().getText();
    }

    @Override
    public String visitFunccall(FunccallContext ctx) {
        return ctx.ID().getText() + "(" + visit(ctx.exprparams()) + ")";
    }

    /**
     * Generates code for a function call's parameter list.
     * @param ctx The tree node in question.
     * @return A string of the form: "{@code expr0, expr1, ... , exprN}".
     */
    @Override
    public String visitExprparamsNotEmpty(ExprparamsNotEmptyContext ctx) {
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
