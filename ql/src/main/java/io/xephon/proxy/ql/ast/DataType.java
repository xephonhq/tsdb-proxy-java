package io.xephon.proxy.ql.ast;

import io.xephon.proxy.ql.parser.ReikaParser;

/**
 * Created by at15 on 3/4/17.
 * <p>
 * Built in data types
 *
 * @TODO override toString to show lower case when println
 */
public enum DataType {
    INT, DOUBLE, BOOL, STRING, DATE, ANY_TYPE, UNDEFINED_TYPE;

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
            // NOTE: ANY_TYPE is just used for keep the pars moving on
            default:
                return UNDEFINED_TYPE;
        }
    }

    public static DataType type(ReikaParser.TypeContext ctx) {
        return type(ctx.getText());
    }

    public static DataType type(Exp exp) {
        if (exp instanceof VariableExp) {
            return ((VariableExp) exp).type;
        } else if (exp instanceof IntegerExp) {
            return INT;
        } else if (exp instanceof DoubleExp) {
            return DOUBLE;
        } else if (exp instanceof BoolExp) {
            return BOOL;
        } else if (exp instanceof StringExp) {
            return STRING;
        } else if (exp instanceof AnyExp) {
            return ANY_TYPE;
        } else {
            return UNDEFINED_TYPE;
        }
    }
}
