/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randompicker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class Controller {
    Model model;
    InterfaceView view;
    Controller(InterfaceView view){
        this.view=view;
        model = new Model(view.getTextArea(), view.getLabel(), view.getJBNext());
    }
    
    void leArquivo(File file) throws IOException{
        model.leArquivo(file);
    }
    
    void random(String nomes){
        model.random(nomes);
    }
    
    void next(){
        model.next();
    }
}
