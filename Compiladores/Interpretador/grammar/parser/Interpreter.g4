grammar Interpreter;

@header {
package parser;
}

prog  : line EOL;
       
line  : input                    #lineInput
      | output                   #lineOutput 
      | expr                     #lineExpr          
      | atrb                     #lineAtrb
      ;

input : TYPE VAR '=' READ '(' ')';

output: PRINT '('VAR')'          #outVar
      | PRINT '('expr')'         #outExpr
      | PRINT '('STR')'          #outStr
      ;

atrb  : TYPE VAR '=' expr        #atrbExpr
      | TYPE VAR '=' STR         #atrbStr
      | VAR '=' expr             #atrbVar
      ;

expr returns [Object val]
      : expr1=expr '+' term      #exprSum
      | expr1=expr '-' term      #exprSub
      | term                     #exprTerm
      ;

term returns [Object val]
      : term1=term '*' fact      #termMult
      | term1=term '/' fact      #termDiv
      | term1=term '%' fact      #termRest
      | fact                     #termFact
      ;

fact returns [Object val]
      : '(' expr ')'             #factExpr
      | INT                      #factInt
      | DBL                      #factDbl
      | VAR                      #factVar
      ;

// tokens
TYPE : 'int' | 'double' | 'string';
PRINT: 'print';
READ: 'input';
EOL: ';';
ASSIGN: '=';
SUM: '+';
SUB: '-';
REST: '%';
MULT: '*';
DIV: '/';
CLOSE: ')';
OPEN: '(';
INT : [0-9]+;
DBL : [0-9]+[.][0-9]+;
VAR: '$'[a-zA-Z_][a-zA-Z0-9_]*;
STR : '"'('\\' ["\\] | ~["\\\r\n])*'"';
WS:  [ \t\r\n\u000C]+ -> skip;