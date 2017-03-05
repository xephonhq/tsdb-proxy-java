package io.xephon.proxy.ql.ast;

/**
 * Created by at15 on 3/4/17.
 */
public class ExpStat extends Stat {
    public final Exp exp;

    public ExpStat(Exp exp) {
        this.exp = exp;
    }
}
