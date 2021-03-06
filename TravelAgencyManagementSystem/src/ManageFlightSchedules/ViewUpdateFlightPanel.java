/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageFlightSchedules;
import Business.*;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.JobAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAGTAP
 */
public class ViewUpdateFlightPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewUpdateFlightPanel
     */
    private Flight flight;
    private JPanel cardSequenceJPanel;
    public ViewUpdateFlightPanel(Flight flight, JPanel cardSequenceJPanel) {
        initComponents();
        this.flight=flight;
        this.cardSequenceJPanel=cardSequenceJPanel;
        reload();
    }
    
    public void reload()
    {
        flightIdTextField.setText(String.valueOf(flight.getFlightId()));
        dateTextField.setText(flight.getDepatureDate());
        timeTextField.setText(flight.getDepatureTime());
        depaturePortTextField.setText(flight.getDepaturePort());
        destinationPortTextField.setText(flight.getDestinationPort());
        pricePerSeatTextField.setText(String.valueOf(flight.getPriceOfSeat()));
        airlinerTextField.setText(flight.getAirplane().getFleet().getAirliners().getAirlines());
        airplaneIdTextField.setText(String.valueOf(flight.getAirplane().getAirplaneId()));
        manufacturingYearTextField.setText(String.valueOf(flight.getAirplane().getManufacturingYear()));
        modelNumTextField.setText(flight.getAirplane().getModelNumber());
        companyTextField1.setText(flight.getAirplane().getManufacturingCompany());
        totalSeatsTextField.setText(String.valueOf(flight.getAirplane().getTotalSeats()));
        DefaultTableModel dtm = (DefaultTableModel) seatsTable.getModel();
        dtm.setRowCount(0);
        for(Seat s: flight.getListOfSeats() )
        {
            Object row[]=new Object[3];
            row[0]=s;
            if(s.isBooked())
            {
                row[1]="Booked";
                row[2]=s.getPerson().getPersonId();
            }
            else
            {
                row[1]="Available";
                row[2]=null;
            }  
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pricePerSeatTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        airplaneIdTextField = new javax.swing.JTextField();
        modelNumTextField = new javax.swing.JTextField();
        companyTextField1 = new javax.swing.JTextField();
        manufacturingYearTextField = new javax.swing.JTextField();
        totalSeatsTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        flightIdTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        timeTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        depaturePortTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        destinationPortTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        airlinerTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        seatsTable = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        changeButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelFlightButton = new javax.swing.JButton();
        undoCancelButton = new javax.swing.JButton();

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("View / Update Flight ");

        pricePerSeatTextField.setEnabled(false);
        pricePerSeatTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricePerSeatTextFieldActionPerformed(evt);
            }
        });

        jLabel11.setText("Airplane Id");

        airplaneIdTextField.setEnabled(false);

        modelNumTextField.setEnabled(false);

        companyTextField1.setEnabled(false);

        manufacturingYearTextField.setEnabled(false);
        manufacturingYearTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufacturingYearTextFieldActionPerformed(evt);
            }
        });

        totalSeatsTextField.setEnabled(false);
        totalSeatsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalSeatsTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Flight Id");

        jLabel9.setText("Total Seats");

        flightIdTextField.setEnabled(false);

        jLabel8.setText("Manufacturing Year");

        jLabel3.setText("Date (mm-dd-yyyy)");

        dateTextField.setEnabled(false);

        jLabel4.setText("Time 24hrs (mm:ss)");

        timeTextField.setEnabled(false);

        jLabel12.setText("Company");

        jLabel13.setText("Model Number");

        depaturePortTextField.setEnabled(false);

        jLabel5.setText("Depature Port");

        jLabel6.setText("Destination Port");

        destinationPortTextField.setEnabled(false);

        jLabel10.setText("Airliner");

        airlinerTextField.setEnabled(false);

        jLabel7.setText("Price per Seat");

        seatsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seat Num", "Status", "Customer Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(seatsTable);

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        changeButton.setText("Change Airplane");
        changeButton.setEnabled(false);
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        jLabel14.setText("Seats Allotment");

        saveButton.setText("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelFlightButton.setText("Cancel Flight");
        cancelFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelFlightButtonActionPerformed(evt);
            }
        });

        undoCancelButton.setText("Undo Cancel Flight");
        undoCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(undoCancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelFlightButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(depaturePortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(flightIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(41, 41, 41)
                                        .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(destinationPortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pricePerSeatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(91, 91, 91)
                                        .addComponent(airlinerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel13))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(manufacturingYearTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(companyTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(modelNumTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(airplaneIdTextField)
                                            .addComponent(totalSeatsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(backButton))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(flightIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(updateButton))
                    .addComponent(airlinerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(airplaneIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modelNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(companyTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(manufacturingYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalSeatsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(changeButton)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(depaturePortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(destinationPortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(saveButton)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(pricePerSeatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(cancelFlightButton)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(undoCancelButton)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pricePerSeatTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricePerSeatTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pricePerSeatTextFieldActionPerformed

    private void manufacturingYearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufacturingYearTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manufacturingYearTextFieldActionPerformed

    private void totalSeatsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalSeatsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalSeatsTextFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        Component component = cardSequenceJPanel.getComponent((cardSequenceJPanel.getComponentCount()-2));
        ListOfFlightsPanel listOfFlightsPanel = (ListOfFlightsPanel) component;
        listOfFlightsPanel.reload();
        cardSequenceJPanel.remove(this);
        CardLayout cardLayout = (CardLayout) cardSequenceJPanel.getLayout();
        cardLayout.previous(cardSequenceJPanel);
    }//GEN-LAST:event_backButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        dateTextField.setEnabled(true);
        timeTextField.setEnabled(true);
        depaturePortTextField.setEnabled(true);
        destinationPortTextField.setEnabled(true);
        pricePerSeatTextField.setEnabled(true);
        saveButton.setEnabled(true);
        changeButton.setEnabled(true);
        updateButton.setEnabled(false);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        // TODO add your handling code here:
        AirplaneForFlightPanel airplaneForFlightPanel = new AirplaneForFlightPanel(flight,cardSequenceJPanel);
        cardSequenceJPanel.add("AirplaneForFlight",airplaneForFlightPanel);
        CardLayout cardLayout=(CardLayout) cardSequenceJPanel.getLayout();
        cardLayout.next(cardSequenceJPanel);
    }//GEN-LAST:event_changeButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        if((flightIdTextField.getText().isEmpty()) || (depaturePortTextField.getText().isEmpty()) ||
           (destinationPortTextField.getText().isEmpty()) || (dateTextField.getText().isEmpty()) ||
           (timeTextField.getText().isEmpty()) || (pricePerSeatTextField.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Please enter all the flight details", "Error", 0);
        }
        else
        {
            try
            {
                int id = Integer.parseInt(flightIdTextField.getText());
                double price = Double.parseDouble(pricePerSeatTextField.getText());
                if((id >=0) && (price >=0))
                {
                    try
                    {
                        byte flag = dateValidation(dateTextField.getText());
                        if(flag == 0)
                        {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy"); 
                            Date date = (Date)dateFormat.parse(dateTextField.getText());
                            Date currdate = (Date)dateFormat.parse(dateFormat.format(new Date()));
                            flag = timeValidation(timeTextField.getText());
                            if (flag == 0)
                            {
                                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                                Date time = (Date)timeFormat.parse(timeTextField.getText());
                                Date currtime = (Date)timeFormat.parse(timeFormat.format(new Date()));
                                if (((date.equals(currdate)) && (time.after(currtime))) || (date.after(currdate)))
                                {
                                    flight.setDepatureDate(dateTextField.getText());
                                    flight.setDepaturePort(depaturePortTextField.getText());
                                    flight.setDepatureTime(timeTextField.getText());
                                    flight.setDestinationPort(destinationPortTextField.getText());
                                    flight.setFlightId(id);
                                    flight.setPriceOfSeat(price);
                                    JOptionPane.showMessageDialog(null, "Filght updated Successfully");
                                    dateTextField.setEnabled(false);
                                    timeTextField.setEnabled(false);
                                    depaturePortTextField.setEnabled(false);
                                    destinationPortTextField.setEnabled(false);
                                    pricePerSeatTextField.setEnabled(false);
                                    saveButton.setEnabled(false);
                                    changeButton.setEnabled(false);
                                    updateButton.setEnabled(true);
                                }
                                else 
                                    JOptionPane.showMessageDialog(null, "Please Enter Todays or future depature Date and time", "Error", 0);
                            }
                            else
                                JOptionPane.showMessageDialog(null, "Improper time format please enter time in HH:mm(24 hrs) format ", "Error", 0);
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Improper date format please enter date in MM-dd-yyyy format ", "Error", 0);
                    }
                    catch(Exception e)
                    {
                            JOptionPane.showMessageDialog(null, "Please enter date in MM-dd-yyyy & Time in HH:mm(24 hrs) format ", "Error", 0);
                            e.printStackTrace();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Price / Seat can't be negative", "Error", 0);
                }
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Flight Id and Price per seat are numeric fields", "Error", 0);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelFlightButtonActionPerformed
        // TODO add your handling code here:
        if(flight.isCancelFlag())
        {
            JOptionPane.showMessageDialog(null, "Flight is already canceled press Undo Cancel to make flight available");
        }
        else
        {
            flight.setCancelFlag(true);
            JOptionPane.showMessageDialog(null,"Flight Canceled Successfully");
        }
        
    }//GEN-LAST:event_cancelFlightButtonActionPerformed

    private void undoCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoCancelButtonActionPerformed
        // TODO add your handling code here:
        if(flight.isCancelFlag())
        {
            flight.setCancelFlag(false);
            JOptionPane.showMessageDialog(null,"Flight is Available now");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Flight is already Available press CancelFlight to cancel flight");
        }
    }//GEN-LAST:event_undoCancelButtonActionPerformed


    private byte dateValidation(String depatDateTextField)
    {
        if (depatDateTextField.matches("^[0-1][0-9][-][0-3][0-9][-][0-9][0-9][0-9][0-9]"))
        {
               if (((depatDateTextField.charAt(0)=='1') && (depatDateTextField.charAt(1)<'3')) ||
                   ((depatDateTextField.charAt(0)=='0') && (depatDateTextField.charAt(1)<='9')))
               {
                    if (((depatDateTextField.charAt(3)=='0') && (depatDateTextField.charAt(4)<='9')) ||
                        ((depatDateTextField.charAt(3)=='1') && (depatDateTextField.charAt(4)<='9')) ||
                        ((depatDateTextField.charAt(3)=='2') && (depatDateTextField.charAt(4)<='9')) ||
                        ((depatDateTextField.charAt(3)=='3') && (depatDateTextField.charAt(4)<'2')))
                    {
                         if(((depatDateTextField.charAt(0)=='0') && (depatDateTextField.charAt(1)=='2') &&
                             (depatDateTextField.charAt(3)=='3')) || 
                            ((depatDateTextField.charAt(0)=='0') && ((depatDateTextField.charAt(1)=='4') || (depatDateTextField.charAt(1)=='6') ||
                                                                              (depatDateTextField.charAt(1)=='9')) &&
                                                                             (depatDateTextField.charAt(3)=='3') && (depatDateTextField.charAt(4)=='1') ) ||
                            ((depatDateTextField.charAt(0)=='1') && (depatDateTextField.charAt(1)=='1') && (depatDateTextField.charAt(3)=='3') && 
                                 (depatDateTextField.charAt(4)=='1') ))
                         {
                               return 1;
                         }
                         else
                         {
                               return 0;
                         }
                    }
                     
                }
                            
        }
        return 1;                      
    }
    
    private byte timeValidation(String depatTimeTextField)
    {
        if (depatTimeTextField.matches("^[0-2][0-9][:][0-5][0-9]"))
        {
            if (((depatTimeTextField.charAt(0)=='2') && (depatTimeTextField.charAt(1) < '4')) ||
                 ((depatTimeTextField.charAt(0)=='1') && (depatTimeTextField.charAt(1) <='9'))||
                 ((depatTimeTextField.charAt(0)=='0') && (depatTimeTextField.charAt(1) <='9')))
            {
                return 0;
            }
        }
        return 1;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField airlinerTextField;
    private javax.swing.JTextField airplaneIdTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelFlightButton;
    private javax.swing.JButton changeButton;
    private javax.swing.JTextField companyTextField1;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JTextField depaturePortTextField;
    private javax.swing.JTextField destinationPortTextField;
    private javax.swing.JTextField flightIdTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField manufacturingYearTextField;
    private javax.swing.JTextField modelNumTextField;
    private javax.swing.JTextField pricePerSeatTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable seatsTable;
    private javax.swing.JTextField timeTextField;
    private javax.swing.JTextField totalSeatsTextField;
    private javax.swing.JButton undoCancelButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
