/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author pm070001
 */
public class KMADR extends Combining {

    private int[] values;
    private int port;

    public KMADR(int numIn) {
        super(numIn, 1);

        values = new int[numIn];

//        regdir      1B
//        indreg      1D
//        indregpom   1F
//        dirmem      23
//        indmem      25
//        rel         2E
//        immed       32

        
        values[0] = 0x1b;
        values[1] = 0x1d;
        values[2] = 0x1f;
        values[3] = 0x23;
        values[4] = 0x25;
        values[5] = 0x2e;
        values[6] = 0x32;

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
