/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CPU_blok_registri_sedmi.java
 *
 * Created on 22.09.2010., 10.24.11
 */

package rs.etf.aor.gui;

import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;
import rs.etf.aor.components.And;
import rs.etf.aor.components.Junction;
import rs.etf.aor.components.Line;
import rs.etf.aor.components.Or;

/**
 *
 * @author MB
 */
public class CPU_blok_registri_sedmi extends javax.swing.JPanel implements PanelsInfo{

    private JPanel parent;
    private String parentTitle = "CPU_organizacija_registri";

    //components
    private And and1, and2, and3, and4, and5, and6, and7,
            and8, and9, and10, and11, and12, and13, and14,
            and15, and16;
    private Or or1, or2, or3, or4, or5, or6;

    //lines
    Line lines[];

    //dots
    private Junction dot1, dot2, dot3, dot4, dot5,
            dot6, dot7, dot8, dot9, dot10;

    //bus

    /** Creates new form CPU_blok_registri_sedmi */
    public CPU_blok_registri_sedmi(JPanel parent) {
        this.parent = parent;
        initComponents();
        initPictureComponents();
        initLines();
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/etf/aor/images/CPU_blok_registri_sedmi.jpg"))); // NOI18N

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
        lines = new Line[70];
        for(int i = 0; i<lines.length; i++){
            lines[i] = new Line(null, 0, 0, 1);
        }

        //GLOBAL
        //ldREG
        lines[0].addPoint(new Point(83, 137));
        lines[0].addPoint(new Point(87, 137));

        //REGout
        lines[1].addPoint(new Point(83, 175));
        lines[1].addPoint(new Point(87, 175));

        //AXsel
        lines[2].addPoint(new Point(83, 149));
        lines[2].addPoint(new Point(87, 149));

        //BXsel
        lines[3].addPoint(new Point(221, 149));
        lines[3].addPoint(new Point(225, 149));

        //CXsel
        lines[4].addPoint(new Point(83, 224));
        lines[4].addPoint(new Point(87, 224));

        //DXsel
        lines[5].addPoint(new Point(83, 300));
        lines[5].addPoint(new Point(87, 300));

        //BPsel
        lines[6].addPoint(new Point(221, 243));
        lines[6].addPoint(new Point(225, 243));

        //DIsel
        lines[7].addPoint(new Point(388, 243));
        lines[7].addPoint(new Point(392, 243));

        //SIsel
        lines[8].addPoint(new Point(388, 149));
        lines[8].addPoint(new Point(392, 149));

        //SPsel
        lines[9].addPoint(new Point(533, 149));
        lines[9].addPoint(new Point(537, 149));

        //endGLOBAL
        ////////////////////////////////////////

        //AX
        //ldREG on and1 in
        lines[10].addPoint(new Point(91, 137));
        lines[10].addPoint(new Point(87, 137));

        //axsel on and1 in
        lines[11].addPoint(new Point(91, 149));
        lines[11].addPoint(new Point(87, 149));

        //ldax
        lines[12].addPoint(new Point(114, 143));
        lines[12].addPoint(new Point(121, 143));

        //REGout on and2 in
        lines[13].addPoint(new Point(91, 175));
        lines[13].addPoint(new Point(87, 175));

        //axsel on and2 in
        lines[14].addPoint(new Point(91, 149));
        lines[14].addPoint(new Point(83, 149));

        //axout
        lines[15].addPoint(new Point(114, 181));
        lines[15].addPoint(new Point(121, 181));

        //CX
        //ldREG on and3 in
        lines[16].addPoint(new Point(91, 214));
        lines[16].addPoint(new Point(83, 214));

        //cxsel on and3 in
        lines[17].addPoint(new Point(91, 224));
        lines[17].addPoint(new Point(87, 224));

        //ldcx
        lines[18].addPoint(new Point(114, 219));
        lines[18].addPoint(new Point(121, 219));

        //REGout on and4 in
        lines[19].addPoint(new Point(91, 250));
        lines[19].addPoint(new Point(83, 250));

        //cxsel on and4 in
        lines[20].addPoint(new Point(91, 262));
        lines[20].addPoint(new Point(83, 262));

        //cxout
        lines[21].addPoint(new Point(114, 256));
        lines[21].addPoint(new Point(121, 256));

        //DX
        //ldREG on and5 in
        lines[22].addPoint(new Point(91, 289));
        lines[22].addPoint(new Point(83, 289));

        //dxsel on and5 in
        lines[23].addPoint(new Point(91, 300));
        lines[23].addPoint(new Point(87, 300));

        //lddx
        lines[24].addPoint(new Point(114, 294));
        lines[24].addPoint(new Point(121, 294));

        //REGout on and6 in
        lines[25].addPoint(new Point(91, 326));
        lines[25].addPoint(new Point(83, 326));

        //dxsel on and6 in
        lines[26].addPoint(new Point(91, 338));
        lines[26].addPoint(new Point(83, 338));

        //dxout
        lines[27].addPoint(new Point(114, 333));
        lines[27].addPoint(new Point(121, 333));


        //BX
        //ldREG on and7 in
        lines[28].addPoint(new Point(220, 137));
        lines[28].addPoint(new Point(227, 137));

        //bxsel on and7 in
        lines[29].addPoint(new Point(225, 149));
        lines[29].addPoint(new Point(227, 149));

        //ldbx
        lines[30].addPoint(new Point(251, 143));
        lines[30].addPoint(new Point(258, 143));

        //REGout on and8 in
        lines[31].addPoint(new Point(220, 175));
        lines[31].addPoint(new Point(227, 175));

        //bxsel on and8 in
        lines[32].addPoint(new Point(220, 187));
        lines[32].addPoint(new Point(227, 187));

        //and8out
        lines[33].addPoint(new Point(251, 181));
        lines[33].addPoint(new Point(265, 181));

        //bxout2
        lines[34].addPoint(new Point(256, 192));
        lines[34].addPoint(new Point(265, 192));

        //bxout
        lines[35].addPoint(new Point(286, 187));
        lines[35].addPoint(new Point(293, 187));

        //BP
        //ldREG on and9 in
        lines[36].addPoint(new Point(220, 232));
        lines[36].addPoint(new Point(227, 232));

        //bpsel on and9 in
        lines[37].addPoint(new Point(225, 243));
        lines[37].addPoint(new Point(227, 243));

        //ldbp
        lines[38].addPoint(new Point(251, 238));
        lines[38].addPoint(new Point(258, 238));

        //REGout on and10 in
        lines[39].addPoint(new Point(220, 270));
        lines[39].addPoint(new Point(227, 270));

        //bpsel on and10 in
        lines[40].addPoint(new Point(220, 281));
        lines[40].addPoint(new Point(227, 281));

        //and10out
        lines[41].addPoint(new Point(251, 275));
        lines[41].addPoint(new Point(265, 275));

        //bpout2
        lines[42].addPoint(new Point(256, 287));
        lines[42].addPoint(new Point(265, 287));

        //bpout
        lines[43].addPoint(new Point(286, 281));
        lines[43].addPoint(new Point(293, 281));

        //SI
        //ldREG on and11 in
        lines[44].addPoint(new Point(388, 137));
        lines[44].addPoint(new Point(395, 137));

        //sisel on and11 in
        lines[45].addPoint(new Point(392, 149));
        lines[45].addPoint(new Point(395, 149));

        //ldsi
        lines[46].addPoint(new Point(418, 143));
        lines[46].addPoint(new Point(426, 143));

        //REGout on and12 in
        lines[47].addPoint(new Point(388, 175));
        lines[47].addPoint(new Point(395, 175));

        //sisel on and12 in
        lines[48].addPoint(new Point(388, 187));
        lines[48].addPoint(new Point(395, 187));

        //and12out
        lines[49].addPoint(new Point(418, 181));
        lines[49].addPoint(new Point(432, 181));

        //siout2
        lines[50].addPoint(new Point(423, 192));
        lines[50].addPoint(new Point(433, 192));

        //siout
        lines[51].addPoint(new Point(454, 187));
        lines[51].addPoint(new Point(461, 187));

        //DI
        //ldREG on and13 in
        lines[52].addPoint(new Point(388, 232));
        lines[52].addPoint(new Point(395, 232));

        //disel on and13 in
        lines[53].addPoint(new Point(392, 243));
        lines[53].addPoint(new Point(395, 243));

        //lddi
        lines[54].addPoint(new Point(418, 238));
        lines[54].addPoint(new Point(426, 238));

        //REGout on and14 in
        lines[55].addPoint(new Point(388, 270));
        lines[55].addPoint(new Point(395, 270));

        //disel on and14 in
        lines[56].addPoint(new Point(388, 281));
        lines[56].addPoint(new Point(395, 281));

        //and14out
        lines[57].addPoint(new Point(418, 275));
        lines[57].addPoint(new Point(432, 275));

        //diout2
        lines[58].addPoint(new Point(423, 287));
        lines[58].addPoint(new Point(433, 287));

        //diout
        lines[59].addPoint(new Point(454, 281));
        lines[59].addPoint(new Point(461, 281));
        
        //SP
        //ldREG on and15 in
        lines[60].addPoint(new Point(533, 137));
        lines[60].addPoint(new Point(541, 137));

        //spsel on and15 in
        lines[61].addPoint(new Point(537, 149));
        lines[61].addPoint(new Point(541, 149));

        //and15out
        lines[62].addPoint(new Point(564, 143));
        lines[62].addPoint(new Point(578, 143));

        //upldsp
        lines[63].addPoint(new Point(569, 154));
        lines[63].addPoint(new Point(578, 154));

        //ldsp
        lines[64].addPoint(new Point(599, 149));
        lines[64].addPoint(new Point(607, 149));

        //ldREG on and16 in
        lines[65].addPoint(new Point(533, 232));
        lines[65].addPoint(new Point(541, 232));

        //spsel on and16 in
        lines[66].addPoint(new Point(533, 243));
        lines[66].addPoint(new Point(541, 243));

        //and16out
        lines[67].addPoint(new Point(564, 238));
        lines[67].addPoint(new Point(578, 238));

        //upspout
        lines[68].addPoint(new Point(569, 249));
        lines[68].addPoint(new Point(578, 249));

        //spout
        lines[69].addPoint(new Point(599, 243));
        lines[69].addPoint(new Point(607, 243));
        
    }

    private void initPictureComponents() {
        and1 = new And(2);
        and2 = new And(2);
        and3 = new And(2);
        and4 = new And(2);
        and5 = new And(2);
        and6 = new And(2);
        and7 = new And(2);
        and8 = new And(2);
        and9 = new And(2);
        and10 = new And(2);
        and11 = new And(2);
        and12 = new And(2);
        and13 = new And(2);
        and14 = new And(2);
        and15 = new And(2);
        and16 = new And(2);

        or1 = new Or(2);
        or2 = new Or(2);
        or3 = new Or(2);
        or4 = new Or(2);
        or5 = new Or(2);
        or6 = new Or(2);

        dot1 = new Junction(8);//ldREG
        dot2 = new Junction(8);//REGout
        dot3 = new Junction(2);//axsel
        dot4 = new Junction(2);//bxsel
        dot5 = new Junction(2);//cxsel
        dot6 = new Junction(2);//dxsel
        dot7 = new Junction(2);//bpsel
        dot8 = new Junction(2);//disel
        dot9 = new Junction(2);//sisel
        dot10 = new Junction(2);//spsel
    }

    private void connectComponents() {
        lines[0].setNextComp(dot1);
        lines[1].setNextComp(dot2);
        lines[2].setNextComp(dot3);
        lines[3].setNextComp(dot4);
        lines[4].setNextComp(dot5);
        lines[5].setNextComp(dot6);
        lines[6].setNextComp(dot7);
        lines[7].setNextComp(dot8);
        lines[8].setNextComp(dot9);
        lines[9].setNextComp(dot10);

        //ax
        dot1.setLine(lines[10], 0);
        lines[10].setNextComp(and1);
        lines[10].setNextCompPort(0);
        dot3.setLine(lines[11], 0);
        lines[11].setNextComp(and1);
        lines[11].setNextCompPort(1);
        and1.setLine(lines[12], 0);

        dot2.setLine(lines[13], 0);
        lines[13].setNextComp(and2);
        lines[13].setNextCompPort(0);
        dot3.setLine(lines[14], 1);
        lines[14].setNextComp(and2);
        lines[14].setNextCompPort(1);
        and2.setLine(lines[15], 0);

        //cx
        dot1.setLine(lines[16], 1);
        lines[16].setNextComp(and3);
        lines[16].setNextCompPort(0);
        dot5.setLine(lines[17], 0);
        lines[17].setNextComp(and3);
        lines[17].setNextCompPort(1);
        and3.setLine(lines[18], 0);

        dot2.setLine(lines[19], 1);
        lines[19].setNextComp(and4);
        lines[19].setNextCompPort(0);
        dot5.setLine(lines[20], 1);
        lines[20].setNextComp(and4);
        lines[20].setNextCompPort(1);
        and4.setLine(lines[21], 0);

        //dx
        dot1.setLine(lines[22], 2);
        lines[22].setNextComp(and5);
        lines[22].setNextCompPort(0);
        dot6.setLine(lines[23], 0);
        lines[23].setNextComp(and5);
        lines[23].setNextCompPort(1);
        and5.setLine(lines[24], 0);

        dot2.setLine(lines[25], 2);
        lines[25].setNextComp(and6);
        lines[25].setNextCompPort(0);
        dot6.setLine(lines[26], 1);
        lines[26].setNextComp(and6);
        lines[26].setNextCompPort(1);
        and6.setLine(lines[27], 0);

        //bx
        dot1.setLine(lines[28], 3);
        lines[28].setNextComp(and7);
        lines[28].setNextCompPort(0);
        dot4.setLine(lines[29], 0);
        lines[29].setNextComp(and7);
        lines[29].setNextCompPort(1);
        and7.setLine(lines[30], 0);

        dot2.setLine(lines[31], 3);
        lines[31].setNextComp(and8);
        lines[31].setNextCompPort(0);
        dot4.setLine(lines[32], 1);
        lines[32].setNextComp(and8);
        lines[32].setNextCompPort(1);
        and8.setLine(lines[33], 0);
        lines[33].setNextComp(or1);
        lines[33].setNextCompPort(0);
        lines[34].setNextComp(or1);
        lines[34].setNextCompPort(1);
        or1.setLine(lines[35], 0);

        //bp
        dot1.setLine(lines[36], 4);
        lines[36].setNextComp(and9);
        lines[36].setNextCompPort(0);
        dot7.setLine(lines[37], 0);
        lines[37].setNextComp(and9);
        lines[37].setNextCompPort(1);
        and9.setLine(lines[38], 0);

        dot2.setLine(lines[39], 4);
        lines[39].setNextComp(and10);
        lines[39].setNextCompPort(0);
        dot7.setLine(lines[40], 1);
        lines[40].setNextComp(and10);
        lines[40].setNextCompPort(1);
        and10.setLine(lines[41], 0);
        lines[41].setNextComp(or2);
        lines[41].setNextCompPort(0);
        lines[42].setNextComp(or2);
        lines[42].setNextCompPort(1);
        or2.setLine(lines[43], 0);

        //si
        dot1.setLine(lines[44], 5);
        lines[44].setNextComp(and11);
        lines[44].setNextCompPort(0);
        dot9.setLine(lines[45], 0);
        lines[45].setNextComp(and11);
        lines[45].setNextCompPort(1);
        and11.setLine(lines[46], 0);

        dot2.setLine(lines[47], 5);
        lines[47].setNextComp(and12);
        lines[47].setNextCompPort(0);
        dot9.setLine(lines[48], 1);
        lines[48].setNextComp(and12);
        lines[48].setNextCompPort(1);
        and12.setLine(lines[49], 0);
        lines[49].setNextComp(or3);
        lines[49].setNextCompPort(0);
        lines[50].setNextComp(or3);
        lines[50].setNextCompPort(1);
        or3.setLine(lines[51], 0);

        //di
        dot1.setLine(lines[52], 6);
        lines[52].setNextComp(and13);
        lines[52].setNextCompPort(0);
        dot8.setLine(lines[53], 0);
        lines[53].setNextComp(and13);
        lines[53].setNextCompPort(1);
        and13.setLine(lines[54], 0);

        dot2.setLine(lines[55], 6);
        lines[55].setNextComp(and14);
        lines[55].setNextCompPort(0);
        dot8.setLine(lines[56], 1);
        lines[56].setNextComp(and14);
        lines[56].setNextCompPort(1);
        and14.setLine(lines[57], 0);
        lines[57].setNextComp(or4);
        lines[57].setNextCompPort(0);
        lines[58].setNextComp(or4);
        lines[58].setNextCompPort(1);
        or4.setLine(lines[59], 0);

        //sp
        dot1.setLine(lines[60], 7);
        lines[60].setNextComp(and15);
        lines[60].setNextCompPort(0);
        dot10.setLine(lines[61], 0);
        lines[61].setNextComp(and15);
        lines[61].setNextCompPort(1);
        and15.setLine(lines[62], 0);
        lines[62].setNextComp(or5);
        lines[62].setNextCompPort(0);
        lines[63].setNextComp(or5);
        lines[63].setNextCompPort(1);
        or5.setLine(lines[64], 0);

        dot2.setLine(lines[65], 7);
        lines[65].setNextComp(and16);
        lines[65].setNextCompPort(0);
        dot10.setLine(lines[66], 1);
        lines[66].setNextComp(and16);
        lines[66].setNextCompPort(1);
        and16.setLine(lines[67], 0);
        lines[67].setNextComp(or6);
        lines[67].setNextCompPort(0);
        lines[68].setNextComp(or6);
        lines[68].setNextCompPort(1);
        or6.setLine(lines[69], 0);
    }

    public void refreshSequential() {
    }

    public void clock() {
    }

    public void clear(){
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < lines.length; i++) {
            lines[i].paint(g);
        }
    }
}
