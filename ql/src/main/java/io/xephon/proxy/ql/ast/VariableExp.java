package io.xephon.proxy.ql.ast;

/**
 * Created by at15 on 3/3/17.
 *
 * @TODO data type, but is it necessary for variable exp to hold the type?
 */
public class VariableExp extends Exp {
    public String name;

    public VariableExp(String s) {
        name = s;
    }
}
