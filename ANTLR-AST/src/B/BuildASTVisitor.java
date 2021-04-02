package B;

import B.Nodes.Abstract.Node;
import B.Nodes.Nodes.*;

public class BuildASTVisitor extends BBaseVisitor<Node>{
    public Node visit(BParser.ProgContext ctx){
        return visitCode(ctx.code());
    }

    public Node visitCode(BParser.CodeContext ctx){
        if (IsCodeFuncContext(ctx))
            return visitCodeFuncdef((BParser.CodeFuncdefContext) ctx);
        else if (IsCodeStmtContext(ctx))
            return visitCodeStmt((BParser.CodeStmtContext) ctx);
        else
            return null;
    }

    boolean IsCodeFuncContext(BParser.CodeContext ctx){
        return ctx instanceof BParser.CodeFuncdefContext;
    }

    boolean IsCodeStmtContext(BParser.CodeContext ctx){
        return ctx instanceof BParser.CodeStmtContext;
    }

    @Override
    public Node visitCodeFuncdef(BParser.CodeFuncdefContext ctx) {
        return new CodeFuncDef(visitFuncdef(ctx.funcdef()), visitCode(ctx.code()));
    }

    @Override
    public Node visitCodeStmt(BParser.CodeStmtContext ctx) {
        return new CodeStmt(visitStmt(ctx.stmt()), visitCode(ctx.code()));
    }

    @Override
    public Node visitCodeEmpty(BParser.CodeEmptyContext ctx) {
        return null;
    }

    @Override
    public Node visitFuncdef(BParser.FuncdefContext ctx) {
        if (IsFuncdefparamsNotEmpty(ctx.funcdefparams()))
            return new FuncDef(visitType(ctx.type()), ctx.ID().getText(),
                    visitFuncdefparamsNotEmpty((BParser.FuncdefparamsNotEmptyContext) ctx.funcdefparams()),
                    visitStmts(ctx.stmts()), visitStmt(ctx.stmt()));
        else
            return new FuncDef(visitType(ctx.type()), ctx.ID().getText(),
                    visitFuncdefparamsEmpty((BParser.FuncdefparamsEmptyContext) ctx.funcdefparams()),
                    visitStmts(ctx.stmts()), visitStmt(ctx.stmt()));
    }

    private boolean IsStmtsEmpty(BParser.StmtsContext ctx) {
        return ctx instanceof BParser.StmtsEmptyContext;
    }

    private boolean IsFuncdefmoreparamsNotEmpty(BParser.FuncdefmoreparamsContext ctx) {
        return ctx instanceof BParser.FuncdefmoreparamsNotEmptyContext;
    }

    @Override
    public Node visitType(BParser.TypeContext ctx) {
        return new Type(ctx.getText());
    }

    @Override
    public Node visitFuncdefmoreparamsNotEmpty(BParser.FuncdefmoreparamsNotEmptyContext ctx) {
        if (IsFuncdefmoreparamsNotEmpty(ctx.funcdefmoreparams()))
            return new FuncDefMoreParams(visitFuncdefparam(ctx.funcdefparam()),
                visitFuncdefmoreparamsNotEmpty((BParser.FuncdefmoreparamsNotEmptyContext) ctx.funcdefmoreparams()));
        else
            return new FuncDefMoreParams(visitFuncdefparam(ctx.funcdefparam()),
                    visitFuncdefmoreparamsEmpty((BParser.FuncdefmoreparamsEmptyContext) ctx.funcdefmoreparams()));
    }

    @Override
    public Node visitFuncdefmoreparamsEmpty(BParser.FuncdefmoreparamsEmptyContext ctx) {
        return null;
    }

    @Override
    public Node visitFuncdefparamsNotEmpty(BParser.FuncdefparamsNotEmptyContext ctx) {
        if (IsFuncdefmoreparamsNotEmpty(ctx.funcdefmoreparams()))
            return new FuncDefParams(visitFuncdefparam(ctx.funcdefparam()),
                    visitFuncdefmoreparamsNotEmpty((BParser.FuncdefmoreparamsNotEmptyContext) ctx.funcdefmoreparams()));
        else
            return new FuncDefParams(visitFuncdefparam(ctx.funcdefparam()),
                    visitFuncdefmoreparamsEmpty((BParser.FuncdefmoreparamsEmptyContext) ctx.funcdefmoreparams()));
    }

    @Override
    public Node visitFuncdefparamsEmpty(BParser.FuncdefparamsEmptyContext ctx) {
        return null;
    }

    private boolean IsFuncdefparamsNotEmpty(BParser.FuncdefparamsContext ctx) {
        return ctx instanceof BParser.FuncdefparamsNotEmptyContext;
    }

    @Override
    public Node visitFuncdefparam(BParser.FuncdefparamContext ctx) {
        return new FuncDefParam(visitType(ctx.type()), ctx.ID().getText());
    }

    @Override
    public Node visitStmtsNotEmpty(BParser.StmtsNotEmptyContext ctx) {
                return new Stmts(visitExpr(ctx.expr()),visitStmt(ctx.stmt()),
                        visitStmts(ctx.stmts()));
    }

    public Node visitStmts(BParser.StmtsContext ctx){
        if (IsStmtsEmpty(ctx))
            return visitStmtsEmpty((BParser.StmtsEmptyContext) ctx);
        else
            return visitStmtsNotEmpty((BParser.StmtsNotEmptyContext) ctx);
    }

    private Node visitExpr(BParser.ExprContext expr) {
        if (IsLogOrOp(expr))
            return visitLogOrOp((BParser.LogOrOpContext) expr);
        else
            return visitLog((BParser.LogContext) expr);
    }

    boolean IsLogOrOp(BParser.ExprContext ctx){
        return ctx instanceof BParser.LogOrOpContext;
    }

    @Override
    public Node visitStmtsEmpty(BParser.StmtsEmptyContext ctx) {
        return null;
    }

    @Override
    public Node visitStmt(BParser.StmtContext ctx) {
        if (IsLogOrOp(ctx.expr()))
            return new Stmt(visitLogOrOp((BParser.LogOrOpContext) ctx.expr()));
        else {
            return new Stmt(visitLog((BParser.LogContext) ctx.expr()));
        }
    }

    @Override
    public Node visitLogOrOp(BParser.LogOrOpContext ctx) {
        if (IsLogAndOp(ctx.left)) {
            if (IsLogOrOp(ctx.right))
                return new LogOrOp(visitLogAndOp((BParser.LogAndOpContext) ctx.left),
                        visitLogOrOp((BParser.LogOrOpContext) ctx.right));
            else
                return new LogOrOp(visitLogAndOp((BParser.LogAndOpContext) ctx.left),
                        visitLog((BParser.LogContext) ctx.right));
        }
        else {
            if (IsLogOrOp(ctx.right))
                return new LogOrOp(visitLog2((BParser.Log2Context) ctx.left),
                        visitLogOrOp((BParser.LogOrOpContext) ctx.right));
            else
                return new LogOrOp(visitLog2((BParser.Log2Context) ctx.left),
                        visitLog((BParser.LogContext) ctx.right));
        }
    }

    boolean IsLogAndOp(BParser.LogexprContext ctx){
        return ctx instanceof BParser.LogAndOpContext;
    }

    @Override
    public Node visitLog(BParser.LogContext ctx) {
        if (IsLogAndOp(ctx.logexpr()))
            return visitLogAndOp((BParser.LogAndOpContext) ctx.logexpr());
        else
            return visitLog2((BParser.Log2Context) ctx.logexpr());
    }

    @Override
    public Node visitLogAndOp(BParser.LogAndOpContext ctx) {
        if (IsLogEqualsOp(ctx.left)){
            if (IsLogAndOp(ctx.right))
                return new LogAndOp(visitLogEqualsOp((BParser.LogEqualsOpContext) ctx.left),
                        visitLogAndOp((BParser.LogAndOpContext) ctx.right));
            else
                    return new LogAndOp(visitLogEqualsOp((BParser.LogEqualsOpContext) ctx.left),
                            visitLog2((BParser.Log2Context) ctx.right));
        }
        else{
            if (IsLogAndOp(ctx.right))
                return new LogAndOp(visitLog3((BParser.Log3Context) ctx.left),
                        visitLogAndOp((BParser.LogAndOpContext) ctx.right));
            else
                return new LogAndOp(visitLog3((BParser.Log3Context) ctx.left),
                        visitLog2((BParser.Log2Context) ctx.right));
        }
    }

    boolean IsLogEqualsOp(BParser.Logexpr2Context ctx){
        return ctx instanceof BParser.LogEqualsOpContext;
    }

    @Override
    public Node visitLog2(BParser.Log2Context ctx) {
        if (IsLogEqualsOp(ctx.logexpr2()))
            return visitLogEqualsOp((BParser.LogEqualsOpContext) ctx.logexpr2());
        else
            return visitLog3((BParser.Log3Context) ctx.logexpr2());
    }

    @Override
    public Node visitLogEqualsOp(BParser.LogEqualsOpContext ctx) {
        switch (ctx.op.getType()){
            case BLexer.LOGEQ:
                if (IsLogOpContext(ctx.left)) {
                    if (IsLogEqualsOpContext(ctx.right))
                        return new LogEquals(visitLogOp((BParser.LogOpContext) ctx.left),
                                visitLogEqualsOp((BParser.LogEqualsOpContext) ctx.right));
                    else
                        return new LogEquals(visitLogOp((BParser.LogOpContext) ctx.left),
                                visitLog3((BParser.Log3Context) ctx.right));
                }
                else {
                    if (IsLogEqualsOpContext(ctx.right))
                        return new LogEquals(visitMath((BParser.MathContext) ctx.left),
                                visitLogEqualsOp((BParser.LogEqualsOpContext) ctx.right));
                    else
                        return new LogEquals(visitMath((BParser.MathContext) ctx.left),
                                visitLog3((BParser.Log3Context) ctx.right));
                }
            case BLexer.LOGNOTEQ:
                if (IsLogOpContext(ctx.left)) {
                    if (IsLogEqualsOpContext(ctx.right))
                        return new LogNotEquals(visitLogOp((BParser.LogOpContext) ctx.left),
                                visitLogEqualsOp((BParser.LogEqualsOpContext) ctx.right));
                    else
                        return new LogNotEquals(visitLogOp((BParser.LogOpContext) ctx.left),
                                visitLog3((BParser.Log3Context) ctx.right));
                }
                else
                if (IsLogEqualsOpContext(ctx.right))
                    return new LogNotEquals(visitMath((BParser.MathContext) ctx.left),
                            visitLogEqualsOp((BParser.LogEqualsOpContext) ctx.right));
                else
                    return new LogNotEquals(visitMath((BParser.MathContext) ctx.left),
                            visitLog3((BParser.Log3Context) ctx.right));
            default :
                return null;
        }
    }
    boolean IsLogOpContext(BParser.Logexpr3Context ctx){
        return ctx instanceof BParser.LogOpContext;
    }
    boolean IsLogEqualsOpContext(BParser.Logexpr2Context ctx){
        return ctx instanceof BParser.LogEqualsOpContext;
    }

    @Override
    public Node visitLog3(BParser.Log3Context ctx) {
        if (ctx.logexpr3() instanceof BParser.LogOpContext)
            return visitLogOp((BParser.LogOpContext) ctx.logexpr3());
        else
            return visitMath((BParser.MathContext) ctx.logexpr3());
    }

    @Override
    public Node visitLogOp(BParser.LogOpContext ctx) {
        switch (ctx.op.getType()) {
            case BLexer.LOGLESS:
                if (IsPlusMinus(ctx.left)) {
                    if (IsLogOpContext(ctx.right))
                        return new LogLess(visitPlusMinus((BParser.PlusMinusContext) ctx.left),
                                visitLogOp((BParser.LogOpContext) ctx.right));
                    else
                        return new LogLess(visitPlusMinus((BParser.PlusMinusContext) ctx.left),
                                visitMath((BParser.MathContext) ctx.right));
                }
                else {
                    if (IsLogOpContext(ctx.right))
                        return new LogLess(visitMath2((BParser.Math2Context) ctx.left),
                                visitLogOp((BParser.LogOpContext) ctx.right));
                    else
                        return new LogLess(visitMath2((BParser.Math2Context) ctx.left),
                                visitMath((BParser.MathContext) ctx.right));
                }
            case BLexer.LOGGREATER:
                if (IsPlusMinus(ctx.left)) {
                    if (IsLogOpContext(ctx.right))
                        return new LogGreater(visitPlusMinus((BParser.PlusMinusContext) ctx.left),
                                visitLogOp((BParser.LogOpContext) ctx.right));
                    else
                        return new LogGreater(visitPlusMinus((BParser.PlusMinusContext) ctx.left),
                                visitMath((BParser.MathContext) ctx.right));
                }
                else {
                    if (IsLogOpContext(ctx.right))
                        return new LogGreater(visitMath2((BParser.Math2Context) ctx.left),
                                visitLogOp((BParser.LogOpContext) ctx.right));
                    else
                        return new LogGreater(visitMath2((BParser.Math2Context) ctx.left),
                                visitMath((BParser.MathContext) ctx.right));
                }
            case BLexer.LOGLESSOREQ:
                if (IsPlusMinus(ctx.left)) {
                    if (IsLogOpContext(ctx.right))
                        return new LogLessOrEqual(visitPlusMinus((BParser.PlusMinusContext) ctx.left),
                                visitLogOp((BParser.LogOpContext) ctx.right));
                    else
                        return new LogLessOrEqual(visitPlusMinus((BParser.PlusMinusContext) ctx.left),
                                visitMath((BParser.MathContext) ctx.right));
                }
                else {
                    if (IsLogOpContext(ctx.right))
                        return new LogLessOrEqual(visitMath2((BParser.Math2Context) ctx.left),
                                visitLogOp((BParser.LogOpContext) ctx.right));
                    else
                        return new LogLessOrEqual(visitMath2((BParser.Math2Context) ctx.left),
                                visitMath((BParser.MathContext) ctx.right));
                }
            case BLexer.LOGGREATEROREQ:
                if (IsPlusMinus(ctx.left)) {
                    if (IsLogOpContext(ctx.right))
                        return new LogGreaterOrEqual(visitPlusMinus((BParser.PlusMinusContext) ctx.left),
                                visitLogOp((BParser.LogOpContext) ctx.right));
                    else
                        return new LogGreaterOrEqual(visitPlusMinus((BParser.PlusMinusContext) ctx.left),
                                visitMath((BParser.MathContext) ctx.right));
                }
                else {
                    if (IsLogOpContext(ctx.right))
                        return new LogGreaterOrEqual(visitMath2((BParser.Math2Context) ctx.left),
                                visitLogOp((BParser.LogOpContext) ctx.right));
                    else
                        return new LogGreaterOrEqual(visitMath2((BParser.Math2Context) ctx.left),
                                visitMath((BParser.MathContext) ctx.right));
                }
            default:
                return null;
        }

    }


    @Override
    public Node visitMath(BParser.MathContext ctx) {
        if (IsPlusMinus(ctx.mathexpr()))
            return visitPlusMinus((BParser.PlusMinusContext) ctx.mathexpr());
        else
            return visitMath2((BParser.Math2Context) ctx.mathexpr());
    }

    @Override
    public Node visitPlusMinus(BParser.PlusMinusContext ctx) {
        switch (ctx.op.getType()) {
            case BLexer.PLUS:
                if (IsMultDiv(ctx.left)){
                    if (IsPlusMinus(ctx.right))
                        return new Plus(visitMultDiv((BParser.MultDivContext) ctx.left),
                                visitPlusMinus((BParser.PlusMinusContext) ctx.right));
                    else
                        return new Plus(visitMultDiv((BParser.MultDivContext) ctx.left),
                                visitMath2((BParser.Math2Context) ctx.right));
                }
                else {
                    if (IsPlusMinus(ctx.right))
                        return new Plus(visitMath3((BParser.Math3Context) ctx.left),
                            visitPlusMinus((BParser.PlusMinusContext) ctx.right));
                    else
                        return new Plus(visitMath3((BParser.Math3Context) ctx.left),
                                visitMath2((BParser.Math2Context) ctx.right));

                }
            case BLexer.MINUS:
                if (IsMultDiv(ctx.left)){
                    if (IsPlusMinus(ctx.right))
                        return new Minus(visitMultDiv((BParser.MultDivContext) ctx.left),
                                visitPlusMinus((BParser.PlusMinusContext) ctx.right));
                    else
                        return new Minus(visitMultDiv((BParser.MultDivContext) ctx.left),
                                visitMath2((BParser.Math2Context) ctx.right));
                }
                else {
                    if (IsPlusMinus(ctx.right))
                        return new Minus(visitMath3((BParser.Math3Context) ctx.left),
                                visitPlusMinus((BParser.PlusMinusContext) ctx.right));
                    else
                        return new Minus(visitMath3((BParser.Math3Context) ctx.left),
                                visitMath2((BParser.Math2Context) ctx.right));

                }
            default:
                return null;
        }
    }

    private boolean IsPlusMinus(BParser.MathexprContext ctx) {
        return ctx instanceof BParser.PlusMinusContext;
    }

    private boolean IsMultDiv(BParser.Mathexpr2Context ctx) {
        return ctx instanceof BParser.MultDivContext;
    }

    @Override
    public Node visitMath2(BParser.Math2Context ctx) {
        if (IsMultDiv(ctx.mathexpr2()))
            return visitMultDiv((BParser.MultDivContext) ctx.mathexpr2());
        else
            return visitMath3((BParser.Math3Context) ctx.mathexpr2());
    }

    @Override
    public Node visitMultDiv(BParser.MultDivContext ctx) {
        switch (ctx.op.getType()) {
            case BLexer.MULTIPLY:
                if (IsPowExp(ctx.left)) {
                    if (IsMultDiv(ctx.right))
                        return new Mulitply(visitPow((BParser.PowContext) ctx.left),
                                visitMultDiv((BParser.MultDivContext) ctx.right));
                    else
                        return new Mulitply(visitPow((BParser.PowContext) ctx.left),
                                visitMath3((BParser.Math3Context) ctx.right));
                } else {
                    if (IsMultDiv(ctx.right))
                        return new Mulitply(visitLog4((BParser.Log4Context) ctx.left),
                                visitMultDiv((BParser.MultDivContext) ctx.right));
                    else
                        return new Mulitply(visitLog4((BParser.Log4Context) ctx.left),
                                visitMath3((BParser.Math3Context) ctx.right));
                }
            case BLexer.DIVIDE:
                if (IsPowExp(ctx.left)) {
                    if (IsMultDiv(ctx.right))
                        return new Divide(visitPow((BParser.PowContext) ctx.left),
                                visitMultDiv((BParser.MultDivContext) ctx.right));
                    else
                        return new Divide(visitPow((BParser.PowContext) ctx.left),
                                visitMath3((BParser.Math3Context) ctx.right));
                } else {
                    if (IsMultDiv(ctx.right))
                        return new Divide(visitLog4((BParser.Log4Context) ctx.left),
                                visitMultDiv((BParser.MultDivContext) ctx.right));
                    else
                        return new Divide(visitLog4((BParser.Log4Context) ctx.left),
                                visitMath3((BParser.Math3Context) ctx.right));
                }
            default:
                return null;
        }
    }

    private boolean IsPowExp(BParser.Mathexpr3Context ctx) {
        return ctx instanceof BParser.PowContext;
    }

    @Override
    public Node visitMath3(BParser.Math3Context ctx) {
        if (IsPowExp(ctx.mathexpr3()))
            return visitPow((BParser.PowContext) ctx.mathexpr3());
        else
            return visitLog4((BParser.Log4Context) ctx.mathexpr3());
    }

    @Override
    public Node visitPow(BParser.PowContext ctx) {
        if (IsNegate(ctx.left)){
            if (IsPowExp(ctx.right))
                return new Power(visitNegate((BParser.NegateContext) ctx.left),
                        visitPow((BParser.PowContext) ctx.right));
            else
                return new Power(visitNegate((BParser.NegateContext) ctx.left),
                        visitLog4((BParser.Log4Context) ctx.right));
        }
        else{
            if (IsPowExp(ctx.right))
                return new Power(visitValue((BParser.ValueContext) ctx.left),
                        visitPow((BParser.PowContext) ctx.right));
            else
                return new Power(visitValue((BParser.ValueContext) ctx.left),
                        visitLog4((BParser.Log4Context) ctx.right));
        }
    }

    private boolean IsNegate(BParser.Logexpr4Context ctx) {
        return ctx instanceof BParser.NegateContext;
    }

    @Override
    public Node visitLog4(BParser.Log4Context ctx) {
        if (IsNegate(ctx.logexpr4()))
            return visitNegate((BParser.NegateContext) ctx.logexpr4());
        else
            return visitValue((BParser.ValueContext) ctx.logexpr4());
    }

    @Override
    public Node visitNegate(BParser.NegateContext ctx) {
        return new Negate(visitValue(ctx.val()));
    }

    @Override
    public Node visitValue(BParser.ValueContext ctx) {
        return visitValue(ctx.val());
    }

    public Node visitValue(BParser.ValContext ctx) {
        if (IsValParenthesisedExpr(ctx))
            return visitValParenthesisedExpr((BParser.ValParenthesisedExprContext) ctx);
        else if (IsValFunccall(ctx))
            return visitValFunccall((BParser.ValFunccallContext) ctx);
        else if (IsValFunccallPrint(ctx))
            return visitValFunccallPrint((BParser.ValFunccallPrintContext) ctx);
        else
            return new ValTerminal(ctx.getText());
    }

    boolean IsValParenthesisedExpr(BParser.ValContext ctx){
        return ctx instanceof BParser.ValParenthesisedExprContext;
    }

    boolean IsValFunccall(BParser.ValContext ctx){
        return ctx instanceof BParser.ValFunccallContext;
    }

    boolean IsValFunccallPrint(BParser.ValContext ctx){
        return ctx instanceof BParser.ValFunccallPrintContext;
    }

    @Override
    public Node visitValParenthesisedExpr(BParser.ValParenthesisedExprContext ctx) {
        return new ParensExp(visitExpr(ctx.expr()));
    }

    @Override
    public Node visitValFunccall(BParser.ValFunccallContext ctx) {
        return visitFunccall(ctx.funccall());
    }


    @Override
    public Node visitValFunccallPrint(BParser.ValFunccallPrintContext ctx) {
        if (IsExprparamsNotEmpty(ctx.funccall().exprparams()))
            return new FuncCall(ctx.funccall().ID().getText(),
                    visitExprparamsNotEmpty((BParser.ExprparamsNotEmptyContext) ctx.funccall().exprparams()), true);
        else
            return new FuncCall(ctx.funccall().ID().getText(),
                    visitExprparamsEmpty((BParser.ExprparamsEmptyContext) ctx.funccall().exprparams()),
                    true);
    }

    @Override
    public Node visitValNumber(BParser.ValNumberContext ctx) {
        return super.visitValNumber(ctx);
    }

    @Override
    public Node visitValBoolean(BParser.ValBooleanContext ctx) {
        return super.visitValBoolean(ctx);
    }

    @Override
    public Node visitValId(BParser.ValIdContext ctx) {
        return super.visitValId(ctx);
    }

    @Override
    public Node visitFunccall(BParser.FunccallContext ctx) {
        if (IsExprparamsNotEmpty(ctx.exprparams()))
            return new FuncCall(ctx.ID().getText(),
                    visitExprparamsNotEmpty((BParser.ExprparamsNotEmptyContext) ctx.exprparams()));
        else
            return new FuncCall(ctx.ID().getText(), visitExprparamsEmpty((BParser.ExprparamsEmptyContext) ctx.exprparams()));
    }


    private boolean IsExprparamsNotEmpty(BParser.ExprparamsContext ctx) {
        return ctx instanceof BParser.ExprparamsNotEmptyContext;
    }

    @Override
    public Node visitExprparamsNotEmpty(BParser.ExprparamsNotEmptyContext ctx) {
        if (isExprmoreparamsNotEmpty(ctx.exprmoreparams()))
            return new ExprParams(visitExpr(ctx.expr()),
                    visitExprmoreparamsNotEmpty((BParser.ExprmoreparamsNotEmptyContext) ctx.exprmoreparams()));
        else
            return new ExprParams(visitExpr(ctx.expr()),
                    visitExprmoreparamsEmpty((BParser.ExprmoreparamsEmptyContext) ctx.exprmoreparams()));
    }

    private boolean isExprmoreparamsNotEmpty(BParser.ExprmoreparamsContext ctx) {
        return ctx instanceof BParser.ExprmoreparamsNotEmptyContext;
    }

    @Override
    public Node visitExprparamsEmpty(BParser.ExprparamsEmptyContext ctx) {
        return null;
    }

    @Override
    public Node visitExprmoreparamsNotEmpty(BParser.ExprmoreparamsNotEmptyContext ctx) {
        if (isExprmoreparamsNotEmpty(ctx.exprmoreparams()))
            return new ExprMoreParams(visitExpr(ctx.expr()),
                    visitExprmoreparamsNotEmpty((BParser.ExprmoreparamsNotEmptyContext) ctx.exprmoreparams()));
        else
            return new ExprMoreParams(visitExpr(ctx.expr()),
                    visitExprmoreparamsEmpty((BParser.ExprmoreparamsEmptyContext) ctx.exprmoreparams()));
    }

    @Override
    public Node visitExprmoreparamsEmpty(BParser.ExprmoreparamsEmptyContext ctx) {
        return null;
    }
}
