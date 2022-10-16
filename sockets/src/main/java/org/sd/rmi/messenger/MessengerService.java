
package org.sd.rmi.messenger;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Mayara
 */
public interface MessengerService extends Remote {
    public String sendMessage(String clientMessage) throws RemoteException;
    public Message sendMessage (Message clientMessage) throws RemoteException;
}
