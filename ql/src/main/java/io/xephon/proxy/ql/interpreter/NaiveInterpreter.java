package io.xephon.proxy.ql.interpreter;

import io.xephon.proxy.ql.ast.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by at15 on 3/5/17.
 * <p>
 * NaiveInterpreter use is instanceof instead of visitor pattern
 */
public class NaiveInterpreter {
    private Map<String, Integer> integerVariables;

    public NaiveInterpreter() {
        integerVariables = new HashMap<>();
    }

    public void evalProgram(List<Stat> statements) {
        for (Stat stat : statements) {
            evalStatement(stat);
        }
    }

    public void evalStatement(Stat stat) {
        if (stat instanceof VarDeclareStat) {
            System.out.println("It's declare");
        } else if (stat instanceof VarAssignStat) {
            System.out.println("It's assign ");
        } else if (stat instanceof ExpStat) {
            System.out.println("It's expr");
        } else {
            System.err.println("Unknown statement!");
        }
    }

    // TODO: may use interface for generic? or IntLiterial and IntExpression should derive from same class
    public Integer evalExpression(IntegerExp exp) {
        return 0;
    }
}
