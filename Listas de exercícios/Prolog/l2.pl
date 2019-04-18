is_member(L, [H|T]) :-
	is_member(L, T) ;
	L == H.

ao_lado(X, Y, L) :- nextto(X,Y,L) ; nextto(Y,X,L).

um_entre(X, Y, L) :- nextto(X,G,L) , nextto(G,Y,L) ; nextto(Y,G,L) , nextto(G,X,L).

