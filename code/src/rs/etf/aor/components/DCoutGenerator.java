/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class DCoutGenerator extends Combining {

    public DCoutGenerator() {
        super(1, 1);
    }

    @Override
    public void calculateState() {
        int value = 1;
        value <<= inValues[0];
        outValues[0] = value;
    }

}
