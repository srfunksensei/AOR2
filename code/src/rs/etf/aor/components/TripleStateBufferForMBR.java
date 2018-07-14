/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class TripleStateBufferForMBR extends TripleStateBuffer {

    @Override
    public void calculateState() {
        if (inValues[1] == 1) {
            outValues[0] = (inValues[0] & 0xFF) | ((inValues[0] << 8) &0xFF00);
        }
        else {
            outValues[0] = -1;
        }
    }



}
