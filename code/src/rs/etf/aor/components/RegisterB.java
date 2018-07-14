/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class RegisterB extends Sequential {

    //PC has 3 input ports
    //first is for data
    //second is 'ldHigh'
    //third is 'ldLow'
    public RegisterB(int state) {
        super(3, state);
        outValues[0] = state;
    }

    @Override
    protected void calculateState() {

        //ldHigh
        if (inValues[1] == 1) {
            state &= 0x00FF;
            state |= (inValues[0] & 0xFF00);
        }

        //ldLow
        if (inValues[2] == 1) {
            state &= 0xFF00;
            state |= (inValues[0] & 0x00FF);
        }

        outValues[0] = state;

    }

}
