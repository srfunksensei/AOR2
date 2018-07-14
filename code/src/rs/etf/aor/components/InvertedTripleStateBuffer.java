/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.etf.aor.components;

/**
 *
 * @author MB
 */
public class InvertedTripleStateBuffer extends Combining {

    //first input port is for data
    //second input port is for control
    public InvertedTripleStateBuffer() {
        super(2, 1);
    }

    @Override
    public void calculateState() {
        //it can be 0 or 1 or highZ
        if (inValues[1] == 1) {
            if (inValues[0] == 1) {
                outValues[0] = 0;
            } else {
                outValues[0] = 1;
            } 
        } else {
            outValues[0] = -1;
        }
    }
}
