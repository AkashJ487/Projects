/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageFlightSchedules;
import Business.*;
import java.awt.CardLayout;
import javax.swing.JPanel;


/**
 *
 * @author JAGTAP
 */
public class ManageFlightSchPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageFlightSchPanel
     */
    private TravelAgency travelAgency;
    private JPanel cardSequenceJPanel;
    public ManageFlightSchPanel(TravelAgency travelAgency, JPanel cardSequenceJPanel) {
        initComponents();
        this.travelAgency=travelAgency;
        this.cardSequenceJPanel=cardSequenceJPanel;
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
        listOfAirlinersButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("       Manage Flight Schedule");

        listOfAirlinersButton.setText("List Of Flights");
        listOfAirlinersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listOfAirlinersButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(listOfAirlinersButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(listOfAirlinersButton)
                .addContainerGap(311, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listOfAirlinersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listOfAirlinersButtonActionPerformed
        // TODO add your handling code here:
        ListOfFlightsPanel listOfFlightsPanel = new ListOfFlightsPanel(travelAgency,cardSequenceJPanel);
        cardSequenceJPanel.add("ListOfFlights",listOfFlightsPanel);
        CardLayout cardLayout= (CardLayout) cardSequenceJPanel.getLayout();
        cardLayout.next(cardSequenceJPanel);
    }//GEN-LAST:event_listOfAirlinersButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton listOfAirlinersButton;
    // End of variables declaration//GEN-END:variables
}