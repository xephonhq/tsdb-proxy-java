package io.xephon.proxy.ql.ast;

/**
 * Created by at15 on 3/3/17.
 * <p>
 * Variable declaration statement
 */
public class VarDeclareStat extends Stat {
    public final VariableExp var;
    public final Exp exp;

    public VarDeclareStat(VariableExp var, Exp exp) {
        this.var = var;
        this.exp = exp;
    }
}
