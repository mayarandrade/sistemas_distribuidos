package org.sd.tcp.object;

/**
 * 
 * @author mayarandrade
 */
public class ServerExecutor {
    
    public static void main(String args[]) {
        
        Server s = new Server();
        
        s.connect();
        
        if(s.getClientSocket().isConnected()){
            
            s.receive();
            
            s.disconnect();
        }
        
    } 
    
}
