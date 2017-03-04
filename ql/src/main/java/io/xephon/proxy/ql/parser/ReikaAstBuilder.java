package io.xephon.proxy.ql.parser;

import io.xephon.proxy.ql.ast.Node;

/**
 * Created by at15 on 3/3/17.
 * <p>
 * Build AST
 *
 * @TODO: should use Node instead of Void, but Prog has can have a list of statement
 */
public class ReikaAstBuilder extends ReikaBaseVisitor<Node> {
    @Override
    public Node visitProg(ReikaParser.ProgContext ctx) {
        System.out.println("visit program!");
        return visitChildren(ctx);
    }

    @Override
    public Node visitVarDeclareStat(ReikaParser.VarDeclareStatContext ctx) {
        System.out.println("visit var declare statement");
        System.out.println(ctx.varDeclare().type().getText());
        System.out.println(ctx.varDeclare().ID().getText());
        System.out.println(ctx.varDeclare().expr().getText());
        System.out.println("line:" + ctx.varDeclare().getStart().getLine());
        return visitChildren(ctx);
    }

    @Override
    public Node visitVarAssignStat(ReikaParser.VarAssignStatContext ctx) {
        System.out.println("visit var assign statement");
        System.out.println(ctx.varAssign().ID().getText());
        System.out.println(ctx.varAssign().expr().getText());
        return visitChildren(ctx);
    }

    @Override
    public Node visitExprStat(ReikaParser.ExprStatContext ctx) {
        System.out.println("visit expr statement");
        System.out.println(ctx.expr().getText());
        return visitChildren(ctx);
    }

    @Override
    public Node visitCall(ReikaParser.CallContext ctx) {
        System.out.println("visit call expression");
//        ctx.exprList().expr(); // this will return a list
        return visitChildren(ctx);
    }
}
