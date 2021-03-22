// Generated from Buff_1_1.g4 by ANTLR 4.9
package Buff;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Buff_1_1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Buff_1_1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Buff_1_1Parser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(Buff_1_1Parser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dclProg}
	 * labeled alternative in {@link Buff_1_1Parser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclProg(Buff_1_1Parser.DclProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtProg}
	 * labeled alternative in {@link Buff_1_1Parser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtProg(Buff_1_1Parser.StmtProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code progEmpty}
	 * labeled alternative in {@link Buff_1_1Parser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgEmpty(Buff_1_1Parser.ProgEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oneLineStmt}
	 * labeled alternative in {@link Buff_1_1Parser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneLineStmt(Buff_1_1Parser.OneLineStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiLineStmt}
	 * labeled alternative in {@link Buff_1_1Parser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiLineStmt(Buff_1_1Parser.MultiLineStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Buff_1_1Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(Buff_1_1Parser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Buff_1_1Parser#dclParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclParams(Buff_1_1Parser.DclParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Buff_1_1Parser#dclMoreParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclMoreParams(Buff_1_1Parser.DclMoreParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Buff_1_1Parser#dclParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclParam(Buff_1_1Parser.DclParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link Buff_1_1Parser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(Buff_1_1Parser.StmtsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Buff_1_1Parser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(Buff_1_1Parser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logOr}
	 * labeled alternative in {@link Buff_1_1Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogOr(Buff_1_1Parser.LogOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logExp}
	 * labeled alternative in {@link Buff_1_1Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogExp(Buff_1_1Parser.LogExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logAnd}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogAnd(Buff_1_1Parser.LogAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code log2}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLog2(Buff_1_1Parser.Log2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code logEqualsOp}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogEqualsOp(Buff_1_1Parser.LogEqualsOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mathLog}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathLog(Buff_1_1Parser.MathLogContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalOp}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOp(Buff_1_1Parser.LogicalOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code math}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath(Buff_1_1Parser.MathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryOpPlusMinus}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOpPlusMinus(Buff_1_1Parser.BinaryOpPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mathDivMul}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathDivMul(Buff_1_1Parser.MathDivMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryOpDivMul}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOpDivMul(Buff_1_1Parser.BinaryOpDivMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mathPow}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathPow(Buff_1_1Parser.MathPowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryOpPoe}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOpPoe(Buff_1_1Parser.BinaryOpPoeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logUnary}
	 * labeled alternative in {@link Buff_1_1Parser#mathExpr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogUnary(Buff_1_1Parser.LogUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negate}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegate(Buff_1_1Parser.NegateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code value}
	 * labeled alternative in {@link Buff_1_1Parser#lgclExpr4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(Buff_1_1Parser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExp}
	 * labeled alternative in {@link Buff_1_1Parser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExp(Buff_1_1Parser.ParensExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valFuncCall}
	 * labeled alternative in {@link Buff_1_1Parser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValFuncCall(Buff_1_1Parser.ValFuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valFuncCallDebug}
	 * labeled alternative in {@link Buff_1_1Parser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValFuncCallDebug(Buff_1_1Parser.ValFuncCallDebugContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valTerminal}
	 * labeled alternative in {@link Buff_1_1Parser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValTerminal(Buff_1_1Parser.ValTerminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link Buff_1_1Parser#termVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermVal(Buff_1_1Parser.TermValContext ctx);
	/**
	 * Visit a parse tree produced by {@link Buff_1_1Parser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(Buff_1_1Parser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link Buff_1_1Parser#stmtParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtParams(Buff_1_1Parser.StmtParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Buff_1_1Parser#exprMoreParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMoreParams(Buff_1_1Parser.ExprMoreParamsContext ctx);
}