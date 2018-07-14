/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CPU_blok_registri_peti.java
 *
 * Created on 22.09.2010., 10.22.39
 */

package rs.etf.aor.gui;

import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;
import rs.etf.aor.components.Bus;
import rs.etf.aor.components.Junction;
import rs.etf.aor.components.Line;
import rs.etf.aor.components.Register;
import rs.etf.aor.components.SP;
import rs.etf.aor.components.TripleStateBuffer;

/**
 *
 * @author MB
 */
public class CPU_blok_registri_peti extends javax.swing.JPanel implements PanelsInfo{

    public static final int startSPValue = 0xff00;

    private JPanel parent;
    private String parentTitle = "CPU_organizacija_registri";

    Line ldAX, AXout, ldCX, CXout, ldDX, DXout, ldSP, SPout, incSP, decSP;
    Line ldBX, BXout, ldSI, SIout, ldDI, DIout, ldBP, BPout;
    Line  outAX, outCX, outDX, outSP, outBX, outSI, outDI, outBP;
    Line DI, SI, BP, BX;
    Register regAX, regCX, regDX, regBX, regSI, regDI, regBP;
    SP regSP;
    private TripleStateBuffer tsbAX, tsbCX, tsbDX, tsbSP, tsbBX, tsbSI, tsbDI, tsbBP;

    //bus
    Bus sbus, dbus;

    /** Creates new form CPU_blok_registri_peti */
    public CPU_blok_registri_peti(JPanel parent) {
        this.parent = parent;
        initComponents();
        
        regAX = new Register(0);
        ldAX = new Line(regAX, 1, 0, 1);
        ldAX.addPoint(new Point(114, 88));
        ldAX.addPoint(new Point(125, 88));

        tsbAX = new TripleStateBuffer();
        outAX = new Line(tsbAX, 0, 0, 2);
        outAX.addPoint(new Point(201, 108));
        outAX.addPoint(new Point(201, 123));
        outAX.addPoint(new Point(257, 123));

        AXout = new Line(tsbAX, 1, 0, 1);
        AXout.addPoint(new Point(270, 128));
        AXout.addPoint(new Point(270, 135));

        regAX.setLine(outAX, 0);

        regCX = new Register(0);
        ldCX = new Line(regCX, 1, 0, 1);
        ldCX.addPoint(new Point(114, 183));
        ldCX.addPoint(new Point(125, 183));

        tsbCX = new TripleStateBuffer();
        outCX = new Line(tsbCX, 0, 0, 2);
        outCX.addPoint(new Point(201, 203));
        outCX.addPoint(new Point(201, 218));
        outCX.addPoint(new Point(257, 218));

        CXout = new Line(tsbCX, 1, 0, 1);
        CXout.addPoint(new Point(270, 223));
        CXout.addPoint(new Point(270, 230));

        regCX.setLine(outCX, 0);

        regDX = new Register(0);
        ldDX = new Line(regDX, 1, 0, 1);
        ldDX.addPoint(new Point(114, 273));
        ldDX.addPoint(new Point(125, 273));

        tsbDX = new TripleStateBuffer();
        outDX = new Line(tsbDX, 0, 0, 2);
        outDX.addPoint(new Point(201, 293));
        outDX.addPoint(new Point(201, 308));
        outDX.addPoint(new Point(257, 308));

        DXout = new Line(tsbDX, 1, 0, 1);
        DXout.addPoint(new Point(270, 313));
        DXout.addPoint(new Point(270, 320));

        regDX.setLine(outDX, 0);

        regSP = new SP(startSPValue);
        ldSP = new Line(regSP, 1, 0, 1);
        ldSP.addPoint(new Point(114, 360));
        ldSP.addPoint(new Point(125, 360));

        incSP = new Line(regSP, 2, 0, 1);
        incSP.addPoint(new Point(278, 349));
        incSP.addPoint(new Point(295, 349));

        decSP = new Line(regSP, 3, 0, 1);
        decSP.addPoint(new Point(278, 368));
        decSP.addPoint(new Point(295, 368));

        tsbSP = new TripleStateBuffer();
        outSP = new Line(tsbSP, 0, 0, 2);
        outSP.addPoint(new Point(201, 380));
        outSP.addPoint(new Point(201, 395));
        outSP.addPoint(new Point(257, 395));

        SPout = new Line(tsbSP, 1, 0, 1);
        SPout.addPoint(new Point(270, 400));
        SPout.addPoint(new Point(270, 407));

        regSP.setLine(outSP, 0);

        regBX = new Register(0);
        ldBX = new Line(regBX, 1, 0, 1);
        ldBX.addPoint(new Point(403, 88));
        ldBX.addPoint(new Point(412, 88));

        tsbBX = new TripleStateBuffer();
        Junction bxJun = new Junction(2);
        outBX = new Line(null, 0, 0, 2);
        BX = new Line(null, 0, 0, 2);
        outBX.setNextComp(bxJun);
        outBX.setNextCompPort(0);
        Line bxToTSB = new Line(tsbBX, 0, 0, 2);
        bxJun.setLine(bxToTSB, 0);
        bxJun.setLine(BX, 1);
        outBX.addPoint(new Point(490, 108));
        outBX.addPoint(new Point(490, 123));
        outBX.addPoint(new Point(546, 123));

        BXout = new Line(tsbBX, 1, 0, 1);
        BXout.addPoint(new Point(559, 128));
        BXout.addPoint(new Point(559, 135));

        regBX.setLine(outBX, 0);

        regSI = new Register(0);
        ldSI = new Line(regSI, 1, 0, 1);
        ldSI.addPoint(new Point(403, 183));
        ldSI.addPoint(new Point(412, 183));

        tsbSI = new TripleStateBuffer();
        Junction siJun = new Junction(2);
        outSI = new Line(null, 0, 0, 2);
        SI = new Line(null, 0, 0, 2);
        outSI.setNextComp(siJun);
        outSI.setNextCompPort(0);
        Line siToTSB = new Line(tsbSI, 0, 0, 2);
        siJun.setLine(siToTSB, 0);
        siJun.setLine(SI, 1);
        outSI.addPoint(new Point(490, 203));
        outSI.addPoint(new Point(490, 218));
        outSI.addPoint(new Point(546, 218));

        SIout = new Line(tsbSI, 1, 0, 1);
        SIout.addPoint(new Point(559, 223));
        SIout.addPoint(new Point(559, 230));

        regSI.setLine(outSI, 0);

        regDI = new Register(0);
        ldDI = new Line(regDI, 1, 0, 1);
        ldDI.addPoint(new Point(403, 273));
        ldDI.addPoint(new Point(412, 273));

        tsbDI = new TripleStateBuffer();
        Junction diJun = new Junction(2);
        outDI = new Line(null, 0, 0, 2);
        DI = new Line(null, 0, 0, 2);
        outDI.setNextComp(diJun);
        outDI.setNextCompPort(0);
        Line diToTSB = new Line(tsbDI, 0, 0, 2);
        diJun.setLine(diToTSB, 0);
        diJun.setLine(DI, 1);
        outDI.addPoint(new Point(490, 293));
        outDI.addPoint(new Point(490, 308));
        outDI.addPoint(new Point(546, 308));

        DIout = new Line(tsbDI, 1, 0, 1);
        DIout.addPoint(new Point(559, 313));
        DIout.addPoint(new Point(559, 320));

        regDI.setLine(outDI, 0);

        regBP = new Register(0);
        ldBP = new Line(regBP, 1, 0, 1);
        ldBP.addPoint(new Point(403, 358));
        ldBP.addPoint(new Point(415, 358));

        tsbBP = new TripleStateBuffer();
        Junction bpJun = new Junction(2);
        outBP = new Line(null, 0, 0, 2);
        BP = new Line(null, 0, 0, 2);
        outBP.setNextComp(bpJun);
        outBP.setNextCompPort(0);
        Line bpToTSB = new Line(tsbBP, 0, 0, 2);
        bpJun.setLine(bpToTSB, 0);
        bpJun.setLine(BP, 1);
        outBP.addPoint(new Point(490, 380));
        outBP.addPoint(new Point(490, 395));
        outBP.addPoint(new Point(546, 395));

        outBP.addTextPoint(new Point(488, 418));

        BPout = new Line(tsbBP, 1, 0, 1);
        BPout.addPoint(new Point(559, 400));
        BPout.addPoint(new Point(559, 407));

        regBP.setLine(outBP, 0);

        sbus = new Bus(16);
        dbus = new Bus(16);

        sbus.addNextComponent(regAX, 0);
        sbus.addNextComponent(regBX, 0);
        sbus.addNextComponent(regCX, 0);
        sbus.addNextComponent(regDX, 0);
        sbus.addNextComponent(regSI, 0);
        sbus.addNextComponent(regDI, 0);
        sbus.addNextComponent(regSP, 0);
        sbus.addNextComponent(regBP, 0);

        tsbAX.setLine(dbus, 0);
        tsbBX.setLine(dbus, 0);
        tsbCX.setLine(dbus, 0);
        tsbDX.setLine(dbus, 0);
        tsbSI.setLine(dbus, 0);
        tsbDI.setLine(dbus, 0);
        tsbSP.setLine(dbus, 0);
        tsbBP.setLine(dbus, 0);

        initBus();
    }

    private void initBus() {

        //vertical sbus
        sbus.addPoint(new Point(70, 44));
        sbus.addPoint(new Point(70, 437));
        sbus.addPoint(new Point(353, 44));
        sbus.addPoint(new Point(353, 437));

        //sbus to ax
        sbus.addPoint(new Point(70, 54));
        sbus.addPoint(new Point(202, 54));
        sbus.addPoint(new Point(202, 54));
        sbus.addPoint(new Point(202, 68));

        //sbus to bx
        sbus.addPoint(new Point(70, 149));
        sbus.addPoint(new Point(202, 149));
        sbus.addPoint(new Point(202, 149));
        sbus.addPoint(new Point(202, 163));

        //sbus to dx
        sbus.addPoint(new Point(70, 240));
        sbus.addPoint(new Point(202, 240));
        sbus.addPoint(new Point(202, 240));
        sbus.addPoint(new Point(202, 254));

        //sbus to sp
        sbus.addPoint(new Point(70, 326));
        sbus.addPoint(new Point(202, 326));
        sbus.addPoint(new Point(202, 326));
        sbus.addPoint(new Point(202, 340));

        //sbus to bx
        sbus.addPoint(new Point(353, 54));
        sbus.addPoint(new Point(491, 54));
        sbus.addPoint(new Point(491, 54));
        sbus.addPoint(new Point(491, 68));
        
        //sbus to si
        sbus.addPoint(new Point(353, 149));
        sbus.addPoint(new Point(491, 149));
        sbus.addPoint(new Point(491, 149));
        sbus.addPoint(new Point(491, 163));
        
        //sbus to di
        sbus.addPoint(new Point(353, 240));
        sbus.addPoint(new Point(491, 240));
        sbus.addPoint(new Point(491, 240));
        sbus.addPoint(new Point(491, 254));
        
        //sbus to bp
        sbus.addPoint(new Point(353, 330));
        sbus.addPoint(new Point(491, 330));
        sbus.addPoint(new Point(491, 330));
        sbus.addPoint(new Point(491, 340));

        //vertical dbus
        dbus.addPoint(new Point(319, 46));
        dbus.addPoint(new Point(319, 437));
        dbus.addPoint(new Point(593, 46));
        dbus.addPoint(new Point(593, 437));

        //horizontal dbus
        dbus.addPoint(new Point(281, 123));
        dbus.addPoint(new Point(319, 123));
        dbus.addPoint(new Point(281, 217));
        dbus.addPoint(new Point(319, 217));
        dbus.addPoint(new Point(281, 307));
        dbus.addPoint(new Point(319, 307));
        dbus.addPoint(new Point(281, 394));
        dbus.addPoint(new Point(319, 394));

        dbus.addPoint(new Point(570, 122));
        dbus.addPoint(new Point(593, 122));
        dbus.addPoint(new Point(570, 217));
        dbus.addPoint(new Point(593, 217));
        dbus.addPoint(new Point(570, 308));
        dbus.addPoint(new Point(593, 308));
        dbus.addPoint(new Point(570, 394));
        dbus.addPoint(new Point(593, 394));

        sbus.addTextPoint(new Point(73, 55));
        sbus.addTextPoint(new Point(375, 55));
        dbus.addTextPoint(new Point(321, 55));
        dbus.addTextPoint(new Point(596, 55));

    }

    public void refreshSequential(){

        regAX.refreshSequential();
        regCX.refreshSequential();
        regDX.refreshSequential();
        regSP.refreshSequential();
        regBX.refreshSequential();
        regSI.refreshSequential();
        regDI.refreshSequential();
        regBP.refreshSequential();
    }
    
    public void clock(){

        regAX.clock();
        regCX.clock();
        regDX.clock();
        regSP.clock();
        regBX.clock();
        regSI.clock();
        regDI.clock();
        regBP.clock();
    }

    public void clear(){

        regAX.setState(0);
        regCX.setState(0);
        regDX.setState(0);
        regSP.setState(startSPValue);
        regBX.setState(0);
        regSI.setState(0);
        regDI.setState(0);
        regBP.setState(0);
    }

        @Override
    public void paint(Graphics g) {
	super.paint(g);

        ldAX.paint(g);
        outAX.paint(g);
        AXout.paint(g);
        
        ldCX.paint(g);
        outCX.paint(g);
        CXout.paint(g);

        ldDX.paint(g);
        outDX.paint(g);
        DXout.paint(g);

        ldSP.paint(g);
        outSP.paint(g);
        SPout.paint(g);
        incSP.paint(g);
        decSP.paint(g);

        ldBX.paint(g);
        outBX.paint(g);
        BXout.paint(g);

        ldSI.paint(g);
        outSI.paint(g);
        SIout.paint(g);

        ldDI.paint(g);
        outDI.paint(g);
        DIout.paint(g);

        ldBP.paint(g);
        outBP.paint(g);
        BPout.paint(g);

        sbus.paint(g);
        dbus.paint(g);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/etf/aor/images/CPU_blok_registri_peti.jpg"))); // NOI18N

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
