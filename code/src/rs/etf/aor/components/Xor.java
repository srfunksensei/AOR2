/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class Xor extends Combining {

    public Xor(int numIn) {
        super(numIn, 1);
    }

    @Override
    public void calculateState() {

        int countTrue = 0;

        for (int i=0; i<inValues.length; i++) {
            if (inValues[i] == 1) {
                countTrue++;
            }
        }

        if (countTrue % 2 == 0) {
            outValues[0] = 0;
        }

        outValues[0] = 1;

    }

}
