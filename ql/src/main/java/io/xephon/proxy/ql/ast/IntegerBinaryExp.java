package io.xephon.proxy.ql.ast;

/**
 * Created by at15 on 3/5/17.
 */
public class IntegerBinaryExp extends BinaryExp {
    public final Operator operator;
    public final Exp l;
    public final Exp r;

    public IntegerBinaryExp(Operator operator, Exp l, Exp r) {
        this.operator = operator;
        this.l = l;
        this.r = r;
    }
}
