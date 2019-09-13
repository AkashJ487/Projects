/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JPanel;
import Business.*;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
/**
 *
 * @author JAGTAP
 */
public class AdminWorkAreaPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminWorkAreaPanel
     */
    private Business business;
    private UserAccount userAccount;
    private JPanel cardSequenceJPanel;
    public AdminWorkAreaPanel(Business business,JPanel cardSequenceJPanel, UserAccount userAccount) {
        initComponents();
        this.business=business;
        this.cardSequenceJPanel=cardSequenceJPanel;
        this.userAccount=userAccount;
        this.userAccount.setCount(0);
        reload();
    }
     public void reload()
    {
        userNameTextField.setText(userAccount.getUserName());
        nameTextField.setText(userAccount.getPerson().getName());
        roleTextField.setText(userAccount.getRole());
        if(userAccount.getPassword()=="pass".hashCode())
        {
            JOptionPane.showMessageDialog(null, "Please change your default password");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        roleTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mmoButton = new javax.swing.JButton();
        mspButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        manageSuppButton = new javax.swing.JButton();
        manageSalesPersonButton = new javax.swing.JButton();
        changePwdButton1 = new javax.swing.JButton();

        jLabel1.setText("username");

        jLabel2.setText("Name ");

        jLabel3.setText("Role");

        userNameTextField.setEnabled(false);
        userNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTextFieldActionPerformed(evt);
            }
        });

        nameTextField.setEnabled(false);
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        roleTextField.setEnabled(false);
        roleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Admin Work Area");

        mmoButton.setText("Manage Market Offers");
        mmoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmoButtonActionPerformed(evt);
            }
        });

        mspButton.setText("Monitor Sales performance");
        mspButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mspButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        manageSuppButton.setText("Manage Supplier");
        manageSuppButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageSuppButtonActionPerformed(evt);
            }
        });

        manageSalesPersonButton.setText("Manage Sales Person");
        manageSalesPersonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageSalesPersonButtonActionPerformed(evt);
            }
        });

        changePwdButton1.setText("Change Password");
        changePwdButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePwdButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameTextField)
                            .addComponent(userNameTextField)
                            .addComponent(roleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(changePwdButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(manageSalesPersonButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(manageSuppButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mspButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mmoButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(roleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(mmoButton)
                .addGap(18, 18, 18)
                .addComponent(mspButton)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addGap(18, 18, 18)
                .addComponent(manageSuppButton)
                .addGap(18, 18, 18)
                .addComponent(manageSalesPersonButton)
                .addGap(18, 18, 18)
                .addComponent(changePwdButton1)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void mmoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmoButtonActionPerformed
        // TODO add your handling code here:
        ManageMarketOffersPanel manageMarketOffersPanel = new ManageMarketOffersPanel(business,cardSequenceJPanel);
        cardSequenceJPanel.add("ManageMarketOffers",manageMarketOffersPanel);
        CardLayout cardLayout = (CardLayout) cardSequenceJPanel.getLayout();
        cardLayout.next(cardSequenceJPanel);
    }//GEN-LAST:event_mmoButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        Component component = cardSequenceJPanel.getComponent((cardSequenceJPanel.getComponentCount()-2));
        LoginPanel loginPanel = (LoginPanel) component;
        loginPanel.reset();
        cardSequenceJPanel.remove(this);
        CardLayout cardLayout = (CardLayout) cardSequenceJPanel.getLayout();
        cardLayout.previous(cardSequenceJPanel);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void mspButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mspButtonActionPerformed
        // TODO add your handling code here:
        MonitorSalesPerformancePanel monitorSalesPerformancePanel = new MonitorSalesPerformancePanel(business, cardSequenceJPanel);
        cardSequenceJPanel.add("MonitorSalesPerformance",monitorSalesPerformancePanel);
        CardLayout cardLayout = (CardLayout) cardSequenceJPanel.getLayout();
        cardLayout.next(cardSequenceJPanel);
    }//GEN-LAST:event_mspButtonActionPerformed

    private void manageSuppButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageSuppButtonActionPerformed
        // TODO add your handling code here:
        ManageSupplierPanel manageSupplierPanel = new ManageSupplierPanel(business, cardSequenceJPanel);
        cardSequenceJPanel.add("ManageSupplier",manageSupplierPanel);
        CardLayout cardLayout = (CardLayout) cardSequenceJPanel.getLayout();
        cardLayout.next(cardSequenceJPanel);
    }//GEN-LAST:event_manageSuppButtonActionPerformed

    private void manageSalesPersonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageSalesPersonButtonActionPerformed
        // TODO add your handling code here:
        ManageSalesPersonPanel manageSalesPersonPanel = new ManageSalesPersonPanel(business, cardSequenceJPanel);
        cardSequenceJPanel.add("ManageSalesPerson",manageSalesPersonPanel);
        CardLayout cardLayout = (CardLayout) cardSequenceJPanel.getLayout();
        cardLayout.next(cardSequenceJPanel);
    }//GEN-LAST:event_manageSalesPersonButtonActionPerformed

    private void changePwdButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePwdButton1ActionPerformed
        // TODO add your handling code here:
        ChangePasswordPanel changePasswordPanel=new ChangePasswordPanel(userAccount,cardSequenceJPanel);
        cardSequenceJPanel.add("ChangePassword",changePasswordPanel);
        CardLayout cardLayout=(CardLayout)cardSequenceJPanel.getLayout();
        cardLayout.next(cardSequenceJPanel);
    }//GEN-LAST:event_changePwdButton1ActionPerformed

    private void userNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTextFieldActionPerformed

    private void roleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changePwdButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageSalesPersonButton;
    private javax.swing.JButton manageSuppButton;
    private javax.swing.JButton mmoButton;
    private javax.swing.JButton mspButton;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField roleTextField;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables
}
