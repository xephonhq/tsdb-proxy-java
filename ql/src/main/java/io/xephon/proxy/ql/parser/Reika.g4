/*
 Reika is from Reika Mishima
 The grammar file is based on ANTLR Guide Chapter 6 Cymbol

 Usage
 - gradle genParser
 - Ayi run grun
 - Unit tests in io.xephon.proxy.ql.parser
 TODO:
 - support date
*/
grammar Reika;

//prog : stat+ | expr;
prog : stat+ ;

type : 'int' | 'double' | 'bool' | 'string' | 'date';
varDeclare : type ID '=' expr ';';
varAssign : ID '=' expr ';';
stat : varDeclare # VarDeclareStat
     | varAssign # VarAssignStat
     | expr ';' # ExprStat
     ;
expr : INT # Int
     | DOUBLE # Double
     | BOOL # Bool
     | STRING # String
     | ID '(' exprList? ')' # Call
     | ID # Variable
     | expr MULT expr # Mult
     | expr DIV expr # Div
     | expr ADD expr # Add
     | expr MINUS expr # Minus
     ;

exprList : expr (',' expr)* ;   // arg list

// tokens
// TODO: add tokens for date or date time
INT :   [0-9]+ ;
// NOTE: from Java.g4
DOUBLE: [0-9]+ '.' [0-9]+ ;
// NOTE: must put BOOL before ID, otherwise true will be treated as identifier
BOOL : 'true' | 'false' ;
// NOTE: from Chapter 05, only support escape "
STRING: '"' (ESC|.)*? '"';
fragment
ESC : '\\"' | '\\\\' ; // 2-char sequences \" and \\

ID  :   LETTER (LETTER | [0-9])* ;
fragment
LETTER : [a-zA-Z] ;

ADD : '+';
MINUS: '-';
MULT: '*';
DIV: '/';

WS  :   [ \t\n\r]+ -> channel(HIDDEN)
    ;
COMMENT
    :   '/*' .*? '*/'    -> channel(HIDDEN) // match anything between /* and */
    ;
SL_COMMENT :   '//' .*? '\n' -> channel(HIDDEN)
    ;
