/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForkJoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Mario
 */
public class ProcuraPar extends RecursiveTask<Long>{
    
    //List<Integer> array = new ArrayList();
    long [] array;
    long inicio;
    long fim;
    boolean dividido;
            
    public ProcuraPar(long [] array, long inicio, long fim, boolean dividido) {
        this.array = array;
        this.inicio = inicio;
        this.fim = fim;
        this.dividido = dividido;
    }
    
    public ProcuraPar() {
        
    }

   // private static final int MAXIMO = 500;
    //int tam = 500;
    //long temp = 50;
    
    @Override
    protected Long compute(){   
        if (dividido == true){
            return this.contaParesVetor(array);
        }        
        ProcuraPar pp1 = new ProcuraPar(array, 0, array.length/2, true);
        ProcuraPar pp2 = new ProcuraPar(array, array.length/2, array.length, true);
        pp1.fork();
        pp2.fork();
        long pp1Resultado = pp1.join(); 
        long pp2Resultado = pp2.join();    
        return pp1Resultado + pp2Resultado; 
    }

    public Long contaParesVetor(long [] array){
        long total = 0;
        for (int i = (int) inicio; i < fim; i++) {
            if (array[i] % 2 == 0){
                total++;
            }
        }
        return total;
    }

    
    
    
}
