/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author Dragan
 */
public class ALU extends Combining {

    //9 inputs: 0. X, 1. Y, 2. trans, 3. shl, 4. asr, 5. and, 6. add, 7. inc, 8. dec
    //2 outputs: 0. ALU, 1. C16, 2. ALU0, 3. ALU1, 4. ALU2, 5. ALU3, 6. ALU4, 7. ALU5, 8. ALU6
    //           9. ALU7, 10. ALU8, 11. ALU9, 12. ALU10, 13. ALU11, 14. ALU12, 15. ALU13, 16. ALU14
    //           17. ALU15
    public ALU() {
        super(9, 18);
    }

    @Override
    public void calculateState() {

        //trans
        if (inValues[2] == 1) {
            outValues[0] = inValues[0];
            outValues[1] = 0;
            calculateBits();
            return;
        }

        //shl
        if (inValues[3] == 1) {
            outValues[0] = inValues[0] << 1;
            outValues[1] = inValues[0] & 0x80000000;
            calculateBits();
            return;
        }

        //asr
        if (inValues[4] == 1) {
            outValues[1] = inValues[0] & 0x00000001;
            outValues[0] = (inValues[0] >> 1) & 0x0000FFFF;
            calculateBits();
            return;
        }

        //and
        if (inValues[5] == 1) {
            outValues[0] = (inValues[0] & inValues[1]) & 0x0000FFFF;
            outValues[1] = 0;
            calculateBits();
            return;
        }

        //add
        if (inValues[6] == 1) {
            outValues[0] = (inValues[0] + inValues[1]) & 0x0000FFFF;
            outValues[1] = ((inValues[0] + inValues[1]) & 0x00010000) >>> 16;
            calculateBits();
            return;
        }

        //inc
        if (inValues[7] == 1) {
            outValues[0] = (inValues[0] + 1) & 0x0000FFFF;
            outValues[1] = ((inValues[0] + 1) & 0x00010000) >>> 16;
            calculateBits();
            return;
        }

        //dec
        if (inValues[8] == 1) {
            outValues[0] = (inValues[0] - 1) & 0x0000FFFF;
            outValues[1] = ((inValues[0] - 1) & 0x00010000) >>> 16;
            calculateBits();
            return;
        }

        outValues[0] = 0;
        outValues[1] = 0;
        calculateBits();

    }

    private void calculateBits() {
        int mask = 1;
        for (int i=0; i<16; i++) {
            outValues[2+i] = (outValues[0] & mask) >> i;
            mask <<= 1;
        }
    }

}
