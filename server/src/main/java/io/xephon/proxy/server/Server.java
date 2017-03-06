package io.xephon.proxy.server;

import io.xephon.proxy.ql.ast.*;

import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("e.. I think I am a server");
        IntegerLiteral integerLiteral = new IntegerLiteral(1);
        StringLiteral stringLiteral = new StringLiteral("a");
        List<Node> nodes = new ArrayList<>();
        nodes.add(integerLiteral);
        nodes.add(stringLiteral);
        for (Node node : nodes) {
            String nodeType = node.getClass().getSimpleName();
            switch (nodeType) {
                case "IntegerLiteral":
                    IntegerLiteral iexp = (IntegerLiteral) node;
                    System.out.println(iexp.value);
                    break;
                case "StringLiteral":
                    StringLiteral sexp = (StringLiteral) node;
                    System.out.println(sexp.value);
            }
        }
    }
}
