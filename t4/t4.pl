/*vítima, pobre e-ou insano*/
vitima(anita).
pobre(bernardo).
pobre(bia).
pobre(pedro).
pobre(maria).
rica(caren).
rica(alice).
rica(henrique).
rica(adriano).
insano(adriano).
insano(maria).

/*Relacionamentos*/
relacionamento(bernardo,anita).
relacionamento(bernardo,caren).
relacionamento(pedro,anita).
relacionamento(pedro,alice).
relacionamento(henrique,alice).
relacionamento(henrique,maria).
relacionamento(adriano,maria).
relacionamento(adriano,caren).

/*estava_no_ap*/
estava_no_ap(pedro, sexta).
estava_no_ap(caren, sexta).
estava_no_ap(henrique, segunda).
estava_no_ap(henrique, quarta).
estava_no_ap(henrique, quinta).
estava_no_ap(henrique, sexta).
estava_no_ap(bia, segunda).
estava_no_ap(bia, sexta).
estava_no_ap(adriano, quinta).
estava_no_ap(adriano, sexta).
estava_no_ap(adriano, sabado).
estava_no_ap(adriano, domingo).
estava_no_ap(alice, segunda).
estava_no_ap(alice, quinta).
estava_no_ap(alice, sexta).
estava_no_ap(bernardo, sexta).
estava_no_ap(maria, segunda).
estava_no_ap(maria, sexta).
estava_no_ap(anita, quinta).
estava_no_ap(anita, sexta).

/*estava_em*/
estava_em(pedro, santamaria, segunda).
estava_em(pedro, santamaria, terca).
estava_em(pedro, portoalegre, quarta).
estava_em(pedro, santamaria, quinta).
estava_em(caren, portoalegre, segunda).
estava_em(caren, portoalegre, terca).
estava_em(caren, portoalegre, quarta).
estava_em(caren, santamaria, quinta).
estava_em(henrique, portoalegre, terca).
estava_em(bia, portoalegre, terca).
estava_em(bia, santamaria, quinta).
estava_em(adriano, santamaria, quarta).
estava_em(alice, portoalegre, terca).
estava_em(alice, portoalegre, quarta).
estava_em(bernardo, santamaria, segunda).
estava_em(bernardo, santamaria, terca).
estava_em(bernardo, portoalegre, quarta).
estava_em(bernardo, santamaria, quinta).
estava_em(maria, santamaria, terca).
estava_em(maria, santamaria, quarta).
estava_em(maria, santamaria, quinta).

tem_copia_chave(bia).

chave(X) :- estava_em(X, santamaria, segunda); estava_em(X, portoalegre, terca); tem_copia_chave(X).
arma(X) :- estava_em(X, portoalegre, quinta); estava_em(X, santamaria, quarta); estava_no_ap(X, quarta); estava_no_ap(X, quinta).
apartamento(X) :- estava_no_ap(X, sexta); estava_no_ap(X, quinta).
acesso(X) :- arma(X), chave(X), apartamento(X).
ciume(X) :- relacionamento(Y, anita), relacionamento(Y, X).
motivo(X) :- pobre(X); insano(X); ciume(X).
assassino(X) :- motivo(X), acesso(X), !.