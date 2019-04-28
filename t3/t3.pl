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
/*Minha primeira lógica foi essa, porém não funcionou*/
incN([],L2,N).
incN([H|T], L2, N) :-
	H1 is H + N,
	incN(T, [H1|T2], N).

