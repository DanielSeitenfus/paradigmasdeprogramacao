/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Grafo {
   //infos básicas 
    int qntVertices;
    int qntArestas;
    LinkedList<Vertice> listaVertices;
    
    //variáveis para busca
    boolean achei;
    int[] cor;
    Vertice verticeBuscar;
    static final int BRANCO=0, AMARELO=1, VERMELHO=2;
    String texto;

    public Grafo() {
        listaVertices = new LinkedList<>();
        qntVertices=0;
        qntArestas=0;
    }
    
    public int distanciaEntrePessoas(int inicio, int fim) { //transforma em matriz de adjacência 
        int[][] ma = new int[qntVertices][qntVertices];
        for (int i = 0; i < qntVertices; ++i) {
            for (int j = 0; j < qntVertices; ++j) {
                ma[i][j] = 0;
            }
        }
        for (int i = 0; i < qntVertices; i++) {
            Vertice vertice = listaVertices.get(i);
            LinkedList<Adjacencia> listaAdjacencias = vertice.listaAdjacencia;
            for (int j = 0; j < listaAdjacencias.size(); j++) {
                ma[listaVertices.get(i).identificador][listaAdjacencias.get(j).vertice.identificador] = 1;
            }
        }

        int distancias[] = buscaLateral(inicio, ma, qntVertices*qntVertices);
        return distancias[fim];
        
    }
    
    private int[] buscaLateral(int inicio, int[][] ma, int tam) {
        int[] nivel = new int[tam];
        Queue<Integer> fila = new LinkedList<>();

        // Inicialinzando nivel de todos os vértices como -1
        for (int i = 0; i < qntVertices; i++) {
            nivel[i] = -1;
        }

        // O nível do vértice inicial é zero
        nivel[inicio] = 0;
        fila.add(inicio);

        // Executando a busca lateral
        while (!fila.isEmpty()) {
            int atual = fila.remove();
            for (int i = 0; i < qntVertices; i++) {
                if (ma(atual, i, ma) == 1 && nivel[i] == -1) {
                    nivel[i] = nivel[atual] + 1;
                    fila.add(i);
                }
            }
        }
        return nivel;
    }

    private static int ma(int i, int j, int[][] ma) {
        if (i < j) {
            return ma[i][j];
        } else {
            return ma[j][i];
        }
    }
}
