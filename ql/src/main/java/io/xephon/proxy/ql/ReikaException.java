package io.xephon.proxy.ql;

/**
 * Created by at15 on 3/5/17.
 * <p>
 * Base class for exception that should be caught,
 * i.e. the AST builder should consider occurrence of invalid semantics
 */
public class ReikaException extends Exception {
    public ReikaException() {
        super();
    }

    public ReikaException(String s, Throwable t) {
        super(s, t);
    }

    public ReikaException(String s) {
        super(s);
    }

    public ReikaException(Throwable t) {
        super(t);
    }
}
