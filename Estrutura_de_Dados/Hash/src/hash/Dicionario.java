/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *
 * @author Cursos
 */
public class Dicionario {
    
    private String chave;
    private String palavra;
    
    public Dicionario(String chave, String palavra){
        this.chave = chave;
        this.palavra = palavra;
    }
    public Dicionario(){
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    
    
    
    
    
}
