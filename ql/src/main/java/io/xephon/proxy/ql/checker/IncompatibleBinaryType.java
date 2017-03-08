package io.xephon.proxy.ql.checker;

import io.xephon.proxy.ql.ReikaException;
import io.xephon.proxy.ql.ast.BinaryOperator;
import io.xephon.proxy.ql.ast.DataType;

/**
 * Created by at15 on 3/8/17.
 */
public class IncompatibleBinaryType extends ReikaException {
    private Symbol symbol;
    private BinaryOperator operator;
    private DataType lhsType;
    private DataType rhsType;

    public IncompatibleBinaryType(Symbol s, BinaryOperator op, DataType l, DataType r) {
        symbol = s;
        operator = op;
        lhsType = l;
        rhsType = r;
    }
}
