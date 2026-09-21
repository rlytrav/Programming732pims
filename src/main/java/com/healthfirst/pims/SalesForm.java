/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.healthfirst.pims;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SalesForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SalesForm.class.getName());


    public SalesForm() {
        initComponents();
        loadMedicines();
    }

    private void loadMedicines() {

    cmbMedicine.removeAllItems();
    cmbMedicine.addItem("Select Medicine");

    String sql = "SELECT name FROM medicines";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            cmbMedicine.addItem(rs.getString("name"));
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

        jButton1 = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblMedicine = new javax.swing.JLabel();
        cmbMedicine = new javax.swing.JComboBox<>();
        lblQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnAddItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSaleItems = new javax.swing.JTable();
        lblTotalText = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnCompleteSale = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setText("Sales Management");

        lblMedicine.setText("Medicine:");

        cmbMedicine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMedicine.addActionListener(this::cmbMedicineActionPerformed);

        lblQuantity.setText("Quantity:");

        lblPrice.setText("Price:");

        txtPrice.addActionListener(this::txtPriceActionPerformed);

        btnAddItem.setText("Add Item");
        btnAddItem.addActionListener(this::btnAddItemActionPerformed);

        tblSaleItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Medicine", "Quantity", "Price", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(tblSaleItems);

        lblTotalText.setText("Total:");

        lblTotal.setText("R0.00");

        btnCompleteSale.setText("Complete Sale");
        btnCompleteSale.addActionListener(this::btnCompleteSaleActionPerformed);

        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);

        btnBack.setText("Back");
        btnBack.addActionListener(this::btnBackActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblMedicine)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbMedicine, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblPrice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblQuantity)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(lblTitle))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(btnAddItem))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTotalText)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTotal))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCompleteSale)
                                        .addGap(39, 39, 39)
                                        .addComponent(btnClear)
                                        .addGap(38, 38, 38)
                                        .addComponent(btnBack)))))
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMedicine)
                    .addComponent(cmbMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(btnAddItem)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalText)
                    .addComponent(lblTotal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompleteSale)
                    .addComponent(btnClear)
                    .addComponent(btnBack))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void cmbMedicineActionPerformed(java.awt.event.ActionEvent evt) {                                            
            String selectedMedicine = (String) cmbMedicine.getSelectedItem();

    if (selectedMedicine == null || selectedMedicine.equals("Select Medicine")) {
        txtPrice.setText("");
        return;
    }

    String sql = "SELECT price FROM medicines WHERE name = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, selectedMedicine);

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                txtPrice.setText(rs.getString("price"));
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
                this,
                "Error loading price: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }                                           

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String medicine = (String) cmbMedicine.getSelectedItem();
    String quantityText = txtQuantity.getText().trim();
    String priceText = txtPrice.getText().trim();

    if (medicine == null || medicine.equals("Select Medicine")) {
        JOptionPane.showMessageDialog(this, "Please select a medicine.");
        return;
    }

    if (quantityText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a quantity.");
        return;
    }

    try {
        int quantity = Integer.parseInt(quantityText);
        double price = Double.parseDouble(priceText);

        if (quantity <= 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Quantity must be greater than 0."
            );
            return;
        }

        double subtotal = quantity * price;

        DefaultTableModel model =
                (DefaultTableModel) tblSaleItems.getModel();

        model.addRow(new Object[]{
            medicine,
            quantity,
            String.format("%.2f", price),
            String.format("%.2f", subtotal)
        });

        updateTotal();

        cmbMedicine.setSelectedIndex(0);
        txtQuantity.setText("");
        txtPrice.setText("");

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
                this,
                "Please enter a valid quantity.",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }                                          

    private void btnCompleteSaleActionPerformed(java.awt.event.ActionEvent evt) {                                                
        DefaultTableModel model =
        (DefaultTableModel) tblSaleItems.getModel();

    if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(
                this,
                "Please add at least one medicine before completing the sale."
        );
        return;
    }

    Connection conn = null;

    try {
        conn = DatabaseConnection.getConnection();
        conn.setAutoCommit(false);

    double total = 0.0;

    for (int i = 0; i < model.getRowCount(); i++) {

        Object subtotalValue = model.getValueAt(i, 3);

        if (subtotalValue != null &&
                !subtotalValue.toString().trim().isEmpty()) {

            String subtotalText =
                    subtotalValue.toString().replace(",", ".");

            total += Double.parseDouble(subtotalText);
        }
    }

    String saleSql =
            "INSERT INTO sales (total_amount) VALUES (?)";

    PreparedStatement salePst = conn.prepareStatement(
            saleSql,
            Statement.RETURN_GENERATED_KEYS
    );

    salePst.setDouble(1, total);
    salePst.executeUpdate();

    ResultSet generatedKeys = salePst.getGeneratedKeys();

    if (!generatedKeys.next()) {
        throw new SQLException("Could not retrieve sale ID.");
    }

    int saleId = generatedKeys.getInt(1);
    
    String itemSql =
            "INSERT INTO sale_items "
            + "(sale_id, medicine_id, quantity_sold, price_at_sale) "
            + "VALUES (?, ?, ?, ?)";

    for (int i = 0; i < model.getRowCount(); i++) {
        Object medicineValue = model.getValueAt(i, 0);

    if (medicineValue == null || medicineValue.toString().trim().isEmpty()) {
    continue;
    }
        String medicineName = medicineValue.toString();
        int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
        double price = Double.parseDouble(model.getValueAt(i, 2).toString().replace(",","."));

        String medicineSql =
                "SELECT medicine_id FROM medicines WHERE name = ?";

        try (PreparedStatement medicinePst =
                conn.prepareStatement(medicineSql)) {

            medicinePst.setString(1, medicineName);

            try (ResultSet medicineRs = medicinePst.executeQuery()) {

                if (!medicineRs.next()) {
                    throw new SQLException(
                            "Medicine not found: " + medicineName
                    );
                }

                int medicineId = medicineRs.getInt("medicine_id");

                try (PreparedStatement itemPst =
                        conn.prepareStatement(itemSql)) {

                    itemPst.setInt(1, saleId);
                    itemPst.setInt(2, medicineId);
                    itemPst.setInt(3, quantity);
                    itemPst.setDouble(4, price);

                    itemPst.executeUpdate();
                }
                String updateStockSql =
        "UPDATE medicines "
        + "SET quantity_in_stock = quantity_in_stock - ? "
        + "WHERE medicine_id = ? AND quantity_in_stock >= ?";

        try (PreparedStatement stockPst =
                conn.prepareStatement(updateStockSql)) {

            stockPst.setInt(1, quantity);
            stockPst.setInt(2, medicineId);
            stockPst.setInt(3, quantity);

            int rowsUpdated = stockPst.executeUpdate();

            if (rowsUpdated == 0) {
                throw new SQLException(
                        "Not enough stock for: " + medicineName
                );
            }
        }
            }
        }
    }

    JOptionPane.showMessageDialog(
            this,
            "Sale completed successfully!\n"
            + "Sale ID: " + saleId
            + "\nTotal: R" + String.format("%.2f", total)
    );

    conn.commit();

} catch (Exception e) {

    try {
        if (conn != null) {
            conn.rollback();
        }
    } catch (SQLException rollbackError) {
        rollbackError.printStackTrace();
    }

    JOptionPane.showMessageDialog(
            this,
            "Error completing sale: " + e.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
    );

    e.printStackTrace();

} finally {

    try {
        if (conn != null) {
            conn.setAutoCommit(true);
            conn.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    }                                               

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {                                         
        DefaultTableModel model =
        (DefaultTableModel) tblSaleItems.getModel();

    model.setRowCount(0);

    cmbMedicine.setSelectedIndex(0);
    txtQuantity.setText("");
    txtPrice.setText("");
    lblTotal.setText("Total: R0.00");
    }                                        

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                        
        AdminDashboard dashboard = new AdminDashboard();
    dashboard.setVisible(true);
    this.dispose();
    }                                       
 private void updateTotal() {
    DefaultTableModel model =
            (DefaultTableModel) tblSaleItems.getModel();

    double total = 0.0;

    for (int i = 0; i < model.getRowCount(); i++) {
        Object value = model.getValueAt(i, 3);

        if (value != null && !value.toString().trim().isEmpty()) {
            total += Double.parseDouble(value.toString().replace(",","."));
        }
    }

    lblTotal.setText("R" + String.format("%.2f", total));
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
        java.awt.EventQueue.invokeLater(() -> new SalesForm().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCompleteSale;
    private javax.swing.JComboBox<String> cmbMedicine;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMedicine;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalText;
    private javax.swing.JTable tblSaleItems;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration                   
}
