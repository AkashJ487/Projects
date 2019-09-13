/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.*;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author JAGTAP
 */
public class SupplierWorkAreaPanel extends javax.swing.JPanel {

    /**
     * Creates new form SupplierWorkAreaPanel
     */
    private Business business;
    private UserAccount userAccount;
    private JPanel cardSequenceJPanel;
    private Supplier supplier;
    public SupplierWorkAreaPanel(Business business,JPanel cardSequenceJPanel, UserAccount userAccount) {
        initComponents();
        this.business=business;
        this.cardSequenceJPanel=cardSequenceJPanel;
        this.userAccount=userAccount;
        this.userAccount.setCount(0);
        reload();
        supplier=IdentifySupplier();
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
    private Supplier IdentifySupplier()
    {
        for(Supplier sp:business.getSupplierDirectory().getListOfSuppliers())
        {
            if((sp.getUserAccount().getUserName().equals(userAccount.getUserName())) &&
                (sp.getUserAccount().getPassword()==userAccount.getPassword()))
            {
                SupplierTextField.setText(sp.getName());
                return sp;
            }
        }        
        return null;
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
        jLabel5 = new javax.swing.JLabel();
        SupplierTextField = new javax.swing.JTextField();
        logoutButton = new javax.swing.JButton();
        manageProductButton = new javax.swing.JButton();
        changePwdButton2 = new javax.swing.JButton();

        jLabel1.setText("username");

        jLabel2.setText("Name ");

        jLabel3.setText("Role");

        userNameTextField.setEnabled(false);

        nameTextField.setEnabled(false);
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        roleTextField.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Supplier Work Area");

        jLabel5.setText("Supplier");

        SupplierTextField.setEnabled(false);
        SupplierTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierTextFieldActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        manageProductButton.setText("Manage Products");
        manageProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageProductButtonActionPerformed(evt);
            }
        });

        changePwdButton2.setText("Change Password");
        changePwdButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePwdButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(manageProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameTextField)
                            .addComponent(userNameTextField)
                            .addComponent(roleTextField)
                            .addComponent(SupplierTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(changePwdButton2)
                            .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(SupplierTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(manageProductButton)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addGap(18, 18, 18)
                .addComponent(changePwdButton2)
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void SupplierTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupplierTextFieldActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        Component component = cardSequenceJPanel.getComponent((cardSequenceJPanel.getComponentCount()-2));
        LoginPanel loginPanel = (LoginPanel) component;
        loginPanel.reset();
        cardSequenceJPanel.remove(this);
        CardLayout cardLayout = (CardLayout) cardSequenceJPanel.getLayout();
        cardLayout.previous(cardSequenceJPanel);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void manageProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageProductButtonActionPerformed
        // TODO add your handling code here:
        ManageProductPanel manageProductPanel = new ManageProductPanel(business,cardSequenceJPanel,supplier);
        cardSequenceJPanel.add("ManageProduct",manageProductPanel);
        CardLayout cardLayout=(CardLayout)cardSequenceJPanel.getLayout();
        cardLayout.next(cardSequenceJPanel);
    }//GEN-LAST:event_manageProductButtonActionPerformed

    private void changePwdButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePwdButton2ActionPerformed
        // TODO add your handling code here:
        ChangePasswordPanel changePasswordPanel=new ChangePasswordPanel(userAccount,cardSequenceJPanel);
        cardSequenceJPanel.add("ChangePassword",changePasswordPanel);
        CardLayout cardLayout=(CardLayout)cardSequenceJPanel.getLayout();
        cardLayout.next(cardSequenceJPanel);
    }//GEN-LAST:event_changePwdButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SupplierTextField;
    private javax.swing.JButton changePwdButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageProductButton;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField roleTextField;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables
}