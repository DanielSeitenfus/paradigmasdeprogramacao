/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randompicker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import randompicker.RandomPickerGUI.SwingAppendableText;

/**
 *
 * @author danie
 */
public class Model {
    SwingAppendableText textArea, label, next;
    int cont=0;
    Embaralhamento embaralhamento;
    Model(SwingAppendableText textArea, SwingAppendableText label, SwingAppendableText next){
        this.textArea = textArea;
        this.label = label;
        this.next = next;
        embaralhamento = new Embaralhamento();
    }
    
    void random(String nomes) throws IOException{
        embaralhamento.random(nomes);
        label.setText("");
    }
    
    void next(){
        String nome=embaralhamento.next();
        cont++;
        if(cont==embaralhamento.getListaNomes().size()){
            next.setEnableButton(false);
            cont=0;
        }
        label.setText(nome);
    }
    
    void leArquivo(File file) throws FileNotFoundException, IOException{
        embaralhamento.leArquivo(file);
        for(String nome : embaralhamento.getListaNomes()){
            textArea.append(nome+"\n");
        }
    }
}
