package io.xephon.proxy.ql.ast;

/**
 * Created by summer2016 on 3/8/17.
 */
public class BoolBinaryExp extends BoolExp {
    public final BinaryOperator operator;
    public final Exp l;
    public final Exp r;

    public BoolBinaryExp(BinaryOperator operator, Exp l, Exp r) {
        this.operator = operator;
        this.l = l;
        this.r = r;
    }
}
