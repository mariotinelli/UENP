/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForkJoin;

/**
 *
 * @author Mario
 */
public class Fibo {
    
    public static long fibo(long n){
        if (n < 2) {
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
