/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class PC extends Sequential {

    //PC has 4 input ports
    //first is for data
    //second is 'ldHigh'
    //third is 'ldLow'
    //forth is 'inc'
    public PC(int state) {
        super(4, state);
        outValues[0] = state;
    }

    @Override
    protected void calculateState() {

        //ldHigh
        if (inValues[1] == 1) {
            state &= 0x00FF;
            state |= (inValues[0] & 0xFF00);
            outValues[0] = state;
        }

        //ldLow
        if (inValues[2] == 1) {
            state &= 0xFF00;
            state |= (inValues[0] & 0x00FF);
            outValues[0] = state;
            return;
        }

        //inc
        if (inValues[3] == 1) {
            state = (state + 1) & 0xFFFF;
            outValues[0] = state;
            return;
        }

    }



}
