// Generated from C:/Users/chris/4-semester/Projekt/P4/ANTLR/src/main\Buff.g4 by ANTLR 4.9.1
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
	 * Enter a parse tree produced by {@link BuffParser#dclparams}.
	 * @param ctx the parse tree
	 */
	void enterDclparams(BuffParser.DclparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#dclparams}.
	 * @param ctx the parse tree
	 */
	void exitDclparams(BuffParser.DclparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#dclmoreparams}.
	 * @param ctx the parse tree
	 */
	void enterDclmoreparams(BuffParser.DclmoreparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#dclmoreparams}.
	 * @param ctx the parse tree
	 */
	void exitDclmoreparams(BuffParser.DclmoreparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#dclparam}.
	 * @param ctx the parse tree
	 */
	void enterDclparam(BuffParser.DclparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#dclparam}.
	 * @param ctx the parse tree
	 */
	void exitDclparam(BuffParser.DclparamContext ctx);
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
	 * Enter a parse tree produced by {@link BuffParser#followterm}.
	 * @param ctx the parse tree
	 */
	void enterFollowterm(BuffParser.FollowtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#followterm}.
	 * @param ctx the parse tree
	 */
	void exitFollowterm(BuffParser.FollowtermContext ctx);
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
	 * Enter a parse tree produced by {@link BuffParser#simpleops}.
	 * @param ctx the parse tree
	 */
	void enterSimpleops(BuffParser.SimpleopsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#simpleops}.
	 * @param ctx the parse tree
	 */
	void exitSimpleops(BuffParser.SimpleopsContext ctx);
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
	 * Enter a parse tree produced by {@link BuffParser#funccall}.
	 * @param ctx the parse tree
	 */
	void enterFunccall(BuffParser.FunccallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#funccall}.
	 * @param ctx the parse tree
	 */
	void exitFunccall(BuffParser.FunccallContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#stmtparams}.
	 * @param ctx the parse tree
	 */
	void enterStmtparams(BuffParser.StmtparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#stmtparams}.
	 * @param ctx the parse tree
	 */
	void exitStmtparams(BuffParser.StmtparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuffParser#stmtmoreparams}.
	 * @param ctx the parse tree
	 */
	void enterStmtmoreparams(BuffParser.StmtmoreparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuffParser#stmtmoreparams}.
	 * @param ctx the parse tree
	 */
	void exitStmtmoreparams(BuffParser.StmtmoreparamsContext ctx);
}