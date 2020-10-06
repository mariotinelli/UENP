/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForkJoin;


import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author Mario
 */
public class ParTeste {
    
    static final int TAMANHO = 50000000;
    
    public static void main(String[] args) {
        Random r = new Random();
        long vetor[] = new long[TAMANHO];
        for (int i = 0; i < TAMANHO; i++){
            vetor[i] = r.nextInt(10000000);
        }
        ProcuraPar pp = new ProcuraPar(vetor, 0, TAMANHO, false);
        ProcuraParParalelo ppf = new ProcuraParParalelo(vetor, 0, TAMANHO, false);
//----------------------------------------   
    // Busca de numeros pares em um vetor utilizando filter.    
        long ms = System.currentTimeMillis();
        System.out.println("Filter: " + ppf.contaPares(vetor, 0, TAMANHO) + " pares em " + (System.currentTimeMillis() - ms)+ "ms");
//----------------------------------------  
    //Busca de numeros pares em um vetor utilizando fork join com filter.  
        ms = System.currentTimeMillis();
        System.out.println("ForkJoinFilter: " + ppf.compute() + " pares em " + (System.currentTimeMillis() - ms)+ "ms");
//----------------------------------------  
        //Busca de numeros pares em um vetor utilizando for..  
        ms = System.currentTimeMillis();
        System.out.println("For: " + pp.contaParesVetor(vetor) + " pares em " + (System.currentTimeMillis() - ms)+ "ms");
//---------------------------------------- 
        //Busca de numeros pares em um vetor utilizando fork join com for.  
        ms = System.currentTimeMillis();
        System.out.println("ForkJoinFor: " + pp.compute()+ " pares em " + (System.currentTimeMillis() - ms)+ "ms");
        
        

    }
    
}
