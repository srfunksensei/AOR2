/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class DFlipFlop extends Sequential {

    //flip flop has only one input port
    public DFlipFlop(int state) {
        super(1, state);
    }

    @Override
    protected void calculateState() {
        state = inValues[0];
        outValues[0] = state;
    }

}
