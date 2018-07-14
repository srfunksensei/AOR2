/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CPU_blok_prekidi_drugi.java
 *
 * Created on 22.09.2010., 10.19.11
 */
package rs.etf.aor.gui;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import rs.etf.aor.components.And;
import rs.etf.aor.components.Bus;
import rs.etf.aor.components.Coder;
import rs.etf.aor.components.Invertor;
import rs.etf.aor.components.Junction;
import rs.etf.aor.components.Line;
import rs.etf.aor.components.Multiplexer;
import rs.etf.aor.components.Register;
import rs.etf.aor.components.SRFlipFlop;
import rs.etf.aor.components.TripleStateBuffer;

/**
 *
 * @author MB
 */
public class CPU_blok_prekidi_drugi extends javax.swing.JPanel implements PanelsInfo {

    private JPanel parent;
    private String parentTitle = "CPU_organizacija_prekid";
    public Line setINT, setCOD, setADR, setNMI, resetF, intn, inta, intack, pswT, prper, PREKID;
    private Line resetF1, resetF2, resetF3, resetNMI, intn1, intn2;
    private And andNMI, andIntn, andInta;
    public SRFlipFlop INT, COD, ADR, NMI;
    private Junction junResetF, junCod0, junCod1, junCod2, junIntn;
    private Line outINT, outCOD, outADR, outNMI, outCoder0, outCoder1, outCoder2;
    private Coder coder1;
    private Line inIntn0, inInta0, inMP0, inIntn1, inInta1, inMP1, inIntn2, inInta2, inMP2;
    private Multiplexer mul1, mul2;
    private Register regL1, regL2, regL3, regM0, regM2, regM3, regM4;
    Register regBR, regIVTP;
    private Line outRegL1, outRegL2, outRegL3, outMul2, outRegM0, outRegM2, outRegM3, outRegM4;
    public Line prl0, prl1, IR2, ldBR, ldIVTP, outIVTP;
    public Line outMul1, outBR, IVTPout, BRout;
    private TripleStateBuffer ivtpBuff, brBuff;
    Line PRCOD, PRADR;
    //bus
    Bus sbus, dbus;

    /** Creates new form CPU_blok_prekidi_drugi */
    public CPU_blok_prekidi_drugi(JPanel parent) {
        this.parent = parent;
        initComponents();

        INT = new SRFlipFlop(0);
        setINT = new Line(INT, 0, 0, 1);
        setINT.addPoint(new Point(91, 29));
        setINT.addPoint(new Point(109, 29));

        COD = new SRFlipFlop(0);
        setCOD = new Line(COD, 0, 0, 1);
        setCOD.addPoint(new Point(90, 127));
        setCOD.addPoint(new Point(109, 127));

        ADR = new SRFlipFlop(0);
        setADR = new Line(ADR, 0, 0, 1);
        setADR.addPoint(new Point(90, 225));
        setADR.addPoint(new Point(109, 225));

        NMI = new SRFlipFlop(0);
        setNMI = new Line(NMI, 0, 0, 1);
        setNMI.addPoint(new Point(90, 324));
        setNMI.addPoint(new Point(109, 324));

        junResetF = new Junction(3);

        resetF = new Line(junResetF, 0, 0, 1);

        resetF1 = new Line(INT, 1, 0, 1);
        resetF1.addPoint(new Point(90, 82));
        resetF1.addPoint(new Point(109, 82));

        resetF2 = new Line(COD, 1, 0, 1);
        resetF2.addPoint(new Point(90, 180));
        resetF2.addPoint(new Point(109, 180));

        resetF3 = new Line(NMI, 1, 0, 1);
        resetF3.addPoint(new Point(90, 278));
        resetF3.addPoint(new Point(109, 278));

        junResetF.setLine(resetF1, 0);
        junResetF.setLine(resetF2, 1);
        junResetF.setLine(resetF3, 2);

        junIntn = new Junction(2);

        andNMI = new And(2);

        intn1 = new Line(andNMI, 0, 0, 1);
        intn1.addPoint(new Point(60, 371));
        intn1.addPoint(new Point(68, 371));

        junIntn.setLine(intn1, 0);

        intack = new Line(andNMI, 0, 0, 1);
        intack.addPoint(new Point(60, 382));
        intack.addPoint(new Point(68, 382));

        resetNMI = new Line(NMI, 1, 0, 1);
        resetNMI.addPoint(new Point(92, 377));
        resetNMI.addPoint(new Point(109, 377));

        andNMI.setLine(resetNMI, 0);

        coder1 = new Coder(3);

        outINT = new Line(coder1, 5, 0, 1);
        outINT.addPoint(new Point(167, 29));
        outINT.addPoint(new Point(240, 29));
        outINT.addPoint(new Point(240, 210));
        outINT.addPoint(new Point(269, 210));

        Junction tempJun = new Junction(2);
        outCOD = new Line(tempJun, 0, 0, 1);
        Line tempLine = new Line(coder1, 4, 0, 1);
        tempJun.setLine(tempLine, 0);
        PRCOD = new Line(null, 0, 0, 1);
        tempJun.setLine(PRCOD, 1);

        outCOD.addPoint(new Point(167, 127));
        outCOD.addPoint(new Point(229, 127));
        outCOD.addPoint(new Point(229, 225));
        outCOD.addPoint(new Point(269, 225));

        tempJun = new Junction(2);
        outADR = new Line(tempJun, 0, 0, 1);
        tempLine = new Line(coder1, 3, 0, 1);
        tempJun.setLine(tempLine, 0);
        PRADR = new Line(null, 0, 0, 1);
        tempJun.setLine(PRADR, 1);

        outADR.addPoint(new Point(167, 225));
        outADR.addPoint(new Point(217, 225));
        outADR.addPoint(new Point(217, 240));
        outADR.addPoint(new Point(269, 240));

        outNMI = new Line(coder1, 2, 0, 1);
        outNMI.addPoint(new Point(167, 324));
        outNMI.addPoint(new Point(229, 324));
        outNMI.addPoint(new Point(229, 256));
        outNMI.addPoint(new Point(269, 256));

        INT.setLine(outINT, 0);
        COD.setLine(outCOD, 0);
        ADR.setLine(outADR, 0);
        NMI.setLine(outNMI, 0);

        prper = new Line(coder1, 1, 0, 1);
        prper.addPoint(new Point(251, 271));
        prper.addPoint(new Point(269, 271));

        pswT = new Line(coder1, 0, 0, 1);
        pswT.addPoint(new Point(251, 286));
        pswT.addPoint(new Point(269, 286));

        junCod0 = new Junction(3);
        junCod1 = new Junction(3);
        junCod2 = new Junction(3);

        outCoder0 = new Line(junCod0, 0, 0, 1);
        outCoder0.addPoint(new Point(327, 218));
        outCoder0.addPoint(new Point(347, 218));

        outCoder1 = new Line(junCod1, 0, 1, 1);
        outCoder1.addPoint(new Point(327, 233));
        outCoder1.addPoint(new Point(347, 233));

        outCoder2 = new Line(junCod2, 0, 2, 1);
        outCoder2.addPoint(new Point(327, 248));
        outCoder2.addPoint(new Point(347, 248));

        PREKID = new Line(null, 0, 3, 1);
        PREKID.addPoint(new Point(298, 164));
        PREKID.addPoint(new Point(298, 146));

        coder1.setLine(PREKID, 3);

        coder1.setLine(outCoder0, 0);
        coder1.setLine(outCoder1, 1);
        coder1.setLine(outCoder2, 2);

        andIntn = new And(3);

        Invertor inv1 = new Invertor();
        inIntn0 = new Line(inv1, 0, 0, 1);
        Line lin1 = new Line(andIntn, 0, 0, 1);
        inv1.setLine(lin1, 0);
        inIntn0.addPoint(new Point(425, 195));
        inIntn0.addPoint(new Point(432, 195));

        inIntn1 = new Line(andIntn, 1, 0, 1);
        inIntn1.addPoint(new Point(425, 201));
        inIntn1.addPoint(new Point(435, 201));

        Invertor inv2 = new Invertor();
        inIntn2 = new Line(inv2, 0, 0, 1);
        Line lin2 = new Line(andIntn, 2, 0, 1);
        inv2.setLine(lin2, 0);
        inIntn2.addPoint(new Point(425, 207));
        inIntn2.addPoint(new Point(432, 207));

        junCod0.setLine(inIntn0, 0);
        junCod1.setLine(inIntn1, 0);
        junCod2.setLine(inIntn2, 0);

        intn2 = new Line(junIntn, 0, 0, 1);
        intn2.addPoint(new Point(460, 201));
        intn2.addPoint(new Point(467, 201));

        andIntn.setLine(intn2, 0);

        intn = new Line(null, 0, 1, 1);

        junIntn.setLine(intn, 1);

        andInta = new And(3);

        inInta0 = new Line(andInta, 0, 1, 1);
        inInta0.addPoint(new Point(425, 227));
        inInta0.addPoint(new Point(435, 227));

        Invertor inv3 = new Invertor();
        inInta1 = new Line(inv3, 0, 1, 1);
        Line lin3 = new Line(andInta, 1, 0, 1);
        inv3.setLine(lin3, 0);
        inInta1.addPoint(new Point(425, 233));
        inInta1.addPoint(new Point(432, 233));

        Invertor inv4 = new Invertor();
        inInta2 = new Line(inv4, 0, 1, 1);
        Line lin4 = new Line(andInta, 2, 0, 1);
        inv4.setLine(lin4, 0);
        inInta2.addPoint(new Point(425, 239));
        inInta2.addPoint(new Point(432, 239));

        junCod0.setLine(inInta0, 1);
        junCod1.setLine(inInta1, 1);
        junCod2.setLine(inInta2, 1);

        inta = new Line(null, 0, 0, 1);
        inta.addPoint(new Point(460, 233));
        inta.addPoint(new Point(467, 233));

        andInta.setLine(inta, 0);

        mul1 = new Multiplexer(3);

        inMP0 = new Line(mul1, 10, 2, 1);
        inMP0.addPoint(new Point(391, 277));
        inMP0.addPoint(new Point(391, 296));

        inMP1 = new Line(mul1, 9, 2, 1);
        inMP1.addPoint(new Point(402, 277));
        inMP1.addPoint(new Point(402, 296));

        inMP2 = new Line(mul1, 8, 2, 1);
        inMP2.addPoint(new Point(414, 277));
        inMP2.addPoint(new Point(414, 296));

        junCod0.setLine(inMP0, 2);
        junCod1.setLine(inMP1, 2);
        junCod2.setLine(inMP2, 2);

        mul2 = new Multiplexer(2);

        regL1 = new Register(5);
        regL2 = new Register(6);
        regL3 = new Register(7);

        outRegL1 = new Line(mul2, 1, 0, 2);
        outRegL1.addPoint(new Point(247, 395));
        outRegL1.addPoint(new Point(265, 395));

        outRegL2 = new Line(mul2, 2, 0, 2);
        outRegL2.addPoint(new Point(247, 410));
        outRegL2.addPoint(new Point(265, 410));

        outRegL3 = new Line(mul2, 3, 0, 2);
        outRegL3.addPoint(new Point(247, 425));
        outRegL3.addPoint(new Point(265, 425));

        regL1.setLine(outRegL1, 0);
        regL2.setLine(outRegL2, 0);
        regL3.setLine(outRegL3, 0);

        prl0 = new Line(mul2, 4, 0, 1);
        prl0.addPoint(new Point(285, 452));
        prl0.addPoint(new Point(285, 442));

        prl1 = new Line(mul2, 5, 0, 1);
        prl1.addPoint(new Point(304, 452));
        prl1.addPoint(new Point(304, 442));

        outMul2 = new Line(mul1, 1, 0, 16);
        outMul2.addPoint(new Point(324, 403));
        outMul2.addPoint(new Point(373, 403));

        mul2.setLine(outMul2, 0);

        regM0 = new Register(0);
        regM2 = new Register(1);
        regM3 = new Register(2);
        regM4 = new Register(3);

        outRegM0 = new Line(mul1, 0, 0, 2);
        outRegM0.addPoint(new Point(355, 418));
        outRegM0.addPoint(new Point(373, 418));

        outRegM2 = new Line(mul1, 2, 0, 2);
        outRegM2.addPoint(new Point(355, 388));
        outRegM2.addPoint(new Point(373, 388));

        outRegM3 = new Line(mul1, 3, 0, 2);
        outRegM3.addPoint(new Point(355, 373));
        outRegM3.addPoint(new Point(373, 373));

        outRegM4 = new Line(mul1, 4, 0, 2);
        outRegM4.addPoint(new Point(355, 358));
        outRegM4.addPoint(new Point(373, 358));

        IR2 = new Line(mul1, 5, 0, 2);
        IR2.addPoint(new Point(355, 343));
        IR2.addPoint(new Point(373, 343));

        regM0.setLine(outRegM0, 0);
        regM2.setLine(outRegM2, 0);
        regM3.setLine(outRegM3, 0);
        regM4.setLine(outRegM4, 0);

        regBR = new Register(0);
        outMul1 = new Line(regBR, 0, 0, 2);
        outMul1.addPoint(new Point(432, 366));
        outMul1.addPoint(new Point(473, 366));

        mul1.setLine(outMul1, 0);

        ldBR = new Line(regBR, 1, 0, 1);
        ldBR.addPoint(new Point(504, 453));
        ldBR.addPoint(new Point(504, 442));

        outBR = new Line(null, 0, 0, 8);
        outBR.addPoint(new Point(513, 366));
        outBR.addPoint(new Point(535, 366));

        regBR.setLine(outBR, 0);


        regIVTP = new Register(0);

        ldIVTP = new Line(regIVTP, 1, 0, 1);
        ldIVTP.addPoint(new Point(315, 56));
        ldIVTP.addPoint(new Point(326, 56));

        outIVTP = new Line(null, 0, 0, 16);
        outIVTP.addPoint(new Point(402, 76));
        outIVTP.addPoint(new Point(402, 113));
        outIVTP.addPoint(new Point(526, 113));

        regIVTP.setLine(outIVTP, 0);

        ivtpBuff = new TripleStateBuffer();
        brBuff = new TripleStateBuffer();

        outBR.setNextComp(brBuff);
        outBR.setNextCompPort(0);

        outIVTP.setNextComp(ivtpBuff);
        outIVTP.setNextCompPort(0);
        outIVTP.addTextPoint(new Point(420, 112));

        IVTPout = new Line(ivtpBuff, 1, 0, 1);
        BRout = new Line(brBuff, 1, 0, 1);

        IVTPout.addPoint(new Point(539, 123));
        IVTPout.addPoint(new Point(539, 118));

        BRout.addPoint(new Point(565, 366));
        BRout.addPoint(new Point(565, 362));

        sbus = new Bus(16);
        dbus = new Bus(16);

        sbus.addPoint(new Point(584, 19));
        sbus.addPoint(new Point(584, 435));
        sbus.addPoint(new Point(549, 112));
        sbus.addPoint(new Point(583, 112));
        sbus.addPoint(new Point(575, 356));
        sbus.addPoint(new Point(583, 356));

        sbus.addTextPoint(new Point(588, 34));

        dbus.addPoint(new Point(403, 22));
        dbus.addPoint(new Point(403, 36));

        dbus.addNextComponent(regIVTP, 0);

        brBuff.setLine(sbus, 0);
        ivtpBuff.setLine(sbus, 0);
    }

    public void refreshSequential() {
        INT.refreshSequential();
        ADR.refreshSequential();
        COD.refreshSequential();
        NMI.refreshSequential();
        regBR.refreshSequential();
        regIVTP.refreshSequential();
        regL1.refreshSequential();
        regL2.refreshSequential();
        regL3.refreshSequential();
        regM0.refreshSequential();
        regM2.refreshSequential();
        regM3.refreshSequential();
        regM4.refreshSequential();
    }

    public void clock() {
        INT.clock();
        ADR.clock();
        COD.clock();
        NMI.clock();
        regBR.clock();
        regIVTP.clock();
        regL1.clock();
        regL2.clock();
        regL3.clock();
        regM0.clock();
        regM2.clock();
        regM3.clock();
        regM4.clock();

    }

    public void clear() {
        INT.setState(0);
        ADR.setState(0);
        COD.setState(0);
        NMI.setState(0);
        regBR.setState(0);
        regIVTP.setState(0);
        regL1.setState(5);
        regL2.setState(6);
        regL3.setState(7);
        regM0.setState(0);
        regM2.setState(1);
        regM3.setState(2);
        regM4.setState(3);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        setINT.paint(g);
        setADR.paint(g);
        setCOD.paint(g);
        setNMI.paint(g);

        resetF1.paint(g);
        resetF2.paint(g);
        resetF3.paint(g);

        intn1.paint(g);
        intack.paint(g);
        resetNMI.paint(g);

        outINT.paint(g);
        outCOD.paint(g);
        outADR.paint(g);
        outNMI.paint(g);
        prper.paint(g);
        pswT.paint(g);

        outCoder0.paint(g);
        outCoder1.paint(g);
        outCoder2.paint(g);
        PREKID.paint(g);

        inIntn0.paint(g);
        inIntn1.paint(g);
        inIntn2.paint(g);
        intn2.paint(g);

        inInta0.paint(g);
        inInta1.paint(g);
        inInta2.paint(g);
        inta.paint(g);

        inMP0.paint(g);
        inMP1.paint(g);
        inMP2.paint(g);

        outRegL1.paint(g);
        outRegL2.paint(g);
        outRegL3.paint(g);

        prl0.paint(g);
        prl1.paint(g);

        outMul2.paint(g);
        outRegM0.paint(g);
        outRegM2.paint(g);
        outRegM3.paint(g);
        outRegM4.paint(g);
        IR2.paint(g);

        outMul1.paint(g);
        ldBR.paint(g);

        outBR.paint(g);

        ldIVTP.paint(g);
        outIVTP.paint(g);

        sbus.paint(g);
        dbus.paint(g);

        IVTPout.paint(g);
        BRout.paint(g);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/etf/aor/images/CPU_blok_prekidi_drugi.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public String getParentTitle() {
        return parentTitle;
    }
}
