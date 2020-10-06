/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

public class No {
    
    private No proximo;
    private No anterior;
    private Dicionario dic;
    
    public No(Dicionario d){
        this.dic = d;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public Dicionario getDic() {
        return dic;
    }

    public void setDic(Dicionario dic) {
        this.dic = dic;
    }

    
    
}
