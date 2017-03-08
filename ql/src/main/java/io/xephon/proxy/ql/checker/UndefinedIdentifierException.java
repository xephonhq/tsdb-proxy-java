package io.xephon.proxy.ql.checker;

import io.xephon.proxy.ql.ReikaException;

/**
 * Created by at15 on 3/4/17.
 *
 * @TODO distinguish variable and function
 */
public class UndefinedIdentifierException extends ReikaException {
    public final Symbol symbol;

    public UndefinedIdentifierException(Symbol symbol) {
        super(String.format("%d:%d %s is undefined", symbol.line, symbol.column, symbol.id));
        this.symbol = symbol;
    }
}
