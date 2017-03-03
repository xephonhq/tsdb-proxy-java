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
	 * Visit a parse tree produced by {@link ReikaParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(ReikaParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReikaParser#varAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssign(ReikaParser.VarAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReikaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(ReikaParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ReikaParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReikaParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(ReikaParser.ExprListContext ctx);
}