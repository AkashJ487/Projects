/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageAirliners;
import Business.*;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author JAGTAP
 */
public class ViewAirlinerPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewAirlinerPanel
     */
    private Airliners airliners;
    private JPanel cardSequenceJPanel;
    public ViewAirlinerPanel(Airliners airliners, JPanel cardSequenceJPanel) {
        initComponents();
        this.airliners=airliners;
        this.cardSequenceJPanel=cardSequenceJPanel;
        reload();
    }
    
    public void reload()
    {
        nameTextField.setText(airliners.getAirlines());
        iATATextField.setText(airliners.getiATA());
        iCAOTextField.setText(airliners.getiCAO());
        mainHubTextField.setText(airliners.getMainHub());
        countryTextField.setText(airliners.getCountry());
        Fleet fleet = airliners.getFleet();
        DefaultTableModel dtm = (DefaultTableModel) airplanesTable.getModel();
        dtm.setRowCount(0);
        for (Airplane airplane: fleet.getListOfAirplanes())
        {
            Object row[] = new Object[5];
            row[0] = airplane;
            row[1] = airplane.getModelNumber();
            row[2]=airplane.getManufacturingCompany();
            row[3]=airplane.getManufacturingYear();
            row[4]=airplane.getTotalSeats();
            dtm.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        iCAOTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mainHubTextField = new javax.swing.JTextField();
        countryTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        iATATextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        airplanesTable = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        addAirplaneButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        deleteAirplaneButton = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("ICAO");

        iCAOTextField.setEnabled(false);

        jLabel5.setText("Main Hub");

        mainHubTextField.setEnabled(false);

        countryTextField.setEnabled(false);

        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Country");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Airliner");

        jLabel2.setText("Name");

        nameTextField.setEnabled(false);

        jLabel3.setText("IATA");

        iATATextField.setEnabled(false);

        airplanesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airplane Id", "Model Num", "Company", "Manuf. Year", "Total Seats"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Short.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        airplanesTable.setEnabled(false);
        jScrollPane2.setViewportView(airplanesTable);

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        addAirplaneButton.setText("Add Airplane");
        addAirplaneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAirplaneButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteAirplaneButton.setText("Delete Airplane");
        deleteAirplaneButton.setEnabled(false);
        deleteAirplaneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAirplaneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteAirplaneButton)
                    .addComponent(addAirplaneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(47, 47, 47)
                                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGap(48, 48, 48)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(iCAOTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(iATATextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mainHubTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(35, 35, 35)
                                    .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 52, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(backButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(iATATextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(iCAOTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(updateButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(saveButton)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(mainHubTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteAirplaneButton)
                        .addGap(4, 4, 4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addAirplaneButton))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        //nameTextField.setEnabled(true);
        iATATextField.setEnabled(true);
        iCAOTextField.setEnabled(true);
        countryTextField.setEnabled(true);
        mainHubTextField.setEnabled(true);
        saveButton.setEnabled(true);
        updateButton.setEnabled(false);
        airplanesTable.setEnabled(true);
        addAirplaneButton.setEnabled(false);
        deleteAirplaneButton.setEnabled(true);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        cardSequenceJPanel.remove(this);
        CardLayout cardLayout = (CardLayout) cardSequenceJPanel.getLayout();
        cardLayout.previous(cardSequenceJPanel);
    }//GEN-LAST:event_backButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        if ((nameTextField.getText().isEmpty()) || (iATATextField.getText().isEmpty()) || 
            (iCAOTextField.getText().isEmpty()) || (countryTextField.getText().isEmpty()) ||
            (mainHubTextField.getText().isEmpty()))
            JOptionPane.showMessageDialog(null, "Please enter the all airliner details before", "Error", 0);
        else
        {
            
            airliners.setAirlines(nameTextField.getText());
            airliners.setCountry(countryTextField.getText());
            airliners.setMainHub(mainHubTextField.getText());
            airliners.setiATA(iATATextField.getText());
            airliners.setiCAO(iCAOTextField.getText());
            byte flag=0;
                int selectedRow = airplanesTable.getSelectedRow();
                if (selectedRow < 0 )
                    System.out.println("ManageAirliners.ViewAirlinerPanel.saveButtonActionPerformed()");
                    //JOptionPane.showMessageDialog(null, "Please select a row");
                else
                {
                    DefaultTableModel dtm = (DefaultTableModel) airplanesTable.getModel();
                    dtm.getValueAt(selectedRow,1);
                    Airplane airplane = (Airplane)airplanesTable.getValueAt(selectedRow,0);
                    try
                    {
                        if((String.valueOf(airplanesTable.getValueAt(selectedRow,1)).isEmpty()) ||
                           (String.valueOf(airplanesTable.getValueAt(selectedRow,2)).isEmpty()) ||
                           (String.valueOf(airplanesTable.getValueAt(selectedRow,3)).isEmpty()) ||
                           (String.valueOf(airplanesTable.getValueAt(selectedRow,4)).isEmpty()))    
                        {
                             flag=1;
                             JOptionPane.showMessageDialog(null, "Please enter all the details of the selected airplane before saving", "Error", 0);
                        }
                        else
                        {
                            short year = Short.parseShort(String.valueOf(airplanesTable.getValueAt(selectedRow,3)));
                            short totSeats= Short.parseShort(String.valueOf(airplanesTable.getValueAt(selectedRow,4)));
                            if ((year >=0) && (totSeats>=0))
                            {
                                
                                airplane.setManufacturingCompany(String.valueOf(airplanesTable.getValueAt(selectedRow,2)));
                                airplane.setManufacturingYear(year);
                                airplane.setModelNumber(String.valueOf(airplanesTable.getValueAt(selectedRow,1)));
                                airplane.setTotalSeats(totSeats);
                                JOptionPane.showMessageDialog(null, "Details Saved Successfully");
                            }
                            else
                            {
                                flag=1;
                                JOptionPane.showMessageDialog(null, "year & total seats of the selected airplane can not be negative", "Error", 0);
                            }
                        }
                    }
            
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, "Please enter numeric fields in airplane Id, year and total seats of the the selected airplane before saving", "Error", 0);
                        e.printStackTrace();
                    }  
                }
                if(flag==0)
                {
                    iATATextField.setEnabled(false);
                    iCAOTextField.setEnabled(false);
                    countryTextField.setEnabled(false);
                    mainHubTextField.setEnabled(false);
                    saveButton.setEnabled(false);
                    updateButton.setEnabled(true);
                    addAirplaneButton.setEnabled(true);
                    deleteAirplaneButton.setEnabled(false);
                    airplanesTable.setEnabled(false);
                    reload();
                }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteAirplaneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAirplaneButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = airplanesTable.getSelectedRow();
        if (selectedRow < 0 )
            JOptionPane.showMessageDialog(null, "Please select a row");
        else
        {
            int dialogBtn = JOptionPane.YES_NO_OPTION;
            int dialogResult=JOptionPane.showConfirmDialog(null, "Please Confirm to Delete the selected Airplane", "Warning", dialogBtn);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                Airplane airplane = (Airplane) airplanesTable.getValueAt(selectedRow, 0);
                airliners.getFleet().delAirplane(airplane);
                JOptionPane.showMessageDialog(null, "Selected Airplane deleted successfully");
                reload();
            }
        }
    }//GEN-LAST:event_deleteAirplaneButtonActionPerformed

    private void addAirplaneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAirplaneButtonActionPerformed
        // TODO add your handling code here:
        AddingAirplanePanel addingAirplanePanel = new AddingAirplanePanel(airliners.getFleet(),cardSequenceJPanel);
        cardSequenceJPanel.add("AddingAirplane",addingAirplanePanel);
        CardLayout cardLayout= (CardLayout) cardSequenceJPanel.getLayout();
        cardLayout.next(cardSequenceJPanel);
    }//GEN-LAST:event_addAirplaneButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAirplaneButton;
    private javax.swing.JTable airplanesTable;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField countryTextField;
    private javax.swing.JButton deleteAirplaneButton;
    private javax.swing.JTextField iATATextField;
    private javax.swing.JTextField iCAOTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField mainHubTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
