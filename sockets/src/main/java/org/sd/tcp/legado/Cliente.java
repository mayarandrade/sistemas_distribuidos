
package org.sd.tcp.legado;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author 125111371551
 */
public class Cliente {
    
    private Conexao connection;
    private Socket socket;
    
    public Cliente(String host, int port){
        try{
            this.socket = new Socket(host, port);
        } catch (IOException e) {
            System.out.println("Error on resolving host: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    public Conexao getConnection() {
        return this.connection;
    }

    public Socket getSocket() {
        return this.socket;
    }
    
    public void sendMessage(String message){
        Cliente client = new Cliente("localhost", 9600);
        client.connection.send(client.socket, message);
        
        String serverResponse = client.connection.receive(client.socket);
        
        System.out.println("Servidor enviou: " + serverResponse.trim());
        
        try{
            client.socket.close();
        } catch (IOException e) {
            System.err.println("Nao encerrou a conexao corretamente no cliente." + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        Cliente client = new Cliente("localhost", 9600);
        client.sendMessage("Mensagem");
    }
}
