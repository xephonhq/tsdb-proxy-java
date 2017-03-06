package io.xephon.proxy.ql.ast;

/**
 * Created by at15 on 3/3/17.
 *
 * @TODO: make it abstract and have MultiplyExp, AddExp or just use it
 */
public abstract class BinaryExp extends Exp {
    public enum Operator {
        ADD, MINUS, MULT, DIV
    }
}
