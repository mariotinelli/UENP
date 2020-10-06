/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacaoThread;



// Criada uma classe veiculo que recebe os atributos de uma Thread.
public class Veiculo extends Thread {
    
    String tipo;
    Ponte ponte = new Ponte();
    
    public Veiculo(String tipo, Ponte ponte){
        this.tipo = tipo;
        this.ponte = ponte;
    }

    
    // Toda classe que recebe Thread necessita sobrecarregar o método run. Que é o método padrão de uma Thread.
    @Override
    public void run(){       

        //Quando eu der um .start() em uma Thread esse método será executado.
            synchronized (this){
                try {
                    /* Cada Veiculo criado, executa este métido run(), após inicializado pelo .start();
                    e quando inicializa será chama o método atravessar da Classe ponte.  */
                    ponte.atravessar(this);
                } catch (InterruptedException ex) {
                    
                }
            }

    }
    
    
}
