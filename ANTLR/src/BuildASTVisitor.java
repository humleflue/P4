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
            System.out.println("reached onelinestatement");
            if (ctx.prog() instanceof Buff_1_1Parser.DclProgContext)
                return new DclProg(visitOneLineStmt((Buff_1_1Parser.OneLineStmtContext) ctx.dcl()),
                        visitDclProg((Buff_1_1Parser.DclProgContext) ctx.prog()));
            else if (ctx.prog() instanceof Buff_1_1Parser.StmtProgContext)
                return new StmtProg(visitOneLineStmt((Buff_1_1Parser.OneLineStmtContext) ctx.dcl()),
                        visitStmtProg((Buff_1_1Parser.StmtProgContext) ctx.prog()));
            else
                System.out.println("Reached progempty");
                return new StmtProg(visitOneLineStmt((Buff_1_1Parser.OneLineStmtContext) ctx.dcl()),
                        visitProgEmpty((Buff_1_1Parser.ProgEmptyContext) ctx.prog()));
        }
        else if (ctx.dcl() instanceof Buff_1_1Parser.MultiLineStmtContext){
            if (ctx.prog() instanceof Buff_1_1Parser.DclProgContext)
                return new DclProg(visitMultiLineStmt((Buff_1_1Parser.MultiLineStmtContext) ctx.dcl()),
                        visitDclProg((Buff_1_1Parser.DclProgContext) ctx.prog()));
            else if (ctx.prog() instanceof Buff_1_1Parser.StmtProgContext)
                return new StmtProg(visitMultiLineStmt((Buff_1_1Parser.MultiLineStmtContext) ctx.dcl()),
                        visitStmtProg((Buff_1_1Parser.StmtProgContext) ctx.prog()));

            if (ctx.prog() instanceof Buff_1_1Parser.DclProgContext)
                return new DclProg(visitMultiLineStmt((Buff_1_1Parser.MultiLineStmtContext) ctx.dcl()),
                        visitProgEmpty((Buff_1_1Parser.ProgEmptyContext) ctx.prog()));
            else
                return new StmtProg(visitMultiLineStmt((Buff_1_1Parser.MultiLineStmtContext) ctx.dcl()),
                        visitProgEmpty((Buff_1_1Parser.ProgEmptyContext) ctx.prog()));
        }
        else
            return null;
    }


    @Override
    public Node visitStmtProg(Buff_1_1Parser.StmtProgContext ctx) {
        System.out.println("stmtprog");

        if (ctx.prog() instanceof Buff_1_1Parser.DclProgContext)
            return new StmtProg(visitStmt(ctx.stmt()), visitDclProg((Buff_1_1Parser.DclProgContext) ctx.prog()));
        else if (ctx.prog() instanceof Buff_1_1Parser.StmtProgContext)
            return new StmtProg(visitStmt(ctx.stmt()), visitStmtProg((Buff_1_1Parser.StmtProgContext) ctx.prog()));
        else
            return new StmtProg(visitStmt(ctx.stmt()), visitProgEmpty((Buff_1_1Parser.ProgEmptyContext) ctx.prog()));
    }

    @Override
    public Node visitProgEmpty(Buff_1_1Parser.ProgEmptyContext ctx) {
        return null;
    }

    @Override
    public Node visitOneLineStmt(Buff_1_1Parser.OneLineStmtContext ctx) {
        return new OneLineStmt(visitType(ctx.type()),visitDclParams(ctx.dclParams()),
                visitStmt(ctx.stmt()),ctx.ID().getText());
    }

    @Override
    public Node visitMultiLineStmt(Buff_1_1Parser.MultiLineStmtContext ctx) {
        return new MultiLineStmt(visitType(ctx.type()),visitDclParams(ctx.dclParams()),
                visitStmt(ctx.stmt()),ctx.ID().getText(), visitStmts(ctx.stmts()));
    }

    @Override
    public Node visitType(Buff_1_1Parser.TypeContext ctx) {
        System.out.println("reached type");
        return new Type(ctx.getText());
    }

    @Override
    public Node visitDclParams(Buff_1_1Parser.DclParamsContext ctx) {
        System.out.println("reached DclParams");
        if (ctx.isEmpty())
            return null;
        else {
            System.out.println("Reached Dclparams deep");
            return new DclParams(visitDclParam(ctx.dclParam()), visitDclMoreParams(ctx.dclMoreParams()));
        }
    }

    @Override
    public Node visitDclMoreParams(Buff_1_1Parser.DclMoreParamsContext ctx) {
        System.out.println("Reached moreDclParams");
        if (ctx.getPayload().getText() == null) {
            System.out.println("Reached moreDclParams empty");
            return null;
        }
        else {
            System.out.println("Reached wrong dclmoreparams");
            return new DclMoreParams(visitDclParam(ctx.dclParam()), visitDclMoreParams(ctx.dclMoreParams()));
        }
    }

    @Override
    public Node visitDclParam(Buff_1_1Parser.DclParamContext ctx) {
        return new DclParam(visitType(ctx.type()), ctx.ID().getText());
    }

    @Override
    public Node visitStmts(Buff_1_1Parser.StmtsContext ctx) {
        if (ctx.isEmpty())
            return null;
        else {
            if (ctx.expr() instanceof Buff_1_1Parser.LogOrContext)
                return new Stmts(visitLogOr((Buff_1_1Parser.LogOrContext) ctx.expr()),
                        visitStmt(ctx.stmt()), visitStmts(ctx.stmts()));
            else if (ctx.expr() instanceof Buff_1_1Parser.LogExpContext)
                return new Stmts(visitLogExp((Buff_1_1Parser.LogExpContext) ctx.expr()),
                        visitStmt(ctx.stmt()), visitStmts(ctx.stmts()));
            else
                return new Stmts(null,
                        visitStmt(ctx.stmt()), visitStmts(ctx.stmts()));
        }
    }

    @Override
    public Node visitStmt(Buff_1_1Parser.StmtContext ctx) {
        System.out.println("Reached Stmt");
        if (ctx.expr() instanceof Buff_1_1Parser.LogOrContext)
            return new Stmt(visitLogExp((Buff_1_1Parser.LogExpContext) ctx.expr()));
        else {
            System.out.println("Reached stmtLog");
            return new Stmt(visitLogExp((Buff_1_1Parser.LogExpContext) ctx.expr()));
        }
    }

    @Override
    public Node visitLogOr(Buff_1_1Parser.LogOrContext ctx) {
        if (ctx.left instanceof Buff_1_1Parser.LogAndContext) {
            if (ctx.right instanceof Buff_1_1Parser.LogOrContext)
                return new LogOr(visitLogAnd((Buff_1_1Parser.LogAndContext) ctx.left),
                        visitLogOr((Buff_1_1Parser.LogOrContext) ctx.right));
            else // if (ctx.right instanceof Buff_1_1Parser.LogExpContext)
                return new LogOr(visitLogAnd((Buff_1_1Parser.LogAndContext) ctx.left),
                        visitLogExp((Buff_1_1Parser.LogExpContext) ctx.right));
            //else
            //    return new LogOr(visitLogAnd((Buff_1_1Parser.LogAndContext) ctx.left), null);
        }
        else {
            if (ctx.right instanceof Buff_1_1Parser.LogOrContext)
                return new LogOr(visitLog2((Buff_1_1Parser.Log2Context) ctx.left),
                        visitLogOr((Buff_1_1Parser.LogOrContext) ctx.right));
            else // if (ctx.right instanceof Buff_1_1Parser.LogExpContext)
                return new LogOr(visitLog2((Buff_1_1Parser.Log2Context) ctx.left),
                        visitLogExp((Buff_1_1Parser.LogExpContext) ctx.right));
            //else
            //    return new LogOr(visitLog2((Buff_1_1Parser.Log2Context) ctx.left), null);
        }
    }

    @Override
    public Node visitLogExp(Buff_1_1Parser.LogExpContext ctx) {
        if (ctx.lgclExpr() instanceof Buff_1_1Parser.LogAndContext)
            return visitLog2((Buff_1_1Parser.Log2Context) ctx.lgclExpr());
        else // if (ctx.lgclExpr() instanceof Buff_1_1Parser.Log2Context)
            return visitLog2((Buff_1_1Parser.Log2Context) ctx.lgclExpr());
        // else
        //     return null;
    }

    @Override
    public Node visitLogAnd(Buff_1_1Parser.LogAndContext ctx) {
        if (ctx.left instanceof Buff_1_1Parser.LogEqualsOpContext){
            if (ctx.right instanceof Buff_1_1Parser.LogAndContext)
                return new LogAnd(visitLogEqualsOp((Buff_1_1Parser.LogEqualsOpContext) ctx.left),
                        visitLogAnd((Buff_1_1Parser.LogAndContext) ctx.right));
            else // if (ctx.right instanceof Buff_1_1Parser.Log2Context)
                    return new LogAnd(visitLogEqualsOp((Buff_1_1Parser.LogEqualsOpContext) ctx.left),
                            visitLog2((Buff_1_1Parser.Log2Context) ctx.right));
               // else
               //     return new LogAnd(visitLogEqualsOp((Buff_1_1Parser.LogEqualsOpContext) ctx.left),
               //             null);
        }
        else /* if (ctx.left instanceof Buff_1_1Parser.MathLogContext)*/{
            if (ctx.right instanceof Buff_1_1Parser.LogAndContext)
                return new LogAnd(visitMathLog((Buff_1_1Parser.MathLogContext) ctx.left),
                        visitLogAnd((Buff_1_1Parser.LogAndContext) ctx.right));
            else // if (ctx.right instanceof Buff_1_1Parser.Log2Context)
                return new LogAnd(visitMathLog((Buff_1_1Parser.MathLogContext) ctx.left),
                        visitLog2((Buff_1_1Parser.Log2Context) ctx.right));
            // else
            //     return new LogAnd(visitMathLog((Buff_1_1Parser.MathLogContext) ctx.left),
            //             null);
        }
        // else
            // return null;
    }

    @Override
    public Node visitLog2(Buff_1_1Parser.Log2Context ctx) {
        if (ctx.lgclExpr2() instanceof Buff_1_1Parser.LogEqualsOpContext)
            return visitLogEqualsOp((Buff_1_1Parser.LogEqualsOpContext) ctx.lgclExpr2());
        else // if (ctx.lgclExpr2() instanceof Buff_1_1Parser.MathLogContext)
            return visitMathLog((Buff_1_1Parser.MathLogContext) ctx.lgclExpr2());
        // else
        //     return null;
    }

    @Override
    public Node visitLogEqualsOp(Buff_1_1Parser.LogEqualsOpContext ctx) {
        switch (ctx.op.getType()){
            case Buff_1_1Lexer.LOGEQUALS:
                if (IsLogicalOpContext(ctx.left)) {
                    if (IsLogEqualsOpContext(ctx.right))
                        return new LogEquals(visitLogicalOp((Buff_1_1Parser.LogicalOpContext) ctx.left),
                                visitLogEqualsOp((Buff_1_1Parser.LogEqualsOpContext) ctx.right));
                    else
                        return new LogEquals(visitLogicalOp((Buff_1_1Parser.LogicalOpContext) ctx.left),
                                visitMathLog((Buff_1_1Parser.MathLogContext) ctx.right));
                }
                else {
                    if (IsLogEqualsOpContext(ctx.right))
                        return new LogEquals(visitMath((Buff_1_1Parser.MathContext) ctx.left),
                                visitLogEqualsOp((Buff_1_1Parser.LogEqualsOpContext) ctx.right));
                    else
                        return new LogEquals(visitMath((Buff_1_1Parser.MathContext) ctx.left),
                                visitMathLog((Buff_1_1Parser.MathLogContext) ctx.right));
                }
            case Buff_1_1Lexer.LOGNEQUALS:
                if (IsLogicalOpContext(ctx.left)) {
                    if (IsLogEqualsOpContext(ctx.right))
                        return new LogNotEquals(visitLogicalOp((Buff_1_1Parser.LogicalOpContext) ctx.left),
                                visitLogEqualsOp((Buff_1_1Parser.LogEqualsOpContext) ctx.right));
                    else
                        return new LogNotEquals(visitLogicalOp((Buff_1_1Parser.LogicalOpContext) ctx.left),
                                visitMathLog((Buff_1_1Parser.MathLogContext) ctx.right));
                }
                else
                if (IsLogEqualsOpContext(ctx.right))
                    return new LogNotEquals(visitMath((Buff_1_1Parser.MathContext) ctx.left),
                            visitLogEqualsOp((Buff_1_1Parser.LogEqualsOpContext) ctx.right));
                else
                    return new LogNotEquals(visitMath((Buff_1_1Parser.MathContext) ctx.left),
                            visitMathLog((Buff_1_1Parser.MathLogContext) ctx.right));
            default :
                return null;
        }
    }
    boolean IsLogicalOpContext(Buff_1_1Parser.LgclExpr3Context ctx){
        return ctx instanceof Buff_1_1Parser.LogicalOpContext;
    }
    boolean IsLogEqualsOpContext(Buff_1_1Parser.LgclExpr2Context ctx){
        return ctx instanceof Buff_1_1Parser.LogEqualsOpContext;
    }

    @Override
    public Node visitMathLog(Buff_1_1Parser.MathLogContext ctx) {
        if (ctx.lgclExpr3() instanceof Buff_1_1Parser.LogicalOpContext)
            return visitLogicalOp((Buff_1_1Parser.LogicalOpContext) ctx.lgclExpr3());
        else // if (ctx.lgclExpr3() instanceof Buff_1_1Parser.MathContext)
            return visitMath((Buff_1_1Parser.MathContext) ctx.lgclExpr3());
        // else
        //     return null;
    }

    @Override
    public Node visitLogicalOp(Buff_1_1Parser.LogicalOpContext ctx) {
        switch (ctx.op.getType()) {
            case Buff_1_1Lexer.LOGLESS:
                if (IsBinaryPlusMinus(ctx.left)) {
                    if (IsLogicalOpContext(ctx.right))
                        return new LogLess(visitBinaryOpPlusMinus((Buff_1_1Parser.BinaryOpPlusMinusContext) ctx.left),
                                visitLogicalOp((Buff_1_1Parser.LogicalOpContext) ctx.right));
                    else
                        return new LogLess(visitBinaryOpPlusMinus((Buff_1_1Parser.BinaryOpPlusMinusContext) ctx.left),
                                visitMath((Buff_1_1Parser.MathContext) ctx.right));
                }
                else {
                    if (IsLogicalOpContext(ctx.right))
                        return new LogLess(visitMathDivMul((Buff_1_1Parser.MathDivMulContext) ctx.left),
                                visitLogicalOp((Buff_1_1Parser.LogicalOpContext) ctx.right));
                    else
                        return new LogLess(visitMathDivMul((Buff_1_1Parser.MathDivMulContext) ctx.left),
                                visitMath((Buff_1_1Parser.MathContext) ctx.right));
                }
            case Buff_1_1Lexer.LOGGREATER:
                if (IsBinaryPlusMinus(ctx.left)) {
                    if (IsLogicalOpContext(ctx.right))
                        return new LogGreater(visitBinaryOpPlusMinus((Buff_1_1Parser.BinaryOpPlusMinusContext) ctx.left),
                                visitLogicalOp((Buff_1_1Parser.LogicalOpContext) ctx.right));
                    else
                        return new LogGreater(visitBinaryOpPlusMinus((Buff_1_1Parser.BinaryOpPlusMinusContext) ctx.left),
                                visitMath((Buff_1_1Parser.MathContext) ctx.right));
                }
                else {
                    if (IsLogicalOpContext(ctx.right))
                        return new LogGreater(visitMathDivMul((Buff_1_1Parser.MathDivMulContext) ctx.left),
                                visitLogicalOp((Buff_1_1Parser.LogicalOpContext) ctx.right));
                    else
                        return new LogGreater(visitMathDivMul((Buff_1_1Parser.MathDivMulContext) ctx.left),
                                visitMath((Buff_1_1Parser.MathContext) ctx.right));
                }
            case Buff_1_1Lexer.LOGLESSOREQUAL:
                if (IsBinaryPlusMinus(ctx.left)) {
                    if (IsLogicalOpContext(ctx.right))
                        return new LogLessOrEqual(visitBinaryOpPlusMinus((Buff_1_1Parser.BinaryOpPlusMinusContext) ctx.left),
                                visitLogicalOp((Buff_1_1Parser.LogicalOpContext) ctx.right));
                    else
                        return new LogLessOrEqual(visitBinaryOpPlusMinus((Buff_1_1Parser.BinaryOpPlusMinusContext) ctx.left),
                                visitMath((Buff_1_1Parser.MathContext) ctx.right));
                }
                else {
                    if (IsLogicalOpContext(ctx.right))
                        return new LogLessOrEqual(visitMathDivMul((Buff_1_1Parser.MathDivMulContext) ctx.left),
                                visitLogicalOp((Buff_1_1Parser.LogicalOpContext) ctx.right));
                    else
                        return new LogLessOrEqual(visitMathDivMul((Buff_1_1Parser.MathDivMulContext) ctx.left),
                                visitMath((Buff_1_1Parser.MathContext) ctx.right));
                }
            case Buff_1_1Lexer.LOGGREATEROREQUAL:
                if (IsBinaryPlusMinus(ctx.left)) {
                    if (IsLogicalOpContext(ctx.right))
                        return new LogGreaterOrEqual(visitBinaryOpPlusMinus((Buff_1_1Parser.BinaryOpPlusMinusContext) ctx.left),
                                visitLogicalOp((Buff_1_1Parser.LogicalOpContext) ctx.right));
                    else
                        return new LogGreaterOrEqual(visitBinaryOpPlusMinus((Buff_1_1Parser.BinaryOpPlusMinusContext) ctx.left),
                                visitMath((Buff_1_1Parser.MathContext) ctx.right));
                }
                else {
                    if (IsLogicalOpContext(ctx.right))
                        return new LogGreaterOrEqual(visitMathDivMul((Buff_1_1Parser.MathDivMulContext) ctx.left),
                                visitLogicalOp((Buff_1_1Parser.LogicalOpContext) ctx.right));
                    else
                        return new LogGreaterOrEqual(visitMathDivMul((Buff_1_1Parser.MathDivMulContext) ctx.left),
                                visitMath((Buff_1_1Parser.MathContext) ctx.right));
                }
            default:
                return null;
        }

    }


    @Override
    public Node visitMath(Buff_1_1Parser.MathContext ctx) {
        if (ctx.mathExpr() instanceof Buff_1_1Parser.BinaryOpPlusMinusContext)
            return visitBinaryOpPlusMinus((Buff_1_1Parser.BinaryOpPlusMinusContext) ctx.mathExpr());
        else // if (ctx.mathExpr() instanceof Buff_1_1Parser.MathDivMulContext)
            return visitMathDivMul((Buff_1_1Parser.MathDivMulContext) ctx.mathExpr());
        // else
        //     return null;
    }

    @Override
    public Node visitBinaryOpPlusMinus(Buff_1_1Parser.BinaryOpPlusMinusContext ctx) {
        switch (ctx.op.getType()) {
            case Buff_1_1Lexer.PLUS:
                if (IsBinaryOpDivMul(ctx.left)){
                    if (IsBinaryPlusMinus(ctx.right))
                        return new Plus(visitBinaryOpDivMul((Buff_1_1Parser.BinaryOpDivMulContext) ctx.left),
                                visitBinaryOpPlusMinus((Buff_1_1Parser.BinaryOpPlusMinusContext) ctx.right));
                    else
                        return new Plus(visitBinaryOpDivMul((Buff_1_1Parser.BinaryOpDivMulContext) ctx.left),
                                visitMathDivMul((Buff_1_1Parser.MathDivMulContext) ctx.right));
                }
                else {
                    if (IsBinaryPlusMinus(ctx.right))
                        return new Plus(visitMathPow((Buff_1_1Parser.MathPowContext) ctx.left),
                            visitBinaryOpPlusMinus((Buff_1_1Parser.BinaryOpPlusMinusContext) ctx.right));
                    else
                        return new Plus(visitMathPow((Buff_1_1Parser.MathPowContext) ctx.left),
                                visitMathDivMul((Buff_1_1Parser.MathDivMulContext) ctx.right));

                }
            case Buff_1_1Lexer.MINUS:
                if (IsBinaryOpDivMul(ctx.left)){
                    if (IsBinaryPlusMinus(ctx.right))
                        return new Minus(visitBinaryOpDivMul((Buff_1_1Parser.BinaryOpDivMulContext) ctx.left),
                                visitBinaryOpPlusMinus((Buff_1_1Parser.BinaryOpPlusMinusContext) ctx.right));
                    else
                        return new Minus(visitBinaryOpDivMul((Buff_1_1Parser.BinaryOpDivMulContext) ctx.left),
                                visitMathDivMul((Buff_1_1Parser.MathDivMulContext) ctx.right));
                }
                else {
                    if (IsBinaryPlusMinus(ctx.right))
                        return new Minus(visitMathPow((Buff_1_1Parser.MathPowContext) ctx.left),
                                visitBinaryOpPlusMinus((Buff_1_1Parser.BinaryOpPlusMinusContext) ctx.right));
                    else
                        return new Minus(visitMathPow((Buff_1_1Parser.MathPowContext) ctx.left),
                                visitMathDivMul((Buff_1_1Parser.MathDivMulContext) ctx.right));

                }
            default:
                return null;
        }
    }

    private boolean IsBinaryPlusMinus(Buff_1_1Parser.MathExprContext ctx) {
        return ctx instanceof Buff_1_1Parser.BinaryOpPlusMinusContext;
    }

    private boolean IsBinaryOpDivMul(Buff_1_1Parser.MathExpr2Context ctx) {
        return ctx instanceof Buff_1_1Parser.BinaryOpDivMulContext;
    }

    @Override
    public Node visitMathDivMul(Buff_1_1Parser.MathDivMulContext ctx) {
        if (IsBinaryOpDivMul(ctx.mathExpr2()))
            return visitBinaryOpDivMul((Buff_1_1Parser.BinaryOpDivMulContext) ctx.mathExpr2());
        else // if (IsMathPow(ctx.mathExpr2()))
            return visitMathPow((Buff_1_1Parser.MathPowContext) ctx.mathExpr2());
        // else
        //     return null;
    }

    private boolean IsMathPow(Buff_1_1Parser.MathExpr2Context ctx) {
        return ctx instanceof Buff_1_1Parser.MathPowContext;
    }


    @Override
    public Node visitBinaryOpDivMul(Buff_1_1Parser.BinaryOpDivMulContext ctx) {
        switch (ctx.op.getType()) {
            case Buff_1_1Lexer.MULTIPLY:
                if (IsPowExp(ctx.left)) {
                    if (IsBinaryOpDivMul(ctx.right))
                        return new Mulitply(visitBinaryOpPow((Buff_1_1Parser.BinaryOpPowContext) ctx.left),
                                visitBinaryOpDivMul((Buff_1_1Parser.BinaryOpDivMulContext) ctx.right));
                    else
                        return new Mulitply(visitBinaryOpPow((Buff_1_1Parser.BinaryOpPowContext) ctx.left),
                                visitMathPow((Buff_1_1Parser.MathPowContext) ctx.right));
                } else {
                    if (IsBinaryOpDivMul(ctx.right))
                        return new Mulitply(visitLogUnary((Buff_1_1Parser.LogUnaryContext) ctx.left),
                                visitBinaryOpDivMul((Buff_1_1Parser.BinaryOpDivMulContext) ctx.right));
                    else
                        return new Mulitply(visitLogUnary((Buff_1_1Parser.LogUnaryContext) ctx.left),
                                visitMathPow((Buff_1_1Parser.MathPowContext) ctx.right));
                }
            case Buff_1_1Lexer.DIVIDE:
                if (IsPowExp(ctx.left)) {
                    if (IsBinaryOpDivMul(ctx.right))
                        return new Divide(visitBinaryOpPow((Buff_1_1Parser.BinaryOpPowContext) ctx.left),
                                visitBinaryOpDivMul((Buff_1_1Parser.BinaryOpDivMulContext) ctx.right));
                    else
                        return new Divide(visitBinaryOpPow((Buff_1_1Parser.BinaryOpPowContext) ctx.left),
                                visitMathPow((Buff_1_1Parser.MathPowContext) ctx.right));
                } else {
                    if (IsBinaryOpDivMul(ctx.right))
                        return new Divide(visitLogUnary((Buff_1_1Parser.LogUnaryContext) ctx.left),
                                visitBinaryOpDivMul((Buff_1_1Parser.BinaryOpDivMulContext) ctx.right));
                    else
                        return new Divide(visitLogUnary((Buff_1_1Parser.LogUnaryContext) ctx.left),
                                visitMathPow((Buff_1_1Parser.MathPowContext) ctx.right));
                }
            default:
                return null;
        }
    }

    private boolean IsPowExp(Buff_1_1Parser.MathExpr3Context ctx) {
        return ctx instanceof Buff_1_1Parser.BinaryOpPowContext;
    }

    @Override
    public Node visitMathPow(Buff_1_1Parser.MathPowContext ctx) {
        if (ctx.mathExpr3() instanceof Buff_1_1Parser.BinaryOpPowContext)
            return visitBinaryOpPow((Buff_1_1Parser.BinaryOpPowContext) ctx.mathExpr3());
        else // if (ctx.mathExpr3() instanceof Buff_1_1Parser.LogUnaryContext)
            return visitLogUnary((Buff_1_1Parser.LogUnaryContext) ctx.mathExpr3());
        //else
        //    return null;
    }

    @Override
    public Node visitBinaryOpPow(Buff_1_1Parser.BinaryOpPowContext ctx) {
        if (IsNegate(ctx.left)){
            if (IsPowExp(ctx.right))
                return new Power(visitNegate((Buff_1_1Parser.NegateContext) ctx.left),
                        visitBinaryOpPow((Buff_1_1Parser.BinaryOpPowContext) ctx.right));
            else
                return new Power(visitNegate((Buff_1_1Parser.NegateContext) ctx.left),
                        visitLogUnary((Buff_1_1Parser.LogUnaryContext) ctx.right));
        }
        else{
            if (IsPowExp(ctx.right))
                return new Power(visitValue((Buff_1_1Parser.ValueContext) ctx.left),
                        visitBinaryOpPow((Buff_1_1Parser.BinaryOpPowContext) ctx.right));
            else
                return new Power(visitValue((Buff_1_1Parser.ValueContext) ctx.left),
                        visitLogUnary((Buff_1_1Parser.LogUnaryContext) ctx.right));
        }
    }

    private boolean IsNegate(Buff_1_1Parser.LgclExpr4Context ctx) {
        return ctx instanceof Buff_1_1Parser.NegateContext;
    }

    @Override
    public Node visitLogUnary(Buff_1_1Parser.LogUnaryContext ctx) {
        if (ctx.lgclExpr4() instanceof Buff_1_1Parser.NegateContext)
            return visitNegate((Buff_1_1Parser.NegateContext) ctx.lgclExpr4());
        else
            return visitValue((Buff_1_1Parser.ValueContext) ctx.lgclExpr4());
    }

    @Override
    public Node visitNegate(Buff_1_1Parser.NegateContext ctx) {
        return new Negate(visitValue(ctx.val()));
    }

    public Node visitValue(Buff_1_1Parser.ValContext ctx) {
        if (ctx instanceof Buff_1_1Parser.ParensExpContext)
            return visitParensExp((Buff_1_1Parser.ParensExpContext) ctx);
        else if (ctx instanceof Buff_1_1Parser.ValFuncCallContext)
            return visitValFuncCall((Buff_1_1Parser.ValFuncCallContext) ctx);
        else if (ctx instanceof Buff_1_1Parser.ValFuncCallDebugContext)
            return visitValFuncCallDebug((Buff_1_1Parser.ValFuncCallDebugContext) ctx);
        else // if (ctx instanceof Buff_1_1Parser.ValTerminalContext)
            return visitValTerminal((Buff_1_1Parser.ValTerminalContext) ctx);
        // else
        //     return null;
    }

    @Override
    public Node visitParensExp(Buff_1_1Parser.ParensExpContext ctx) {
        if (ctx.expr() instanceof Buff_1_1Parser.LogOrContext)
            return new ParensExp(visitLogOr((Buff_1_1Parser.LogOrContext) ctx.expr()));
        else // if (ctx.expr() instanceof Buff_1_1Parser.LogExpContext)
            return new ParensExp(visitLogExp((Buff_1_1Parser.LogExpContext) ctx.expr()));
        // else
        //     return null;
    }

    @Override
    public Node visitValFuncCall(Buff_1_1Parser.ValFuncCallContext ctx) {
        return visitFuncCall(ctx.funcCall());
    }

    @Override
    public Node visitValFuncCallDebug(Buff_1_1Parser.ValFuncCallDebugContext ctx) {
        return visitFuncCall(ctx.funcCall());
    }

    @Override
    public Node visitValTerminal(Buff_1_1Parser.ValTerminalContext ctx) {
        return visitTermVal(ctx.termVal());
    }

    @Override
    public Node visitTermVal(Buff_1_1Parser.TermValContext ctx) {
        return new ValTerminal(ctx.getText());
    }

    @Override
    public Node visitFuncCall(Buff_1_1Parser.FuncCallContext ctx) {
        return new FuncCall(ctx.ID().getText(), visitStmtParams(ctx.stmtParams()));
    }

    @Override
    public Node visitStmtParams(Buff_1_1Parser.StmtParamsContext ctx) {
        if (ctx.isEmpty())
            return null;
        else if (ctx.expr() instanceof Buff_1_1Parser.LogOrContext)
            return new StmtParams(visitLogOr((Buff_1_1Parser.LogOrContext) ctx.expr()),
                    visitExprMoreParams(ctx.exprMoreParams()));
        else
            return new StmtParams(visitLogExp((Buff_1_1Parser.LogExpContext) ctx.expr()),
                    visitExprMoreParams(ctx.exprMoreParams()));
    }

    @Override
    public Node visitExprMoreParams(Buff_1_1Parser.ExprMoreParamsContext ctx) {
        if (ctx.exprMoreParams().isEmpty())
            return new ExprMoreParams(visitStmt(ctx.stmt()),
            null);
        else
            return new ExprMoreParams(visitStmt(ctx.stmt()),
                    visitExprMoreParams(ctx.exprMoreParams()));
    }
}
