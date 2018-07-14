/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class MoreToOne extends Combining {

    public MoreToOne(int numIn) {
        super(numIn, 1);
    }

    @Override
    public void calculateState() {
        
        int newValue = 0;

        for (int i=inValues.length - 1; i>=0; i--) {
            newValue = (newValue << 8) | (inValues[i] & 0xff);
        }
        
        outValues[0] = newValue;

    }

}
