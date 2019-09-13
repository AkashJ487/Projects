/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BloodBank;

import Business.BloodBank.BloodBankInventoryManager;
import Business.Organization.BloodBankInventoryManagerOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.WorkQueue.BloodBankWQ;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang.time.DateUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author JAGTAP
 */
public class BloodBankStatisticsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BloodBankStatisticsJPanel
     */
    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    private ArrayList<BloodBankWQ> listOfBloodBankWQ;
    private float a1,b1,ab1,o1;
    private int su;
    public BloodBankStatisticsJPanel(JPanel userProcessContainer,OrganizationDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        listOfBloodBankWQ=new ArrayList<>();
        populateArray();
        populateCombo();
        populateTable();
    }

    private void populateCombo(){
        periodComboBox.removeAllItems();
        periodComboBox.addItem("Last 7 days");
        periodComboBox.addItem("Last 30 days");
        periodComboBox.addItem("Last 365 days");
    }
    private void populateArray()
    {
        for (Organization o:directory.getOrganizationList())
        {
            if(o instanceof BloodBankInventoryManagerOrganization)
                for (BloodBankInventoryManager bbim : ((BloodBankInventoryManagerOrganization) o).getListOfBloodBankInventoryManager())
                {
                    for(WorkRequest wr : bbim.getWorkQueue().getWorkRequestList())
                    {
                        listOfBloodBankWQ.add((BloodBankWQ) wr);
                    }
                    
                }
        }
    }
    
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) periodTable.getModel();
        model.setRowCount(0);
        String pd = String.valueOf(periodComboBox.getSelectedItem());
        int a=0;
        int b=0;
        int ab=0;
        int o=0;
        Date date = new Date();
        Date daysAgo = null;
        float t=1;
        if(pd.matches("Last 7 days"))
        {
            daysAgo = DateUtils.addDays(new Date(),-7);
            t=7;
        }
        else if (pd.matches("Last 30 days"))
        {
            daysAgo = DateUtils.addDays(new Date(),-30);
            t=30;
        }
        else if (pd.matches("Last 365 days"))
        {
            daysAgo = DateUtils.addDays(new Date(),-365);
            t=365;
        }
        su=0;
        for (BloodBankWQ bbWQ : listOfBloodBankWQ){
            //Object[] row = new Object[4];
            if (bbWQ.getResolveDate().equals(daysAgo) || bbWQ.getResolveDate().after(daysAgo))
                if (bbWQ.getBloodGroup().getName().matches("A"))
                {
                    a=bbWQ.getQuant()+a;
                }
                else if (bbWQ.getBloodGroup().getName().matches("B"))
                {
                    b=bbWQ.getQuant()+b;
                }
                else if (bbWQ.getBloodGroup().getName().matches("AB"))
                {
                    ab=bbWQ.getQuant()+ab;
                }
                else if (bbWQ.getBloodGroup().getName().matches("O"))
                {
                    o=bbWQ.getQuant()+o;
                } 
            //model.addRow(row);
        }
        for(int i=4;i>=1;i--)
        {
            Object[] row = new Object[3];
            if (i==4)
            {
                row[0]="A";
                row[1]=a;
                row[2]=Math.round(a/t);
            }
            else if (i==3)
            {
                row[0]="B";
                row[1]=b;
                row[2]=Math.round(b/t);
            }
            else if (i==2)
            {
                row[0]="AB";
                row[1]=ab;
                row[2]=Math.round(ab/t);
            }
            else
            {
                row[0]="O";
                row[1]=o;
                row[2]=Math.round(o/t);
            }
            model.addRow(row);
        }
       /* su=a+b+ab+o;
        a1=(a*100)/su;
        b1=(b*100)/su;
        ab1=(ab*100)/su;
        o1=(o*100)/su;*/
       DefaultPieDataset dataset = new DefaultKeyedValuesDataset();
        dataset.setValue("A", a);
        dataset.setValue("B", b);
        dataset.setValue("AB", ab);
        dataset.setValue("O", o);
        
        JFreeChart chart = ChartFactory.createPieChart("Blood Group", dataset, true, true,false);
        
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setStartAngle(0);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        ChartPanel chartPanel =new ChartPanel(chart);
        //chartPanel.setPreferredSize(new java.awt.Dimension(200,80));
        chartjPanel.removeAll();
        chartjPanel.add(chartPanel,BorderLayout.CENTER);
        chartjPanel.validate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        periodComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        periodTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        chartjPanel = new javax.swing.JPanel();

        periodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        periodComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                periodComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Period");

        periodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BloodGroup", "Quant", "Approx Avg Quant  per Day"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(periodTable);

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Statistics of Blood Group ");

        chartjPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(periodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addComponent(backJButton)
                    .addComponent(chartjPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(periodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chartjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void periodComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodComboBoxActionPerformed
        // TODO add your handling code here:
        if(periodComboBox.getSelectedItem()!=null)
        {
            populateTable();
        }
    }//GEN-LAST:event_periodComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JPanel chartjPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> periodComboBox;
    private javax.swing.JTable periodTable;
    // End of variables declaration//GEN-END:variables
}
