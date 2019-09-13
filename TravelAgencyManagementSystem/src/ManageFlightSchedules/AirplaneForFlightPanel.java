/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageFlightSchedules;

import java.awt.CardLayout;
import Business.*;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author JAGTAP
 */
public class AirplaneForFlightPanel extends javax.swing.JPanel {

    /**
     * Creates new form AirplaneForFlightPanel
     */
    private Flight flight;
    private Airplane airplane;
    private JPanel cardSequenceJPanel;
    public AirplaneForFlightPanel(Flight flight,JPanel cardSequenceJPanel) {
        initComponents();
        this.flight=flight;
        this.cardSequenceJPanel=cardSequenceJPanel;
        this.airplane=flight.getAirplane();
        reload();
    }

    private void reload()
    {
        DefaultTableModel dtm = (DefaultTableModel) airplanesTable.getModel();
        dtm.setRowCount(0);
        for(Airplane a: airplane.getFleet().getListOfAirplanes())
        {
            Object row[]= new Object[5];
            row[0]=a;
            row[1]=a.getModelNumber();
            row[2]=a.getManufacturingCompany();
            row[3]=a.getManufacturingYear();
            row[4]=a.getTotalSeats();
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

        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        airplanesTable = new javax.swing.JTable();
        selectSaveButton = new javax.swing.JButton();

        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Select Airplane For Flight ");

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
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(airplanesTable);

        selectSaveButton.setText("Select & Save");
        selectSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectSaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectSaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(backButton))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectSaveButton))
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        Component component = cardSequenceJPanel.getComponent((cardSequenceJPanel.getComponentCount()-2));
        ViewUpdateFlightPanel viewUpdateFlightPanel=(ViewUpdateFlightPanel) component;
        viewUpdateFlightPanel.reload();
        cardSequenceJPanel.remove(this);
        CardLayout cardLayout = (CardLayout) cardSequenceJPanel.getLayout();
        cardLayout.previous(cardSequenceJPanel);
    }//GEN-LAST:event_backButtonActionPerformed

    private void selectSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectSaveButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = airplanesTable.getSelectedRow();
        if (selectedRow < 0 )
            JOptionPane.showMessageDialog(null, "Please select a row");
        else
        {
            Airplane a = (Airplane) airplanesTable.getValueAt(selectedRow, 0);
            airplane.getAirplaneListOfFlight().remove(flight);
            flight.setAirplane(a); 
            Component component = cardSequenceJPanel.getComponent((cardSequenceJPanel.getComponentCount()-2));
            ViewUpdateFlightPanel viewUpdateFlightPanel=(ViewUpdateFlightPanel) component;
            viewUpdateFlightPanel.reload();
            cardSequenceJPanel.remove(this);
            CardLayout cardLayout = (CardLayout) cardSequenceJPanel.getLayout();
            cardLayout.previous(cardSequenceJPanel);
        }
    }//GEN-LAST:event_selectSaveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable airplanesTable;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton selectSaveButton;
    // End of variables declaration//GEN-END:variables
}