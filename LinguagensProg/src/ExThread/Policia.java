/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExThread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class Policia extends Thread{
    
    
    Ponte ponte = new Ponte();

    @Override
    public void run(){
        
        try {
            ponte.atravessarP(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Policia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
