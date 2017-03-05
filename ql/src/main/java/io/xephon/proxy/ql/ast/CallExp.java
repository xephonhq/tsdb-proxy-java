package io.xephon.proxy.ql.ast;

import java.util.List;

/**
 * Created by at15 on 3/3/17.
 */
public class CallExp extends Exp {
    public final String name;
    public final List<Exp> arguments;

    public CallExp(String n, List<Exp> args) {
        name = n;
        arguments = args;
    }
}
