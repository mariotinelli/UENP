/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExThread;

/**
 *
 * @author Mario
 */
public class Principal {
    
    public static void main(String[] args) {
        
        Ambulancia ambulancia1 = new Ambulancia();
        Ambulancia ambulancia2 = new Ambulancia();
        Policia policia1 = new Policia();
        Policia policia2 = new Policia();
        Comum comum1 = new Comum();
        Comum comum2 = new Comum();
        
        ambulancia1.setPriority(10);
        ambulancia2.setPriority(10);
        policia1.setPriority(9);
        policia2.setPriority(9);
        
        ambulancia1.start();
        ambulancia2.start();
        policia1.start();
        policia2.start();
        comum1.start();
        comum2.start();


        
    }
    
}
