package io.xephon.proxy.ql.parser;

import io.xephon.proxy.common.Loggable;
import io.xephon.proxy.ql.ReikaException;
import io.xephon.proxy.ql.ReikaRuntimeException;
import io.xephon.proxy.ql.ast.*;
import io.xephon.proxy.ql.checker.*;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by at15 on 3/3/17.
 * <p>
 * Build AST
 *
 * @TODO: maybe we should use a wrapper class as return value Optional or StatOrNode etc.
 */
public class ReikaAstBuilder extends ReikaBaseVisitor<Node> implements Loggable {
    private SymbolTable symbolTable;
    private List<Stat> statements;
    private List<ReikaException> allExceptions;
    private List<ReikaException> symbolExceptions;
    private List<ReikaException> typeExceptions;

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public List<Stat> getStatements() throws ReikaException {
        if (hasError()) {
            throw new ReikaException(errorAbstract());
        }
        return statements;
    }

    // discard the error and get the statements
    public List<Stat> getStatementsAnyway() {
        return statements;
    }

    private void clearTables() {
        symbolTable = new SymbolTable();
        statements = new ArrayList<>();
        allExceptions = new ArrayList<>();
        symbolExceptions = new ArrayList<>();
        typeExceptions = new ArrayList<>();
    }

    public void recordError(ReikaException ex) {
        allExceptions.add(ex);
        if (ex instanceof DuplicateDeclarationException) {
            symbolExceptions.add(ex);
        } else if (ex instanceof UndefinedIdentifierException) {
            symbolExceptions.add(ex);
        } else if (ex instanceof IncompatibleDeclarationType) {
            typeExceptions.add(ex);
        } else if (ex instanceof IncompatibleAssignType) {
            typeExceptions.add(ex);
        } else if (ex instanceof IncompatibleBinaryType) {
            typeExceptions.add(ex);
        } else {
            throw new ReikaRuntimeException("un categorized exception", ex);
        }
    }

    public boolean hasError() {
        return allExceptions.size() > 0;
    }

    public String errorAbstract() {
        return String.format("%d symbol errors, %d type errors", symbolExceptions.size(), typeExceptions.size());
    }

    public void printErrors() {
        // TODO: maybe print error abstract here, or add a print error abstract method
        for (ReikaException ex : allExceptions) {
            System.out.println(ex.getMessage());
        }
    }

    // start of statements
    @Override
    public Node visitProg(ReikaParser.ProgContext ctx) {
        clearTables();

        logger().trace("visit program");
        // visit every statement, prog is the root
        List<ReikaParser.StatContext> statContexts = ctx.stat();
        for (ReikaParser.StatContext stat : statContexts) {
            statements.add((Stat) visit(stat));
        }
        logger().info("total statements in program: " + statements.size());
        // FIXME: returning null is never a good idea
        return null;
    }

    /**
     * There are two types of error when visit declaration statement
     * <p>
     * 1. Symbol, duplicate declaration
     * - recovery, over write the old one
     * 2. type, rhs has different type with the variable
     * - recovery, do nothing, just keep the type in lhs
     */
    @Override
    public Node visitVarDeclareStat(ReikaParser.VarDeclareStatContext ctx) {
        logger().trace("visit var declare statement");
        ReikaParser.VarDeclareContext declareContext = ctx.varDeclare();
        DataType varType = DataType.type(declareContext.type());
        Token varToken = declareContext.ID().getSymbol();
        Symbol varSymbol = new Symbol(varToken, varType);
        // check if it is already declared
        try {
            symbolTable.add(varSymbol);
        } catch (DuplicateDeclarationException ex) {
            recordError(ex);
            // recovery, the latest type replace the old one to reduce following errors
            logger().trace("recovery from duplicate declaration by replacing the old symbol with new ");
            symbolTable.replace(varSymbol);
        }
        VariableExp var = new VariableExp(varToken.getText(), varType);
        Exp rhs = (Exp) visit(declareContext.expr());
        // check type
        DataType rhsType = DataType.type(rhs);
        try {
            if (varType != rhsType) {
                throw new IncompatibleDeclarationType(varSymbol, varType, rhsType);
            }
        } catch (IncompatibleDeclarationType ex) {
            recordError(ex);
            // recovery: do nothing, the variable just use the type it is declared as
        }
        return new VarDeclareStat(var, rhs);
    }

    @Override
    public Node visitVarAssignStat(ReikaParser.VarAssignStatContext ctx) {
        logger().trace("visit var assign statement");
        ReikaParser.VarAssignContext assignContext = ctx.varAssign();
        Token varToken = assignContext.ID().getSymbol();
        DataType varType = DataType.UNDEFINED_TYPE;
        Symbol varUsageSymbol = new Symbol(varToken, varType);
        Symbol varDeclareSymbol = null;
        try {
            // the variable is declared before
            varDeclareSymbol = symbolTable.resolve(varToken);
            varType = varDeclareSymbol.type;
            varUsageSymbol.type = varType;
        } catch (UndefinedIdentifierException ex) {
            recordError(ex);
            // recover is in following
        }
        Exp rhs = (Exp) visit(assignContext.expr());
        DataType rhsType = DataType.type(rhs);
        // recover from undefined identifier, use type of rhs
        // TODO: this is actually type inference
        if (varDeclareSymbol == null) {
            // TODO: is using ANY_TYPE or NO_TYPE a better idea?
            logger().trace("recover from undefined id when assign by using type of rhs");
            varType = rhsType;
            varUsageSymbol.type = varType;
            try {
                logger().trace("recover from undefined id when assign II by adding symbol to table");
                symbolTable.add(varUsageSymbol);
            } catch (DuplicateDeclarationException ex) {
                throw new ReikaRuntimeException(
                    "should not happen unless there is concurrent access to symbol table", ex); // or I wrote the wrong code
            }
        } else {
            try {
                if (varUsageSymbol.type != rhsType) {
                    throw new IncompatibleAssignType(varUsageSymbol, varType, rhsType, varDeclareSymbol);
                }
            } catch (IncompatibleAssignType ex) {
                recordError(ex);
                // recovery: do nothing, the variable just use the type it is declared as
                // TODO: need to keep consistency for error recovery, but I am kind of lost now
            }
        }
        VariableExp var = new VariableExp(varToken.getText(), varType);
        return new VarAssignStat(var, rhs);
    }

    @Override
    public Node visitExprStat(ReikaParser.ExprStatContext ctx) {
        logger().trace("visit expr statement");
        // NOTE: itself don't need to resolve symbol, it the expression it need to do these
        // TODO: should we only allow call exp? though I think we should return 2 as the eval result when we have 1 + 1
        return new ExpStat((Exp) visit(ctx.expr()));
    }
    // end of statements

    // start of expressions
    // start of literal expressions
    @Override
    public Node visitInt(ReikaParser.IntContext ctx) {
        return new IntegerLiteral(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public Node visitString(ReikaParser.StringContext ctx) {
        String s = ctx.STRING().getText();
        // trim the quote mark
        // TODO: don't know if escape is proper handled
        return new StringLiteral(s.substring(1, s.length() - 1));
    }

    @Override
    public Node visitVariable(ReikaParser.VariableContext ctx) {
        DataType type;
        try {
            Symbol symbol = symbolTable.resolve(ctx.ID().getSymbol());
            type = symbol.type;
        } catch (UndefinedIdentifierException ex) {
            recordError(ex);
            // TODO: recover, it is called when expression contains variables, if I put it into symbol table, the undefined exception would
            // show up only once
            // NOTE: I think even if we don't recover, following visit can also moves on
            type = DataType.ANY_TYPE;
        }
        return new VariableExp(ctx.getText(), type);
    }
    // end of literal expressions

    @Override
    public Node visitCall(ReikaParser.CallContext ctx) {
        logger().trace("visit call expression");
        // TODO: check if the function is defined
        // TODo: type check
        String id = ctx.ID().getText();
        List<ReikaParser.ExprContext> argContexts = ctx.exprList().expr();
        List<Exp> args = new ArrayList<>();
        for (ReikaParser.ExprContext argContext : argContexts) {
            args.add((Exp) visit(argContext));
        }
        return new CallExp(id, args);
    }

    // start of binary operations
    @Override
    public Node visitAdd(ReikaParser.AddContext ctx) {
        // TODO: only integer is considered and IntegerBinaryExp may use IntegerExp as its type for lhs and rhs
        Exp lhs = (Exp) visit(ctx.expr(0));
        Exp rhs = (Exp) visit(ctx.expr(1));
        DataType lhsType = DataType.type(lhs);
        DataType rhsType = DataType.type(rhs);
        try {
            if (lhsType == DataType.INT && rhsType == DataType.INT) {
                return new IntegerBinaryExp(BinaryOperator.ADD, lhs, rhs);
            } else if (lhsType == DataType.STRING && rhsType == DataType.STRING) {
                return new StringBinaryExp(BinaryOperator.ADD, lhs, rhs);
            } else {
                // TODO: actually symbol is used for variable and functions,
                // maybe there should be another data type for tracking line number and column only
                Symbol symbol = new Symbol(ctx.getStart());
                throw new IncompatibleBinaryType(symbol, BinaryOperator.ADD, lhsType, rhsType);
            }
        } catch (IncompatibleBinaryType ex) {
            recordError(ex);
            // recovery, return ANY_TYPE
            // TODO: need to change the type check in previous declare and assign
            return new AnyExp();
        }
    }

    @Override
    public Node visitMinus(ReikaParser.MinusContext ctx) {
        return new IntegerBinaryExp(BinaryOperator.MINUS,
            (Exp) visit(ctx.expr(0)), (Exp) visit(ctx.expr(1)));
    }

    @Override
    public Node visitMult(ReikaParser.MultContext ctx) {
        return new IntegerBinaryExp(BinaryOperator.MULT,
            (Exp) visit(ctx.expr(0)), (Exp) visit(ctx.expr(1)));
    }

    @Override
    public Node visitDiv(ReikaParser.DivContext ctx) {
        return new IntegerBinaryExp(BinaryOperator.DIV,
            (Exp) visit(ctx.expr(0)), (Exp) visit(ctx.expr(1)));
    }
    // end of binary operations
    // end of expressions
}
