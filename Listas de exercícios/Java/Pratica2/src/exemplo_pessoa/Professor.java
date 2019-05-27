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
public class Professor extends Pessoa{
    private int siape;
    private float salario;

    public Professor(String nome, String CPF, int idade, int siape, float salario) {
        super(nome, CPF, idade);
        this.siape = siape;
        this.salario = salario;
    }

    public int getSiape() {
        return siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
}
