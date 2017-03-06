package io.xephon.proxy.ql.parser;

import io.xephon.proxy.ql.checker.SymbolTable;
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
    public void testSkeleton() throws IOException {
        ReikaParser parser = Util.parserFromResource("skeleton.reika");
        ParseTree tree = parser.prog();
        ReikaBaseVisitor baseVisitor = new ReikaBaseVisitor();
        baseVisitor.visit(tree);
        ReikaAstBuilder astBuilder = new ReikaAstBuilder();
        System.out.println(astBuilder.visit(tree));
        SymbolTable.printTable(astBuilder.getSymbolTable());
    }

    @Test
    public void testInt() throws IOException {
        ReikaParser parser = Util.parserFromResource("int_only.reika");
        ParseTree tree = parser.prog();
        ReikaBaseVisitor baseVisitor = new ReikaBaseVisitor();
        baseVisitor.visit(tree);
        ReikaAstBuilder astBuilder = new ReikaAstBuilder();
        astBuilder.visit(tree);
    }
}
