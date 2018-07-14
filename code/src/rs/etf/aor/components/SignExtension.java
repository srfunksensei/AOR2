/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class SignExtension extends Combining {

    public SignExtension(int outputThiknes) {
        super(1, 1);
    }

    @Override
    public void calculateState() {
        outValues[0] = (0 - inValues[0]) & 0xFF;
    }

}
