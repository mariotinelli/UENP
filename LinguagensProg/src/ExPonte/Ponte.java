/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExPonte;

import java.util.List;



public class Ponte {
    
    public synchronized void atravessar(Veiculo v) throws InterruptedException{
        System.out.println(v.getName()+ " está passando");
        for (int i=1; i < 11; i++){
            System.out.print(i + " ");
            Thread.sleep(1000);
        }
        System.out.println("");
    }
    
}
    

