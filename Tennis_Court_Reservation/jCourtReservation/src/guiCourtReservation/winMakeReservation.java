/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiCourtReservation;

import domainCourtReservation.TableCellListener;
import domainCourtReservation.enumErrorCode;
import domainCourtReservation.enumEventOrigin;
import domainCourtReservation.enumEventType;
import domainCourtReservation.enumReservationStatus;
import domainCourtReservation.enumSurface;
import domainCourtReservation.jCourt;
import domainCourtReservation.jDate;
import domainCourtReservation.jMember;
import domainCourtReservation.jReservations;
import domainCourtReservation.jTimetable;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Paulo Garcez Vieira
 */
public class winMakeReservation extends javax.swing.JInternalFrame {
    
    private Date dateReservation;
    private String [] hourSlots = {"00:00", "01:00", "02:00", "03:00", "04:00",
                        "05:00", "06:00", "07:00", "08:00", "09:00", "10:00",
                        "11:00", "12:00", "13:00", "14:00", "15:00", "16:00",
                        "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
    private boolean isMember = true;
    private enumReservationStatus cellSlotChanged;
    private String rowHourSlotChanged;
    private int columnSlotChanged;
    private int[] arrayCourtID;
    private int rowChanged = 0;
    private int colChanged = 0;
    
    /**
     * Creates new form winMakeReservation
     */
    public winMakeReservation() {
        initComponents();
        this.resetComponents();  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMemberID = new javax.swing.JLabel();
        txtMemberID = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnPreference = new javax.swing.JButton();
        btnEvents = new javax.swing.JButton();
        pnlLeft = new javax.swing.JPanel();
        lblSurface = new javax.swing.JLabel();
        cmbSurface = new javax.swing.JComboBox<>();
        lblLocation = new javax.swing.JLabel();
        cmbLocation = new javax.swing.JComboBox<>();
        lblLightning = new javax.swing.JLabel();
        chkLightning = new javax.swing.JCheckBox();
        lblDate = new javax.swing.JLabel();
        jXDatePickerDate = new org.jdesktop.swingx.JXDatePicker();
        lblEventType = new javax.swing.JLabel();
        cmbEventType = new javax.swing.JComboBox<>();
        lblEventOrigin = new javax.swing.JLabel();
        cmbEventOrigin = new javax.swing.JComboBox<>();
        lblWeekend = new javax.swing.JLabel();
        chkWeekend = new javax.swing.JCheckBox();
        lblNoPreferences = new javax.swing.JLabel();
        chkNoPreferences = new javax.swing.JCheckBox();
        btnSearch = new javax.swing.JButton();
        pnlRight = new javax.swing.JPanel();
        jScrollPaneTimeSlots = new javax.swing.JScrollPane();
        tblTimeSlots = new javax.swing.JTable();
        btnConfirm = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setClosable(true);

        lblMemberID.setText("Member ID");

        txtMemberID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMemberIDActionPerformed(evt);
            }
        });

        lblName.setText("Name");
        lblName.setEnabled(false);

        txtName.setEnabled(false);

        btnPreference.setText("Preference");
        btnPreference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreferenceActionPerformed(evt);
            }
        });

        btnEvents.setText("Events");
        btnEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventsActionPerformed(evt);
            }
        });

        pnlLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preferences", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblSurface.setText("Surface");

        cmbSurface.setModel(new DefaultComboBoxModel(enumSurface.values()));
        cmbSurface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSurfaceActionPerformed(evt);
            }
        });

        lblLocation.setText("Location");

        cmbLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INDOOR", "OUTDOOR" }));
        cmbLocation.setSelectedIndex(-1);
        cmbLocation.setToolTipText("");
        cmbLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocationActionPerformed(evt);
            }
        });

        lblLightning.setText("Lighting");

        chkLightning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLightningActionPerformed(evt);
            }
        });

        lblDate.setText("Date");

        jXDatePickerDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePickerDateActionPerformed(evt);
            }
        });

        lblEventType.setText("Event Type");

        cmbEventType.setModel(new DefaultComboBoxModel(enumEventType.values()));
        cmbEventType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEventTypeActionPerformed(evt);
            }
        });

        lblEventOrigin.setText("Event Origin");

        cmbEventOrigin.setModel(new DefaultComboBoxModel(enumEventOrigin.values()));
        cmbEventOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEventOriginActionPerformed(evt);
            }
        });

        lblWeekend.setText("Weekend");

        chkWeekend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkWeekendActionPerformed(evt);
            }
        });

        lblNoPreferences.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNoPreferences.setText("No Preferences");

        chkNoPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkNoPreferencesActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlLeftLayout.createSequentialGroup()
                        .addComponent(lblNoPreferences)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkNoPreferences))
                    .addComponent(btnSearch)
                    .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jXDatePickerDate, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                        .addComponent(cmbLocation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbEventType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbEventOrigin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbSurface, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlLeftLayout.createSequentialGroup()
                            .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblEventOrigin)
                                .addComponent(lblEventType)
                                .addComponent(lblDate)
                                .addComponent(lblLocation)
                                .addComponent(lblSurface)
                                .addComponent(lblLightning)
                                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(chkLightning)
                                    .addGroup(pnlLeftLayout.createSequentialGroup()
                                        .addComponent(lblWeekend)
                                        .addGap(18, 18, 18)
                                        .addComponent(chkWeekend))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXDatePickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(lblEventType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEventType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEventOrigin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEventOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSurface)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSurface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLocation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlLeftLayout.createSequentialGroup()
                        .addComponent(cmbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLightning))
                    .addComponent(chkLightning))
                .addGap(3, 3, 3)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkNoPreferences)
                    .addComponent(lblNoPreferences))
                .addGap(1, 1, 1)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWeekend, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chkWeekend, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(15, 15, 15)
                .addComponent(btnSearch)
                .addContainerGap())
        );

        pnlRight.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Time slots", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblTimeSlots.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTimeSlots.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPaneTimeSlots.setViewportView(tblTimeSlots);

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTimeSlots, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addGap(6, 6, 6))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTimeSlots, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnConfirm)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblMemberID)
                .addGap(18, 18, 18)
                .addComponent(txtMemberID, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPreference)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEvents, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(lblName)
                .addGap(18, 18, 18)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMemberID)
                    .addComponent(txtMemberID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPreference)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName)
                    .addComponent(btnEvents))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSurfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSurfaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSurfaceActionPerformed

    private void cmbLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLocationActionPerformed

    private void chkLightningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLightningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkLightningActionPerformed

    private void jXDatePickerDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePickerDateActionPerformed
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            this.dateReservation = this.jXDatePickerDate.getDate();
            String strReservDate = sdf.format(this.dateReservation);
            enumErrorCode errCode = jDate.enabledDate(this.dateReservation);
            if (errCode == enumErrorCode.CLUB_CLOSED)  {
                    String purpose = "The Tennis Club is closed!" + "\n Purpose: " + jDate.enabledPurpose(this.dateReservation);
                    JOptionPane.showMessageDialog(this, purpose);
                    this.btnSearch.setEnabled(false);
            } else {
                this.btnSearch.setEnabled(true);
                Calendar cal = Calendar.getInstance();
                cal.setTime(this.dateReservation);
                int day = cal.get(Calendar.DAY_OF_WEEK);
                if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
                    this.chkWeekend.setSelected(true);
                } else { this.chkWeekend.setSelected(false); }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error entering date! " + e);}
    }//GEN-LAST:event_jXDatePickerDateActionPerformed

    private void txtMemberIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMemberIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMemberIDActionPerformed

    private void btnPreferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreferenceActionPerformed
        String str = this.txtMemberID.getText();
        try {
            int k = Integer.valueOf(str);
            int j = jMember.findMember(k);
            
            if (j >= 0) {
                
                if (!jMember.getStatus(j))  {
                    JOptionPane.showMessageDialog(this,"Member status is inactive!");
                } else {
                    this.txtMemberID.setText(Integer.toString(jMember.getMemberID(j)));
                    this.txtName.setText(jMember.getName(j));
                    this.cmbSurface.setSelectedItem(jMember.getSurface(j));
                    this.lblSurface.setEnabled(true);
                    this.cmbSurface.setEnabled(true);
                    this.btnPreference.setEnabled(false);
                    this.lblMemberID.setEnabled(false);
                    this.txtMemberID.setEnabled(false);
                    this.lblLightning.setEnabled(true);
                    this.lblLocation.setEnabled(true);
                    this.chkLightning.setEnabled(true);
                    this.cmbLocation.setEnabled(true);
                    this.lblDate.setEnabled(true);
                    this.chkNoPreferences.setEnabled(true);
                    this.lblNoPreferences.setEnabled(true);
                    this.jXDatePickerDate.setEnabled(true);
                    this.cmbEventType.setSelectedItem(enumEventType.BOOKING);
                    this.cmbEventOrigin.setSelectedItem(enumEventOrigin.EXTERNAL);
                    this.btnEvents.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(this,"Member not found!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Please enter valid n.º Member ID!");}
    }//GEN-LAST:event_btnPreferenceActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cmbEventTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEventTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEventTypeActionPerformed

    private void cmbEventOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEventOriginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEventOriginActionPerformed

    private void chkWeekendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkWeekendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkWeekendActionPerformed

    private void btnEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventsActionPerformed
        this.lblSurface.setEnabled(true);
        this.cmbSurface.setEnabled(true);
        this.btnPreference.setEnabled(false);
        this.lblMemberID.setEnabled(false);
        this.txtMemberID.setEnabled(false);
        this.lblLightning.setEnabled(true);
        this.lblLocation.setEnabled(true);
        this.chkLightning.setEnabled(true);
        this.cmbLocation.setEnabled(true);
        this.lblDate.setEnabled(true);
        this.jXDatePickerDate.setEnabled(true);
        this.cmbEventType.setEnabled(true);
        this.lblEventType.setEnabled(true);
        this.cmbEventOrigin.setEnabled(true);
        this.lblEventOrigin.setEnabled(true);
        this.btnEvents.setEnabled(false);
        this.isMember = false;
        this.chkNoPreferences.setEnabled(true);
        this.lblNoPreferences.setEnabled(true);
    }//GEN-LAST:event_btnEventsActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        enumSurface tempEnum = (enumSurface) this.cmbSurface.getSelectedItem();
        String tempStr = (String) this.cmbLocation.getSelectedItem();
        boolean tempLight = this.chkLightning.isSelected();
        boolean allCourts = this.chkNoPreferences.isSelected();
        arrayCourtID = jCourt.matchCourts(tempEnum, tempStr, tempLight, allCourts);
        if (arrayCourtID.length == 0) {
            JOptionPane.showMessageDialog(this,"None of the courts match the preferences!");
        } else {
            for (int m = 0; m > arrayCourtID.length; m++)  {
                if (jTimetable.existCourtTimetable(arrayCourtID[m], this.dateReservation) == -1) {
                    JOptionPane.showMessageDialog(this,"There are courts without Timetable!");
                }
            }
            this.btnSearch.setEnabled(false);
            this.btnConfirm.setEnabled(true);
            DefaultTableModel model = new DefaultTableModel()  {
                    public boolean isCellEditable(int row, int col) {
                        if (col == 0 || this.getValueAt(row, col) == enumReservationStatus.UNAVAILABLE) {
                            return false;
                        }
                        return true;
                    }
            };
            model.setNumRows(24);
            model.setColumnCount(arrayCourtID.length + 1);
            String [] columnTitles = jMakeReservation.getColumnNames(arrayCourtID);
            model.setColumnIdentifiers(columnTitles);
            int nrows = model.getRowCount();
            for (int i = 0; i < nrows; i++)  {
                model.setValueAt (hourSlots[i], i, 0);
            }
            enumReservationStatus[][] timeSlotsContent = jTimetable.setupSlots(arrayCourtID, nrows, this.dateReservation, this.chkWeekend.isSelected());
            for (int i = 0; i < nrows; i++)  {
                for (int j = 1; j < model.getColumnCount(); j++) {
                    if (jReservations.isRowReserved(this.dateReservation, hourSlots[i], arrayCourtID[j - 1])) {
                        timeSlotsContent[i][j] = enumReservationStatus.RESERVED;
                    }
                    if (jReservations.isRowCanceled(this.dateReservation, hourSlots[i], arrayCourtID[j - 1])) {
                        timeSlotsContent[i][j] = enumReservationStatus.CANCELED;
                    }
                    model.setValueAt (timeSlotsContent[i][j], i, j);
                }
            }
            this.tblTimeSlots.setModel(model);
            jMakeReservation.setUpColumnSpots(this.tblTimeSlots, model.getColumnCount(), columnTitles);
            TableColumnModel tcm = this.tblTimeSlots.getColumnModel();
            tcm.getColumn(0).setPreferredWidth(60);
            for (int i = 1; i < (tcm.getColumnCount()); i++) {
                tcm.getColumn(i).setPreferredWidth(100);
                this.tblTimeSlots.getColumnModel().getColumn(i).setCellRenderer(new CustomRenderer());
            }
            this.tblTimeSlots.setVisible(true);
            this.tblTimeSlots.setEnabled(true);
            
            Action action = new AbstractAction()  {
                public void actionPerformed(ActionEvent e)   {
                    TableCellListener tcl = (TableCellListener)e.getSource();
                    rowChanged = tcl.getRow();
                    colChanged = tcl.getColumn();
                }
            };
            TableCellListener tcl = new TableCellListener(this.tblTimeSlots, action);
            
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
            if (rowChanged != 0 || colChanged != 0) {
                int k = 0;
                    if (!this.txtMemberID.getText().isEmpty()) {
                            String str = this.txtMemberID.getText();
                    try {
                        k = Integer.valueOf(str);
                    } catch (NumberFormatException e) { 
                        JOptionPane.showMessageDialog(this,"Error! " + e);
                    }
                }
                               
                enumReservationStatus tmp1 = enumReservationStatus.RESERVED;
                enumEventType tmp2 = (enumEventType) this.cmbEventType.getSelectedItem();
                enumEventOrigin tmp3 = (enumEventOrigin) this.cmbEventOrigin.getSelectedItem();
                int tmp4 = arrayCourtID[colChanged - 1];
                String hourReserv = (String) this.tblTimeSlots.getValueAt(rowChanged, 0);
                jReservations temp = new jReservations(this.dateReservation, hourReserv, k, tmp4, tmp1, tmp2, tmp3);
                enumErrorCode errCode = jReservations.confirmReservation(temp);		
                if (errCode == enumErrorCode.OK) {
                        JOptionPane.showMessageDialog(this,"Reservation confirmed with success!");
                } else {JOptionPane.showMessageDialog(this,"Reservation details error!");}    
            }    
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void chkNoPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkNoPreferencesActionPerformed
       if (this.chkNoPreferences.isSelected()) {
            this.chkLightning.setSelected(false);
            this.chkLightning.setEnabled(false);
            this.chkWeekend.setSelected(false);
            this.chkWeekend.setEnabled(false);
            this.lblWeekend.setEnabled(false);
            this.lblLightning.setEnabled(false);
            this.cmbLocation.setEnabled(false);
            this.cmbLocation.setSelectedIndex(-1);
            this.cmbSurface.setEnabled(false);
            this.cmbSurface.setSelectedIndex(-1);
            this.lblSurface.setEnabled(false);
            this.lblLocation.setEnabled(false);
       } else  {
            this.chkLightning.setEnabled(true);
            this.chkWeekend.setEnabled(true);
            this.lblWeekend.setEnabled(true);
            this.lblLightning.setEnabled(true);
            this.cmbLocation.setEnabled(true);
            this.cmbSurface.setEnabled(true);
            this.lblSurface.setEnabled(true);
            this.lblLocation.setEnabled(true);
       }
    }//GEN-LAST:event_chkNoPreferencesActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       this.resetComponents();
    }//GEN-LAST:event_btnClearActionPerformed

    private void resetComponents() {
        this.lblMemberID.setEnabled(true);
        this.txtMemberID.setText("");
        this.txtMemberID.setEnabled(true);
        this.lblName.setEnabled(false);
        this.txtName.setText("");
        this.txtName.setEnabled(false);
        this.lblDate.setEnabled(false);
        this.jXDatePickerDate.setDate(Calendar.getInstance().getTime());
        this.jXDatePickerDate.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
        this.jXDatePickerDate.getMonthView().setLowerBound(Calendar.getInstance().getTime());
        this.jXDatePickerDate.setEnabled(false);
        this.chkLightning.setSelected(false);
        this.chkLightning.setEnabled(false);
        this.chkWeekend.setSelected(false);
        this.chkWeekend.setEnabled(false);
        this.chkNoPreferences.setSelected(false);
        this.chkNoPreferences.setEnabled(false);
        this.cmbLocation.setEnabled(false);
        this.cmbLocation.setSelectedIndex(-1);
        this.cmbSurface.setEnabled(false);
        this.cmbSurface.setSelectedIndex(-1);
        this.lblEventOrigin.setEnabled(false);
        this.cmbEventOrigin.setEnabled(false);
        this.cmbEventOrigin.setSelectedIndex(-1);
        this.lblEventType.setEnabled(false);
        this.cmbEventType.setEnabled(false);
        this.cmbEventType.setSelectedIndex(-1);
        this.lblLightning.setEnabled(false);
        this.lblWeekend.setEnabled(false);
        this.lblLocation.setEnabled(false);
        this.lblSurface.setEnabled(false);
        this.lblNoPreferences.setEnabled(false);
        this.tblTimeSlots.setEnabled(false);
        this.tblTimeSlots.setVisible(false);   
        this.btnConfirm.setEnabled(false);
        this.btnSearch.setEnabled(false);
        this.btnEvents.setEnabled(true);
        this.btnPreference.setEnabled(true);
    }

    class CustomRenderer extends DefaultTableCellRenderer     {
            private Color colorGreen = new Color(128,255,128);
            private Color colorRed = new Color(255,128,128);
            private Color colorYellow = new Color(255,255,128);
            private Color colorRedLocked = new Color(255,204,204);
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if(table.getValueAt(row, column) == enumReservationStatus.AVAILABLE ||
                      table.getValueAt(row, column) == enumReservationStatus.CANCELED){
                    cellComponent.setBackground(colorGreen);
                } 
                if(table.getValueAt(row, column) == enumReservationStatus.CANCELED){
                    cellComponent.setBackground(colorYellow);
                } 
                if(table.getValueAt(row, column) == enumReservationStatus.RESERVED){
                    cellComponent.setBackground(colorRed);
                } 
                if(table.getValueAt(row, column) == enumReservationStatus.UNAVAILABLE){
                    cellComponent.setBackground(colorRedLocked);
                }
                return cellComponent;
            }
    }
    
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnEvents;
    private javax.swing.JButton btnPreference;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox chkLightning;
    private javax.swing.JCheckBox chkNoPreferences;
    private javax.swing.JCheckBox chkWeekend;
    private javax.swing.JComboBox<String> cmbEventOrigin;
    private javax.swing.JComboBox<String> cmbEventType;
    private javax.swing.JComboBox<String> cmbLocation;
    private javax.swing.JComboBox<String> cmbSurface;
    private javax.swing.JScrollPane jScrollPaneTimeSlots;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerDate;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEventOrigin;
    private javax.swing.JLabel lblEventType;
    private javax.swing.JLabel lblLightning;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblMemberID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNoPreferences;
    private javax.swing.JLabel lblSurface;
    private javax.swing.JLabel lblWeekend;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JTable tblTimeSlots;
    private javax.swing.JTextField txtMemberID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
