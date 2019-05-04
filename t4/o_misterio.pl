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
estava_no_ap(pedro, quinta). /*VERIFICAR SE ELE ESTAVA NA SEXTA OU NA QUINTA (na quinta e depois voltou ao apartamento)*/
estava_no_ap(caren, sexta).
estava_no_ap(henrique, segunda).
estava_no_ap(henrique, terca). /*VERIFICAR SE ELE ESTAVA NA TERÇA OU QUARTA (na terça e depois voltou para o apartamento)*/
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

/*Maria esteve em Santa Maria de terça a quinta-feira e no apartamento na segunda e na sexta-feira*/

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

/*tem a chave*/
tem_copia_chave(bia).


pode_roubar_chave(X) :- estava_em(X, santamaria, quarta); estava_em(X, portoalegre, terca).
pode_roubar_arma(X) :- estava_em(X, portoalegre, quinta); estava_em(X, santamaria, quarta); estava_no_ap(X, quarta); estava_no_ap(X, quinta).
acesso(X) :- pode_roubar_arma(X), pode_roubar_chave(X), estava_no_ap(X, sexta); estava_no_ap(X, quinta).
motivo(X) :- pobre(X); insano(X); relacionamento(X, anita); relacionamento(Y, anita), relacionamento(Y, X).
assassino(X) :- motivo(X), acesso(X).