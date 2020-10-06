/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExThread;


public class Ponte {

    
    
    
    
    public synchronized void atravessarA(Ambulancia ambulancia) throws InterruptedException{   
        System.out.println("Ambulancia está passando");
        notify();  
    } 
    public synchronized void atravessarP(Policia policia) throws InterruptedException{   
        System.out.println("Policia está passando");
        notify();  
    } 
    public synchronized void atravessarC(Comum comum) throws InterruptedException{   
        System.out.println("Comum está passando");
        notify();  
    } 
}
    

