/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacaoThread;




public class Ponte {
    
    public int MAXVEICULOS = 100;
    
    public synchronized void atravessar(Veiculo veiculo) throws InterruptedException{
        // imprime qual veiculo está passando na ponte no momento.
        System.out.println(veiculo.tipo + " está passando");
        
        for(int i = 0; i < 15; i++){
            System.out.print("-");
            //Thread.sleep(100);
        }
        System.out.println(" ");

    }
    
}
