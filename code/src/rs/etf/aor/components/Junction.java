/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class Junction extends Combining {

    public Junction(int numOut) {
        super(1, numOut);
    }

    @Override
    public void calculateState() {

        for (int i=0; i<outValues.length; i++) {
            outValues[i] = inValues[0];
        }

    }

}
