/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Dijkstra {
    
    public final int numVertices = 30; // número máximo de vertices
    public final int INFINITO = 2000000;
    public Vertice listaVertices[];                                            
    public int matrizAdjacente[][];                                                     
    public int contVertices;                                                         
    public int verticeAtual;
    public int contTotal;                                                        
    public Pai[] menorCaminho;
    public int inicioDoAtual;
    public int custoTotal;

    public Dijkstra(){
        listaVertices = new Vertice[numVertices]; 
        matrizAdjacente = new int[numVertices][numVertices];                                 
        contVertices = 0;
        contTotal = 0;
        for(int j=0; j<numVertices; j++){
            for(int k=0; k<numVertices; k++){
                matrizAdjacente[j][k] = INFINITO;
            }
        }
        menorCaminho = new Pai[numVertices];
        custoTotal = 0;
    }
    public void addVertice(String cid){
        listaVertices[contVertices++] = new Vertice(cid);
    }
    public void addAresta(Integer origem, Integer destino, Integer custo){
        matrizAdjacente[origem][destino] = custo;                                             
        matrizAdjacente[destino][origem] = custo;
    }
    
    public void caminho(int inicio, int fim){                                   
            
        int inicioGrafo = inicio;                                               
        listaVertices[inicioGrafo].setCidadeInserida(true);
        contTotal = 1;                                                             

        for(int j=0; j<contVertices; j++){
            int tempDist = matrizAdjacente[inicioGrafo][j];
            menorCaminho[j] = new Pai(inicioGrafo, tempDist);
        }

        while(contTotal < contVertices){
            int indexMin = obterMenor();                                        
            int minDist = menorCaminho[indexMin].getCusto();

            verticeAtual = indexMin;
            inicioDoAtual = menorCaminho[indexMin].getCusto();
            listaVertices[verticeAtual].setCidadeInserida(true);
            contTotal++;
            ajusteCaminho();
        }
        
        exibirCaminho(inicio,fim);
        contTotal = 0;
        for(int j=0; j<contVertices; j++){
            listaVertices[j].setCidadeInserida(false);
        }        
    }
    
    public int obterMenor(){                                                    
        int minDist = INFINITO;                                                
        int indexMin = 0;
        for(int j=0; j<contVertices; j++){                                            
                                                                                
            if( !listaVertices[j].isCidadeInserida() && menorCaminho[j].getCusto() < minDist){
                minDist = menorCaminho[j].getCusto();
                indexMin = j;                                                   
            }
        }
        return indexMin;
    }
    
    public void ajusteCaminho(){
        int coluna = 1;
        while(coluna < contVertices){
            
            if(listaVertices[coluna].isCidadeInserida()){
                coluna++;
                continue;
            }
            
            int currentToFringe = matrizAdjacente[verticeAtual][coluna];
            int startToFring = inicioDoAtual + currentToFringe;
            int sPathDist = menorCaminho[coluna].getCusto();

            if(startToFring < sPathDist){
                menorCaminho[coluna].setNoPai(verticeAtual);
                menorCaminho[coluna].setCusto(startToFring);
            }
            coluna++;
        }
    }
    
    public void exibirCaminho(int inicio,int fim){
        int aux = fim;
        String pai;
        if(menorCaminho[fim].getCusto() == INFINITO){
            System.out.println("Impossível");
            System.out.println("\n");
            return;
        }else{
            custoTotal += menorCaminho[fim].getCusto();
            System.out.println("Preço total: " + menorCaminho[fim].getCusto());
        }
        
        System.out.print("Caminho de "+ listaVertices[inicio].getCidade() +
                         " até " + listaVertices[fim].getCidade() + ": ");
        System.out.print(listaVertices[fim].getCidade());
        while( aux != inicio){
            pai = listaVertices[menorCaminho[aux].getNoPai()].getCidade();
            aux = menorCaminho[aux].getNoPai();
            System.out.print(" <- " + pai);
        }
        System.out.println("\n");
    }
    
    public void exibirCidades(){
        for(int i = 0; i < listaVertices.length; i++){
            if(listaVertices[i] != null)
                System.out.println("Posicao: " +i+ " | cidade: "+listaVertices[i].getCidade());
            else break;
        }
    }
    
    public int obterIndice(String cidade){
        for(int i=0; i < listaVertices.length; i++){
            if(listaVertices[i].getCidade().equals(cidade))
                return i;
        }
        return -1;
    }
    
    public boolean contem(String cidad){
        for(int i=0; i<listaVertices.length; i++){
            if(listaVertices[i] == null)
                return false;
            if(listaVertices[i].getCidade().equals(cidad))
                return true;
        }
        return false;
    }
    
    public void exibirMatriz(){
        for(int l = 0; l < 13; l++){
            for(int c = 0; c < 13; c++){
                System.out.print(matrizAdjacente[l][c] + "\t");
            }
            System.out.println();
        }
    }
    

    public List<String> inicializaCaminhos(){
        
        List<String> caminhos = new ArrayList();
        caminhos.add("Arad Zerind 75");
        caminhos.add("Arad Sibiu 140");
        caminhos.add("Arad Timisoara 118");
        caminhos.add("Zerind Oradea 71");
        caminhos.add("Zerind Arad 75");
        caminhos.add("Timisoara Arad 118");
        caminhos.add("Timisoara Lugoj 111");
        caminhos.add("Sibiu Oradea 151");
        caminhos.add("Sibiu Arad 140");
        caminhos.add("Sibiu Fagaras 99");
        caminhos.add("Sibiu RimnicuVilcea 80");
        caminhos.add("Oradea Zerind 71");
        caminhos.add("Oradea Sibiu 151");
        caminhos.add("Lugoj Timisoara 111");
        caminhos.add("Lugoj Mehadia 70");
        caminhos.add("Mehadia Lugoj 70");
        caminhos.add("Mehadia Dobreta 75");
        caminhos.add("Dobreta Mehadia 75");
        caminhos.add("Dobreta Craiova 120");
        caminhos.add("Craiova Dobreta 120");
        caminhos.add("Craiova RimnicuVilcea 80");
        caminhos.add("Craiova Pitesti 138");
        caminhos.add("RimnicuVilcea Craiova 146");
        caminhos.add("RimnicuVilcea Sibiu 80");
        caminhos.add("RimnicuVilcea Pitesti 97");
        caminhos.add("Fagaras Sibiu 99");
        caminhos.add("Fagaras Bucharest 211");
        caminhos.add("Pitesti RimnicuVilcea 97");
        caminhos.add("Pitesti Craiova 138");
        caminhos.add("Pitesti Bucharest 101");
        caminhos.add("Bucharest Giurgiu 90");
        caminhos.add("Bucharest Pitesti 101");
        caminhos.add("Bucharest Fagaras 211");
        caminhos.add("Bucharest Urziceni 85");
        caminhos.add("Giurgiu Bucharest 90");
        caminhos.add("Urziceni Bucharest 85");
        caminhos.add("Urziceni Vaslui 142");
        caminhos.add("Urziceni Hirsova 98");
        caminhos.add("Neamt Iasi 87");
        caminhos.add("Iasi Neamt 87");
        caminhos.add("Iasi Vaslui 92");
        caminhos.add("Vaslui Iasi 92");
        caminhos.add("Vaslui Urziceni 142");
        caminhos.add("Hirsova Urziceni 98");
        caminhos.add("Hirsova Eforie 86");
        caminhos.add("Eforie Hirsova 86");
        
        return caminhos;
    }
    
    
    public void inicializaGrafo(){
        
        Scanner sc = new Scanner(System.in);
        List<String> caminhos = this.inicializaCaminhos();
        String origem;
        String destino;
        Integer custo;
        
        
        for (String caminho : caminhos) {
            //System.out.println(caminho);
            String [] caminhoSplit = caminho.split(" ");
            origem = caminhoSplit[0];
            destino = caminhoSplit[1];
            custo = Integer.parseInt(caminhoSplit[2]);
            
            if(this.listaVertices[0] == null){
                this.addVertice(origem);
                this.addVertice(destino);
            }else{
                if(this.contem(origem) == false){
                    this.addVertice(origem);
                }
                if(this.contem(destino) == false){
                    this.addVertice(destino);
                }
            }
//            
//            this.addVertice(origem);
//            this.addVertice(destino);
            int indiceOrigem = this.obterIndice(origem);
            int indiceDestino = this.obterIndice(destino);
            this.addAresta(indiceOrigem, indiceDestino, custo);
            
        }
        
        System.out.println();
        //this.exibirCidades();
        System.out.println();
        
        
    }
    
}
