/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;



/**
 *
 * @author Mario
 */
public class Pai {
    
    private int custo;           
    private int noPai;      
    
    public Pai(int noPai, int custo){
        this.custo = custo;
        this.noPai = noPai;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public int getNoPai() {
        return noPai;
    }

    public void setNoPai(int noPai) {
        this.noPai = noPai;
    }

    @Override
    public String toString() {
        return "Pai{" + "custo=" + custo + ", noPai=" + noPai + '}';
    }
    
    
    
    
}

