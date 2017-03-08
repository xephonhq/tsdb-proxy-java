package io.xephon.proxy.ql.ast;

/**
 * Created by at15 on 3/3/17.
 * <p>
 * Integer value
 */
public class IntegerLiteral extends IntegerExp {
    public final int value;

    public IntegerLiteral(int n) {
        value = n;
    }
}
