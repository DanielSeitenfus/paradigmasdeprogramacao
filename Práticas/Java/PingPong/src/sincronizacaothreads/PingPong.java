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
public class PingPong {
    public static void main(String[] args){
        Ball bola = new Ball("ping");
        Player pinger = new Player(bola);
        Player ponger = new Player(bola);
        
        pinger.setName("ping");
        ponger.setName("pong");
        pinger.setMate(ponger);
        ponger.setMate(pinger);
        
        pinger.start();
        ponger.start();
        
        
    }
}
