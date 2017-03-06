package io.xephon.proxy.ql;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

/**
 * Created by at15 on 3/5/17.
 * <p>
 * Shell using JLine
 * <p>
 * https://github.com/jline/jline3/blob/master/builtins/src/test/java/org/jline/example/Example.java
 */
public class Shell {
    public static void main(String[] args) throws Exception {
        Terminal terminal = TerminalBuilder.builder()
            .build();
        LineReader reader = LineReaderBuilder.builder()
            .terminal(terminal)
            .build();
        String prompt = "> ";
        while (true) {
            String line = null;
            try {
                line = reader.readLine(prompt);
                System.out.println("I got u");
            } catch (UserInterruptException ex) {
                System.out.println("Please use CTRL + D");
            } catch (EndOfFileException ex) {
                System.out.println("bye~");
                return;
            }
        }
    }
}
