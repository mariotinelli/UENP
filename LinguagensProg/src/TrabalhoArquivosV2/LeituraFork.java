/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoArquivosV2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Mario
 */
public class LeituraFork extends RecursiveTask<List<Palavra>> {

    String arquivo;
    String [] palavras;
    List<String> listaPalavras;
    List<Palavra> listaContagem;
    
    public LeituraFork(String arquivo){
        this.arquivo = arquivo;
        palavras = null;
        listaPalavras = new ArrayList();
        listaContagem = new ArrayList();
    }

    @Override
    protected List<Palavra> compute() {
        System.out.println("Thread em execução " + Thread.currentThread().getName());
        try {
            //Thread.sleep(5000);
            lerArquivo();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LeituraFork.class.getName()).log(Level.SEVERE, null, ex);
        }


        return listaContagem;
    }
        
    public void lerArquivo() throws FileNotFoundException, IOException, InterruptedException{
        
        
        try (BufferedReader bf = new BufferedReader(new FileReader(arquivo))) {
            String linha = "";
            while (true) {
                linha = bf.readLine();
                if (linha != null){
                    palavras = linha.split(" ");
                    iniciarPassos();
                }
                else {
                    break;
                }
            }
            bf.close();
//            System.out.println("-------------");
//            exibirContagem();
//            System.out.println("-------------");
        }
    }
    
    public void iniciarPassos() throws IOException, FileNotFoundException, InterruptedException{

        lowerCase();
        removerPontos();
        removerStopwords();
        iniciarContagem();
        //exibirContagem();
        
    }

    public void lowerCase(){
        
        Stream<String> aux = Arrays.stream(palavras).map(x -> x.toLowerCase());
        palavras = aux.toArray(String[]::new);
        
    }
    
    public void removerPontos() throws IOException, InterruptedException{
        
        List<String> pontos = Files.readAllLines(Paths.get("C:\\Users\\Mario\\Desktop\\Arquivos\\pontos.txt"));
        
        int i = 0;
        while (i < palavras.length){
            for (int j = 0; j < palavras[i].length(); j++){
                String temp = palavras[i].substring(j,j+1);
                if (pontos.contains(temp)){
                    palavras[i] = palavras[i].replace(palavras[i].substring(j, j+1), "");
                }
            }
            
            for (int j = 0; j < palavras[i].length(); j++){
                String temp = palavras[i].substring(j,j+1);
                if (pontos.contains(temp)){
                   palavras[i] = palavras[i].replace(palavras[i].substring(j, j+1), ""); 
                }
            }
            i++;
            //Thread.sleep(300);
        }

    }
    
    public void removerStopwords() throws IOException{
        
//      listaPalavras.addAll(Arrays.asList(palavras));
        List<String> stopwords = Files.readAllLines(Paths.get("C:\\Users\\Mario\\Desktop\\Arquivos\\stopwords.txt"));
        Stream<String> aux = Arrays.stream(palavras).filter(x -> !stopwords.contains(x));
        palavras = aux.toArray(String[]::new);
        
//        for (int i = 0; i < listaPalavras.size(); i++){
//            String palavra = listaPalavras.get(i);
//            if (stopwords.contains(palavra)){
//                listaPalavras.remove(palavra);  
//            }  
//        }
//        
//        for (int i = 0; i < palavras.length; i++){
//            if (i >= listaPalavras.size()){
//                
//                palavras[i] = "";
//
//            }
//            else{
//                palavras[i] = listaPalavras.get(i);
//            }
//        }
        
//listaPalavras.clear();
        
    }
    
    public void iniciarContagem() throws IOException{
        
        boolean inserido = false;
        for (String palavra : palavras) {
            Palavra aux = new Palavra(palavra);
            if (listaContagem.isEmpty()){
                listaContagem.add(aux);
            }
            else {
                for (int i = 0; i < listaContagem.size(); i++){
                    Palavra troca = listaContagem.get(i);
                    inserido = false;
                    if (troca.palavra.equals(palavra)){
                        inserido = true;
                        troca.quantidade++;
                        break;
                    }
                }
                if (!inserido & !palavra.equals("")){
                    listaContagem.add(aux);
                }
            }
        }  
    } 
    
    public void exibirContagem(){
        System.out.println("");
        System.out.println("-----------");
        for (Palavra palavra: listaContagem){
            if (palavra.palavra.length() > 1){
                System.out.println(palavra.toString());
            }
        }
        System.out.println("TAM = " + listaContagem.size());
        
    }
    
    
    
}
