
package org.sd.tcp.legado;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author 125111371551
 */
public class Conexao {
    
    public static void send(Socket socket, String message) {
        OutputStream outputStream;
        try{
            outputStream = socket.getOutputStream();
            outputStream.write(message.getBytes());
        } catch (IOException e) {
            System.out.println("Erro ao enviar mensagem." + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static String receive(Socket socket) {
        
        try {
            byte textInBytes[] = new byte[1024];
            String message = "";
            InputStream inputStream = socket.getInputStream();
            int quantityOfBytes = inputStream.read(textInBytes);
            
            if (quantityOfBytes > 0){
                return new String(textInBytes);
            }
        } catch (IOException e) {
            System.out.println("Erro ao receber mensagem." + e.getMessage());
            e.printStackTrace();
        }
        
        return "";
    }
    
}
