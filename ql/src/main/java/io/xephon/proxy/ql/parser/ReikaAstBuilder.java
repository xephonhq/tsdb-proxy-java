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
 * @TODO: should use Node instead of Void, but Prog has can have a list of statement
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
        // TODO: maybe we should use optional or StatOrNode, things like that
        return null;
    }

    @Override
    public Node visitVarDeclareStat(ReikaParser.VarDeclareStatContext ctx) {
        System.out.println("visit var declare statement");
        System.out.println(ctx.varDeclare().type().getText());
        System.out.println(ctx.varDeclare().ID().getText());
        System.out.println(ctx.varDeclare().expr().getText());
        System.out.println("line:" + ctx.varDeclare().getStart().getLine());
        ReikaParser.VarDeclareContext declareContext = ctx.varDeclare();
        DataType type = DataType.type(declareContext.type());
        Token id = declareContext.ID().getSymbol();
        try {
            symbolTable.add(type, id);
        } catch (DuplicateDeclarationException ex) {
            // TODO: do sth, record the exception and recovery from it
        }
        // TODO: exception in the rhs
        return new VarDeclareStat(new VariableExp(id.getText()), (Exp) visit(declareContext.expr()));
    }

    @Override
    public Node visitVarAssignStat(ReikaParser.VarAssignStatContext ctx) {
        System.out.println("visit var assign statement");
        ReikaParser.VarAssignContext assignContext = ctx.varAssign();
        Token id = assignContext.ID().getSymbol();
        try {
            Symbol symbol = symbolTable.resolve(id);
            // TODO: check if the assign is type compatible
        } catch (UndefinedIdentifierException ex) {
            // TODO: do sth, and how to recovery from it
        }
        // TODO: what about the exceptions in the rhs
        return new VarAssignStat(new VariableExp(id.getText()), (Exp) visit(assignContext.expr()));
    }

    @Override
    public Node visitExprStat(ReikaParser.ExprStatContext ctx) {
        System.out.println("visit expr statement");
        System.out.println(ctx.expr().getText());
        // NOTE: itself don't need to resolve symbol, it the expression it need to do these
        return visitChildren(ctx);
    }

    // start of expressions
    @Override
    public Node visitInt(ReikaParser.IntContext ctx) {
        return new IntegerExp(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public Node visitString(ReikaParser.StringContext ctx) {
        // TODO: will this include the quote mark?
        System.out.println("have quote mark? " + ctx.STRING().getText());
        String s = ctx.STRING().getText();
        System.out.println("trim quote mark? " + s.substring(1, s.length() - 1));
        System.out.println(ctx.getStart().getCharPositionInLine());
        System.out.println(ctx.getStart().getStartIndex()); // NOTE: this is not the column we want
        // TODO: trim the quote mark
        return new StringExp(ctx.STRING().getText());
    }

    @Override
    public Node visitVariable(ReikaParser.VariableContext ctx) {
        // FIXME: visitVariable can't know its data type
        // for var declare stmt, it can know it
        // for var assign stmt, need to lookup symbol table
        // another way to do it is
        //    - fill the symbol table when encounter declare statement
        //    - look up symbol table if not found assign it to NO_TYPE, and this should be an error
        // TODO: may need to aggregate the error instead of simply stdout
        // ctx.getStart().getStartIndex()
//        ctx.getStart()
        System.out.println("variable text is " + ctx.getText());
        // Current solution should be, variable will resolve it, when assign, variable is not visited
        // VarDeclare handle the creation of VariableExp when declare, for assign, it is visited as normal ?
        // No, it should handle it differently to provide more detail message
        return new VariableExp(ctx.getText());
    }

    @Override
    public Node visitCall(ReikaParser.CallContext ctx) {
        System.out.println("visit call expression");
//        ctx.exprList().expr(); // this will return a list
        return visitChildren(ctx);
    }
}
