/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class TripleStateBuffer extends Combining {

    //first input port is for data
    //second input port is for control
    public TripleStateBuffer() {
        super(2, 1);
        inValues[0] = -1;
    }

    @Override
    public void calculateState() {
        if (inValues[1] == 1) {
            outValues[0] = inValues[0];
        } else {
            outValues[0] = -1;
        }
    }

    @Override
    public void refreshNextLines() {
        for (int i = 0; i < outLines.length; i++) {
            if (outLines[i] != null) {
                ((Bus) outLines[i]).refreshValue(outValues[outLines[i].getPreviousCompPort()], this);
            }
        }
    }
}
