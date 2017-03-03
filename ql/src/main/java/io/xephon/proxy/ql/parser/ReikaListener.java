// Generated from Reika.g4 by ANTLR 4.6
package io.xephon.proxy.ql.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ReikaParser}.
 */
public interface ReikaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ReikaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ReikaParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReikaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ReikaParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReikaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ReikaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReikaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ReikaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReikaParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(ReikaParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReikaParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(ReikaParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReikaParser#varAssign}.
	 * @param ctx the parse tree
	 */
	void enterVarAssign(ReikaParser.VarAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReikaParser#varAssign}.
	 * @param ctx the parse tree
	 */
	void exitVarAssign(ReikaParser.VarAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReikaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ReikaParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReikaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ReikaParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ReikaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ReikaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReikaParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(ReikaParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReikaParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(ReikaParser.ExprListContext ctx);
}