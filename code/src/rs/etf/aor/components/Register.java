/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class Register extends Sequential {

    //Register has data input port and 'ld' control port
    //first port is data, second is ld
    //output ports: 0. data, 1. value at bit 0, 2. value at bit 15, 3. value at bit 7
    public Register(int state) {
        super(2, 4, state);
        outValues[0] = state;
        calculateBits();
    }

    @Override
    protected void calculateState() {
        if (inValues[1] == 1) {
            state = inValues[0];
        }
        outValues[0] = state;
        calculateBits();
    }

    private void calculateBits() {
        int mask = 1;
        outValues[1] = outValues[0] & mask;
        mask = 0x8000;
        outValues[2] = (outValues[0] & mask) >>> 15;
        mask = 0x0080;
        outValues[3] = (outValues[0] & mask) >>> 7;
    }

}
