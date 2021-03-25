package Buff;
import Buff.Nodes.Abstract.*;
import Buff.Nodes.Nodes.*;

public class BuildASTVisitor extends Buff_1_1BaseVisitor<Node>{
    @Override
    public Node visitStart(Buff_1_1Parser.StartContext ctx) {
        return visitProg(ctx.prog());
    }

    public Node visitProg(Buff_1_1Parser.ProgContext ctx){
        if (IsDclProgContext(ctx))
            return visitDclProg((Buff_1_1Parser.DclProgContext) ctx);
        else if (IsStmtProgContext(ctx))
            return visitStmtProg((Buff_1_1Parser.StmtProgContext) ctx);
        else
            return null;
    }

    boolean IsDclProgContext(Buff_1_1Parser.ProgContext ctx){
        return ctx instanceof Buff_1_1Parser.DclProgContext;
    }

    boolean IsStmtProgContext(Buff_1_1Parser.ProgContext ctx){
        return ctx instanceof Buff_1_1Parser.StmtProgContext;
    }

    @Override
    public Node visitDclProg(Buff_1_1Parser.DclProgContext ctx) {
        if (IsOneLineStmt(ctx.dcl())) {
            if (IsDclProgContext(ctx.prog()))
                return new DclProg(visitOneLineStmt((Buff_1_1Parser.OneLineStmtContext) ctx.dcl()),
                        visitDclProg((Buff_1_1Parser.DclProgContext) ctx.prog()));
            else if (IsStmtProgContext(ctx.prog()))
                return new StmtProg(visitOneLineStmt((Buff_1_1Parser.OneLineStmtContext) ctx.dcl()),
                        visitStmtProg((Buff_1_1Parser.StmtProgContext) ctx.prog()));
            else
                return new StmtProg(visitOneLineStmt((Buff_1_1Parser.OneLineStmtContext) ctx.dcl()),
                        visitProgEmpty((Buff_1_1Parser.ProgEmptyContext) ctx.prog()));
        }
        else if (IsMultiLineStmt(ctx.dcl())){
            if (IsDclProgContext(ctx.prog()))
                return new DclProg(visitMultiLineStmt((Buff_1_1Parser.MultiLineStmtContext) ctx.dcl()),
                        visitDclProg((Buff_1_1Parser.DclProgContext) ctx.prog()));
            else if (IsStmtProgContext(ctx.prog()))
                return new StmtProg(visitMultiLineStmt((Buff_1_1Parser.MultiLineStmtContext) ctx.dcl()),
                        visitStmtProg((Buff_1_1Parser.StmtProgContext) ctx.prog()));
            else
                return new StmtProg(visitMultiLineStmt((Buff_1_1Parser.MultiLineStmtContext) ctx.dcl()),
                        visitProgEmpty((Buff_1_1Parser.ProgEmptyContext) ctx.prog()));
        }
        else
            return null;
    }

    boolean IsOneLineStmt(Buff_1_1Parser.DclContext ctx){
        return ctx instanceof Buff_1_1Parser.OneLineStmtContext;
    }

    boolean IsMultiLineStmt(Buff_1_1Parser.DclContext ctx){
        return ctx instanceof Buff_1_1Parser.MultiLineStmtContext;
    }

    @Override
    public Node visitStmtProg(Buff_1_1Parser.StmtProgContext ctx) {
        if (IsDclProgContext(ctx.prog()))
            return new StmtProg(visitStmt(ctx.stmt()), visitDclProg((Buff_1_1Parser.DclProgContext) ctx.prog()));
        else if (IsStmtProgContext(ctx.prog()))
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
        if (IsDclParamsContained(ctx.dclParams()))
            return new OneLineStmt(visitType(ctx.type()),visitDclParamscontained((Buff_1_1Parser.DclParamscontainedContext) ctx.dclParams()),
                visitStmt(ctx.stmt()),ctx.ID().getText());
        else
            return new OneLineStmt(visitType(ctx.type()),visitDclParamsEmpty((Buff_1_1Parser.DclParamsEmptyContext) ctx.dclParams()),
                visitStmt(ctx.stmt()),ctx.ID().getText());
    }

    @Override
    public Node visitMultiLineStmt(Buff_1_1Parser.MultiLineStmtContext ctx) {
        if (IsDclParamsContained(ctx.dclParams())) {
            if (IsStmtsContained(ctx.stmts()))
                return new MultiLineStmt(visitType(ctx.type()), visitDclParamscontained((Buff_1_1Parser.DclParamscontainedContext) ctx.dclParams()),
                        visitStmt(ctx.stmt()), ctx.ID().getText(), visitStmtsContained((Buff_1_1Parser.StmtsContainedContext) ctx.stmts()));
            else
                return new MultiLineStmt(visitType(ctx.type()), visitDclParamscontained((Buff_1_1Parser.DclParamscontainedContext) ctx.dclParams()),
                        visitStmt(ctx.stmt()), ctx.ID().getText(), visitStmtsEmpty((Buff_1_1Parser.StmtsEmptyContext) ctx.stmts()));
        }
        else{
            if (IsStmtsContained(ctx.stmts()))
                return new MultiLineStmt(visitType(ctx.type()), visitDclParamsEmpty((Buff_1_1Parser.DclParamsEmptyContext) ctx.dclParams()),
                        visitStmt(ctx.stmt()), ctx.ID().getText(), visitStmtsContained((Buff_1_1Parser.StmtsContainedContext) ctx.stmts()));
            else
                return new MultiLineStmt(visitType(ctx.type()), visitDclParamsEmpty((Buff_1_1Parser.DclParamsEmptyContext) ctx.dclParams()),
                        visitStmt(ctx.stmt()), ctx.ID().getText(), visitStmtsEmpty((Buff_1_1Parser.StmtsEmptyContext) ctx.stmts()));
        }
    }

    private boolean IsStmtsContained(Buff_1_1Parser.StmtsContext ctx) {
        return ctx instanceof Buff_1_1Parser.StmtsContainedContext;
    }

    private boolean IsDclParamsContained(Buff_1_1Parser.DclParamsContext ctx) {
        return ctx instanceof Buff_1_1Parser.DclParamscontainedContext;
    }

    @Override
    public Node visitType(Buff_1_1Parser.TypeContext ctx) {
        return new Type(ctx.getText());
    }

    @Override
    public Node visitDclParamscontained(Buff_1_1Parser.DclParamscontainedContext ctx) {
        if (IsDclMoreParamsContained(ctx.dclMoreParams()))
            return new DclParams(visitDclParam(ctx.dclParam()),
                visitDclMoreParamscontained((Buff_1_1Parser.DclMoreParamscontainedContext) ctx.dclMoreParams()));
        else
            return new DclParams(visitDclParam(ctx.dclParam()),
                    visitDclMoreParamsEmpty((Buff_1_1Parser.DclMoreParamsEmptyContext) ctx.dclMoreParams()));
    }

    @Override
    public Node visitDclParamsEmpty(Buff_1_1Parser.DclParamsEmptyContext ctx) {
        return null;
    }

    @Override
    public Node visitDclMoreParamscontained(Buff_1_1Parser.DclMoreParamscontainedContext ctx) {
        if (IsDclMoreParamsContained(ctx.dclMoreParams()))
            return new DclMoreParams(visitDclParam(ctx.dclParam()),
                    visitDclMoreParamscontained((Buff_1_1Parser.DclMoreParamscontainedContext) ctx.dclMoreParams()));
        else
            return new DclMoreParams(visitDclParam(ctx.dclParam()),
                    visitDclMoreParamsEmpty((Buff_1_1Parser.DclMoreParamsEmptyContext) ctx.dclMoreParams()));
    }

    private boolean IsDclMoreParamsContained(Buff_1_1Parser.DclMoreParamsContext ctx) {
        return ctx instanceof Buff_1_1Parser.DclMoreParamscontainedContext;
    }

    @Override
    public Node visitDclMoreParamsEmpty(Buff_1_1Parser.DclMoreParamsEmptyContext ctx) {
        return null;
    }

    @Override
    public Node visitDclParam(Buff_1_1Parser.DclParamContext ctx) {
        return new DclParam(visitType(ctx.type()), ctx.ID().getText());
    }

    @Override
    public Node visitStmtsContained(Buff_1_1Parser.StmtsContainedContext ctx) {
        if (IsStmtsContained(ctx.stmts()))
            return new Stmts(visitExpr(ctx.expr()),visitStmt(ctx.stmt()),
                    visitStmtsContained((Buff_1_1Parser.StmtsContainedContext) ctx.stmts()));
        else
            return new Stmts(visitExpr(ctx.expr()),visitStmt(ctx.stmt()),
                    visitStmtsEmpty((Buff_1_1Parser.StmtsEmptyContext) ctx.stmts()));
    }

    private Node visitExpr(Buff_1_1Parser.ExprContext expr) {
        if (IsLogOr(expr))
            return visitLogOr((Buff_1_1Parser.LogOrContext) expr);
        else
            return visitLogExp((Buff_1_1Parser.LogExpContext) expr);
    }

    boolean IsLogOr(Buff_1_1Parser.ExprContext ctx){
        return ctx instanceof Buff_1_1Parser.LogOrContext;
    }

    @Override
    public Node visitStmtsEmpty(Buff_1_1Parser.StmtsEmptyContext ctx) {
        return null;
    }

    @Override
    public Node visitStmt(Buff_1_1Parser.StmtContext ctx) {
        if (IsLogOr(ctx.expr()))
            return new Stmt(visitLogOr((Buff_1_1Parser.LogOrContext) ctx.expr()));
        else {
            return new Stmt(visitLogExp((Buff_1_1Parser.LogExpContext) ctx.expr()));
        }
    }

    @Override
    public Node visitLogOr(Buff_1_1Parser.LogOrContext ctx) {
        if (IsLogAnd(ctx.left)) {
            if (IsLogOr(ctx.right))
                return new LogOr(visitLogAnd((Buff_1_1Parser.LogAndContext) ctx.left),
                        visitLogOr((Buff_1_1Parser.LogOrContext) ctx.right));
            else
                return new LogOr(visitLogAnd((Buff_1_1Parser.LogAndContext) ctx.left),
                        visitLogExp((Buff_1_1Parser.LogExpContext) ctx.right));
        }
        else {
            if (IsLogOr(ctx.right))
                return new LogOr(visitLog2((Buff_1_1Parser.Log2Context) ctx.left),
                        visitLogOr((Buff_1_1Parser.LogOrContext) ctx.right));
            else
                return new LogOr(visitLog2((Buff_1_1Parser.Log2Context) ctx.left),
                        visitLogExp((Buff_1_1Parser.LogExpContext) ctx.right));
        }
    }

    boolean IsLogAnd(Buff_1_1Parser.LgclExprContext ctx){
        return ctx instanceof Buff_1_1Parser.LogAndContext;
    }

    @Override
    public Node visitLogExp(Buff_1_1Parser.LogExpContext ctx) {
        if (IsLogAnd(ctx.lgclExpr()))
            return visitLogAnd((Buff_1_1Parser.LogAndContext) ctx.lgclExpr());
        else
            return visitLog2((Buff_1_1Parser.Log2Context) ctx.lgclExpr());
    }

    @Override
    public Node visitLogAnd(Buff_1_1Parser.LogAndContext ctx) {
        if (IsLogEqualsOp(ctx.left)){
            if (IsLogAnd(ctx.right))
                return new LogAnd(visitLogEqualsOp((Buff_1_1Parser.LogEqualsOpContext) ctx.left),
                        visitLogAnd((Buff_1_1Parser.LogAndContext) ctx.right));
            else
                    return new LogAnd(visitLogEqualsOp((Buff_1_1Parser.LogEqualsOpContext) ctx.left),
                            visitLog2((Buff_1_1Parser.Log2Context) ctx.right));
        }
        else{
            if (IsLogAnd(ctx.right))
                return new LogAnd(visitMathLog((Buff_1_1Parser.MathLogContext) ctx.left),
                        visitLogAnd((Buff_1_1Parser.LogAndContext) ctx.right));
            else
                return new LogAnd(visitMathLog((Buff_1_1Parser.MathLogContext) ctx.left),
                        visitLog2((Buff_1_1Parser.Log2Context) ctx.right));
        }
    }

    boolean IsLogEqualsOp(Buff_1_1Parser.LgclExpr2Context ctx){
        return ctx instanceof Buff_1_1Parser.LogEqualsOpContext;
    }

    @Override
    public Node visitLog2(Buff_1_1Parser.Log2Context ctx) {
        if (IsLogEqualsOp(ctx.lgclExpr2()))
            return visitLogEqualsOp((Buff_1_1Parser.LogEqualsOpContext) ctx.lgclExpr2());
        else
            return visitMathLog((Buff_1_1Parser.MathLogContext) ctx.lgclExpr2());
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
        else
            return visitMath((Buff_1_1Parser.MathContext) ctx.lgclExpr3());
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
        if (IsBinaryPlusMinus(ctx.mathExpr()))
            return visitBinaryOpPlusMinus((Buff_1_1Parser.BinaryOpPlusMinusContext) ctx.mathExpr());
        else
            return visitMathDivMul((Buff_1_1Parser.MathDivMulContext) ctx.mathExpr());
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
        else
            return visitMathPow((Buff_1_1Parser.MathPowContext) ctx.mathExpr2());
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
        if (IsPowExp(ctx.mathExpr3()))
            return visitBinaryOpPow((Buff_1_1Parser.BinaryOpPowContext) ctx.mathExpr3());
        else
            return visitLogUnary((Buff_1_1Parser.LogUnaryContext) ctx.mathExpr3());
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
        if (IsNegate(ctx.lgclExpr4()))
            return visitNegate((Buff_1_1Parser.NegateContext) ctx.lgclExpr4());
        else
            return visitValue((Buff_1_1Parser.ValueContext) ctx.lgclExpr4());
    }

    @Override
    public Node visitNegate(Buff_1_1Parser.NegateContext ctx) {
        return new Negate(visitValue(ctx.val()));
    }

    @Override
    public Node visitValue(Buff_1_1Parser.ValueContext ctx) {
        return visitValue(ctx.val());
    }

    public Node visitValue(Buff_1_1Parser.ValContext ctx) {
        if (IsParensExp(ctx))
            return visitParensExp((Buff_1_1Parser.ParensExpContext) ctx);
        else if (IsValFuncCall(ctx))
            return visitValFuncCall((Buff_1_1Parser.ValFuncCallContext) ctx);
        else if (IsValFuncCallDebug(ctx))
            return visitValFuncCallDebug((Buff_1_1Parser.ValFuncCallDebugContext) ctx);
        else
            return visitValTerminal((Buff_1_1Parser.ValTerminalContext) ctx);
    }

    boolean IsParensExp(Buff_1_1Parser.ValContext ctx){
        return ctx instanceof Buff_1_1Parser.ParensExpContext;
    }

    boolean IsValFuncCall(Buff_1_1Parser.ValContext ctx){
        return ctx instanceof Buff_1_1Parser.ValFuncCallContext;
    }

    boolean IsValFuncCallDebug(Buff_1_1Parser.ValContext ctx){
        return ctx instanceof Buff_1_1Parser.ValFuncCallDebugContext;
    }

    @Override
    public Node visitParensExp(Buff_1_1Parser.ParensExpContext ctx) {
        if (IsLogOr(ctx.expr()))
            return new ParensExp(visitLogOr((Buff_1_1Parser.LogOrContext) ctx.expr()));
        else
            return new ParensExp(visitLogExp((Buff_1_1Parser.LogExpContext) ctx.expr()));
    }

    @Override
    public Node visitValFuncCall(Buff_1_1Parser.ValFuncCallContext ctx) {
        return visitFuncCall(ctx.funcCall());
    }

    @Override
    public Node visitValFuncCallDebug(Buff_1_1Parser.ValFuncCallDebugContext ctx) {
        if (IsStmtParamsContained(ctx.funcCall().stmtParams()))
            return new FuncCall(ctx.funcCall().ID().getText(),
                    visitStmtParamscontained((Buff_1_1Parser.StmtParamscontainedContext) ctx.funcCall().stmtParams()), true);
        else
            return new FuncCall(ctx.funcCall().ID().getText(),
                    visitStmtParamsEmpty((Buff_1_1Parser.StmtParamsEmptyContext) ctx.funcCall().stmtParams()),
                    true);
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
        if (IsStmtParamsContained(ctx.stmtParams()))
            return new FuncCall(ctx.ID().getText(),
                    visitStmtParamscontained((Buff_1_1Parser.StmtParamscontainedContext) ctx.stmtParams()));
        else
            return new FuncCall(ctx.ID().getText(), visitStmtParamsEmpty((Buff_1_1Parser.StmtParamsEmptyContext) ctx.stmtParams()));
    }


    private boolean IsStmtParamsContained(Buff_1_1Parser.StmtParamsContext ctx) {
        return ctx instanceof Buff_1_1Parser.StmtParamscontainedContext;
    }

    @Override
    public Node visitStmtParamscontained(Buff_1_1Parser.StmtParamscontainedContext ctx) {
        if (isExprMoreParamsContained(ctx.exprMoreParams()))
            return new StmtParams(visitExpr(ctx.expr()),
                    visitExprMoreParamsContained((Buff_1_1Parser.ExprMoreParamsContainedContext) ctx.exprMoreParams()));
        else
            return new StmtParams(visitExpr(ctx.expr()),
                    visitExprMoreParamsEmpty((Buff_1_1Parser.ExprMoreParamsEmptyContext) ctx.exprMoreParams()));
    }

    private boolean isExprMoreParamsContained(Buff_1_1Parser.ExprMoreParamsContext ctx) {
        return ctx instanceof Buff_1_1Parser.ExprMoreParamsContainedContext;
    }

    @Override
    public Node visitStmtParamsEmpty(Buff_1_1Parser.StmtParamsEmptyContext ctx) {
        return null;
    }

    @Override
    public Node visitExprMoreParamsContained(Buff_1_1Parser.ExprMoreParamsContainedContext ctx) {
        if (isExprMoreParamsContained(ctx.exprMoreParams()))
            return new ExprMoreParams(visitStmt(ctx.stmt()),
                    visitExprMoreParamsContained((Buff_1_1Parser.ExprMoreParamsContainedContext) ctx.exprMoreParams()));
        else
            return new ExprMoreParams(visitStmt(ctx.stmt()),
                    visitExprMoreParamsEmpty((Buff_1_1Parser.ExprMoreParamsEmptyContext) ctx.exprMoreParams()));
    }

    @Override
    public Node visitExprMoreParamsEmpty(Buff_1_1Parser.ExprMoreParamsEmptyContext ctx) {
        return null;
    }
}