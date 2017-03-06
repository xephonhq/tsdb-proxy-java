package io.xephon.proxy.ql.ast;

/**
 * Created by at15 on 3/3/17.
 *
 * Since we don't have scope, the variable exp will only have one type that is determined when building the AST
 */
public class VariableExp extends Exp {
    public final String name;
    public final DataType type;

    public VariableExp(String s, DataType t) {
        name = s;
        type = t;
    }
}
