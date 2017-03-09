// Generated from Reika.g4 by ANTLR 4.6
package io.xephon.proxy.ql.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ReikaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ReikaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ReikaParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ReikaParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReikaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(ReikaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReikaParser#varDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclare(ReikaParser.VarDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReikaParser#varAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssign(ReikaParser.VarAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDeclareStat}
	 * labeled alternative in {@link ReikaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclareStat(ReikaParser.VarDeclareStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarAssignStat}
	 * labeled alternative in {@link ReikaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssignStat(ReikaParser.VarAssignStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprStat}
	 * labeled alternative in {@link ReikaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(ReikaParser.ExprStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(ReikaParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(ReikaParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(ReikaParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ReikaParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(ReikaParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(ReikaParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(ReikaParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(ReikaParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(ReikaParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Double}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble(ReikaParser.DoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(ReikaParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(ReikaParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReikaParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(ReikaParser.ExprListContext ctx);
}