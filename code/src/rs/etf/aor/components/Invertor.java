/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class Invertor extends Combining {

    public Invertor () {
        super(1, 1);
    }

    @Override
    public void calculateState() {

        //it can be 0 or -1
        if (inValues[0] != 1) {
            outValues[0] = 1;
        }
        else {
            outValues[0] = 0;
        }

    }

}
