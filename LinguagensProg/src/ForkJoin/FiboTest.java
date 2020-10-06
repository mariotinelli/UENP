/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForkJoin;

import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author Mario
 */
public class FiboTest {
    
    public static void main(String[] args) {

        long ms = System.currentTimeMillis();
        System.out.println(Fibo.fibo(45));
        System.out.println("Sem Fork: " + (System.currentTimeMillis() - ms));
        
        ms = System.currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci(45, false);
        System.out.println(fibonacci.compute());
        System.out.println("Com Fork: " + (System.currentTimeMillis() - ms));
        
    }
    
}
