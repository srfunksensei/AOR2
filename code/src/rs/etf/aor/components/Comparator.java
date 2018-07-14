/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class Comparator extends Combining {

    //fist half of input ports are for first operand
    //second half of input ports are for second operand
    //outValues[0] - greater
    //outValues[1] - lower
    //outValues[2] - equal
    public Comparator (int numIn) {
        super(numIn, 3);
    }

    @Override
    public void calculateState() {

        for (int i=0; i<numIn/2; i++) {
            if (inValues[i] > inValues[i+numIn/2]) {
                outValues[0] = 1;
                outValues[1] = 0;
                outValues[2] = 0;
                return;
            }
            if (inValues[i] < inValues[i+numIn/2]) {
                outValues[0] = 0;
                outValues[1] = 1;
                outValues[2] = 0;
                return;
            }
        }

        outValues[0] = 0;
        outValues[1] = 0;
        outValues[2] = 1;

    }

}
