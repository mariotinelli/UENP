/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

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
                    //System.out.println(tam + "" + vetorSplit[i] + " i = " + i);
                    vetor[i] = Integer.parseInt(vetorSplit[i].trim());
                }
                
                switch(opcao){
                    case 1:
                        System.out.println("bbu");
                        vetor = UDPClient.bubbleSort(vetor);
                    case 2:
                        vetor = UDPClient.mergeSort(vetor);
                    case 3:
                        vetor = UDPClient.radixSort(vetor);  
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
}
