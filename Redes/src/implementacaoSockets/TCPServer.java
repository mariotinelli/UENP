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

public class TCPServer {
    public static void main( String argv[]) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);

        System.out.println("ponto1");
        Socket connectionSocket = welcomeSocket.accept();

        while (true) {
               System.out.println("ponto2");
               BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
               DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
               System.out.println("ponto3");
               clientSentence = inFromClient.readLine();
               System.out.println("ponto4");
               capitalizedSentence = clientSentence.toUpperCase() + '\n';
               outToClient.writeBytes(capitalizedSentence);
               // connectionSocket.close();
       }
    }
}
