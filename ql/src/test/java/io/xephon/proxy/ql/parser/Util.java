package io.xephon.proxy.ql.parser;

import io.xephon.proxy.ql.checker.SymbolTable;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by at15 on 3/4/17.
 * <p>
 * Util functions to make life easier
 */
public class Util {
    public static ReikaParser parserFromResource(String fileName) throws IOException {
        // NOTE: getting class loader is different in static and non static methods
        // https://www.mkyong.com/java/java-getresourceasstream-in-static-method/
        // - non-static getClass().getClassLoader().getResourceAsStream("config.properties");
        // - static ClassName.class.getClassLoader().getResourceAsStream("config.properties");
        ClassLoader classLoader = Util.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream(fileName);
        ANTLRInputStream input = new ANTLRInputStream(is);
        ReikaLexer lexer = new ReikaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ReikaParser parser = new ReikaParser(tokens);
        is.close();
        return parser;
    }

    // FIXME: this builder actually also contains the result .... contains too much responsibility
    public static ReikaAstBuilder astBuilderFromResource(String fileName) throws IOException {
        ReikaParser parser = Util.parserFromResource(fileName);
        ParseTree tree = parser.prog();
        ReikaAstBuilder astBuilder = new ReikaAstBuilder();
        astBuilder.visit(tree);
        return astBuilder;
    }
}
