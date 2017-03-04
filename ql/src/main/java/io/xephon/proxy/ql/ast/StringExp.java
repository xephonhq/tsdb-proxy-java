package io.xephon.proxy.ql.ast;

/**
 * Created by at15 on 3/3/17.
 * <p>
 * String
 */
public class StringExp extends Exp {
    public String value;

    public StringExp(String s) {
        value = s;
    }
}
