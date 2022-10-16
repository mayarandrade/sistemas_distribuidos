
package org.sd.rmi.person;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author mayarandrade
 */
public interface PersonService extends Remote {
    public Person transferPerson() throws RemoteException;
}
