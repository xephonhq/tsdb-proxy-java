package io.xephon.proxy.ql.ast;

/**
 * Created by summer2016 on 3/8/17.
 * <p>
 * Double value
 */
public class DoubleLiteral extends DoubleExp {
    public double value;

    public DoubleLiteral(double n) {
        value = n;
    }
}
