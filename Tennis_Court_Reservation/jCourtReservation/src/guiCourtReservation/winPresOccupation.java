/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiCourtReservation;

import domainCourtReservation.jCourt;
import domainCourtReservation.jReservations;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo Garcez Vieira
 */
public class winPresOccupation extends javax.swing.JInternalFrame {

    /**
     * Creates new form winPresOccupation
     */
    public winPresOccupation() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCourtID = new javax.swing.JLabel();
        cmbCourtID = new javax.swing.JComboBox<>();
        lblFromDate = new javax.swing.JLabel();
        jXDatePickerFrom = new org.jdesktop.swingx.JXDatePicker();
        lblToDate = new javax.swing.JLabel();
        jXDatePickerTo = new org.jdesktop.swingx.JXDatePicker();
        txtResult = new javax.swing.JTextField();
        lblResult = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnCalculate = new javax.swing.JButton();

        setClosable(true);

        lblCourtID.setText("Court ID");

        cmbCourtID.setModel(new DefaultComboBoxModel(jCourt.getCourtsID()));
        cmbCourtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCourtIDActionPerformed(evt);
            }
        });

        lblFromDate.setText("From");

        jXDatePickerFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePickerFromActionPerformed(evt);
            }
        });

        lblToDate.setText("To");

        jXDatePickerTo.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jXDatePickerToInputMethodTextChanged(evt);
            }
        });
        jXDatePickerTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePickerToActionPerformed(evt);
            }
        });

        txtResult.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtResult.setEnabled(false);

        lblResult.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblResult.setText("Result");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnCalculate.setText("Calculate");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCalculate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblToDate)
                            .addComponent(lblCourtID)
                            .addComponent(lblFromDate)
                            .addComponent(lblResult))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXDatePickerFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCourtID, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXDatePickerTo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCourtID)
                    .addComponent(cmbCourtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFromDate)
                    .addComponent(jXDatePickerFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblToDate))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jXDatePickerTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResult))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnCalculate))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Date dateFrom, dateTo;
    
    private void cmbCourtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCourtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCourtIDActionPerformed

    private void jXDatePickerFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePickerFromActionPerformed
        try {
            this.dateFrom = this.jXDatePickerFrom.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String strfromDate = sdf.format(this.dateFrom);
            this.jXDatePickerFrom.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error entering date! " + e);}
    }//GEN-LAST:event_jXDatePickerFromActionPerformed

    private void jXDatePickerToInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jXDatePickerToInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePickerToInputMethodTextChanged

    private void jXDatePickerToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePickerToActionPerformed
        try {
            this.dateTo = this.jXDatePickerTo.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String strtoDate = sdf.format(this.dateTo);
            this.jXDatePickerTo.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error entering date! " + e);}
    }//GEN-LAST:event_jXDatePickerToActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        String str = (String) this.cmbCourtID.getSelectedItem();
        String[] courtReservations = new String[100];
        float result = 0;
        int k = -1;
        try {
            k = Integer.valueOf(str);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Please enter valid n.º Court ID!");}
        if (k != -1) { 
            result = jReservations.presentOccupation(k, this.dateFrom, this.dateTo);
        }
        String occupationRate = String.valueOf(result) + " % for day(s)";
        this.txtResult.setText(occupationRate);
    }//GEN-LAST:event_btnCalculateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnExit;
    private javax.swing.JComboBox<String> cmbCourtID;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerFrom;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerTo;
    private javax.swing.JLabel lblCourtID;
    private javax.swing.JLabel lblFromDate;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblToDate;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}