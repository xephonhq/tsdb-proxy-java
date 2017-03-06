package io.xephon.proxy.ql.parser;

import io.xephon.proxy.ql.checker.SymbolTable;
import org.antlr.v4.runtime.tree.ParseTree;

import static org.junit.Assert.*;

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

    @Test
    public void testSymbolError() throws IOException {
// NOTE: uncomment the following code to see how java (IDEA) handle symbol error
//        int a = 1;
//        int a = 2; // duplicate declaration
//        b = 3; // undefined identifier
//        int c = d + 1; // undefined identifier
//        int e = b + c; // TODO: if we have recover, then only b should be reported
        ReikaParser parser = Util.parserFromResource("error_symbol.reika");
        ParseTree tree = parser.prog();
        ReikaAstBuilder astBuilder = new ReikaAstBuilder();
        astBuilder.visit(tree);
        assertTrue(astBuilder.hasError());
        System.out.println(astBuilder.errorAbstract());
        astBuilder.printErrors();
    }

    public void testTypeAssignOnly() throws IOException {

    }
}
