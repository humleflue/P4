// Generated from C:/Users/chris/4-semester/Projekt/P4/ANTLR/src/main\Buff.g4 by ANTLR 4.9.1
package main;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BuffParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BuffVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BuffParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(BuffParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#dcls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcls(BuffParser.DclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(BuffParser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(BuffParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#dclParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclParams(BuffParser.DclParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#dclMoreParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclMoreParams(BuffParser.DclMoreParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#dclParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclParam(BuffParser.DclParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(BuffParser.StmtsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(BuffParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath(BuffParser.MathContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#followTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFollowTerm(BuffParser.FollowTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(BuffParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#simpleOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleOps(BuffParser.SimpleOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(BuffParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(BuffParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#stmtParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtParams(BuffParser.StmtParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#stmtMoreParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtMoreParams(BuffParser.StmtMoreParamsContext ctx);
}