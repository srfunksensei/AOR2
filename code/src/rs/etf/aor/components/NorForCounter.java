/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author pm070001
 */
public class NorForCounter extends Combining{

       public NorForCounter() {
        super(1, 1);
    }

    @Override
    public void calculateState() {

        if (inValues[0] == 0)
            outValues[0] = 1;
        else
            outValues[0] = 0;

    }

}
