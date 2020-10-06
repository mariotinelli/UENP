/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoArquivosV2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author Mario
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException, IOException {
        long ms = System.currentTimeMillis();
        Leitura a1 = new Leitura("C:\\Users\\Mario\\Desktop\\Arquivos\\arquivo1.txt");
        Leitura a2 = new Leitura("C:\\Users\\Mario\\Desktop\\Arquivos\\arquivo2.txt");
        Leitura a3 = new Leitura("C:\\Users\\Mario\\Desktop\\Arquivos\\arquivo3.txt");
        Leitura a4 = new Leitura("C:\\Users\\Mario\\Desktop\\Arquivos\\arquivo4.txt");
        
        a1.join();
        a2.join();
        a3.join();
        a4.join();
        
        System.out.println("Leitura Thread demorou " + (System.currentTimeMillis() - ms) + "ms");
        System.out.println("Contagem de a1"); a1.exibirContagem();
        System.out.println("Contagem de a2"); a2.exibirContagem();
        System.out.println("Contagem de a3"); a3.exibirContagem();
        System.out.println("Contagem de a3"); a4.exibirContagem();
        System.out.println("");
        System.out.println("");
        
        
        ms = System.currentTimeMillis();
     

        LeituraFork l1 = new LeituraFork("C:\\Users\\Mario\\Desktop\\Arquivos\\arquivo1.txt");
        LeituraFork l2 = new LeituraFork("C:\\Users\\Mario\\Desktop\\Arquivos\\arquivo2.txt");
        LeituraFork l3 = new LeituraFork("C:\\Users\\Mario\\Desktop\\Arquivos\\arquivo3.txt");
        l1.fork();
        l2.fork();
        l3.fork();
        List<Palavra> result1 = l1.join();
        List<Palavra> result2 = l2.join();
        List<Palavra> result3 = l3.join();
        System.out.println("Leitura Fork demorou " + (System.currentTimeMillis() - ms) + "ms");
        
        System.out.println("Contagem l1");  l1.exibirContagem();
        System.out.println("Contagem l2");  l2.exibirContagem();
        System.out.println("Contagem l3");  l3.exibirContagem();

    }
    
    
}
