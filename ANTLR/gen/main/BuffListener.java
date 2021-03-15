// Generated from C:/Users/chris/4-semester/Projekt/P4/ANTLR/src/main\Buff.g4 by ANTLR 4.9.1
package main;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BuffParser}.
 */
public interface BuffListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BuffParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(BuffParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(BuffParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#dcls}.
	 * @param ctx the parse tree
	 */
	void enterDcls(BuffParser.DclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#dcls}.
	 * @param ctx the parse tree
	 */
	void exitDcls(BuffParser.DclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(BuffParser.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(BuffParser.DclContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(BuffParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(BuffParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#dclParams}.
	 * @param ctx the parse tree
	 */
	void enterDclParams(BuffParser.DclParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#dclParams}.
	 * @param ctx the parse tree
	 */
	void exitDclParams(BuffParser.DclParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#dclMoreParams}.
	 * @param ctx the parse tree
	 */
	void enterDclMoreParams(BuffParser.DclMoreParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#dclMoreParams}.
	 * @param ctx the parse tree
	 */
	void exitDclMoreParams(BuffParser.DclMoreParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#dclParam}.
	 * @param ctx the parse tree
	 */
	void enterDclParam(BuffParser.DclParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#dclParam}.
	 * @param ctx the parse tree
	 */
	void exitDclParam(BuffParser.DclParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmts(BuffParser.StmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmts(BuffParser.StmtsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(BuffParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(BuffParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMath(BuffParser.MathContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMath(BuffParser.MathContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#followTerm}.
	 * @param ctx the parse tree
	 */
	void enterFollowTerm(BuffParser.FollowTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#followTerm}.
	 * @param ctx the parse tree
	 */
	void exitFollowTerm(BuffParser.FollowTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(BuffParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(BuffParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#simpleOps}.
	 * @param ctx the parse tree
	 */
	void enterSimpleOps(BuffParser.SimpleOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#simpleOps}.
	 * @param ctx the parse tree
	 */
	void exitSimpleOps(BuffParser.SimpleOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#val}.
	 * @param ctx the parse tree
	 */
	void enterVal(BuffParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#val}.
	 * @param ctx the parse tree
	 */
	void exitVal(BuffParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(BuffParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(BuffParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#stmtParams}.
	 * @param ctx the parse tree
	 */
	void enterStmtParams(BuffParser.StmtParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#stmtParams}.
	 * @param ctx the parse tree
	 */
	void exitStmtParams(BuffParser.StmtParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#stmtMoreParams}.
	 * @param ctx the parse tree
	 */
	void enterStmtMoreParams(BuffParser.StmtMoreParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#stmtMoreParams}.
	 * @param ctx the parse tree
	 */
	void exitStmtMoreParams(BuffParser.StmtMoreParamsContext ctx);
}