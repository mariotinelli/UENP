grammar Interpreter;

@header {
package parser;
}

prog  : (line)+;
       
line  : input  EOL               #lineInput
      | output EOL               #lineOutput 
      | expr   EOL               #lineExpr          
      | atrb   EOL               #lineAtrb
      | ifstmt                   #lineIf
      ;

input : READ '(' TYPE ',' VAR ')';

output: PRINT '('VAR')'          #outVar
      | PRINT '('expr')'         #outExpr
      | PRINT '('STR')'          #outStr
      ;

atrb  : TYPE VAR '=' expr        #atrbExpr
      | TYPE VAR '=' STR         #atrbStr
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
      
ifstmt: IF '(' c1=cond ')' b1=block                                                     #if
      | IF '(' c1=cond ')' b1=block ELSEIF '(' c2=cond ')' b2=block                     #ifElseIf
      | IF '(' c1=cond ')' b1=block ELSEIF '(' c2=cond ')' b2=block ELSE b3=block       #IfElseIfElse
      | IF '(' c1=cond ')' b1=block ELSE b2=block                                       #IfElse
      ;


cond returns [Object val]
      : expr                     #condExpr
      | STR RELOP STR            #condRelopStr
      | expr RELOP expr          #condRelop
      ;

block returns [Object val]
      : '{' prog '}'             #blockStmt
      ;

// tokens
RELOP   : '>'|'<'|'>='|'<='|'=='|'!=';
IF      : 'if';
ELSEIF  : 'else if';
ELSE    : 'else';
READ    : 'input';
TYPE    : 'int' | 'double' | 'string';
PRINT   : 'print';
EOL     : ';';
ASSIGN  : '=';
SUM     : '+';
SUB     : '-';
REST    : '%';
MULT    : '*';
DIV     : '/';
CLOSE   : ')';
OPEN    : '(';
OPEN_BL : '{';
CLOSE_BL: '}';
INT     : [0-9]+;
DBL     : [0-9]+[.][0-9]+;
VAR     : [a-zA-Z_][a-zA-Z0-9_]*;
STR     : '"'('\\' ["\\] | ~["\\\r\n])*'"';
WS      :  [ \t\r\n\u000C]+ -> skip;