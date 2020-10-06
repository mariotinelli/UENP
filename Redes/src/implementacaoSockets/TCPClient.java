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

public class TCPClient {

    public static void main(String argv[]) throws Exception {
        
        String sentence;
        String modifiedSentence;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        int porta = 6789;
        String servidor = "localhost";

        System.out.println("Conectando ao servidor " + servidor + ":" + porta);

        try (Socket clientSocket = new Socket(servidor, porta)) {
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            System.out.println("Digite string a ser enviada para o servidor");
            sentence = inFromUser.readLine();
            
            outToServer.writeBytes(sentence + '\n');
            
            modifiedSentence = inFromServer.readLine();
            
            System.out.println("Recebido do servidor: " + modifiedSentence);
        }

    }
}
