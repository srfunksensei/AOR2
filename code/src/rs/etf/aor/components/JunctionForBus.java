/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class JunctionForBus extends Combining {

    private boolean[] alreadyRefreshed;
    private int cnt;

    public JunctionForBus(int num) {
        super(num, num);
        alreadyRefreshed = new boolean[num];
        cnt = 0;
    }

    @Override
    public void calculateState() {
        
    }

    public void calculateState(int port) {
        for (int i=0; i<outValues.length; i++) {
            outValues[i] = inValues[port];
        }
    }

    public void refreshNextLines(int port) {
        for (int i=0; i<outLines.length; i++) {
            if (i != port) {
                if (! alreadyRefreshed[i]) {
                    ((Bus)outLines[i]).refreshValue(outValues[port], this);
                }
            }
        }
    }

    @Override
    public void refreshValue(int newValue, int port) {

        cnt++;

        alreadyRefreshed[port] = true;
        inValues[port] = newValue;

        calculateState(port);
        refreshNextLines(port);

        cnt--;

        if (cnt == 0) {
            for (int i=0; i<alreadyRefreshed.length; i++) {
                alreadyRefreshed[i] = false;
            }
        }

    }

}
