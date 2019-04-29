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

/*Defina um predicado recursivo incN(L1,L2,N), de forma que L2 seja uma lista com todos os elementos de L1 acrescidos da constante N.*/
/*Minha primeira lógica foi essa, porém não funcionou. Quando o L1 fica em [] ele não fez todas operações com o L2?*/
incN2([],_,_).
incN2([H|T], _, N) :-
	H1 is H + N,
	incN2(T, [H1|_], N).

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








