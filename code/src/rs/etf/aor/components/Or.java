/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class Or extends Combining {

    public Or(int numIn) {
        super(numIn, 1);
    }

    @Override
    public void calculateState() {
        outValues[0] = 0;

        for (int i=0; i<inValues.length; i++) {
            if (inValues[i] == 1) {
                outValues[0] = 1;
                return;
            }
        }

    }

}
