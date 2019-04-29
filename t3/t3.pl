odd(N) :- N mod 2 =\= 0.

/*Defina um predicado recursivo hasN(L,N) que seja verdadeiro se L for uma lista de N elementos.*/
/*Estava começando a fazer a questão e somente testei o que isso iria retornar, e para minha surpresa, funcionou. Porém não entendi porque ele decrementa e testa automaticamente se o N>0 */
hasN([],N). /*condição de parada*/
hasN([H|T],N) :-
	hasN(T,N).

/*Defina um predicado recursivo inc99(L1,L2), */
/*de forma que L2 seja uma lista com todos os elementos de L1 acrescidos da constante 99.*/
inc99([],L2). /*condição de parada, quando L1 passar por todos elementos, ele retorna a lista2*/
inc99([H|T],L2) :-
	H1 is H + 99, /*Define H1 pois o valor a esquerda não pode estar instaciado*/
	inc99(T, [H1|T2]). /*passa o valor de H1 como Head, assim ele adiciona na lista*/

/*Defina um predicado recursivo incN(L1,L2,N), de forma que L2 seja uma lista com todos os elementos de L1 acrescidos da constante N.*/
/*Minha primeira lógica foi essa, porém não funcionou. Quando o L1 fica em [] ele não fez todas operações com o L2?*/
incN2([],L2,N).
incN2([H|T], L2, N) :-
	H1 is H + N,
	incN2(T, [H1|T2], N).

incN([],[],N). /* Devo colocar L1 e L2 = [] como instrução de parada porque ele executa primeiro um depois o outro*/
incN([H|T], [H2|T2], N) :-
	incN(T, T2, N),
	H2 is H + N.

/*Defina um predicado recursivo comment(L1,L2), de forma que L1 seja uma lista de strings e L2 tenha todos os elementos de L1 concatenados com o prefixo "%%". Dica: consulte predicados Prolog para manipulação de strings.*/
comment([],[]).
comment([H1|T1],[H2|T2]) :-
	comment(T1,T2),
	string_concat("%%", H1, H2).

/*Defina um predicado recursivo onlyEven(L1,L2), de forma que L2 seja uma lista só com os elementos pares de L1, conforme o exemplo abaixo:*/
/*?- onlyEven2([1,2,3,4,5,6,7],L).*/
/*L = [2, 4, 6].*/
par(N) :- N mod 2 =:= 0.

onlyEven([],[]).
onlyEven([H1|T1],[H2|T2]) :-
H2 = H1,
par(H1),
onlyEven(T1,T2); 
onlyEven(T1,[H2|T2]). /* caso o par(H1) dê falso, perde-se a instância de H2(?) e executa-se onlyEven(T1, [H2|T2]) com H2 diferente de H1*/





