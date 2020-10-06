/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Cursos
 */
public class LeituraArquivo {
    
    Dicionario dicionarioPT_EN[] = new Dicionario[3000];
    Dicionario dicionarioEN_PT[] = new Dicionario[3000];
    
    
    public int h(int h){
        int aux = h%3000;
        return aux;
    }
    
    public String busca_hash(Dicionario dic[], int x, String palavra){
        int k;
        k = h(x);
        if (dic[k].getChave().equals(palavra)){ 
            return dic[k].getPalavra();
        }
        return null;
    }
    
    public static void main(String[] args) throws IOException {
        
        LeituraArquivo la = new LeituraArquivo();
        
        String port = "portugues.txt";
        String ingles = "ingles.txt";    
        
        for (int i = 0; i < la.dicionarioPT_EN.length; i++){
            la.dicionarioPT_EN[i] = new Dicionario();
            la.dicionarioEN_PT[i] = new Dicionario();
        }

        FileReader lerCaminhoPort = new FileReader(port);
        FileReader lerCaminhoIngles = new FileReader(ingles);
        BufferedReader lerPort = new BufferedReader(lerCaminhoPort);
        BufferedReader lerIngles = new BufferedReader(lerCaminhoIngles);
        int i = 0;
        int colisao = 0;
        while (lerPort.ready()) {
            String portugues = lerPort.readLine();
            String portuguesSplit [] = portugues.split(". ");
            String ing = lerIngles.readLine();
            String inglesSplit [] = ing.split(". ");
            boolean acabouVetor = false;
            try {
                //System.out.println(Integer.parseInt(portuguesSplit[0]));
                i = la.h(Integer.parseInt(portuguesSplit[0]));
            } catch (NumberFormatException e){
                    
            }
            if (la.dicionarioPT_EN[i].getChave() == null){
                la.dicionarioPT_EN[i].setChave(portuguesSplit[1]);
                la.dicionarioPT_EN[i].setPalavra(inglesSplit[1]);
            }
            else {
                colisao++;
                for (int k = i+1; k < la.dicionarioPT_EN.length; k++){
                    if (la.dicionarioPT_EN[k].getChave() == null){
                        la.dicionarioPT_EN[k].setChave(portuguesSplit[1]);
                        la.dicionarioPT_EN[k].setPalavra(inglesSplit[1]);
                        acabouVetor = true;
                        break;
                    }                 
                }
                if (acabouVetor != true){
                    for (int k = 0; k < la.dicionarioPT_EN.length; k++){
                        if (la.dicionarioPT_EN[k].getChave() == null){
                            la.dicionarioPT_EN[k].setChave(portuguesSplit[1]);
                            la.dicionarioPT_EN[k].setPalavra(inglesSplit[1]);
                            break;  
                        }
                    }
                }
            }
            
            //// EN-PT
            
            if (la.dicionarioEN_PT[i].getChave() == null){
                la.dicionarioEN_PT[i].setChave(inglesSplit[1]);
                la.dicionarioEN_PT[i].setPalavra(portuguesSplit[1]);
            }
            else {
                colisao++;
                for (int k = i+1; k < la.dicionarioEN_PT.length; k++){
                    if (la.dicionarioEN_PT[k].getChave() == null){
                        la.dicionarioEN_PT[k].setChave(inglesSplit[1]);
                        la.dicionarioEN_PT[k].setPalavra(portuguesSplit[1]);
                        acabouVetor = true;
                        break;
                    }                 
                }
                if (acabouVetor != true){
                    for (int k = 0; k < la.dicionarioEN_PT.length; k++){
                        if (la.dicionarioEN_PT[k].getChave() == null){
                            la.dicionarioEN_PT[k].setChave(inglesSplit[1]);
                            la.dicionarioEN_PT[k].setPalavra(portuguesSplit[1]);
                            break;  
                        }
                    }
                }
            }
        }
        lerPort.close();
        
//        for (Dicionario dicionarioPT_EN1 : la.dicionarioPT_EN) {
//            System.out.println("Chave: "+dicionarioPT_EN1.getChave()+ " Tradução: "+dicionarioPT_EN1.getPalavra());
//        }
//        for (Dicionario dicionarioEN_PT1 : la.dicionarioEN_PT) {
//            System.out.println("Chave: "+dicionarioEN_PT1.getChave()+ " Tradução: "+dicionarioEN_PT1.getPalavra());
//        }
        System.out.println("Colisões: "+colisao);
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma palvra: ");
        String palavra = sc.next();
        System.out.println("Digite o valor a chave da palavra: ");
        int x = sc.nextInt();
        System.out.println("Digite o dicionário, PT-EN OU EN-PT");
        String dic = sc.next();
        if (dic.equals("PT-EN")){
            System.out.println(la.busca_hash(la.dicionarioPT_EN, x, palavra));
        }
        else{
            System.out.println(la.busca_hash(la.dicionarioEN_PT, x, palavra));
        }
       
        
        
        
    } 
          
} 
        
    


   
