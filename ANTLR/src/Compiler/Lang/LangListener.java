// Generated from Lang.g4 by ANTLR 4.9
package Compiler.Lang;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParser}.
 */
public interface LangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code codeFuncdef}
	 * labeled alternative in {@link LangParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCodeFuncdef(LangParser.CodeFuncdefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code codeFuncdef}
	 * labeled alternative in {@link LangParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCodeFuncdef(LangParser.CodeFuncdefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code codeStmt}
	 * labeled alternative in {@link LangParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCodeStmt(LangParser.CodeStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code codeStmt}
	 * labeled alternative in {@link LangParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCodeStmt(LangParser.CodeStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code codeEmpty}
	 * labeled alternative in {@link LangParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCodeEmpty(LangParser.CodeEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code codeEmpty}
	 * labeled alternative in {@link LangParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCodeEmpty(LangParser.CodeEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef(LangParser.FuncdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef(LangParser.FuncdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcdefparamsNotEmpty}
	 * labeled alternative in {@link LangParser#funcdefparams}.
	 * @param ctx the parse tree
	 */
	void enterFuncdefparamsNotEmpty(LangParser.FuncdefparamsNotEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcdefparamsNotEmpty}
	 * labeled alternative in {@link LangParser#funcdefparams}.
	 * @param ctx the parse tree
	 */
	void exitFuncdefparamsNotEmpty(LangParser.FuncdefparamsNotEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcdefparamsEmpty}
	 * labeled alternative in {@link LangParser#funcdefparams}.
	 * @param ctx the parse tree
	 */
	void enterFuncdefparamsEmpty(LangParser.FuncdefparamsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcdefparamsEmpty}
	 * labeled alternative in {@link LangParser#funcdefparams}.
	 * @param ctx the parse tree
	 */
	void exitFuncdefparamsEmpty(LangParser.FuncdefparamsEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#funcdefparam}.
	 * @param ctx the parse tree
	 */
	void enterFuncdefparam(LangParser.FuncdefparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#funcdefparam}.
	 * @param ctx the parse tree
	 */
	void exitFuncdefparam(LangParser.FuncdefparamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtsNotEmpty}
	 * labeled alternative in {@link LangParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmtsNotEmpty(LangParser.StmtsNotEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtsNotEmpty}
	 * labeled alternative in {@link LangParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmtsNotEmpty(LangParser.StmtsNotEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtsEmpty}
	 * labeled alternative in {@link LangParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmtsEmpty(LangParser.StmtsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtsEmpty}
	 * labeled alternative in {@link LangParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmtsEmpty(LangParser.StmtsEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(LangParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(LangParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryOp}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(LangParser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryOp}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(LangParser.BinaryOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code uneryOp}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUneryOp(LangParser.UneryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code uneryOp}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUneryOp(LangParser.UneryOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code value}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterValue(LangParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code value}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitValue(LangParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valParenthesisedExpr}
	 * labeled alternative in {@link LangParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValParenthesisedExpr(LangParser.ValParenthesisedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valParenthesisedExpr}
	 * labeled alternative in {@link LangParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValParenthesisedExpr(LangParser.ValParenthesisedExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valFunccall}
	 * labeled alternative in {@link LangParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValFunccall(LangParser.ValFunccallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valFunccall}
	 * labeled alternative in {@link LangParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValFunccall(LangParser.ValFunccallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valFunccallPrint}
	 * labeled alternative in {@link LangParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValFunccallPrint(LangParser.ValFunccallPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valFunccallPrint}
	 * labeled alternative in {@link LangParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValFunccallPrint(LangParser.ValFunccallPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valNumber}
	 * labeled alternative in {@link LangParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValNumber(LangParser.ValNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valNumber}
	 * labeled alternative in {@link LangParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValNumber(LangParser.ValNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valBoolean}
	 * labeled alternative in {@link LangParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValBoolean(LangParser.ValBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valBoolean}
	 * labeled alternative in {@link LangParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValBoolean(LangParser.ValBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valId}
	 * labeled alternative in {@link LangParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValId(LangParser.ValIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valId}
	 * labeled alternative in {@link LangParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValId(LangParser.ValIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#funccall}.
	 * @param ctx the parse tree
	 */
	void enterFunccall(LangParser.FunccallContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#funccall}.
	 * @param ctx the parse tree
	 */
	void exitFunccall(LangParser.FunccallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprparamsNotEmpty}
	 * labeled alternative in {@link LangParser#exprparams}.
	 * @param ctx the parse tree
	 */
	void enterExprparamsNotEmpty(LangParser.ExprparamsNotEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprparamsNotEmpty}
	 * labeled alternative in {@link LangParser#exprparams}.
	 * @param ctx the parse tree
	 */
	void exitExprparamsNotEmpty(LangParser.ExprparamsNotEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprparamsEmpty}
	 * labeled alternative in {@link LangParser#exprparams}.
	 * @param ctx the parse tree
	 */
	void enterExprparamsEmpty(LangParser.ExprparamsEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprparamsEmpty}
	 * labeled alternative in {@link LangParser#exprparams}.
	 * @param ctx the parse tree
	 */
	void exitExprparamsEmpty(LangParser.ExprparamsEmptyContext ctx);
}