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
public class Comum extends Thread{
    
    Ponte ponte = new Ponte();

    @Override
    public void run(){
        
        try {
            ponte.atravessarC(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Comum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
