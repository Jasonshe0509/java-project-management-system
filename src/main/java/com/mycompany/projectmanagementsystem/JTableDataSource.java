/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectmanagementsystem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author user
 */
public class JTableDataSource implements JRDataSource {

    private JTable table;
    private int rowIndex = -1;

    public JTableDataSource(JTable table) {
        this.table = table;
    }

    @Override
    public boolean next() throws JRException {
        rowIndex++;
        return rowIndex < table.getRowCount();
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        String fieldName = jrField.getName();
        TableModel model = table.getModel();
        int columnIndex = getColumnIndexByName(model, fieldName);

        if (columnIndex >= 0 && rowIndex >= 0) {
            return model.getValueAt(rowIndex, columnIndex);
        }

        return null;
    }

    private int getColumnIndexByName(TableModel model, String columnName) {
        for (int i = 0; i < model.getColumnCount(); i++) {
            if (model.getColumnName(i).equals(columnName)) {
                return i;
            }
        }
        return -1; // Column not found
    }
}
