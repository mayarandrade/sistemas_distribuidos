package org.sd.tcp.object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author mayarandrade
 */
public class Server {
    
    //atributos
    ServerSocket serverSocket;
    Socket clientSocket;
    
    //construtor
    public Server(){
        try {
            serverSocket = new ServerSocket(9600);
            System.out.println("Server Socket criado.");
        } catch (IOException e) {
            System.out.println("Erro ao criar Server Socket." + e.getMessage());
        }
    }
    
    //getters
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }
    
    //conexão
    public void connect() {
        try {
            clientSocket = serverSocket.accept(); 
        } catch (IOException e) {
            System.out.println("Erro ao realizar conexão." + e.getMessage());
        }
    }
    
    //recebimento/leitura
    public void receive() {
            try {        
                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
                Object returned = ois.readObject();
                Person person = (Person) returned;
                System.out.println("O objeto recebido foi: " + person.toString());
            } catch (Exception e) {
                System.out.println("Erro no recebimento. " + e.getMessage());
            }
    }
    
    //desconexão
    public void disconnect() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Erro ao encerrar conexão." +e.getMessage());
        }
        
    }
    
}
