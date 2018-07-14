/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CPU_blok_registri_treci.java
 *
 * Created on 22.09.2010., 10.25.32
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
public class CPU_blok_registri_treci extends javax.swing.JPanel implements PanelsInfo {

    private JPanel parent;
    private String parentTitle = "CPU_organizacija_registri";
    Line ldPSW, ldPSWALU, pswOut, N, Z, V, C, pswN, pswZ, pswV, pswC;
    private Junction junLdPSW, junPSWout, junLdPSWALU;
    // N podaci
    private Junction junLdPSWN, junLdPSWALUN, junN, junPSWN;
    private Line ldPSWALUN, ldPSWN, ldPSWN1, ldPSWALUN1, N1, ldPSWN2, ldPSWALUN2, N2, outAndN1, outAndN2, outAndN3, outAndN4;
    private And andN1, andN2, andN3, andN4;
    private Or orN1, orN2;
    private Line outOrN1, outOrN2, pswN1, pswN0, pswOutN1;
    SRFlipFlop ffN;
    TripleStateBuffer tsbN;
    //  Z podaci
    private Junction junLdPSWZ, junLdPSWALUZ, junZ, junPSWZ;
    private Line ldPSWALUZ, ldPSWZ, ldPSWZ1, ldPSWALUZ1, Z1, ldPSWZ2, ldPSWALUZ2, Z2, outAndZ1, outAndZ2, outAndZ3, outAndZ4;
    private And andZ1, andZ2, andZ3, andZ4;
    private Or orZ1, orZ2;
    private Line outOrZ1, outOrZ2, pswZ1, pswZ0, pswOutZ1;
    SRFlipFlop ffZ;
    TripleStateBuffer tsbZ;
    // V podaci
    private Junction junLdPSWV, junLdPSWALUV, junV, junPSWV;
    private Line ldPSWALUV, ldPSWV, ldPSWV1, ldPSWALUV1, V1, ldPSWV2, ldPSWALUV2, V2, outAndV1, outAndV2, outAndV3, outAndV4;
    private And andV1, andV2, andV3, andV4;
    private Or orV1, orV2;
    private Line outOrV1, outOrV2, pswV1, pswV0, pswOutV1;
    SRFlipFlop ffV;
    TripleStateBuffer tsbV;
    // C podaci
    private Junction junLdPSWC, junLdPSWALUC, junC, junPSWC;
    private Line ldPSWALUC, ldPSWC, ldPSWC1, ldPSWALUC1, C1, ldPSWC2, ldPSWALUC2, C2, outAndC1, outAndC2, outAndC3, outAndC4;
    private And andC1, andC2, andC3, andC4;
    private Or orC1, orC2;
    private Line outOrC1, outOrC2, pswC1, pswC0, pswOutC1;
    SRFlipFlop ffC;
    TripleStateBuffer tsbC;
    //bus
    Bus sbus;
    private Line nFromBus, zFromBus, cFromBus, vFromBus;
    private Line[][] lines;
    //selectors for flags
    private Selector nselector, zselector, cselector, vselector;

    /** Creates new form CPU_blok_registri_treci */
    public CPU_blok_registri_treci(JPanel parent) {
        this.parent = parent;
        initComponents();

        junLdPSW = new Junction(4);
        junPSWout = new Junction(4);
        junLdPSWALU = new Junction(4);

        pswOut = new Line(junPSWout, 0, 0, 1);
        ldPSW = new Line(junLdPSW, 0, 0, 1);
        ldPSWALU = new Line(junLdPSWALU, 0, 0, 1);

        // N FF

        junLdPSWALUN = new Junction(2);
        junLdPSWN = new Junction(2);
        junN = new Junction(2);

        N = new Line(junN, 0, 0, 1);
        N.addPoint(new Point(95, 80));
        N.addPoint(new Point(95, 108));

        ldPSWALUN = new Line(junLdPSWALUN, 0, 0, 1);
        ldPSWALUN.addPoint(new Point(65, 97));
        ldPSWALUN.addPoint(new Point(80, 97));

        junLdPSWALU.setLine(ldPSWALUN, 0);

        ldPSWN = new Line(junLdPSWN, 0, 0, 1);
        ldPSWN.addPoint(new Point(65, 122));
        ldPSWN.addPoint(new Point(72, 122));

        junLdPSW.setLine(ldPSWN, 0);

        andN1 = new And(2);

        N1 = new Line(andN1, 1, 0, 1);
        N1.addPoint(new Point(95, 108));
        N1.addPoint(new Point(111, 108));

        ldPSWALUN1 = new Line(andN1, 0, 0, 1);
        ldPSWALUN1.addPoint(new Point(80, 97));
        ldPSWALUN1.addPoint(new Point(111, 97));

        orN1 = new Or(2);

        outAndN1 = new Line(orN1, 0, 0, 1);
        outAndN1.addPoint(new Point(136, 103));
        outAndN1.addPoint(new Point(142, 103));
        outAndN1.addPoint(new Point(142, 110));
        outAndN1.addPoint(new Point(151, 110));

        andN1.setLine(outAndN1, 0);

        junN.setLine(N1, 0);
        junLdPSWALUN.setLine(ldPSWALUN1, 0);

        andN2 = new And(2);

        ldPSWN1 = new Line(andN2, 0, 0, 1);
        ldPSWN1.addPoint(new Point(72, 122));
        ldPSWN1.addPoint(new Point(111, 122));

        junLdPSWN.setLine(ldPSWN1, 0);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndN2 = new Line(orN1, 1, 0, 1);
        outAndN2.addPoint(new Point(135, 127));
        outAndN2.addPoint(new Point(142, 127));
        outAndN2.addPoint(new Point(142, 122));
        outAndN2.addPoint(new Point(151, 122));

        andN2.setLine(outAndN2, 0);

        // donja dva and kola

        andN3 = new And(2);

        Invertor inv1 = new Invertor();
        N2 = new Line(inv1, 0, 1, 1);
        Line lin1 = new Line(andN3, 1, 0, 1);
        inv1.setLine(lin1, 0);
        N2.addPoint(new Point(95, 108));
        N2.addPoint(new Point(95, 163));
        N2.addPoint(new Point(108, 163));

        ldPSWALUN2 = new Line(andN3, 0, 1, 1);
        ldPSWALUN2.addPoint(new Point(80, 97));
        ldPSWALUN2.addPoint(new Point(80, 152));
        ldPSWALUN2.addPoint(new Point(112, 152));

        junN.setLine(N2, 1);
        junLdPSWALUN.setLine(ldPSWALUN2, 1);

        orN2 = new Or(2);

        outAndN3 = new Line(orN2, 0, 0, 1);
        outAndN3.addPoint(new Point(136, 157));
        outAndN3.addPoint(new Point(143, 157));
        outAndN3.addPoint(new Point(143, 163));
        outAndN3.addPoint(new Point(152, 163));

        andN3.setLine(outAndN3, 0);

        andN4 = new And(2);

        ldPSWN2 = new Line(andN4, 0, 1, 1);
        ldPSWN2.addPoint(new Point(73, 122));
        ldPSWN2.addPoint(new Point(73, 176));
        ldPSWN2.addPoint(new Point(112, 176));

        junLdPSWN.setLine(ldPSWN2, 1);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndN4 = new Line(orN2, 1, 0, 1);
        outAndN4.addPoint(new Point(136, 182));
        outAndN4.addPoint(new Point(143, 182));
        outAndN4.addPoint(new Point(143, 174));
        outAndN4.addPoint(new Point(152, 174));

        andN4.setLine(outAndN4, 0);

        // izlazi iz ili kola i ulazi u N FlipFlop

        ffN = new SRFlipFlop(0);

        outOrN1 = new Line(ffN, 0, 0, 1);
        outOrN1.addPoint(new Point(173, 116));
        outOrN1.addPoint(new Point(180, 116));

        outOrN2 = new Line(ffN, 1, 0, 1);
        outOrN2.addPoint(new Point(173, 169));
        outOrN2.addPoint(new Point(180, 169));

        orN1.setLine(outOrN1, 0);
        orN2.setLine(outOrN2, 0);

        junPSWN = new Junction(2);

        pswN0 = new Line(junPSWN, 0, 0, 1);
        pswN0.addPoint(new Point(238, 116));
        pswN0.addPoint(new Point(260, 116));

        ffN.setLine(pswN0, 0);

        tsbN = new TripleStateBuffer();

        pswN1 = new Line(tsbN, 0, 0, 1);
        pswN = new Line(null, 0, 1, 1);

        junPSWN.setLine(pswN1, 0);
        junPSWN.setLine(pswN, 1);

        pswOutN1 = new Line(tsbN, 1, 0, 1);
        pswOutN1.addPoint(new Point(273, 128));
        pswOutN1.addPoint(new Point(273, 121));

        junPSWout.setLine(pswOutN1, 0);

        // Z flip flop


        junLdPSWALUZ = new Junction(2);
        junLdPSWZ = new Junction(2);
        junZ = new Junction(2);

        Z = new Line(junZ, 0, 0, 1);
        Z.addPoint(new Point(95, 250));
        Z.addPoint(new Point(95, 278));

        ldPSWALUZ = new Line(junLdPSWALUZ, 0, 0, 1);
        ldPSWALUZ.addPoint(new Point(65, 267));
        ldPSWALUZ.addPoint(new Point(80, 267));

        junLdPSWALU.setLine(ldPSWALUZ, 1);

        ldPSWZ = new Line(junLdPSWZ, 0, 0, 1);
        ldPSWZ.addPoint(new Point(65, 292));
        ldPSWZ.addPoint(new Point(72, 292));

        junLdPSW.setLine(ldPSWZ, 1);

        andZ1 = new And(2);

        Z1 = new Line(andZ1, 1, 0, 1);
        Z1.addPoint(new Point(95, 278));
        Z1.addPoint(new Point(111, 278));

        ldPSWALUZ1 = new Line(andZ1, 0, 0, 1);
        ldPSWALUZ1.addPoint(new Point(80, 267));
        ldPSWALUZ1.addPoint(new Point(111, 267));

        orZ1 = new Or(2);

        outAndZ1 = new Line(orZ1, 0, 0, 1);
        outAndZ1.addPoint(new Point(136, 273));
        outAndZ1.addPoint(new Point(142, 273));
        outAndZ1.addPoint(new Point(142, 280));
        outAndZ1.addPoint(new Point(151, 280));

        andZ1.setLine(outAndZ1, 0);

        junZ.setLine(Z1, 0);
        junLdPSWALUZ.setLine(ldPSWALUZ1, 0);

        andZ2 = new And(2);

        ldPSWZ1 = new Line(andZ2, 0, 0, 1);
        ldPSWZ1.addPoint(new Point(72, 292));
        ldPSWZ1.addPoint(new Point(111, 292));

        junLdPSWZ.setLine(ldPSWZ1, 0);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndZ2 = new Line(orZ1, 1, 0, 1);
        outAndZ2.addPoint(new Point(135, 297));
        outAndZ2.addPoint(new Point(142, 297));
        outAndZ2.addPoint(new Point(142, 292));
        outAndZ2.addPoint(new Point(151, 292));

        andZ2.setLine(outAndZ2, 0);

        // donja dva and kola

        andZ3 = new And(2);

        Invertor inv3 = new Invertor();
        Z2 = new Line(inv3, 0, 1, 1);
        Line lin3 = new Line(andZ3, 1, 0, 1);
        inv3.setLine(lin3, 0);
        Z2.addPoint(new Point(95, 278));
        Z2.addPoint(new Point(95, 333));
        Z2.addPoint(new Point(108, 333));

        ldPSWALUZ2 = new Line(andZ3, 0, 1, 1);
        ldPSWALUZ2.addPoint(new Point(80, 267));
        ldPSWALUZ2.addPoint(new Point(80, 322));
        ldPSWALUZ2.addPoint(new Point(112, 322));

        junZ.setLine(Z2, 1);
        junLdPSWALUZ.setLine(ldPSWALUZ2, 1);

        orZ2 = new Or(2);

        outAndZ3 = new Line(orZ2, 0, 0, 1);
        outAndZ3.addPoint(new Point(136, 327));
        outAndZ3.addPoint(new Point(143, 327));
        outAndZ3.addPoint(new Point(143, 333));
        outAndZ3.addPoint(new Point(152, 333));

        andZ3.setLine(outAndZ3, 0);

        andZ4 = new And(2);

        ldPSWZ2 = new Line(andZ4, 0, 1, 1);
        ldPSWZ2.addPoint(new Point(73, 292));
        ldPSWZ2.addPoint(new Point(73, 346));
        ldPSWZ2.addPoint(new Point(112, 346));

        junLdPSWZ.setLine(ldPSWZ2, 1);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndZ4 = new Line(orZ2, 1, 0, 1);
        outAndZ4.addPoint(new Point(136, 352));
        outAndZ4.addPoint(new Point(143, 352));
        outAndZ4.addPoint(new Point(143, 344));
        outAndZ4.addPoint(new Point(152, 344));

        andZ4.setLine(outAndZ4, 0);

        // izlazi iz ili kola i ulazi u Z FlipFlop

        ffZ = new SRFlipFlop(0);

        outOrZ1 = new Line(ffZ, 0, 0, 1);
        outOrZ1.addPoint(new Point(173, 286));
        outOrZ1.addPoint(new Point(180, 286));

        outOrZ2 = new Line(ffZ, 1, 0, 1);
        outOrZ2.addPoint(new Point(173, 339));
        outOrZ2.addPoint(new Point(180, 339));

        orZ1.setLine(outOrZ1, 0);
        orZ2.setLine(outOrZ2, 0);

        junPSWZ = new Junction(2);

        pswZ0 = new Line(junPSWZ, 0, 0, 1);
        pswZ0.addPoint(new Point(238, 286));
        pswZ0.addPoint(new Point(260, 286));

        ffZ.setLine(pswZ0, 0);


        tsbZ = new TripleStateBuffer();

        pswZ1 = new Line(tsbZ, 0, 0, 1);
        pswZ = new Line(null, 0, 1, 1);

        junPSWZ.setLine(pswZ1, 0);
        junPSWZ.setLine(pswZ, 1);

        pswOutZ1 = new Line(tsbZ, 1, 0, 1);
        pswOutZ1.addPoint(new Point(273, 298));
        pswOutZ1.addPoint(new Point(273, 291));

        junPSWout.setLine(pswOutZ1, 1);

        // V FF

        junLdPSWALUV = new Junction(2);
        junLdPSWV = new Junction(2);
        junV = new Junction(2);

        V = new Line(junV, 0, 0, 1);
        V.addPoint(new Point(435, 80));
        V.addPoint(new Point(435, 108));

        ldPSWALUV = new Line(junLdPSWALUV, 0, 0, 1);
        ldPSWALUV.addPoint(new Point(405, 97));
        ldPSWALUV.addPoint(new Point(420, 97));

        junLdPSWALU.setLine(ldPSWALUV, 2);

        ldPSWV = new Line(junLdPSWV, 0, 0, 1);
        ldPSWV.addPoint(new Point(405, 122));
        ldPSWV.addPoint(new Point(412, 122));

        junLdPSW.setLine(ldPSWV, 2);

        andV1 = new And(2);

        V1 = new Line(andV1, 1, 0, 1);
        V1.addPoint(new Point(435, 108));
        V1.addPoint(new Point(451, 108));

        ldPSWALUV1 = new Line(andV1, 0, 0, 1);
        ldPSWALUV1.addPoint(new Point(420, 97));
        ldPSWALUV1.addPoint(new Point(451, 97));

        orV1 = new Or(2);

        outAndV1 = new Line(orV1, 0, 0, 1);
        outAndV1.addPoint(new Point(476, 103));
        outAndV1.addPoint(new Point(482, 103));
        outAndV1.addPoint(new Point(482, 110));
        outAndV1.addPoint(new Point(491, 110));

        andV1.setLine(outAndV1, 0);

        junV.setLine(V1, 0);
        junLdPSWALUV.setLine(ldPSWALUV1, 0);

        andV2 = new And(2);

        ldPSWV1 = new Line(andV2, 0, 0, 1);
        ldPSWV1.addPoint(new Point(412, 122));
        ldPSWV1.addPoint(new Point(451, 122));

        junLdPSWV.setLine(ldPSWV1, 0);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndV2 = new Line(orV1, 1, 0, 1);
        outAndV2.addPoint(new Point(475, 127));
        outAndV2.addPoint(new Point(482, 127));
        outAndV2.addPoint(new Point(482, 122));
        outAndV2.addPoint(new Point(491, 122));

        andV2.setLine(outAndV2, 0);

        // donja dva and kola

        andV3 = new And(2);

        Invertor inv5 = new Invertor();
        V2 = new Line(inv5, 0, 1, 1);
        Line lin5 = new Line(andV3, 1, 0, 1);
        inv5.setLine(lin5, 0);
        V2.addPoint(new Point(435, 108));
        V2.addPoint(new Point(435, 163));
        V2.addPoint(new Point(448, 163));

        ldPSWALUV2 = new Line(andV3, 0, 1, 1);
        ldPSWALUV2.addPoint(new Point(420, 97));
        ldPSWALUV2.addPoint(new Point(420, 152));
        ldPSWALUV2.addPoint(new Point(452, 152));

        junV.setLine(V2, 1);
        junLdPSWALUV.setLine(ldPSWALUV2, 1);

        orV2 = new Or(2);

        outAndV3 = new Line(orV2, 0, 0, 1);
        outAndV3.addPoint(new Point(476, 157));
        outAndV3.addPoint(new Point(483, 157));
        outAndV3.addPoint(new Point(483, 163));
        outAndV3.addPoint(new Point(492, 163));

        andV3.setLine(outAndV3, 0);

        andV4 = new And(2);

        ldPSWV2 = new Line(andV4, 0, 1, 1);
        ldPSWV2.addPoint(new Point(413, 122));
        ldPSWV2.addPoint(new Point(413, 176));
        ldPSWV2.addPoint(new Point(452, 176));

        junLdPSWV.setLine(ldPSWV2, 1);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndV4 = new Line(orV2, 1, 0, 1);
        outAndV4.addPoint(new Point(476, 182));
        outAndV4.addPoint(new Point(483, 182));
        outAndV4.addPoint(new Point(483, 174));
        outAndV4.addPoint(new Point(492, 174));

        andV4.setLine(outAndV4, 0);

        // izlazi iz ili kola i ulazi u V FlipFlop

        ffV = new SRFlipFlop(0);

        outOrV1 = new Line(ffV, 0, 0, 1);
        outOrV1.addPoint(new Point(513, 116));
        outOrV1.addPoint(new Point(520, 116));

        outOrV2 = new Line(ffV, 1, 0, 1);
        outOrV2.addPoint(new Point(513, 169));
        outOrV2.addPoint(new Point(520, 169));

        orV1.setLine(outOrV1, 0);
        orV2.setLine(outOrV2, 0);

        junPSWV = new Junction(2);

        pswV0 = new Line(junPSWV, 0, 0, 1);
        pswV0.addPoint(new Point(578, 116));
        pswV0.addPoint(new Point(600, 116));

        ffV.setLine(pswV0, 0);

        tsbV = new TripleStateBuffer();

        pswV1 = new Line(tsbV, 0, 0, 1);
        pswV = new Line(null, 0, 1, 1);

        junPSWV.setLine(pswV1, 0);
        junPSWV.setLine(pswV, 1);

        pswOutV1 = new Line(tsbV, 1, 0, 1);
        pswOutV1.addPoint(new Point(613, 128));
        pswOutV1.addPoint(new Point(613, 121));

        junPSWout.setLine(pswOutV1, 2);

        // C flip flop

        junLdPSWALUC = new Junction(2);
        junLdPSWC = new Junction(2);
        junC = new Junction(2);

        C = new Line(junC, 0, 0, 1);
        C.addPoint(new Point(435, 250));
        C.addPoint(new Point(435, 278));

        ldPSWALUC = new Line(junLdPSWALUC, 0, 0, 1);
        ldPSWALUC.addPoint(new Point(405, 267));
        ldPSWALUC.addPoint(new Point(420, 267));

        junLdPSWALU.setLine(ldPSWALUC, 3);

        ldPSWC = new Line(junLdPSWC, 0, 0, 1);
        ldPSWC.addPoint(new Point(405, 292));
        ldPSWC.addPoint(new Point(412, 292));

        junLdPSW.setLine(ldPSWC, 3);

        andC1 = new And(2);

        C1 = new Line(andC1, 1, 0, 1);
        C1.addPoint(new Point(435, 278));
        C1.addPoint(new Point(451, 278));

        ldPSWALUC1 = new Line(andC1, 0, 0, 1);
        ldPSWALUC1.addPoint(new Point(420, 267));
        ldPSWALUC1.addPoint(new Point(451, 267));

        orC1 = new Or(2);

        outAndC1 = new Line(orC1, 0, 0, 1);
        outAndC1.addPoint(new Point(476, 273));
        outAndC1.addPoint(new Point(482, 273));
        outAndC1.addPoint(new Point(482, 280));
        outAndC1.addPoint(new Point(491, 280));

        andC1.setLine(outAndC1, 0);

        junC.setLine(C1, 0);
        junLdPSWALUC.setLine(ldPSWALUC1, 0);

        andC2 = new And(2);

        ldPSWC1 = new Line(andC2, 0, 0, 1);
        ldPSWC1.addPoint(new Point(412, 292));
        ldPSWC1.addPoint(new Point(451, 292));

        junLdPSWC.setLine(ldPSWC1, 0);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndC2 = new Line(orC1, 1, 0, 1);
        outAndC2.addPoint(new Point(475, 297));
        outAndC2.addPoint(new Point(482, 297));
        outAndC2.addPoint(new Point(482, 292));
        outAndC2.addPoint(new Point(491, 292));

        andC2.setLine(outAndC2, 0);

        // donja dva and kola

        andC3 = new And(2);

        Invertor inv7 = new Invertor();
        C2 = new Line(inv7, 0, 1, 1);
        Line lin7 = new Line(andC3, 1, 0, 1);
        inv7.setLine(lin7, 0);
        C2.addPoint(new Point(435, 278));
        C2.addPoint(new Point(435, 333));
        C2.addPoint(new Point(448, 333));

        ldPSWALUC2 = new Line(andC3, 0, 1, 1);
        ldPSWALUC2.addPoint(new Point(420, 267));
        ldPSWALUC2.addPoint(new Point(420, 322));
        ldPSWALUC2.addPoint(new Point(452, 322));

        junC.setLine(C2, 1);
        junLdPSWALUC.setLine(ldPSWALUC2, 1);

        orC2 = new Or(2);

        outAndC3 = new Line(orC2, 0, 0, 1);
        outAndC3.addPoint(new Point(476, 327));
        outAndC3.addPoint(new Point(483, 327));
        outAndC3.addPoint(new Point(483, 333));
        outAndC3.addPoint(new Point(492, 333));

        andC3.setLine(outAndC3, 0);

        andC4 = new And(2);

        ldPSWC2 = new Line(andC4, 0, 1, 1);
        ldPSWC2.addPoint(new Point(413, 292));
        ldPSWC2.addPoint(new Point(413, 346));
        ldPSWC2.addPoint(new Point(452, 346));

        junLdPSWC.setLine(ldPSWC2, 1);

        // TREBA DODATI DRUGI ULAZ U I KOLO SA MAGISTRALE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        outAndC4 = new Line(orC2, 1, 0, 1);
        outAndC4.addPoint(new Point(476, 352));
        outAndC4.addPoint(new Point(483, 352));
        outAndC4.addPoint(new Point(483, 344));
        outAndC4.addPoint(new Point(492, 344));

        andC4.setLine(outAndC4, 0);

        // izlazi iz ili kola i ulazi u C FlipFlop

        ffC = new SRFlipFlop(0);

        outOrC1 = new Line(ffC, 0, 0, 1);
        outOrC1.addPoint(new Point(513, 286));
        outOrC1.addPoint(new Point(520, 286));

        outOrC2 = new Line(ffC, 1, 0, 1);
        outOrC2.addPoint(new Point(513, 339));
        outOrC2.addPoint(new Point(520, 339));

        orC1.setLine(outOrC1, 0);
        orC2.setLine(outOrC2, 0);

        junPSWC = new Junction(2);

        pswC0 = new Line(junPSWC, 0, 0, 1);
        pswC0.addPoint(new Point(578, 286));
        pswC0.addPoint(new Point(600, 286));

        ffC.setLine(pswC0, 0);


        tsbC = new TripleStateBuffer();

        pswC1 = new Line(tsbC, 0, 0, 1);
        pswC = new Line(null, 0, 1, 1);

        junPSWC.setLine(pswC1, 0);
        junPSWC.setLine(pswC, 1);

        pswOutC1 = new Line(tsbC, 1, 0, 1);
        pswOutC1.addPoint(new Point(613, 298));
        pswOutC1.addPoint(new Point(613, 291));

        junPSWout.setLine(pswOutC1, 3);

        nselector = new Selector(4);
        zselector = new Selector(5);
        vselector = new Selector(6);
        cselector = new Selector(7);

        Junction[] selectorJunctions = new Junction[4];
        for (int i = 0; i < selectorJunctions.length; i++) {
            selectorJunctions[i] = new Junction(2);
        }

        nFromBus = new Line(selectorJunctions[0], 0, 0, 1);
        zFromBus = new Line(selectorJunctions[1], 0, 0, 1);
        vFromBus = new Line(selectorJunctions[2], 0, 0, 1);
        cFromBus = new Line(selectorJunctions[3], 0, 0, 1);

        nselector.setLine(nFromBus, 0);
        zselector.setLine(zFromBus, 0);
        cselector.setLine(cFromBus, 0);
        vselector.setLine(vFromBus, 0);

        Invertor[] selectorInvertors = new Invertor[4];
        for (int i = 0; i < selectorInvertors.length; i++) {
            selectorInvertors[i] = new Invertor();
        }

        lines = new Line[4][3];

        //N from bus
        lines[0][0] = new Line(andN2, 1, 0, 1);
        lines[0][1] = new Line(selectorInvertors[0], 0, 1, 1);
        lines[0][2] = new Line(andN4, 1, 0, 1);
        selectorJunctions[0].setLine(lines[0][0], 0);
        selectorJunctions[0].setLine(lines[0][1], 1);
        selectorInvertors[0].setLine(lines[0][2], 0);

        //Z from bus
        lines[1][0] = new Line(andZ2, 1, 0, 1);
        lines[1][1] = new Line(selectorInvertors[1], 0, 1, 1);
        lines[1][2] = new Line(andZ4, 1, 0, 1);
        selectorJunctions[1].setLine(lines[1][0], 0);
        selectorJunctions[1].setLine(lines[1][1], 1);
        selectorInvertors[1].setLine(lines[1][2], 0);

        //V from bus
        lines[2][0] = new Line(andV2, 1, 0, 1);
        lines[2][1] = new Line(selectorInvertors[2], 0, 1, 1);
        lines[2][2] = new Line(andV4, 1, 0, 1);
        selectorJunctions[2].setLine(lines[2][0], 0);
        selectorJunctions[2].setLine(lines[2][1], 1);
        selectorInvertors[2].setLine(lines[2][2], 0);

        //C from bus
        lines[3][0] = new Line(andC2, 1, 0, 1);
        lines[3][1] = new Line(selectorInvertors[3], 0, 1, 1);
        lines[3][2] = new Line(andC4, 1, 0, 1);
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

        lines[2][0].addPoint(new Point(428, 188));
        lines[2][0].addPoint(new Point(448, 188));
        lines[2][1].addPoint(new Point(428, 188));
        lines[2][1].addPoint(new Point(428, 133));
        lines[2][1].addPoint(new Point(452, 133));

        lines[3][0].addPoint(new Point(428, 358));
        lines[3][0].addPoint(new Point(447, 358));
        lines[3][1].addPoint(new Point(428, 358));
        lines[3][1].addPoint(new Point(428, 303));
        lines[3][1].addPoint(new Point(451, 303));

        nFromBus.addPoint(new Point(291, 205));
        nFromBus.addPoint(new Point(88, 205));
        nFromBus.addPoint(new Point(88, 188));

        zFromBus.addPoint(new Point(291, 374));
        zFromBus.addPoint(new Point(88, 374));
        zFromBus.addPoint(new Point(88, 357));

        vFromBus.addPoint(new Point(631, 205));
        vFromBus.addPoint(new Point(428, 205));
        vFromBus.addPoint(new Point(428, 188));

        cFromBus.addPoint(new Point(631, 375));
        cFromBus.addPoint(new Point(428, 375));
        cFromBus.addPoint(new Point(428, 358));
    }

    private void initBus() {

        sbus = new Bus(16);

        //vertical sbus
        sbus.addPoint(new Point(292, 94));
        sbus.addPoint(new Point(292, 393));
        sbus.addPoint(new Point(631, 93));
        sbus.addPoint(new Point(631, 393));

        //horizontal sbus
        sbus.addPoint(new Point(284, 116));
        sbus.addPoint(new Point(292, 116));
        sbus.addPoint(new Point(284, 286));
        sbus.addPoint(new Point(292, 286));
        sbus.addPoint(new Point(624, 116));
        sbus.addPoint(new Point(631, 116));
        sbus.addPoint(new Point(624, 286));
        sbus.addPoint(new Point(631, 286));

        //points for textual representation of bus value
        sbus.addTextPoint(new Point(295, 100));
        sbus.addTextPoint(new Point(634, 100));

        //add next components
        sbus.addNextComponent(nselector, 0);
        sbus.addNextComponent(zselector, 0);
        sbus.addNextComponent(cselector, 0);
        sbus.addNextComponent(vselector, 0);

    }

    public void refreshSequential() {
        ffN.refreshSequential();
        ffZ.refreshSequential();
        ffV.refreshSequential();
        ffC.refreshSequential();
    }

    public void clock() {

        ffN.clock();
        ffZ.clock();
        ffV.clock();
        ffC.clock();

    }

    public void clear() {
        ffN.setState(0);
        ffZ.setState(0);
        ffV.setState(0);
        ffC.setState(0);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // N FF

        ldPSWALUN.paint(g);
        ldPSWN.paint(g);
        N.paint(g);

        ldPSWALUN1.paint(g);
        N1.paint(g);

        ldPSWN1.paint(g);

        outAndN1.paint(g);
        outAndN2.paint(g);

        N2.paint(g);
        ldPSWALUN2.paint(g);

        ldPSWN2.paint(g);

        outAndN3.paint(g);
        outAndN4.paint(g);

        outOrN1.paint(g);
        outOrN2.paint(g);

        pswN0.paint(g);

        pswOutN1.paint(g);

        // Z FF

        ldPSWALUZ.paint(g);
        ldPSWZ.paint(g);
        Z.paint(g);

        ldPSWALUZ1.paint(g);
        Z1.paint(g);

        ldPSWZ1.paint(g);

        outAndZ1.paint(g);
        outAndZ2.paint(g);

        Z2.paint(g);
        ldPSWALUZ2.paint(g);

        ldPSWZ2.paint(g);

        outAndZ3.paint(g);
        outAndZ4.paint(g);

        outOrZ1.paint(g);
        outOrZ2.paint(g);

        pswZ0.paint(g);

        pswOutZ1.paint(g);

        // V FF

        ldPSWALUV.paint(g);
        ldPSWV.paint(g);
        V.paint(g);

        ldPSWALUV1.paint(g);
        V1.paint(g);

        ldPSWV1.paint(g);

        outAndV1.paint(g);
        outAndV2.paint(g);

        V2.paint(g);
        ldPSWALUV2.paint(g);

        ldPSWV2.paint(g);

        outAndV3.paint(g);
        outAndV4.paint(g);

        outOrV1.paint(g);
        outOrV2.paint(g);

        pswV0.paint(g);

        pswOutV1.paint(g);

        // C FF

        ldPSWALUC.paint(g);
        ldPSWC.paint(g);
        C.paint(g);

        ldPSWALUC1.paint(g);
        C1.paint(g);

        ldPSWC1.paint(g);

        outAndC1.paint(g);
        outAndC2.paint(g);

        C2.paint(g);
        ldPSWALUC2.paint(g);

        ldPSWC2.paint(g);

        outAndC3.paint(g);
        outAndC4.paint(g);

        outOrC1.paint(g);
        outOrC2.paint(g);

        pswC0.paint(g);

        pswOutC1.paint(g);

        sbus.paint(g);

        nFromBus.paint(g);
        zFromBus.paint(g);
        vFromBus.paint(g);
        cFromBus.paint(g);

        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length; j++) {
                lines[i][j].paint(g);
            }
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    //  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/etf/aor/images/CPU_blok_registri_treci.jpg"))); // NOI18N

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
