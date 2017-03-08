package io.xephon.proxy.ql.interpreter;

import io.xephon.proxy.ql.parser.ReikaAstBuilder;
import io.xephon.proxy.ql.parser.Util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by at15 on 3/5/17.
 * <p>
 * Test the naive interpreter
 */
public class NaiveInterpreterTest {
    @Test
    public void testInt() throws Exception {
        ReikaAstBuilder astBuilder = Util.astBuilderFromResource("int_only.reika");
//        astBuilder.printErrors();
        assertFalse(astBuilder.hasError());
        NaiveInterpreter interpreter = new NaiveInterpreter();
        interpreter.evalProgram(astBuilder.getStatements());
        assertEquals(10, (int) interpreter.resolveInt("a"));
    }

    @Test
    public void testString() throws Exception {
        ReikaAstBuilder astBuilder = Util.astBuilderFromResource("int_string.reika");
//        astBuilder.printErrors();
        assertFalse(astBuilder.hasError());
        NaiveInterpreter interpreter = new NaiveInterpreter();
        interpreter.evalProgram(astBuilder.getStatements());
        assertEquals(2, (int) interpreter.resolveInt("b"));
        assertEquals("hahanaive", interpreter.resolveString("jj"));
    }

    @Test
    public void testDouble() throws Exception {
        ReikaAstBuilder astBuilder = Util.astBuilderFromResource("double_only.reika");
//        astBuilder.printErrors();
        assertFalse(astBuilder.hasError());
        NaiveInterpreter interpreter = new NaiveInterpreter();
        interpreter.evalProgram(astBuilder.getStatements());
        assertEquals(10.0, (double) interpreter.resolveDouble("a"),0.0);
    }

}
