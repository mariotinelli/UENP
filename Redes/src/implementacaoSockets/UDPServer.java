/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacaoSockets;

import java.io.*;
import java.net.*;

public class UDPServer {
    
    public static void main(String args[]) throws Exception {

        int porta = 9876;
        int numConn = 1;

        DatagramSocket serverSocket = new DatagramSocket(porta);

        byte[] receiveDataVet = new byte[1024];
        byte[] sendDataVet = new byte[1024];
        
        byte[] receiveDataOpcao = new byte[1024];
        byte[] sendDataOpcao = new byte[1024];
        
        
        while (true) {

                DatagramPacket vetReceivePacket = new DatagramPacket(receiveDataVet, receiveDataVet.length);
                System.out.println("Esperando por datagrama UDP na porta " + porta);
                serverSocket.receive(vetReceivePacket);
                
                System.out.print("Datagrama UDP [" + numConn + "] recebido...");
                String vetSentence = new String(vetReceivePacket.getData());
                System.out.println(vetSentence);
                
                String [] vetorSplit = vetSentence.split(" ");
                String sentence = "Digite a ordenação que deseja: 1-BubbleSort | 2-MergeSort | 3-RadixSort";
                
                InetAddress IPAddress = vetReceivePacket.getAddress();
                int port = vetReceivePacket.getPort();
                sendDataVet = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendDataVet,sendDataVet.length, IPAddress, port);
                
                System.out.print("Enviando " + sentence + "...");
                serverSocket.send(sendPacket);
                System.out.println("OK\n");

                // ---------------------------------------------------------------------------
                
                DatagramPacket opcaoReceivePacket = new DatagramPacket(receiveDataOpcao, receiveDataOpcao.length);
                System.out.println("Esperando por datagrama UDP na porta " + porta);
                serverSocket.receive(opcaoReceivePacket);
                System.out.print("Datagrama UDP [" + numConn + "] recebido...");
                String opcaoSentence = new String(opcaoReceivePacket.getData());
                System.out.println(opcaoSentence);
                
                int opcao = Integer.parseInt(opcaoSentence.trim());
                int tam = vetorSplit.length;
                int [] vetor = new int[tam];
                
                for (int i = 0; i < vetorSplit.length; i++){
                    vetor[i] = Integer.parseInt(vetorSplit[i].trim());
                }
                
                switch(opcao){
                    case 1:
                        vetor = UDPServer.bubbleSort(vetor);
                    case 2:
                        vetor = UDPServer.mergeSort(vetor);
                    case 3:
                        vetor = UDPServer.radixSort(vetor);  
                }
                
                String vetCapitalizedSentence = "";
                for (int i = 0; i < vetor.length; i++){
                    vetCapitalizedSentence += vetor[i] + " ";
                }

                IPAddress = opcaoReceivePacket.getAddress();
                port = opcaoReceivePacket.getPort();
                sendDataOpcao = vetCapitalizedSentence.getBytes();
                sendPacket = new DatagramPacket(sendDataOpcao,sendDataOpcao.length, IPAddress, port);

                System.out.print("Enviando " + vetCapitalizedSentence + "...");

                serverSocket.send(sendPacket);
                System.out.println("OK\n");
        }
    }
    
    
    
    public static int [] bubbleSort(int [] vetor){
        
        for(int i = 0; i < vetor.length - 1; i++) {
            for(int j = 0; j < vetor.length - 1 - i; j++) {
                if(vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }  
        }
        return vetor;
    }
    
    public static int [] mergeSort(int [] vetor){
        int tamanho = vetor.length;
        int elementos = 1;
        int inicio, meio, fim;

        while(elementos < tamanho) {

          inicio = 0;

            while(inicio + elementos < tamanho) {

                meio = inicio + elementos;
                fim = inicio + 2 * elementos;

                if(fim > tamanho)
                  fim = tamanho;

                vetor = intercala(vetor, inicio, meio, fim);
                inicio = fim;
            }
        elementos = elementos * 2;     
        }
        return vetor;
    }
        
    public static int [] intercala(int[] vetor, int inicio, int meio, int fim) {

        int novoVetor[] = new int[fim - inicio];
        int i = inicio;
        int m = meio;
        int pos = 0;

        while(i < meio && m < fim) {
            
            if(vetor[i] <= vetor[m]) {
              novoVetor[pos] = vetor[i];
              pos = pos + 1;
              i = i + 1;
            } else {
              novoVetor[pos] = vetor[m];
              pos = pos + 1;
              m = m + 1;
            }
        }

        while(i < meio) {
          novoVetor[pos] = vetor[i];
          pos = pos + 1;
          i = i + 1;
        }

        while(m < fim) {
          novoVetor[pos] = vetor[m];
          pos = pos + 1;
          m = m + 1;
        }

        for(pos = 0, i = inicio; i < fim; i++, pos++) {
          vetor[i] = novoVetor[pos];
        }
        return vetor;
    }    
    
    public static int [] radixSort(int [] arr){
        
        if (arr.length == 0)
            return null;

        int[][] np = new int[arr.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f = 0;

        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++)
                    np[i][1] = i + 1;
            np[i][1] = -1;

            for (i = 0; i < q.length; i++)
                    q[i] = -1;
            for (f = i = 0; i < arr.length; i++) {
                    j = ((0xFF << (k << 3)) & arr[i]) >> (k << 3);
                    if (q[j] == -1)
                            l = q[j] = f;

                    else {
                            l = q[j];
                            while (np[l][1] != -1)
                                    l = np[l][1];
                            np[l][1] = f;
                            l = np[l][1];
                    }

                    f = np[f][1];
                    np[l][0] = arr[i];
                    np[l][1] = -1;
            }
            for (l = q[i = j = 0]; i < 0x100; i++)
                    for (l = q[i]; l != -1; l = np[l][1])
                            arr[j++] = np[l][0];
        }
        return arr;
    }
    
}
