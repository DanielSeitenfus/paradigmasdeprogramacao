/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.LinkedList;

/**
 *
 * @author danie
 */
public class Vertice {
    int identificador;
    String nome;
    LinkedList<Adjacencia> listaAdjacencia;

    public Vertice(String nome, int identificador) {
        this.nome = nome;
        this.identificador = identificador;
        listaAdjacencia =  new LinkedList<>();        
    }
}
