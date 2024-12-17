grammar Expr;

prog:   stat+;

stat:   'print' expr NEWLINE                          # printExpr
        | ID '=' expr NEWLINE                  # assign
        | 'function' ID '(' params? ')' '{' prog '}' NEWLINE  # functionDef
        | ID '(' args? ')' NEWLINE              # functionCall
        | 'if' expr 'then' prog ('else' prog)? 'end' NEWLINE  # ifStmt
        | 'while' expr 'do' prog 'end' NEWLINE   # whileStmt
        | '{' prog '}'                           # block
        ;

params: ID (',' ID)*;  // 函数参数

args: expr (',' expr)*; // 函数参数的实际参数

expr:   expr op=('*'|'/') expr                     # mulDiv
        | expr op=('+'|'-') expr                     # addSub
        | expr op=('=='|'!='|'>'|'>='|'<'|'<=') expr  # comparison
        | INT                                   # int
        | FLOAT                                 # float
        | STRING                                # string
        | 'true'                                # true
        | 'false'                               # false
        | ID                                    # id
        | '(' expr ')'                          # parens
        ;
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
EQ  : '==';
NEQ : '!=';
GT  : '>';
GTE : '>=';
LT  : '<';
LTE : '<=';
ID  : [a-zA-Z]+ ;  // 变量名
INT : [0-9]+ ;     // 整数
FLOAT : [0-9]+ '.' [0-9]+ ; // 浮点数
STRING: '\'' (~['\r\n])* '\'' ; // 用单引号包裹的字符串
NEWLINE: [\r\n]+ ;
WS  : [ \t]+ -> skip ;