/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author pm070001
 */
public class KMBRANCH extends Combining{

    private int port;
    private int[] values;

    public KMBRANCH(int numIn) {
        super(numIn, 1);

        values = new int[numIn];

        values[0] = 0x00;
        values[1] = 0x0e;
        values[2] = 0x19;
        values[3] = 0x34;
        values[4] = 0x3b;
        values[5] = 0x92;
        values[6] = 0x98;
        values[7] = 0x9a;
        values[8] = 0x9b;

    }

    @Override
    public void refreshValue(int newValue, int port) {
        if (newValue == 1)
            this.port = port;
	calculateState();
	refreshNextLines();
    }




    @Override
    public void calculateState() {
        outValues[0] = values[port];
    }

    

}
