/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForkJoin;



public class RoboTeste {
    public static void main(String[] args) {
        // Robo convencional
        long inicio = System.currentTimeMillis();
        System.out.println("Caminhos (20, 20): " + (Robo.contar(15, 15)));
        System.out.println("Robô convencional: "+ (System.currentTimeMillis() - inicio));
        
        // Robo paralelo
        inicio = System.currentTimeMillis();
        RoboParalelo conta = new RoboParalelo(15, 15, false);
        long total = conta.compute();
        //System.out.println(total);
        System.out.println("Robô paralelo....: "+ (System.currentTimeMillis() - inicio));
    }
}
