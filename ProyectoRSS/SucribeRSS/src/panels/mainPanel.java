/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author Raquel Villon
 * This class render de view
 */
public class mainPanel extends javax.swing.JPanel {
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * Creates new form mainPanel
     */
    public mainPanel() {
        initComponents();
        setSize(d.width-20, d.height-40);
        setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frecuencyRadioButton = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        radioButton5s = new javax.swing.JRadioButton();
        radioButton10s = new javax.swing.JRadioButton();
        radioButton30s = new javax.swing.JRadioButton();
        radioButton1m = new javax.swing.JRadioButton();
        radioButton5m = new javax.swing.JRadioButton();
        radioButton10m = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        suscribeBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        jLabel1.setText("RSS Suscriber");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        jLabel2.setText("Choose Channels");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        jLabel3.setText("Choose Frecuency");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        frecuencyRadioButton.add(radioButton5s);
        radioButton5s.setText("5 seconds");
        radioButton5s.setActionCommand("5");
        add(radioButton5s, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 110, -1));

        frecuencyRadioButton.add(radioButton10s);
        radioButton10s.setSelected(true);
        radioButton10s.setText("10 seconds");
        radioButton10s.setActionCommand("10");
        add(radioButton10s, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 140, -1));

        frecuencyRadioButton.add(radioButton30s);
        radioButton30s.setText("30 seconds");
        radioButton30s.setActionCommand("30");
        add(radioButton30s, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 130, -1));

        frecuencyRadioButton.add(radioButton1m);
        radioButton1m.setText("1 minute");
        radioButton1m.setActionCommand("60");
        add(radioButton1m, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 130, -1));

        frecuencyRadioButton.add(radioButton5m);
        radioButton5m.setText("5 minutes");
        radioButton5m.setActionCommand("300");
        add(radioButton5m, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 110, -1));

        frecuencyRadioButton.add(radioButton10m);
        radioButton10m.setText("10 minutes");
        radioButton10m.setActionCommand("600");
        add(radioButton10m, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 130, -1));
        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 460, 360));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "", "Channels"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(1).setMinWidth(25);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(25);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 370, 170));

        suscribeBtn.setText("Suscribe");
        suscribeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suscribeBtnActionPerformed(evt);
            }
        });
        add(suscribeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 90, -1));

        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });
        add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(751, 70, 100, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void suscribeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suscribeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suscribeBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup frecuencyRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioButton10m;
    private javax.swing.JRadioButton radioButton10s;
    private javax.swing.JRadioButton radioButton1m;
    private javax.swing.JRadioButton radioButton30s;
    private javax.swing.JRadioButton radioButton5m;
    private javax.swing.JRadioButton radioButton5s;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton suscribeBtn;
    // End of variables declaration//GEN-END:variables
}
