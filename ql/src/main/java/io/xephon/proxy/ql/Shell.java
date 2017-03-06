package io.xephon.proxy.ql;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

/**
 * Created by at15 on 3/5/17.
 * <p>
 * Shell using JLine
 * <p>
 * https://github.com/jline/jline3/blob/master/builtins/src/test/java/org/jline/example/Example.java
 *
 * @TODO: provide system command like help
 */
public class Shell {
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
            println("let me help you!");
            println("TODO: show available commands");
        } else if (cmd.equals("exit")) {
            throw new EndOfFileException();
        }
    }

    public void process(String line) {
        if (isCommand(line)) {
            processCommand(line);
        } else {
            println("need to evaluate!");
        }
    }

    public static void main(String[] args) throws Exception {
        Shell shell = new Shell();
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
