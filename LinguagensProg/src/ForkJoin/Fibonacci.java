/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForkJoin;

import java.util.Scanner;
import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Long> {

    long n;
    boolean dividido;
    
    public Fibonacci(long n, boolean dividido) {
        this.n = n;
        this.dividido = dividido;
    }

    @Override
    protected Long compute() {
        if (dividido == true) {
            return this.fibo(n);
        }
        Fibonacci f1 = new Fibonacci(n - 1, true);
        Fibonacci f2 = new Fibonacci(n - 2, true);
        f1.fork();
        f2.fork();
        long f1R = f1.join();
        long f2R = f2.join();
        return f1R + f2R;
    }

    public long fibo(long n){
        if (n <= 1) {
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
    
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