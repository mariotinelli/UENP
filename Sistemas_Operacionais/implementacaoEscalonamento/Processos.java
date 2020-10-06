/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacaoEscalonamento;


import java.util.List;


/**
 *
 * @author Mario
 * - Classe processos
 * 
 */
public class Processos{
    
    int id; // id do processo
    int tempoEntrada; // tempo de entrada (tempo na lista pronto da tabela)
    int tempoListaPronto = 0; // contador do tempo que o processo ficará na fila pronto
    int prioridade; // prioridade do processo
    int contExec = 0; // contador de quantas vezes o processo foi executado
    int qntExecMax = 3; // quantidade limite de execuções de cada processo

    
    public Processos(int id, int tempoEntrada, int prioridade) {
        this.id = id;
        this.tempoEntrada = tempoEntrada;
        this.prioridade = prioridade;
    }

    public Processos() {}
        
    // Impressão dos processos indicando seu id, prioridade, tempo que ficou na fila pronto, e sua quantidade de execução.
    public void imprime(List<Processos> processos) {
        processos.forEach((process) -> {
            System.out.println("Processos{" +   "Processo = " + process.id + 
                    " Prioridade = " + process.prioridade + 
                    ", Tempo na fila pronto = " + process.tempoListaPronto +
                    ", Executou = " + process.contExec +
                    " vezes" +  '}');
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Processos.class.getName()).log(Level.SEVERE, null, ex);
//            }
        });
    }

    
}
