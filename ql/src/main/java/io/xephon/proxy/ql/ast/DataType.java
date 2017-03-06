package io.xephon.proxy.ql.ast;

import io.xephon.proxy.ql.parser.ReikaParser;

/**
 * Created by at15 on 3/4/17.
 * <p>
 * Built in data types
 * @TODO override toString to show lower case when println
 */
public enum DataType {
    INT, DOUBLE, BOOL, STRING, DATE, NO_TYPE, UNDEFINED_TYPE;

    public static DataType type(String t) {
        switch (t) {
            case "int":
                return INT;
            case "double":
                return DOUBLE;
            case "bool":
                return BOOL;
            case "string":
                return STRING;
            default:
                return UNDEFINED_TYPE;
        }
    }

    public static DataType type(ReikaParser.TypeContext ctx) {
        return type(ctx.getText());
    }
}
