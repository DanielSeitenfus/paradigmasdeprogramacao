# Tabelas-verdade em Prolog
 
## Introdução

O objetivo da atividade proposta é estudar, testar e explicar métodos de como representar tabelas-verdade em prolog. O Prolog é uma linguagem de programação declarativa, logo, ao invés do programador codificar passo-a-passo as instruções para resolução do problema, como acontece em outras linguagens, há recursos de que a linguagem fornece, como fatos e regras, que permitem identificar como o problema deve ser resolvido. Assim, a explicação do código passa em descrever os predicados e fatos que serão usados para a construção de tabelas-verdade em Prolog.

## Predicados

Como sugerido, um dos algoritmos interessantes que resolvem o problema proposto é P46 (http://www.ic.unicamp.br/~meidanis/courses/mc336/2009s2/prolog/problemas/). Nele, são utilizados dez predicados, cada um com uma funcionalidade bem específica.

(1) Os responsáveis pela **lógica** da tabela-verdade:

``and(A,B) :- A, B.``
``or(A,_) :- A.``
``or(_,B) :- B.``
``equ(A,B) :- or(and(A,B), and(not(A),not(B))).``
``xor(A,B) :- not(equ(A,B)).``
``nor(A,B) :- not(or(A,B)).``
``nand(A,B) :- not(and(A,B)).``
``impl(A,B) :- or(not(A),B).``

(2) Pela **instanciação** das variáveis usadas para as comparações lógicas: 

``bind(X).``

(3) Pela **escrita** de informações na tela:

``do(A,B,_) :- write(A), write('  '), write(B), write('  '), fail.``

``do(_,_,Expr) :- Expr, !, write(true), nl.``

``do(_,_,_) :- write(fail), nl.``

(4) E, por fim, pela **combinação** de todos os predicados, utilizando este para realizar as consultas no interpretador:

``table(A,B,Expr) :- bind(A), bind(B), do(A,B,Expr), fail.``

## Fatos

Em Prolog, os fatos são utilizados para criação de uma “base de dados”, que posteriormente serão executadas consultas nas relações dos predicados com os fatos. Nesse caso, o algoritmo conta com somente dois que são vinculados ao predicado bind: true e fail. Como será explicado na seção a seguir, eles serão responsáveis por instanciar as variáveis A e B. 

## Funcionamento
Ao compilarmos o algoritmo, inicialmente as variáveis A e B encontram-se com um valor desconhecido (não-instanciado). Ao realizar, por exemplo, a consulta ``table(A,B,and(A,B))`` no interpretador, o Prolog procura por um fato na base de conhecimentos que se iguale a questão desejada, ou seja, ele irá procurar algum fato que tenha o mesmo predicado, o mesmo número de argumentos. Nesse caso, o predicado “bind” é que instanciará as variáveis A e B. Como ele possui somente dois fatos (true e fail), as variáveis receberão esses valores para a continuar a validação desse predicado. A busca na “base de dados”, inserida através do código, sempre é realizada na ordem em que os fatos foram passados. Assim, é possível realizar a combinação dos fatos, instanciando as variáveis e montando a tabela-verdade. Como instâncias para todas as combinações possíveis para a instância TRUE da variável A, temos:

``table(A,B,Expr)∶- bind(A),bind(B),do(A,B,Expr),fail.``

TRUE | TRUE
-- | --
TRUE | FAIL

É importante notar que, se invertêssemos a ordem de declaração dos fatos “bind(fail). bind(true).”, a combinação das instâncias seria:

FAIL | FAIL
-- | --
FAIL | TRUE

Repetindo o mesmo processo de busca e instanciação para o segundo valor possível de A, temos:


TRUE | TRUE
-- | --
TRUE | FALSE
FALSE | TRUE
FALSE | FALSE

Por conta da instanciação das variáveis pelo predicado “bind”, a variável Expr só é instanciada quando os valores que são passados como argumento na consulta são instanciados. Assim, o predicado “do”, responsável de fato pela escrita (saída de dados) da tabela-verdade, é chamado. Ele recebe como parâmetro as variáveis A, B, Expr (todos já instanciados). Assim, no caso da consulta, table(A,B,and(A,B)) , tem-se:

``table(TRUE,TRUE,TRUE and TRUE)`` *chamada do predicado do*

``do(TRUE,TRUE,TRUE and TRUE)``

Predicado “do” sempre escreve, através do comando “write”, os valores de A e B, além do valor de Expr, que já foi instanciado.

``do(A,B,_)∶- write(A),write('  '),write(B),write('  '),fail.``

``do(_,_,Expr)∶- Expr,!,write(true),nl.``

``do(_,_,_)∶- write(fail),nl.``

Ao final de toda busca, possuímos como saída a tabela-verdade da operação AND:

TRUE | TRUE | TRUE
-- | -- | --
TRUE | FALSE | FALSE
FALSE | TRUE | FALSE
FALSE | FALSE | FALSE

O operador utilizado nos exemplos foi o AND, mas pode-se utilizar qualquer operador declarado nos predicados responsáveis pela combinação lógica, como OR, XOR, NOR, NAND, entre outros.
Há também outras formas de implementação de tabelas-verdade em Prolog. Uma alternativa um pouco diferente é chamar o método write no próprio predicado utilizado para a realização das consultas de tabelas-verdade. Nesse caso, devemos ter uma variável auxiliar, também, que deve ser instanciada de acordo com a expressão passada na consulta, como mostra o exemplo a seguir:

``and(A, B) :- A, B.``

``evaluate(E, true) :- E, !.``

``evaluate(_, false).``

``bool(true).``

``bool(false).``

``tableBody(A,B,E) :-``
  ``bool(A),``
  ``bool(B),``
  ``write(A),``
  ``write(' \t '),``
  ``write(B),``
  ``write(' \t '),``
  ``evaluate(E, Result),``
  ``write(Result),nl, fail.``

