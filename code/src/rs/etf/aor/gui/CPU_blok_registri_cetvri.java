/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CPU_blok_registri_cetvri.java
 *
 * Created on 22.09.2010., 10.20.48
 */

package rs.etf.aor.gui;

import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;
import rs.etf.aor.components.Bus;
import rs.etf.aor.components.Line;
import rs.etf.aor.components.PC;
import rs.etf.aor.components.Register;
import rs.etf.aor.components.RegisterB;
import rs.etf.aor.components.TripleStateBuffer;

/**
 *
 * @author MB
 */
public class CPU_blok_registri_cetvri extends javax.swing.JPanel implements PanelsInfo{

    public static final int startPCValue = 0x100;

    private JPanel parent;
    private String parentTitle = "CPU_organizacija_registri";

    Line ldPCHigh, ldPCLow, ldBHigh, ldBLow, ldA, PCout, Bout, Aout, incPC;
    Line outPC, outA, outB;
    PC regPC;
    RegisterB regB;
    Register regA;
    private TripleStateBuffer tsbA, tsbB, tsbPC;

    //bus
    Bus sbus, dbus;

    /** Creates new form CPU_blok_registri_cetvri */
    public CPU_blok_registri_cetvri(JPanel parent) {
        this.parent = parent;
        initComponents();

        // ulazni signali

        regPC = new PC(startPCValue);
        ldPCHigh = new Line(regPC, 1, 0, 1);
        ldPCHigh.addPoint(new Point(270, 134));
        ldPCHigh.addPoint(new Point(278, 134));
        
        ldPCLow = new Line(regPC, 2, 0, 1);
        ldPCLow.addPoint(new Point(270, 149));
        ldPCLow.addPoint(new Point(278, 149));

        incPC = new Line(regPC, 3, 0, 1);
        incPC.addPoint(new Point(430, 134));
        incPC.addPoint(new Point(438, 134));

        regB = new RegisterB(0);
        ldBHigh = new Line(regB, 1, 0, 1);
        ldBHigh.addPoint(new Point(270, 210));
        ldBHigh.addPoint(new Point(278, 210));

        ldBLow = new Line(regB, 2, 0, 1);
        ldBLow.addPoint(new Point(270, 232));
        ldBLow.addPoint(new Point(278, 232));
        
        regA = new Register(0);
        ldA = new Line(regA, 1, 0, 1);
        ldA.addPoint(new Point(266, 306));
        ldA.addPoint(new Point(278, 306));

        // izlazni signali

        tsbPC = new TripleStateBuffer();
        outPC = new Line(tsbPC, 0, 0, 2);
        outPC.addPoint(new Point(354, 158));
        outPC.addPoint(new Point(354, 172));
        outPC.addPoint(new Point(408, 172));

        PCout = new Line(tsbPC, 1, 0, 1);
        PCout.addPoint(new Point(422, 177));
        PCout.addPoint(new Point(422, 184));
        
        regPC.setLine(outPC, 0);

        tsbB = new TripleStateBuffer();
        outB = new Line(tsbB, 0, 0, 2);
        outB.addPoint(new Point(354, 241));
        outB.addPoint(new Point(354, 255));
        outB.addPoint(new Point(408, 255));

        Bout = new Line(tsbB, 1, 0, 1);
        Bout.addPoint(new Point(422, 260));
        Bout.addPoint(new Point(422, 267));
        
        regB.setLine(outB, 0);

        tsbA = new TripleStateBuffer();
        outA = new Line(tsbA, 0, 0, 2);
        outA.addPoint(new Point(355, 328));
        outA.addPoint(new Point(355, 342));
        outA.addPoint(new Point(409, 342));

        Aout = new Line(tsbA, 1, 0, 1);
        Aout.addPoint(new Point(423, 346));
        Aout.addPoint(new Point(423, 354));

        regA.setLine(outA, 0);

        sbus = new Bus(16);
        dbus = new Bus(16);

        dbus.addNextComponent(regPC, 0);
        dbus.addNextComponent(regB, 0);
        dbus.addNextComponent(regA, 0);

        tsbPC.setLine(sbus, 0);
        tsbB.setLine(sbus, 0);
        tsbA.setLine(sbus, 0);

        initBus();
    }

    private void initBus() {

        sbus.addPoint(new Point(456, 88));
        sbus.addPoint(new Point(456, 370));

        sbus.addPoint(new Point(433, 172));
        sbus.addPoint(new Point(456, 172));
        sbus.addPoint(new Point(433, 255));
        sbus.addPoint(new Point(456, 255));
        sbus.addPoint(new Point(433, 342));
        sbus.addPoint(new Point(456, 342));

        dbus.addPoint(new Point(218, 88));
        dbus.addPoint(new Point(218, 370));

        dbus.addPoint(new Point(218, 278));
        dbus.addPoint(new Point(355, 278));
        dbus.addPoint(new Point(355, 278));
        dbus.addPoint(new Point(355, 288));

        dbus.addPoint(new Point(218, 191));
        dbus.addPoint(new Point(355, 191));
        dbus.addPoint(new Point(355, 191));
        dbus.addPoint(new Point(355, 201));

        dbus.addPoint(new Point(218, 108));
        dbus.addPoint(new Point(355, 108));
        dbus.addPoint(new Point(355, 108));
        dbus.addPoint(new Point(355, 118));

        sbus.addTextPoint(new Point(458, 98));
        dbus.addTextPoint(new Point(221, 98));

    }

    public void refreshSequential(){
        
        regPC.refreshSequential();
        regB.refreshSequential();
        regA.refreshSequential();

    }

    public void clock(){

        regPC.clock();
        regB.clock();
        regA.clock();

    }

    public void clear() {
        regPC.setState(startPCValue);
        regB.setState(0);
        regA.setState(0);
    }

    @Override
    public void paint(Graphics g) {
	super.paint(g);

        ldPCHigh.paint(g);
        ldPCLow.paint(g);
        incPC.paint(g);
        
        ldBHigh.paint(g);
        ldBLow.paint(g);
        
        ldA.paint(g);

        outA.paint(g);
        outB.paint(g);
        outPC.paint(g);

        Aout.paint(g);
        Bout.paint(g);
        PCout.paint(g);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/etf/aor/images/CPU_blok_registri_cetvri.jpg"))); // NOI18N

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
