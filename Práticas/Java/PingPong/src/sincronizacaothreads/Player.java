/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sincronizacaothreads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class Player extends Thread{
    Ball b;
    Player mate; //parceiro de jogo
    
    Player(Ball b){
        this.b=b;
    }
    
    void setMate(Player mate){
        this.mate=mate;
    }
    
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            try {
                b.waitTurn(getName());
            } catch (InterruptedException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(getName());
            b.setTurn(mate.getName());
        }
    }
}
