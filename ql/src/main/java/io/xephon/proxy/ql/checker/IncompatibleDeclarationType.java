package io.xephon.proxy.ql.checker;

import io.xephon.proxy.ql.ReikaException;
import io.xephon.proxy.ql.ast.DataType;

/**
 * Created by at15 on 3/7/17.
 */
public class IncompatibleDeclarationType extends ReikaException {
    private Symbol symbol;
    private DataType lhsType;
    private DataType rhsType;

    public IncompatibleDeclarationType(Symbol s, DataType l, DataType r) {
        super(String.format("%d:%d %s is declared as %s but assigned %s",
            s.line, s.column, s.id, l, r));
        symbol = s;
        lhsType = l;
        rhsType = r;
    }
}
