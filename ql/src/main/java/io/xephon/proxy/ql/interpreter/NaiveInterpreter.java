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
            VarAssignStat assignStat = (VarAssignStat) stat;
            assignVar(assignStat.var.name, assignStat.exp);
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

    public void assignVar(String id, Exp exp) {
        if (exp instanceof IntegerExp) {
            integerVariables.put(id, evalExpression((IntegerExp) exp));
        }
    }

    public Integer resolveInt(String id) {
        // TODO: throw error if not found
        return integerVariables.get(id);
    }

    public String evalExpression(StringLiteral exp) {
        return exp.value;
    }

    public Object evalExpression(VariableExp exp) {
        if (exp.type == DataType.INT) {
            return resolveInt(exp.name);
        }
        return null;
    }

    public Integer evalExpression(IntegerExp exp) {
        if (exp instanceof IntegerLiteral) {
            return ((IntegerLiteral) exp).value;
        } else if (exp instanceof IntegerBinaryExp) {
            IntegerBinaryExp bexp = (IntegerBinaryExp) exp;
            Integer l, r;
            if (bexp.l instanceof VariableExp) {
                l = resolveInt(((VariableExp) bexp.l).name);
            } else {
                l = evalExpression((IntegerExp) bexp.l);
            }
            if (bexp.r instanceof VariableExp) {
                r = resolveInt(((VariableExp) bexp.r).name);
            } else {
                r = evalExpression((IntegerExp) bexp.r);
            }
            switch (bexp.operator) {
                case ADD:
                    return l + r;
                case MINUS:
                    return l - r;
                case MULT:
                    return l * r;
                case DIV:
                    // TODO: handle exception
                    return l / r;
                default:
                    System.err.printf("can't handler operator %s\n", bexp.operator);
            }
        }
        // TODO: should throw exception
        System.err.printf("unsupported integer expression");
        return 0;
    }
}
