/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exemplo1;

public class Tarefa  {
    String nome;
    
    public Tarefa(String nome){
        this.nome = nome; 
    }
     
    public void run(){
        for (int i=0; i<4; i++){
            System.out.println("Sou a tarefa: "+ nome);
        }
    }
}