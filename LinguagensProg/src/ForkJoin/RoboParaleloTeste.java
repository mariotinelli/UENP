/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForkJoin;



/**
 *
 * @author Mario
 */
public class RoboParaleloTeste {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        RoboParalelo conta = new RoboParalelo(10, 10, false); System.out.println("criei classe robopar");
        long total = conta.compute(); System.out.println("chamei o compute");
        System.out.println(total);
        System.out.println("Demorou: "+ (System.currentTimeMillis() - inicio) + "ms");
    }
}
