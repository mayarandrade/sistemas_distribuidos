
package org.sd.rmi.calculator;

import java.io.Serializable;

/**
 *
 * @author mayarandrade
 */
public class Calculator implements Serializable {
    private int addend1;
    private int addend2;
    private int sum;
    
    public Calculator() {
        this.addend1 = 0;
        this.addend2 = 0;
        this.sum = 0;
    }

    public int getAddend1() {
        return addend1;
    }

    public void setAddend1(int addend1) {
        this.addend1 = addend1;
    }

    public int getAddend2() {
        return addend2;
    }

    public void setAddend2(int addend2) {
        this.addend2 = addend2;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
    
    
    
    public int summation(int addend1, int addend2) {
        this.addend1 = addend1;
        this.addend2 = addend2;
        this.sum = this.addend1 + this.addend2;
        return this.sum;
    }
}
