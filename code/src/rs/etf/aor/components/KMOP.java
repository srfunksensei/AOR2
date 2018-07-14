/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

import javax.swing.JPanel;
import rs.etf.aor.gui.CPU_upravljacka_prvi;

/**
 *
 * @author pm070001
 */
public class KMOP extends Combining{

    private int[] values;
    private int port;
    private JPanel panel;

    public KMOP(int numIn, JPanel panel) {
        super(numIn, 1);
        this.panel = panel;

        values = new int[numIn];

//        MOVS      3E	RTS	65
//        MOVD      41	INT	6D
//        ADD       45	PUSH	6F
//        AND       49	POP	76
//        ASR       4D	INC	82
//        BNZ       51	DEC	86
//        JSR       56	INTE	8A
//        JMP       5C	INTD	8C
//        JMPIND    5E	TRPE	8E
//        RTI       61	TRPD	90


        values[0] = 0x3e;
        values[1] = 0x41;
        values[2] = 0x45;
        values[3] = 0x49;
        values[4] = 0x4d;
        values[5] = 0x51;
        values[6] = 0x56;
        values[7] = 0x5c;
        values[8] = 0x5e;
        values[9] = 0x61;
        values[10] = 0x65;
        values[11] = 0x6d;
        values[12] = 0x6f;
        values[13] = 0x76;
        values[14] = 0x82;
        values[15] = 0x86;
        values[16] = 0x8a;
        values[17] = 0x8c;
        values[18] = 0x8e;
        values[19] = 0x90;
        values[20] = 0x00; //!!!!!!!!!!!!!!!! HLT
        //errOP
        values[21] = 0x3c;

    }

    @Override
    public void refreshValue(int newValue, int port) {
        if (newValue == 1)
            this.port = port;
        if (port != 20){
            calculateState();
            refreshNextLines();
        }
        else{
            ((CPU_upravljacka_prvi)panel).lines[22].refreshValue(1);
        }

   }

    @Override
    public void calculateState() {
        outValues[0] = values[port];
    }


}
