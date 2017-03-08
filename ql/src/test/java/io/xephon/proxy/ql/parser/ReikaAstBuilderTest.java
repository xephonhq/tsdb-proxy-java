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
        ReikaAstBuilder astBuilder = Util.astBuilderFromResource("int_only.reika");
        astBuilder.printErrors();
        assertFalse(astBuilder.hasError());
    }

    @Test
    public void testDouble() throws IOException {
        ReikaAstBuilder astBuilder = Util.astBuilderFromResource("double_only.reika");
        astBuilder.printErrors();
        assertFalse(astBuilder.hasError());
    }

    @Test
    public void testSymbolError() throws IOException {
// NOTE: uncomment the following code to see how java (IDEA) handle symbol error
//        int a = 1;
//        int a = 2; // duplicate declaration
//        b = 3; // undefined identifier
//        int c = d + 1; // undefined identifier
//        int e = b + c; // TODO: if we have recover, then only b should be reported
        ReikaAstBuilder astBuilder = Util.astBuilderFromResource("error_symbol.reika");
        assertTrue(astBuilder.hasError());
        astBuilder.printErrors();
    }

    @Test
    public void testTypeError() throws IOException {
        ReikaAstBuilder astBuilder = Util.astBuilderFromResource("error_type.reika");
        assertTrue(astBuilder.hasError());
        astBuilder.printErrors();
    }

    @Test
    public void testRecoveryDeclarationDuplication() throws IOException {
        ReikaAstBuilder astBuilder = Util.astBuilderFromResource("recovery_declare_dup.reika");
        assertTrue(astBuilder.hasError());
        astBuilder.printErrors();
    }

    @Test
    public void testRecoveryUndefinedAssign() throws IOException {
        ReikaAstBuilder astBuilder = Util.astBuilderFromResource("recovery_undefined_assign.reika");
        assertTrue(astBuilder.hasError());
        astBuilder.printErrors();
    }
}
