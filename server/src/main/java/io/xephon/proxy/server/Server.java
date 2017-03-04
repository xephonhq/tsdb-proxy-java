package io.xephon.proxy.server;

import io.xephon.proxy.ql.ast.*;

import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("e.. I think I am a server");
        IntegerExp integerExp = new IntegerExp(1);
        StringExp stringExp = new StringExp("a");
        List<Node> nodes = new ArrayList<>();
        nodes.add(integerExp);
        nodes.add(stringExp);
        for (Node node : nodes) {
            String nodeType = node.getClass().getSimpleName();
            switch (nodeType) {
                case "IntegerExp":
                    IntegerExp iexp = (IntegerExp) node;
                    System.out.println(iexp.value);
                    break;
                case "StringExp":
                    StringExp sexp = (StringExp) node;
                    System.out.println(sexp.value);
            }
        }
    }
}
