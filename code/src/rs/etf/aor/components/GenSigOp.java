/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.etf.aor.components;

/**
 *
 * @author pm070001
 */
public class GenSigOp extends Combining {

    public int numTClk = 0xB0;
    public int[] Tclk = new int[numTClk];

    public GenSigOp(int numOut) {
        super(1, numOut);

        for (int i = 0; i < numOut; i++) {
            outValues[i] = 0;
        }

    }

    @Override
    public void calculateState() {

        for (int i = 0; i < numTClk; i++) {
            Tclk[i] = 0;
        }

        Tclk[inValues[0]] = 1;

        // calculating out signal values

        // resetF

        outValues[0] = Tclk[0];

        // PCout

        outValues[1] = Tclk[0x0] + Tclk[0x3] + Tclk[0x8] + Tclk[0x10] + Tclk[0x14]
                + Tclk[0x2e] + Tclk[0x52] + Tclk[0x56] + Tclk[0x5a] + Tclk[0x9c] + Tclk[0xa0];

        // ldMAR

        outValues[2] = Tclk[0x0] + Tclk[0x3] + Tclk[0x8] + Tclk[0x10] + Tclk[0x14]
                + Tclk[0x1d] + Tclk[0x21] + Tclk[0x23] + Tclk[0x25] + Tclk[0x2c]
                + Tclk[0x30] + Tclk[0x57] + Tclk[0x59] + Tclk[0x61] + Tclk[0x65]
                + Tclk[0x67] + Tclk[0x70] + Tclk[0x72] + Tclk[0x78] + Tclk[0x7a]
                + Tclk[0x7d] + Tclk[0x9d] + Tclk[0x9f] + Tclk[0xa2] + Tclk[0xa8];

        // read

        outValues[3] = Tclk[0x1] + Tclk[0x6] + Tclk[0xa] + Tclk[0xe] + Tclk[0x12]
                + Tclk[0x16] + Tclk[0x26] + Tclk[0x29] + Tclk[0x35] + Tclk[0x38]
                + Tclk[0x62] + Tclk[0x66] + Tclk[0x69] + Tclk[0x79] + Tclk[0x7c]
                + Tclk[0xa9] + Tclk[0xac];

        // ldMBR

        outValues[4] = Tclk[0x2] + Tclk[0x7] + Tclk[0xb] + Tclk[0xf] + Tclk[0x13]
                + Tclk[0x17] + Tclk[0x27] + Tclk[0x2a] + Tclk[0x36] + Tclk[0x39]
                + Tclk[0x56] + Tclk[0x5a] + Tclk[0x63] + Tclk[0x67] + Tclk[0x6a]
                + Tclk[0x6f] + Tclk[0x73] + Tclk[0x7a] + Tclk[0x7d] + Tclk[0x93]
                + Tclk[0x95] + Tclk[0x9c] + Tclk[0xa0] + Tclk[0xa3] + Tclk[0xaa]
                + Tclk[0xad];

        //incPC

        outValues[5] = Tclk[0x2] + Tclk[0x7] + Tclk[0xb] + Tclk[0xf] + Tclk[0x13]
                + Tclk[0x17];

        //MBRout

        outValues[6] = Tclk[0x3] + Tclk[0x8] + Tclk[0xc] + Tclk[0x10] + Tclk[0x14]
                + Tclk[0x18] + Tclk[0x28] + Tclk[0x2b] + Tclk[0x37] + Tclk[0x3a]
                + Tclk[0x64] + Tclk[0x68] + Tclk[0x6b] + Tclk[0x7b]
                + Tclk[0x7e] + Tclk[0xab] + Tclk[0xae];

        //ldIR1

        outValues[7] = Tclk[0x3];

        //incMAR

        outValues[8] = Tclk[0x27] + Tclk[0x36] + Tclk[0xab];

        // ldIR2

        outValues[9] = Tclk[0x8] + Tclk[0x10];

        // ldIR3

        outValues[10] = Tclk[0xc] + Tclk[0x14];

        // ldIR4

        outValues[11] = Tclk[0x18];

        // REGout

        outValues[12] = Tclk[0x1b] + Tclk[0x1d] + Tclk[0x1f] + Tclk[0x42] + Tclk[0x45]
                + Tclk[0x49];

        // ldBLow

        outValues[13] = Tclk[0x1b] + Tclk[0x2b] + Tclk[0x32] + Tclk[0x3a] + Tclk[0x42]
                + Tclk[0x4f] + Tclk[0x7e] + Tclk[0x84] + Tclk[0x88];

        // ldBHigh

        outValues[14] = Tclk[0x1b] + Tclk[0x28] + Tclk[0x32] + Tclk[0x37] + Tclk[0x42]
                + Tclk[0x4f] + Tclk[0x7b] + Tclk[0x84] + Tclk[0x88];

        // fdo

        outValues[15] = Tclk[0x1b] + Tclk[0x1d] + Tclk[0x1f];

        // DSout

        outValues[16] = Tclk[0x1d] + Tclk[0x1f] + Tclk[0x21] + Tclk[0x30] + Tclk[0x42]
                + Tclk[0x45] + Tclk[0x47]
                + Tclk[0x49] + Tclk[0x4b] //ovo je dodato za izlaz iz alu!!!
                + Tclk[0x57] + Tclk[0x59] + Tclk[0x61]
                + Tclk[0x65] + Tclk[0x67] + Tclk[0x70] + Tclk[0x72] + Tclk[0x78]
                + Tclk[0x7a] + Tclk[0x9d] + Tclk[0x9f] + Tclk[0xa2] + Tclk[0xa6]
                + Tclk[0xa8];

        // ldX

        outValues[17] = Tclk[0x1f] + Tclk[0x2e] + Tclk[0x3e] + Tclk[0x42] + Tclk[0x45]
                + Tclk[0x49] + Tclk[0x4e] + Tclk[0x52] + Tclk[0x7f] + Tclk[0x83]
                + Tclk[0x87] + Tclk[0xa5] + Tclk[0xa6];

        // IR3out

        outValues[18] = Tclk[0x20] + Tclk[0x2f];

        // ldY

        outValues[19] = Tclk[0x20] + Tclk[0x2f] + Tclk[0x46] + Tclk[0x4a] + Tclk[0x53]
                + Tclk[0xa7];

        // add

        outValues[20] = Tclk[0x21] + Tclk[0x30] + Tclk[0x47] + Tclk[0x54] + Tclk[0xa8];

        // ALUout

        outValues[21] = Tclk[0x21] + Tclk[0x30] + Tclk[0x47] + Tclk[0x4b] + Tclk[0x4f]
                + Tclk[0x54] + Tclk[0x84] + Tclk[0x88] + Tclk[0xa6] + Tclk[0xa8];

        // IR_DAout

        outValues[22] = Tclk[0x23] + Tclk[0x25] + Tclk[0x32];

        // Bout

        outValues[23] = Tclk[0x2c] + Tclk[0x3e] + Tclk[0x46] + Tclk[0x4a] + Tclk[0x4e]
                + Tclk[0x5f] + Tclk[0x6f] + Tclk[0x73] + Tclk[0x7f] + Tclk[0x83]
                + Tclk[0x87] + Tclk[0x93] + Tclk[0x95] + Tclk[0x98];

        // SDout

        outValues[24] = Tclk[0x32] + Tclk[0x5c] + Tclk[0x5f];

        // setCOD

        outValues[25] = Tclk[0x3c];

        // daREG

        outValues[26] = Tclk[0x3e] + Tclk[0x42] + Tclk[0x45] + Tclk[0x47] + Tclk[0x49]
                + Tclk[0x4b];

        // ldREG

        outValues[27] = Tclk[0x3e] + Tclk[0x47] + Tclk[0x4b] + Tclk[0x98];

        // trans

        outValues[28] = Tclk[0x3f] + Tclk[0x43] + Tclk[0x80];

        // ldPSWALU

        outValues[29] = Tclk[0x3f] + Tclk[0x43] + Tclk[0x47] + Tclk[0x4b] + Tclk[0x4f]
                + Tclk[0x80] + Tclk[0x84] + Tclk[0x88];

        // and

        outValues[30] = Tclk[0x4b];

        // asr

        outValues[31] = Tclk[0x4f];

        // IR2out

        outValues[32] = Tclk[0x53];

        // ldPCHigh

        outValues[33] = Tclk[0x54] + Tclk[0x5c] + Tclk[0x5f] + Tclk[0x68] + Tclk[0xab];

        // ldPCLow

        outValues[34] = Tclk[0x54] + Tclk[0x5c] + Tclk[0x5f] + Tclk[0x6b] + Tclk[0xae];

        // decSP

        outValues[35] = Tclk[0x56] + Tclk[0x57] + Tclk[0x6f] + Tclk[0x70] + Tclk[0x9c]
                + Tclk[0x9d] + Tclk[0x9f];

        // mxMBR

        outValues[36] = Tclk[0x56] + Tclk[0x5a] + Tclk[0x6f] + Tclk[0x73] + Tclk[0x93]
                + Tclk[0x95] + Tclk[0x9c] + Tclk[0xa0] + Tclk[0xa3];

        // upSPout

        outValues[37] = Tclk[0x57] + Tclk[0x59] + Tclk[0x61] + Tclk[0x65] + Tclk[0x67]
                + Tclk[0x70] + Tclk[0x72] + Tclk[0x78] + Tclk[0x7a] + Tclk[0x9d]
                + Tclk[0x9f] + Tclk[0xa2];

        // write

        outValues[38] = Tclk[0x58] + Tclk[0x5b] + Tclk[0x71] + Tclk[0x74] + Tclk[0x94]
                + Tclk[0x96] + Tclk[0x9e] + Tclk[0xa1] + Tclk[0xa4];

        // MBRHigh

        outValues[39] = Tclk[0x5a] + Tclk[0x73] + Tclk[0x95] + Tclk[0xa0];

        // IR_JAout

        outValues[40] = Tclk[0x5c];

        // incSP

        outValues[41] = Tclk[0x61] + Tclk[0x65] + Tclk[0x67] + Tclk[0x78] + Tclk[0x7a];

        // ldPSW

        outValues[42] = Tclk[0x64];

        // setINT

        outValues[43] = Tclk[0x6d];

        // ldA

        outValues[44] = Tclk[0x77];

        // Aout

        outValues[45] = Tclk[0x7d];

        // inc

        outValues[46] = Tclk[0x84];

        // dec

        outValues[47] = Tclk[0x88];

        // setI

        outValues[48] = Tclk[0x8a];

        // resetI

        outValues[49] = Tclk[0x8c];

        // setT

        outValues[50] = Tclk[0x8e];

        // resetT

        outValues[51] = Tclk[0x90];

        // decMAR

        outValues[52] = Tclk[0x95];

        // fvo

        outValues[53] = Tclk[0x98];

        //setADR

        outValues[54] = Tclk[0x9a];

        // ldBR

        outValues[55] = Tclk[0x9c];

        // intack

        outValues[56] = Tclk[0x9c];

        // PSWout

        outValues[57] = Tclk[0xa3];

        // BRout

        outValues[58] = Tclk[0xa5];

        // shl

        outValues[59] = Tclk[0xa6];

        // IVTPout

        outValues[60] = Tclk[0xa7];

        //MARout

        outValues[61] = Tclk[0x77];


    }

    @Override
    public void refreshNextLines() {
        for (int i=0; i<outValues.length; i++) {
            if (outValues[i] == 0) {
                if (outLines[i] != null) {
                    outLines[i].refreshValue(outValues[outLines[i].getPreviousCompPort()]);
                }
            }
        }
        for (int i=0; i<outValues.length; i++) {
            if (outValues[i] == 1) {
                if (outLines[i] != null) {
                    outLines[i].refreshValue(outValues[outLines[i].getPreviousCompPort()]);
                }
            }
        }
    }
}
