package io.xephon.proxy.ql.checker;

import io.xephon.proxy.ql.ast.DataType;
import org.antlr.v4.runtime.Token;

/**
 * Created by at15 on 3/5/17.
 */
public class Symbol {
    public final String id;
    public final Integer line;
    public final Integer column;
    // TODO: what about function? just ignore it by now ...
    public DataType type;

    public Symbol(Token token) {
        this.id = token.getText();
        line = token.getLine();
        // TODO: do we need + 1? since in a lot of editors column and line all starts from 1
        // in ANTLR line starts from 1, but char index start from 0
        column = token.getCharPositionInLine();
        type = DataType.UNDEFINED_TYPE;
    }

    public Symbol(Token token, DataType type) {
        this(token);
        this.type = type;
    }
}
