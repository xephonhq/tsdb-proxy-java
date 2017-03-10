package io.xephon.proxy.ql;

import io.xephon.proxy.ql.interpreter.NaiveInterpreter;
import io.xephon.proxy.ql.parser.ReikaAstBuilder;
import io.xephon.proxy.ql.parser.ReikaLexer;
import io.xephon.proxy.ql.parser.ReikaParser;
import io.xephon.proxy.ql.parser.TrackerErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by at15 on 3/5/17.
 * <p>
 * Shell using JLine
 * <p>
 * https://github.com/jline/jline3/blob/master/builtins/src/test/java/org/jline/example/Example.java
 *
 * @TODO: implement system command like help
 */
public class Shell {
    // TODO: should get the version from build file
    private static final String version = "0.0.1";
    private static final Logger logger = LogManager.getLogger(Shell.class);
    private final NaiveInterpreter interpreter;
    private ReikaAstBuilder astBuilder;
    private final String commandPrefix;
    private LineReader reader;
    private String prompt;


    public Shell() throws IOException {
        commandPrefix = ":";
        prompt = "> ";
        Terminal terminal = TerminalBuilder.builder()
            .build();
        reader = LineReaderBuilder.builder()
            .terminal(terminal)
            .build();
        logger.trace("create interpreter");
        interpreter = new NaiveInterpreter();
        // need to have a global ast builder, otherwise the symbol table is lost
        logger.trace("create ast builder");
        astBuilder = new ReikaAstBuilder(false);
    }

    public String readLine() {
        return reader.readLine(prompt);
    }

    public boolean isCommand(String cmd) {
        return cmd.startsWith(commandPrefix);
    }

    public void processCommand(String rawCmd) {
        String cmd = rawCmd.substring(1).trim();
        if (cmd.startsWith("help")) {
            // TODO: real help
            println("let me help you!");
            println("TODO: show available commands");
        } else if (cmd.equals("exit")) {
            throw new EndOfFileException();
        }
    }

    public void evalExpression(String expression) {
        // TODO: maybe there is a way to reuse lexer ?
        ANTLRInputStream input = new ANTLRInputStream(expression);
        ReikaLexer lexer = new ReikaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ReikaParser parser = new ReikaParser(tokens);
        parser.removeErrorListeners();
        TrackerErrorListener tracker = new TrackerErrorListener();
        parser.addErrorListener(tracker);
        ParseTree tree = parser.prog();
        if (tracker.hasError()) {
            // TODO: better format
            // TODO: how to create more than one syntax error, I only know don't adding `;` for now
            tracker.printErrors();
            return;
        }

        astBuilder.clearButSymbol();
        astBuilder.visit(tree);
        // FIXME: need to use updated symbol table !!!
        // i.e. astBuilder should share symbol table
        if (astBuilder.hasError()) {
            astBuilder.printErrors();
            return;
        }

        // now let's do the evaluation
        try {
            interpreter.evalProgram(astBuilder.getStatements());
            System.out.println(interpreter.getLastOutput());
        } catch (ReikaException ex) {
            logger.error(ex);
        }

    }

    public void process(String line) {
        if (isCommand(line)) {
            processCommand(line);
        } else {
            evalExpression(line);
        }
    }

    public static void main(String[] args) throws Exception {
        logger.trace("create shell object");
        Shell shell = new Shell();
        System.out.printf("Reika shell, version %s: https://github.com/xephonhq/tsdb-proxy-java \n", version);
        while (true) {
            String line = null;
            try {
                line = shell.readLine();
                shell.process(line);
            } catch (UserInterruptException ex) {
                // TODO: mac user need to use command + D
                System.out.println("Please use CTRL + D");
            } catch (EndOfFileException ex) {
                System.out.println("bye~");
                return;
            }
        }
    }

    private static void println(String s) {
        System.out.println(s);
    }

}
