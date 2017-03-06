package io.xephon.proxy.ql.ast;

/**
 * Created by at15 on 3/6/17.
 *
 * @TODO: string only support +, should throw exception when other operator is used
 */
public class StringBinaryExp extends StringExp {
    public final BinaryOperator operator;
    public final Exp l;
    public final Exp r;

    public StringBinaryExp(BinaryOperator operator, Exp l, Exp r) {
        this.operator = operator;
        this.l = l;
        this.r = r;
    }
}
