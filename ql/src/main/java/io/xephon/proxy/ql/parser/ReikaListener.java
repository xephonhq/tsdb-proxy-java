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
	 * Enter a parse tree produced by {@link ReikaParser#varDeclare}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclare(ReikaParser.VarDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReikaParser#varDeclare}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclare(ReikaParser.VarDeclareContext ctx);
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
	 * Enter a parse tree produced by the {@code VarDeclareStat}
	 * labeled alternative in {@link ReikaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclareStat(ReikaParser.VarDeclareStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarDeclareStat}
	 * labeled alternative in {@link ReikaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclareStat(ReikaParser.VarDeclareStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarAssignStat}
	 * labeled alternative in {@link ReikaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterVarAssignStat(ReikaParser.VarAssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarAssignStat}
	 * labeled alternative in {@link ReikaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitVarAssignStat(ReikaParser.VarAssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprStat}
	 * labeled alternative in {@link ReikaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(ReikaParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprStat}
	 * labeled alternative in {@link ReikaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(ReikaParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdd(ReikaParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdd(ReikaParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Call}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCall(ReikaParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCall(ReikaParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ReikaParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ReikaParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(ReikaParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(ReikaParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(ReikaParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(ReikaParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMinus(ReikaParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMinus(ReikaParser.MinusContext ctx);
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