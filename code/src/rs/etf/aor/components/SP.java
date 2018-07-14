/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Mladen
 */
public class SP extends Sequential {

    //SP has 4 input ports
    //first is for data
    //second is 'ldSP'
    //third is 'incSP'
    //forth is 'decSP'
    public SP(int state) {
        super(4, state);
        outValues[0] = state;
    }

    @Override
    protected void calculateState() {
        //ldSP
        if (inValues[1] == 1) {
            state = inValues[0];
            outValues[0] = state;
        }

        //incSP
        if (inValues[2] == 1) {
            state = (state + 1) & 0xFFFF;
            outValues[0] = state;
            return;
        }

        //decSP
        if (inValues[3] == 1) {
            state = (state - 1) & 0xFFFF;
            outValues[0] = state;
            return;
        }
    }

}
