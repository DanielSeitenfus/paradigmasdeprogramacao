/*---------1*/
odd(N) :- N mod 2 =\= 0.

/*---------2*/
hasN([],0).
hasN([_|T],N) :-
	N1 is N - 1,
	hasN(T,N1).

/*---------3*/
inc99([],_). 
inc99([H|T],_) :-
	H1 is H + 99, 
	inc99(T, [H1|_]). 

/*---------4*/
incN([],[],_).
incN([H|T], [H2|T2], N) :-
	incN(T, T2, N),
	H2 is H + N.

/*---------5*/
comment([],[]).
comment([H1|T1],[H2|T2]) :-
	comment(T1,T2),
	string_concat("%%", H1, H2).

/*---------6*/
par(N) :- N mod 2 =:= 0.

onlyEven([],[]).
onlyEven([H1|T1],[H2|T2]) :-
H2 = H1,
par(H1),
onlyEven(T1,T2); 
onlyEven(T1,[H2|T2]).

/*---------7*/
countdown(0,[]) :- !.
countdown(N,[H|T]) :-
	N1 is N - 1,
	H = N,
	countdown(N1, T).

/*---------8*/
nRandoms(0,[]) :- !.
nRandoms(N, [H|T]) :-
	N1 is N - 1,
	random(1, 100, H),
	nRandoms(N1,T).

/*---------9*/
potN0(-1,[]) :- !.
potN0(N,[H|T]) :-
	H is 2**N,
	N1 is N - 1,
	potN0(N1, T).

/*---------10*/
zipmult([],[],[]) :- !.
zipmult([H1|T1],[H2|T2],[H3|T3]) :-
	H3 is H1*H2,
	zipmult(T1,T2,T3).

/*---------11*/
potencias(N,L) :- potencias_(0,N,L).

potencias_(N1, N1, []) :- !.
potencias_(I, F, [H|T]):-
	H is 2**I,
	C is I + 1,
	potencias_(C, F, T).

/*---------12*/
cedulas(_,[],[]).
cedulas(V,[H|T],[H2|T2]) :-
	H2 is V//H,
	V2 is V mod H,

	cedulas(V2,T,T2).













