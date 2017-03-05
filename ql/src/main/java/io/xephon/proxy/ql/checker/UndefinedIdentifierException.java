package io.xephon.proxy.ql.checker;

import io.xephon.proxy.ql.ReikaException;

/**
 * Created by at15 on 3/4/17.
 *
 * @TODO distinguish variable and function
 */
public class UndefinedIdentifierException extends ReikaException {
    public String id;
    public Integer line;
    public Integer column;

    public UndefinedIdentifierException(String id, Integer line, Integer column) {
        super(String.format("%s on %d,%d is undefined", id, line, column));
        this.id = id;
        this.line = line;
        this.column = column;
    }
}
