// Generated from ./B.g4 by ANTLR 4.9
package B;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(BParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code codeFuncdef}
	 * labeled alternative in {@link BParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeFuncdef(BParser.CodeFuncdefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code codeStmt}
	 * labeled alternative in {@link BParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeStmt(BParser.CodeStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code codeEmpty}
	 * labeled alternative in {@link BParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeEmpty(BParser.CodeEmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdef(BParser.FuncdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(BParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcdefparamsNotEmpty}
	 * labeled alternative in {@link BParser#funcdefparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdefparamsNotEmpty(BParser.FuncdefparamsNotEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcdefparamsEmpty}
	 * labeled alternative in {@link BParser#funcdefparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdefparamsEmpty(BParser.FuncdefparamsEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcdefmoreparamsNotEmpty}
	 * labeled alternative in {@link BParser#funcdefmoreparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdefmoreparamsNotEmpty(BParser.FuncdefmoreparamsNotEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcdefmoreparamsEmpty}
	 * labeled alternative in {@link BParser#funcdefmoreparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdefmoreparamsEmpty(BParser.FuncdefmoreparamsEmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#funcdefparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdefparam(BParser.FuncdefparamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtsNotEmpty}
	 * labeled alternative in {@link BParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtsNotEmpty(BParser.StmtsNotEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtsEmpty}
	 * labeled alternative in {@link BParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtsEmpty(BParser.StmtsEmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(BParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logOrOp}
	 * labeled alternative in {@link BParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogOrOp(BParser.LogOrOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code log}
	 * labeled alternative in {@link BParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLog(BParser.LogContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logAndOp}
	 * labeled alternative in {@link BParser#logexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogAndOp(BParser.LogAndOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code log2}
	 * labeled alternative in {@link BParser#logexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLog2(BParser.Log2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code logEqualsOp}
	 * labeled alternative in {@link BParser#logexpr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogEqualsOp(BParser.LogEqualsOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code log3}
	 * labeled alternative in {@link BParser#logexpr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLog3(BParser.Log3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code logOp}
	 * labeled alternative in {@link BParser#logexpr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogOp(BParser.LogOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code math}
	 * labeled alternative in {@link BParser#logexpr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath(BParser.MathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusMinus}
	 * labeled alternative in {@link BParser#mathexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinus(BParser.PlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code math2}
	 * labeled alternative in {@link BParser#mathexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath2(BParser.Math2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code multDiv}
	 * labeled alternative in {@link BParser#mathexpr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDiv(BParser.MultDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code math3}
	 * labeled alternative in {@link BParser#mathexpr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath3(BParser.Math3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code pow}
	 * labeled alternative in {@link BParser#mathexpr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(BParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code log4}
	 * labeled alternative in {@link BParser#mathexpr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLog4(BParser.Log4Context ctx);
	/**
	 * Visit a parse tree produced by the {@code negate}
	 * labeled alternative in {@link BParser#logexpr4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegate(BParser.NegateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code value}
	 * labeled alternative in {@link BParser#logexpr4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(BParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valParenthesisedExpr}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValParenthesisedExpr(BParser.ValParenthesisedExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valFunccall}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValFunccall(BParser.ValFunccallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valFunccallPrint}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValFunccallPrint(BParser.ValFunccallPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valNumber}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValNumber(BParser.ValNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valBoolean}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValBoolean(BParser.ValBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valId}
	 * labeled alternative in {@link BParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValId(BParser.ValIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link BParser#funccall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunccall(BParser.FunccallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprparamsNotEmpty}
	 * labeled alternative in {@link BParser#exprparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprparamsNotEmpty(BParser.ExprparamsNotEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprparamsEmpty}
	 * labeled alternative in {@link BParser#exprparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprparamsEmpty(BParser.ExprparamsEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprmoreparamsNotEmpty}
	 * labeled alternative in {@link BParser#exprmoreparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprmoreparamsNotEmpty(BParser.ExprmoreparamsNotEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprmoreparamsEmpty}
	 * labeled alternative in {@link BParser#exprmoreparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprmoreparamsEmpty(BParser.ExprmoreparamsEmptyContext ctx);
}