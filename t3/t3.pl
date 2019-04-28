odd(N) :- N mod 2 =\= 0.

/*Defina um predicado recursivo hasN(L,N) que seja verdadeiro se L for uma lista de N elementos.*/
hasN([],N). /*condição de parada*/
hasN([H|T],N) :-
	hasN(T,N).

/*Defina um predicado recursivo inc99(L1,L2), */
/*de forma que L2 seja uma lista com todos os elementos de L1 acrescidos da constante 99.*/
inc99([],L2). /*condição de parada, quando L1 passar por todos elementos, ele retorna a lista2*/
inc99([H|T],L2) :-
	H1 is H + 99, /*Define H1 pois o valor a esquerda não pode estar instaciado*/
	inc99(T, [H1|T2]). /*passa o valor de H1 como Head, assim ele adiciona na lista*/



