# Query Language

## Primitive types

Integer

- [ ] support negative number

Boolean

- [ ] maybe just use 0 and 1 for bool?

String

Date

- Java8 provides new API
  - [ ] https://docs.oracle.com/javase/tutorial/datetime/TOC.html

## SymbolTable & Type Check

- we don't have function declaration and scope, so single pass would work for our single table
- symbol table store not only id and type, also store symbol, which gives the line and column of the symbol is defined
- var declaration fill the symbol table and would have `DuplicateDeclarationException` if it is declared before

Ref

Symbol

- http://courses.cs.washington.edu/courses/csep501/16wi/lectures/I-semantics.pdf
  - P47, What to do when undeclared identifier is encountered
  - P48, mentioned predefined things
  
Type

- P51, but the slide is using class for type, because it's an oop language I guess?

## TODO

- [ ] difference between expression and statement
  - http://stackoverflow.com/questions/4728073/what-is-the-difference-between-an-expression-and-a-statement-in-python
- [ ] may need another g4 grammar and parser for SQL

## ANTLR

- [ ] show syntax error and type error
  - Guide `listeners/CheckSymbols.java`,

````
public static void error(Token t, String msg) {
    System.err.printf("line %d:%d %s\n", t.getLine(), t.getCharPositionInLine(), msg);
}
CheckSymbols.error(ctx.ID().getSymbol(), "no such function: "+funcName);
````

- MUST put BOOL before ID, otherwise true will be treated as identifier

## Ref

Courses

- Use Java http://courses.cs.washington.edu/courses/csep501/09au/lectures/slides.html
- Also use Java? http://www.cs.cornell.edu/courses/cs4120/2016sp/
- Not so much code https://web.stanford.edu/class/cs143/


- Building Abstract Syntax Trees in Java
  - https://lambda.uta.edu/cse5317/notes/node24.html
- Symbol Tables https://lambda.uta.edu/cse5317/notes/node29.html
  - [ ] Note that a symbol table is a compile-time data structure. It's not used during run time by statically typed languages
  - [ ] Add fake entry in symbol table to recovery from error
    - P42 http://courses.cs.washington.edu/courses/csep501/09au/lectures/slides/I-semantics_ink.pdf
- Type and Type Checking
  - [ ] https://lambda.uta.edu/cse5317/notes/node30.html
  - [ ] http://www.cs.cornell.edu/courses/cs4120/2013fa/schedule.html
    - Add method type check in each AST http://www.cs.cornell.edu/courses/cs4120/2013fa/lectures/lec08-fa13.pdf
  - [ ] Also have type check using visitor pattern http://courses.cs.washington.edu/courses/csep501/09au/lectures/slides/H-ASTs_ink.pdf
  - [ ] Use No_Type for error recovery https://web.stanford.edu/class/cs143/lectures/lecture10.pdf
  - http://courses.cs.washington.edu/courses/csep501/16wi/lectures/I-semantics.pdf
- Visitor pattern
  - http://courses.cs.washington.edu/courses/csep501/09au/lectures/slides/H-ASTs_ink.pdf
