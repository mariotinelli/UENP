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
public class Ambulancia extends Thread {
   
    Ponte ponte = new Ponte();

    @Override
    public void run(){
        
        try {
            ponte.atravessarA(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ambulancia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
