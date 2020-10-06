/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

public class ListaDupEncad {
    
    No inicio;
    No fim;
    
    
    public boolean isEmpty(){
        return inicio == null;
    }
    
    public void insere(No n){
        if (isEmpty()){
            inicio = n;
            fim = n;
        }
        
        else if (inicio.getProximo() == null){
            fim = n;
            inicio.setProximo(fim);
            fim.setAnterior(inicio);
        }    
        else {
            fim.setProximo(n);
            n.setAnterior(fim);
            fim = n;
        }
    }
    
    public void imprime(){
        No aux = inicio;
        while (aux!=null){
            Dicionario d = aux.getDic();
            System.out.println("Palavra: "+d.getChave()+" Tradução: "+d.getPalavra());
            aux = aux.getProximo();
        }
    }
    
    public No busca (String b){
        No auxiliar = this.inicio;        
        while(auxiliar != null){ // auxiliar.proximo!=null
            Dicionario d = auxiliar.getDic();
            if(d.getChave().equals(b)){
                return auxiliar;
            }
            auxiliar = auxiliar.getProximo();
        }
        return null;        
    }
    
    public void remove(String rem){
        No temp = busca(rem);
        if ( inicio == fim && temp != null ){
            inicio = null;
            fim = null;
        } 
        
        else if ( temp == inicio ){
            inicio = temp.getProximo();
            temp.setProximo(null);
            temp.getProximo().setAnterior(null);

        }
        else if (temp == fim){
            fim = temp.getAnterior();
            temp.setAnterior(null);
            temp.getAnterior().setProximo(null);
        }
        else if (temp!=null){
            No ant = temp.getAnterior();
            No prox = temp.getProximo();
            ant.setProximo(prox);
            temp.setProximo(null);
            prox.setAnterior(ant);
            temp.setAnterior(null);
        }
        else {
            System.out.println("Elemento não encontrado");
        }
    }
    
    public void limpaLista(){
        inicio = null;
        fim = null;
    }

}
