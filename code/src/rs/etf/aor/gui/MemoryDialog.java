/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MemoryDialog.java
 *
 * Created on Sep 11, 2010, 6:34:34 PM
 */
package rs.etf.aor.gui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;

/**
 *
 * @author Dragan
 */
public class MemoryDialog extends javax.swing.JDialog {

    /** Creates new form MemoryDialog */
    public MemoryDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public MemoryDialog(java.awt.Frame parent, boolean modal, final byte[] memory) {
        this(parent, modal);

        panel.setLayout(new GridLayout(0, 9, 10, 5));

        boolean dots = false;
        for (int i = 0; i < memory.length; i += 8) {

            if (memory[i] == 0 && memory[i + 1] == 0 && memory[i + 2] == 0 && memory[i + 3] == 0 && memory[i + 4] == 0 && memory[i + 5] == 0 && memory[i + 6] == 0 && memory[i + 7] == 0 && i > 2 * 8 && i < 8190 * 8) {
                if (!dots) {
                    JLabel temp = new JLabel();
                    panel.add(temp);
                    for (int j = 0; j < 8; j++) {
                        if (j == 3) {
                            temp = new JLabel(". . .");
                        } else {
                            temp = new JLabel();
                        }
                        panel.add(temp);
                    }
                    dots = true;
                }
                continue;
            }
            dots = false;
            JLabel address = new JLabel(formatter(Integer.toHexString(i).toUpperCase()));
            address.setForeground(Color.red);
            address.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            panel.add(address);
            for (int j = 0; j < 8; j++) {
                JLabel number = new JLabel(formatter(Integer.toHexString(memory[i + j] & 0xFF).toUpperCase()));
                number.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                panel.add(number);
            }
        }

        setSize(660, 500);
        setResizable(false);
        setTitle("MemoryDialog");

    }

    public void refreshMemory (byte[] memory) {

        panel.removeAll();
        panel.setLayout(new GridLayout(0, 9, 10, 5));

        boolean dots = false;
        for (int i = 0; i < memory.length; i += 8) {

            if (memory[i] == 0 && memory[i + 1] == 0 && memory[i + 2] == 0 && memory[i + 3] == 0 && memory[i + 4] == 0 && memory[i + 5] == 0 && memory[i + 6] == 0 && memory[i + 7] == 0 && i > 2 * 8 && i < 8190 * 8) {
                if (!dots) {
                    JLabel temp = new JLabel();
                    panel.add(temp);
                    for (int j = 0; j < 8; j++) {
                        if (j == 3) {
                            temp = new JLabel(". . .");
                        } else {
                            temp = new JLabel();
                        }
                        panel.add(temp);
                    }
                    dots = true;
                }
                continue;
            }
            dots = false;
            JLabel address = new JLabel(formatter(Integer.toHexString(i).toUpperCase()));
            address.setForeground(Color.red);
            address.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            panel.add(address);
            for (int j = 0; j < 8; j++) {
                JLabel number = new JLabel(formatter(Integer.toHexString(memory[i + j] & 0xFF).toUpperCase()));
                number.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                panel.add(number);
            }
        }

    }

    private String formatter(String hexString) {

        int desiredLength = 2;

        while (hexString.length() < desiredLength) {
            hexString = "0" + hexString;
        }

        return "0x" + hexString;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        OK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 618, Short.MAX_VALUE));
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 328, Short.MAX_VALUE));

        scrollPane.setViewportView(panel);

        getContentPane().add(scrollPane);
        scrollPane.setBounds(10, 60, 620, 330);

        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });
        getContentPane().add(OK);
        OK.setBounds(295, 410, 60, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Address");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 30, 50, 14);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Values");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(330, 30, 50, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_OKActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                byte[] memory = new byte[0x10000];
                MemoryDialog dialog = new MemoryDialog(new javax.swing.JFrame(), true, memory);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
