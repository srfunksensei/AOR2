/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class MergePSW extends Combining {

    public MergePSW() {
        super(8, 1);
    }

    @Override
    public void calculateState() {

        if (inValues[7] == -1 || inValues[6] == -1 || inValues[5] == -1 || inValues[4] == -1 ||
                inValues[3] == -1 || inValues[2] == -1 || inValues[1] == -1 || inValues[0] == -1) {
            outValues[0] = -1;
            return;
        }

        outValues[0] = ((inValues[7] << 7) & 0x80) |
                       ((inValues[6] << 6) & 0x40) |
                       ((inValues[5] << 5) & 0x20) |
                       ((inValues[4] << 4) & 0x10) |
                       ((inValues[3] << 3) & 0x08) |
                       ((inValues[2] << 2) & 0x04) |
                       ((inValues[1] << 1) & 0x02) |
                       (inValues[0] & 0x01);
    }

    @Override
    public void refreshNextLines() {
        for (int i = 0; i < outLines.length; i++) {
            if (outLines[i] != null)
                ((Bus)outLines[i]).refreshValue(outValues[outLines[i].getPreviousCompPort()], this);
        }
    }

}
