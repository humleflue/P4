package Buff;

import Buff.Nodes.Abstract.*;
import Buff.Nodes.Nodes.*;

public class BuildASTVisitor extends Buff_1_1BaseVisitor<Node>{
    @Override
    public Node visitStart(Buff_1_1Parser.StartContext ctx) {
        System.out.println("start");
        if (ctx.prog() instanceof Buff_1_1Parser.DclProgContext)
            return visitDclProg((Buff_1_1Parser.DclProgContext) ctx.prog());
        else if (ctx.prog() instanceof Buff_1_1Parser.StmtProgContext)
            return visitStmtProg((Buff_1_1Parser.StmtProgContext) ctx.prog());
        else
            return null;
    }

    @Override
    public Node visitDclProg(Buff_1_1Parser.DclProgContext ctx) {
        System.out.println("dclprog");
        if (ctx.dcl() instanceof Buff_1_1Parser.OneLineStmtContext) {
            if (ctx.prog() instanceof Buff_1_1Parser.DclProgContext)
                return new DclProg(visitOneLineStmt((Buff_1_1Parser.OneLineStmtContext) ctx.dcl()),
                        visitDclProg((Buff_1_1Parser.DclProgContext) ctx.prog()));
            else if (ctx.prog() instanceof Buff_1_1Parser.StmtProgContext)
                return new StmtProg(visitOneLineStmt((Buff_1_1Parser.OneLineStmtContext) ctx.dcl()),
                        visitStmtProg((Buff_1_1Parser.StmtProgContext) ctx.prog()));

            if (ctx.prog() instanceof Buff_1_1Parser.DclProgContext)
                return new DclProg(visitOneLineStmt((Buff_1_1Parser.OneLineStmtContext) ctx.dcl()), null);
            else
                return new StmtProg(visitOneLineStmt((Buff_1_1Parser.OneLineStmtContext) ctx.dcl()), null);
        }
        else {
            if (ctx.prog() instanceof Buff_1_1Parser.DclProgContext)
                return new DclProg(visitMultiLineStmt((Buff_1_1Parser.MultiLineStmtContext) ctx.dcl()),
                        visitDclProg((Buff_1_1Parser.DclProgContext) ctx.prog()));
            else if (ctx.prog() instanceof Buff_1_1Parser.StmtProgContext)
                return new StmtProg(visitMultiLineStmt((Buff_1_1Parser.MultiLineStmtContext) ctx.dcl()),
                        visitStmtProg((Buff_1_1Parser.StmtProgContext) ctx.prog()));

            if (ctx.prog() instanceof Buff_1_1Parser.DclProgContext)
                return new DclProg(visitMultiLineStmt((Buff_1_1Parser.MultiLineStmtContext) ctx.dcl()), null);
            else
                return new StmtProg(visitMultiLineStmt((Buff_1_1Parser.MultiLineStmtContext) ctx.dcl()), null);
        }
    }


    @Override
    public Node visitStmtProg(Buff_1_1Parser.StmtProgContext ctx) {
        return super.visitStmtProg(ctx);
    }

    @Override
    public Node visitProgEmpty(Buff_1_1Parser.ProgEmptyContext ctx) {
        return super.visitProgEmpty(ctx);
    }

    @Override
    public Node visitOneLineStmt(Buff_1_1Parser.OneLineStmtContext ctx) {
        return super.visitOneLineStmt(ctx);
    }

    @Override
    public Node visitMultiLineStmt(Buff_1_1Parser.MultiLineStmtContext ctx) {
        return super.visitMultiLineStmt(ctx);
    }

    @Override
    public Node visitType(Buff_1_1Parser.TypeContext ctx) {
        return super.visitType(ctx);
    }

    @Override
    public Node visitDclParams(Buff_1_1Parser.DclParamsContext ctx) {
        return super.visitDclParams(ctx);
    }

    @Override
    public Node visitDclMoreParams(Buff_1_1Parser.DclMoreParamsContext ctx) {
        return super.visitDclMoreParams(ctx);
    }

    @Override
    public Node visitDclParam(Buff_1_1Parser.DclParamContext ctx) {
        return super.visitDclParam(ctx);
    }

    @Override
    public Node visitStmts(Buff_1_1Parser.StmtsContext ctx) {
        return super.visitStmts(ctx);
    }

    @Override
    public Node visitStmt(Buff_1_1Parser.StmtContext ctx) {
        return super.visitStmt(ctx);
    }

    @Override
    public Node visitLogOr(Buff_1_1Parser.LogOrContext ctx) {
        return super.visitLogOr(ctx);
    }

    @Override
    public Node visitLogExp(Buff_1_1Parser.LogExpContext ctx) {
        return super.visitLogExp(ctx);
    }

    @Override
    public Node visitLogAnd(Buff_1_1Parser.LogAndContext ctx) {
        return super.visitLogAnd(ctx);
    }

    @Override
    public Node visitLog2(Buff_1_1Parser.Log2Context ctx) {
        return super.visitLog2(ctx);
    }

    @Override
    public Node visitLogEqualsOp(Buff_1_1Parser.LogEqualsOpContext ctx) {
        return super.visitLogEqualsOp(ctx);
    }

    @Override
    public Node visitMathLog(Buff_1_1Parser.MathLogContext ctx) {
        return super.visitMathLog(ctx);
    }

    @Override
    public Node visitLogicalOp(Buff_1_1Parser.LogicalOpContext ctx) {
        return super.visitLogicalOp(ctx);
    }

    @Override
    public Node visitMath(Buff_1_1Parser.MathContext ctx) {
        return super.visitMath(ctx);
    }

    @Override
    public Node visitBinaryOpPlusMinus(Buff_1_1Parser.BinaryOpPlusMinusContext ctx) {
        return super.visitBinaryOpPlusMinus(ctx);
    }

    @Override
    public Node visitMathDivMul(Buff_1_1Parser.MathDivMulContext ctx) {
        return super.visitMathDivMul(ctx);
    }

    @Override
    public Node visitBinaryOpDivMul(Buff_1_1Parser.BinaryOpDivMulContext ctx) {
        return super.visitBinaryOpDivMul(ctx);
    }

    @Override
    public Node visitMathPow(Buff_1_1Parser.MathPowContext ctx) {
        return super.visitMathPow(ctx);
    }

    @Override
    public Node visitBinaryOpPoe(Buff_1_1Parser.BinaryOpPoeContext ctx) {
        return super.visitBinaryOpPoe(ctx);
    }

    @Override
    public Node visitLogUnary(Buff_1_1Parser.LogUnaryContext ctx) {
        return super.visitLogUnary(ctx);
    }

    @Override
    public Node visitNegate(Buff_1_1Parser.NegateContext ctx) {
        return super.visitNegate(ctx);
    }

    @Override
    public Node visitValue(Buff_1_1Parser.ValueContext ctx) {
        return super.visitValue(ctx);
    }

    @Override
    public Node visitParensExp(Buff_1_1Parser.ParensExpContext ctx) {
        return super.visitParensExp(ctx);
    }

    @Override
    public Node visitValFuncCal(Buff_1_1Parser.ValFuncCalContext ctx) {
        return super.visitValFuncCal(ctx);
    }

    @Override
    public Node visitValTerminal(Buff_1_1Parser.ValTerminalContext ctx) {
        return super.visitValTerminal(ctx);
    }

    @Override
    public Node visitTermVal(Buff_1_1Parser.TermValContext ctx) {
        return super.visitTermVal(ctx);
    }

    @Override
    public Node visitFuncCall(Buff_1_1Parser.FuncCallContext ctx) {
        return super.visitFuncCall(ctx);
    }

    @Override
    public Node visitStmtParams(Buff_1_1Parser.StmtParamsContext ctx) {
        return super.visitStmtParams(ctx);
    }

    @Override
    public Node visitStmtMoreParams(Buff_1_1Parser.StmtMoreParamsContext ctx) {
        return super.visitStmtMoreParams(ctx);
    }
}
