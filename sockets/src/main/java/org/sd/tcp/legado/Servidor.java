
package org.sd.tcp.legado;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 125111371551
 */
public class Servidor {
    
    static ServerSocket serversocket;
    static Socket client_socket;
    static Conexao c;
    static String msg;
    
    public Servidor(){
        try{
            serversocket = new ServerSocket(9600);
            System.out.println("Criando o Server Socket");
        } catch (Exception e) {
            System.err.println("Não criei o Server Socket...");
        }
    }
    
    public static void main(String args[]) {
        String texto = "";
        String resposta = "Hello World";
        new Servidor();
        
        while (true) {
            if(connect()){
                
                texto = c.receive(client_socket);
                System.out.println("Cliente enviou: " + texto.trim());
                c.send(client_socket, resposta);
                
                try {
                    client_socket.close();
                } catch (Exception e) {
                    System.err.println("Não encerrpu a conexao corretamente" + e.getMessage());
                }
            }
        }
    }
    
    static boolean connect(){
        boolean ret;
        try{
            client_socket = serversocket.accept();
            ret = true;
        } catch (Exception e) {
            System.err.println("Não fez conexao" + e.getMessage());
            ret = false;
        }
        return ret;
    }
}
