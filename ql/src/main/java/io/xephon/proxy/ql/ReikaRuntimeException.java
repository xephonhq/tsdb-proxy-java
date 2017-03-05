package io.xephon.proxy.ql;

/**
 * Created by at15 on 3/4/17.
 * <p>
 * Base Exception class that can be used in visitor because they are unchecked
 *
 * @TODO the constructors are copied from voldemort, not sure why need so many constructors
 * https://github.com/voldemort/voldemort/blob/master/src/java/voldemort/VoldemortException.java
 */
public class ReikaRuntimeException extends RuntimeException {
    public ReikaRuntimeException() {
        super();
    }

    public ReikaRuntimeException(String s, Throwable t) {
        super(s, t);
    }

    public ReikaRuntimeException(String s) {
        super(s);
    }

    public ReikaRuntimeException(Throwable t) {
        super(t);
    }
}
