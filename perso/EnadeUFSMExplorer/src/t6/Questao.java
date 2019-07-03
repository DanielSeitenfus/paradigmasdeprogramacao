/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t6;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author danie
 */
public class Questao {
    //Não usados
    private SimpleStringProperty curso;
    private SimpleStringProperty objetodetalhado;
    //Principais
    private SimpleStringProperty ano;
    private SimpleStringProperty prova;	
    private SimpleStringProperty tipoquestao;	
    private SimpleStringProperty idquestao;
    private SimpleStringProperty objeto;
    private SimpleStringProperty acertoscurso;
    private SimpleStringProperty acertosregiao;
    private SimpleStringProperty acertosbrasil;
    private SimpleStringProperty acertosdif;
    //Tela detalhada
    private SimpleStringProperty gabarito;
    private SimpleStringProperty imagem;
    private String urlcrop;
    
    public Questao(String ano, String prova, String tipoquestao, String idquestao, String objeto, String acertoscurso, String acertosregiao, String acertosbrasil, String acertosdif) {
        this.ano = new SimpleStringProperty(ano);
        this.prova = new SimpleStringProperty(prova);
        this.tipoquestao = new SimpleStringProperty(tipoquestao);
        this.idquestao = new SimpleStringProperty(idquestao);
        this.objeto = new SimpleStringProperty(objeto);
        this.acertoscurso = new SimpleStringProperty(acertoscurso);
        this.acertosregiao = new SimpleStringProperty(acertosregiao);
        this.acertosbrasil = new SimpleStringProperty(acertosbrasil);
        this.acertosdif = new SimpleStringProperty(acertosdif);
    }
    
    public Questao(String ano, String prova, String tipoquestao, String idquestao, String objeto, String acertoscurso, String acertosregiao, String acertosbrasil, String acertosdif, String gabarito, String imagem, String urlcop) {
        this.ano = new SimpleStringProperty(ano);
        this.prova = new SimpleStringProperty(prova);
        this.tipoquestao = new SimpleStringProperty(tipoquestao);
        this.idquestao = new SimpleStringProperty(idquestao);
        this.objeto = new SimpleStringProperty(objeto);
        this.acertoscurso = new SimpleStringProperty(acertoscurso);
        this.acertosregiao = new SimpleStringProperty(acertosregiao);
        this.acertosbrasil = new SimpleStringProperty(acertosbrasil);
        this.acertosdif = new SimpleStringProperty(acertosdif);
        this.gabarito = new SimpleStringProperty(gabarito);
        this.imagem = new SimpleStringProperty(imagem);
        this.urlcrop = urlcop;
    }
    
    public Questao(){
        
    }
    
    public String getUrlcop(){
        return urlcrop;
    }
    
    public void setUrlcop(String urlcop){
        this.urlcrop = urlcop;
    }
    
    public SimpleStringProperty getImagem(){
        return imagem;
    }
    
    public void setImagem(String imagem){
        this.imagem.set(imagem);
    }

    public SimpleStringProperty getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso.set(curso);
    }

    public SimpleStringProperty getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano.set(ano);
    }

    public SimpleStringProperty getProva() {
        return prova;
    }

    public void setProva(String prova) {
        this.prova.set(prova);
    }

    public SimpleStringProperty getTipoquestao() {
        return tipoquestao;
    }

    public void setTipoquestao(String tipoquestao) {
        this.tipoquestao.set(tipoquestao);
    }

    public SimpleStringProperty getIdquestao() {
        return idquestao;
    }

    public void setIdquestao(String idquestao) {
        this.idquestao.set(idquestao);
    }

    public SimpleStringProperty getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto.set(objeto);
    }

    public SimpleStringProperty getGabarito() {
        return gabarito;
    }

    public void setGabarito(String gabarito) {
        this.gabarito.set(gabarito);
    }

    public SimpleStringProperty getAcertoscurso() {
        return acertoscurso;
    }

    public void setAcertoscurso(String acertoscurso) {
        this.acertoscurso.set(acertoscurso);
    }
    
    public SimpleStringProperty getAcertosregiao(){
        return acertosregiao;
    }
    
    public void setAcertosregiao(String acertosregiao){
        this.acertosregiao.set(acertosregiao);
    }
    
    public SimpleStringProperty getAcertosbrasil(){
        return acertosbrasil;
    }
    
    public void setAcertosbrasil(String acertosbrasil){
        this.acertosbrasil.set(acertosbrasil);
    }
     

    public SimpleStringProperty getAcertosdif() {
        return acertosdif;
    }

    public void setAcertosdif(String acertosdif) {
        this.acertosdif.set(acertosdif);
    }

    public SimpleStringProperty anoProperty(){
        return ano;
    }
    public SimpleStringProperty provaProperty() {
      return prova;
    }
    public SimpleStringProperty tipoquestaoProperty() {
      return tipoquestao;
    }
    public SimpleStringProperty idquestaoProperty() {
      return idquestao;
    }
    public SimpleStringProperty objetoProperty() {
      return objeto;
    }
    public SimpleStringProperty gabaritoProperty() {
      return gabarito;
    }
    public SimpleStringProperty acertoscursoProperty() {
      return acertoscurso;
    }
    public SimpleStringProperty acertosdifProperty() {
      return acertosdif;
    }
    public SimpleStringProperty acertosregiaoProperty() {
        return acertosregiao;
    }
    public SimpleStringProperty acertosbrasilProperty() {
        return acertosbrasil;
    }
    public SimpleStringProperty imagemProperty(){
        return imagem;
    }
    
    
    
    
    
    
    

}
