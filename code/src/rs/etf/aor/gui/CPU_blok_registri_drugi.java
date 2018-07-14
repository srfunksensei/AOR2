/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CPU_blok_registri_drugi.java
 *
 * Created on 22.09.2010., 10.21.36
 */
package rs.etf.aor.gui;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import rs.etf.aor.components.And;
import rs.etf.aor.components.Bus;
import rs.etf.aor.components.Invertor;
import rs.etf.aor.components.Junction;
import rs.etf.aor.components.Line;
import rs.etf.aor.components.Or;
import rs.etf.aor.components.SRFlipFlop;
import rs.etf.aor.components.Selector;
import rs.etf.aor.components.TripleStateBuffer;

/**
 *
 * @author MB
 */
public class CPU_blok_registri_drugi extends javax.swing.JPanel implements PanelsInfo {

    private JPanel parent;
    private String parentTitle = "CPU_organizacija_registri";
    public Line ldPSW, ldL, PRL0, PRL1, pswL0, pswL1, pswOut, setI, resetI, pswI, setT, resetT, pswT;
    private Junction junLdPSW, junPSWout, junLdL;
    // L0 podaci
    private Junction junLdPSWL0, junLdL0, junPRL0, junPSWL0;
    private Line ldL0, ldPSWL0, ldPSWL01, ldL01, PRL01, ldPSWL02, ldL02, PRL02, outAndL01, outAndL02, outAndL03, outAndL04;
    private And andL01, andL02, andL03, andL04;
    private Or orL01, orL02;
    private Line outOrL01, outOrL02, pswL01, pswL00, pswOutL01;
    SRFlipFlop L0;
    TripleStateBuffer tsbL0;
    // L1 podaci
    private Junction junLdPSWL1, junLdL1, junPRL1, junPSWL1;
    private Line ldL1, ldPSWL1, ldPSWL11, ldL11, PRL11, ldPSWL12, ldL12, PRL12, outAndL11, outAndL12, outAndL13, outAndL14;
    private And andL11, andL12, andL13, andL14;
    private Or orL11, orL12;
    private Line outOrL11, outOrL12, pswL11, pswL10, pswOutL11;
    SRFlipFlop L1;
    TripleStateBuffer tsbL1;
    // I podaci
    private Junction junLdPSWI, junPSWI;
    private Line ldPSWI, ldPSWI1, ldPSWI2, outAndI2, outAndI4;
    private And andI2, andI4;
    private Or orI1, orI2;
    private Line outOrI1, outOrI2, pswI1, pswI0, pswOutI1;
    SRFlipFlop I;
    TripleStateBuffer tsbI;
    // T podaci
    private Junction junLdPSWT, junPSWT;
    private Line ldPSWT, ldPSWT1, ldPSWT2, outAndT2, outAndT4;
    private And andT2, andT4;
    private Or orT1, orT2;
    private Line outOrT1, outOrT2, pswT1, pswT0, pswOutT1;
    SRFlipFlop T;
    TripleStateBuffer tsbT;

    //bus
    Bus sbus;

    private Line l0FromBus, l1FromBus, iFromBus, tFromBus;
    private Line[][] lines;

    //selectors for flags
    private Selector l0selector, l1selector, iselector, tselector;

    /** Creates new form CPU_blok_registri_drugi */
    public CPU_blok_registri_drugi(JPanel parent) {
        this.parent = parent;
        initComponents();

        junLdPSW = new Junction(4);
        junPSWout = new Junction(4);
        junLdL = new Junction(2);

        pswOut = new Line(junPSWout, 0, 0, 1);
        ldPSW = new Line(junLdPSW, 0, 0, 1);
        ldL = new Line(junLdL, 0, 0, 1);

        junLdL0 = new Junction(2);
        junLdPSWL0 = new Junction(2);
        junPRL0 = new Junction(2);

        PRL0 = new Line(junPRL0, 0, 0, 1);
        PRL0.addPoint(new Point(95, 80));
        PRL0.addPoint(new Point(95, 108));

        ldL0 = new Line(junLdL0, 0, 0, 1);
        ldL0.addPoint(new Point(65, 97));
        ldL0.addPoint(new Point(80, 97));

        junLdL.setLine(ldL0, 0);

        ldPSWL0 = new Line(junLdPSWL0, 0, 0, 1);
        ldPSWL0.addPoint(new Point(65, 122));
        ldPSWL0.addPoint(new Point(72, 122));

        junLdPSW.setLine(ldPSWL0, 0);

        andL01 = new And(2);

        PRL01 = new Line(andL01, 1, 0, 1);
        PRL01.addPoint(new Point(95, 108));
        PRL01.addPoint(new Point(111, 108));

        ldL01 = new Line(andL01, 0, 0, 1);
        ldL01.addPoint(new Point(80, 97));
        ldL01.addPoint(new Point(111, 97));

        orL01 = new Or(2);

        outAndL01 = new Line(orL01, 0, 0, 1);
        outAndL01.addPoint(new Point(136, 103));
        outAndL01.addPoint(new Point(142, 103));
        outAndL01.addPoint(new Point(142, 110));
        outAndL01.addPoint(new Point(151, 110));

        andL01.setLine(outAndL01, 0);

        junPRL0.setLine(PRL01, 0);
        junLdL0.setLine(ldL01, 0);

        andL02 = new And(2);

        ldPSWL01 = new Line(andL02, 0, 0, 1);
        ldPSWL01.addPoint(new Point(72, 122));
        ldPSWL01.addPoint(new Point(111, 122));

        junLdPSWL0.setLine(ldPSWL01, 0);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndL02 = new Line(orL01, 1, 0, 1);
        outAndL02.addPoint(new Point(135, 127));
        outAndL02.addPoint(new Point(142, 127));
        outAndL02.addPoint(new Point(142, 122));
        outAndL02.addPoint(new Point(151, 122));

        andL02.setLine(outAndL02, 0);

        // donja dva and kola

        andL03 = new And(2);

        Invertor inv1 = new Invertor();
        PRL02 = new Line(inv1, 0, 1, 1);
        Line lin1 = new Line(andL03, 1, 0, 1);
        inv1.setLine(lin1, 0);
        PRL02.addPoint(new Point(95, 108));
        PRL02.addPoint(new Point(95, 163));
        PRL02.addPoint(new Point(108, 163));

        ldL02 = new Line(andL03, 0, 1, 1);
        ldL02.addPoint(new Point(80, 97));
        ldL02.addPoint(new Point(80, 152));
        ldL02.addPoint(new Point(112, 152));

        junPRL0.setLine(PRL02, 1);
        junLdL0.setLine(ldL02, 1);

        orL02 = new Or(2);

        outAndL03 = new Line(orL02, 0, 0, 1);
        outAndL03.addPoint(new Point(136, 157));
        outAndL03.addPoint(new Point(143, 157));
        outAndL03.addPoint(new Point(143, 163));
        outAndL03.addPoint(new Point(152, 163));

        andL03.setLine(outAndL03, 0);

        andL04 = new And(2);

        ldPSWL02 = new Line(andL04, 0, 1, 1);
        ldPSWL02.addPoint(new Point(73, 122));
        ldPSWL02.addPoint(new Point(73, 176));
        ldPSWL02.addPoint(new Point(112, 176));

        junLdPSWL0.setLine(ldPSWL02, 1);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndL04 = new Line(orL02, 1, 0, 1);
        outAndL04.addPoint(new Point(136, 182));
        outAndL04.addPoint(new Point(143, 182));
        outAndL04.addPoint(new Point(143, 174));
        outAndL04.addPoint(new Point(152, 174));

        andL04.setLine(outAndL04, 0);

        // izlazi iz ili kola i ulazi u L0 FlipFlop

        L0 = new SRFlipFlop(0);

        outOrL01 = new Line(L0, 0, 0, 1);
        outOrL01.addPoint(new Point(173, 116));
        outOrL01.addPoint(new Point(180, 116));

        outOrL02 = new Line(L0, 1, 0, 1);
        outOrL02.addPoint(new Point(173, 169));
        outOrL02.addPoint(new Point(180, 169));

        orL01.setLine(outOrL01, 0);
        orL02.setLine(outOrL02, 0);

        junPSWL0 = new Junction(2);

        pswL00 = new Line(junPSWL0, 0, 0, 1);
        pswL00.addPoint(new Point(238, 116));
        pswL00.addPoint(new Point(260, 116));

        L0.setLine(pswL00, 0);


        tsbL0 = new TripleStateBuffer();

        pswL01 = new Line(tsbL0, 0, 0, 1);
        pswL0 = new Line(null, 0, 1, 1);

        junPSWL0.setLine(pswL01, 0);
        junPSWL0.setLine(pswL0, 1);

        pswOutL01 = new Line(tsbL0, 1, 0, 1);
        pswOutL01.addPoint(new Point(273, 128));
        pswOutL01.addPoint(new Point(273, 121));

        junPSWout.setLine(pswOutL01, 0);

        // L1 flip flop 


        junLdL1 = new Junction(2);
        junLdPSWL1 = new Junction(2);
        junPRL1 = new Junction(2);

        PRL1 = new Line(junPRL1, 0, 0, 1);
        PRL1.addPoint(new Point(95, 250));
        PRL1.addPoint(new Point(95, 278));

        ldL1 = new Line(junLdL1, 0, 0, 1);
        ldL1.addPoint(new Point(65, 267));
        ldL1.addPoint(new Point(80, 267));

        junLdL.setLine(ldL1, 1);

        ldPSWL1 = new Line(junLdPSWL1, 0, 0, 1);
        ldPSWL1.addPoint(new Point(65, 292));
        ldPSWL1.addPoint(new Point(72, 292));

        junLdPSW.setLine(ldPSWL1, 1);

        andL11 = new And(2);

        PRL11 = new Line(andL11, 1, 0, 1);
        PRL11.addPoint(new Point(95, 278));
        PRL11.addPoint(new Point(111, 278));

        ldL11 = new Line(andL11, 0, 0, 1);
        ldL11.addPoint(new Point(80, 267));
        ldL11.addPoint(new Point(111, 267));

        orL11 = new Or(2);

        outAndL11 = new Line(orL11, 0, 0, 1);
        outAndL11.addPoint(new Point(136, 273));
        outAndL11.addPoint(new Point(142, 273));
        outAndL11.addPoint(new Point(142, 280));
        outAndL11.addPoint(new Point(151, 280));

        andL11.setLine(outAndL11, 0);

        junPRL1.setLine(PRL11, 0);
        junLdL1.setLine(ldL11, 0);

        andL12 = new And(2);

        ldPSWL11 = new Line(andL12, 0, 0, 1);
        ldPSWL11.addPoint(new Point(72, 292));
        ldPSWL11.addPoint(new Point(111, 292));

        junLdPSWL1.setLine(ldPSWL11, 0);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndL12 = new Line(orL11, 1, 0, 1);
        outAndL12.addPoint(new Point(135, 297));
        outAndL12.addPoint(new Point(142, 297));
        outAndL12.addPoint(new Point(142, 292));
        outAndL12.addPoint(new Point(151, 292));

        andL12.setLine(outAndL12, 0);

        // donja dva and kola

        andL13 = new And(2);

        Invertor inv3 = new Invertor();
        PRL12 = new Line(inv3, 0, 1, 1);
        Line lin3 = new Line(andL13, 1, 0, 1);
        inv3.setLine(lin3, 0);
        PRL12.addPoint(new Point(95, 278));
        PRL12.addPoint(new Point(95, 333));
        PRL12.addPoint(new Point(108, 333));

        ldL12 = new Line(andL13, 0, 1, 1);
        ldL12.addPoint(new Point(80, 267));
        ldL12.addPoint(new Point(80, 322));
        ldL12.addPoint(new Point(112, 322));

        junPRL1.setLine(PRL12, 1);
        junLdL1.setLine(ldL12, 1);

        orL12 = new Or(2);

        outAndL13 = new Line(orL12, 0, 0, 1);
        outAndL13.addPoint(new Point(136, 327));
        outAndL13.addPoint(new Point(143, 327));
        outAndL13.addPoint(new Point(143, 333));
        outAndL13.addPoint(new Point(152, 333));

        andL13.setLine(outAndL13, 0);

        andL14 = new And(2);

        ldPSWL12 = new Line(andL14, 0, 1, 1);
        ldPSWL12.addPoint(new Point(73, 292));
        ldPSWL12.addPoint(new Point(73, 346));
        ldPSWL12.addPoint(new Point(112, 346));

        junLdPSWL1.setLine(ldPSWL12, 1);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndL14 = new Line(orL12, 1, 0, 1);
        outAndL14.addPoint(new Point(136, 352));
        outAndL14.addPoint(new Point(143, 352));
        outAndL14.addPoint(new Point(143, 344));
        outAndL14.addPoint(new Point(152, 344));

        andL14.setLine(outAndL14, 0);

        // izlazi iz ili kola i ulazi u L0 FlipFlop

        L1 = new SRFlipFlop(0);

        outOrL11 = new Line(L1, 0, 0, 1);
        outOrL11.addPoint(new Point(173, 286));
        outOrL11.addPoint(new Point(180, 286));

        outOrL12 = new Line(L1, 1, 0, 1);
        outOrL12.addPoint(new Point(173, 339));
        outOrL12.addPoint(new Point(180, 339));

        orL11.setLine(outOrL11, 0);
        orL12.setLine(outOrL12, 0);

        junPSWL1 = new Junction(2);

        pswL10 = new Line(junPSWL1, 0, 0, 1);
        pswL10.addPoint(new Point(238, 286));
        pswL10.addPoint(new Point(260, 286));

        L1.setLine(pswL10, 0);


        tsbL1 = new TripleStateBuffer();

        pswL11 = new Line(tsbL1, 0, 0, 1);
        pswL1 = new Line(null, 0, 1, 1);

        junPSWL1.setLine(pswL11, 0);
        junPSWL1.setLine(pswL1, 1);

        pswOutL11 = new Line(tsbL1, 1, 0, 1);
        pswOutL11.addPoint(new Point(273, 298));
        pswOutL11.addPoint(new Point(273, 291));

        junPSWout.setLine(pswOutL11, 1);


        // I flip flop

        junLdPSWI = new Junction(2);

        ldPSWI = new Line(junLdPSWI, 0, 2, 1);
        ldPSWI.addPoint(new Point(385, 114));
        ldPSWI.addPoint(new Point(401, 114));

        junLdPSW.setLine(ldPSWI, 2);

        orI1 = new Or(2);

        setI = new Line(orI1, 0, 0, 1);
        setI.addPoint(new Point(462, 99));
        setI.addPoint(new Point(462, 108));
        setI.addPoint(new Point(472, 108));

        andI2 = new And(2);

        ldPSWI1 = new Line(andI2, 0, 0, 1);
        ldPSWI1.addPoint(new Point(401, 114));
        ldPSWI1.addPoint(new Point(432, 114));

        junLdPSWI.setLine(ldPSWI1, 0);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndI2 = new Line(orI1, 1, 0, 1);
        outAndI2.addPoint(new Point(456, 120));
        outAndI2.addPoint(new Point(472, 120));

        andI2.setLine(outAndI2, 0);

        // donja dva and kola

        orI2 = new Or(2);

        resetI = new Line(orI2, 0, 0, 1);
        resetI.addPoint(new Point(464, 182));
        resetI.addPoint(new Point(464, 172));
        resetI.addPoint(new Point(473, 172));

        andI4 = new And(2);

        ldPSWI2 = new Line(andI4, 0, 1, 1);
        ldPSWI2.addPoint(new Point(401, 114));
        ldPSWI2.addPoint(new Point(401, 155));
        ldPSWI2.addPoint(new Point(433, 155));

        junLdPSWI.setLine(ldPSWI2, 1);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndI4 = new Line(orI2, 1, 0, 1);
        outAndI4.addPoint(new Point(457, 161));
        outAndI4.addPoint(new Point(473, 161));

        andI4.setLine(outAndI4, 0);

        // izlazi iz ili kola i ulazi u L0 FlipFlop

        I = new SRFlipFlop(0);

        outOrI1 = new Line(I, 0, 0, 1);
        outOrI1.addPoint(new Point(494, 114));
        outOrI1.addPoint(new Point(500, 114));

        outOrI2 = new Line(I, 1, 0, 1);
        outOrI2.addPoint(new Point(494, 167));
        outOrI2.addPoint(new Point(500, 167));

        orI1.setLine(outOrI1, 0);
        orI2.setLine(outOrI2, 0);

        junPSWI = new Junction(2);

        pswI0 = new Line(junPSWI, 0, 0, 1);
        pswI0.addPoint(new Point(559, 114));
        pswI0.addPoint(new Point(581, 114));

        I.setLine(pswI0, 0);

        tsbI = new TripleStateBuffer();

        pswI1 = new Line(tsbI, 0, 0, 1);
        pswI = new Line(null, 0, 1, 1);

        junPSWI.setLine(pswI1, 0);
        junPSWI.setLine(pswI, 1);

        pswOutI1 = new Line(tsbI, 1, 0, 1);
        pswOutI1.addPoint(new Point(594, 125));
        pswOutI1.addPoint(new Point(594, 119));

        junPSWout.setLine(pswOutI1, 2);

        // T flip flop

        junLdPSWT = new Junction(2);

        ldPSWT = new Line(junLdPSWT, 0, 3, 1);
        ldPSWT.addPoint(new Point(385, 273));
        ldPSWT.addPoint(new Point(401, 273));

        junLdPSW.setLine(ldPSWT, 3);

        orT1 = new Or(2);

        setT = new Line(orT1, 0, 0, 1);
        setT.addPoint(new Point(462, 258));
        setT.addPoint(new Point(462, 267));
        setT.addPoint(new Point(472, 267));

        andT2 = new And(2);

        ldPSWT1 = new Line(andT2, 0, 0, 1);
        ldPSWT1.addPoint(new Point(401, 273));
        ldPSWT1.addPoint(new Point(432, 273));

        junLdPSWT.setLine(ldPSWT1, 0);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndT2 = new Line(orT1, 1, 0, 1);
        outAndT2.addPoint(new Point(456, 279));
        outAndT2.addPoint(new Point(472, 279));

        andT2.setLine(outAndT2, 0);

        // donja dva and kola

        orT2 = new Or(2);

        resetT = new Line(orT2, 0, 0, 1);
        resetT.addPoint(new Point(464, 341));
        resetT.addPoint(new Point(464, 331));
        resetT.addPoint(new Point(473, 331));

        andT4 = new And(2);

        ldPSWT2 = new Line(andT4, 0, 1, 1);
        ldPSWT2.addPoint(new Point(401, 273));
        ldPSWT2.addPoint(new Point(401, 314));
        ldPSWT2.addPoint(new Point(433, 314));

        junLdPSWT.setLine(ldPSWT2, 1);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndT4 = new Line(orT2, 1, 0, 1);
        outAndT4.addPoint(new Point(457, 320));
        outAndT4.addPoint(new Point(473, 320));

        andT4.setLine(outAndT4, 0);

        // izlazi iz ili kola i ulazi u L0 FlipFlop

        T = new SRFlipFlop(0);

        outOrT1 = new Line(T, 0, 0, 1);
        outOrT1.addPoint(new Point(494, 273));
        outOrT1.addPoint(new Point(500, 273));

        outOrT2 = new Line(T, 1, 0, 1);
        outOrT2.addPoint(new Point(494, 326));
        outOrT2.addPoint(new Point(500, 326));

        orT1.setLine(outOrT1, 0);
        orT2.setLine(outOrT2, 0);

        junPSWT = new Junction(2);

        pswT0 = new Line(junPSWT, 0, 0, 1);
        pswT0.addPoint(new Point(559, 273));
        pswT0.addPoint(new Point(581, 273));

        T.setLine(pswT0, 0);

        tsbT = new TripleStateBuffer();

        pswT1 = new Line(tsbT, 0, 0, 1);
        pswT = new Line(null, 0, 1, 1);

        junPSWT.setLine(pswT1, 0);
        junPSWT.setLine(pswT, 1);

        pswOutT1 = new Line(tsbT, 1, 0, 1);
        pswOutT1.addPoint(new Point(594, 284));
        pswOutT1.addPoint(new Point(594, 278));

        junPSWout.setLine(pswOutT1, 3);

        l0selector = new Selector(0);
        l1selector = new Selector(1);
        iselector = new Selector(2);
        tselector = new Selector(3);
        
        Junction[] selectorJunctions = new Junction[4];
        for (int i=0; i<selectorJunctions.length; i++) {
            selectorJunctions[i] = new Junction(2);
        }

        l0FromBus = new Line(selectorJunctions[0], 0, 0, 1);
        l1FromBus = new Line(selectorJunctions[1], 0, 0, 1);
        iFromBus = new Line(selectorJunctions[2], 0, 0, 1);
        tFromBus = new Line(selectorJunctions[3], 0, 0, 1);
        
        l0selector.setLine(l0FromBus, 0);
        l1selector.setLine(l1FromBus, 0);
        iselector.setLine(iFromBus, 0);
        tselector.setLine(tFromBus, 0);

        Invertor[] selectorInvertors = new Invertor[4];
        for (int i=0; i<selectorInvertors.length; i++) {
            selectorInvertors[i] = new Invertor();
        }

        lines = new Line[4][3];

        //L0 from bus
        lines[0][0] = new Line(andL02, 1, 0, 1);
        lines[0][1] = new Line(selectorInvertors[0], 0, 1, 1);
        lines[0][2] = new Line(andL04, 1, 0, 1);
        selectorJunctions[0].setLine(lines[0][0], 0);
        selectorJunctions[0].setLine(lines[0][1], 1);
        selectorInvertors[0].setLine(lines[0][2], 0);

        //L1 from bus
        lines[1][0] = new Line(andL12, 1, 0, 1);
        lines[1][1] = new Line(selectorInvertors[1], 0, 1, 1);
        lines[1][2] = new Line(andL14, 1, 0, 1);
        selectorJunctions[1].setLine(lines[1][0], 0);
        selectorJunctions[1].setLine(lines[1][1], 1);
        selectorInvertors[1].setLine(lines[1][2], 0);

        //I from bus
        lines[2][0] = new Line(andI2, 1, 0, 1);
        lines[2][1] = new Line(selectorInvertors[2], 0, 1, 1);
        lines[2][2] = new Line(andI4, 1, 0, 1);
        selectorJunctions[2].setLine(lines[2][0], 0);
        selectorJunctions[2].setLine(lines[2][1], 1);
        selectorInvertors[2].setLine(lines[2][2], 0);

        //T from bus
        lines[3][0] = new Line(andT2, 1, 0, 1);
        lines[3][1] = new Line(selectorInvertors[3], 0, 1, 1);
        lines[3][2] = new Line(andT4, 1, 0, 1);
        selectorJunctions[3].setLine(lines[3][0], 0);
        selectorJunctions[3].setLine(lines[3][1], 1);
        selectorInvertors[3].setLine(lines[3][2], 0);

        initBus();

        initLinesFromBus();
    }

    private void initLinesFromBus() {

        lines[0][0].addPoint(new Point(88, 188));
        lines[0][0].addPoint(new Point(108, 188));
        lines[0][1].addPoint(new Point(88, 188));
        lines[0][1].addPoint(new Point(88, 133));
        lines[0][1].addPoint(new Point(112, 133));

        lines[1][0].addPoint(new Point(88, 358));
        lines[1][0].addPoint(new Point(108, 358));
        lines[1][1].addPoint(new Point(88, 358));
        lines[1][1].addPoint(new Point(88, 303));
        lines[1][1].addPoint(new Point(112, 303));

        lines[2][0].addPoint(new Point(410, 167));
        lines[2][0].addPoint(new Point(429, 167));
        lines[2][1].addPoint(new Point(410, 167));
        lines[2][1].addPoint(new Point(410, 126));
        lines[2][1].addPoint(new Point(433, 126));

        lines[3][0].addPoint(new Point(409, 326));
        lines[3][0].addPoint(new Point(429, 326));
        lines[3][1].addPoint(new Point(409, 326));
        lines[3][1].addPoint(new Point(409, 284));
        lines[3][1].addPoint(new Point(433, 284));

        l0FromBus.addPoint(new Point(291, 206));
        l0FromBus.addPoint(new Point(88, 206));
        l0FromBus.addPoint(new Point(88, 188));

        l1FromBus.addPoint(new Point(291, 374));
        l1FromBus.addPoint(new Point(89, 374));
        l1FromBus.addPoint(new Point(89, 357));

        iFromBus.addPoint(new Point(613, 203));
        iFromBus.addPoint(new Point(410, 203));
        iFromBus.addPoint(new Point(410, 167));

        tFromBus.addPoint(new Point(612, 362));
        tFromBus.addPoint(new Point(409, 362));
        tFromBus.addPoint(new Point(409, 326));
    }

    private void initBus() {

        sbus = new Bus(16);

        //vertical sbus
        sbus.addPoint(new Point(292, 94));
        sbus.addPoint(new Point(292, 393));
        sbus.addPoint(new Point(613, 93));
        sbus.addPoint(new Point(613, 393));

        //horizontal sbus
        sbus.addPoint(new Point(284, 116));
        sbus.addPoint(new Point(292, 116));
        sbus.addPoint(new Point(284, 286));
        sbus.addPoint(new Point(292, 286));
        sbus.addPoint(new Point(605, 114));
        sbus.addPoint(new Point(613, 114));
        sbus.addPoint(new Point(605, 273));
        sbus.addPoint(new Point(613, 273));

        //points for textual representation of bus value
        sbus.addTextPoint(new Point(295, 100));
        sbus.addTextPoint(new Point(616, 100));

        //add next components
        sbus.addNextComponent(l0selector, 0);
        sbus.addNextComponent(l1selector, 0);
        sbus.addNextComponent(iselector, 0);
        sbus.addNextComponent(tselector, 0);

    }

    public void refreshSequential() {
        L0.refreshSequential();
        L1.refreshSequential();
        I.refreshSequential();
        T.refreshSequential();
    }

    public void clock() {

        L0.clock();
        L1.clock();
        I.clock();
        T.clock();

    }

    public void clear() {
        L0.setState(0);
        L1.setState(0);
        I.setState(0);
        T.setState(0);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // L0 FF

        ldL0.paint(g);
        ldPSWL0.paint(g);
        PRL0.paint(g);

        ldL01.paint(g);
        PRL01.paint(g);

        ldPSWL01.paint(g);

        outAndL01.paint(g);
        outAndL02.paint(g);

        PRL02.paint(g);
        ldL02.paint(g);

        ldPSWL02.paint(g);

        outAndL03.paint(g);
        outAndL04.paint(g);

        outOrL01.paint(g);
        outOrL02.paint(g);

        pswL00.paint(g);

        pswOutL01.paint(g);

        // L1 FF

        ldL1.paint(g);
        ldPSWL1.paint(g);
        PRL1.paint(g);

        ldL11.paint(g);
        PRL11.paint(g);

        ldPSWL11.paint(g);

        outAndL11.paint(g);
        outAndL12.paint(g);

        PRL12.paint(g);
        ldL12.paint(g);

        ldPSWL12.paint(g);

        outAndL13.paint(g);
        outAndL14.paint(g);

        outOrL11.paint(g);
        outOrL12.paint(g);

        pswL10.paint(g);

        pswOutL11.paint(g);

        // I FF

        ldPSWI.paint(g);

        ldPSWI1.paint(g);

        setI.paint(g);
        outAndI2.paint(g);

        ldPSWI2.paint(g);

        resetI.paint(g);
        outAndI4.paint(g);

        outOrI1.paint(g);
        outOrI2.paint(g);

        pswI0.paint(g);

        pswOutI1.paint(g);

        // T FF

        ldPSWT.paint(g);

        ldPSWT1.paint(g);

        setT.paint(g);
        outAndT2.paint(g);

        ldPSWT2.paint(g);

        resetT.paint(g);
        outAndT4.paint(g);

        outOrT1.paint(g);
        outOrT2.paint(g);

        pswT0.paint(g);

        pswOutT1.paint(g);

        sbus.paint(g);

        for (int i=0; i<lines.length; i++) {
            for (int j=0; j<lines[i].length; j++) {
                lines[i][j].paint(g);
            }
        }

        l0FromBus.paint(g);
        l1FromBus.paint(g);
        iFromBus.paint(g);
        tFromBus.paint(g);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/etf/aor/images/CPU_blok_registri_drugi.jpg"))); // NOI18N

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
