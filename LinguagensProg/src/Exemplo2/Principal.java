/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exemplo2;

public class Principal {
   
    public static void main(String[] args) {
       
        Fila buffer = new Fila(100);
        Produtor produtor1 = new Produtor(buffer);
        Produtor produtor2 = new Produtor(buffer);
        Consumidor consumidor1 = new Consumidor(buffer);
        produtor1.start();
        produtor2.start();
        consumidor1.start();
    
    }
}
