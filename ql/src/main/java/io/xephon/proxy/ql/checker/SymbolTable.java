package io.xephon.proxy.ql.checker;

import io.xephon.proxy.ql.ReikaException;
import io.xephon.proxy.ql.ast.DataType;
import org.antlr.v4.runtime.Token;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by at15 on 3/4/17.
 * <p>
 * SymbolTable is used for type check when building the AST
 *
 * @TODO - record what is declared
 * @TODO - maybe add and look by Symbol instead of id, and keep that information in symbol table as well
 * @TODO - may need to support retry
 * - when assign, check if the variable is declared and if the rhs type in correct
 * <p>
 * NOTE:
 * - don't support scope, because all the functions are built in function
 * - just need one phase because no forward reference
 */
public class SymbolTable {
    private Map<String, Symbol> table;

    public SymbolTable() {
        table = new HashMap<>();
    }

    /**
     * @param token
     * @param type
     * @throws DuplicateDeclarationException
     * @TODO: need to have recovery, set the symbol to the latest type, i.e. addSafe
     */
    public void add(DataType type, Token token) throws DuplicateDeclarationException {
        String id = token.getText();
        Symbol symbol = new Symbol(token, type);
        if (!table.containsKey(id)) {
            table.put(id, symbol);
        } else {
            throw new DuplicateDeclarationException(table.get(id), symbol);
        }
    }

    public Symbol resolve(Token token) throws UndefinedIdentifierException {
        String id = token.getText();
        if (!table.containsKey(id)) {
            throw new UndefinedIdentifierException(new Symbol(token));
        }
        return table.get(id);
    }

    public static void printTable(SymbolTable table) {
        // FIXME: idea say this could be replaced with expression lambda
        table.table.forEach((id, symbol) -> {
            System.out.printf("%s %s defined on %d, %d\n", symbol.type, id, symbol.line, symbol.column);
        });
    }
}
