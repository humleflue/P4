// Generated from ./B.g4 by ANTLR 4.9
package B;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BParser}.
 */
public interface BListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(BParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(BParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code codeFuncdef}
	 * labeled alternative in {@link BParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCodeFuncdef(BParser.CodeFuncdefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code codeFuncdef}
	 * labeled alternative in {@link BParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCodeFuncdef(BParser.CodeFuncdefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code codeStmt}
	 * labeled alternative in {@link BParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCodeStmt(BParser.CodeStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code codeStmt}
	 * labeled alternative in {@link BParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCodeStmt(BParser.CodeStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code codeEmpty}
	 * labeled alternative in {@link BParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCodeEmpty(BParser.CodeEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code codeEmpty}
	 * labeled alternative in {@link BParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCodeEmpty(BParser.CodeEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef(BParser.FuncdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef(BParser.FuncdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(BParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(BParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcdefparamsNotEmpty}
	 * labeled alternative in {@link BParser#funcdefparams}.
	 * @param ctx the parse tree
	 */
	void enterFuncdefparamsNotEmpty(BParser.FuncdefparamsNotEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcdefparamsNotEmpty}
	 * labeled alternative in {@link BParser#funcdefparams}.
	 * @param ctx the parse tree
	 */
	void exitFuncdefparamsNotEmpty(BParser.FuncdefparamsNotEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcdefparamsEmpty}
	 * labeled alternative in {@link BParser#funcdefparams}.
	 * @param ctx the parse tree
	 */
	void enterFuncdefparamsEmpty(BParser.FuncdefparamsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcdefparamsEmpty}
	 * labeled alternative in {@link BParser#funcdefparams}.
	 * @param ctx the parse tree
	 */
	void exitFuncdefparamsEmpty(BParser.FuncdefparamsEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcdefmoreparamsNotEmpty}
	 * labeled alternative in {@link BParser#funcdefmoreparams}.
	 * @param ctx the parse tree
	 */
	void enterFuncdefmoreparamsNotEmpty(BParser.FuncdefmoreparamsNotEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcdefmoreparamsNotEmpty}
	 * labeled alternative in {@link BParser#funcdefmoreparams}.
	 * @param ctx the parse tree
	 */
	void exitFuncdefmoreparamsNotEmpty(BParser.FuncdefmoreparamsNotEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcdefmoreparamsEmpty}
	 * labeled alternative in {@link BParser#funcdefmoreparams}.
	 * @param ctx the parse tree
	 */
	void enterFuncdefmoreparamsEmpty(BParser.FuncdefmoreparamsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcdefmoreparamsEmpty}
	 * labeled alternative in {@link BParser#funcdefmoreparams}.
	 * @param ctx the parse tree
	 */
	void exitFuncdefmoreparamsEmpty(BParser.FuncdefmoreparamsEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#funcdefparam}.
	 * @param ctx the parse tree
	 */
	void enterFuncdefparam(BParser.FuncdefparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#funcdefparam}.
	 * @param ctx the parse tree
	 */
	void exitFuncdefparam(BParser.FuncdefparamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtsNotEmpty}
	 * labeled alternative in {@link BParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmtsNotEmpty(BParser.StmtsNotEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtsNotEmpty}
	 * labeled alternative in {@link BParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmtsNotEmpty(BParser.StmtsNotEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtsEmpty}
	 * labeled alternative in {@link BParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmtsEmpty(BParser.StmtsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtsEmpty}
	 * labeled alternative in {@link BParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmtsEmpty(BParser.StmtsEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(BParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(BParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logOrOp}
	 * labeled alternative in {@link BParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogOrOp(BParser.LogOrOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logOrOp}
	 * labeled alternative in {@link BParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogOrOp(BParser.LogOrOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code log}
	 * labeled alternative in {@link BParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLog(BParser.LogContext ctx);
	/**
	 * Exit a parse tree produced by the {@code log}
	 * labeled alternative in {@link BParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLog(BParser.LogContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logAndOp}
	 * labeled alternative in {@link BParser#logexpr}.
	 * @param ctx the parse tree
	 */
	void enterLogAndOp(BParser.LogAndOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logAndOp}
	 * labeled alternative in {@link BParser#logexpr}.
	 * @param ctx the parse tree
	 */
	void exitLogAndOp(BParser.LogAndOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code log2}
	 * labeled alternative in {@link BParser#logexpr}.
	 * @param ctx the parse tree
	 */
	void enterLog2(BParser.Log2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code log2}
	 * labeled alternative in {@link BParser#logexpr}.
	 * @param ctx the parse tree
	 */
	void exitLog2(BParser.Log2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code logEqualsOp}
	 * labeled alternative in {@link BParser#logexpr2}.
	 * @param ctx the parse tree
	 */
	void enterLogEqualsOp(BParser.LogEqualsOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logEqualsOp}
	 * labeled alternative in {@link BParser#logexpr2}.
	 * @param ctx the parse tree
	 */
	void exitLogEqualsOp(BParser.LogEqualsOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code log3}
	 * labeled alternative in {@link BParser#logexpr2}.
	 * @param ctx the parse tree
	 */
	void enterLog3(BParser.Log3Context ctx);
	/**
	 * Exit a parse tree produced by the {@code log3}
	 * labeled alternative in {@link BParser#logexpr2}.
	 * @param ctx the parse tree
	 */
	void exitLog3(BParser.Log3Context ctx);
	/**
	 * Enter a parse tree produced by the {@code logOp}
	 * labeled alternative in {@link BParser#logexpr3}.
	 * @param ctx the parse tree
	 */
	void enterLogOp(BParser.LogOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logOp}
	 * labeled alternative in {@link BParser#logexpr3}.
	 * @param ctx the parse tree
	 */
	void exitLogOp(BParser.LogOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code math}
	 * labeled alternative in {@link BParser#logexpr3}.
	 * @param ctx the parse tree
	 */
	void enterMath(BParser.MathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code math}
	 * labeled alternative in {@link BParser#logexpr3}.
	 * @param ctx the parse tree
	 */
	void exitMath(BParser.MathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusMinus}
	 * labeled alternative in {@link BParser#mathexpr}.
	 * @param ctx the parse tree
	 */
	void enterPlusMinus(BParser.PlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusMinus}
	 * labeled alternative in {@link BParser#mathexpr}.
	 * @param ctx the parse tree
	 */
	void exitPlusMinus(BParser.PlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code math2}
	 * labeled alternative in {@link BParser#mathexpr}.
	 * @param ctx the parse tree
	 */
	void enterMath2(BParser.Math2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code math2}
	 * labeled alternative in {@link BParser#mathexpr}.
	 * @param ctx the parse tree
	 */
	void exitMath2(BParser.Math2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code multDiv}
	 * labeled alternative in {@link BParser#mathexpr2}.
	 * @param ctx the parse tree
	 */
	void enterMultDiv(BParser.MultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multDiv}
	 * labeled alternative in {@link BParser#mathexpr2}.
	 * @param ctx the parse tree
	 */
	void exitMultDiv(BParser.MultDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code math3}
	 * labeled alternative in {@link BParser#mathexpr2}.
	 * @param ctx the parse tree
	 */
	void enterMath3(BParser.Math3Context ctx);
	/**
	 * Exit a parse tree produced by the {@code math3}
	 * labeled alternative in {@link BParser#mathexpr2}.
	 * @param ctx the parse tree
	 */
	void exitMath3(BParser.Math3Context ctx);
	/**
	 * Enter a parse tree produced by the {@code pow}
	 * labeled alternative in {@link BParser#mathexpr3}.
	 * @param ctx the parse tree
	 */
	void enterPow(BParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pow}
	 * labeled alternative in {@link BParser#mathexpr3}.
	 * @param ctx the parse tree
	 */
	void exitPow(BParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code log4}
	 * labeled alternative in {@link BParser#mathexpr3}.
	 * @param ctx the parse tree
	 */
	void enterLog4(BParser.Log4Context ctx);
	/**
	 * Exit a parse tree produced by the {@code log4}
	 * labeled alternative in {@link BParser#mathexpr3}.
	 * @param ctx the parse tree
	 */
	void exitLog4(BParser.Log4Context ctx);
	/**
	 * Enter a parse tree produced by the {@code negate}
	 * labeled alternative in {@link BParser#logexpr4}.
	 * @param ctx the parse tree
	 */
	void enterNegate(BParser.NegateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negate}
	 * labeled alternative in {@link BParser#logexpr4}.
	 * @param ctx the parse tree
	 */
	void exitNegate(BParser.NegateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code value}
	 * labeled alternative in {@link BParser#logexpr4}.
	 * @param ctx the parse tree
	 */
	void enterValue(BParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code value}
	 * labeled alternative in {@link BParser#logexpr4}.
	 * @param ctx the parse tree
	 */
	void exitValue(BParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valParenthesisedExpr}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValParenthesisedExpr(BParser.ValParenthesisedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valParenthesisedExpr}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValParenthesisedExpr(BParser.ValParenthesisedExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valFunccall}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValFunccall(BParser.ValFunccallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valFunccall}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValFunccall(BParser.ValFunccallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valFunccallPrint}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValFunccallPrint(BParser.ValFunccallPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valFunccallPrint}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValFunccallPrint(BParser.ValFunccallPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valNumber}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValNumber(BParser.ValNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valNumber}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValNumber(BParser.ValNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valBoolean}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValBoolean(BParser.ValBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valBoolean}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValBoolean(BParser.ValBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valId}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValId(BParser.ValIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valId}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValId(BParser.ValIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link BParser#funccall}.
	 * @param ctx the parse tree
	 */
	void enterFunccall(BParser.FunccallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BParser#funccall}.
	 * @param ctx the parse tree
	 */
	void exitFunccall(BParser.FunccallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprparamsNotEmpty}
	 * labeled alternative in {@link BParser#exprparams}.
	 * @param ctx the parse tree
	 */
	void enterExprparamsNotEmpty(BParser.ExprparamsNotEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprparamsNotEmpty}
	 * labeled alternative in {@link BParser#exprparams}.
	 * @param ctx the parse tree
	 */
	void exitExprparamsNotEmpty(BParser.ExprparamsNotEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprparamsEmpty}
	 * labeled alternative in {@link BParser#exprparams}.
	 * @param ctx the parse tree
	 */
	void enterExprparamsEmpty(BParser.ExprparamsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprparamsEmpty}
	 * labeled alternative in {@link BParser#exprparams}.
	 * @param ctx the parse tree
	 */
	void exitExprparamsEmpty(BParser.ExprparamsEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprmoreparamsNotEmpty}
	 * labeled alternative in {@link BParser#exprmoreparams}.
	 * @param ctx the parse tree
	 */
	void enterExprmoreparamsNotEmpty(BParser.ExprmoreparamsNotEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprmoreparamsNotEmpty}
	 * labeled alternative in {@link BParser#exprmoreparams}.
	 * @param ctx the parse tree
	 */
	void exitExprmoreparamsNotEmpty(BParser.ExprmoreparamsNotEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprmoreparamsEmpty}
	 * labeled alternative in {@link BParser#exprmoreparams}.
	 * @param ctx the parse tree
	 */
	void enterExprmoreparamsEmpty(BParser.ExprmoreparamsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprmoreparamsEmpty}
	 * labeled alternative in {@link BParser#exprmoreparams}.
	 * @param ctx the parse tree
	 */
	void exitExprmoreparamsEmpty(BParser.ExprmoreparamsEmptyContext ctx);
}