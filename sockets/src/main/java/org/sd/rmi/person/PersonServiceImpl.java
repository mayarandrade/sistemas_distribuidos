
package org.sd.rmi.person;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 *
 * @author mayarandrade
 */
public class PersonServiceImpl implements PersonService {

    @Override
    public Person transferPerson() throws RemoteException {
        Person p = new Person(1L, "Name", "Surname", "Document", new Date());
        return p;
    }
    
    public void createStubAndBind() throws RemoteException {
        PersonService stub = (PersonService) UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("PersonService", stub);
    }
}
