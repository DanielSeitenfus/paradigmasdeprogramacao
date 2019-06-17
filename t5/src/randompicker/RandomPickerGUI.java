/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randompicker;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class RandomPickerGUI extends javax.swing.JFrame implements InterfaceView{
    Controller controller;

    public RandomPickerGUI() {
        initComponents();
        controller = new Controller(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jBSuffle = new javax.swing.JButton();
        jBNext = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMFile = new javax.swing.JMenu();
        jMIOpen = new javax.swing.JMenuItem();
        jMIExit = new javax.swing.JMenuItem();
        jMHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jBSuffle.setText("Suffle");
        jBSuffle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSuffleActionPerformed(evt);
            }
        });

        jBNext.setText("Next");
        jBNext.setEnabled(false);
        jBNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNextActionPerformed(evt);
            }
        });

        jMFile.setText("File");

        jMIOpen.setText("Open");
        jMIOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIOpenActionPerformed(evt);
            }
        });
        jMFile.add(jMIOpen);

        jMIExit.setText("Exit");
        jMIExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIExitActionPerformed(evt);
            }
        });
        jMFile.add(jMIExit);

        jMenuBar1.add(jMFile);

        jMHelp.setText("Help");
        jMenuBar1.add(jMHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jBSuffle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBNext, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSuffle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBNext)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIOpenActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int valor = fileChooser.showOpenDialog(this);
        File file = null;
        if (valor == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        try {
            controller.leArquivo(file);
        } catch (IOException ex) {
            Logger.getLogger(RandomPickerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMIOpenActionPerformed

    private void jMIExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMIExitActionPerformed

    private void jBSuffleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSuffleActionPerformed
        if(!jTextArea1.getText().equals("")){
            jBNext.setEnabled(true);
            try {
                controller.random(jTextArea1.getText());
            } catch (IOException ex) {
                Logger.getLogger(RandomPickerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Informe nomes na área de texto!");
        }
        
    }//GEN-LAST:event_jBSuffleActionPerformed

    private void jBNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNextActionPerformed
        controller.next();
    }//GEN-LAST:event_jBNextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RandomPickerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBNext;
    private javax.swing.JButton jBSuffle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMFile;
    private javax.swing.JMenu jMHelp;
    private javax.swing.JMenuItem jMIExit;
    private javax.swing.JMenuItem jMIOpen;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    @Override
    public SwingAppendableText getTextArea() {
        return new SwingAppendableText(jTextArea1);
    }

    @Override
    public SwingAppendableText getLabel() {
        return new SwingAppendableText(jLabel1);
    }

    @Override
    public SwingAppendableText getJBNext() {
        return new SwingAppendableText(jBNext);
    }
    
    class SwingAppendableText {
        private JTextArea textArea;
        private JLabel label;
        private JButton jBNext;
        public SwingAppendableText(JTextArea textArea) {
          this.textArea = textArea;
        }
        
        public SwingAppendableText(JLabel label) {
          this.label = label;
        }
        public SwingAppendableText(JButton jBNext) {
          this.jBNext = jBNext;
        }
        
        public void append(final String s) {
          textArea.append(s);
        }
        
        public void setText(final String s){
           label.setText(s);
        }
        
        public void setEnableButton(boolean enable){
            jBNext.setEnabled(enable);
        }
    }

}
