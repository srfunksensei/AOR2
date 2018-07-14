/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class SRFlipFlop extends Sequential {

    //SR flip flop has 2 inputs
    //first input is 'S'
    //second input is 'R'
    public SRFlipFlop(int state) {
        super(2, 2, state);
        outValues[0] = state;
        outValues[1] = (~state) & 0x00000001;
    }

    @Override
    protected void calculateState() {
        if (inValues[0] == 1) {
            state = 1;
            outValues[0] = state;
            outValues[1] = (~state) & 0x00000001;
            return;
        }
        if (inValues[1] == 1) {
            state = 0;
            outValues[0] = state;
            outValues[1] = (~state) & 0x00000001;
            return;
        }
    }

}
