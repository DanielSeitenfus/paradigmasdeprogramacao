odd(N) :- N mod 2 =\= 0.

hasN([H|T],N) :-
N>0,
N1 is N - 1,
hasN(T, N1).

inc99([H|T],L2) :-
inc99(T,L2)
H1 is H+99,
L2 = [H1|T].
