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
}
