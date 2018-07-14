/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CPU_blok_interfejs_drugi.java
 *
 * Created on 22.09.2010., 10.11.04
 */

package rs.etf.aor.gui;

import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;
import rs.etf.aor.components.*;

/**
 *
 * @author MB
 */
public class CPU_blok_interfejs_drugi extends javax.swing.JPanel implements PanelsInfo{

    private JPanel parent;
    private String parentTitle = "CPU_organizacija_interfejs";

    //components
    private DFlipFlop dff1, dff2;
    private SRFlipFlop srff1;
    private Counter cnt;
    private And and1, and2, and3, and4, and5;
    private Or or1, or2, or3, or4, or5;
    private Nor nor2;
    private InvertedTripleStateBuffer ibuff1, ibuff2;
    private Invertor inv1, inv2;
    private NorForCounter nor;

    //lines
    public Line lines[];

    //dots
    private Junction dot1, dot2, dot3, dot4, dot5, dot6, dot7;
    
    //bus


    /** Creates new form CPU_blok_interfejs_drugi */
    public CPU_blok_interfejs_drugi(JPanel parent) {
        this.parent = parent;
        initComponents();
        initPictureComponents();
        initLines();
        connectComponents();
    }

    public boolean getHalt() {
        return srff1.getState() == 1;
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/etf/aor/images/CPU_blok_interfejs_drugi.jpg"))); // NOI18N

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
        lines = new Line[50];
        for(int i = 0; i<lines.length; i++){
            lines[i] = new Line(null, 0, 0, 1);
        }

        //GLOBAL read
        lines[0].addPoint(new Point(86, 74));
        lines[0].addPoint(new Point(95, 74));

        //GLOBAL rd from dff
        lines[1].addPoint(new Point(161, 74));
        lines[1].addPoint(new Point(200, 74));

        //READBUS
        lines[2].addPoint(new Point(261, 74));
        lines[2].addPoint(new Point(297, 74));

        //rd on and1 entry
        lines[3].addPoint(new Point(206, 149));
        lines[3].addPoint(new Point(214, 149));

        //GLOBAL busHold on and1 entry
        lines[4].addPoint(new Point(206, 161));
        lines[4].addPoint(new Point(210, 161));

        //and1 out
        lines[5].addPoint(new Point(237, 155));
        lines[5].addPoint(new Point(244, 155));
        lines[5].addPoint(new Point(244, 79));

        //read on or in
        lines[6].addPoint(new Point(426, 72));
        lines[6].addPoint(new Point(436, 72));

        //timerZero on or in
        lines[7].addPoint(new Point(468, 89));
        lines[7].addPoint(new Point(476, 89));

        //wr on or in
        lines[8].addPoint(new Point(426, 83));
        lines[8].addPoint(new Point(436, 83));

        //GLOBAL run
        lines[12].addPoint(new Point(498, 84));
        lines[12].addPoint(new Point(510, 84));

        //GLOBAL wr
        lines[13].addPoint(new Point(210, 218));
        lines[13].addPoint(new Point(220, 218));

        //wr on and4 in
        lines[14].addPoint(new Point(210, 248));
        lines[14].addPoint(new Point(217, 248));

        //busHold on and4 in
        lines[15].addPoint(new Point(210, 259));
        lines[15].addPoint(new Point(217, 259));

        //and4 out
        lines[16].addPoint(new Point(241, 253));
        lines[16].addPoint(new Point(248, 253));
        lines[16].addPoint(new Point(248, 223));

        //WRBUS
        lines[17].addPoint(new Point(263, 218));
        lines[17].addPoint(new Point(301, 218));

        //read on or1 in
        lines[18].addPoint(new Point(100, 312));
        lines[18].addPoint(new Point(110, 312));

        //wr on or1 in
        lines[19].addPoint(new Point(100, 323));
        lines[19].addPoint(new Point(110, 323));

        //brqStart
        lines[20].addPoint(new Point(131, 317));
        lines[20].addPoint(new Point(157, 317));

        //rd on or2 in
        lines[21].addPoint(new Point(100, 355));
        lines[21].addPoint(new Point(110, 355));

        //wr on or2 in
        lines[22].addPoint(new Point(100, 366));
        lines[22].addPoint(new Point(110, 366));

        //MARout1
        lines[23].addPoint(new Point(131, 361));
        lines[23].addPoint(new Point(157, 361));

        //stHalt
        lines[24].addPoint(new Point(264, 312));
        lines[24].addPoint(new Point(282, 312));

        //halt
        lines[25].addPoint(new Point(340, 312));
        lines[25].addPoint(new Point(359, 312));

        //GLOBAL timerZero
        lines[26].addPoint(new Point(433, 317));
        lines[26].addPoint(new Point(433, 331));
        lines[26].addPoint(new Point(450, 331));

        //brqStop
        lines[27].addPoint(new Point(561, 331));
        lines[27].addPoint(new Point(537, 331));

        //busHold on and(3) in
        lines[28].addPoint(new Point(561, 199));
        lines[28].addPoint(new Point(561, 212));
        lines[28].addPoint(new Point(555, 212));

        //or3 out
        lines[29].addPoint(new Point(554, 218));
        lines[29].addPoint(new Point(569, 218));

        //run on  and(3) in
        lines[30].addPoint(new Point(558, 224));
        lines[30].addPoint(new Point(561, 224));
        lines[30].addPoint(new Point(561, 236));

        //read on or3 in
        lines[31].addPoint(new Point(590, 212));
        lines[31].addPoint(new Point(599, 212));

        //wr on or3 in
        lines[32].addPoint(new Point(590, 223));
        lines[32].addPoint(new Point(599, 223));

        //other

        //ld
        lines[33].addPoint(new Point(524, 218));
        lines[33].addPoint(new Point(513, 218));

        //dec
        lines[34].addPoint(new Point(524, 218));
        lines[34].addPoint(new Point(524, 241));
        lines[34].addPoint(new Point(510, 241));

        //ld->CNT
        lines[33].addPoint(new Point(513, 218));
        lines[33].addPoint(new Point(513, 218));

        //run -> and(3)
        lines[36].addPoint(new Point(559, 223));
        lines[36].addPoint(new Point(559, 223));

        //and(3) out
        lines[37].addPoint(new Point(530, 218));
        lines[37].addPoint(new Point(524, 218));

        // from Dots
        //read
        lines[38].addPoint(new Point(95, 74));
        lines[38].addPoint(new Point(104, 74));

        //rd
        lines[39].addPoint(new Point(200, 74));
        lines[39].addPoint(new Point(232, 74));

        //wr
        lines[40].addPoint(new Point(220, 218));
        lines[40].addPoint(new Point(236, 218));

        //busHold
        lines[41].addPoint(new Point(210, 161));
        lines[41].addPoint(new Point(214, 161));

        //run
        lines[42].addPoint(new Point(510, 84));
        lines[42].addPoint(new Point(527, 84));

        //timerZero
        lines[43].addPoint(new Point(450, 331));
        lines[43].addPoint(new Point(480, 331));

        //cnt in
        lines[44].addPoint(new Point(433, 173));
        lines[44].addPoint(new Point(433, 210));
        lines[44].setThikness(16);

        //cnt out
        lines[45].addPoint(new Point(433, 249));
        lines[45].addPoint(new Point(433, 274));
        lines[45].setThikness(16);
        lines[45].addTextPoint(new Point(444, 268));

        //or out
        lines[47].addPoint(new Point(458, 77));
        lines[47].addPoint(new Point(472, 77));
    }

    private void initPictureComponents() {
        dff1 = new DFlipFlop(0);
        dff2 = new DFlipFlop(0);
        srff1 = new SRFlipFlop(0);
        cnt = new Counter(1);
        and1 = new And(2);
        and2 = new And(2);
        and3  =new And(2);
        and4 = new And(2);
        and5 = new And(3);
        inv1 = new Invertor();
        inv2 = new Invertor();
        nor = new NorForCounter();
        or1 = new Or(2);
        or2 = new Or(2);
        or3 = new Or(2);
        or4 = new Or(2);
        or5 = new Or(2);
        nor2 = new Nor(1); // x-entries
        ibuff1 = new InvertedTripleStateBuffer();
        ibuff2 = new InvertedTripleStateBuffer();

        dot1 = new Junction(4);//read
        dot2 = new Junction(3);//rd
        dot3 = new Junction(6);//wr
        dot4 = new Junction(3);//busHold
        dot5 = new Junction(2);//run
        dot6 = new Junction(3);//timerZero
        dot7 = new Junction(2);
    }

    private void connectComponents() {
        lines[38].setNextComp(dff1);
        lines[38].setNextCompPort(0);

        lines[39].setNextComp(ibuff1);
        lines[39].setNextCompPort(0);
        dff1.setLine(lines[1], 0);

        ibuff1.setLine(lines[2], 0);

        lines[3].setNextComp(and1);
        lines[3].setNextCompPort(0);

        lines[41].setNextComp(and1);
        lines[41].setNextCompPort(1);

        lines[5].setNextComp(ibuff1);
        lines[5].setNextCompPort(1);

        and1.setLine(lines[5], 0);

        lines[6].setNextComp(and2);
        lines[6].setNextCompPort(0);

        and2.setLine(lines[10], 0);

        lines[8].setNextComp(and3);
        lines[8].setNextCompPort(0);

        lines[9].setNextComp(and3);
        lines[9].setNextCompPort(1);

        and3.setLine(lines[11], 0);

        lines[40].setNextComp(ibuff2);
        lines[40].setNextCompPort(0);

        lines[14].setNextComp(and4);
        lines[14].setNextCompPort(0);

        lines[15].setNextComp(and4);
        lines[15].setNextCompPort(1);

        lines[16].setNextComp(ibuff2);
        lines[16].setNextCompPort(1);

        and4.setLine(lines[16], 0);

        ibuff2.setLine(lines[17], 0);

        lines[18].setNextComp(or1);
        lines[18].setNextCompPort(0);

        lines[19].setNextComp(or1);
        lines[19].setNextCompPort(1);

        or1.setLine(lines[20], 0);

        lines[21].setNextComp(or2);
        lines[21].setNextCompPort(0);

        lines[22].setNextComp(or2);
        lines[22].setNextCompPort(1);

        or2.setLine(lines[23], 0);

        lines[24].setNextComp(srff1);
        lines[24].setNextCompPort(0);

        //reset HALT
        lines[49].setNextComp(srff1);
        lines[49].setNextCompPort(1);

        srff1.setLine(lines[25], 0);

        nor2.setLine(lines[26], 0);

        lines[43].setNextComp(dff2);
        lines[43].setNextCompPort(0);

        dff2.setLine(lines[27], 0);

        lines[28].setNextComp(and5);
        lines[28].setNextCompPort(0);

        lines[29].setNextComp(and5);
        lines[29].setNextCompPort(1);

        lines[30].setNextComp(inv2);
        inv2.setLine(lines[36], 0);

        lines[36].setNextComp(and5);
        lines[36].setNextCompPort(2);

        and5.setLine(lines[37], 0);

        or3.setLine(lines[29], 0);

        lines[31].setNextComp(or3);
        lines[31].setNextCompPort(0);

        lines[32].setNextComp(or3);
        lines[32].setNextCompPort(1);

        lines[33].setNextComp(inv1);
        inv1.setLine(lines[35], 0);

        lines[35].setNextComp(cnt);
        lines[35].setNextCompPort(1);

        lines[34].setNextComp(cnt);
        lines[34].setNextCompPort(2);

        lines[0].setNextComp(dot1);
        dot1.setLine(lines[6], 0);
        dot1.setLine(lines[18], 1);
        dot1.setLine(lines[31], 2);
        dot1.setLine(lines[38], 3);

        lines[1].setNextComp(dot2);
        dot2.setLine(lines[3], 0);
        dot2.setLine(lines[21], 1);
        dot2.setLine(lines[39], 2);

        lines[13].setNextComp(dot3);
        dot3.setLine(lines[8], 0);
        dot3.setLine(lines[14], 1);
        dot3.setLine(lines[19], 2);
        dot3.setLine(lines[22], 3);
        dot3.setLine(lines[32], 4);
        dot3.setLine(lines[40], 5);

        lines[4].setNextComp(dot4);
        lines[4].setNextCompPort(0);
        dot4.setLine(lines[15], 0);
        dot4.setLine(lines[28], 1);
        dot4.setLine(lines[41], 2);

        lines[12].setNextComp(dot5);
        lines[12].setNextCompPort(0);
        dot5.setLine(lines[30], 0);
        dot5.setLine(lines[42], 1);

        lines[26].setNextComp(dot6);
        dot6.setLine(lines[7], 0);
        dot6.setLine(lines[9], 1);
        dot6.setLine(lines[43], 2);

        lines[44].setNextComp(cnt);
        lines[44].setNextCompPort(0);

        cnt.setLine(lines[45], 0);

        lines[45].setNextComp(nor);
        lines[45].setNextCompPort(0);

        nor.setLine(lines[26], 0);

        lines[37].setNextComp(dot7);
        lines[37].setNextCompPort(0);

        dot7.setLine(lines[34], 0);
        dot7.setLine(lines[33], 1);

        lines[6].setNextComp(or4);
        lines[8].setNextComp(or4);
        lines[6].setNextCompPort(0);
        lines[8].setNextCompPort(1);

        or4.setLine(lines[47], 0);
        Invertor tempInv = new Invertor();
        lines[47].setNextComp(tempInv);
        lines[47].setNextCompPort(0);
        tempInv.setLine(lines[48], 0);

        lines[48].setNextComp(or5);
        lines[48].setNextCompPort(0);
        lines[7].setNextComp(or5);
        lines[7].setNextCompPort(1);

        or5.setLine(lines[12], 0);
        
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < lines.length; i++) {
            lines[i].paint(g);
        }
    }

    public void refreshSequential() {
        lines[44].refreshValue(0x1);
        dff1.refreshSequential();
        dff2.refreshSequential();
        cnt.refreshSequential();
        srff1.refreshSequential();
    }

    public void clock() {

        dff1.clock();
        dff2.clock();
        srff1.clock();
        cnt.clock();
        lines[49].refreshValue(0);

    }

    public void clear() {
        dff1.setState(0);
        dff2.setState(0);
        srff1.setState(0);
        cnt.setState(1);
    }

    public void resetHalt() {
        lines[49].refreshValue(1);
        srff1.clock();
    }

}