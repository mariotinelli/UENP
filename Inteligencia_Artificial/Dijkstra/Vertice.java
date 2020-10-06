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
public class Vertice{
    
    private String cidade;
    private boolean cidadeInserida;

    public Vertice(String cidade){
        this.cidade = cidade;
        this.cidadeInserida = false;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public boolean isCidadeInserida() {
        return cidadeInserida;
    }

    public void setCidadeInserida(boolean cidadeInserida) {
        this.cidadeInserida = cidadeInserida;
    }

    @Override
    public String toString() {
        return "Vertice{" + "cidade=" + cidade + ", cidadeInserida=" + cidadeInserida + '}';
    }

    
    
    
}
