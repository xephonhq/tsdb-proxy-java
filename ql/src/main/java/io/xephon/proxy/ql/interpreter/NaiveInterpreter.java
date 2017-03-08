package io.xephon.proxy.ql.interpreter;

import io.xephon.proxy.common.Loggable;
import io.xephon.proxy.ql.ReikaRuntimeException;
import io.xephon.proxy.ql.ast.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by at15 on 3/5/17.
 * <p>
 * NaiveInterpreter use is instanceof instead of visitor pattern
 */
public class NaiveInterpreter implements Loggable {
    private Map<String, Integer> integerVariables;
    private Map<String, String> stringVariables;

    public NaiveInterpreter() {
        integerVariables = new HashMap<>();
        stringVariables = new HashMap<>();
    }

    public void evalProgram(List<Stat> statements) {
        logger().info("start eval a program");
        for (Stat stat : statements) {
            evalStatement(stat);
        }
        logger().info("finish eval a program");
    }

    public void evalStatement(Stat stat) {
        if (stat instanceof VarDeclareStat) {
            logger().trace("eval declare statement");
            VarDeclareStat declareStat = (VarDeclareStat) stat;
            declareVar(declareStat.var.name, declareStat.exp);
        } else if (stat instanceof VarAssignStat) {
            logger().trace("eval assign statement");
            VarAssignStat assignStat = (VarAssignStat) stat;
            assignVar(assignStat.var.name, assignStat.exp);
        } else if (stat instanceof ExpStat) {
            logger().trace("eval expression statement");
        } else {
            throw new ReikaRuntimeException("Unknown type of statement");
        }
    }

    public void declareVar(String id, Exp exp) {
        if (exp instanceof IntegerExp) {
            integerVariables.put(id, evalExpression((IntegerExp) exp));
        } else if (exp instanceof StringExp) {
            stringVariables.put(id, evalExpression((StringExp) exp));
        }
    }

    public void assignVar(String id, Exp exp) {
        if (exp instanceof IntegerExp) {
            integerVariables.put(id, evalExpression((IntegerExp) exp));
        } else if (exp instanceof StringExp) {
            stringVariables.put(id, evalExpression((StringExp) exp));
        }
    }

    public Integer resolveInt(String id) {
        if (!integerVariables.containsKey(id)) {
            throw new ReikaRuntimeException(String.format("int variable %s not found", id));
        }
        return integerVariables.get(id);
    }

    public String resolveString(String id) {
        if (!stringVariables.containsKey(id)) {
            throw new ReikaRuntimeException(String.format("string variable %s not found", id));
        }
        return stringVariables.get(id);
    }

    public String evalExpression(StringExp exp) {
        if (exp instanceof StringLiteral) {
            return ((StringLiteral) exp).value;
        } else if (exp instanceof StringBinaryExp) {
            // sbexp stands for string binary expression -.-
            StringBinaryExp sbexp = (StringBinaryExp) exp;
            if (sbexp.operator != BinaryOperator.ADD) {
                throw new ReikaRuntimeException(String.format("string only support add but found %s", sbexp.operator));
            }
            String l, r;
            if (sbexp.l instanceof VariableExp) {
                l = resolveString(((VariableExp) sbexp.l).name);
            } else {
                l = evalExpression((StringExp) sbexp.l);
            }
            if (sbexp.r instanceof VariableExp) {
                r = resolveString(((VariableExp) sbexp.r).name);
            } else {
                r = evalExpression((StringExp) sbexp.r);
            }
            // we only have add
            return l + r;
        }
        throw new ReikaRuntimeException("Unknown type of string expression");
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
                    // TODO: handle divide by zero exception
                    return l / r;
                default:
                    throw new ReikaRuntimeException(String.format("Operator %s is not supported for integer expression", bexp.operator));
            }
        }
        // TODO: toString of the expression?
        throw new ReikaRuntimeException("Unknown type of integer expression");
    }
}
