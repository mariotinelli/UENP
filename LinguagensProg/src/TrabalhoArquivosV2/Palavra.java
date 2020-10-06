/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoArquivosV2;

/**
 *
 * @author Mario
 */
public class Palavra {
    
    String palavra;
    int quantidade;
    boolean inserido;
    
    public Palavra(String palavra){
        this.palavra = palavra;
        this.quantidade = 1;
        inserido = true;
    }
    
    
    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Palavra{" + "Palavra = " + palavra + " --> Quantidade = " + quantidade + '}';
    }
    
    
    
}
