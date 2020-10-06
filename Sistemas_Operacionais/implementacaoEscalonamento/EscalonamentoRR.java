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
 * - Caso queira tirar o thread sleep é so apagar ou comentar a linha 33.
 * 
 */
public class EscalonamentoRR {
    
    static final int quantum = 30;
    
    
    // Método criado para o escalonamento Round-Robin
    public List<Processos> escRR(List<Processos> processos) throws InterruptedException{
        
        // Criei um array para a fila pronto recebendo o a fila criada no método listaPronto() na linha 78.
        List<Processos> listaPronto = this.listaPronto(processos);
        
        // Como o RR é uma fila circular eu criei um while onde roda sempre que fila pronto não esteja vazia
        while (!listaPronto.isEmpty()){
            // Como é um fila circular, cada execução eu removo o processo da fila e armazeno em uma variável temporária da classe Processo.
            Processos p = listaPronto.remove(0);
            //System.out.println("Executando o processo " + p.id + " e foi executado " + p.contExec); 
            Thread.sleep(1000);
            
            /*   
                - A cada execução é acrescentado 30ms de cada processo existende na fila pronto, exceto o processo em execução atualmente.
                - Esse processo é feito por um for percorrendo toda lista de processos e acrescenta em cada um.
                - Como cada processo em execução é excluido da fila então o atual nao recebe. 
            */
            for (Processos lista: listaPronto){
                lista.tempoListaPronto = quantum + lista.tempoListaPronto;
                //System.out.println("Foi imcrementado 30 em seu tempo na fila no pocesso: " + lista.id);
            }
            // Acrescentado +1 na variavel contExec (contagem de execuções do processo).
            p.contExec++;
            // Imprime a lista inteira de processos para melhor vizualização do andamento do escalonamento.
            p.imprime(processos);
            System.out.println("-----------------------");
            /* 
            Em um ArrayList sempre que é adicionado algo com o .add, será adicionado no final da lista 
            e como o RR é circular, sempre o primeiro da lista vai para o final. então esse if verifica
            se o processo foi processaco menos de 3 vezes, se sim sera adicionado, se nao ele nao será
            adicionado na lista mais, porque ja terminou seu processamento.
            */
            if (p.contExec < 3){
                listaPronto.add(p);
            }

        }
        return processos; 
    }
    
//    public int comparar(Processos p, List<Processos> process){
//        int pos = -1;
//        for (int i = 0; i < process.size(); i++){
//            if (process.get(i).id == p.id){
//                pos = i;
//            }
//        }
//        return pos;
//    }
     
    
    /* 
    Método listaPronto(), organiza a fila pronto conforme na tabela, organiza de tempo na fila pronto (informados na tabela) 
    maior para menor, sem critério de desempate.
    */
    public List<Processos> listaPronto(List<Processos> processos){

        // criado um ArrayList para amarzenar os processos.
        List<Processos> listaPronto = new ArrayList(); 
        // while até que a listaPronto não seja do tamanho da lista processos, pois se chegar no mesmo tamanho quer dizer que armazenou todos os processos.
        while (listaPronto.size() != processos.size())  {  
            int max = Integer.MIN_VALUE;
            int pos = 0;
            for (int i = 0; i < processos.size(); i++){
                if (!listaPronto.contains(processos.get(i))){
                    if (processos.get(i).tempoEntrada > max ){
                        max = processos.get(i).tempoEntrada;
                        pos = i;
                    }
                }
            }
            listaPronto.add(processos.get(pos));
        }
        return listaPronto;
    }
    
    
    
}
