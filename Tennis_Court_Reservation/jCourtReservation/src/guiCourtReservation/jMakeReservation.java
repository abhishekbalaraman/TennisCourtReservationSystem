/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiCourtReservation;

import domainCourtReservation.enumReservationStatus;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Paulo Garcez Vieira
 */
public class jMakeReservation {
    
    /****** Atributes ******/
    private static final String firstcolumnName = "Hour";
       
    /****** Methods ******/
    
    
    public static void setUpColumnSpots(JTable table, int numColumns, String[] colIdentifier) {
        
        JComboBox comboBox = new JComboBox();
        comboBox.addItem(enumReservationStatus.RESERVED);
               
        TableColumn column;
        for (int j = 1; j < numColumns; j++) {
            column = table.getColumn(colIdentifier[j]);
            column.setCellEditor(new DefaultCellEditor(comboBox));
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setToolTipText("Click for combo box");
            column.setCellRenderer(renderer);
        }
    }
    
    public static String[] getColumnNames(int[] courtsMatched)  {
        String[] arrayCol = new String[courtsMatched.length + 1];
        arrayCol[0] = firstcolumnName;
        for (int i = 0; i < courtsMatched.length; i++) {
            arrayCol[i+1] = "Court " + Integer.toString(courtsMatched[i]);
        }
        return arrayCol;
    }
    
}
