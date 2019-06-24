/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo_pessoa;

import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class Main {
    public static void main(String[] args) {
        Estudante estudante = new Estudante("Daniel", "039.068.650-61", 21, 2019510121);
        Professor professor = new Professor("Professor","CPF",45,123,15000);
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        listaPessoas.add(estudante);
        listaPessoas.add(professor);
        
        for(int i=0; i<listaPessoas.size(); i++){
            Pessoa pessoa = listaPessoas.get(i);
            pessoa.mostraDados();
        }
    }
}
