/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BloodBank.Inventory.Manager;

import Business.BloodBank.BloodBankInventoryManager;
import Business.BloodBank.BloodGroup;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.BloodBankInventoryManagerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BloodBankWQ;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.apache.commons.lang.time.DateUtils;

/**
 *
 * @author JAGTAP
 */
public class BloodBankInventoryManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BloodBankInventoryManagerWorkAreaJPanel
     */
    JPanel userProcessContainer;
    UserAccount account; 
    BloodBankInventoryManagerOrganization organization; 
    Enterprise enterprise; 
    EcoSystem business;
    BloodBankInventoryManager him;
    public BloodBankInventoryManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, BloodBankInventoryManagerOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account=account;
        him=(BloodBankInventoryManager)this.account.getEmployee().getP();
        this.business=business;
        this.organization= organization;
        
        /*for(BloodBankInventoryManager him1 : organization.getListOfBloodBankInventoryManager())
        {
            if (account.getEmployee().getName().equals(him1.getName()))
            {
                him = him1;
                
            }
        }*/
        if (him.getWorkQueue() == null) {
            WorkQueue w = new WorkQueue();
            him.setWorkQueue(w);
        }
        populateCombo();
       // populateQuantity();
        populateWorkQueueTable();
        populateAvailable();
        
    }

    public void populateCombo() {
        comboVaccine.removeAllItems();
        comboVaccine.addItem("A");
        comboVaccine.addItem("B");
        comboVaccine.addItem("AB");
        comboVaccine.addItem("O");    
    }

    public void populateWorkQueueTable() {
        DefaultTableModel model = (DefaultTableModel) requestTable.getModel();

        model.setRowCount(0);
//        if(organization.getWorkQueue().getWorkRequestList().size()!=0)
            for (WorkRequest work : organization.getWorkQueue().getWorkRequestList()) {
                if (work instanceof BloodBankWQ) {
                    if((work.getStatus()=="Requested") ||
                        (work.getStatus()=="Pending" && work.getReceiver().getUsername().equals(account.getUsername())))
                    {
                        Object[] row = new Object[4];
                        row[0] = ((BloodBankWQ) work).getBloodGroup().getName();
                        row[1] = ((BloodBankWQ) work).getQuant();
                        row[2] = work;
                        row[3] = work.getReceiver();
                        //row[4] = work.getSender();
                        model.addRow(row);
                    }
                }
            }
    }

    public void populateAvailable() {
        DefaultTableModel model = (DefaultTableModel) availableTable.getModel();

        model.setRowCount(0);

        for (BloodGroup vaccine : him.getListOfBloodGroup()) {

            Object[] row = new Object[2];
            row[0] = vaccine.getName();
            row[1] = vaccine.getQuant();
            model.addRow(row);

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sellBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        availableTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable(){
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component c = super.prepareRenderer(renderer, row, col);
                BloodBankWQ p = (BloodBankWQ) getValueAt(row, 2);
                if ("Pending".equals(p.getStatus())) {
                    c.setBackground(Color.RED);
                    c.setForeground(Color.BLACK);
                } else {
                    c.setBackground(super.getBackground());
                    c.setForeground(super.getForeground());
                }
                return c;
            }
        };
        comboVaccine = new javax.swing.JComboBox();
        txtquant = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        AssignBtn = new javax.swing.JButton();
        btnComplete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Blood Bank Inventory  Manager Work Area ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        sellBtn.setText("Add Blood Group");
        sellBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellBtnActionPerformed(evt);
            }
        });
        jPanel1.add(sellBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 170, -1));

        availableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(availableTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 90));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Blood Group Requested");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 190, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Blood Groups Available");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 190, 30));

        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Blood Group", "Quantity", "Status", "Receiver"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(requestTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 90));

        jPanel1.add(comboVaccine, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 120, -1));

        txtquant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtquantActionPerformed(evt);
            }
        });
        jPanel1.add(txtquant, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 100, -1));

        jLabel2.setText("Blood Group");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 90, 20));

        backJButton.setText("Refresh");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        btnDelete.setText("Delete request");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        AssignBtn.setText("Assign To Me");
        AssignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssignBtnActionPerformed(evt);
            }
        });
        jPanel1.add(AssignBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 120, -1));

        btnComplete.setText("Complete");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 120, -1));

        jLabel3.setText("Quantity");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sellBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellBtnActionPerformed
        // TODO add your handling code here:
        try
        {
            int quant = Integer.parseInt(txtquant.getText());
            BloodGroup v = new BloodGroup();
            v.setName(String.valueOf(comboVaccine.getSelectedItem())); 
           //Vaccine v = (Vaccine) comboVaccine.getSelectedItem();
           int temp = 0;
           for (BloodGroup vaccine : him.getListOfBloodGroup()) {
               if (v.getName().equals(vaccine.getName())) {
                   temp = 1;
                   vaccine.setQuant(vaccine.getQuant() + quant);
               }
           }

           if (temp == 0) {
               BloodGroup vac = new BloodGroup();
               vac.setQuant(quant);
               //vac.setDisease(v.getDisease());
               vac.setName(v.getName());
               him.getListOfBloodGroup().add(vac);
           }
           populateAvailable();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Invalid Quantity enetered", "Error", 0);
        }
    }//GEN-LAST:event_sellBtnActionPerformed

    private void txtquantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtquantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtquantActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        new BloodBankInventoryManagerWorkAreaJPanel(userProcessContainer, account, organization, enterprise, business);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow= requestTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select the row to delete the account", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{

            WorkRequest p=(WorkRequest) requestTable.getValueAt(selectedRow, 2);

            // s.getWorkQueue().getWorkRequestList().remove(p);
            organization.getWorkQueue().getWorkRequestList().remove(p);
            account.getWorkQueue().getWorkRequestList().remove(p);
            business.getWorkQueue().getWorkRequestList().remove(p);
            JOptionPane.showMessageDialog(null, "You have successfully deleted the account");
            populateWorkQueueTable();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void AssignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssignBtnActionPerformed
        int selectedRow = requestTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            BloodBankWQ p = (BloodBankWQ) requestTable.getValueAt(selectedRow, 2);

            p.setStatus("Pending");
            p.setReceiver(account);

            populateWorkQueueTable();

        }
        //        SupplierWorkRequest request= new SupplierWorkRequest();
        //        request.setVaccine((Vaccine)comboVaccine.getSelectedItem());
        //        request.setQuantity(Integer.parseInt(txtquant.getText()));
        //        request.setStatus("Requested");
        //        request.setSender(account);
        //        //organization.getWorkQueue().getWorkRequestList().add(request);
        //        s.getWorkQueue().getWorkRequestList().add(request);
        //        populateWorkQueueTable();
    }//GEN-LAST:event_AssignBtnActionPerformed

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            BloodBankWQ p = (BloodBankWQ) requestTable.getValueAt(selectedRow, 2);

            if (p.getReceiver() != null) {
                if (p.getStatus().equals("Pending")) {
                    UserAccount a = p.getSender();
                    if (him.getListOfBloodGroup().size() <= 0) {
                        JOptionPane.showMessageDialog(null, "No Stock available. Request from Supplier");
                        return;
                    }
                    boolean f=false;
                    for (BloodGroup v : him.getListOfBloodGroup()) {
                        if (p.getBloodGroup().getName().equals(v.getName())) {
                            if (v.getQuant() - p.getQuant() < 0) {
                                JOptionPane.showMessageDialog(null, "No enough Vaccines for supply. Wait for sometime");
                                return;
                            }
                            v.setQuant(v.getQuant() - p.getQuant());
                            f=true;
                        }
                        
                    }
                    if(f==false) {
                             JOptionPane.showMessageDialog(null, "No Stock available");
                             return;
                        }
                    p.setStatus("Complete");
                    p.setResolveDate(new Date()); 
                    JOptionPane.showMessageDialog(null, "You have successfully completed the request");
                    populateWorkQueueTable();
                    populateAvailable();
                    him.getWorkQueue().getWorkRequestList().add(p);
                    /*
                    //A
                    
                    BloodBankWQ bankWQ = new BloodBankWQ();
                    BloodGroup group = new BloodGroup();
                    group.setName("A");
                    group.setQuant(40);
                    bankWQ.setBloodGroup(group);
                    bankWQ.setQuant(40);
                    Date daysAgo = DateUtils.addDays(new Date(),-10);
                    bankWQ.setResolveDate(daysAgo);
                    bankWQ.setStatus("Complete");
                    him.getWorkQueue().getWorkRequestList().add(bankWQ);
                    BloodBankWQ bankWQ1 = new BloodBankWQ();
                    BloodGroup group1 = new BloodGroup();
                    group1.setName("A");
                    group1.setQuant(100);
                    bankWQ1.setBloodGroup(group1);
                    bankWQ1.setQuant(100);
                    Date daysAgo1 = DateUtils.addDays(new Date(),-31);
                    bankWQ1.setResolveDate(daysAgo1);
                    bankWQ1.setStatus("Complete");
                    him.getWorkQueue().getWorkRequestList().add(bankWQ1);
                    
                    // B
                    
                    BloodBankWQ bankWQ2 = new BloodBankWQ();
                    BloodGroup group2 = new BloodGroup();
                    group2.setName("B");
                    group2.setQuant(50);
                    bankWQ2.setBloodGroup(group2);
                    bankWQ2.setQuant(50);
                    Date daysAgo2 = DateUtils.addDays(new Date(),-10);
                    bankWQ2.setResolveDate(daysAgo2);
                    bankWQ2.setStatus("Complete");
                    him.getWorkQueue().getWorkRequestList().add(bankWQ2);
                    BloodBankWQ bankWQ3 = new BloodBankWQ();
                    BloodGroup group3 = new BloodGroup();
                    group3.setName("B");
                    group3.setQuant(108);
                    bankWQ3.setBloodGroup(group3);
                    bankWQ3.setQuant(110);
                    Date daysAgo3 = DateUtils.addDays(new Date(),-31);
                    bankWQ3.setResolveDate(daysAgo3);
                    bankWQ3.setStatus("Complete");
                    him.getWorkQueue().getWorkRequestList().add(bankWQ3);
                    
                    //AB
                    
                    BloodBankWQ bankWQ4 = new BloodBankWQ();
                    BloodGroup group4 = new BloodGroup();
                    group4.setName("AB");
                    group4.setQuant(10);
                    bankWQ4.setBloodGroup(group4);
                    bankWQ4.setQuant(10);
                    Date daysAgo4 = DateUtils.addDays(new Date(),-10);
                    bankWQ4.setResolveDate(daysAgo4);
                    bankWQ4.setStatus("Complete");
                    him.getWorkQueue().getWorkRequestList().add(bankWQ4);
                    BloodBankWQ bankWQ5 = new BloodBankWQ();
                    BloodGroup group5 = new BloodGroup();
                    group5.setName("AB");
                    group5.setQuant(80);
                    bankWQ5.setBloodGroup(group5);
                    bankWQ5.setQuant(80);
                    Date daysAgo5 = DateUtils.addDays(new Date(),-31);
                    bankWQ5.setResolveDate(daysAgo5);
                    bankWQ5.setStatus("Complete");
                    him.getWorkQueue().getWorkRequestList().add(bankWQ5);
                    
                    //O
                    
                    BloodBankWQ bankWQ6 = new BloodBankWQ();
                    BloodGroup group6 = new BloodGroup();
                    group6.setName("O");
                    group6.setQuant(20);
                    bankWQ6.setBloodGroup(group6);
                    bankWQ6.setQuant(20);
                    Date daysAgo6 = DateUtils.addDays(new Date(),-10);
                    bankWQ6.setResolveDate(daysAgo6);
                    bankWQ6.setStatus("Complete");
                    him.getWorkQueue().getWorkRequestList().add(bankWQ6);
                    BloodBankWQ bankWQ7 = new BloodBankWQ();
                    BloodGroup group7 = new BloodGroup();
                    group7.setName("AB");
                    group7.setQuant(50);
                    bankWQ7.setBloodGroup(group7);
                    bankWQ7.setQuant(50);
                    Date daysAgo7 = DateUtils.addDays(new Date(),-31);
                    bankWQ7.setResolveDate(daysAgo7);
                    bankWQ7.setStatus("Complete");
                    him.getWorkQueue().getWorkRequestList().add(bankWQ7);*/
                    
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot complete it two times.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please assign first");
            }

        }
    }//GEN-LAST:event_btnCompleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AssignBtn;
    private javax.swing.JTable availableTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnComplete;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox comboVaccine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable requestTable;
    private javax.swing.JButton sellBtn;
    private javax.swing.JTextField txtquant;
    // End of variables declaration//GEN-END:variables
}
