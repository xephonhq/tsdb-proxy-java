// Reika is from Reika Mishima
// The grammar file is based on ANTLR Guide Chapter 6 Cymbol
//
// Usage
// - see build.gradle for detail
// - gradle genParser
// - Ayi run grun
// TODO:
// - support date
// - entry of program
grammar Reika;

//prog : stat+ | expr;
prog : stat+ ;

type : 'int' | 'bool' | 'string' | 'date';
varDeclare : type ID '=' expr ';';
varAssign : ID '=' expr ';';
stat : varDeclare # VarDeclareStat
     | varAssign # VarAssignStat
     | expr ';' # ExprStat
     ;
expr : ID '(' exprList? ')' # Call
     | ID # Variable
     | expr ADD expr # Add
     | expr MINUS expr # Minus
     | INT # Int
     | STRING # String
     ;

exprList : expr (',' expr)* ;   // arg list

// tokens
// TODO: add tokens for date or date time
ID  :   LETTER (LETTER | [0-9])* ;
fragment
LETTER : [a-zA-Z] ;

INT :   [0-9]+ ;

// NOTE: from Chapter 05, only support escape "
STRING: '"' (ESC|.)*? '"';
fragment
ESC : '\\"' | '\\\\' ; // 2-char sequences \" and \\

ADD : '+';
MINUS: '-';

WS  :   [ \t\n\r]+ -> skip ;

SL_COMMENT :   '//' .*? '\n' -> skip ;
