/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class Coder extends Combining {

    public Coder(int numOut) {
        // + 1 because of 'W' out port
        super((int)(Math.pow(2, numOut)), numOut + 1);
        for (int i = 0; i < numIn; i++) 
        	inValues[i] = 0;
    }

    @Override
    public void calculateState() {

        for (int i=0; i<outValues.length; i++) {
            outValues[i] = 0;
        }

        for (int i=inValues.length - 1; i>=0; i--) {
            if (inValues[i] == 1) {
                generateOutValues(i);
                return;
            }
        }
        
    }

    private void generateOutValues (int value) {
        for (int i=0; i<outValues.length - 1; i++) {
            outValues[i] = value & 0x00000001;
            value >>= 1;
        }

        //W = 1
        outValues[outValues.length - 1] = 1;
    }

}
