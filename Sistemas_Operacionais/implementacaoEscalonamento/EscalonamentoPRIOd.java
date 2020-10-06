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
 * 
 *  - Usei o método de implementação apresentando em aula, criar 3 filas com prioridades diferentes e cada uma ter uma quantidade de execução.
 *  - Caso queira tirar o thread sleep é so apagar ou comentar a linha 64,86 e 103.
 */
public class EscalonamentoPRIOd {
    
    public static final int quantum = 30;
    public static final int prioridadeAlta = 6;
    public static final int prioridadeMedia = 5;
    public static final int prioridadeBaixa = 3;
    
    // Método para o escalonamento PRIOd.
    public List<Processos> escPRIOd(List<Processos> processos) throws InterruptedException{
        List<Processos> filaAlta = this.filaAlta(processos); // criado a fila com prioridade alta, recebido do método filaAlta
        List<Processos> filaMedia = this.filaMedia(processos); // criado a fila com prioridade media, recebido do método filaMedia
        List<Processos> filaBaixa = this.filaBaixa(processos); // criado a fila com prioridade baixa, recebido do método filaBaixa
        
        Processos p = new Processos(); // variavel temporária.
        
        // while rodará ate que todas as filas estejam vazias.
        while (!filaAlta.isEmpty() || !filaMedia.isEmpty() || !filaBaixa.isEmpty()){
            
            int qntQuantum = 1; // inicilizado um contador para a quantidade de execução de cada fila.
            
            // while que rodará até que a quantidade de execuções E até que a fila esteja vazia.
            while (qntQuantum <= 4 && !filaAlta.isEmpty()){
                //System.out.println("Entrou na fila alta");
                for (Processos process: processos){
                    if (process != filaAlta.get(0) && filaAlta.contains(process)|| filaMedia.contains(process)|| filaBaixa.contains(process)){
                            process.tempoListaPronto += quantum; // acrescentado 30ms em cada processo que esteja na fila e que nao esteja sendo executado.
                        }
                    }
                /* 
                    - Verifica se a quantidade max de execuções é diferente de 0, se sim, é decrementado 1 da mesma.
                    - Essa quantidade de execuções máximas é definida na Classe Processos, no exemplo é definido como 3, conforme solicitado no exercício.
                    - E também é acrescentado 1 na contagem de execuções, para impressão. (Para ter uma boa vizualização do andamento do processo)
                    - Se o processo ainda não foi executado o máximo de vezes, sera acrescentado 1 no contador de execuções da fila,
                      sempre que for feito uma execução, se o processo ja foi executado o máximo de vezes nao será acrescentado no contador,
                      e esse processo será excluido da fila, pois ele já terminou seu processo então não será mais executado.
                    - E se isso acontecer será recebido outro processo para execução (se houver).
                    - Se quantum chegou a sua contagem máxima será feito a leitura da proxima lista.
                    - Esse procedimento será feito em todas as filas, da mesma forma que esse.
                */
                if (filaAlta.get(0).qntExecMax != 0){
                    filaAlta.get(0).qntExecMax--;
                    filaAlta.get(0).contExec++;
                    qntQuantum++;
                    // Impressão da lsita de processo para melhor compreenssão das execuções.
                    p.imprime(processos);
                    Thread.sleep(1000);
                    System.out.println("-----------------");
                    //System.out.println("Processo: " + filaAlta.get(0).id  + " tem prioridade: " + filaAlta.get(0).prioridade + " foi executado " + filaAlta.get(0).contExec);
                }
                else {filaAlta.remove(0);}
            }


            qntQuantum = 1;
            // while que rodará até que a quantidade de execuções E até que a fila esteja vazia.
            while (qntQuantum <= 2 && !filaMedia.isEmpty()){
                //System.out.println("Entrou na fila media");
                for (Processos process: processos){
                        if (process != filaMedia.get(0) && filaAlta.contains(process)|| filaMedia.contains(process)|| filaBaixa.contains(process)){
                            process.tempoListaPronto += quantum;
                        }
                }
                if (filaMedia.get(0).qntExecMax != 0){
                    filaMedia.get(0).qntExecMax--;
                    filaMedia.get(0).contExec++;
                    qntQuantum++;
                    p.imprime(processos);
                    Thread.sleep(1000);                        
                    System.out.println("-----------------");                    
                    //System.out.println("Processo: " + filaMedia.get(0).id  + " tem prioridade: " + filaMedia.get(0).prioridade + " foi executado " + filaMedia.get(0).contExec);
                }
                else {filaMedia.remove(0);}
            }
            

            qntQuantum = 1;
            // while que rodará até que a quantidade de execuções E até que a fila esteja vazia.
            while (qntQuantum <= 1 && !filaBaixa.isEmpty()){
                //System.out.println("Entrou na fila baixa");
                if (filaBaixa.get(0).qntExecMax != 0){
                    filaBaixa.get(0).qntExecMax--;
                    filaBaixa.get(0).contExec++;
                    qntQuantum++;
                    p.imprime(processos);
                    Thread.sleep(1000);
                    for (Processos process: processos){
                        if (process != filaBaixa.get(0) && filaAlta.contains(process)|| filaMedia.contains(process)|| filaBaixa.contains(process)){
                            process.tempoListaPronto += quantum;
                        }
                    }
                    System.out.println("-----------------");
                    //System.out.println("Processo: " + filaBaixa.get(0).id  + " tem prioridade: " + filaBaixa.get(0).prioridade + " foi executado " + filaBaixa.get(0).contExec);
                }
                else {filaBaixa.remove(0);}
            }
            
        }
        
        return processos;
    }
    
    // Ordenação dos processos por prioridade mais alta.
    public List<Processos> ordenaPrioridade (List<Processos> fila){
        List<Processos> filaPronto = new ArrayList();
        while (!fila.isEmpty())  {  
            int pos = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < fila.size(); i++){
                if (fila.get(i).prioridade > max && !filaPronto.contains(fila.get(i))){
                    max = fila.get(i).prioridade;
                    pos = i;
                }
            }
            filaPronto.add(fila.get(pos));
            fila.remove(pos);
        }
        
        return filaPronto;
    }
    
    // Preenchimento da filaAlta com as prioridades maiores ou igual a 6, conforme definido na variável prioridadeAlta no inicio da classe.
    public List<Processos> filaAlta(List<Processos> processos){
        
        List<Processos> filaProntoAux = new ArrayList();
        for (Processos process: processos){
            if (process.prioridade >= prioridadeAlta){
                filaProntoAux.add(process);
            }
        }
        // Esse preenchimento não é ordenado em prioridade, então é usado o método ordenaPrioridade() para ordenar essa fila.
        List<Processos> filaPronto = this.ordenaPrioridade(filaProntoAux);
        
        return filaPronto;
    }
    
    // Preenchimento da filaMedia com as prioridades maiores que 3 e menores que 6, conforme nas variáveis já citadas.
    public List<Processos> filaMedia(List<Processos> processos){
        
        List<Processos> filaProntoAux = new ArrayList();
        for (Processos process: processos){
            if (process.prioridade > prioridadeBaixa && process.prioridade < prioridadeAlta){
                filaProntoAux.add(process);
            }
        }
        // Esse preenchimento não é ordenado em prioridade, então é usado o método ordenaPrioridade() para ordenar essa fila.
        List<Processos> filaPronto = this.ordenaPrioridade(filaProntoAux);
        
        return filaPronto;
    }
    
    // Preenchimento da filaBaixa com as prioridades menores ou iguais a 3, conforme definido na variável prioridadeBaixa no inicio da classe.
    public List<Processos> filaBaixa(List<Processos> processos){
        
        List<Processos> filaProntoAux = new ArrayList();
        for (Processos process: processos){
            if (process.prioridade <= prioridadeBaixa){
                filaProntoAux.add(process);
            }
        }
        
        // Esse preenchimento não é ordenado em prioridade, então é usado o método ordenaPrioridade() para ordenar essa fila.
        List<Processos> filaPronto = this.ordenaPrioridade(filaProntoAux);
        
        return filaPronto;
    }
    
}
