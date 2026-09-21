/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.healthfirst.pims;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class MedicineForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MedicineForm.class.getName());

    /**
     * Creates new form MedicineForm
     */
    public MedicineForm() {
        initComponents();
        loadMedicines();
        setLocationRelativeTo(null);
    }
    private void loadMedicines() {

    DefaultTableModel model =
            (DefaultTableModel) tblMedicines.getModel();

    model.setRowCount(0);

    String sql = "SELECT * FROM medicines";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {

            Object[] row = {
                rs.getInt("medicine_id"),
                rs.getString("name"),
                rs.getString("company"),
                rs.getString("medicine_type"),
                rs.getDouble("price"),
                rs.getInt("quantity_in_stock"),
                rs.getInt("reorder_level"),
                rs.getDate("expiry_date"),
                rs.getInt("supplier_id")
            };

            model.addRow(row);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error loading medicines: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCompany = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtReorderLevel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtExpiryDate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSupplierId = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicines = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Medicine Management");

        jLabel2.setText("Name:");

        jLabel3.setText("Company:");

        jLabel4.setText("Medicine type:");

        txtCompany.addActionListener(this::txtCompanyActionPerformed);

        jLabel5.setText("Price:");

        jLabel6.setText("Quantity in stock:");

        jLabel7.setText("Reoder Level:");

        jLabel8.setText("Expiry date:");

        txtExpiryDate.addActionListener(this::txtExpiryDateActionPerformed);

        jLabel9.setText("Supplier ID:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(this::btnAddActionPerformed);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);

        btnBack.setText("Back");
        btnBack.addActionListener(this::btnBackActionPerformed);

        tblMedicines.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Company", "Type", "Price", "Quantity", "Reorder Level", "Expiry Date", "Supplier ID"
            }
        ));
        tblMedicines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMedicinesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMedicines);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtReorderLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSupplierId))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCompany)))
                                .addGap(122, 122, 122))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtName))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(270, 270, 270))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtReorderLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSupplierId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void txtCompanyActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        try {
    String name = txtName.getText().trim();
    String company = txtCompany.getText().trim();
    String medicineType = txtType.getText().trim();
    double price = Double.parseDouble(txtPrice.getText().trim());
    int quantity = Integer.parseInt(txtQuantity.getText().trim());
    int reorderLevel = Integer.parseInt(txtReorderLevel.getText().trim());
    String expiryDate = txtExpiryDate.getText().trim();
    int supplierId = Integer.parseInt(txtSupplierId.getText().trim());

    String sql = "INSERT INTO medicines "
            + "(name, company, medicine_type, price, quantity_in_stock, "
            + "reorder_level, expiry_date, supplier_id) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, name);
        pst.setString(2, company);
        pst.setString(3, medicineType);
        pst.setDouble(4, price);
        pst.setInt(5, quantity);
        pst.setInt(6, reorderLevel);
        pst.setDate(7, java.sql.Date.valueOf(expiryDate));
        pst.setInt(8, supplierId);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(
                this,
                "Medicine added successfully!"
        );

        loadMedicines();
    }

} catch (NumberFormatException e) {

    JOptionPane.showMessageDialog(
            this,
            "Price, quantity, reorder level and supplier ID must be valid numbers.",
            "Input Error",
            JOptionPane.ERROR_MESSAGE
    );

} catch (IllegalArgumentException e) {

    JOptionPane.showMessageDialog(
            this,
            "Expiry date must be entered as YYYY-MM-DD.",
            "Date Error",
            JOptionPane.ERROR_MESSAGE
    );

} catch (SQLException e) {

    JOptionPane.showMessageDialog(
            this,
            "Error adding medicine: " + e.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
    );
}
    }                                      

    private void tblMedicinesMouseClicked(java.awt.event.MouseEvent evt) {                                          
        int selectedRow = tblMedicines.getSelectedRow();

if (selectedRow != -1) {
    txtName.setText(tblMedicines.getValueAt(selectedRow, 1).toString());
    txtCompany.setText(tblMedicines.getValueAt(selectedRow, 2).toString());
    txtType.setText(tblMedicines.getValueAt(selectedRow, 3).toString());
    txtPrice.setText(tblMedicines.getValueAt(selectedRow, 4).toString());
    txtQuantity.setText(tblMedicines.getValueAt(selectedRow, 5).toString());
    txtReorderLevel.setText(tblMedicines.getValueAt(selectedRow, 6).toString());
    txtExpiryDate.setText(tblMedicines.getValueAt(selectedRow, 7).toString());
    txtSupplierId.setText(tblMedicines.getValueAt(selectedRow, 8).toString());
}
    }                                         

    private void txtExpiryDateActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
       int selectedRow = tblMedicines.getSelectedRow();

if (selectedRow == -1) {
    JOptionPane.showMessageDialog(
        this,
        "Please select a medicine to update.",
        "No Medicine Selected",
        JOptionPane.WARNING_MESSAGE
    );
    return;
}

try {
    int medicineId = Integer.parseInt(
        tblMedicines.getValueAt(selectedRow, 0).toString()
    );

    String name = txtName.getText().trim();
    String company = txtCompany.getText().trim();
    String medicineType = txtType.getText().trim();
    double price = Double.parseDouble(txtPrice.getText().trim());
    int quantity = Integer.parseInt(txtQuantity.getText().trim());
    int reorderLevel = Integer.parseInt(txtReorderLevel.getText().trim());
    String expiryDate = txtExpiryDate.getText().trim();
    int supplierId = Integer.parseInt(txtSupplierId.getText().trim());

    String sql = "UPDATE medicines SET "
            + "name = ?, company = ?, medicine_type = ?, price = ?, "
            + "quantity_in_stock = ?, reorder_level = ?, expiry_date = ?, "
            + "supplier_id = ? WHERE medicine_id = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, name);
        pst.setString(2, company);
        pst.setString(3, medicineType);
        pst.setDouble(4, price);
        pst.setInt(5, quantity);
        pst.setInt(6, reorderLevel);
        pst.setString(7, expiryDate);
        pst.setInt(8, supplierId);
        pst.setInt(9, medicineId);

        int rowsUpdated = pst.executeUpdate();

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(
                this,
                "Medicine updated successfully!"
            );

            loadMedicines();
        }
    }

} catch (NumberFormatException e) {

    JOptionPane.showMessageDialog(
        this,
        "Price, quantity, reorder level and supplier ID must be valid numbers.",
        "Input Error",
        JOptionPane.ERROR_MESSAGE
    );

} catch (SQLException e) {

    JOptionPane.showMessageDialog(
        this,
        "Error updating medicine: " + e.getMessage(),
        "Database Error",
        JOptionPane.ERROR_MESSAGE
    );
}
    }                                         

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
       int selectedRow = tblMedicines.getSelectedRow();

if (selectedRow == -1) {
    JOptionPane.showMessageDialog(
        this,
        "Please select a medicine to delete.",
        "No Medicine Selected",
        JOptionPane.WARNING_MESSAGE
    );
    return;
}

int medicineId = Integer.parseInt(
        tblMedicines.getValueAt(selectedRow, 0).toString()
);

int confirm = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to delete this medicine?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION
);

if (confirm == JOptionPane.YES_OPTION) {

    String sql = "DELETE FROM medicines WHERE medicine_id = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setInt(1, medicineId);

        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(
                this,
                "Medicine deleted successfully!"
            );

            loadMedicines();

            txtName.setText("");
            txtCompany.setText("");
            txtType.setText("");
            txtPrice.setText("");
            txtQuantity.setText("");
            txtReorderLevel.setText("");
            txtExpiryDate.setText("");
            txtSupplierId.setText("");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this,
            "Error deleting medicine: " + e.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
}
    }                                         

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {                                         
        txtName.setText("");
txtCompany.setText("");
txtType.setText("");
txtPrice.setText("");
txtQuantity.setText("");
txtReorderLevel.setText("");
txtExpiryDate.setText("");
txtSupplierId.setText("");

tblMedicines.clearSelection();

txtName.requestFocus();
    }                                        

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                        
         new AdminDashboard().setVisible(true);
    this.dispose();
    }                                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MedicineForm().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMedicines;
    private javax.swing.JTextField txtCompany;
    private javax.swing.JTextField txtExpiryDate;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtReorderLevel;
    private javax.swing.JTextField txtSupplierId;
    private javax.swing.JTextField txtType;
    // End of variables declaration                   
}
