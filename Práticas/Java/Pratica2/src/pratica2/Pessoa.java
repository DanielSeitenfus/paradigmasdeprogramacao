/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica2;

public class Pessoa {
    private String nome;
    private String CPF;
    private String sexo;
    private Data dtNasc;

    public Pessoa(String nome, String CPF, String sexo, int dia, int mes, int ano) {
        this.nome = nome;
        this.CPF = CPF;
        this.sexo = sexo;
        this.dtNasc = new Data(dia, mes, ano);
    }
    
    public void apresentarPessoa(){
        System.out.println("Nome: "+nome);
        System.out.println("CPF: "+CPF);
        System.out.println("Sexo: "+sexo);
        System.out.println("Data de nascimento: "+dtNasc.getData());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Data getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Data dtNasc) {
        this.dtNasc = dtNasc;
    }
    
    
}
