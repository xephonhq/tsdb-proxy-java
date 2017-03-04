# Query Language

## Primitive types 

Integer

Boolean

- [ ] maybe just use 0 and 1 for bool?

String

Date 

- Java8 provides new API
  - [ ] https://docs.oracle.com/javase/tutorial/datetime/TOC.html
  
## TODO

- [ ] difference between expression and statement 
  - http://stackoverflow.com/questions/4728073/what-is-the-difference-between-an-expression-and-a-statement-in-python
- [ ] may need another g4 grammar and parser for SQL

## ANTLR

- [ ] show syntax error and type error
  - Guide `listeners/CheckSymbols.java`, 
  
````java
public static void error(Token t, String msg) {
    System.err.printf("line %d:%d %s\n", t.getLine(), t.getCharPositionInLine(),
                      msg);
}
CheckSymbols.error(ctx.ID().getSymbol(), "no such function: "+funcName);
````
## Ref 

- Building Abstract Syntax Trees in Java https://lambda.uta.edu/cse5317/notes/node24.html
- Symbol Tables https://lambda.uta.edu/cse5317/notes/node29.html
  - [ ] Note that a symbol table is a compile-time data structure. It's not used during run time by statically typed languages
