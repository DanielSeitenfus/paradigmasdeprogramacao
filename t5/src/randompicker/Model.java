/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randompicker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import randompicker.RandomPickerGUI.SwingAppendableText;

/**
 *
 * @author danie
 */
public class Model {
    SwingAppendableText textArea, label, next;
    ArrayList<String> listaNomes;
    int indice;
    Model(SwingAppendableText textArea, SwingAppendableText label, SwingAppendableText next){
        this.textArea = textArea;
        this.label = label;
        this.next = next;
        indice=0;
    }
    
    void random(String nomes){
        String[] vetNomes = nomes.split("\n");
        List lista =Arrays.asList(vetNomes);
        listaNomes = new ArrayList<>(lista);
        boolean online=false;
        if(online){
            
        }else{
            Collections.shuffle(listaNomes);
        }
    }
    
    void next(){
        label.setText(listaNomes.get(indice));
        if(listaNomes.size()-1!=indice){
            indice++;
        }else{
            next.setEnableButton(false);
            indice=0;
        }
    }
    
    void leArquivo(File file) throws FileNotFoundException, IOException{
        listaNomes = new ArrayList<>();
        BufferedReader buff = new BufferedReader(new FileReader(file));
        String linha;
        while ((linha = buff.readLine()) != null) {
             textArea.append(linha+"\n");
             listaNomes.add(linha);
        }
        
    }
}
