
package org.sd.rmi.calculator;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author mayarandrade
 */
public interface CalculatorService extends Remote {
    public Calculator transferCalculator() throws RemoteException;
}
