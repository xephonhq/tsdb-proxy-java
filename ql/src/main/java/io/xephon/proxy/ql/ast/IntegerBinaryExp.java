package io.xephon.proxy.ql.ast;

/**
 * Created by at15 on 3/5/17.
 *
 * @TODO: use IntegerExp instead of Exp?
 */
public class IntegerBinaryExp extends IntegerExp{
    public final BinaryOperator operator;
    public final Exp l;
    public final Exp r;

    public IntegerBinaryExp(BinaryOperator operator, Exp l, Exp r) {
        this.operator = operator;
        this.l = l;
        this.r = r;
    }
}
