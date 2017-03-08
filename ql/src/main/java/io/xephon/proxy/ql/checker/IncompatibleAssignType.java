package io.xephon.proxy.ql.checker;

import io.xephon.proxy.ql.ReikaException;
import io.xephon.proxy.ql.ast.DataType;

/**
 * Created by at15 on 3/7/17.
 */
public class IncompatibleAssignType extends ReikaException {
    private Symbol declareSymbol;
    private Symbol usageSymbol;
    private DataType lhsType;
    private DataType rhsType;

    public IncompatibleAssignType(Symbol usage, DataType l, DataType r, Symbol decl) {
        super(String.format("%d:%d %s is %s but assigned %s, declared in %d:%d",
            usage.line, usage.column, usage.id, l, r, decl.line, decl.column));
        declareSymbol = decl;
        usageSymbol = usage;
        lhsType = l;
        rhsType = r;
    }
}
