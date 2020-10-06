/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacaoBFS;


public class Aresta {
    
    private No de;
    private No para;
    private int custo;
    public boolean arestaInserida = false;

    public Aresta(No de, No para, int custo) {
        this.de = de;
        this.para = para;
        this.custo = custo;
        arestaInserida = true;
    }


    
    public No getDe() {
        return de;
    }

    public void setDe(No de) {
        this.de = de;
    }

    public No getPara() {
        return para;
    }

    public void setPara(No para) {
        this.para = para;
    }
    

//    @Override
//    public String toString() {
//        return "Aresta{" + "de=" + de + ", para=" + para + ", custo=" + custo + '}';
//    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    
    
    
    
}
