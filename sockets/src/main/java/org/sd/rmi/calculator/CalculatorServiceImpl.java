
package org.sd.rmi.calculator;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author mayarandrade
 */
public class CalculatorServiceImpl implements CalculatorService {
    
    @Override
    public Calculator transferCalculator() throws RemoteException {
        Calculator c = new Calculator();
        return c;
    }
    
    public void createStubAndBind() throws RemoteException {
        CalculatorService stub = (CalculatorService) UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("CalculatorService", stub);
    }
    
}
