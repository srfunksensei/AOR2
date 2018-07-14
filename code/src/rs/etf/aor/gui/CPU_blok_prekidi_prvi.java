/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CPU_blok_prekidi_prvi.java
 *
 * Created on 22.09.2010., 10.19.58
 */
package rs.etf.aor.gui;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import rs.etf.aor.components.And;
import rs.etf.aor.components.Coder;
import rs.etf.aor.components.Comparator;
import rs.etf.aor.components.Decoder;
import rs.etf.aor.components.Junction;
import rs.etf.aor.components.Line;
import rs.etf.aor.components.Or;
import rs.etf.aor.components.SRFlipFlop;

/**
 *
 * @author MB
 */
public class CPU_blok_prekidi_prvi extends javax.swing.JPanel implements PanelsInfo {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel parent;
    private String parentTitle = "CPU_organizacija_prekid";
    public Line setIMR1, resetIMR1, setIMR2, resetIMR2, setIMR3, resetIMR3, intr1, intr2, intr3, inta1, inta2, inta3;
    private Line inta11, inta21, inta31, inta12, inta22, inta32;
    private SRFlipFlop IMR1, IMR2, IMR3, INT1, INT2, INT3;
    private Line outIMR1, outIMR2, outIMR3, outINT1, outINT2, outINT3;
    private Line outAndIMR1, outAndIMR2, outAndIMR3;
    private And andIMR1, andIMR2, andIMR3, andEn, andPrper;
    private Junction junOutAndIMR1, junOutAndIMR2, junOutAndIMR3, junPrl0, junPrl1;
    private Junction junInta1, junInta2, junInta3;
    private Line outAndIMR11, outAndIMR21, outAndIMR31, outAndIMR12, outAndIMR22, outAndIMR32;
    private Or or1;
    private Coder coder1;
    private Line izPrl01, izPrl11, izPrl02, izPrl12, izPrl03, izPrl13;
    public Line prl0, prl1;
    private Comparator comp1;
    private Decoder decoder1;
    public Line ldL, inta, intack;
    public Line pswL0, pswL1, pswI, accprirr, imrprirr, prper;

    /** Creates new form CPU_blok_prekidi_prvi */
    public CPU_blok_prekidi_prvi(JPanel parent) {
        this.parent = parent;
        initComponents();

        // flip flopovi IMR

        IMR1 = new SRFlipFlop(0);
        setIMR1 = new Line(IMR1, 0, 0, 1);
        setIMR1.addPoint(new Point(139, 30));
        setIMR1.addPoint(new Point(157, 30));

        resetIMR1 = new Line(IMR1, 1, 0, 1);
        resetIMR1.addPoint(new Point(139, 49));
        resetIMR1.addPoint(new Point(157, 49));

        IMR2 = new SRFlipFlop(0);
        setIMR2 = new Line(IMR2, 0, 0, 1);
        setIMR2.addPoint(new Point(139, 56));
        setIMR2.addPoint(new Point(157, 56));

        resetIMR2 = new Line(IMR2, 1, 0, 1);
        resetIMR2.addPoint(new Point(139, 75));
        resetIMR2.addPoint(new Point(157, 75));

        IMR3 = new SRFlipFlop(0);
        setIMR3 = new Line(IMR3, 0, 0, 1);
        setIMR3.addPoint(new Point(139, 85));
        setIMR3.addPoint(new Point(157, 85));

        resetIMR3 = new Line(IMR3, 1, 0, 1);
        resetIMR3.addPoint(new Point(139, 102));
        resetIMR3.addPoint(new Point(157, 102));

        andIMR1 = new And(2);
        andIMR2 = new And(2);
        andIMR3 = new And(2);

        outIMR1 = new Line(andIMR1, 0, 0, 1);
        outIMR1.addPoint(new Point(178, 30));
        outIMR1.addPoint(new Point(298, 30));
        outIMR1.addPoint(new Point(298, 91));

        outIMR2 = new Line(andIMR2, 0, 0, 1);
        outIMR2.addPoint(new Point(178, 56));
        outIMR2.addPoint(new Point(260, 56));
        outIMR2.addPoint(new Point(260, 91));

        outIMR3 = new Line(andIMR3, 0, 0, 1);
        outIMR3.addPoint(new Point(178, 85));
        outIMR3.addPoint(new Point(222, 85));
        outIMR3.addPoint(new Point(222, 91));

        IMR1.setLine(outIMR1, 0);
        IMR2.setLine(outIMR2, 0);
        IMR3.setLine(outIMR3, 0);

        // flip flopovi INT

        INT1 = new SRFlipFlop(0);
        intr1 = new Line(INT1, 0, 0, 1);
        intr1.addPoint(new Point(465, 30));
        intr1.addPoint(new Point(482, 30));

        inta11 = new Line(INT1, 1, 0, 1);
        inta11.addPoint(new Point(465, 49));
        inta11.addPoint(new Point(482, 49));

        INT2 = new SRFlipFlop(0);
        intr2 = new Line(INT2, 0, 0, 1);
        intr2.addPoint(new Point(465, 56));
        intr2.addPoint(new Point(482, 56));

        inta21 = new Line(INT2, 1, 0, 1);
        inta21.addPoint(new Point(465, 75));
        inta21.addPoint(new Point(482, 75));

        INT3 = new SRFlipFlop(0);
        intr3 = new Line(INT3, 0, 0, 1);
        intr3.addPoint(new Point(465, 84));
        intr3.addPoint(new Point(482, 84));

        inta31 = new Line(INT3, 1, 0, 1);
        inta31.addPoint(new Point(465, 102));
        inta31.addPoint(new Point(482, 102));

        outINT1 = new Line(andIMR1, 1, 0, 1);
        outINT1.addPoint(new Point(444, 30));
        outINT1.addPoint(new Point(309, 30));
        outINT1.addPoint(new Point(309, 91));

        outINT2 = new Line(andIMR2, 1, 0, 1);
        outINT2.addPoint(new Point(444, 56));
        outINT2.addPoint(new Point(271, 56));
        outINT2.addPoint(new Point(271, 91));

        outINT3 = new Line(andIMR3, 1, 0, 1);
        outINT3.addPoint(new Point(444, 85));
        outINT3.addPoint(new Point(234, 85));
        outINT3.addPoint(new Point(234, 91));

        INT1.setLine(outINT1, 0);
        INT2.setLine(outINT2, 0);
        INT3.setLine(outINT3, 0);

        // izlazi iz AND kola do tacki

        junOutAndIMR1 = new Junction(2);
        junOutAndIMR2 = new Junction(2);
        junOutAndIMR3 = new Junction(2);

        outAndIMR1 = new Line(junOutAndIMR1, 0, 0, 1);
        outAndIMR1.addPoint(new Point(303, 116));
        outAndIMR1.addPoint(new Point(303, 159));

        outAndIMR2 = new Line(junOutAndIMR2, 0, 0, 1);
        outAndIMR2.addPoint(new Point(266, 116));
        outAndIMR2.addPoint(new Point(266, 140));

        outAndIMR3 = new Line(junOutAndIMR3, 0, 0, 1);
        outAndIMR3.addPoint(new Point(228, 116));
        outAndIMR3.addPoint(new Point(228, 124));

        andIMR1.setLine(outAndIMR1, 0);
        andIMR2.setLine(outAndIMR2, 0);
        andIMR3.setLine(outAndIMR3, 0);

        // izlazne linije iz tacki u ili kolo

        or1 = new Or(3);

        outAndIMR11 = new Line(or1, 0, 0, 1);
        outAndIMR11.addPoint(new Point(303, 160));
        outAndIMR11.addPoint(new Point(239, 160));
        outAndIMR11.addPoint(new Point(239, 168));

        outAndIMR21 = new Line(or1, 1, 0, 1);
        outAndIMR21.addPoint(new Point(266, 141));
        outAndIMR21.addPoint(new Point(233, 141));
        outAndIMR21.addPoint(new Point(233, 169));

        outAndIMR31 = new Line(or1, 2, 0, 1);
        outAndIMR31.addPoint(new Point(228, 123));
        outAndIMR31.addPoint(new Point(228, 168));

        junOutAndIMR1.setLine(outAndIMR11, 0);
        junOutAndIMR2.setLine(outAndIMR21, 0);
        junOutAndIMR3.setLine(outAndIMR31, 0);

        // izlaz iz ili kola

        andPrper = new And(3);

        imrprirr = new Line(andPrper, 0, 0, 1);
        imrprirr.addPoint(new Point(233, 191));
        imrprirr.addPoint(new Point(233, 249));
        imrprirr.addPoint(new Point(227, 249));

        or1.setLine(imrprirr, 0);

        // izlazne linije iz tacki u koder

        coder1 = new Coder(2);

        outAndIMR12 = new Line(coder1, 1, 1, 1);
        outAndIMR12.addPoint(new Point(303, 160));
        outAndIMR12.addPoint(new Point(343, 160));
        outAndIMR12.addPoint(new Point(343, 178));

        outAndIMR22 = new Line(coder1, 2, 1, 1);
        outAndIMR22.addPoint(new Point(266, 141));
        outAndIMR22.addPoint(new Point(358, 141));
        outAndIMR22.addPoint(new Point(358, 178));

        outAndIMR32 = new Line(coder1, 3, 1, 1);
        outAndIMR32.addPoint(new Point(228, 123));
        outAndIMR32.addPoint(new Point(373, 123));
        outAndIMR32.addPoint(new Point(373, 178));

        junOutAndIMR1.setLine(outAndIMR12, 1);
        junOutAndIMR2.setLine(outAndIMR22, 1);
        junOutAndIMR3.setLine(outAndIMR32, 1);

        // izlazi iz kodera do tacke

        junPrl0 = new Junction(3);
        junPrl1 = new Junction(3);

        izPrl01 = new Line(junPrl0, 0, 0, 1);
        izPrl01.addPoint(new Point(343, 236));
        izPrl01.addPoint(new Point(343, 255));

        izPrl11 = new Line(junPrl1, 0, 1, 1);
        izPrl11.addPoint(new Point(358, 236));
        izPrl11.addPoint(new Point(358, 273));

        coder1.setLine(izPrl01, 0);
        coder1.setLine(izPrl11, 1);

        // izlazi iz tacki

        prl0 = new Line(null, 0, 0, 1);
        prl0.addPoint(new Point(343, 255));
        prl0.addPoint(new Point(445, 255));

        prl1 = new Line(null, 0, 0, 1);
        prl1.addPoint(new Point(358, 273));
        prl1.addPoint(new Point(445, 273));

        junPrl0.setLine(prl0, 0);
        junPrl1.setLine(prl1, 0);

        // izlazi do komparatora

        comp1 = new Comparator(4);

        izPrl02 = new Line(comp1, 0, 1, 1);
        izPrl02.addPoint(new Point(343, 255));
        izPrl02.addPoint(new Point(343, 360));
        izPrl02.addPoint(new Point(333, 360));

        izPrl12 = new Line(comp1, 1, 1, 1);
        izPrl12.addPoint(new Point(358, 273));
        izPrl12.addPoint(new Point(358, 375));
        izPrl12.addPoint(new Point(333, 375));

        junPrl0.setLine(izPrl02, 1);
        junPrl1.setLine(izPrl12, 1);

        // izlazi do dekodera

        decoder1 = new Decoder(2);

        izPrl03 = new Line(decoder1, 0, 2, 1);
        izPrl03.addPoint(new Point(343, 255));
        izPrl03.addPoint(new Point(343, 360));
        izPrl03.addPoint(new Point(368, 360));

        izPrl13 = new Line(decoder1, 1, 2, 1);
        izPrl13.addPoint(new Point(358, 273));
        izPrl13.addPoint(new Point(358, 375));
        izPrl13.addPoint(new Point(368, 375));

        junPrl0.setLine(izPrl03, 2);
        junPrl1.setLine(izPrl13, 2);

        // izlazi iz dekodera

        junInta1 = new Junction(2);
        junInta2 = new Junction(2);
        junInta3 = new Junction(2);

        inta12 = new Line(junInta1, 0, 2, 1);
        inta12.addPoint(new Point(427, 360));
        inta12.addPoint(new Point(445, 360));

        inta22 = new Line(junInta2, 0, 2, 1);
        inta22.addPoint(new Point(427, 375));
        inta22.addPoint(new Point(445, 375));

        inta32 = new Line(junInta3, 0, 2, 1);
        inta32.addPoint(new Point(427, 390));
        inta32.addPoint(new Point(445, 390));

        decoder1.setLine(inta12, 1);
        decoder1.setLine(inta22, 2);
        decoder1.setLine(inta32, 3);

        // enable signal dekodera

        andEn = new And(2);

        inta = new Line(andEn, 0, 0, 1);
        inta.addPoint(new Point(475, 415));
        inta.addPoint(new Point(450, 415));

        intack = new Line(andEn, 1, 0, 1);
        intack.addPoint(new Point(475, 422));
        intack.addPoint(new Point(450, 422));

        ldL = new Line(decoder1, 2, 0, 1);
        ldL.addPoint(new Point(425, 419));
        ldL.addPoint(new Point(398, 419));
        ldL.addPoint(new Point(398, 407));

        andEn.setLine(ldL, 0);

        // pravlejnje inta signala

        inta1 = new Line(null, 0, 1, 1);
        inta2 = new Line(null, 0, 1, 1);
        inta3 = new Line(null, 0, 1, 1);

        junInta1.setLine(inta11, 0);
        junInta2.setLine(inta21, 0);
        junInta3.setLine(inta31, 0);

        junInta1.setLine(inta1, 1);
        junInta2.setLine(inta2, 1);
        junInta3.setLine(inta3, 1);

        // drugi ulaz u komparator 

        pswL0 = new Line(comp1, 2, 0, 1);
        pswL0.addPoint(new Point(222, 360));
        pswL0.addPoint(new Point(274, 360));

        pswL1 = new Line(comp1, 3, 0, 1);
        pswL1.addPoint(new Point(222, 375));
        pswL1.addPoint(new Point(274, 375));

        // izlaz iz komparatora

        accprirr = new Line(andPrper, 1, 0, 1);
        accprirr.addPoint(new Point(303, 329));
        accprirr.addPoint(new Point(303, 255));
        accprirr.addPoint(new Point(227, 255));

        comp1.setLine(accprirr, 0);

        // pswI

        pswI = new Line(andPrper, 2, 0, 1);
        pswI.addPoint(new Point(234, 292));
        pswI.addPoint(new Point(234, 260));
        pswI.addPoint(new Point(227, 260));

        // signal PRPER

        prper = new Line(null, 0, 0, 1);
        prper.addPoint(new Point(202, 254));
        prper.addPoint(new Point(177, 254));

        andPrper.setLine(prper, 0);
    }

    public void refreshSequential() {
        IMR1.refreshSequential();
        IMR2.refreshSequential();
        IMR3.refreshSequential();
        INT1.refreshSequential();
        INT2.refreshSequential();
        INT3.refreshSequential();
    }

    public void clock() {
        IMR1.clock();
        IMR2.clock();
        IMR3.clock();
        INT1.clock();
        INT2.clock();
        INT3.clock();

    }

    public void clear() {
        IMR1.setState(0);
        IMR2.setState(0);
        IMR3.setState(0);
        INT1.setState(0);
        INT2.setState(0);
        INT3.setState(0);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setIMR1.paint(g);
        resetIMR1.paint(g);
        setIMR2.paint(g);
        resetIMR2.paint(g);
        setIMR3.paint(g);
        resetIMR3.paint(g);

        outIMR1.paint(g);
        outIMR2.paint(g);
        outIMR3.paint(g);

        intr1.paint(g);
        inta11.paint(g);
        intr2.paint(g);
        inta21.paint(g);
        intr3.paint(g);
        inta31.paint(g);

        outINT1.paint(g);
        outINT2.paint(g);
        outINT3.paint(g);

        outAndIMR1.paint(g);
        outAndIMR2.paint(g);
        outAndIMR3.paint(g);

        outAndIMR11.paint(g);
        outAndIMR21.paint(g);
        outAndIMR31.paint(g);

        outAndIMR12.paint(g);
        outAndIMR22.paint(g);
        outAndIMR32.paint(g);

        izPrl01.paint(g);
        izPrl11.paint(g);

        prl0.paint(g);
        prl1.paint(g);

        izPrl02.paint(g);
        izPrl12.paint(g);

        izPrl03.paint(g);
        izPrl13.paint(g);

        inta12.paint(g);
        inta22.paint(g);
        inta32.paint(g);

        inta.paint(g);
        intack.paint(g);
        ldL.paint(g);

        pswL0.paint(g);
        pswL1.paint(g);

        imrprirr.paint(g);
        prper.paint(g);
        accprirr.paint(g);
        pswI.paint(g);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/etf/aor/images/CPU_blok_prekidi_prvi.jpg"))); // NOI18N

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
