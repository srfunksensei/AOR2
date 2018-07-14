/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.etf.aor.components;

/**
 *
 * @author MB
 */
public class GenSigUp extends Combining {

    public int numTClk = 0xB0;
    public int[] Tclk = new int[numTClk];
    private int[] conditions;

    //inValues: 0.from dc, 1. l1, 2. l2, 3. l3, 4. l4,
    // 5. l5, 6. MOVD or POP, 7. immed, 8. regdir
    // 9. imm_regdir, 10. Z, 11. brnotPrekid
    //12. errADR, 13. errOP
    public GenSigUp(int numIn, int numOut) {
        super(numIn, numOut);

        for (int i = 0; i < numOut; i++) {
            outValues[i] = 0;
        }

        conditions = new int[12];

    }

    private void initConditions() {

        for (int i = 0; i < conditions.length; i++) {
            conditions[i] = 0;
        }

        //bruncnd
        conditions[0] = Tclk[0x0d] + Tclk[0x1a] + Tclk[0x1c] + Tclk[0x1e] + Tclk[0x22]
                + Tclk[0x24] + Tclk[0x2d] + Tclk[0x31] + Tclk[0x33] + Tclk[0x3d] + Tclk[0x40]
                + Tclk[0x44] + Tclk[0x48] + Tclk[0x4c] + Tclk[0x50] + Tclk[0x55] + Tclk[0x5d]
                + Tclk[0x60] + Tclk[0x6c] + Tclk[0x6e] + Tclk[0x75] + Tclk[0x81] + Tclk[0x85]
                + Tclk[0x89] + Tclk[0x8b] + Tclk[0x8d] + Tclk[0x8f] + Tclk[0x91] + Tclk[0x97]
                + Tclk[0x99] + Tclk[0xaf];

        //brli
        conditions[1] = Tclk[0x04];

        //brl2
        conditions[2] = Tclk[0x05];

        //brl3
        conditions[3] = Tclk[0x09];

        //brl4
        conditions[4] = Tclk[0x11];

        //brl5
        conditions[5] = Tclk[0x15];

        //brMOVD_POP
        conditions[6] = Tclk[0x34];

        //brimmed
        conditions[7] = Tclk[0x41] + +Tclk[0x4d] + Tclk[0x76] + Tclk[0x82] + Tclk[0x86];

        //brregdir
        conditions[8] = Tclk[0x92];

        //brregdir_imm
        conditions[9] = Tclk[0x5e];

        //brZ
        conditions[10] = Tclk[0x51];

        //brnotPrekid
        conditions[11] = Tclk[0x9b];

    }

    @Override
    public void calculateState() {

        for (int i = 0; i < numTClk; i++) {
            Tclk[i] = 0;
        }

        Tclk[inValues[0]] = 1;

        // calculating out signal values
        initConditions();

        //brop
        outValues[0] = Tclk[0x3b];

        //bradr
        outValues[1] = Tclk[0x19];

        int in11;
        if (inValues[11] == 0) {
            in11 = 1;
        } else {
            in11 = 0;
        }

        int l4;
        if (inValues[4] == 0) {
            l4 = 1;
        } else {
            l4 = 0;
        }

        //branch
        outValues[2] = conditions[0] + conditions[1] * inValues[1] + conditions[2] * inValues[2] + conditions[3] * inValues[3] + conditions[4] * l4
                + conditions[5] * inValues[5] + conditions[6] * inValues[6] + conditions[7] * inValues[7] + conditions[8] * inValues[8] + conditions[9] * inValues[9]
                + conditions[10] * inValues[10] + conditions[11] * (in11);

        //val00
        outValues[3] = Tclk[0x91] + Tclk[0x9b] + Tclk[0xaf];

        //val0e
        outValues[4] = Tclk[0x04];

        //val19
        outValues[5] = Tclk[0x11] + Tclk[0x15];

        //val34
        outValues[6] = Tclk[0x1e] + Tclk[0x22] + Tclk[0x24] + Tclk[0x2d] + Tclk[0x31];

        //val3b
        outValues[7] = Tclk[0x05] + Tclk[0x09] + Tclk[0x0d] + Tclk[0x1c] + Tclk[0x33]
                + Tclk[0x34];

        //val92
        outValues[8] = Tclk[0x44] + Tclk[0x50] + Tclk[0x81] + Tclk[0x85] + Tclk[0x89];

        //val98
        outValues[9] = Tclk[0x92];

        //val9c
        outValues[10] = Tclk[0x1a] + Tclk[0x41] + Tclk[0x4d] + Tclk[0x5e] + Tclk[0x76]
                + Tclk[0x82] + Tclk[0x86];

        //val9d
        outValues[11] = Tclk[0x3d] + Tclk[0x40] + Tclk[0x48] + Tclk[0x4c] + Tclk[0x51]
                + Tclk[0x55] + Tclk[0x5d] + Tclk[0x60] + Tclk[0x6c] + Tclk[0x6e] + Tclk[0x75]
                + Tclk[0x8b] + Tclk[0x8d] + Tclk[0x8f] + Tclk[0x91] + Tclk[0x97] + Tclk[0x99];

    }
}
