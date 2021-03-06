package io.xephon.proxy.ql.interpreter;

import io.xephon.proxy.common.Loggable;
import io.xephon.proxy.ql.ReikaRuntimeException;
import io.xephon.proxy.ql.ast.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by at15 on 3/5/17.
 * <p>
 * NaiveInterpreter use is instanceof instead of visitor pattern
 */
public class NaiveInterpreter implements Loggable {
    private Map<String, Integer> integerVariables;
    private Map<String, String> stringVariables;
    private Map<String, Double> doubleVariables;
    private Map<String, Boolean> boolVariables;
    private Object lastOutput;

    public NaiveInterpreter() {
        integerVariables = new HashMap<>();
        stringVariables = new HashMap<>();
        doubleVariables = new HashMap<>();
        boolVariables = new HashMap<>();
    }

    public Object getLastOutput() {
        return lastOutput;
    }

    public void evalProgram(List<Stat> statements) {
        logger().debug("start eval a program");
        for (Stat stat : statements) {
            evalStatement(stat);
        }
        logger().debug("finish eval a program");
    }

    public void evalStatement(Stat stat) {
        if (stat instanceof VarDeclareStat) {
            logger().trace("eval declare statement");
            VarDeclareStat declareStat = (VarDeclareStat) stat;
            setVar(declareStat.var.name, declareStat.exp);
        } else if (stat instanceof VarAssignStat) {
            logger().trace("eval assign statement");
            VarAssignStat assignStat = (VarAssignStat) stat;
            setVar(assignStat.var.name, assignStat.exp);
        } else if (stat instanceof ExpStat) {
            logger().trace("eval expression statement");
            lastOutput = evalExpression(((ExpStat) stat).exp);
        } else {
            throw new ReikaRuntimeException("Unknown type of statement");
        }
    }

    // setVar is assignVar and declareVar, they are same code pointed out by IDEA
    // since the checker already checked symbol problems,
    // the interpreter treat assign and declare with no difference
    public void setVar(String id, Exp exp) {
        if (exp instanceof IntegerExp) {
            integerVariables.put(id, evalExpression((IntegerExp) exp));
            lastOutput = integerVariables.get(id);
        } else if (exp instanceof DoubleExp) {
            doubleVariables.put(id, evalExpression((DoubleExp) exp));
            lastOutput = doubleVariables.get(id);
        } else if (exp instanceof StringExp) {
            stringVariables.put(id, evalExpression((StringExp) exp));
            lastOutput = stringVariables.get(id);
        } else if (exp instanceof BoolExp) {
            boolVariables.put(id, evalExpression((BoolExp) exp));
            lastOutput = boolVariables.get(id);
        }
    }

    public Integer resolveInt(String id) {
        if (!integerVariables.containsKey(id)) {
            throw new ReikaRuntimeException(String.format("int variable %s not found", id));
        }
        return integerVariables.get(id);
    }

    public Double resolveDouble(String id) {
        if (!doubleVariables.containsKey(id)) {
            throw new ReikaRuntimeException(String.format("double variable %s not found", id));
        }
        return doubleVariables.get(id);
    }

    public String resolveString(String id) {
        if (!stringVariables.containsKey(id)) {
            throw new ReikaRuntimeException(String.format("string variable %s not found", id));
        }
        return stringVariables.get(id);
    }

    public Boolean resolveBool(String id) {
        if (!boolVariables.containsKey(id)) {
            throw new ReikaRuntimeException(String.format("boolean variable %s not found", id));
        }
        return boolVariables.get(id);
    }

    public Object evalExpression(Exp exp) {
        if (exp instanceof VariableExp) {
            return evalExpression((VariableExp) exp);
        } else if (exp instanceof IntegerExp) {
            return evalExpression((IntegerExp) exp);
        } else if (exp instanceof DoubleExp) {
            return evalExpression((DoubleExp) exp);
        } else if (exp instanceof StringExp) {
            return evalExpression((StringExp) exp);
        } else if (exp instanceof BoolExp) {
            return evalExpression((BoolExp) exp);
        } else if (exp instanceof CallExp) {
            // TODO: implement evaluation of call exp
            return null;
        }
        throw new ReikaRuntimeException(String.format("Unknown type of expression %s", exp.getClass().getSimpleName()));
    }

    public Object evalExpression(VariableExp exp) {
        if (exp.type == DataType.INT) {
            return resolveInt(exp.name);
        } else if (exp.type == DataType.STRING) {
            return resolveString(exp.name);
        } else if (exp.type == DataType.DOUBLE) {
            return resolveDouble(exp.name);
        } else if (exp.type == DataType.BOOL) {
            return resolveBool(exp.name);
        }
        throw new ReikaRuntimeException("Unknown type of variable expression");
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

    public Double evalExpression(DoubleExp exp) {
        if (exp instanceof DoubleLiteral) {
            return ((DoubleLiteral) exp).value;
        } else if (exp instanceof DoubleBinaryExp) {
            DoubleBinaryExp bexp = (DoubleBinaryExp) exp;
            Double l, r;
            if (bexp.l instanceof VariableExp) {
                l = resolveDouble(((VariableExp) bexp.l).name);
            } else {
                l = evalExpression((DoubleExp) bexp.l);
            }
            if (bexp.r instanceof VariableExp) {
                r = resolveDouble(((VariableExp) bexp.r).name);
            } else {
                r = evalExpression((DoubleExp) bexp.r);
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
                    throw new ReikaRuntimeException(String.format("Operator %s is not supported for double expression", bexp.operator));
            }
        }
        // TODO: toString of the expression?
        throw new ReikaRuntimeException("Unknown type of double expression");
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

    public Boolean evalExpression(BoolExp exp) {
        if (exp instanceof BoolLiteral) {
            return ((BoolLiteral) exp).bool;
        } else if (exp instanceof BoolBinaryExp) {
            BoolBinaryExp bexp = (BoolBinaryExp) exp;
            Boolean l, r;
            if (bexp.l instanceof VariableExp) {
                l = resolveBool(((VariableExp) bexp.l).name);
            } else {
                l = evalExpression((BoolExp) bexp.l);
            }
            if (bexp.r instanceof VariableExp) {
                r = resolveBool(((VariableExp) bexp.r).name);
            } else {
                r = evalExpression((BoolExp) bexp.r);
            }
            switch (bexp.operator) {
                case AND:
                    return l && r;
                case OR:
                    return l || r;
                default:
                    throw new ReikaRuntimeException(String.format("Operator %s is not supported for boolean expression", bexp.operator));
            }
        }
        // TODO: toString of the expression?
        throw new ReikaRuntimeException("Unknown type of boolean expression");
    }

}
