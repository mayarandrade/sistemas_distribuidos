
package org.sd.rmi.messenger;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Mayara
 */
public class MessengerIntegrationTest {
    private MessengerServiceImpl messengerService;
    
    @Before
    public void init() {
        try {
            messengerService = new MessengerServiceImpl();
            messengerService.createStubAndBind();
        } catch (RemoteException e) {
            fail("Exception Occurred: " + e);
        }
    }
    
    @Test
    public void whenClientSendsMessageToServer_thenServerSendsResponseMessage() {
        try {
            Registry registry = LocateRegistry.getRegistry();
            MessengerService server = (MessengerService) registry.lookup("MessengerService");
            String responseMessage = server.sendMessage("Client Message");
            
            String expectedMessage = "Server Message";
            assertEquals(responseMessage, expectedMessage);  
        } catch (NotBoundException | RemoteException e) {
            fail("Exception Occurred: " + e);
        }
    }
}
