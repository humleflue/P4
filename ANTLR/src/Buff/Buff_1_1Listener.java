// Generated from Buff_1_1.g4 by ANTLR 4.7.2
package Buff;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Buff_1_1Parser}.
 */
public interface Buff_1_1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Buff_1_1Parser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(Buff_1_1Parser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link Buff_1_1Parser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(Buff_1_1Parser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dclProg}
	 * labeled alternative in {@link Buff_1_1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterDclProg(Buff_1_1Parser.DclProgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dclProg}
	 * labeled alternative in {@link Buff_1_1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitDclProg(Buff_1_1Parser.DclProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtProg}
	 * labeled alternative in {@link Buff_1_1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterStmtProg(Buff_1_1Parser.StmtProgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtProg}
	 * labeled alternative in {@link Buff_1_1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitStmtProg(Buff_1_1Parser.StmtProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code progEmpty}
	 * labeled alternative in {@link Buff_1_1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgEmpty(Buff_1_1Parser.ProgEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code progEmpty}
	 * labeled alternative in {@link Buff_1_1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgEmpty(Buff_1_1Parser.ProgEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code oneLineStmt}
	 * labeled alternative in {@link Buff_1_1Parser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterOneLineStmt(Buff_1_1Parser.OneLineStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code oneLineStmt}
	 * labeled alternative in {@link Buff_1_1Parser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitOneLineStmt(Buff_1_1Parser.OneLineStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiLineStmt}
	 * labeled alternative in {@link Buff_1_1Parser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterMultiLineStmt(Buff_1_1Parser.MultiLineStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiLineStmt}
	 * labeled alternative in {@link Buff_1_1Parser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitMultiLineStmt(Buff_1_1Parser.MultiLineStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Buff_1_1Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(Buff_1_1Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Buff_1_1Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(Buff_1_1Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dclParamscontained}
	 * labeled alternative in {@link Buff_1_1Parser#dclParams}.
	 * @param ctx the parse tree
	 */
	void enterDclParamscontained(Buff_1_1Parser.DclParamscontainedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dclParamscontained}
	 * labeled alternative in {@link Buff_1_1Parser#dclParams}.
	 * @param ctx the parse tree
	 */
	void exitDclParamscontained(Buff_1_1Parser.DclParamscontainedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dclParamsEmpty}
	 * labeled alternative in {@link Buff_1_1Parser#dclParams}.
	 * @param ctx the parse tree
	 */
	void enterDclParamsEmpty(Buff_1_1Parser.DclParamsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dclParamsEmpty}
	 * labeled alternative in {@link Buff_1_1Parser#dclParams}.
	 * @param ctx the parse tree
	 */
	void exitDclParamsEmpty(Buff_1_1Parser.DclParamsEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dclMoreParamscontained}
	 * labeled alternative in {@link Buff_1_1Parser#dclMoreParams}.
	 * @param ctx the parse tree
	 */
	void enterDclMoreParamscontained(Buff_1_1Parser.DclMoreParamscontainedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dclMoreParamscontained}
	 * labeled alternative in {@link Buff_1_1Parser#dclMoreParams}.
	 * @param ctx the parse tree
	 */
	void exitDclMoreParamscontained(Buff_1_1Parser.DclMoreParamscontainedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dclMoreParamsEmpty}
	 * labeled alternative in {@link Buff_1_1Parser#dclMoreParams}.
	 * @param ctx the parse tree
	 */
	void enterDclMoreParamsEmpty(Buff_1_1Parser.DclMoreParamsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dclMoreParamsEmpty}
	 * labeled alternative in {@link Buff_1_1Parser#dclMoreParams}.
	 * @param ctx the parse tree
	 */
	void exitDclMoreParamsEmpty(Buff_1_1Parser.DclMoreParamsEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Buff_1_1Parser#dclParam}.
	 * @param ctx the parse tree
	 */
	void enterDclParam(Buff_1_1Parser.DclParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link Buff_1_1Parser#dclParam}.
	 * @param ctx the parse tree
	 */
	void exitDclParam(Buff_1_1Parser.DclParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtsContained}
	 * labeled alternative in {@link Buff_1_1Parser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmtsContained(Buff_1_1Parser.StmtsContainedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtsContained}
	 * labeled alternative in {@link Buff_1_1Parser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmtsContained(Buff_1_1Parser.StmtsContainedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtsEmpty}
	 * labeled alternative in {@link Buff_1_1Parser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmtsEmpty(Buff_1_1Parser.StmtsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtsEmpty}
	 * labeled alternative in {@link Buff_1_1Parser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmtsEmpty(Buff_1_1Parser.StmtsEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Buff_1_1Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(Buff_1_1Parser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Buff_1_1Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(Buff_1_1Parser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logOr}
	 * labeled alternative in {@link Buff_1_1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogOr(Buff_1_1Parser.LogOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logOr}
	 * labeled alternative in {@link Buff_1_1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogOr(Buff_1_1Parser.LogOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logExp}
	 * labeled alternative in {@link Buff_1_1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogExp(Buff_1_1Parser.LogExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logExp}
	 * labeled alternative in {@link Buff_1_1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogExp(Buff_1_1Parser.LogExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logAnd}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogAnd(Buff_1_1Parser.LogAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logAnd}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogAnd(Buff_1_1Parser.LogAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code log2}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr}.
	 * @param ctx the parse tree
	 */
	void enterLog2(Buff_1_1Parser.Log2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code log2}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr}.
	 * @param ctx the parse tree
	 */
	void exitLog2(Buff_1_1Parser.Log2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code logEqualsOp}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr2}.
	 * @param ctx the parse tree
	 */
	void enterLogEqualsOp(Buff_1_1Parser.LogEqualsOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logEqualsOp}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr2}.
	 * @param ctx the parse tree
	 */
	void exitLogEqualsOp(Buff_1_1Parser.LogEqualsOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mathLog}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr2}.
	 * @param ctx the parse tree
	 */
	void enterMathLog(Buff_1_1Parser.MathLogContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mathLog}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr2}.
	 * @param ctx the parse tree
	 */
	void exitMathLog(Buff_1_1Parser.MathLogContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalOp}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr3}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOp(Buff_1_1Parser.LogicalOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalOp}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr3}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOp(Buff_1_1Parser.LogicalOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code math}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr3}.
	 * @param ctx the parse tree
	 */
	void enterMath(Buff_1_1Parser.MathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code math}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr3}.
	 * @param ctx the parse tree
	 */
	void exitMath(Buff_1_1Parser.MathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryOpPlusMinus}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOpPlusMinus(Buff_1_1Parser.BinaryOpPlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryOpPlusMinus}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOpPlusMinus(Buff_1_1Parser.BinaryOpPlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mathDivMul}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr}.
	 * @param ctx the parse tree
	 */
	void enterMathDivMul(Buff_1_1Parser.MathDivMulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mathDivMul}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr}.
	 * @param ctx the parse tree
	 */
	void exitMathDivMul(Buff_1_1Parser.MathDivMulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryOpDivMul}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr2}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOpDivMul(Buff_1_1Parser.BinaryOpDivMulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryOpDivMul}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr2}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOpDivMul(Buff_1_1Parser.BinaryOpDivMulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mathPow}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr2}.
	 * @param ctx the parse tree
	 */
	void enterMathPow(Buff_1_1Parser.MathPowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mathPow}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr2}.
	 * @param ctx the parse tree
	 */
	void exitMathPow(Buff_1_1Parser.MathPowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryOpPow}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr3}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOpPow(Buff_1_1Parser.BinaryOpPowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryOpPow}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr3}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOpPow(Buff_1_1Parser.BinaryOpPowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logUnary}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr3}.
	 * @param ctx the parse tree
	 */
	void enterLogUnary(Buff_1_1Parser.LogUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logUnary}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr3}.
	 * @param ctx the parse tree
	 */
	void exitLogUnary(Buff_1_1Parser.LogUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negate}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr4}.
	 * @param ctx the parse tree
	 */
	void enterNegate(Buff_1_1Parser.NegateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negate}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr4}.
	 * @param ctx the parse tree
	 */
	void exitNegate(Buff_1_1Parser.NegateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code value}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr4}.
	 * @param ctx the parse tree
	 */
	void enterValue(Buff_1_1Parser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code value}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr4}.
	 * @param ctx the parse tree
	 */
	void exitValue(Buff_1_1Parser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExp}
	 * labeled alternative in {@link Buff_1_1Parser#val}.
	 * @param ctx the parse tree
	 */
	void enterParensExp(Buff_1_1Parser.ParensExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExp}
	 * labeled alternative in {@link Buff_1_1Parser#val}.
	 * @param ctx the parse tree
	 */
	void exitParensExp(Buff_1_1Parser.ParensExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valFuncCall}
	 * labeled alternative in {@link Buff_1_1Parser#val}.
	 * @param ctx the parse tree
	 */
	void enterValFuncCall(Buff_1_1Parser.ValFuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valFuncCall}
	 * labeled alternative in {@link Buff_1_1Parser#val}.
	 * @param ctx the parse tree
	 */
	void exitValFuncCall(Buff_1_1Parser.ValFuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valFuncCallDebug}
	 * labeled alternative in {@link Buff_1_1Parser#val}.
	 * @param ctx the parse tree
	 */
	void enterValFuncCallDebug(Buff_1_1Parser.ValFuncCallDebugContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valFuncCallDebug}
	 * labeled alternative in {@link Buff_1_1Parser#val}.
	 * @param ctx the parse tree
	 */
	void exitValFuncCallDebug(Buff_1_1Parser.ValFuncCallDebugContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valTerminal}
	 * labeled alternative in {@link Buff_1_1Parser#val}.
	 * @param ctx the parse tree
	 */
	void enterValTerminal(Buff_1_1Parser.ValTerminalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valTerminal}
	 * labeled alternative in {@link Buff_1_1Parser#val}.
	 * @param ctx the parse tree
	 */
	void exitValTerminal(Buff_1_1Parser.ValTerminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link Buff_1_1Parser#termVal}.
	 * @param ctx the parse tree
	 */
	void enterTermVal(Buff_1_1Parser.TermValContext ctx);
	/**
	 * Exit a parse tree produced by {@link Buff_1_1Parser#termVal}.
	 * @param ctx the parse tree
	 */
	void exitTermVal(Buff_1_1Parser.TermValContext ctx);
	/**
	 * Enter a parse tree produced by {@link Buff_1_1Parser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(Buff_1_1Parser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link Buff_1_1Parser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(Buff_1_1Parser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtParamscontained}
	 * labeled alternative in {@link Buff_1_1Parser#stmtParams}.
	 * @param ctx the parse tree
	 */
	void enterStmtParamscontained(Buff_1_1Parser.StmtParamscontainedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtParamscontained}
	 * labeled alternative in {@link Buff_1_1Parser#stmtParams}.
	 * @param ctx the parse tree
	 */
	void exitStmtParamscontained(Buff_1_1Parser.StmtParamscontainedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtParamsEmpty}
	 * labeled alternative in {@link Buff_1_1Parser#stmtParams}.
	 * @param ctx the parse tree
	 */
	void enterStmtParamsEmpty(Buff_1_1Parser.StmtParamsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtParamsEmpty}
	 * labeled alternative in {@link Buff_1_1Parser#stmtParams}.
	 * @param ctx the parse tree
	 */
	void exitStmtParamsEmpty(Buff_1_1Parser.StmtParamsEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMoreParamsContained}
	 * labeled alternative in {@link Buff_1_1Parser#exprMoreParams}.
	 * @param ctx the parse tree
	 */
	void enterExprMoreParamsContained(Buff_1_1Parser.ExprMoreParamsContainedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMoreParamsContained}
	 * labeled alternative in {@link Buff_1_1Parser#exprMoreParams}.
	 * @param ctx the parse tree
	 */
	void exitExprMoreParamsContained(Buff_1_1Parser.ExprMoreParamsContainedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMoreParamsEmpty}
	 * labeled alternative in {@link Buff_1_1Parser#exprMoreParams}.
	 * @param ctx the parse tree
	 */
	void enterExprMoreParamsEmpty(Buff_1_1Parser.ExprMoreParamsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMoreParamsEmpty}
	 * labeled alternative in {@link Buff_1_1Parser#exprMoreParams}.
	 * @param ctx the parse tree
	 */
	void exitExprMoreParamsEmpty(Buff_1_1Parser.ExprMoreParamsEmptyContext ctx);
}