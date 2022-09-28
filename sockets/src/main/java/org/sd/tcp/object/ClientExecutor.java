package org.sd.tcp.object;

import java.util.Date;

/**
 *
 * @author mayarandrade
 */
public class ClientExecutor {
    
    public static void main(String args[]) {
        
        Person p = new Person(1L, "Nome", "Sobrenome", "Documento", new Date());
        
        Client c = new Client();
        
        c.send(p);
        
        c.disconnect();
    }
}
