package io.xephon.proxy.ql.parser;

/**
 * Created by at15 on 3/9/17.
 */
public class SyntaxError {
    public final int line;
    public final int charPos;
    public final String msg;

    public SyntaxError(int line, int charPos, String msg) {
        this.line = line;
        this.charPos = charPos;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return String.format("line %d:%d %s", line, charPos, msg);
    }
}
