package io.xephon.proxy.ql.checker;

import com.google.common.collect.Table;
import io.xephon.proxy.ql.ReikaException;
import io.xephon.proxy.ql.ast.DataType;

import java.util.HashMap;

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
    // TODO: might use guava's table
    private HashMap<String, DataType> table;
//    private Table<String, >

    // TODO: may have a class called symbol exception?
    public DataType lookup(String id) throws ReikaException{
        // TODO: is using NO_TYPE a good idea?
        // Maybe throw exception and catch it in visitor is a better idea
        // FIXME: you can't throw exception in visitor
        // TODO: using unchecked exception allow not modifying the method definition
        // TODO: the exception need symbol information
        if (!table.containsKey(id)) {
            return DataType.NO_TYPE;
        }
        return table.get(id);
    }

    public void add(String id, DataType type) throws ReikaException {
        // TODO: deal with declare twice
        if (!table.containsKey(id)) {
            table.put(id, type);
        } else {
            // TODO: throw exception
        }
//        int a = 1;
//        double a = 2.0;
//        int c = a + 1;
//        int d = c + 1;
//        e = 1;
//        int g = e + 1;
    }
}
