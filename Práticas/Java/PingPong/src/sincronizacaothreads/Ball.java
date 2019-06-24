/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sincronizacaothreads;

/**
 *
 * @author danie
 */
public class Ball {
    String turn;
    Ball(String turn){
        this.turn=turn;
    }
    
    String getTurn(){
        return this.turn;
    }
    
    synchronized void setTurn(String turn){
        this.notifyAll();
        this.turn=turn;
        
    }
    
    synchronized void waitTurn(String t) throws InterruptedException{
        long count = 0;
        while(!turn.equals(t)){
            this.wait();
            count++;
        }
        System.out.println("Count "+count);
        
    }
}
