/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManageAirliners;
import Business.*;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author JAGTAP
 */
public class AddingAirplanePanel extends javax.swing.JPanel {

    /** Creates new form AddingAirplane */
   // private TravelAgency travelAgency;
    private JPanel cardSequenceJPanel;
    private Fleet fleet;
    public AddingAirplanePanel(Fleet fleet, JPanel cardSequenceJPanel) {
        initComponents();
        //this.travelAgency=travelAgency;
        this.cardSequenceJPanel=cardSequenceJPanel;
        this.fleet=fleet;
        resetFields();
    }

    private void resetFields()
    {
        airlinerTextField.setText(fleet.getAirliners().getAirlines());
        airplaneIdTextField.setText("");
        mainHubTextField.setText("");
        manufacturingYearTextField.setText("");
        modelNumTextField.setText("");
        companyTextField1.setText("");
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        iCAOTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mainHubTextField = new javax.swing.JTextField();
        countryTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addAirplanesButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        iATATextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        companyTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        manufacturingYearTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        airplaneIdTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        modelNumTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        totalSeatsTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        airlinerTextField = new javax.swing.JTextField();

        jLabel4.setText("ICAO");

        jLabel5.setText("Main Hub");

        jLabel6.setText("Country");

        addAirplanesButton.setText("Add Airplanes");

        jLabel2.setText("Name");

        jLabel3.setText("IATA");

        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Airplane");

        jLabel7.setText("Company");

        jLabel8.setText("Manufacturing Year");

        manufacturingYearTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufacturingYearTextFieldActionPerformed(evt);
            }
        });

        addButton.setText("Add ");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Airplane Id");

        jLabel11.setText("Model Number");

        jLabel9.setText("Total Seats");

        totalSeatsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalSeatsTextFieldActionPerformed(evt);
            }
        });

        jLabel12.setText("Airliner");

        airlinerTextField.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(airplaneIdTextField)
                            .addComponent(modelNumTextField)
                            .addComponent(companyTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(manufacturingYearTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(totalSeatsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(airlinerTextField))
                        .addGap(0, 321, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(backButton))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(airlinerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(airplaneIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modelNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(companyTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(manufacturingYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(totalSeatsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(196, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manufacturingYearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufacturingYearTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manufacturingYearTextFieldActionPerformed

    private void totalSeatsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalSeatsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalSeatsTextFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if((airplaneIdTextField.getText().isEmpty()) || (modelNumTextField.getText().isEmpty()) ||
           (manufacturingYearTextField.getText().isEmpty()) ||
           (totalSeatsTextField.getText().isEmpty()) || (companyTextField1.getText().isEmpty()))
            JOptionPane.showMessageDialog(null, "Please enter all the details before pressing Add", "Error", 0);
        else
        {
            try
            {
                int id = Integer.parseInt(airplaneIdTextField.getText());
                short year = Short.parseShort(manufacturingYearTextField.getText());
                short totSeats= Short.parseShort(totalSeatsTextField.getText());
                if ((id >=0 ) && (year >=0) && (totSeats>=0))
                {
                    Airplane airplane=fleet.addAirplane();
                    airplane.setAirplaneId(id);
                    airplane.setFleet(fleet);
                    airplane.setManufacturingCompany(companyTextField1.getText());
                    airplane.setManufacturingYear(year);
                    airplane.setModelNumber(modelNumTextField.getText());
                    airplane.setTotalSeats(totSeats);
                    JOptionPane.showMessageDialog(null, "Airplane added successfully");
                }
                else
                    JOptionPane.showMessageDialog(null, "id,year & total seats can not be negative", "Error", 0);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Please enter numeric fields in airplane Id, year and total seats", "Error", 0);
                e.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        Component component = cardSequenceJPanel.getComponent((cardSequenceJPanel.getComponentCount()-2));
        try
        {
            CreateAirlinerPanel createAirlinerPanel = (CreateAirlinerPanel)component;
            createAirlinerPanel.disableFields();
        }
        catch(Exception e)
        {
            ViewAirlinerPanel viewAirlinerPanel = (ViewAirlinerPanel) component;
            viewAirlinerPanel.reload();
            e.printStackTrace();
        }
        cardSequenceJPanel.remove(this);
        CardLayout cardLayout = (CardLayout) cardSequenceJPanel.getLayout();
        cardLayout.previous(cardSequenceJPanel);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAirplanesButton;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField airlinerTextField;
    private javax.swing.JTextField airplaneIdTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField companyTextField1;
    private javax.swing.JTextField countryTextField;
    private javax.swing.JTextField iATATextField;
    private javax.swing.JTextField iCAOTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField mainHubTextField;
    private javax.swing.JTextField manufacturingYearTextField;
    private javax.swing.JTextField modelNumTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField totalSeatsTextField;
    // End of variables declaration//GEN-END:variables

}
