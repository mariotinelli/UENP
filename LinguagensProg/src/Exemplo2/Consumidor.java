/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exemplo2;

public class Consumidor extends Thread {
    Fila buffer;
    
    public Consumidor(Fila fila){
        buffer = fila; 
    }
    
    @Override
    public void run(){
        int item;
        while (true){
            try {
                item = buffer.retirar();
                System.out.println("Item retirado: "+item);
            } catch (InterruptedException ex) {}           
        }
        
    }
}
