/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelForDrawings.java
 *
 * Created on 14.09.2010., 19.05.43
 */
package rs.etf.aor.gui;

import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import rs.etf.aor.components.Bus;
import rs.etf.aor.components.Junction;
import rs.etf.aor.components.JunctionForBus;
import rs.etf.aor.components.MergePSW;

/**
 *
 * @author MB
 */
public class MainPanel extends javax.swing.JPanel {

    private JFrame parent;
    // "cards"
    private JPanel CPU_blok_interfejs_drugi,
            CPU_blok_interfejs_prvi,
            CPU_blok_interfejs_treci,
            CPU_blok_operacije_drugi,
            CPU_blok_operacije_prvi,
            CPU_blok_registri_peti,
            CPU_blok_registri_drugi,
            CPU_blok_registri_cetvri,
            CPU_blok_prekidi_prvi,
            CPU_blok_prekidi_drugi,
            CPU_blok_registri_prvi,
            CPU_blok_registri_sedmi,
            CPU_blok_registri_sesti,
            CPU_blok_registri_treci,
            CPU_organizacija_interfejs,
            CPU_organizacija_main,
            CPU_organizacija_registri,
            CPU_organizacija_prekid,
            CPU_upravljacka_drugi,
            CPU_upravljacka_prvi,
            System_main;
    private Map<String, PanelsInfo> panels;
    private String current; //current panel title

    /** Creates new form PanelForDrawings */
    public MainPanel() {
        panels = new HashMap<String, PanelsInfo>();

        initComponents();
        initLayout();
        connectPanels();

        clk();

    }

    public String getCurrent() {
        return current;
    }

    public boolean getHalt() {
        return ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).getHalt();
    }

    private void connectPanels() {

        JunctionForBus sbusJunction = new JunctionForBus(11);
        ((CPU_organizacija_main) CPU_organizacija_main).sbus.addNextComponent(sbusJunction, 0);
        ((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).sbus.addNextComponent(sbusJunction, 1);
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).sbus.addNextComponent(sbusJunction, 2);
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).sbus.addNextComponent(sbusJunction, 3);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).sbus.addNextComponent(sbusJunction, 4);
        ((CPU_blok_registri_treci) CPU_blok_registri_treci).sbus.addNextComponent(sbusJunction, 5);
        ((CPU_organizacija_interfejs) CPU_organizacija_interfejs).sbus.addNextComponent(sbusJunction, 6);
        ((CPU_organizacija_prekid) CPU_organizacija_prekid).sbus.addNextComponent(sbusJunction, 7);
        ((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).sbus.addNextComponent(sbusJunction, 8);
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).sbus.addNextComponent(sbusJunction, 9);
        ((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).sbus.addNextComponent(sbusJunction, 10);
        sbusJunction.setLine(((CPU_organizacija_main) CPU_organizacija_main).sbus, 0);
        sbusJunction.setLine(((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).sbus, 1);
        sbusJunction.setLine(((CPU_blok_registri_drugi) CPU_blok_registri_drugi).sbus, 2);
        sbusJunction.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).sbus, 3);
        sbusJunction.setLine(((CPU_blok_registri_prvi) CPU_blok_registri_prvi).sbus, 4);
        sbusJunction.setLine(((CPU_blok_registri_treci) CPU_blok_registri_treci).sbus, 5);
        sbusJunction.setLine(((CPU_organizacija_interfejs) CPU_organizacija_interfejs).sbus, 6);
        sbusJunction.setLine(((CPU_organizacija_prekid) CPU_organizacija_prekid).sbus, 7);
        sbusJunction.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).sbus, 8);
        sbusJunction.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).sbus, 9);
        sbusJunction.setLine(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).sbus, 10);

        JunctionForBus dbusJunction = new JunctionForBus(10);
        ((CPU_organizacija_main) CPU_organizacija_main).dbus.addNextComponent(dbusJunction, 0);
        ((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).dbus.addNextComponent(dbusJunction, 1);
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).dbus.addNextComponent(dbusJunction, 2);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).dbus.addNextComponent(dbusJunction, 3);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).dbus.addNextComponent(dbusJunction, 4);
        ((CPU_organizacija_interfejs) CPU_organizacija_interfejs).dbus.addNextComponent(dbusJunction, 5);
        ((CPU_organizacija_prekid) CPU_organizacija_prekid).dbus.addNextComponent(dbusJunction, 6);
        ((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).dbus.addNextComponent(dbusJunction, 7);
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).dbus.addNextComponent(dbusJunction, 8);
        ((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).dbus.addNextComponent(dbusJunction, 9);
        dbusJunction.setLine(((CPU_organizacija_main) CPU_organizacija_main).dbus, 0);
        dbusJunction.setLine(((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).dbus, 1);
        dbusJunction.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).dbus, 2);
        dbusJunction.setLine(((CPU_blok_registri_prvi) CPU_blok_registri_prvi).dbus, 3);
        dbusJunction.setLine(((CPU_blok_registri_sesti) CPU_blok_registri_sesti).dbus, 4);
        dbusJunction.setLine(((CPU_organizacija_interfejs) CPU_organizacija_interfejs).dbus, 5);
        dbusJunction.setLine(((CPU_organizacija_prekid) CPU_organizacija_prekid).dbus, 6);
        dbusJunction.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).dbus, 7);
        dbusJunction.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).dbus, 8);
        dbusJunction.setLine(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).dbus, 9);

        JunctionForBus systemABUSJunction = new JunctionForBus(4);
        ((CPU_organizacija_main) CPU_organizacija_main).systemABUS.addNextComponent(systemABUSJunction, 0);
        ((CPU_organizacija_interfejs) CPU_organizacija_interfejs).systemABUS.addNextComponent(systemABUSJunction, 1);
        ((System_main) System_main).systemABUS.addNextComponent(systemABUSJunction, 2);
        ((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).systemABUS.addNextComponent(systemABUSJunction, 3);
        systemABUSJunction.setLine(((CPU_organizacija_main) CPU_organizacija_main).systemABUS, 0);
        systemABUSJunction.setLine(((CPU_organizacija_interfejs) CPU_organizacija_interfejs).systemABUS, 1);
        systemABUSJunction.setLine(((System_main) System_main).systemABUS, 2);
        systemABUSJunction.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).systemABUS, 3);

        JunctionForBus systemDBUSJunction = new JunctionForBus(4);
        ((CPU_organizacija_main) CPU_organizacija_main).systemDBUS.addNextComponent(systemDBUSJunction, 0);
        ((CPU_organizacija_interfejs) CPU_organizacija_interfejs).systemDBUS.addNextComponent(systemDBUSJunction, 1);
        ((System_main) System_main).systemDBUS.addNextComponent(systemDBUSJunction, 2);
        ((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).systemDBUS.addNextComponent(systemDBUSJunction, 3);
        systemDBUSJunction.setLine(((CPU_organizacija_main) CPU_organizacija_main).systemDBUS, 0);
        systemDBUSJunction.setLine(((CPU_organizacija_interfejs) CPU_organizacija_interfejs).systemDBUS, 1);
        systemDBUSJunction.setLine(((System_main) System_main).systemDBUS, 2);
        systemDBUSJunction.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).systemDBUS, 3);

        //spajanje operacija i generisanja flegova
        Junction x15 = new Junction(1);
        x15.setLine(((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[0], 0);
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[13].setNextComp(x15);
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[13].setNextCompPort(0);

        Junction y15 = new Junction(1);
        y15.setLine(((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[1], 0);
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[11].setNextComp(y15);
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[11].setNextCompPort(0);

        Junction alu15 = new Junction(1);
        alu15.setLine(((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[2], 0);
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[40].setNextComp(alu15);
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[40].setNextCompPort(0);

        Junction alu16 = new Junction(1);
        alu16.setLine(((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[6], 0);
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[14].setNextComp(alu16);
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[14].setNextCompPort(0);

        Junction x0 = new Junction(1);
        x0.setLine(((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[40], 0);
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[12].setNextComp(x0);
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[12].setNextCompPort(0);

        Junction[] alu0to14 = new Junction[15];
        for (int i = 0; i < alu0to14.length; i++) {
            alu0to14[i] = new Junction(1);
        }

        alu0to14[0].setLine(((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[48], 0);
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[25].setNextComp(alu0to14[0]);
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[25].setNextCompPort(0);

        for (int i = 1; i < alu0to14.length; i++) {
            alu0to14[i].setLine(((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[49 + i], 0);
            ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[25 + i].setNextComp(alu0to14[i]);
            ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[25 + i].setNextCompPort(0);
        }

        //spajanje signala za load i out sa registrima
        Junction axout = new Junction(1);
        axout.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).AXout, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[15].setNextComp(axout);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[15].setNextCompPort(0);

        Junction ldax = new Junction(1);
        ldax.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).ldAX, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[12].setNextComp(ldax);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[12].setNextCompPort(0);

        Junction bxout = new Junction(1);
        bxout.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).BXout, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[35].setNextComp(bxout);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[35].setNextCompPort(0);

        Junction ldbx = new Junction(1);
        ldbx.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).ldBX, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[30].setNextComp(ldbx);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[30].setNextCompPort(0);

        Junction cxout = new Junction(1);
        cxout.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).CXout, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[21].setNextComp(cxout);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[21].setNextCompPort(0);

        Junction ldcx = new Junction(1);
        ldcx.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).ldCX, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[18].setNextComp(ldcx);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[18].setNextCompPort(0);

        Junction dxout = new Junction(1);
        dxout.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).DXout, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[27].setNextComp(dxout);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[27].setNextCompPort(0);

        Junction lddx = new Junction(1);
        lddx.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).ldDX, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[24].setNextComp(lddx);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[24].setNextCompPort(0);

        Junction siout = new Junction(1);
        siout.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).SIout, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[51].setNextComp(siout);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[51].setNextCompPort(0);

        Junction ldsi = new Junction(1);
        ldsi.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).ldSI, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[46].setNextComp(ldsi);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[46].setNextCompPort(0);

        Junction diout = new Junction(1);
        diout.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).DIout, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[59].setNextComp(diout);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[59].setNextCompPort(0);

        Junction lddi = new Junction(1);
        lddi.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).ldDI, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[54].setNextComp(lddi);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[54].setNextCompPort(0);

        Junction spout = new Junction(1);
        spout.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).SPout, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[69].setNextComp(spout);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[69].setNextCompPort(0);

        Junction ldsp = new Junction(1);
        ldsp.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).ldSP, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[64].setNextComp(ldsp);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[64].setNextCompPort(0);

        Junction bpout = new Junction(1);
        bpout.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).BPout, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[43].setNextComp(bpout);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[43].setNextCompPort(0);

        Junction ldbp = new Junction(1);
        ldbp.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).ldBP, 0);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[38].setNextComp(ldbp);
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[38].setNextCompPort(0);

        //spajanje selekcije registara na osnovu nacina adresiranja sa kombinacionom mrezom za selekciju
        Junction axsel = new Junction(1);
        axsel.setLine(((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[2], 0);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[15].setNextComp(axsel);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[15].setNextCompPort(0);

        Junction bxsel = new Junction(1);
        bxsel.setLine(((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[3], 0);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[16].setNextComp(bxsel);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[16].setNextCompPort(0);

        Junction cxsel = new Junction(1);
        cxsel.setLine(((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[4], 0);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[17].setNextComp(cxsel);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[17].setNextCompPort(0);

        Junction dxsel = new Junction(1);
        dxsel.setLine(((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[5], 0);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[18].setNextComp(dxsel);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[18].setNextCompPort(0);

        Junction spsel = new Junction(1);
        spsel.setLine(((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[9], 0);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[19].setNextComp(spsel);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[19].setNextCompPort(0);

        Junction bpsel = new Junction(1);
        bpsel.setLine(((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[6], 0);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[20].setNextComp(bpsel);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[20].setNextCompPort(0);

        Junction sisel = new Junction(1);
        sisel.setLine(((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[8], 0);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[21].setNextComp(sisel);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[21].setNextCompPort(0);

        Junction disel = new Junction(1);
        disel.setLine(((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[7], 0);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[22].setNextComp(disel);
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[22].setNextCompPort(0);


        //resetF
        Junction resetF = new Junction(1);
        resetF.setLine(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).resetF, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[0].setNextComp(resetF);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[0].setNextCompPort(0);

        //PCout
        Junction pcout = new Junction(1);
        pcout.setLine(((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).PCout, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[1].setNextComp(pcout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[1].setNextCompPort(0);

        //ldMAR
        Junction ldMAR = new Junction(1);
        ldMAR.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).lines[2], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[2].setNextComp(ldMAR);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[2].setNextCompPort(0);

        //read
        Junction read = new Junction(1);
        read.setLine(((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[0], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[3].setNextComp(read);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[3].setNextCompPort(0);

        //ldMBR
        Junction ldMBR = new Junction(1);
        ldMBR.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).lines[8], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[4].setNextComp(ldMBR);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[4].setNextCompPort(0);

        //incPC
        Junction incPC = new Junction(1);
        incPC.setLine(((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).incPC, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[5].setNextComp(incPC);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[5].setNextCompPort(0);

        //MBRout
        Junction mbrout = new Junction(1);
        mbrout.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).lines[11], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[6].setNextComp(mbrout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[6].setNextCompPort(0);

        //ldIR1
        Junction ldIR1 = new Junction(1);
        ldIR1.setLine(((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[0], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[7].setNextComp(ldIR1);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[7].setNextCompPort(0);

        //incMAR
        Junction incMAR = new Junction(1);
        incMAR.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).lines[0], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[8].setNextComp(incMAR);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[8].setNextCompPort(0);

        //ldIR2
        Junction ldIR2 = new Junction(1);
        ldIR2.setLine(((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[1], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[9].setNextComp(ldIR2);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[9].setNextCompPort(0);

        //ldIR3
        Junction ldIR3 = new Junction(1);
        ldIR3.setLine(((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[2], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[10].setNextComp(ldIR3);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[10].setNextCompPort(0);

        //ldIR4
        Junction ldIR4 = new Junction(1);
        ldIR4.setLine(((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[3], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[11].setNextComp(ldIR4);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[11].setNextCompPort(0);

        //REGout
        Junction regout = new Junction(2);
        regout.setLine(((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[1], 0);
        regout.setLine(((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[23], 1);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[12].setNextComp(regout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[12].setNextCompPort(0);

        //ldBlow
        Junction ldBlow = new Junction(1);
        ldBlow.setLine(((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).ldBLow, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[13].setNextComp(ldBlow);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[13].setNextCompPort(0);

        //ldBHigh
        Junction ldBhigh = new Junction(1);
        ldBhigh.setLine(((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).ldBHigh, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[14].setNextComp(ldBhigh);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[14].setNextCompPort(0);

        //fdo
        Junction fdo = new Junction(1);
        fdo.setLine(((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[1], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[15].setNextComp(fdo);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[15].setNextCompPort(0);

        //DSout
        Junction dsout = new Junction(1);
        dsout.setLine(((CPU_organizacija_main) CPU_organizacija_main).lines[1], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[16].setNextComp(dsout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[16].setNextCompPort(0);

        //ldX
        Junction ldX = new Junction(1);
        ldX.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[0], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[17].setNextComp(ldX);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[17].setNextCompPort(0);

        //IR3out
        Junction ir3out = new Junction(1);
        ir3out.setLine(((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[4], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[18].setNextComp(ir3out);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[18].setNextCompPort(0);

        //ldY
        Junction ldY = new Junction(1);
        ldY.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[1], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[19].setNextComp(ldY);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[19].setNextCompPort(0);

        //add
        Junction add = new Junction(1);
        add.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[3], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[20].setNextComp(add);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[20].setNextCompPort(0);

        //ALUout
        Junction aluout = new Junction(1);
        aluout.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[19], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[21].setNextComp(aluout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[21].setNextCompPort(0);

        //IR_DAout
        Junction ir_daout = new Junction(1);
        ir_daout.setLine(((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[7], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[22].setNextComp(ir_daout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[22].setNextCompPort(0);

        //Bout
        Junction bout = new Junction(1);
        bout.setLine(((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).Bout, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[23].setNextComp(bout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[23].setNextCompPort(0);

        //DSout
        Junction sdout = new Junction(1);
        sdout.setLine(((CPU_organizacija_main) CPU_organizacija_main).lines[0], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[24].setNextComp(sdout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[24].setNextCompPort(0);

        //setCOD
        Junction setCOD = new Junction(1);
        setCOD.setLine(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).setCOD, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[25].setNextComp(setCOD);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[25].setNextCompPort(0);

        //daREG
        Junction daREG = new Junction(1);
        daREG.setLine(((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[0], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[26].setNextComp(daREG);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[26].setNextCompPort(0);

        //ldREG
        Junction ldREG = new Junction(1);
        ldREG.setLine(((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[0], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[27].setNextComp(ldREG);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[27].setNextCompPort(0);

        //trans
        Junction trans = new Junction(1);
        trans.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[2], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[28].setNextComp(trans);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[28].setNextCompPort(0);

        //ldPSWalu
        Junction ldPSWalu = new Junction(1);
        ldPSWalu.setLine(((CPU_blok_registri_treci) CPU_blok_registri_treci).ldPSWALU, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[29].setNextComp(ldPSWalu);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[29].setNextCompPort(0);

        //and
        Junction and = new Junction(1);
        and.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[6], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[30].setNextComp(and);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[30].setNextCompPort(0);

        //asr
        Junction asr = new Junction(1);
        asr.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[7], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[31].setNextComp(asr);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[31].setNextCompPort(0);

        //IR2out
        Junction ir2out = new Junction(1);
        ir2out.setLine(((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[5], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[32].setNextComp(ir2out);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[32].setNextCompPort(0);

        //ldPChigh
        Junction ldPChigh = new Junction(1);
        ldPChigh.setLine(((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).ldPCHigh, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[33].setNextComp(ldPChigh);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[33].setNextCompPort(0);

        //ldPClow
        Junction ldPClow = new Junction(1);
        ldPClow.setLine(((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).ldPCLow, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[34].setNextComp(ldPClow);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[34].setNextCompPort(0);

        //decSP
        Junction decSP = new Junction(1);
        decSP.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).decSP, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[35].setNextComp(decSP);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[33].setNextCompPort(0);

        //mxMBR
        Junction mxMBR = new Junction(1);
        mxMBR.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).lines[7], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[36].setNextComp(mxMBR);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[36].setNextCompPort(0);

        //upSPout
        Junction upSPout = new Junction(1);
        upSPout.setLine(((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).lines[68], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[37].setNextComp(upSPout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[37].setNextCompPort(0);

        //write
        Junction write = new Junction(2);
        write.setLine(((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[13], 0);
        write.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).lines[9], 1);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[38].setNextComp(write);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[38].setNextCompPort(0);

        //MBRhigh
        Junction mbrhigh = new Junction(1);
        mbrhigh.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).lines[6], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[39].setNextComp(mbrhigh);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[39].setNextCompPort(0);

        //IR_JAout
        Junction ir_jaout = new Junction(1);
        ir_jaout.setLine(((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[6], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[40].setNextComp(ir_jaout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[40].setNextCompPort(0);

        //incSP
        Junction incSP = new Junction(1);
        incSP.setLine(((CPU_blok_registri_peti) CPU_blok_registri_peti).incSP, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[41].setNextComp(incSP);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[41].setNextCompPort(0);

        //ldPSW
        Junction ldPSW = new Junction(2);
        ldPSW.setLine(((CPU_blok_registri_treci) CPU_blok_registri_treci).ldPSW, 0);
        ldPSW.setLine(((CPU_blok_registri_drugi) CPU_blok_registri_drugi).ldPSW, 1);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[42].setNextComp(ldPSW);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[42].setNextCompPort(0);

        //setINT
        Junction setINT = new Junction(1);
        setINT.setLine(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).setINT, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[43].setNextComp(setINT);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[43].setNextCompPort(0);

        //ldA
        Junction ldA = new Junction(1);
        ldA.setLine(((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).ldA, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[44].setNextComp(ldA);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[44].setNextCompPort(0);

        //Aout
        Junction aout = new Junction(1);
        aout.setLine(((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).Aout, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[45].setNextComp(aout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[45].setNextCompPort(0);

        //inc
        Junction inc = new Junction(1);
        inc.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[4], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[46].setNextComp(inc);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[46].setNextCompPort(0);

        //dec
        Junction dec = new Junction(1);
        dec.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[5], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[47].setNextComp(dec);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[47].setNextCompPort(0);

        //setI
        Junction setI = new Junction(1);
        setI.setLine(((CPU_blok_registri_drugi) CPU_blok_registri_drugi).setI, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[48].setNextComp(setI);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[48].setNextCompPort(0);

        //resetI
        Junction resetI = new Junction(1);
        resetI.setLine(((CPU_blok_registri_drugi) CPU_blok_registri_drugi).resetI, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[49].setNextComp(resetI);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[49].setNextCompPort(0);

        //setT
        Junction setT = new Junction(1);
        setT.setLine(((CPU_blok_registri_drugi) CPU_blok_registri_drugi).setT, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[50].setNextComp(setT);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[50].setNextCompPort(0);

        //resetT
        Junction resetT = new Junction(1);
        resetT.setLine(((CPU_blok_registri_drugi) CPU_blok_registri_drugi).resetT, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[51].setNextComp(resetT);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[51].setNextCompPort(0);

        //decMAR
        Junction decMAR = new Junction(1);
        decMAR.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).lines[1], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[52].setNextComp(decMAR);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[52].setNextCompPort(0);

        //fvo
        Junction fvo = new Junction(1);
        fvo.setLine(((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[6], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[53].setNextComp(fvo);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[53].setNextCompPort(0);

        //setADR
        Junction setADR = new Junction(1);
        setADR.setLine(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).setADR, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[54].setNextComp(setADR);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[54].setNextCompPort(0);

        //ldBR
        Junction ldBR = new Junction(1);
        ldBR.setLine(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).ldBR, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[55].setNextComp(ldBR);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[55].setNextCompPort(0);

        //intack
        Junction intack = new Junction(2);
        intack.setLine(((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).intack, 0);
        intack.setLine(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).intack, 1);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[56].setNextComp(intack);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[56].setNextCompPort(0);

        //PSWout
        Junction pswout = new Junction(2);
        pswout.setLine(((CPU_blok_registri_treci) CPU_blok_registri_treci).pswOut, 0);
        pswout.setLine(((CPU_blok_registri_drugi) CPU_blok_registri_drugi).pswOut, 1);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[57].setNextComp(pswout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[57].setNextCompPort(0);

        //BRout
        Junction brout = new Junction(1);
        brout.setLine(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).BRout, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[58].setNextComp(brout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[58].setNextCompPort(0);

        //shl
        Junction shl = new Junction(1);
        shl.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[8], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[59].setNextComp(shl);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[59].setNextCompPort(0);

        //IVTPout
        Junction ivtpout = new Junction(1);
        ivtpout.setLine(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).IVTPout, 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[60].setNextComp(ivtpout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[60].setNextCompPort(0);

        //MARout
        Junction marout = new Junction(1);
        marout.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).lines[5], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[61].setNextComp(marout);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).opLines[61].setNextCompPort(0);

        //merging PSW
        Bus[] tempLines = new Bus[8];
        for (int i = 0; i < tempLines.length; i++) {
            tempLines[i] = new Bus(1);
        }
        MergePSW mergePSW = new MergePSW();
        mergePSW.setLine(((CPU_blok_registri_treci) CPU_blok_registri_treci).sbus, 0);
        ((CPU_blok_registri_treci) CPU_blok_registri_treci).tsbC.setLine(tempLines[7], 0);
        ((CPU_blok_registri_treci) CPU_blok_registri_treci).tsbV.setLine(tempLines[6], 0);
        ((CPU_blok_registri_treci) CPU_blok_registri_treci).tsbZ.setLine(tempLines[5], 0);
        ((CPU_blok_registri_treci) CPU_blok_registri_treci).tsbN.setLine(tempLines[4], 0);
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).tsbT.setLine(tempLines[3], 0);
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).tsbI.setLine(tempLines[2], 0);
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).tsbL1.setLine(tempLines[1], 0);
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).tsbL0.setLine(tempLines[0], 0);

        for (int i = 0; i < tempLines.length; i++) {
            tempLines[i].addNextComponent(mergePSW, i);
        }

        //spajanje RD i WR bus
        Junction readBus = new Junction(6);
        readBus.setLine(((CPU_organizacija_interfejs) CPU_organizacija_interfejs).lines[2], 0);
        readBus.setLine(((CPU_organizacija_main) CPU_organizacija_main).lines[18], 1);
        readBus.setLine(((System_main) System_main).lines[0], 2);
        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[2].setNextComp(readBus);
        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[2].setNextCompPort(0);

        Junction writeBus = new Junction(3);
        writeBus.setLine(((CPU_organizacija_interfejs) CPU_organizacija_interfejs).lines[5], 0);
        writeBus.setLine(((CPU_organizacija_main) CPU_organizacija_main).lines[22], 1);
        writeBus.setLine(((System_main) System_main).lines[5], 2);
        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[17].setNextComp(writeBus);
        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[17].setNextCompPort(0);

        //MARout1
        Junction marout1 = new Junction(1);
        marout1.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).lines[3], 0);
        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[23].setNextComp(marout1);
        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[23].setNextCompPort(0);

        //BusHOLD
        Junction busHOLD = new Junction(2);
        busHOLD.setLine(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).lines[4], 0);
        busHOLD.setLine(((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[4], 1);
        ((CPU_blok_interfejs_treci) CPU_blok_interfejs_treci).lines[27].setNextComp(busHOLD);
        ((CPU_blok_interfejs_treci) CPU_blok_interfejs_treci).lines[27].setNextCompPort(0);

        //brqStart
        Junction brqStart = new Junction(1);
        brqStart.setLine(((CPU_blok_interfejs_treci) CPU_blok_interfejs_treci).lines[5], 0);
        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[20].setNextComp(brqStart);
        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[20].setNextCompPort(0);

        //brqStop
        Junction brqStop = new Junction(2);
        brqStop.setLine(((CPU_blok_interfejs_treci) CPU_blok_interfejs_treci).lines[6], 0);
        brqStop.setLine(((CPU_blok_interfejs_treci) CPU_blok_interfejs_treci).lines[25], 1);
        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[27].setNextComp(brqStop);
        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[27].setNextCompPort(0);

        //flegovi
        Junction n = new Junction(2);
        n.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[18], 0);
        n.setLine(((CPU_blok_registri_treci) CPU_blok_registri_treci).N, 1);
        ((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[9].setNextComp(n);
        ((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[9].setNextCompPort(0);

        Junction z = new Junction(2);
        z.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[17], 0);
        z.setLine(((CPU_blok_registri_treci) CPU_blok_registri_treci).Z, 1);
        ((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[49].setNextComp(z);
        ((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[49].setNextCompPort(0);

        Junction c = new Junction(2);
        c.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[16], 0);
        c.setLine(((CPU_blok_registri_treci) CPU_blok_registri_treci).C, 1);
        ((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[45].setNextComp(c);
        ((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[45].setNextCompPort(0);

        Junction v = new Junction(2);
        v.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[15], 0);
        v.setLine(((CPU_blok_registri_treci) CPU_blok_registri_treci).V, 1);
        ((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[28].setNextComp(v);
        ((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[28].setNextCompPort(0);

        //PRPERR
        Junction prperr = new Junction(1);
        prperr.setLine(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).prper, 0);
        ((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).prper.setNextComp(prperr);
        ((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).prper.setNextCompPort(0);

        //prL0
        Junction prL0 = new Junction(1);
        prL0.setLine(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).prl0, 0);
        ((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).prl0.setNextComp(prL0);
        ((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).prl0.setNextCompPort(0);

        //prL1
        Junction prL1 = new Junction(1);
        prL1.setLine(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).prl1, 0);
        ((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).prl1.setNextComp(prL1);
        ((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).prl1.setNextCompPort(0);

        //intr1
        Junction intr1 = new Junction(1);
        intr1.setLine(((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).intr1, 0);
        ((CPU_organizacija_main) CPU_organizacija_main).lines[3].setNextComp(intr1);
        ((CPU_organizacija_main) CPU_organizacija_main).lines[3].setNextCompPort(0);

        //intr2
        Junction intr2 = new Junction(1);
        intr2.setLine(((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).intr2, 0);
        ((CPU_organizacija_main) CPU_organizacija_main).lines[5].setNextComp(intr2);
        ((CPU_organizacija_main) CPU_organizacija_main).lines[5].setNextCompPort(0);

        //intr3
        Junction intr3 = new Junction(1);
        intr3.setLine(((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).intr3, 0);
        ((CPU_organizacija_main) CPU_organizacija_main).lines[7].setNextComp(intr3);
        ((CPU_organizacija_main) CPU_organizacija_main).lines[7].setNextCompPort(0);

        //inta1
        Junction inta1 = new Junction(1);
        inta1.setLine(((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).inta1, 0);
        ((CPU_organizacija_main) CPU_organizacija_main).lines[8].setNextComp(inta1);
        ((CPU_organizacija_main) CPU_organizacija_main).lines[8].setNextCompPort(0);

        //inta2
        Junction inta2 = new Junction(1);
        inta2.setLine(((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).inta2, 0);
        ((CPU_organizacija_main) CPU_organizacija_main).lines[10].setNextComp(inta2);
        ((CPU_organizacija_main) CPU_organizacija_main).lines[10].setNextCompPort(0);

        //inta3
        Junction inta3 = new Junction(1);
        inta3.setLine(((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).inta3, 0);
        ((CPU_organizacija_main) CPU_organizacija_main).lines[12].setNextComp(inta3);
        ((CPU_organizacija_main) CPU_organizacija_main).lines[12].setNextCompPort(0);

        //run
        Junction run = new Junction(1);
        run.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).lines[19], 0);
        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[42].setNextComp(run);
        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[42].setNextCompPort(0);

        //IR2
        Junction ir2 = new Junction(2);
        ir2.setLine(((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[59], 0);
        ir2.setLine(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).IR2, 1);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[77].setNextComp(ir2);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[77].setNextCompPort(0);

        //PSWT
        Junction pswT = new Junction(1);
        pswT.setLine(((CPU_blok_prekidi_drugi)CPU_blok_prekidi_drugi).pswT, 0);
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).pswT.setNextComp(pswT);
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).pswT.setNextCompPort(0);

        //PSWI
        Junction pswI = new Junction(1);
        pswI.setLine(((CPU_blok_prekidi_prvi)CPU_blok_prekidi_prvi).pswI, 0);
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).pswI.setNextComp(pswI);
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).pswI.setNextCompPort(0);

        //ldL
        Junction ldL = new Junction(1);
        ldL.setLine(((CPU_blok_prekidi_prvi)CPU_blok_prekidi_prvi).ldL, 0);
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).ldL.setNextComp(ldL);
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).ldL.setNextCompPort(0);

        //BX on add
        Junction bxOnAdd = new Junction(1);
        bxOnAdd.setLine(((CPU_blok_registri_sesti)CPU_blok_registri_sesti).lines[52], 0);
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).BX.setNextComp(bxOnAdd);
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).BX.setNextCompPort(0);

        //BP on add
        Junction bpOnAdd = new Junction(1);
        bpOnAdd.setLine(((CPU_blok_registri_sesti)CPU_blok_registri_sesti).lines[53], 0);
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).BP.setNextComp(bpOnAdd);
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).BP.setNextCompPort(0);

        //SI on add
        Junction siOnAdd = new Junction(1);
        siOnAdd.setLine(((CPU_blok_registri_sesti)CPU_blok_registri_sesti).lines[54], 0);
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).SI.setNextComp(siOnAdd);
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).SI.setNextCompPort(0);

        //DI on add
        Junction diOnAdd = new Junction(1);
        diOnAdd.setLine(((CPU_blok_registri_sesti)CPU_blok_registri_sesti).lines[55], 0);
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).DI.setNextComp(diOnAdd);
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).DI.setNextCompPort(0);

        //halt
        Junction halt = new Junction(1);
        halt.setLine(((CPU_upravljacka_prvi)CPU_upravljacka_prvi).lines[22], 0);
        ((CPU_blok_interfejs_drugi)CPU_blok_interfejs_drugi).lines[25].setNextComp(halt);
        ((CPU_blok_interfejs_drugi)CPU_blok_interfejs_drugi).lines[25].setNextCompPort(0);

        //inm
        Junction inm = new Junction(1);
        inm.setLine(((CPU_blok_prekidi_drugi)CPU_blok_prekidi_drugi).setNMI, 0);
        ((CPU_organizacija_main)CPU_organizacija_main).lines[15].setNextComp(inm);
        ((CPU_organizacija_main)CPU_organizacija_main).lines[15].setNextCompPort(0);

        //brop
        Junction brop = new Junction(1);
        brop.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).lines[9], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[5].setNextComp(brop);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[5].setNextCompPort(0);

        //bradr
        Junction bradr = new Junction(1);
        bradr.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).lines[10], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[6].setNextComp(bradr);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[6].setNextCompPort(0);

        //bruncnd
        Junction bruncnd = new Junction(1);
        bruncnd.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).lines[15], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[7].setNextComp(bruncnd);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[7].setNextCompPort(0);

        //val00
        Junction val00 = new Junction(1);
        val00.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmbranchLines[0], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[8].setNextComp(val00);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[8].setNextCompPort(0);

        //val0e
        Junction val0e = new Junction(1);
        val0e.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmbranchLines[1], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).upLines[4].setNextComp(val0e);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).upLines[4].setNextCompPort(0);

        //val19
        Junction val19 = new Junction(1);
        val19.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmbranchLines[2], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).upLines[5].setNextComp(val19);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).upLines[5].setNextCompPort(0);

        //val34
        Junction val34 = new Junction(1);
        val34.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmbranchLines[3], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[9].setNextComp(val34);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[9].setNextCompPort(0);

        //val3b
        Junction val3b = new Junction(1);
        val3b.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmbranchLines[4], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).upLines[7].setNextComp(val3b);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).upLines[7].setNextCompPort(0);

        //val92
        Junction val94 = new Junction(1);
        val94.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmbranchLines[5], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).upLines[8].setNextComp(val94);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).upLines[8].setNextCompPort(0);

        //val98
        Junction val9a = new Junction(1);
        val9a.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmbranchLines[6], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).upLines[9].setNextComp(val9a);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).upLines[9].setNextCompPort(0);

        //val9a
        Junction val9c = new Junction(1);
        val9c.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmbranchLines[7], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).upLines[10].setNextComp(val9c);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).upLines[10].setNextCompPort(0);

        //val9b
        Junction val9d = new Junction(1);
        val9d.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmbranchLines[8], 0);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[10].setNextComp(val9d);
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[10].setNextCompPort(0);

        //HALT
        Junction haltUp = new Junction(1);
        haltUp.setLine(((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).lines[24], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[53].setNextComp(haltUp);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[53].setNextCompPort(0);

        //MOVS
        Junction movs = new Junction(2);
        movs.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[0], 0);
        movs.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[9], 1);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[50].setNextComp(movs);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[50].setNextCompPort(0);

        //MOVD
        Junction movd = new Junction(1);
        movd.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[1], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[79].setNextComp(movd);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[79].setNextCompPort(0);

        //ADD
        Junction addUp = new Junction(2);
        addUp.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[2], 0);
        addUp.setLine(((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[5], 1);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[51].setNextComp(addUp);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[51].setNextCompPort(0);

        //andUp
        Junction andUp = new Junction(1);
        andUp.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[3], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[52].setNextComp(andUp);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[52].setNextCompPort(0);

        //asrUp
        Junction asrUp = new Junction(2);
        asrUp.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[4], 0);
        asrUp.setLine(((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[41], 1);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[44].setNextComp(asrUp);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[44].setNextCompPort(0);

        //bnz
        Junction bnz = new Junction(1);
        bnz.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[5], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[42].setNextComp(bnz);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[42].setNextCompPort(0);

        //jsr
        Junction jsr = new Junction(1);
        jsr.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[6], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[41].setNextComp(jsr);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[41].setNextCompPort(0);

        //jmp
        Junction jmp = new Junction(1);
        jmp.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[7], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[40].setNextComp(jmp);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[40].setNextCompPort(0);

        //jmpind
        Junction jmpind = new Junction(1);
        jmpind.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[8], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[49].setNextComp(jmpind);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[49].setNextCompPort(0);

        //rti
        Junction rti = new Junction(1);
        rti.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[9], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[36].setNextComp(rti);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[36].setNextCompPort(0);

        //rts
        Junction rts = new Junction(1);
        rts.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[10], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[35].setNextComp(rts);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[35].setNextCompPort(0);

        //int
        Junction intUp = new Junction(1);
        intUp.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[11], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[43].setNextComp(intUp);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[43].setNextCompPort(0);

        //push
        Junction push = new Junction(1);
        push.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[12], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[45].setNextComp(push);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[45].setNextCompPort(0);

        //pop
        Junction pop = new Junction(2);
        pop.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[13], 0);
        pop.setLine(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).lines[10], 1);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[81].setNextComp(pop);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[81].setNextCompPort(0);

        //inc
        Junction incUp = new Junction(2);
        incUp.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[14], 0);
        incUp.setLine(((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[3], 1);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[47].setNextComp(incUp);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[47].setNextCompPort(0);

        //dec
        Junction decUp = new Junction(2);
        decUp.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[15], 0);
        decUp.setLine(((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).lines[4], 1);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[48].setNextComp(decUp);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[48].setNextCompPort(0);

        //inte
        Junction inte = new Junction(1);
        inte.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[16], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[37].setNextComp(inte);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[37].setNextCompPort(0);

        //intd
        Junction intd = new Junction(1);
        intd.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[17], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[17].setNextComp(intd);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[17].setNextCompPort(0);

        //trpe
        Junction trpe = new Junction(1);
        trpe.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[18], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[38].setNextComp(trpe);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[38].setNextCompPort(0);

        //trpd
        Junction trpd = new Junction(1);
        trpd.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[19], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[39].setNextComp(trpd);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[39].setNextCompPort(0);

        //regdir
        Junction regdir = new Junction(3);
        regdir.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmadrLines[0], 0);
        regdir.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[33], 1);
        regdir.setLine(((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[8], 2);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[130].setNextComp(regdir);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[130].setNextCompPort(0);

        //indreg
        Junction indreg = new Junction(2);
        indreg.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmadrLines[1], 0);
        indreg.setLine(((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[25], 1);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[131].setNextComp(indreg);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[131].setNextCompPort(0);

        //indregpom
        Junction indregpom = new Junction(2);
        indregpom.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmadrLines[2], 0);
        indregpom.setLine(((CPU_blok_registri_sesti) CPU_blok_registri_sesti).lines[26], 1);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[132].setNextComp(indregpom);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[132].setNextCompPort(0);

        //dirmem
        Junction dirmem = new Junction(1);
        dirmem.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmadrLines[3], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[133].setNextComp(dirmem);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[133].setNextCompPort(0);

        //indmem
        Junction indmem = new Junction(1);
        indmem.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmadrLines[4], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[134].setNextComp(indmem);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[134].setNextCompPort(0);

        //rel
        Junction rel = new Junction(1);
        rel.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmadrLines[5], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[135].setNextComp(rel);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[135].setNextCompPort(0);

        //immed
        Junction immed = new Junction(2);
        immed.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmadrLines[6], 0);
        immed.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[32], 1);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[136].setNextComp(immed);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[136].setNextCompPort(0);

        //l1
        Junction l1 = new Junction(2);
        l1.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[11], 0);
        l1.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[18], 1);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[61].setNextComp(l1);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[61].setNextCompPort(0);

        //l2
        Junction l2 = new Junction(2);
        l2.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[12], 0);
        l2.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[19], 1);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[86].setNextComp(l2);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[86].setNextCompPort(0);

        //l3
        Junction l3 = new Junction(2);
        l3.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[13], 0);
        l3.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[20], 1);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[63].setNextComp(l3);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[63].setNextCompPort(0);

        //l4
        Junction l4 = new Junction(1);
        l4.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[29], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[64].setNextComp(l4);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[64].setNextCompPort(0);

        //l5
        Junction l5 = new Junction(1);
        l5.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[30], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[88].setNextComp(l5);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[88].setNextCompPort(0);

        //PRCOD
        Junction prcod = new Junction(2);
        prcod.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[16], 0);
        prcod.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[23], 1);
        ((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).PRCOD.setNextComp(prcod);
        ((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).PRCOD.setNextCompPort(0);

        //PRADR
        Junction pradr = new Junction(2);
        pradr.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[17], 0);
        pradr.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[24], 1);
        ((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).PRADR.setNextComp(pradr);
        ((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).PRADR.setNextCompPort(0);

        //movd or pop
        Junction movdORpop = new Junction(1);
        movdORpop.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[31], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[69].setNextComp(movdORpop);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[69].setNextCompPort(0);

        //immed or regdir
        Junction immedORregdir = new Junction(1);
        immedORregdir.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[34], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[70].setNextComp(immedORregdir);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[70].setNextCompPort(0);

        //Z
        Junction zUp = new Junction(2);
        zUp.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[14], 0);
        zUp.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[21], 1);
        ((CPU_blok_registri_treci) CPU_blok_registri_treci).pswZ.setNextComp(zUp);
        ((CPU_blok_registri_treci) CPU_blok_registri_treci).pswZ.setNextCompPort(0);

        //prekid
        Junction prekid = new Junction(2);
        prekid.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[15], 0);
        prekid.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[22], 1);
        ((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).PREKID.setNextComp(prekid);
        ((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).PREKID.setNextCompPort(0);

        //cnt upravljacka
        Junction cntUpravljacka = new Junction(1);
        cntUpravljacka.setLine(((CPU_upravljacka_drugi) CPU_upravljacka_drugi).lines[25], 0);
        ((CPU_upravljacka_prvi) CPU_upravljacka_prvi).lines[34].setNextComp(cntUpravljacka);
        ((CPU_upravljacka_prvi) CPU_upravljacka_prvi).lines[34].setNextCompPort(0);

        //op code error
        Junction opCodeError = new Junction(1);
        opCodeError.setLine(((CPU_upravljacka_prvi) CPU_upravljacka_prvi).kmopLines[21], 0);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[129].setNextComp(opCodeError);
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).lines[129].setNextCompPort(0);

    }

    public void setParent(JFrame parent) {
        this.parent = parent;
    }

    public String getPC() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).regPC.getState() & 0xFFFF);
    }

    public String getA() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).regA.getState() & 0xFFFF);
    }

    public String getB() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).regB.getState() & 0xFFFF);
    }

    public String getIR1() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_prvi) CPU_blok_registri_prvi).ir1.getState() & 0xFF);
    }

    public String getIR2() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_prvi) CPU_blok_registri_prvi).ir2.getState() & 0xFF);
    }

    public String getIR3() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_prvi) CPU_blok_registri_prvi).ir3.getState() & 0xFF);
    }

    public String getIR4() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_prvi) CPU_blok_registri_prvi).ir4.getState() & 0xFF);
    }

    public String getMAR() {
        return "0x" + Integer.toHexString(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).mar.getState() & 0xFFFF);
    }

    public String getMBR() {
        return "0x" + Integer.toHexString(((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).mbr.getState() & 0xFF);
    }

    public String getRegX() {
        return "0x" + Integer.toHexString(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).x.getState() & 0xFFFF);
    }

    public String getRegY() {
        return "0x" + Integer.toHexString(((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).y.getState() & 0xFFFF);
    }

    public String getIVTP() {
        return "0x" + Integer.toHexString(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).regIVTP.getState() & 0xFFFF);
    }

    public String getBR() {
        return "0x" + Integer.toHexString(((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).regBR.getState() & 0xFF);
    }

    public String getAX() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_peti) CPU_blok_registri_peti).regAX.getState() & 0xFFFF);
    }

    public String getBX() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_peti) CPU_blok_registri_peti).regBX.getState() & 0xFFFF);
    }

    public String getCX() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_peti) CPU_blok_registri_peti).regCX.getState() & 0xFFFF);
    }

    public String getDX() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_peti) CPU_blok_registri_peti).regDX.getState() & 0xFFFF);
    }

    public String getSI() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_peti) CPU_blok_registri_peti).regSI.getState() & 0xFFFF);
    }

    public String getDI() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_peti) CPU_blok_registri_peti).regDI.getState() & 0xFFFF);
    }

    public String getSP() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_peti) CPU_blok_registri_peti).regSP.getState() & 0xFFFF);
    }

    public String getBP() {
        return "0x" + Integer.toHexString(((CPU_blok_registri_peti) CPU_blok_registri_peti).regBP.getState() & 0xFFFF);
    }

    public String getSBUS() {
        if (((CPU_organizacija_interfejs) CPU_organizacija_interfejs).sbus.getValue() == -1) {
            return "highZ";
        }
        return "0x" + Integer.toHexString(((CPU_organizacija_interfejs) CPU_organizacija_interfejs).sbus.getValue() & 0xFFFF);
    }

    public String getDBUS() {
        if (((CPU_organizacija_interfejs) CPU_organizacija_interfejs).dbus.getValue() == -1) {
            return "highZ";
        }
        return "0x" + Integer.toHexString(((CPU_organizacija_interfejs) CPU_organizacija_interfejs).dbus.getValue() & 0xFFFF);
    }

    public String getSystemABUS() {
        if (((CPU_organizacija_interfejs) CPU_organizacija_interfejs).systemABUS.getValue() == -1) {
            return "highZ";
        }
        return "0x" + Integer.toHexString(((CPU_organizacija_interfejs) CPU_organizacija_interfejs).systemABUS.getValue() & 0xFFFF);
    }

    public String getSystemDBUS() {
        if (((CPU_organizacija_interfejs) CPU_organizacija_interfejs).systemDBUS.getValue() == -1) {
            return "highZ";
        }
        return "0x" + Integer.toHexString(((CPU_organizacija_interfejs) CPU_organizacija_interfejs).systemDBUS.getValue() & 0xFF);
    }

    public String getPSW() {
        return "00000000" + getSecondHalfOfPSW() + getFirstHalfOfPSW();
    }

    private String getFirstHalfOfPSW() {
        String firstHalf = "";

        firstHalf = "" + ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).T.getState()
                + ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).I.getState()
                + ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).L1.getState()
                + ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).L0.getState();

        return firstHalf;
    }

    private String getSecondHalfOfPSW() {
        String secondHalf = "";

        secondHalf = "" + ((CPU_blok_registri_treci) CPU_blok_registri_treci).ffC.getState()
                + ((CPU_blok_registri_treci) CPU_blok_registri_treci).ffV.getState()
                + ((CPU_blok_registri_treci) CPU_blok_registri_treci).ffZ.getState()
                + ((CPU_blok_registri_treci) CPU_blok_registri_treci).ffN.getState();

        return secondHalf;
    }

    public int getT () {
        return ((CPU_upravljacka_prvi)CPU_upravljacka_prvi).getT();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(680, 470));
        setMinimumSize(new java.awt.Dimension(680, 470));
        setPreferredSize(new java.awt.Dimension(680, 470));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        setLayout(new java.awt.CardLayout());
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        Point point = evt.getPoint();

        //System_main
        if (current.equals("System_main")) {
            if (point.x >= 448 && point.x <= 618 && point.y >= 249 && point.y <= 395) {
                current = "CPU_organizacija_main";
                this.changePanel("CPU_organizacija_main");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            if (point.x >= 106 && point.x <= 276 && point.y >= 249 && point.y <= 395) {
                MemoryDialog dialog = ((MainWindow) parent).getMemDialog();
                if (dialog == null) {
                    dialog = new MemoryDialog(null, true, ((MainWindow) parent).getMemory());
                } else {
                    dialog.refreshMemory(((MainWindow) parent).getMemory());
                }
               
                dialog.setVisible(true);
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }
        }

        // CPU main
        if (current.equals("CPU_organizacija_main")) {
            if (point.x >= 135 && point.x <= 230 && point.y >= 117 && point.y <= 200) {
                current = "CPU_organizacija_registri";
                this.changePanel("CPU_organizacija_registri");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            if (point.x >= 315 && point.x <= 400 && point.y >= 117 && point.y <= 200) {
                current = "CPU_organizacija_interfejs";
                this.changePanel("CPU_organizacija_interfejs");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            if (point.x >= 135 && point.x <= 230 && point.y >= 223 && point.y <= 307) {
                current = "CPU_blok_operacije_prvi";
                this.changePanel("CPU_blok_operacije_prvi");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            if (point.x >= 315 && point.x <= 400 && point.y >= 223 && point.y <= 307) {
                current = "CPU_organizacija_prekid";
                this.changePanel("CPU_organizacija_prekid");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            if (point.x >= 120 && point.x <= 430 && point.y >= 345 && point.y <= 380) {
                current = "CPU_upravljacka_drugi";
                this.changePanel("CPU_upravljacka_drugi");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }
        } //interupt
        else if (current.equals("CPU_organizacija_prekid")) {
            if (point.x >= 215 && point.x <= 422 && point.y >= 108 && point.y <= 192) {
                current = "CPU_blok_prekidi_drugi";
                this.changePanel("CPU_blok_prekidi_drugi");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            if (point.x >= 215 && point.x <= 422 && point.y >= 250 && point.y <= 333) {
                current = "CPU_blok_prekidi_prvi";
                this.changePanel("CPU_blok_prekidi_prvi");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

        } //interface
        else if (current.equals("CPU_organizacija_interfejs")) {
            if (point.x >= 176 && point.x <= 403 && point.y >= 116 && point.y <= 201) {
                current = "CPU_blok_interfejs_prvi";
                this.changePanel("CPU_blok_interfejs_prvi");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            if (point.x >= 176 && point.x <= 403 && point.y >= 211 && point.y <= 296) {
                current = "CPU_blok_interfejs_drugi";
                this.changePanel("CPU_blok_interfejs_drugi");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            if (point.x >= 176 && point.x <= 403 && point.y >= 312 && point.y <= 396) {
                current = "CPU_blok_interfejs_treci";
                this.changePanel("CPU_blok_interfejs_treci");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

        } //registers
        else if (current.equals("CPU_organizacija_registri")) {
            if (point.x >= 152 && point.x <= 311 && point.y >= 84 && point.y <= 156) {
                current = "CPU_blok_registri_prvi";
                this.changePanel("CPU_blok_registri_prvi");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            if (point.x >= 152 && point.x <= 263 && point.y >= 197 && point.y <= 273) {
                current = "CPU_blok_registri_peti";
                this.changePanel("CPU_blok_registri_peti");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            if (point.x >= 152 && point.x <= 311 && point.y >= 295 && point.y <= 370) {
                current = "CPU_blok_registri_sesti";
                this.changePanel("CPU_blok_registri_sesti");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            if (point.x >= 264 && point.x <= 311 && point.y >= 197 && point.y <= 273) {
                current = "CPU_blok_registri_sedmi";
                this.changePanel("CPU_blok_registri_sedmi");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            if (point.x >= 332 && point.x <= 492 && point.y >= 84 && point.y <= 156) {
                current = "CPU_blok_registri_cetvri";
                this.changePanel("CPU_blok_registri_cetvri");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            if (point.x >= 341 && point.x <= 499 && point.y >= 197 && point.y <= 270) {
                current = "CPU_blok_registri_drugi";
                this.changePanel("CPU_blok_registri_drugi");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }

            if (point.x >= 341 && point.x <= 499 && point.y >= 295 && point.y <= 367) {
                current = "CPU_blok_registri_treci";
                this.changePanel("CPU_blok_registri_treci");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }
        } //operations
        else if (current.equals("CPU_blok_operacije_prvi")) {
            if (point.x >= 497 && point.x <= 550 && point.y >= 214 && point.y <= 365) {
                current = "CPU_blok_operacije_drugi";
                this.changePanel("CPU_blok_operacije_drugi");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }
        } //upravljacka
        else if (current.equals("CPU_upravljacka_drugi")) {
            if (point.x >= 116 && point.x <= 253 && point.y >= 39 && point.y <= 102) {
                current = "CPU_upravljacka_prvi";
                this.changePanel("CPU_upravljacka_prvi");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }
        }

    }//GEN-LAST:event_formMouseClicked

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        Point point = evt.getPoint();

        // CPU main
        if (current.equals("CPU_organizacija_main")) {
            if (point.x >= 135 && point.x <= 230 && point.y >= 117 && point.y <= 200) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            if (point.x >= 315 && point.x <= 400 && point.y >= 117 && point.y <= 200) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            if (point.x >= 135 && point.x <= 230 && point.y >= 223 && point.y <= 307) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            if (point.x >= 315 && point.x <= 400 && point.y >= 223 && point.y <= 307) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            if (point.x >= 120 && point.x <= 430 && point.y >= 345 && point.y <= 380) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        } //interupt
        else if (current.equals("CPU_organizacija_prekid")) {
            if (point.x >= 215 && point.x <= 422 && point.y >= 108 && point.y <= 192) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            if (point.x >= 215 && point.x <= 422 && point.y >= 250 && point.y <= 333) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        } //interface
        else if (current.equals("CPU_organizacija_interfejs")) {
            if (point.x >= 176 && point.x <= 403 && point.y >= 116 && point.y <= 201) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            if (point.x >= 176 && point.x <= 403 && point.y >= 211 && point.y <= 296) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            if (point.x >= 176 && point.x <= 403 && point.y >= 312 && point.y <= 396) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        } //registers
        else if (current.equals("CPU_organizacija_registri")) {
            if (point.x >= 152 && point.x <= 311 && point.y >= 84 && point.y <= 156) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            if (point.x >= 152 && point.x <= 263 && point.y >= 197 && point.y <= 273) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            if (point.x >= 152 && point.x <= 311 && point.y >= 295 && point.y <= 370) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            if (point.x >= 264 && point.x <= 311 && point.y >= 197 && point.y <= 273) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            if (point.x >= 332 && point.x <= 492 && point.y >= 84 && point.y <= 156) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            if (point.x >= 341 && point.x <= 499 && point.y >= 197 && point.y <= 270) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            if (point.x >= 341 && point.x <= 499 && point.y >= 295 && point.y <= 367) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        } //operations
        else if (current.equals("CPU_blok_operacije_prvi")) {
            if (point.x >= 497 && point.x <= 550 && point.y >= 214 && point.y <= 365) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        } //upravljacka
        else if (current.equals("CPU_upravljacka_drugi")) {
            if (point.x >= 116 && point.x <= 253 && point.y >= 39 && point.y <= 102) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        } //system main
        else if (current.equals("System_main")) {
            if (point.x >= 448 && point.x <= 618 && point.y >= 249 && point.y <= 395) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }

            if (point.x >= 106 && point.x <= 276 && point.y >= 249 && point.y <= 395) {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                return;
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }

    }//GEN-LAST:event_formMouseMoved

    // inits "cards"
    private void initLayout() {
        //organization
        System_main = new System_main(this);
        CPU_organizacija_main = new CPU_organizacija_main(System_main);
        CPU_organizacija_interfejs = new CPU_organizacija_interfejs(CPU_organizacija_main);
        CPU_organizacija_registri = new CPU_organizacija_registri(CPU_organizacija_main);
        CPU_organizacija_prekid = new CPU_organizacija_prekid(CPU_organizacija_main);

        //
        CPU_upravljacka_drugi = new CPU_upravljacka_drugi(CPU_organizacija_main);
        CPU_upravljacka_prvi = new CPU_upravljacka_prvi(CPU_organizacija_main);

        //interface
        CPU_blok_interfejs_drugi = new CPU_blok_interfejs_drugi(CPU_organizacija_interfejs);
        CPU_blok_interfejs_prvi = new CPU_blok_interfejs_prvi(CPU_organizacija_interfejs);
        CPU_blok_interfejs_treci = new CPU_blok_interfejs_treci(CPU_organizacija_interfejs);

        //operation
        CPU_blok_operacije_prvi = new CPU_blok_operacije_prvi(CPU_organizacija_main);
        CPU_blok_operacije_drugi = new CPU_blok_operacije_drugi(CPU_blok_operacije_prvi);

        //interupts
        CPU_blok_prekidi_prvi = new CPU_blok_prekidi_prvi(CPU_organizacija_prekid);
        CPU_blok_prekidi_drugi = new CPU_blok_prekidi_drugi(CPU_organizacija_prekid);

        //registers
        CPU_blok_registri_peti = new CPU_blok_registri_peti(CPU_organizacija_registri);
        CPU_blok_registri_drugi = new CPU_blok_registri_drugi(CPU_organizacija_registri);
        CPU_blok_registri_cetvri = new CPU_blok_registri_cetvri(CPU_organizacija_registri);
        CPU_blok_registri_prvi = new CPU_blok_registri_prvi(CPU_organizacija_registri);
        CPU_blok_registri_sedmi = new CPU_blok_registri_sedmi(CPU_organizacija_registri);
        CPU_blok_registri_sesti = new CPU_blok_registri_sesti(CPU_organizacija_registri);
        CPU_blok_registri_treci = new CPU_blok_registri_treci(CPU_organizacija_registri);

        //add
        add(System_main, "System_main");
        add(CPU_blok_interfejs_drugi, "CPU_blok_interfejs_drugi");
        add(CPU_blok_interfejs_prvi, "CPU_blok_interfejs_prvi");
        add(CPU_blok_interfejs_treci, "CPU_blok_interfejs_treci");
        add(CPU_blok_operacije_drugi, "CPU_blok_operacije_drugi");
        add(CPU_blok_operacije_prvi, "CPU_blok_operacije_prvi");
        add(CPU_blok_registri_peti, "CPU_blok_registri_peti");
        add(CPU_blok_registri_drugi, "CPU_blok_registri_drugi");
        add(CPU_blok_registri_cetvri, "CPU_blok_registri_cetvri");
        add(CPU_blok_prekidi_prvi, "CPU_blok_prekidi_prvi");
        add(CPU_blok_prekidi_drugi, "CPU_blok_prekidi_drugi");
        add(CPU_blok_registri_prvi, "CPU_blok_registri_prvi");
        add(CPU_blok_registri_sedmi, "CPU_blok_registri_sedmi");
        add(CPU_blok_registri_sesti, "CPU_blok_registri_sesti");
        add(CPU_blok_registri_treci, "CPU_blok_registri_treci");
        add(CPU_organizacija_interfejs, "CPU_organizacija_interfejs");
        add(CPU_organizacija_main, "CPU_organizacija_main");
        add(CPU_organizacija_registri, "CPU_organizacija_registri");
        add(CPU_organizacija_prekid, "CPU_organizacija_prekid");
        add(CPU_upravljacka_drugi, "CPU_upravljacka_drugi");
        add(CPU_upravljacka_prvi, "CPU_upravljacka_prvi");

        //add to hashTable
        panels.put("CPU_blok_interfejs_drugi", (PanelsInfo) CPU_blok_interfejs_drugi);
        panels.put("CPU_blok_interfejs_prvi", (PanelsInfo) CPU_blok_interfejs_prvi);
        panels.put("CPU_blok_interfejs_treci", (PanelsInfo) CPU_blok_interfejs_treci);
        panels.put("CPU_blok_operacije_drugi", (PanelsInfo) CPU_blok_operacije_drugi);
        panels.put("CPU_blok_operacije_prvi", (PanelsInfo) CPU_blok_operacije_prvi);
        panels.put("CPU_blok_registri_peti", (PanelsInfo) CPU_blok_registri_peti);
        panels.put("CPU_blok_registri_drugi", (PanelsInfo) CPU_blok_registri_drugi);
        panels.put("CPU_blok_registri_cetvri", (PanelsInfo) CPU_blok_registri_cetvri);
        panels.put("CPU_blok_prekidi_prvi", (PanelsInfo) CPU_blok_prekidi_prvi);
        panels.put("CPU_blok_prekidi_drugi", (PanelsInfo) CPU_blok_prekidi_drugi);
        panels.put("CPU_blok_registri_prvi", (PanelsInfo) CPU_blok_registri_prvi);
        panels.put("CPU_blok_registri_sedmi", (PanelsInfo) CPU_blok_registri_sedmi);
        panels.put("CPU_blok_registri_sesti", (PanelsInfo) CPU_blok_registri_sesti);
        panels.put("CPU_blok_registri_treci", (PanelsInfo) CPU_blok_registri_treci);
        panels.put("CPU_organizacija_interfejs", (PanelsInfo) CPU_organizacija_interfejs);
        panels.put("CPU_organizacija_main", (PanelsInfo) CPU_organizacija_main);
        panels.put("CPU_organizacija_registri", (PanelsInfo) CPU_organizacija_registri);
        panels.put("CPU_organizacija_prekid", (PanelsInfo) CPU_organizacija_prekid);
        panels.put("CPU_upravljacka_drugi", (PanelsInfo) CPU_upravljacka_drugi);
        panels.put("CPU_upravljacka_prvi", (PanelsInfo) CPU_upravljacka_prvi);

        current = "System_main";
        CardLayout card = (CardLayout) getLayout();
        card.show(this, current);

    }

    public void changePanel(String title) {
        CardLayout card = (CardLayout) getLayout();
        card.show(this, title);
        ((MainWindow)parent).refreshTextArea();
    }

    public void up() {
        if (current.equals("System_main")) {
            return;
        }
        PanelsInfo currentPanel = panels.get(current);
        current = currentPanel.getParentTitle();
        changePanel(current);
    }

    public void clk() {

        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).refreshSequential();
        ((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).refreshSequential();
        ((CPU_blok_interfejs_treci) CPU_blok_interfejs_treci).refreshSequential();
        ((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).refreshSequential();
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).refreshSequential();
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).refreshSequential();
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).refreshSequential();
        ((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).refreshSequential();
        ((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).refreshSequential();
        ((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).refreshSequential();
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).refreshSequential();
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).refreshSequential();
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).refreshSequential();
        ((CPU_blok_registri_treci) CPU_blok_registri_treci).refreshSequential();
        ((CPU_organizacija_interfejs) CPU_organizacija_interfejs).refreshSequential();
        ((CPU_organizacija_interfejs) CPU_organizacija_interfejs).refreshSequential();
        ((CPU_organizacija_registri) CPU_organizacija_registri).refreshSequential();
        ((CPU_organizacija_prekid) CPU_organizacija_prekid).refreshSequential();
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).refreshSequential();
        ((CPU_upravljacka_prvi) CPU_upravljacka_prvi).refreshSequential();
        ((System_main) System_main).refreshSequential();

        ((CPU_organizacija_main) CPU_organizacija_main).sbus.clock();
        ((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).sbus.clock();
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).sbus.clock();
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).sbus.clock();
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).sbus.clock();
        ((CPU_blok_registri_treci) CPU_blok_registri_treci).sbus.clock();
        ((CPU_organizacija_interfejs) CPU_organizacija_interfejs).sbus.clock();
        ((CPU_organizacija_prekid) CPU_organizacija_prekid).sbus.clock();
        ((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).sbus.clock();
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).sbus.clock();
        ((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).sbus.clock();
        ((CPU_organizacija_main) CPU_organizacija_main).dbus.clock();
        ((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).dbus.clock();
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).dbus.clock();
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).dbus.clock();
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).dbus.clock();
        ((CPU_organizacija_interfejs) CPU_organizacija_interfejs).dbus.clock();
        ((CPU_organizacija_prekid) CPU_organizacija_prekid).dbus.clock();
        ((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).dbus.clock();
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).dbus.clock();
        ((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).dbus.clock();
        ((CPU_organizacija_main) CPU_organizacija_main).systemDBUS.clock();
        ((CPU_organizacija_interfejs) CPU_organizacija_interfejs).systemDBUS.clock();
        ((System_main) System_main).systemDBUS.clock();
        ((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).systemDBUS.clock();
        ((CPU_organizacija_main) CPU_organizacija_main).systemABUS.clock();
        ((CPU_organizacija_interfejs) CPU_organizacija_interfejs).systemABUS.clock();
        ((System_main) System_main).systemABUS.clock();
        ((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).systemABUS.clock();

        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).clock();
        ((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).clock();
        ((CPU_blok_interfejs_treci) CPU_blok_interfejs_treci).clock();
        ((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).clock();
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).clock();
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).clock();
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).clock();
        ((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).clock();
        ((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).clock();
        ((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).clock();
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).clock();
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).clock();
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).clock();
        ((CPU_blok_registri_treci) CPU_blok_registri_treci).clock();
        ((CPU_organizacija_interfejs) CPU_organizacija_interfejs).clock();
        ((CPU_organizacija_interfejs) CPU_organizacija_interfejs).clock();
        ((CPU_organizacija_registri) CPU_organizacija_registri).clock();
        ((CPU_organizacija_prekid) CPU_organizacija_prekid).clock();
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).clock();
        ((CPU_upravljacka_prvi) CPU_upravljacka_prvi).clock();
        ((System_main) System_main).clock();

        PanelsInfo currentPanel = panels.get(current);
        if (currentPanel != null) {
            currentPanel.repaint();
        }

    }

    public void clear() {

        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).resetHalt();

        ((CPU_upravljacka_prvi) CPU_upravljacka_prvi).clear();
        ((System_main) System_main).clear();
        ((CPU_blok_interfejs_drugi) CPU_blok_interfejs_drugi).clear();
        ((CPU_blok_interfejs_prvi) CPU_blok_interfejs_prvi).clear();
        ((CPU_blok_interfejs_treci) CPU_blok_interfejs_treci).clear();
        ((CPU_blok_operacije_drugi) CPU_blok_operacije_drugi).clear();
        ((CPU_blok_operacije_prvi) CPU_blok_operacije_prvi).clear();
        ((CPU_blok_registri_peti) CPU_blok_registri_peti).clear();
        ((CPU_blok_registri_drugi) CPU_blok_registri_drugi).clear();
        ((CPU_blok_registri_cetvri) CPU_blok_registri_cetvri).clear();
        ((CPU_blok_prekidi_prvi) CPU_blok_prekidi_prvi).clear();
        ((CPU_blok_prekidi_drugi) CPU_blok_prekidi_drugi).clear();
        ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).clear();
        ((CPU_blok_registri_sedmi) CPU_blok_registri_sedmi).clear();
        ((CPU_blok_registri_sesti) CPU_blok_registri_sesti).clear();
        ((CPU_blok_registri_treci) CPU_blok_registri_treci).clear();
        ((CPU_organizacija_interfejs) CPU_organizacija_interfejs).clear();
        ((CPU_organizacija_interfejs) CPU_organizacija_interfejs).clear();
        ((CPU_organizacija_registri) CPU_organizacija_registri).clear();
        ((CPU_organizacija_prekid) CPU_organizacija_prekid).clear();
        ((CPU_upravljacka_drugi) CPU_upravljacka_drugi).clear();
        ((CPU_upravljacka_prvi) CPU_upravljacka_prvi).clear();

        clk();

    }

    public String getOperation() {
        return ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).currentOp;
    }

    public String getWayOfAddressing() {
        return ((CPU_blok_registri_prvi) CPU_blok_registri_prvi).currentAdr;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
