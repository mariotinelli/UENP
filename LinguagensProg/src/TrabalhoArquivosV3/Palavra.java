/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoArquivosV3;


/**
 *
 * @author Mario
 */
public class Palavra {
    
    String palavra;
    int quantidade;
    
    public Palavra(String palavra){
        this.palavra = palavra;
        this.quantidade = 1;
    }
    

    @Override
    public String toString() {
        return "Palavra{" + "Palavra = " + palavra + " --> Quantidade = " + quantidade + '}';
    }
    
    
    
}
