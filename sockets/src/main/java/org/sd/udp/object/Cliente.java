package org.sd.udp.object;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @author 125111371551
 */
public class Cliente {
    
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date birthDate = sdf.parse("2001/09/04");
        
        Person p = new Person(2L, "Mayara", "Andrade", "125111371551", birthDate);
        
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        
        final ByteArrayOutputStream baos = new ByteArrayOutputStream(6400);
        final ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(p);
        final byte[] data = baos.toByteArray();
        
        DatagramPacket dp = new DatagramPacket(data, data.length, ip, 3000);
        ds.send(dp);
        ds.close();
        
    }
}
