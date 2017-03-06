package io.xephon.proxy.ql.parser;

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
public class ReikaAstBuilder extends ReikaBaseVisitor<Node> {
    private SymbolTable symbolTable;
    private List<Stat> statements;

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public List<Stat> getStatements() {
        return statements;
    }

    // start of statements
    @Override
    public Node visitProg(ReikaParser.ProgContext ctx) {
        symbolTable = new SymbolTable();
        statements = new ArrayList<>();

        System.out.println("visit program!");
        // visit every statement, prog is the root
        List<ReikaParser.StatContext> statContexts = ctx.stat();
        for (ReikaParser.StatContext stat : statContexts) {
            statements.add((Stat) visit(stat));
        }
        System.out.println("total statements: " + statements.size());
        // FIXME: returning null is never a good idea
        return null;
    }

    @Override
    public Node visitVarDeclareStat(ReikaParser.VarDeclareStatContext ctx) {
        System.out.println("visit var declare statement");
        ReikaParser.VarDeclareContext declareContext = ctx.varDeclare();
        DataType type = DataType.type(declareContext.type());
        Token id = declareContext.ID().getSymbol();
        try {
            symbolTable.add(type, id);
        } catch (DuplicateDeclarationException ex) {
            // TODO: do sth, record the exception and recovery from it
            // in this case, the type should be changed to the newest declaration
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        VariableExp var = new VariableExp(id.getText(), type);
        return new VarDeclareStat(var, (Exp) visit(declareContext.expr()));
    }

    @Override
    public Node visitVarAssignStat(ReikaParser.VarAssignStatContext ctx) {
        System.out.println("visit var assign statement");
        ReikaParser.VarAssignContext assignContext = ctx.varAssign();
        Token id = assignContext.ID().getSymbol();
        DataType type = DataType.UNDEFINED_TYPE;
        try {
            Symbol symbol = symbolTable.resolve(id);
            type = symbol.type;
            // TODO: check if the assign is type compatible
        } catch (UndefinedIdentifierException ex) {
            // TODO: do sth, and how to recovery from it
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        VariableExp var = new VariableExp(id.getText(), type);
        return new VarAssignStat(var, (Exp) visit(assignContext.expr()));
    }

    @Override
    public Node visitExprStat(ReikaParser.ExprStatContext ctx) {
        System.out.println("visit expr statement");
        // NOTE: itself don't need to resolve symbol, it the expression it need to do these
        return new ExpStat((Exp) visit(ctx.expr()));
    }
    // end of statements

    // start of expressions
    // start of literal expressions
    @Override
    public Node visitInt(ReikaParser.IntContext ctx) {
        return new IntegerExp(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public Node visitString(ReikaParser.StringContext ctx) {
        String s = ctx.STRING().getText();
        // trim the quote mark
        // TODO: don't know if escape is proper handled
        return new StringExp(s.substring(1, s.length() - 1));
    }

    @Override
    public Node visitVariable(ReikaParser.VariableContext ctx) {
        System.out.println("variable text is " + ctx.getText());
        DataType type = DataType.UNDEFINED_TYPE;
        try {
            Symbol symbol = symbolTable.resolve(ctx.ID().getSymbol());
            type = symbol.type;
        } catch (UndefinedIdentifierException ex) {
            // TODO: handle it
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return new VariableExp(ctx.getText(), type);
    }
    // end of literal expressions

    @Override
    public Node visitCall(ReikaParser.CallContext ctx) {
        System.out.println("visit call expression");
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
        return new IntegerBinaryExp(BinaryExp.Operator.ADD,
            (Exp) visit(ctx.expr(0)), (Exp) visit(ctx.expr(1)));
    }

    @Override
    public Node visitMinus(ReikaParser.MinusContext ctx) {
        return new IntegerBinaryExp(BinaryExp.Operator.MINUS,
            (Exp) visit(ctx.expr(0)), (Exp) visit(ctx.expr(1)));
    }

    @Override
    public Node visitMult(ReikaParser.MultContext ctx) {
        return new IntegerBinaryExp(BinaryExp.Operator.MULT,
            (Exp) visit(ctx.expr(0)), (Exp) visit(ctx.expr(1)));
    }

    @Override
    public Node visitDiv(ReikaParser.DivContext ctx) {
        return new IntegerBinaryExp(BinaryExp.Operator.DIV,
            (Exp) visit(ctx.expr(0)), (Exp) visit(ctx.expr(1)));
    }
    // end of binary operations
    // end of expressions
}
