package io.xephon.proxy.ql.ast;

/**
 * Created by at15 on 3/3/17.
 * <p>
 * Integer value
 */
public class IntegerExp extends Exp {
    public int value;

    public IntegerExp(int n) {
        value = n;
    }
}
