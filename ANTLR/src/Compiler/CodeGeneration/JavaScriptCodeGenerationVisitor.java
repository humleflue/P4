package Compiler.CodeGeneration;

import Compiler.AntlrGenerated.LangBaseVisitor;
import Compiler.AntlrGenerated.LangParser.*;

import java.util.List;

// WARNING: This might be a bad idea !!!
// This imports all of our enums from LangLexer,
// so that we don't have to write LangLexer.NUMBERTYPE,
// instead we can just write NUMBERTYPE
import static Compiler.AntlrGenerated.LangLexer.*;

public class JavaScriptCodeGenerationVisitor extends LangBaseVisitor<String> {
    @Override
    protected String defaultResult() {
        return "";
    }

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

    @Override
    public String visitFuncdef(FuncdefContext ctx) {
        String result = "function ";

        result += ctx.ID().getText();
        result += "(";
        result += visit(ctx.funcdefparams());
        result += ") { ";
        result += visit(ctx.stmts());
        result += "return ";
        result += visit(ctx.stmt());
        result += "} ";

        return result;
    }

    @Override
    public String visitFuncdefparamsNotEmpty(FuncdefparamsNotEmptyContext ctx) {
        //Gets lists of parameter nodes in the formal parameters
        List<FuncdefparamContext> params =  ctx.getRuleContexts(FuncdefparamContext.class);
        String result = visit(ctx.funcdefparam(0));

        for(int i = 1; i < params.size(); i++) {
            result += ", ";
            result += visit(ctx.funcdefparam(i));
        }

        return result;
    }

    @Override
    public String visitFuncdefparam(FuncdefparamContext ctx) {
        return ctx.ID().getText();
    }

    @Override
    public String visitStmtsNotEmpty(StmtsNotEmptyContext ctx) {
        String result = "if(";

        result += visit(ctx.expr());
        result += ") return ";
        result += visit(ctx.stmt());
        result += visit(ctx.stmts());

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
            case POW -> throw new IllegalArgumentException("POW operator should've already been handled.");
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

    @Override
    public String visitValFunccallPrint(ValFunccallPrintContext ctx) {
        return "console.log(" + visit(ctx.funccall()) + ")";
    }

    @Override
    public String visitValNumber(ValNumberContext ctx) {
        return ctx.NUMLITERAL().getText();
    }

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
