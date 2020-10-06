/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tempdicte file, choose Tools | Tempdictes
 * and open the tempdicte in the editor.
 */
package hash;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Cursos
 */
public class Dic {
    
    ListaDupEncad dicionarioPT_EN[];
    ListaDupEncad dicionarioEN_PT[];
    
    public Dic (){
        dicionarioPT_EN = new ListaDupEncad[251];
        dicionarioEN_PT = new ListaDupEncad[251];
    }
    
    final void inicializaDic(){
        for(int i = 0; i < dicionarioPT_EN.length; i++){
            dicionarioPT_EN[i] = new ListaDupEncad();
        }
        for(int i = 0; i < dicionarioEN_PT.length; i++){
            dicionarioEN_PT[i] = new ListaDupEncad();
        }
    }
    
    final int funcaoHash(String palavra){
        int pos = palavra.charAt(0);
        return pos;     
    }
    
    final void insereTabelaPT(String chave, String palavra){
        No aux = new No(new Dicionario(chave,palavra));
        dicionarioPT_EN[funcaoHash(chave)].insere(aux);
    }
    final void insereTabelaEN(String chave, String palavra){
        No aux = new No(new Dicionario(chave,palavra));
        dicionarioEN_PT[funcaoHash(chave)].insere(aux);
    }
    
    final String buscaHash(String palavra, ListaDupEncad lista[]){
        String trad = lista[funcaoHash(palavra)].busca(palavra).getDic().getPalavra();
        return trad;
    }

    
    public static void main(String[] args) throws IOException {
        
        Dic dic = new Dic();
        
        String port = "portugues.txt";
        String ingles = "ingles.txt";    
        dic.inicializaDic();
        FileReader lerCaminhoPort = new FileReader(port);
        FileReader lerCaminhoIngles = new FileReader(ingles);
        BufferedReader lerPort = new BufferedReader(lerCaminhoPort);
        BufferedReader lerIngles = new BufferedReader(lerCaminhoIngles);
        
        
        int temp = 1;
        // Arquivo port
        while (lerPort.ready()) {
            String portugues = lerPort.readLine();
            String inglesSplit[] = new String[2];
            String portuguesSplit[] = new String[2] ;
            String ing = lerIngles.readLine();
            if (temp == 1){
                portuguesSplit[1] = portugues.substring(4, portugues.length());
                inglesSplit[1] = ing.substring(3, ing.length());
            }
            else if (temp <= 9){ 
                portuguesSplit[1] = portugues.substring(3, portugues.length());
                inglesSplit[1] = ing.substring(3, ing.length());
            }
            else if (temp >= 10 && temp < 100){
                portuguesSplit[1] = portugues.substring(4, portugues.length());
                inglesSplit[1] = ing.substring(4, ing.length());
            }
            else if (temp >= 100 && temp < 1000){
                portuguesSplit[1] = portugues.substring(5, portugues.length());
                inglesSplit[1] = ing.substring(5, ing.length());
            }
            else if (temp >= 1000 && temp <= 3000){
                portuguesSplit[1] = portugues.substring(6, portugues.length());
                inglesSplit[1] = ing.substring(6, ing.length());
            }
            
            String chave = portuguesSplit[1];
            String palavra = inglesSplit[1];
            dic.insereTabelaPT(chave, palavra);
            dic.insereTabelaEN(palavra, chave);
            temp++;
        }
        lerPort.close(); 

        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        OUTER:
        while (opcao != 0) {
            System.out.println("------------Tradutor de Palavras---------------");
            System.out.println("");
            System.out.println("Digite (1) para PT_EN ou (2) para EN_PT ou (0) para sair");
            int trad = sc.nextInt();
            switch (trad) {
                case 0:
                    break OUTER;
                case 1:
                    {
                        System.out.println("Digite a palavra que deseja traduzir: ");
                        String palavra = sc.next();
                        String traducao = dic.buscaHash(palavra, dic.dicionarioPT_EN);
                        System.out.println("A tradução de "+palavra+ "é: "+traducao);
                        break;
                    }
                case 2:
                    {
                        System.out.println("Digite a palavra que deseja traduzir: ");
                        String palavra = sc.next();
                        String traducao = dic.buscaHash(palavra, dic.dicionarioEN_PT);
                        System.out.println("A tradução de "+palavra+ " é: "+traducao);
                        break;
                    }
                default:
                    break;
            }
        }
        

    } 
}
    
    
          

        
    


   

    

