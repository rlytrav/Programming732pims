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

public class BillForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BillForm.class.getName());
    
    private int saleId;
    public BillForm () {
        initComponents();
    }
    public BillForm(int saleiId) {
        initComponents();
        this.saleId = saleId;
        setLocationRelativeTo(null);
        loadBill();
    }
    public BillForm(String billDetails) {
    initComponents();
    setLocationRelativeTo(null);
    loadBill();

    txtBill.setText(billDetails);
    txtBill.setCaretPosition(0);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtBill = new javax.swing.JTextArea();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtBill.setEditable(false);
        txtBill.setColumns(15);
        txtBill.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        txtBill.setRows(7);
        jScrollPane1.setViewportView(txtBill);

        btnClose.setText("Close");
        btnClose.addActionListener(this::btnCloseActionPerformed);

        jLabel1.setText("HealthFirst Bill");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(btnClose))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose))
        );

        pack();
    }// </editor-fold>                        

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.dispose();
    }                                        

private void loadBill() {

    StringBuilder bill = new StringBuilder();

    bill.append("          HEALTHFIRST PHARMACY\n");
    bill.append("====================================\n");
    bill.append("Sale ID: ").append(saleId).append("\n");

    String saleSql =
            "SELECT sale_date, total_amount FROM sales WHERE sale_id = ?";

    String itemSql =
            "SELECT m.name, si.quantity_sold, si.price_at_sale "
            + "FROM sale_items si "
            + "JOIN medicines m ON si.medicine_id = m.medicine_id "
            + "WHERE si.sale_id = ?";

    try (Connection conn = DatabaseConnection.getConnection()) {

        try (PreparedStatement pst = conn.prepareStatement(saleSql)) {
            pst.setInt(1, saleId);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    bill.append("Date: ")
                            .append(rs.getTimestamp("sale_date"))
                            .append("\n");

                    bill.append("====================================\n");
                    bill.append("ITEMS\n");
                    bill.append("------------------------------------\n");
                }
            }
        }

        try (PreparedStatement pst = conn.prepareStatement(itemSql)) {
            pst.setInt(1, saleId);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {

                    String name = rs.getString("name");
                    int quantity = rs.getInt("quantity_sold");
                    double price = rs.getDouble("price_at_sale");

                    bill.append(name)
                            .append("   ")
                            .append(quantity)
                            .append(" x R")
                            .append(String.format("%.2f", price))
                            .append("\n");
                }
            }
        }

        try (PreparedStatement pst = conn.prepareStatement(saleSql)) {
            pst.setInt(1, saleId);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    bill.append("------------------------------------\n");
                    bill.append("TOTAL: R")
                            .append(String.format("%.2f",
                                    rs.getDouble("total_amount")))
                            .append("\n");
                }
            }
        }

        bill.append("====================================\n");
        bill.append("Thank you for shopping with us!\n");

        txtBill.setText(bill.toString());

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
                this,
                "Error loading bill: " + e.getMessage(),
                "Bill Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
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
        java.awt.EventQueue.invokeLater(() -> new BillForm().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtBill;
    // End of variables declaration                   
}
