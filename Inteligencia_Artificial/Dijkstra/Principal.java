/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Principal {
    
    public static void main(String[] args) {
        
        Dijkstra dj = new Dijkstra();
        dj.inicializaGrafo();
        Scanner sc = new Scanner(System.in);
        String origem;
        String destino;
        
        while(true){
            System.out.println("Digite # caso queria sair.");
            System.out.println("");
            System.out.print("Qual sua Origem: ");
            origem = sc.next();
            
            if(origem.equals("#"))
                break;
            
            System.out.print("Qual seu Destino: ");
            destino = sc.next();
            
            if(dj.contem(origem) && dj.contem(destino)){ 
                
                int keyOrigem = dj.obterIndice(origem);
                int keyDestino = dj.obterIndice(destino); 
                dj.caminho(keyOrigem,keyDestino);
                
            }else{
                System.out.println("impossivel");
            }
        }
    }
}
