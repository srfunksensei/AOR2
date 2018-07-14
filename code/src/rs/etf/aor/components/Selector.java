/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class Selector extends Combining {
    
    private int startBit, endBit;

    public Selector (int bitToSelect) {
        this (bitToSelect, bitToSelect);
    }

    public Selector(int startBit, int endBit) {
        super(1, 1);
        this.startBit = startBit;
        this.endBit = endBit;
    }

    @Override
    public void calculateState() {

        int mask = 1;

        for (int i=0; i<endBit - startBit; i++) {
            mask = (mask << 1) | 0x1;
        }

        mask <<= startBit;

        outValues[0] = (inValues[0] & mask) >> startBit;
    }

}
