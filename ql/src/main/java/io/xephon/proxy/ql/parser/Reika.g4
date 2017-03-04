// Reika is from Reika Mishima
// The grammar file is based on ANTLR Guide Chapter 6 Cymbol
// Usage
// - see build.gradle for detail
// - gradle parser
// - gradle
grammar Reika;

// TODO: maybe allow single expression stat+|expr
// TODO: add tokens for date or date time
prog : stat+;

type : 'int' | 'bool' | 'string' | 'date';
varDecl : type ID '=' expr ';';
varAssign : ID '=' expr ';';
stat : varDecl
     | varAssign
     | expr ';'
     ;
expr : ID '(' exprList? ')' // function
     | ID // variable
     | expr ADD expr
     | expr MINUS expr
     | INT
     | STRING
     ;

exprList : expr (',' expr)* ;   // arg list

// tokens
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
