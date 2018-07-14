/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class Decoder extends Combining {

    public Decoder(int numIn) {
        // + 1 because of 'E' in port
        super(numIn + 1, (int)(Math.pow(2, numIn)));
        inValues[numIn] = 1;
    }

    @Override
    public void calculateState() {

        for (int i=0; i<outValues.length; i++) {
            outValues[i] = 0;
        }

        //if E == 1
        if (inValues[inValues.length - 1] == 1) {
            generateOutValues();
        }

    }

    private void generateOutValues () {

        int inValue = 0;

        for (int i=inValues.length - 2; i>=0; i--) {
            inValue <<= 1;

            int temp = inValues[i];
            //if it is highZ treat it like 0
            if (temp == -1) temp = 0;

            inValue |= (temp & 0x00000001);
        }

        outValues[inValue] = 1;

    }

}
