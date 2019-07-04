/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author danie
 */
public class Principal extends javax.swing.JFrame {

    static final int CONHECIDO = 1, COLEGA = 2, AMIGO = 3, COMPANHEIRO = 4, FAMILIAR = 5, OUTRO = 0;
    int cont = 0;
    DefaultTableModel defaultTableModel;
    Grafo grafo;

    public Principal() {
        initComponents();
        defaultTableModel = (DefaultTableModel) jTable1.getModel();
        grafo = new Grafo();
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);        // Configura a largura para 100 pixels
        int vColIndex = 0;
        TableColumn col = jTable1.getColumnModel().getColumn(vColIndex);

        col.setPreferredWidth(50);
        col = jTable1.getColumnModel().getColumn(1);
        col.setPreferredWidth(200);
        col = jTable1.getColumnModel().getColumn(2);
        col.setPreferredWidth(400);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jBSalvar = new javax.swing.JButton();
        jTFNome = new javax.swing.JTextField();
        jBVinculo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jBMenorCaminho = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Vínculos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Pessoas:");

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBVinculo.setText("Estabelecer vínculo");
        jBVinculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVinculoActionPerformed(evt);
            }
        });

        jButton1.setText("Imprimir grafo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBMenorCaminho.setText("Menor caminho");
        jBMenorCaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMenorCaminhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBMenorCaminho)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBVinculo))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jTFNome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVinculo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBMenorCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        String nome = jTFNome.getText();
        defaultTableModel.addRow(new Object[]{cont++, nome, ""});
        Vertice vertice = new Vertice(nome, defaultTableModel.getRowCount() - 1);
        grafo.listaVertices.add(vertice);
        grafo.qntVertices++;
        jTFNome.setText("");
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBVinculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVinculoActionPerformed
        int identificador[] = jTable1.getSelectedRows();
        Object[] opcoes = {"Conhecido(a)", "Colega", "Amigo(a)", "Companheiro(a)", "Familiar", "Outro"};
        Object res = JOptionPane.showInputDialog(null, "Qual é o vínculo?", "Estabelecer vínculo",
                JOptionPane.PLAIN_MESSAGE, null, opcoes, "");
        int peso = 0;
        if (res.equals("Conhecido(a)")) {
            peso = CONHECIDO;
        } else if (res.equals("Colega")) {
            peso = COLEGA;
        } else if (res.equals("Amigo(a)")) {
            peso = AMIGO;
        } else if (res.equals("Companheiro(a)")) {
            peso = COMPANHEIRO;
        } else if (res.equals("Familiar")) {
            peso = FAMILIAR;
        } else if (res.equals("Outro")) {
            peso = OUTRO;
        }
        Vertice vertice1 = grafo.listaVertices.get(identificador[0]);
        Vertice vertice2 = grafo.listaVertices.get(identificador[1]);
        Adjacencia adj1 = new Adjacencia(vertice2, peso);
        Adjacencia adj2 = new Adjacencia(vertice1, peso);
        vertice1.listaAdjacencia.add(adj1);
        vertice2.listaAdjacencia.add(adj2);
        String adjacencias1 = (String) jTable1.getValueAt(identificador[0], 2);
        String adjacencias2 = (String) jTable1.getValueAt(identificador[1], 2);
        jTable1.setValueAt(adjacencias1 + vertice2.nome + ": " + peso + " | ", identificador[0], 2);
        jTable1.setValueAt(adjacencias2 + vertice1.nome + ": " + peso + " | ", identificador[1], 2);
        grafo.qntArestas++;
    }//GEN-LAST:event_jBVinculoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String texto = "";
        texto += "Qnt. Vértices: " + grafo.qntVertices + " Qnt. Arestas: " + grafo.qntArestas + "\n";
        for (int i = 0; i < grafo.qntVertices; i++) {
            Vertice vertice = grafo.listaVertices.get(i);
            texto += vertice.identificador + ": ";
            if (vertice.listaAdjacencia.isEmpty()) {
                texto += " Não há adjacências\n";
            } else {
                for (int j = 0; j < vertice.listaAdjacencia.size(); j++) {
                    Adjacencia adj = vertice.listaAdjacencia.get(j);
                    texto += adj.vertice.identificador + "(" + adj.peso + ") ";
                }
                texto += "\n";
            }
        }
        JOptionPane.showMessageDialog(rootPane, texto);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBMenorCaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMenorCaminhoActionPerformed
        int rows[] = jTable1.getSelectedRows();
        int dist = grafo.distanciaEntrePessoas(rows[0],rows[1]);
        dist--;
        String texto;
        if(dist<0){
            texto = grafo.listaVertices.get(rows[0]).nome+" não possui nenhum vínculo com "+grafo.listaVertices.get(rows[1]).nome;
        }else if(dist==0){
            texto = grafo.listaVertices.get(rows[0]).nome+" conhece diretamente "+grafo.listaVertices.get(rows[1]).nome;
        }else{
            texto = grafo.listaVertices.get(rows[0]).nome+" está a "+dist+" pessoa(s) distante de "+grafo.listaVertices.get(rows[1]).nome;
        }
        
        JOptionPane.showMessageDialog(rootPane, texto);
    }//GEN-LAST:event_jBMenorCaminhoActionPerformed

    

    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBMenorCaminho;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JButton jBVinculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
