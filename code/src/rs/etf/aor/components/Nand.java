/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class Nand extends Combining {

    public Nand(int numIn) {
        super(numIn, 1);
    }

    @Override
    public void calculateState() {
        outValues[0] = 0;

        for (int i=0; i<inValues.length; i++) {

            //it can be 0 or -1
            if (inValues[i] != 1) {
                outValues[0] = 1;
                return;
            }
        }

    }

}
