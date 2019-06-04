Tabelas-verdade em Prolog
 
**Introdução**

O objetivo da atividade proposta é estudar, testar e explicar métodos de como representar tabelas-verdade em prolog. O Prolog é uma linguagem de programação declarativa, logo, ao invés do programador codificar passo-a-passo as instruções para resolução do problema, como acontece em outras linguagens, há recursos de que a linguagem fornece, como fatos e regras, que permitem identificar como o problema deve ser resolvido. Assim, a explicação do código passa em descrever os predicados e fatos que serão usados para a construção de tabelas-verdade em Prolog.

**Predicados**

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

(4) E, por fim, pela **combinação** de todos os predicados, utilizando este para realizar as consultas no interpretador

``table(A,B,Expr) :- bind(A), bind(B), do(A,B,Expr), fail.``

