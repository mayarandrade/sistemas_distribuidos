
package org.sd.rmi.calculator;

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
 * @author mayarandrade
 */
public class CalculatorServiceIntegrationTest {
    private CalculatorServiceImpl calculatorService;
    
    @Before
    public void init(){
        try {
            calculatorService = new CalculatorServiceImpl();
            calculatorService.createStubAndBind();
        } catch (RemoteException e) {
            fail("Exception occurred: " + e);
        }
    }
    
    @Test
    public void whenClientRequestsCalculatorAndDoesSum() {
        try {
            Registry registry = LocateRegistry.getRegistry();
            CalculatorService server = (CalculatorService) registry.lookup("CalculatorService");
            Calculator calc = server.transferCalculator();
            
            int addend1 = 2;
            int addend2 = 3;
            
            assertEquals(addend1 + addend2, calc.summation(addend1, addend2));
        } catch (NotBoundException | RemoteException e) {
            fail("Exception occurred: " + e);
        }
    }
}
