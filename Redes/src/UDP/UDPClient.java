/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

/**
 *
 * @author Mario
 */
import java.io.*;
import java.net.*;

public class UDPClient {
    
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
    
    
    public static void main(String args[]) throws Exception {

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket = new DatagramSocket();

        String servidor = "localhost";
        int porta = 9876;

        InetAddress IPAddress = InetAddress.getByName(servidor);

        byte[] sendDataVet = new byte[1024];
        byte[] receiveDataVet = new byte[1024];
        
        byte[] sendDataOpcao = new byte[1024];
        byte[] receiveDataOpcao = new byte[1024];
        
        //int [] vetorClient = {20,15,14,13,12,10,8,7,25,9,5,4,3,2,1};
        System.out.println("Digite o vetor de inteiros: ");
        //+ "e a Ordenação escolhida: 1-BubbleSort | 2-MergeSort | 3-RadixSort  ");
       
        String sentence = inFromUser.readLine();
        sendDataVet = sentence.getBytes();
        
        //System.out.println("Digite a ordenação desejada: 1-BubbleSort | 2-MergeSort | 3-RadixSort ");
        //String opcao = inFromUser.readLine();
        
        DatagramPacket sendPacket = new DatagramPacket(sendDataVet,sendDataVet.length, IPAddress, porta);

        System.out.println("Enviando pacote UDP para " + servidor + ":" + porta);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveDataVet,receiveDataVet.length);

        clientSocket.receive(receivePacket);
        System.out.println("Pacote UDP recebido...");

        String modifiedSentence = new String(receivePacket.getData());

        System.out.println("Texto recebido do servidor: " + modifiedSentence);
        
        // --------------------------------------------------------------------
        
        sentence = inFromUser.readLine();
        sendDataOpcao = sentence.getBytes();
        
        //System.out.println("Digite a ordenação desejada: 1-BubbleSort | 2-MergeSort | 3-RadixSort ");
        //String opcao = inFromUser.readLine();
        
        sendPacket = new DatagramPacket(sendDataOpcao,sendDataOpcao.length, IPAddress, porta);

        System.out.println("Enviando pacote UDP para " + servidor + ":" + porta);
        clientSocket.send(sendPacket);

        receivePacket = new DatagramPacket(receiveDataOpcao,receiveDataOpcao.length);

        clientSocket.receive(receivePacket);
        System.out.println("Pacote UDP recebido...");

        modifiedSentence = new String(receivePacket.getData());

        System.out.println("Texto recebido do servidor:" + modifiedSentence);
        
 
        clientSocket.close();
        System.out.println("Socket cliente fechado!");
    }
}
