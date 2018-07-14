/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CPU_blok_registri_prvi.java
 *
 * Created on 22.09.2010., 10.23.27
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
import rs.etf.aor.components.MoreToOne;
import rs.etf.aor.components.Nor;
import rs.etf.aor.components.Or;
import rs.etf.aor.components.Register;
import rs.etf.aor.components.Selector;
import rs.etf.aor.components.SignExtension;
import rs.etf.aor.components.TripleStateBuffer;

/**
 *
 * @author MB
 */
public class CPU_blok_registri_prvi extends javax.swing.JPanel implements PanelsInfo{

    private JPanel parent;
    private String parentTitle = "CPU_organizacija_registri";

    //components
    Register ir1, ir2, ir3, ir4;
    private TripleStateBuffer buff1, buff2, buff3, buff4;
    private Selector sel1, sel2, sel3, sel4, sel5, sel6, sel7,
            sel8, sel9;
    private Or or1, or2, or3;
    private And and1, and2;
    private Invertor inv1, inv2;
    private Nor nor2;

    String currentOp, currentAdr;

    //lines
    Line lines[];
    
    //dots
    private Junction dot1, dot2, dot3, dot4, dot5, dot6, dot7,
            dot8, dot9;

    //bus
    Bus sbus, dbus;

    private SignExtension[] signExtension;
    private MoreToOne[] moreToOne;
    

    /** Creates new form CPU_blok_registri_prvi */
    public CPU_blok_registri_prvi(JPanel parent) {
        this.parent = parent;
        initComponents();
        initPictureComponents();
        initLines();
        initBus();
        connectComponents();

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/etf/aor/images/CPU_blok_registri_prvi.jpg"))); // NOI18N

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

    private void initLines() {
        lines = new Line[146];
        for(int i = 0; i<lines.length; i++){
            lines[i] = new Line(null, 0, 0, 1);
        }

        //ldir1
        lines[0].addPoint(new Point(82, 382));
        lines[0].addPoint(new Point(82, 370));

        //ldir2
        lines[1].addPoint(new Point(161, 382));
        lines[1].addPoint(new Point(161, 370));

        //ldir3
        lines[2].addPoint(new Point(293, 382));
        lines[2].addPoint(new Point(293, 370));

        //ldir4
        lines[3].addPoint(new Point(437, 382));
        lines[3].addPoint(new Point(437, 370));

        //ir3out
        lines[4].addPoint(new Point(367, 143));
        lines[4].addPoint(new Point(377, 143));

        //ir2out
        lines[5].addPoint(new Point(204, 169));
        lines[5].addPoint(new Point(214, 169));

        //irjaout
        lines[6].addPoint(new Point(282, 139));
        lines[6].addPoint(new Point(292, 139));

        //irdaout
        lines[7].addPoint(new Point(438, 140));
        lines[7].addPoint(new Point(448, 140));

        //ir31
        lines[8].addPoint(new Point(538, 185));
        lines[8].addPoint(new Point(558, 185));

        //ir0
        lines[9].addPoint(new Point(538, 223));
        lines[9].addPoint(new Point(558, 223));

        //movd
        lines[10].addPoint(new Point(606, 139));
        lines[10].addPoint(new Point(624, 139));

        //intd
        lines[11].addPoint(new Point(606, 184));
        lines[11].addPoint(new Point(624, 184));

        //regind
        lines[12].addPoint(new Point(606, 207));
        lines[12].addPoint(new Point(624, 207));

        //immed
        lines[13].addPoint(new Point(606, 260));
        lines[13].addPoint(new Point(624, 260));

        //ir31>
        lines[14].addPoint(new Point(549, 181));
        lines[14].addPoint(new Point(554, 185));
        lines[14].addPoint(new Point(549, 189));

        //ir0>
        lines[15].addPoint(new Point(549, 219));
        lines[15].addPoint(new Point(554, 223));
        lines[15].addPoint(new Point(549, 227));

        //movd>
        lines[16].addPoint(new Point(618, 136));
        lines[16].addPoint(new Point(621, 139));
        lines[16].addPoint(new Point(618, 142));

        //intd>
        lines[17].addPoint(new Point(618, 181));
        lines[17].addPoint(new Point(621, 184));
        lines[17].addPoint(new Point(618, 187));

        //regind>
        lines[18].addPoint(new Point(618, 204));
        lines[18].addPoint(new Point(621, 207));
        lines[18].addPoint(new Point(618, 210));

        //immed>
        lines[19].addPoint(new Point(618, 257));
        lines[19].addPoint(new Point(621, 260));
        lines[19].addPoint(new Point(618, 263));

        //ir3 out GLOBAL
        lines[20].addPoint(new Point(313, 294));
        lines[20].addPoint(new Point(332, 294));
        lines[20].setThikness(8);

        //ir3_15
        lines[21].addPoint(new Point(373, 242));
        lines[21].addPoint(new Point(373, 220));

        //ir2 out to dot7
        lines[22].addPoint(new Point(180, 294));
        lines[22].addPoint(new Point(187, 294));
        lines[22].setThikness(8);

        //ir2_15
        lines[23].addPoint(new Point(206, 245));
        lines[23].addPoint(new Point(206, 208));

        //ir2_1 from dot7
        lines[24].addPoint(new Point(187, 294));
        lines[24].addPoint(new Point(187, 209));
        lines[24].setThikness(8);

        //ir2_2 from dot7
        lines[25].addPoint(new Point(187, 294));
        lines[25].addPoint(new Point(226, 294));
        lines[25].addPoint(new Point(226, 188));
        lines[25].setThikness(8);

        //ir3 out from dot8
        lines[26].addPoint(new Point(331, 294));
        lines[26].addPoint(new Point(331, 188));
        lines[26].setThikness(8);

        //ir4 out
        lines[27].addPoint(new Point(456, 294));
        lines[27].addPoint(new Point(475, 294));
        lines[27].addPoint(new Point(475, 178));
        lines[27].setThikness(8);

        //ir3 out all
        lines[28].addPoint(new Point(362, 206));
        lines[28].addPoint(new Point(362, 155));
        lines[28].setThikness(16);

        //ir2 out all
        lines[29].addPoint(new Point(200, 194));
        lines[29].addPoint(new Point(200, 181));
        lines[29].setThikness(16);

        //irja out all
        lines[30].addPoint(new Point(278, 172));
        lines[30].addPoint(new Point(278, 152));
        lines[30].setThikness(16);

        //irda out all
        lines[31].addPoint(new Point(434, 165));
        lines[31].addPoint(new Point(434, 154));
        lines[31].setThikness(16);

        //ir3 out from dot8
        lines[32].addPoint(new Point(331, 294));
        lines[32].addPoint(new Point(358, 294));
        lines[32].setThikness(8);

        //ir3 out from dot9
        lines[33].addPoint(new Point(358, 294));
        lines[33].addPoint(new Point(358, 219));
        lines[33].setThikness(8);

        //ir3 out from dot9
        lines[34].addPoint(new Point(358, 294));
        lines[34].addPoint(new Point(385, 294));
        lines[34].addPoint(new Point(385, 181));
        lines[34].setThikness(8);

        //rts
        lines[35].addPoint(new Point(643, 155));
        lines[35].addPoint(new Point(643, 155));

        //rti
        lines[36].addPoint(new Point(643, 155));
        lines[36].addPoint(new Point(643, 155));

        //inte
        lines[37].addPoint(new Point(643, 155));
        lines[37].addPoint(new Point(643, 155));

        //trpe
        lines[38].addPoint(new Point(643, 155));
        lines[38].addPoint(new Point(643, 155));

        //trpd
        lines[39].addPoint(new Point(643, 155));
        lines[39].addPoint(new Point(643, 155));

        //jmp
        lines[40].addPoint(new Point(643, 155));
        lines[40].addPoint(new Point(643, 155));

        //jsr
        lines[41].addPoint(new Point(643, 155));
        lines[41].addPoint(new Point(643, 155));

        //bnz
        lines[42].addPoint(new Point(643, 155));
        lines[42].addPoint(new Point(643, 155));

        //int
        lines[43].addPoint(new Point(643, 155));
        lines[43].addPoint(new Point(643, 155));

        //asr
        lines[44].addPoint(new Point(643, 155));
        lines[44].addPoint(new Point(643, 155));

        //push
        lines[45].addPoint(new Point(643, 155));
        lines[45].addPoint(new Point(643, 155));

        //pop
        lines[46].addPoint(new Point(643, 155));
        lines[46].addPoint(new Point(643, 155));

        //inc
        lines[47].addPoint(new Point(643, 155));
        lines[47].addPoint(new Point(643, 155));

        //dec
        lines[48].addPoint(new Point(643, 155));
        lines[48].addPoint(new Point(643, 155));

        //jmpind
        lines[49].addPoint(new Point(643, 155));
        lines[49].addPoint(new Point(643, 155));

        //movs
        lines[50].addPoint(new Point(643, 155));
        lines[50].addPoint(new Point(643, 155));

        //add
        lines[51].addPoint(new Point(643, 155));
        lines[51].addPoint(new Point(643, 155));

        //and
        lines[52].addPoint(new Point(643, 155));
        lines[52].addPoint(new Point(643, 155));

        //halt
        lines[53].addPoint(new Point(643, 155));
        lines[53].addPoint(new Point(643, 155));

        //regdir
        lines[54].addPoint(new Point(643, 227));
        lines[54].addPoint(new Point(643, 227));

        //regindpom
        lines[55].addPoint(new Point(643, 227));
        lines[55].addPoint(new Point(643, 227));

        //memdir
        lines[56].addPoint(new Point(643, 227));
        lines[56].addPoint(new Point(643, 227));

        //memind
        lines[57].addPoint(new Point(643, 227));
        lines[57].addPoint(new Point(643, 227));

        //rel
        lines[58].addPoint(new Point(643, 227));
        lines[58].addPoint(new Point(643, 227));

        //ir2_2..0
        lines[59].addPoint(new Point(643, 227));
        lines[59].addPoint(new Point(643, 227));

        //ir2_5..3
        lines[60].addPoint(new Point(643, 227));
        lines[60].addPoint(new Point(643, 227));

        //ir1_7
        lines[61].addPoint(new Point(643, 227));
        lines[61].addPoint(new Point(643, 227));

        //ir1_6
        lines[62].addPoint(new Point(643, 227));
        lines[62].addPoint(new Point(643, 227));

        //ir1_5
        lines[63].addPoint(new Point(643, 227));
        lines[63].addPoint(new Point(643, 227));

        //ir2_7
        lines[64].addPoint(new Point(643, 227));
        lines[64].addPoint(new Point(643, 227));

        //ir2_6
        lines[65].addPoint(new Point(643, 227));
        lines[65].addPoint(new Point(643, 227));

        //ir2_1
        lines[66].addPoint(new Point(643, 227));
        lines[66].addPoint(new Point(643, 227));

        //ir2_0
        lines[67].addPoint(new Point(643, 227));
        lines[67].addPoint(new Point(643, 227));
        
        //ir1out
        lines[68].addPoint(new Point(643, 227));
        lines[68].addPoint(new Point(643, 227));

        //IR2 = lines[77] (ne iscrtava se)

        //movd_pop
        lines[69].addPoint(new Point(643, 227));
        lines[69].addPoint(new Point(643, 227));

        //regdir_immed
        lines[70].addPoint(new Point(643, 227));
        lines[70].addPoint(new Point(643, 227));

    }

    private void initPictureComponents() {
        ir1 = new Register(0xFF);
        ir2 = new Register(0);
        ir3 = new Register(0);
        ir4 = new Register(0);

        buff1 = new TripleStateBuffer();//ir3
        buff2 = new TripleStateBuffer();
        buff3 = new TripleStateBuffer();
        buff4 = new TripleStateBuffer();

        dot1 = new Junction(1);
        dot2 = new Junction(1);
        dot3 = new Junction(1);
        dot4 = new Junction(1);
        dot5 = new Junction(1);
        dot6 = new Junction(1);
        dot7 = new Junction(3);//ir2
        dot8 = new Junction(2);//ir3
        dot9 = new Junction(2);//ir3

        nor2 = new Nor(10);//adr

        signExtension = new SignExtension[2];
        moreToOne = new MoreToOne[4];

        for (int i=0; i<signExtension.length; i++) {
            signExtension[i] = new SignExtension(8);
        }

        for (int i=0; i<moreToOne.length; i++) {
            moreToOne[i] = new MoreToOne(2);
        }

        sel1 = new Selector(0, 2);//ir2
        sel2 = new Selector(3, 5);//ir2
        sel3 = new Selector(7);//ir1
        sel4 = new Selector(6);//ir1
        sel5 = new Selector(5);//ir1
        sel6 = new Selector(7);//ir2
        sel7 = new Selector(6);//ir2
        sel8 = new Selector(1);//ir2
        sel9 = new Selector(0);//ir2

        or1 = new Or(2);//movd or pop
        or2 = new Or(2);//imm or regdir
        or3 = new Or(2);//l5

        and1 = new And(2);//l5
        and2 = new And(2);//l5

        inv1 = new Invertor();
        inv2 = new Invertor();
    }

    private void initBus() {

        sbus = new Bus(16);
        dbus = new Bus(16);

        sbus.addPoint(new Point(22, 71));
        sbus.addPoint(new Point(483, 71));
        sbus.addPoint(new Point(200, 71));
        sbus.addPoint(new Point(200, 159));
        sbus.addPoint(new Point(279, 71));
        sbus.addPoint(new Point(279, 130));
        sbus.addPoint(new Point(362, 71));
        sbus.addPoint(new Point(362, 132));
        sbus.addPoint(new Point(434, 71));
        sbus.addPoint(new Point(434, 130));

        dbus.addPoint(new Point(22, 105));
        dbus.addPoint(new Point(483, 105));

        dbus.addPoint(new Point(45, 105));
        dbus.addPoint(new Point(45, 294));
        dbus.addPoint(new Point(45, 294));
        dbus.addPoint(new Point(64, 294));

        dbus.addPoint(new Point(124, 105));
        dbus.addPoint(new Point(124, 294));
        dbus.addPoint(new Point(124, 294));
        dbus.addPoint(new Point(143, 294));

        dbus.addPoint(new Point(256, 105));
        dbus.addPoint(new Point(256, 294));
        dbus.addPoint(new Point(256, 294));
        dbus.addPoint(new Point(274, 294));

        dbus.addPoint(new Point(400, 105));
        dbus.addPoint(new Point(400, 294));
        dbus.addPoint(new Point(400, 294));
        dbus.addPoint(new Point(418, 294));

        sbus.addTextPoint(new Point(67, 67));
        dbus.addTextPoint(new Point(67, 100));

    }

    private void connectComponents() {
        lines[0].setNextComp(ir1);
        lines[0].setNextCompPort(1);
        lines[1].setNextComp(ir2);
        lines[1].setNextCompPort(1);
        lines[2].setNextComp(ir3);
        lines[2].setNextCompPort(1);
        lines[3].setNextComp(ir4);
        lines[3].setNextCompPort(1);

        lines[4].setNextComp(buff1);
        lines[4].setNextCompPort(1);
        lines[5].setNextComp(buff2);
        lines[5].setNextCompPort(1);
        lines[6].setNextComp(buff3);
        lines[6].setNextCompPort(1);
        lines[7].setNextComp(buff4);
        lines[7].setNextCompPort(1);

        ir1.setLine(lines[8], 2);
        ir4.setLine(lines[9], 2);

        lines[8].setNextComp(dot1);
        lines[9].setNextComp(dot2);
        lines[10].setNextComp(dot3);
        lines[11].setNextComp(dot4);
        lines[12].setNextComp(dot5);
        lines[13].setNextComp(dot6);

        dot1.setLine(lines[14], 0);
        dot2.setLine(lines[15], 0);
        dot3.setLine(lines[16], 0);
        dot4.setLine(lines[17], 0);
        dot5.setLine(lines[18], 0);
        dot6.setLine(lines[19], 0);

        ir3.setLine(lines[20], 0);
        ir3.setLine(lines[21], 3);

        ir2.setLine(lines[22], 0);
        ir2.setLine(lines[23], 3);
        lines[22].setNextComp(dot7);
        dot7.setLine(lines[24], 0);
        dot7.setLine(lines[25], 1);
        //!!!!!!!!!!!!!!!!!!!!!!!!
        dot7.setLine(lines[77], 2);

        ir4.setLine(lines[27], 0);

        lines[28].setNextComp(buff1);
        lines[28].setNextCompPort(0);
        lines[29].setNextComp(buff2);
        lines[29].setNextCompPort(0);
        lines[30].setNextComp(buff3);
        lines[30].setNextCompPort(0);
        lines[31].setNextComp(buff4);
        lines[31].setNextCompPort(0);

        lines[20].setNextComp(dot8);

        dot8.setLine(lines[26], 0);
        dot8.setLine(lines[32], 1);

        lines[32].setNextComp(dot9);

        dot9.setLine(lines[33], 0);
        dot9.setLine(lines[34], 1);

        //sign extension of IR3
        lines[21].setNextComp(signExtension[0]);
        lines[21].setNextCompPort(0);

        //sign extension of IR2
        lines[23].setNextComp(signExtension[1]);
        lines[23].setNextCompPort(0);


        Line temp;

        //merging IR3 and sign of IR3
        lines[33].setNextComp(moreToOne[0]);
        lines[33].setNextCompPort(0);
        temp = new Line(moreToOne[0], 1, 0, 8);
        signExtension[0].setLine(temp, 0);
        moreToOne[0].setLine(lines[28], 0);

        //merging IR2 and sign of IR2
        lines[24].setNextComp(moreToOne[1]);
        lines[24].setNextCompPort(0);
        temp = new Line(moreToOne[1], 1, 0, 8);
        signExtension[1].setLine(temp, 0);
        moreToOne[1].setLine(lines[29], 0);

        //merging IR2 and IR3 (IR_JA)
        lines[25].setNextComp(moreToOne[2]);
        lines[25].setNextCompPort(1);
        lines[26].setNextComp(moreToOne[2]);
        lines[26].setNextCompPort(0);
        moreToOne[2].setLine(lines[30], 0);

        //merging IR3 and IR4 (IR_DA)
        lines[34].setNextComp(moreToOne[3]);
        lines[34].setNextCompPort(1);
        lines[27].setNextComp(moreToOne[3]);
        lines[27].setNextCompPort(0);
        moreToOne[3].setLine(lines[31], 0);

       
        //IR1 select
        ir1.setLine(lines[68], 0);
        Junction tempJun = new Junction(3);
        Line[] tempLines = new Line[3];
        for (int i=0; i<tempLines.length; i++) {
            tempLines[i] = new Line(null, 0, 0, 1);
        }

        lines[68].setNextComp(tempJun);
        tempJun.setLine(tempLines[0], 0);
        tempJun.setLine(tempLines[1], 1);
        tempJun.setLine(tempLines[2], 2);
        tempLines[0].setNextComp(sel3);
        tempLines[1].setNextComp(sel4);
        tempLines[2].setNextComp(sel5);
        sel3.setLine(lines[61], 0);
        sel4.setLine(lines[62], 0);
        sel5.setLine(lines[63], 0);

        //IR2 select
        tempLines = new Line[7];
        tempJun = new Junction(7);
        for (int i=0; i<tempLines.length; i++) {
            tempLines[i] = new Line(null, 0, 0, 1);
        }

        lines[22].setNextComp(tempJun);
        tempJun.setLine(tempLines[0], 0);
        tempJun.setLine(tempLines[1], 1);
        tempJun.setLine(tempLines[2], 2);
        tempJun.setLine(tempLines[3], 3);
        tempJun.setLine(tempLines[4], 4);
        tempJun.setLine(tempLines[5], 5);
        tempJun.setLine(tempLines[6], 6);
        tempLines[0].setNextComp(sel1);
        tempLines[1].setNextComp(sel2);
        tempLines[2].setNextComp(sel6);
        tempLines[3].setNextComp(sel7);
        tempLines[4].setNextComp(sel8);
        tempLines[5].setNextComp(sel9);
        tempLines[6].setNextComp(dot7);
        sel1.setLine(lines[59], 0);
        sel2.setLine(lines[60], 0);
        sel6.setLine(lines[64], 0);
        sel7.setLine(lines[65], 0);
        sel8.setLine(lines[66], 0);
        sel9.setLine(lines[67], 0);

        //movd or pop
        Junction movdJun = new Junction(2);
        lines[16].setNextComp(movdJun);
        lines[16].setNextCompPort(0);
        movdJun.setLine(lines[78], 0);
        movdJun.setLine(lines[79], 1);
        lines[78].setNextComp(or1);
        lines[78].setNextCompPort(0);
        Junction popJun = new Junction(2);
        lines[46].setNextComp(popJun);
        lines[46].setNextCompPort(0);
        popJun.setLine(lines[80], 0);
        popJun.setLine(lines[81], 1);
        lines[80].setNextComp(or1);
        lines[80].setNextCompPort(1);
        or1.setLine(lines[69], 0);

        //regdir or immed
        Junction regdirJun = new Junction(2);
        lines[54].setNextComp(regdirJun);
        lines[54].setNextCompPort(0);
        regdirJun.setLine(lines[82], 0);
        regdirJun.setLine(lines[83], 1);
        lines[82].setNextComp(or2);
        lines[82].setNextCompPort(0);
        Junction immedJun = new Junction(2);
        lines[19].setNextComp(immedJun);
        lines[19].setNextCompPort(0);
        immedJun.setLine(lines[84], 0);
        immedJun.setLine(lines[85], 1);
        lines[84].setNextComp(or2);
        lines[84].setNextCompPort(1);
        or2.setLine(lines[70], 0);

        //l5 = !ir2_6 || ir2_6 && (ir2_1 && !ir2_0)
        
        lines[67].setNextComp(inv1);
        inv1.setLine(lines[71], 0);
        lines[71].setNextComp(and1);
        lines[71].setNextCompPort(0);
        lines[66].setNextComp(and1);
        lines[66].setNextCompPort(1);
        and1.setLine(lines[72], 0);
        lines[72].setNextComp(and2);
        lines[72].setNextCompPort(0);

        Junction jun65 = new Junction(2);
        lines[65].setNextComp(jun65);
        jun65.setLine(lines[73], 0);
        jun65.setLine(lines[74], 1);

        lines[73].setNextComp(and2);
        lines[73].setNextCompPort(1);
        lines[74].setNextComp(inv2);
        inv2.setLine(lines[75], 0);

        and2.setLine(lines[76], 0);
        lines[75].setNextComp(or3);
        lines[75].setNextCompPort(0);
        lines[76].setNextComp(or3);
        lines[76].setNextCompPort(1);
        or3.setLine(lines[88], 0);

        //l5 = lines[88]
        
        Invertor invTemp = new Invertor();
        lines[62].setNextComp(invTemp);
        lines[62].setNextCompPort(0);
        invTemp.setLine(lines[86], 0);

        dbus.addNextComponent(ir1, 0);
        dbus.addNextComponent(ir2, 0);
        dbus.addNextComponent(ir3, 0);
        dbus.addNextComponent(ir4, 0);

        buff1.setLine(sbus, 0);
        buff2.setLine(sbus, 0);
        buff3.setLine(sbus, 0);
        buff4.setLine(sbus, 0);


        //if no address way is selected
        //generate errADR
        Junction adrDots[] = new Junction[7];
        for (int i = 0; i < adrDots.length; i++) {
            adrDots[i] = new Junction(2);
        }

        lines[83].setNextComp(adrDots[0]);
        lines[18].setNextComp(adrDots[1]);
        lines[55].setNextComp(adrDots[2]);
        lines[56].setNextComp(adrDots[3]);
        lines[57].setNextComp(adrDots[4]);
        lines[58].setNextComp(adrDots[5]);
        lines[85].setNextComp(adrDots[6]);

        for (int i = 0; i < adrDots.length; i++) {
            adrDots[i].setLine(lines[130 + i], 0);
            adrDots[i].setLine(lines[130 + adrDots.length +i], 1);
        }

        for (int i=0; i<adrDots.length; i++) {
            lines[130 + adrDots.length + i].setNextComp(nor2);
            lines[130 + adrDots.length + i].setNextCompPort(i);
        }

        //err in adr type
        nor2.setLine(lines[145], 0);
    }

    public void refreshSequential() {
        ir1.refreshSequential();
        ir2.refreshSequential();
        ir3.refreshSequential();
        ir4.refreshSequential();
    }

    public void clear() {
        ir1.setState(0xFF);
        ir2.setState(0);
        ir3.setState(0);
        ir4.setState(0);
        lines[53].refreshValue(0);
        if (previousOp != null) {
            previousOp.refreshValue(0);
        }
        if (previousAdr != null) {
            previousAdr.refreshValue(0);
        }
    }

    private Line currentOpLine, previousOp, currentAdrLine, previousAdr;

    public void clock() {
        ir1.clock();
        ir2.clock();
        ir3.clock();
        ir4.clock();

        currentOpLine = calculateOpCode();
        if (previousOp != null) {
            previousOp.refreshValue(0);
        }

        previousOp = currentOpLine;
        if (currentOpLine != null) {
            currentOpLine.refreshValue(1);
        }

        currentAdrLine = calculateWayOfAddressing();
        if (previousAdr != null) {
            previousAdr.refreshValue(0);
        }
        previousAdr = currentAdrLine;
        if (currentAdrLine != null) {
            currentAdrLine.refreshValue(1);
        }

    }

/*
    private Line calculateOpCode() {
        byte ir1Byte, ir2Byte;
        ir1Byte = (byte)(ir1.getState()& 0x000000FF);
        ir2Byte = (byte)(ir2.getState() & 0x000000FF);

        if (ir1Byte == 0x01) {
            return lines[35];
        }
        if (ir1Byte == 0x02) {
            return lines[36];
        }
        if (ir1Byte == 0x04) {
            return lines[37];
        }
        if (ir1Byte == 0x08) {
            return lines[11];
        }


        if (ir1Byte == 0x10) {
            return lines[38];
        }

        if (ir1Byte == 0x20) {
            return lines[39];
        }

        if (ir1Byte == 0x40) {
            return lines[40];
        }

        if (ir1Byte == 0x5F) {
            return lines[41];
        }

        if (ir1Byte == 0x60) {
            return lines[42];
        }

        if (ir1Byte == 0x7F) {
            return lines[43];
        }

        if (ir1Byte == (byte) 0x80 && (ir2Byte & 0x38) == 0x00) {
            return lines[44];
        }

        if (ir1Byte == (byte) 0xFF) {
            if ((ir2Byte & 0x38) == 0x00) {
                return lines[45];
            }
            if ((ir2Byte & 0x38) == 0x08) {
                return lines[46];
            }
            if ((ir2Byte & 0x38) == 0x10) {
                return lines[47];
            }
            if ((ir2Byte & 0x38) == 0x18) {
                return lines[48];
            }
            if ((ir2Byte & 0x38) == 0x20) {
                return lines[49];
            }
        }

        if (ir1Byte == (byte) 0x81) {
            return lines[50];
        }
        if (ir1Byte == (byte) 0x82) {
            return lines[10];
        }
        if (ir1Byte == (byte) 0x84) {
            return lines[51];
        }
        if (ir1Byte == (byte) 0x88) {
            return lines[52];
        }
/*
        if (ir1Byte == 0x00) {
            return lines[53];
        }

        //badop
        return null;
    }

*/

    private Line calculateOpCode() {
        byte ir1Byte, ir2Byte;
        ir1Byte = (byte)(ir1.getState()& 0x000000FF);
        ir2Byte = (byte)(ir2.getState() & 0x000000FF);

        // rts
        if (ir1Byte == 0x01) {
            currentOp = "RTS";
            return lines[35];
        }
        // rti
        if (ir1Byte == 0x02) {
            currentOp = "RTI";
            return lines[36];
        }
        // inte
        if (ir1Byte == 0x04) {
            currentOp = "INTE";
            return lines[37];
        }
        // intd
        if (ir1Byte == 0x08) {
            currentOp = "INTD";
            return lines[17];
        }

        //tpre
        if (ir1Byte == 0x10) {
            currentOp = "TRPE";
            return lines[38];
        }
        // trpd

        if (ir1Byte == 0x20) {
            currentOp = "TRPD";
            return lines[39];
        }

        // jmp
        if (ir1Byte == 0x40) {
            currentOp = "JMP";
            return lines[40];
        }

        // jsr
        if (ir1Byte == 0x5F) {
            currentOp = "JSR";
            return lines[41];
        }

        // bnz
        if (ir1Byte == 0x60) {
            currentOp = "BNZ";
            return lines[42];
        }
        // int

        if (ir1Byte == 0x7F) {
            currentOp = "INT";
            return lines[43];
        }
        // asr

        if (ir1Byte == (byte) 0x80 && (ir2Byte & 0x38) == 0x00) {
            currentOp = "ASR";
            return lines[44];
        }


        if (ir1Byte == (byte) 0xFF) {
            //push
            if ((ir2Byte & 0x38) == 0x00) {
                currentOp = "PUSH";
                return lines[45];
            }
            // pop
            if ((ir2Byte & 0x38) == 0x08) {
                currentOp = "POP";
                return lines[81];
            }
            // inc
            if ((ir2Byte & 0x38) == 0x10) {
                currentOp = "INC";
                return lines[47];
            }
            // dec
            if ((ir2Byte & 0x38) == 0x18) {
                currentOp = "DEC";
                return lines[48];
            }
            // jmpind
            if ((ir2Byte & 0x38) == 0x20) {
                currentOp = "JMPIND";
                return lines[49];
            }
        }

        // movs
        if (ir1Byte == (byte) 0x81) {
            currentOp = "MOVS";
            return lines[50];
        }
        // movd
        if (ir1Byte == (byte) 0x82) {
            currentOp = "MOVD";
            return lines[79];
        }
        // add
        if (ir1Byte == (byte) 0x84) {
            currentOp = "ADD";
            return lines[51];
        }
        // and
        if (ir1Byte == (byte) 0x88) {
            currentOp = "AND";
            return lines[52];
        }

        if (ir1Byte == 0x00) {
            currentOp = "HALT";
            return lines[53];
        }

        //badop
        currentOp = "Bad op code";
        return lines[129];
    }

    public Line calculateWayOfAddressing(){
        byte ir2Byte;
        ir2Byte = (byte) (ir2.getState() & 0x000000FF);

        if((ir2Byte & (byte) 0xC0) == 0x00){
            currentAdr = "Register direct";
            return lines[54];
        }

        if((ir2Byte & (byte) 0xC0) == 0x40){
            currentAdr = "Register indirect";
            return lines[12];
        }

        if((ir2Byte & (byte) 0xC0) == (byte)0x80){
            currentAdr = "Register indirect with offset";
            return lines[55];
        }

        if((ir2Byte & (byte) 0xC0) == (byte)0xC0){
            if((ir2Byte & 0x03) == 0x00){
                currentAdr = "Memory direct";
                return lines[56];
            }
            if((ir2Byte & 0x03) == 0x01){
                currentAdr = "Memory indirect";
                return lines[57];
            }
            if((ir2Byte & 0x03) == 0x02){
                currentAdr = "PC relative";
                return lines[58];
            }
            if((ir2Byte & 0x03) == 0x03){
                currentAdr = "Immidiate";
                return lines[13];
            }
        }

        //bad way of addressing
        return null;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < lines.length; i++) {
            lines[i].paint(g);
        }
        sbus.paint(g);
        dbus.paint(g);
    }

}