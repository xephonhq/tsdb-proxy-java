package io.xephon.proxy.ql.ast;

import io.xephon.proxy.ql.parser.ReikaParser;

/**
 * Created by at15 on 3/4/17.
 * <p>
 * Built in data types
 */
public enum DataType {
    INT, BOOL, STRING, Date, NO_TYPE, UNDEFINED_TYPE;

    public static DataType type(String t) {
        switch (t) {
            case "int":
                return INT;
            default:
                return UNDEFINED_TYPE;
        }
    }

    public static DataType type(ReikaParser.TypeContext ctx) {
        return type(ctx.getText());
    }
}
