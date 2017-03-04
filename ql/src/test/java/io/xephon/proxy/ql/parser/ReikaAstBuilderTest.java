package io.xephon.proxy.ql.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by at15 on 3/4/17.
 * <p>
 * Test AST Builder
 */
public class ReikaAstBuilderTest {
    @Test
    public void testGeneratedCode() throws IOException {
//        ANTLRInputStream input = new ANTLRInputStream("");
        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource("skeleton.reika").getFile());
//        Assert.assertTrue(file.exists());
        InputStream is = classLoader.getResourceAsStream("skeleton.reika");
        ANTLRInputStream input = new ANTLRInputStream(is);
        ReikaLexer lexer = new ReikaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ReikaParser parser = new ReikaParser(tokens);
        ParseTree t = parser.prog();
        System.out.println(t.toStringTree(parser));
//        byte[] arr = ByteStreams.toByteArray(is);
        // TODO: do I need to close the input stream?

    }
}
