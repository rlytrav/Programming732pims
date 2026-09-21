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

public class Usermanagement extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Usermanagement.class.getName());

    /**
     * Creates new form Usermanagement
     */
    public Usermanagement() {
        initComponents();
        loadUsers();
    }
    private void loadUsers() {

    DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();
    model.setRowCount(0);

    String sql = "SELECT user_id, full_name, username, role FROM users";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("user_id"),
                rs.getString("full_name"),
                rs.getString("username"),
                rs.getString("role")
            });
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Error loading users: " + e.getMessage());
    }
 }
    private void clearFields() {
    txtFullName.setText("");
    txtUsername.setText("");
    txtPassword.setText("");
    cmbRole.setSelectedIndex(0);
    tblUsers.clearSelection();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbRole = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        btnAddUser = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("HealthFirst User Management");

        jLabel2.setText("Full Name:");

        jLabel3.setText("Username:");

        jLabel4.setText("Password:");

        jLabel5.setText("Role:");

        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Cashier" }));

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Full Name", "Username", "Role"
            }
        ));
        tblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsers);

        btnAddUser.setText("Add User");
        btnAddUser.addActionListener(this::btnAddUserActionPerformed);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);

        btnBack.setText("Back");
        btnBack.addActionListener(this::btnBackActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(btnAddUser)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPassword))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtUsername))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnBack)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddUser)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack)
                .addGap(104, 104, 104))
        );

        pack();
    }// </editor-fold>                        

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String fullName = txtFullName.getText().trim();
String username = txtUsername.getText().trim();
String password = txtPassword.getText().trim();
String role = cmbRole.getSelectedItem().toString();

if (fullName.isEmpty() || username.isEmpty() || password.isEmpty()) {
    JOptionPane.showMessageDialog(this,
            "Please complete all fields.");
    return;
}

String sql = "INSERT INTO users (username, password, role, full_name) "
           + "VALUES (?, ?, ?, ?)";

try (Connection conn = DatabaseConnection.getConnection();
     PreparedStatement pst = conn.prepareStatement(sql)) {

    pst.setString(1, username);
    pst.setString(2, password);
    pst.setString(3, role);
    pst.setString(4, fullName);

    pst.executeUpdate();

    JOptionPane.showMessageDialog(this,
            "User added successfully.");

    clearFields();
    loadUsers();

} catch (SQLException e) {
    JOptionPane.showMessageDialog(this,
            "Error adding user: " + e.getMessage());
}
    }                                          

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int row = tblUsers.getSelectedRow();

if (row == -1) {
    JOptionPane.showMessageDialog(this,
            "Please select a user from the table first.");
    return;
}

int userId = Integer.parseInt(
        tblUsers.getValueAt(row, 0).toString()
);

String fullName = txtFullName.getText().trim();
String username = txtUsername.getText().trim();
String password = txtPassword.getText().trim();
String role = cmbRole.getSelectedItem().toString();

if (fullName.isEmpty() || username.isEmpty()) {
    JOptionPane.showMessageDialog(this,
            "Full Name and Username are required.");
    return;
}

try (Connection conn = DatabaseConnection.getConnection()) {

    if (password.isEmpty()) {

        String sql = "UPDATE users "
                + "SET full_name = ?, username = ?, role = ? "
                + "WHERE user_id = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, fullName);
            pst.setString(2, username);
            pst.setString(3, role);
            pst.setInt(4, userId);

            pst.executeUpdate();
        }

    } else {

        String sql = "UPDATE users "
                + "SET full_name = ?, username = ?, password = ?, role = ? "
                + "WHERE user_id = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, fullName);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.setString(4, role);
            pst.setInt(5, userId);

            pst.executeUpdate();
        }
    }

    JOptionPane.showMessageDialog(this,
            "User updated successfully.");

    clearFields();
    loadUsers();

} catch (SQLException e) {

    JOptionPane.showMessageDialog(this,
            "Error updating user: " + e.getMessage());
}
    }                                         

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {                                         
        clearFields();
    }                                        

    private void tblUsersMouseClicked(java.awt.event.MouseEvent evt) {                                      
        int row = tblUsers.getSelectedRow();

if (row != -1) {
    txtFullName.setText(tblUsers.getValueAt(row, 1).toString());
    txtUsername.setText(tblUsers.getValueAt(row, 2).toString());
    txtPassword.setText("");
    cmbRole.setSelectedItem(tblUsers.getValueAt(row, 3).toString());
}
    }                                     

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int row = tblUsers.getSelectedRow();

if (row == -1) {
    JOptionPane.showMessageDialog(this,
            "Please select a user from the table first.");
    return;
}

int userId = Integer.parseInt(
        tblUsers.getValueAt(row, 0).toString()
);

String username = tblUsers.getValueAt(row, 2).toString();

int choice = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to delete " + username + "?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION
);

if (choice != JOptionPane.YES_OPTION) {
    return;
}

String sql = "DELETE FROM users WHERE user_id = ?";

try (Connection conn = DatabaseConnection.getConnection();
     PreparedStatement pst = conn.prepareStatement(sql)) {

    pst.setInt(1, userId);
    pst.executeUpdate();

    JOptionPane.showMessageDialog(this,
            "User deleted successfully.");

    clearFields();
    loadUsers();

} catch (SQLException e) {

    JOptionPane.showMessageDialog(this,
            "Error deleting user: " + e.getMessage());
}
    }                                         

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                        
        AdminDashboard dashboard = new AdminDashboard();
dashboard.setLocationRelativeTo(null);
dashboard.setVisible(true);
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
        java.awt.EventQueue.invokeLater(() -> new Usermanagement().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration                   
}
