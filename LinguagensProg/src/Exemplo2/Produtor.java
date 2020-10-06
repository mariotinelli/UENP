/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exemplo2;

import java.util.Random;

public class Produtor extends Thread{
    Fila buffer;

    public Produtor(Fila fila){
        buffer = fila;
    }

    
    @Override
    public void run(){
        int novoItem;
        Random random = new Random();
        while (true){
            novoItem = random.nextInt(100);
            buffer.depositar(novoItem);
            System.out.println("Item depositado: "+ novoItem);
        }
    }
}
