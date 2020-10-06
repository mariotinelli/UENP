/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacaoThread;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/* Esse é um problema onde existe uma ponte onde é uma única mão, e é preciso ser criado thread onde um veiculo de prioridade menor
espera o de prioridade maior 
  - A ambulância tem maior prioridade, policia tem prioridade menor que a ambulancia, mas maior que o veiculo comun.
  - Como a Ambulância tem a maior prioridade ela será que a mais executada, caso seja um array infinito de veiculos.
  - No exemplo com 100 veiculos, da para perceber que no inicio a Ambulância é sempre a mais executada que os outros veiculos,
    por isso ela será finalaza antes, então os outros veiculos poderão ser executados.
  - O objetivo do exercicio era mostrar em exemplo simples usando a Thread, eu utilizo a Thread na classe Veiculo, onde eu seto
    prioridades a cada um, conforme necessitam. E inicio a passagem deles na ponte com objetivo de que a Ambulância sempre tenha mais
    prioridade que os outros veiculos.

Obs:

  - Caso o exemplo não seja muito bom ou não seja o certo para o exercicío solicitado, posso tentar procurar outro, abraço!!

*/


public class Principal {
    

    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        Ponte ponte = new Ponte();
        List<Veiculo> veiculos = new ArrayList();
        
        // Criar em array do tipo Veiculo do tamanho estipulado na classe ponte.
        for (int cont = 0; cont < ponte.MAXVEICULOS; cont ++){    
            int randomTipo = r.nextInt(3)+1;
            String tipo;
            switch (randomTipo){
                case 1:
                    // Cria um veiculo do tipo ambulancia quando a o random é 1.
                    if (randomTipo == 1){
                        tipo = "Ambulância";
                        Veiculo veiculo = new Veiculo(tipo, ponte);
                        veiculos.add(cont, veiculo);
                        // Setando a prioridade 10 no meu veiculo Ambulancia, pois ele tem maior prioridade.
                        veiculos.get(cont).setPriority(Thread.MAX_PRIORITY);
                    }
                case 2:
                    // Cria um veiculo do tipo policia quando o random é 2.
                    if (randomTipo == 2){
                        tipo = "Policia";
                        Veiculo veiculo = new Veiculo(tipo, ponte);
                        veiculos.add(cont, veiculo);
                        // Setando a prioridade 9 na policia pois tem uma prioridade alta, mas nao maior que a ambulancia.
                        veiculos.get(cont).setPriority(6);
                    }
                case 3:
                    // Cria um veiculo do tipo comum quando é 3.
                    if (randomTipo == 3){
                        tipo = "Comum";
                        Veiculo veiculo = new Veiculo(tipo, ponte);
                        veiculos.add(cont, veiculo);
                        // Setando prioridade 1 pois o veiculo comum tem a menos prioridade
                        veiculos.get(cont).setPriority(1);
                    }
            }
            // Imprime cada posição do array detalhando o tipo e a prioridade criada.
            //System.out.println("Random: " + randomTipo + " || Tipo: " + veiculos.get(cont).tipo + " || Prioridade: "+ veiculos.get(cont).getPriority());
        }

//      Leitura do array de veiculos criados.  ( um FOR na forma funcional )
        veiculos.forEach((veiculo) -> {
//          Iniciando cada thread criada, o metodo .start(); inicia o método run contido na classe Veiculo que é extendida da classe Thread
            veiculo.start();
        });

    }
}
