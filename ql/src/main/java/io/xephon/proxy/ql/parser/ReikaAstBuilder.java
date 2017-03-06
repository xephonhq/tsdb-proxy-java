package io.xephon.proxy.ql.parser;

import io.xephon.proxy.common.Loggable;
import io.xephon.proxy.ql.ReikaException;
import io.xephon.proxy.ql.ast.*;
import io.xephon.proxy.ql.checker.DuplicateDeclarationException;
import io.xephon.proxy.ql.checker.Symbol;
import io.xephon.proxy.ql.checker.SymbolTable;
import io.xephon.proxy.ql.checker.UndefinedIdentifierException;
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
    private List<ReikaException> symbolExceptions;
    private List<ReikaException> typeExceptions;

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    // TODO: may need to getStatementsSafe method to skip checking
    public List<Stat> getStatements() throws ReikaException {
        if (hasError()) {
            throw new ReikaException(errorAbstract());
        }
        return statements;
    }

    private void clearTables() {
        symbolTable = new SymbolTable();
        statements = new ArrayList<>();
        symbolExceptions = new ArrayList<>();
        typeExceptions = new ArrayList<>();
    }

    public boolean hasError() {
        return symbolExceptions.size() > 0 || typeExceptions.size() > 0;
    }

    public String errorAbstract() {
        return String.format("%d symbol errors, %d type errors", symbolExceptions.size(), typeExceptions.size());
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

    @Override
    public Node visitVarDeclareStat(ReikaParser.VarDeclareStatContext ctx) {
        logger().trace("visit var declare statement");
        ReikaParser.VarDeclareContext declareContext = ctx.varDeclare();
        DataType type = DataType.type(declareContext.type());
        Token id = declareContext.ID().getSymbol();
        try {
            symbolTable.add(type, id);
            // TODO: check the type of right hand side
        } catch (DuplicateDeclarationException ex) {
            // TODO: recovery, in this case, the type should be changed to the newest declaration
            symbolExceptions.add(ex);
            logger().error(ex.getMessage());
        }
        VariableExp var = new VariableExp(id.getText(), type);
        return new VarDeclareStat(var, (Exp) visit(declareContext.expr()));
    }

    @Override
    public Node visitVarAssignStat(ReikaParser.VarAssignStatContext ctx) {
        logger().trace("visit var assign statement");
        ReikaParser.VarAssignContext assignContext = ctx.varAssign();
        Token id = assignContext.ID().getSymbol();
        DataType type = DataType.UNDEFINED_TYPE;
        try {
            Symbol symbol = symbolTable.resolve(id);
            type = symbol.type;
            // TODO: check if the assign is type compatible
        } catch (UndefinedIdentifierException ex) {
            // TODO: how to recovery from it, a symbol as undefined into it?
            // or induct the type from rhs
            symbolExceptions.add(ex);
            logger().error(ex.getMessage());
        }
        VariableExp var = new VariableExp(id.getText(), type);
        return new VarAssignStat(var, (Exp) visit(assignContext.expr()));
    }

    @Override
    public Node visitExprStat(ReikaParser.ExprStatContext ctx) {
        logger().trace("visit expr statement");
        // NOTE: itself don't need to resolve symbol, it the expression it need to do these
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
        DataType type = DataType.UNDEFINED_TYPE;
        try {
            Symbol symbol = symbolTable.resolve(ctx.ID().getSymbol());
            type = symbol.type;
        } catch (UndefinedIdentifierException ex) {
            // TODO: it seems this can't not be recovered, visitVariable is only called by ExprStat
            symbolExceptions.add(ex);
            logger().error(ex.getMessage());
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
        return new IntegerBinaryExp(BinaryOperator.ADD,
            (Exp) visit(ctx.expr(0)), (Exp) visit(ctx.expr(1)));
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
