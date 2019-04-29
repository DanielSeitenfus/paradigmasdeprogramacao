odd(N) :- N mod 2 =\= 0.

hasN([],0). /*Quando a lista estiver vazia e o N=0 retorna true, caso contrário, false.*/
hasN([_|T],N) :-
	N1 is N - 1,
	hasN(T,N1).

/*Defina um predicado recursivo inc99(L1,L2), */
/*de forma que L2 seja uma lista com todos os elementos de L1 acrescidos da constante 99.*/
inc99([],_). /*condição de parada, quando L1 passar por todos elementos, ele retorna a lista2*/
inc99([H|T],_) :-
	H1 is H + 99, /*Define H1 pois o valor a esquerda não pode estar instaciado*/
	inc99(T, [H1|_]). /*passa o valor de H1 como Head, assim ele adiciona na lista*/


incN([],[],_). /* Devo colocar L1 e L2 = [] como instrução de parada porque ele executa primeiro um depois o outro*/
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

countdown(0,[]) :- !.
countdown(N,[H|T]) :-
	N1 is N - 1,
	H = N,
	countdown(N1, T).

nRandoms(0,[]) :- !.
nRandoms(N, [H|T]) :-
	N1 is N - 1,
	random(1, 100, H),
	nRandoms(N1,T).

potN0(-1,[]) :- !.
potN0(N,[H|T]) :-
	H is 2**N,
	N1 is N - 1,
	potN0(N1, T).

zipmult([],[],[]) :- !.
zipmult([H1|T1],[H2|T2],[H3|T3]) :-
	H3 is H1*H2,
	zipmult(T1,T2,T3).

potencias(N,L) :- potencias_(0,N,L).

potencias_(N1, N1, []) :- !.
potencias_(I, F, [H|T]):-
	H is 2**I,
	C is I + 1,
	potencias_(C, F, T).












