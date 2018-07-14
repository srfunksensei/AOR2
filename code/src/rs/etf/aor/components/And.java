/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class And extends Combining {

    public And(int numIn) {
        super(numIn, 1);
    }

    @Override
    public void calculateState() {
        outValues[0] = 1;

        for (int i=0; i<inValues.length; i++) {
            if (inValues[i] == 0) {
                outValues[0] = 0;
                return;
            }
        }

    }

}
