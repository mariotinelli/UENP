/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoArquivosV3;


import java.io.FileNotFoundException;
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

    public LeituraFork(String arquivo){
        this.arquivo = arquivo;
    }

    @Override
    protected List<Palavra> compute() {
        System.out.println("Thread em execução " + Thread.currentThread().getName());
        List<Palavra> listaContagem = new ArrayList();
        try {
            //Thread.sleep(5000);
            listaContagem = iniciarPassos();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LeituraFork.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaContagem;
    }

    
    public List<Palavra> iniciarPassos() throws IOException, FileNotFoundException, InterruptedException{
        List<String> leitura = LeituraFork.lerArquivo(this.arquivo);
        String [] palavras = leitura.toString().split(" ");
        palavras = lowerCase(palavras);
        palavras = removerPontos(palavras);
        palavras = removerStopwords(palavras);
        List<Palavra> contagem = iniciarContagem(palavras);
        return contagem;
    }
          
    public static List<String> lerArquivo(String arquivo) throws FileNotFoundException, IOException, InterruptedException{
        
        List<String> leitura = Files.readAllLines(Paths.get(arquivo));
        return leitura;
        
    }
    
    public String [] lowerCase(String [] palavras){
        
        Stream<String> aux = Arrays.stream(palavras).map(x -> x.toLowerCase());
        palavras = aux.toArray(String[]::new);
        return palavras;
    }
    
    public String [] removerPontos(String [] palavras) throws IOException, InterruptedException{
        
        List<String> pontos = LeituraFork.lerArquivo("C:\\Users\\Mario\\Desktop\\Arquivos\\pontos.txt");
        
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
        }
        return palavras;
    }
    
    public String[] removerStopwords(String [] palavras) throws IOException, FileNotFoundException, InterruptedException{
        
        List<String> stopwords = LeituraFork.lerArquivo("C:\\Users\\Mario\\Desktop\\Arquivos\\stopwords.txt");
        Stream<String> aux = Arrays.stream(palavras).filter(x -> !stopwords.contains(x));
        palavras = aux.toArray(String[]::new);
        return palavras;
    }
    
    public List<Palavra> iniciarContagem(String [] palavras) throws IOException{
        List<Palavra> listaContagem = new ArrayList();
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
        return listaContagem;
    } 
    
    public void exibirContagem(List<Palavra> listaContagem){
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
