/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class Multiplexer extends Combining {

    //fist 2^numIn ports are input ports
    //last numIn ports are control ports
    //numIn is number of control ports
    // number of control ports
    private int controlIn;

    public Multiplexer(int numIn) {
        super(numIn + (int) (Math.pow(2, numIn)), 1);
        controlIn = numIn;
    }

    @Override
    public void calculateState() {

        outValues[0] = inValues[calculateSelectedInput()];

    }

    private int calculateSelectedInput() {
        int selectedInput = 0;

        int i;
        for (i = 0; i < controlIn; i++) {
            selectedInput <<= 1;

            int temp = inValues[(int) (Math.pow(2, controlIn)) + i];
            //if it is highZ treat it like 0
            if (temp == -1) {
                temp = 0;
            }

            selectedInput |= (temp & 0x00000001);
        }

        return selectedInput;

    }
}
