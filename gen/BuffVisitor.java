// Generated from C:/Users/chris/4-semester/Projekt/P4/ANTLR/src/main\Buff.g4 by ANTLR 4.9.1
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
	 * Visit a parse tree produced by {@link BuffParser#dclparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclparams(BuffParser.DclparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#dclmoreparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclmoreparams(BuffParser.DclmoreparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#dclparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclparam(BuffParser.DclparamContext ctx);
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
	 * Visit a parse tree produced by {@link BuffParser#followterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFollowterm(BuffParser.FollowtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(BuffParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#simpleops}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleops(BuffParser.SimpleopsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(BuffParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#funccall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunccall(BuffParser.FunccallContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#stmtparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtparams(BuffParser.StmtparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuffParser#stmtmoreparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtmoreparams(BuffParser.StmtmoreparamsContext ctx);
}