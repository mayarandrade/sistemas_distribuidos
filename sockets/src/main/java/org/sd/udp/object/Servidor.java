package org.sd.udp.object;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;

/*
 * @author 125111371551
 */
public class Servidor {
    
    public static void main(String[] args) throws Exception {
        
        DatagramSocket ds = new DatagramSocket(3000);
        byte[] buffer = new byte[1024];
        
        DatagramPacket dp = new DatagramPacket(buffer, 1024);
        ds.receive(dp);
        
        final ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        final ObjectInputStream ois = new ObjectInputStream(bais);
        Object returned = ois.readObject();
        Person person = (Person) returned;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(sdf.format(person.getBirthDate()));
        
        ds.close();
    }
}
