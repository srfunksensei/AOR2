/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class IncDecRegister extends Sequential {

    //MAR has 4 input ports
    //first is for data
    //second is 'ld'
    //third is 'inc'
    //forth is 'dec'
    public IncDecRegister(int state) {
        super(4, state);
    }

    @Override
    protected void calculateState() {

        //ld
        if (inValues[1] == 1) {
            state = (inValues[0] & 0xFFFF);
            outValues[0] = state;
            return;
        }

        //inc
        if (inValues[2] == 1) {
            state = (state + 1) & 0xFFFF;
            outValues[0] = state;
            return;
        }

        //dec
        if (inValues[3] == 1) {
            state = (state - 1) & 0xFFFF;
            outValues[0] = state;
            return;
        }

    }



}
