/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacaoSockets;

/**
 *
 * @author Mario
 */
import java.io.*;
import java.net.*;

public class UDPClient {

    /* 
    
        - O cliente envia uma mensagem para o servidor contendo o vetor de inteiros que deseja ordenar.
        - O servidor recebe o vetor e envia uma mensagem fornece 3 tipos de ordenações e pergunta qual tipo de ordenação o cliente deseja.
        - O cliente envia uma mensagem contendo o tipo de ordenação.
        - O servidor recebe o tipo de ordenação e retorna ao cliente o vetor ordenado.
    
    */
    
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
        

        System.out.println("Digite o vetor de inteiros: ");
        String sentence = inFromUser.readLine();
        sendDataVet = sentence.getBytes();
        
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
