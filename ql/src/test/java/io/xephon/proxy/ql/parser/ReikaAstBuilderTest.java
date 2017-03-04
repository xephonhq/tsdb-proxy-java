package io.xephon.proxy.ql.parser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by at15 on 3/4/17.
 * <p>
 * Test AST Builder
 */
public class ReikaAstBuilderTest {
    @Test
    public void testVisitor() throws IOException {
        ReikaParser parser = Util.parserFromResource("skeleton.reika");
        ParseTree t = parser.prog();
        ReikaBaseVisitor baseVisitor = new ReikaBaseVisitor();
        baseVisitor.visit(t);
        ReikaAstBuilder astBuilder = new ReikaAstBuilder();
        System.out.println(astBuilder.visit(t));
    }
}
