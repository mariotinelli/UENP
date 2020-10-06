/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForkJoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;


/**
 *
 * @author Mario
 */
public class ProcuraParParalelo extends RecursiveTask<Long>{
    
    long [] array;
    long inicio;
    long fim;
    boolean dividido;

    public ProcuraParParalelo(long [] array, long inicio, long fim, boolean dividido) {
        this.array = array;
        this.inicio = inicio;
        this.fim = fim;
        this.dividido = dividido;
    }
    
    @Override
    protected Long compute(){  
//        System.out.println(inicio);
        if (dividido == true){
            return Arrays.stream(array).filter(e -> e % 2 == 0).skip(inicio).limit(fim).count();
        } 
        ProcuraParParalelo ppf1 = new ProcuraParParalelo(array, inicio, fim/2, true);
        ProcuraParParalelo ppf2 = new ProcuraParParalelo(array, fim/2, fim, true);

        ppf1.fork();
        ppf2.fork();
        long r1 = ppf1.join();
        long r2 = ppf2.join();
        return r1 + r2;
    }

    public Long contaPares(long [] array, long inicio, long fim) {
        long total = Arrays.stream(array).filter(e -> e % 2 == 0).skip(inicio).limit(fim).count();
        return total;
    }
    
    
    
}
