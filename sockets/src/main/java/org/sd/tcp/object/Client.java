package org.sd.tcp.object;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 
 * @author mayarandrade
 */
public class Client {
    
    //atributos
    Socket socket;
    
    //construtor
    public Client(){
        try{
            socket = new Socket("localhost", 9600);
            System.out.println("Socket criado.");
        } catch (IOException e) {
            System.out.println("Erro ao conectar." + e.getMessage());
        } 
    }
    
    //envio/escrita
    public void send(Object obj) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(obj);
            System.out.println("Objeto enviado.");
        } catch (IOException e) {
            System.out.println("Erro no envio." + e.getMessage());
        }
    }
    
    //desconexão
    public void disconnect() {
        try {
           socket.close(); 
           System.out.println("Conexão encerrada.");
        } catch (IOException e) {
           System.out.println("Erro ao desconectar." + e.getMessage());
        }
    }
    
}
