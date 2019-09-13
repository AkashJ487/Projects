/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Hospital.Inventory.Manager;

import Business.BloodBank.BloodBankInventoryManager;
import Business.BloodBank.BloodGroup;
import Business.EcoSystem;
import Business.Enterprise.BloodBankEnterprise;
import Business.Enterprise.Enterprise;
import Business.Hospital.HospitalInventoryManager;
import Business.Network.Network;
import Business.Organization.BloodBankInventoryManagerOrganization;
import Business.Organization.HospInventoryManagerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BloodBankWQ;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAGTAP
 */
public class HospInventoryManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HospInventoryManagerWorkAreaJPanel
     */
    JPanel userProcessContainer;
    UserAccount account; 
    HospInventoryManagerOrganization organization; 
    Enterprise enterprise; 
    EcoSystem business;
    HospitalInventoryManager him;
    public HospInventoryManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, HospInventoryManagerOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account=account;
        this.business=business;
        this.organization= organization;
        him = (HospitalInventoryManager) account.getEmployee().getP();
        /*for(HospitalInventoryManager him1 : organization.getListOfHospitalInventoryManager())
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
        //populateComboBloodBank();
        populateQuantity();
        populateWorkQueueTable();
        populateAvailable();
    }

    /*public void populateComboBloodBank(){
        comboBloodBank.removeAllItems();
        for (Network network : business.getNetworkList())
            for(Enterprise enterprise1 : network.getEnterpriseDirectory().getEnterpriseList())
                if(enterprise1.getEnterpriseType() == Enterprise.EnterpriseType.BloodBank)
                {
                    for (Organization organization1 : enterprise1.getOrganizationDirectory().getOrganizationList()) {
                         if(organization1 instanceof BloodBankInventoryManagerOrganization){
                             BloodBankInventoryManagerOrganization s= (BloodBankInventoryManagerOrganization) organization1;
                             for (BloodBankInventoryManager supplier : s.getListOfBloodBankInventoryManager()) {
                                 comboBloodBank.addItem(supplier);
                             }

                         }
                     }   
                }
    }*/
    public void populateCombo(){
        comboVaccine.removeAllItems();
        comboVaccine.addItem("A");
        comboVaccine.addItem("B");
        comboVaccine.addItem("AB");
        comboVaccine.addItem("O");    
    }
    public void populateWorkQueueTable(){
         DefaultTableModel model = (DefaultTableModel) requestTable.getModel();
        
        model.setRowCount(0);
        
        for (WorkRequest work : him.getWorkQueue().getWorkRequestList()){
           if((work instanceof BloodBankWQ) && (!work.getStatus().equals("Complete")))
           { 
            Object[] row = new Object[4];
            row[0] = ((BloodBankWQ) work).getBloodGroup();
            row[1] = ((BloodBankWQ) work).getQuant();
            row[2] = work;
            row[3] = work.getReceiver();
            model.addRow(row);
           }
        }
    }
     public void populateAvailable(){
         DefaultTableModel model = (DefaultTableModel) availableTable.getModel();
        
        model.setRowCount(0);
        //Pharmacy p= organization.getP();
         //System.out.println("pharmacy"+ p.getVaccine().getVaccineList().size());
        for (BloodGroup bg : him.getListOfBloodGroup()){
          if(bg.getQuant() > 0)
          {
            Object[] row = new Object[2];
            row[0] = bg;
            row[1] = bg.getQuant();
            model.addRow(row);
          }
        }
    }
     public void populateQuantity(){
         
         for ( WorkRequest workRequest : account.getWorkQueue().getWorkRequestList()) {
            // HashMap<WorkRequest,Integer> map = new HashMap<WorkRequest,Integer>();
             int temp=0;
             if(workRequest != null)
            {
             BloodBankWQ p= (BloodBankWQ) workRequest;
             if(workRequest.getStatus().equals("Complete") && !p.isAdd() ){ //&& add == false
                 BloodGroup v = ((BloodBankWQ) workRequest).getBloodGroup();
                  for (BloodGroup vaccine : him.getListOfBloodGroup()) {
                    // if(v.BloodGroupType.equals(vaccine.getVaccineName())){
                    if(v.getName().equals(vaccine.getName())){
                         temp=1;
                          vaccine.setQuant(p.getQuant()+vaccine.getQuant());
                          vaccine.setAutoFlag(true);
                          
                     }
                     
                 }
                  if(temp==0){
                       BloodGroup vac= new BloodGroup();
                      // vac.setDisease(v.getDisease());
                       vac.setName(v.getName());
                       vac.setQuant(p.getQuant());
                       him.getListOfBloodGroup().add(vac);
                   }
                 p.setAdd(true); 
             }
            }
         }
        
     }
    // }//
    
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
        reqBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        availableTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable();
        comboVaccine = new javax.swing.JComboBox();
        txtquant = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Hospital Inventory  Manager Work Area ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        sellBtn.setText("Use Blood Group");
        sellBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellBtnActionPerformed(evt);
            }
        });
        jPanel1.add(sellBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 170, -1));

        reqBtn.setText("Request Blood Group");
        reqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqBtnActionPerformed(evt);
            }
        });
        jPanel1.add(reqBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 170, -1));

        availableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Blood Group", "Quantity"
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
        jPanel1.add(txtquant, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 100, -1));

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
        int selectedRow = availableTable.getSelectedRow();
        if (selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null, "Please select a row from available vaccines");
        }
        else
        {
            try
            {
                BloodGroup v = (BloodGroup) availableTable.getValueAt(selectedRow,0);
                if (Integer.parseInt(txtquant.getText()) > v.getQuant())
                {
                    JOptionPane.showMessageDialog(null, "requested quantity exceeds the available limit");
                }
                else
                {
                    v.setQuant(v.getQuant()-Integer.parseInt(txtquant.getText()));
                    JOptionPane.showMessageDialog(null, "Sold successfully");
                    if((v.getQuant() <= v.getThresholdQuant()) && (v.isAutoFlag()))
                    {
                        BloodBankWQ request= new BloodBankWQ();
                        BloodGroup bg = v;
                        request.setBloodGroup(bg);
                        request.setQuant(v.getMaxQuant());
                        request.setStatus("Requested");
                        request.setSender(account);
                        v.setAutoFlag(false);
                        //BloodBankInventoryManager bbim=(BloodBankInventoryManager) comboBloodBank.getSelectedItem();
                        //bbim.getWorkQueue().getWorkRequestList().add(request);
                        //organization.getWorkQueue().getWorkRequestList().add(request);
                        //account.getWorkQueue().getWorkRequestList().add(request);
                       // business.getWorkQueue().getWorkRequestList().add(request);
                        //him.getWorkQueue().getWorkRequestList().add(request);
                        Organization org = null;
                        Enterprise ent = null;
                        for (Enterprise e1 : enterprise.getNetwork().getEnterpriseDirectory().getEnterpriseList()){
                            if (e1 instanceof BloodBankEnterprise){
                                ent = e1;
                                for(Organization o1: ent.getOrganizationDirectory().getOrganizationList())
                                {
                                    if(o1 instanceof BloodBankInventoryManagerOrganization)
                                    {
                                        org = o1;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        if (org!=null)
                        {
                            org.getWorkQueue().getWorkRequestList().add(request);
                            //userAccount.getWorkQueue().getWorkRequestList().add(request);
                      //  }
                        //organization.getWorkQueue().getWorkRequestList().add(request);
                        account.getWorkQueue().getWorkRequestList().add(request);
                        //business.getWorkQueue().getWorkRequestList().add(request);
                        him.getWorkQueue().getWorkRequestList().add(request);
                        }
                        populateWorkQueueTable();
                    }
                    populateAvailable();
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Invalid Quantity enetered", "Error", 0);
            }
        }

    }//GEN-LAST:event_sellBtnActionPerformed

    private void reqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqBtnActionPerformed
        try
        {
        BloodBankWQ request= new BloodBankWQ();
        BloodGroup bg = new BloodGroup();
        bg.setName(String.valueOf(comboVaccine.getSelectedItem())); 
        request.setBloodGroup(bg);
        request.setQuant(Integer.parseInt(txtquant.getText()));
        request.setStatus("Requested");
        request.setSender(account);
       // BloodBankInventoryManager bbim = (BloodBankInventoryManager) comboBloodBank.getSelectedItem();
        //bbim.getWorkQueue().getWorkRequestList().add(request);
        Organization org = null;
        Enterprise ent = null;
        for (Enterprise e1 : enterprise.getNetwork().getEnterpriseDirectory().getEnterpriseList()){
            if (e1 instanceof BloodBankEnterprise){
                ent = e1;
                for(Organization o1: ent.getOrganizationDirectory().getOrganizationList())
                {
                    if(o1 instanceof BloodBankInventoryManagerOrganization)
                    {
                        org = o1;
                        break;
                    }
                }
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            //userAccount.getWorkQueue().getWorkRequestList().add(request);
      //  }
        //organization.getWorkQueue().getWorkRequestList().add(request);
        account.getWorkQueue().getWorkRequestList().add(request);
        //business.getWorkQueue().getWorkRequestList().add(request);
        him.getWorkQueue().getWorkRequestList().add(request);
        }
        populateWorkQueueTable();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Invalid Quantity enetered", "Error", 0);
        }
    }//GEN-LAST:event_reqBtnActionPerformed

    private void txtquantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtquantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtquantActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        new HospInventoryManagerWorkAreaJPanel(userProcessContainer, account, organization, enterprise, business);
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
            him.getWorkQueue().getWorkRequestList().remove(p);
            JOptionPane.showMessageDialog(null, "You have successfully deleted the account");
            populateWorkQueueTable();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable availableTable;
    private javax.swing.JButton backJButton;
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
    private javax.swing.JButton reqBtn;
    private javax.swing.JTable requestTable;
    private javax.swing.JButton sellBtn;
    private javax.swing.JTextField txtquant;
    // End of variables declaration//GEN-END:variables
}
