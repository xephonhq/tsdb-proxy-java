package io.xephon.proxy.ql.ast;

/**
 * Created by at15 on 3/3/17.
 * <p>
 * String
 */
public class StringLiteral extends Exp {
    public String value;

    public StringLiteral(String s) {
        value = s;
    }
}
