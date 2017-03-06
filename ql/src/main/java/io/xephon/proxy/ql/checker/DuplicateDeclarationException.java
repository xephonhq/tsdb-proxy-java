package io.xephon.proxy.ql.checker;

import io.xephon.proxy.ql.ReikaException;

/**
 * Created by at15 on 3/5/17.
 */
public class DuplicateDeclarationException extends ReikaException {
    public final Symbol previous;
    public final Symbol current;

    public DuplicateDeclarationException(Symbol previous, Symbol current) {
        super(String.format("%s declared again on %d,%d, previously on %d, %d",
            current.id, current.line, current.column, previous.line, previous.column));
        this.previous = previous;
        this.current = current;
    }
}
