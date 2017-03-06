package io.xephon.proxy.ql.interpreter;

import io.xephon.proxy.ql.parser.ReikaAstBuilder;
import io.xephon.proxy.ql.parser.ReikaParser;
import io.xephon.proxy.ql.parser.Util;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

/**
 * Created by at15 on 3/5/17.
 * <p>
 * Test the naive interpreter
 */
public class NaiveInterpreterTest {
    @Test
    public void testInt() throws Exception {
        ReikaParser parser = Util.parserFromResource("int_only.reika");
        ParseTree tree = parser.prog();
        ReikaAstBuilder astBuilder = new ReikaAstBuilder();
        astBuilder.visit(tree);
        NaiveInterpreter interpreter = new NaiveInterpreter();
        interpreter.evalProgram(astBuilder.getStatements());
    }
}
