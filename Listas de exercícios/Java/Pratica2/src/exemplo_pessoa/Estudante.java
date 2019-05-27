/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo_pessoa;

/**
 *
 * @author danie
 */
public class Estudante extends Pessoa{
    private int matricula;

    public Estudante(String nome, String CPF, int idade, int matricula) {
        super(nome, CPF, idade);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    public void mostraDados(){
        System.out.println("Nome: "+nome);
    }
    
}
