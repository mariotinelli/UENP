/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacaoEscalonamento;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Mario
 */
public class TestePRIOd {
    
    public static void main(String[] args) throws InterruptedException {
        
        List<Processos> processos = new ArrayList();
        // Criados os processos conforme na tabela os parãmetros são (ID, TEMPO_NA_LISTA_PRONTO, PRIORIDADE)
        processos.add(new Processos(0 ,200, 1));// p0
        processos.add(new Processos(1, 300, 3));// p1
        processos.add(new Processos(2, 250, 2));// p2
        processos.add(new Processos(3, 100, 5));// p3
        processos.add(new Processos(4, 200, 8));// p4
        processos.add(new Processos(5, 250, 3));// p5
        processos.add(new Processos(6, 150, 1));// p6
        processos.add(new Processos(7, 100, 1));// p7
        processos.add(new Processos(8, 200, 4));// p8
        processos.add(new Processos(9, 300, 6));// p9
        
        
                
        EscalonamentoPRIOd priod = new EscalonamentoPRIOd();
        List<Processos> escPriod = priod.escPRIOd(processos);
        Processos p2 = new Processos();
        p2.imprime(escPriod);
        
    }
    
}
