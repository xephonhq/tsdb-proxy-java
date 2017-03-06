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
            VarDeclareStat declareStat = (VarDeclareStat) stat;
            declareVar(declareStat.var.name, declareStat.exp);
        } else if (stat instanceof VarAssignStat) {
            System.out.println("It's assign ");
        } else if (stat instanceof ExpStat) {
            System.out.println("It's expr");
        } else {
            System.err.println("Unknown statement!");
        }
    }

    public void declareVar(String id, Exp exp) {
        if (exp instanceof IntegerExp) {
            integerVariables.put(id, evalExpression((IntegerExp) exp));
        }
    }

    public Integer resolveInt(String id) {
        // TODO: throw error if not found
        return integerVariables.get(id);
    }

    // TODO: may use interface for generic? or IntLiterial and IntExpression should derive from same class
    public Integer evalExpression(IntegerExp exp) {
        if (exp instanceof IntegerLiteral) {
            return ((IntegerLiteral) exp).value;
        } else if (exp instanceof IntegerBinaryExp) {
            IntegerBinaryExp bexp = (IntegerBinaryExp) exp;
            switch (bexp.operator) {
                case ADD:
                    // FIXME: for a correct program, the lhs and rhs is IntegerExp for sure
                    // and the IntegerBinaryExp class should not use Exp
                    // TODO: this can't handle when the lhs is variable
                    return evalExpression((IntegerExp) bexp.l) + evalExpression((IntegerExp) bexp.r);
                case MULT:
                    return evalExpression((IntegerExp) bexp.l) * evalExpression((IntegerExp) bexp.r);
                default:
                    System.err.printf("can't handler operator %s\n", bexp.operator);
            }
        }
        return 0;
    }
}
