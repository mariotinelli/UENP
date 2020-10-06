/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExPonte;

/* Esse é um problema onde existe uma ponte onde é uma única mão, e é preciso ser criado thread onde um veiculo de prioridade menor
espera o de prioridade maior */
// A ambulância tem maior prioridade, policia tem prioridade menor que a ambulancia, mas maior que o veiculo comun.


public class Principal {
    
    public static void main(String[] args) {
        Ponte p = new Ponte();
        Veiculo v1 = new Veiculo("Comum", p);
        Veiculo v2 = new Veiculo("Comum", p);
        Veiculo v4 = new Veiculo("Ambulância", p);
        v4.setPriority(10);
        Veiculo v3 = new Veiculo("Polícia", p);
        v3.setPriority(9);
        v1.start();
        v2.start();
        v3.start();
        v4.start();
        
    }
}
