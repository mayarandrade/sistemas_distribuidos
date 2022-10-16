
package org.sd.rmi.person;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import static junit.framework.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mayarandrade
 */
public class PersonServiceIntegrationTest {
    
    private PersonServiceImpl personService;
    
    @Before
    public void init(){
        try {
            personService = new PersonServiceImpl();
            personService.createStubAndBind();
        } catch (RemoteException e) {
            fail("Exception Occurred: " + e);
        } 
    }
    
    @Test
    public void whenClientRequestsPerson() {
        try {
            Registry registry = LocateRegistry.getRegistry();
            PersonService server = (PersonService) registry.lookup("PersonService");
            Person person = server.transferPerson();
        } catch (NotBoundException | RemoteException e) {
            fail("Exception Occurred: " + e);
        }
    }
}
