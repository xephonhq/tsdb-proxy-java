package io.xephon.proxy.ql.parser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by at15 on 3/4/17.
 * <p>
 * Test ANTLR generated code on skeleton code snippet `skeleton.reika`
 */
public class ReikaANTLRGeneratedTest {
    @Test
    public void testGeneratedParser() throws IOException {
        ReikaParser parser = Util.parserFromResource("skeleton.reika");
        ParseTree t = parser.prog();
        System.out.println(t.toStringTree(parser));
    }

    @Test
    public void testGeneratedVisitor() throws IOException{
        ReikaParser parser = Util.parserFromResource("skeleton.reika");
        ParseTree t = parser.prog();
        ReikaBaseVisitor baseVisitor = new ReikaBaseVisitor();
        baseVisitor.visit(t);
    }
}
