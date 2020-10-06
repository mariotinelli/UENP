
# Tradutor simples de expressões matemáticas

Tradutor simples de expressões matemáticas onde recebe uma entrada (expressão matemática) transforma a mesma em notação pós-fixa e faz o cálculo da expressão. Para isso foi feito um tradutor que respeita as precedências matemáticas, que são elas:

1° multiplicação / divisão
2° soma / subtração

## Linguagem utilizada

Criado a partir da linguagem python.


## Gramática utilizada

I -> TS  
S -> +TS | -TS  
T -> EM   
M -> * EM | /EM   
E -> num   

## Dificuldades encontradas

Encontrei uma grande dificuldade em entender como era o funcionamento do código recebido de exemplo, onde esse código era um tradutor de apenas soma e subtração. Após entender o mesmo, consegui prosseguir no andandamento de adicionar as operações de divisão e multiplicação, respeitando a ordem de precedências matemáticas. Já a parte de criação da gramática, não consegui entender muito bem eu acho, então não sei exatamaneto se está correta.
