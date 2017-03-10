# ANTLR

## Take away

- MUST put BOOL before ID, otherwise true will be treated as identifier

## Ref

- show syntax error and type error
  - guide `listeners/CheckSymbols.java`,

````
public static void error(Token t, String msg) {
    System.err.printf("line %d:%d %s\n", t.getLine(), t.getCharPositionInLine(), msg);
}
CheckSymbols.error(ctx.ID().getSymbol(), "no such function: "+funcName);
````

- show `^` under specific line 
  - guide `errors/TestE_Listener2.java`

````
protected void underlineError(Recognizer recognizer,
                                Token offendingToken, int line,
                                int charPositionInLine) {
      CommonTokenStream tokens =
          (CommonTokenStream)recognizer.getInputStream();
      String input = tokens.getTokenSource().getInputStream().toString();
      String[] lines = input.split("\n");
      String errorLine = lines[line - 1];
      System.err.println(errorLine);
      for (int i=0; i<charPositionInLine; i++) System.err.print(" ");
      int start = offendingToken.getStartIndex();
      int stop = offendingToken.getStopIndex();
      if ( start>=0 && stop>=0 ) {
          for (int i=start; i<=stop; i++) System.err.print("^");
      }
      System.err.println();
  }
````
