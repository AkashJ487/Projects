/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Doctor;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.LabEnterprise;
import Business.Hospital.Doctor;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabAssistantOrganization;
import Business.Organization.Organization;
import Business.Patient.Disability;
import Business.Patient.MedicalTest;
import Business.Patient.Patient;
import Business.Patient.PatientDisease;
import Business.Patient.Treatment;
import Business.Patient.VitalSigns;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.Lab4DocWQ;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author kruti
 */
public class PatientDataMonitoringJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PatientDataMonitoringJPanel
     */
    JPanel userProcessContainer;
    UserAccount account; 
    DoctorOrganization organization; 
    Enterprise enterprise; 
    EcoSystem business;
    Doctor doctor;
    Patient patient;
    PatientDisease aids;
    PatientDisease heart;
    PatientDisease paralysis;
    PatientDisease diabetes;
    PatientDisease bone;
    PatientDisease breast;
    PatientDisease brain;
    PatientDisease gastric;
    PatientDisease liver;
    PatientDisease lung;
   // PatientDisease patientDisease;
    int flag=0;
    public PatientDataMonitoringJPanel(JPanel userProcessContainer, UserAccount account, DoctorOrganization organization, Enterprise enterprise, EcoSystem business, Doctor d) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account=account;
        this.business=business;
        this.organization= organization;
        this.doctor=d;
        patient=null;
        aids=null;
        heart=null;
        paralysis=null;
        diabetes=null;
        bone=null;
        breast=null;
        brain=null;
        gastric=null;
        liver=null;
        lung=null;
        diseaseComboBox.removeAllItems();
        diseaseComboBox.addItem("Aids");
        diseaseComboBox.addItem("Heart Disease");
        diseaseComboBox.addItem("Paralysis");
        diseaseComboBox.addItem("Diabetes");
        diseaseComboBox.addItem("Bone Cancer");
        diseaseComboBox.addItem("Brain Tumor");
        diseaseComboBox.addItem("Breast Cancer");
        diseaseComboBox.addItem("Gastric Cancer");
        diseaseComboBox.addItem("Liver Cancer");
        diseaseComboBox.addItem("Lung Cancer");
        bloodGroupComboBox.removeAllItems();
        bloodGroupComboBox.addItem("A");
        bloodGroupComboBox.addItem("B");
        bloodGroupComboBox.addItem("AB");
        bloodGroupComboBox.addItem("O");
    }
    public void populateMedicalTest()
    {
        //populte medical test
                    DefaultTableModel dtm = (DefaultTableModel) medicalTestTable.getModel();
                    dtm.setRowCount(0);
                    for(int i=patient.getListOfMedicalTests().size()-1;i>=0;i--)
                    {
                        MedicalTest mt = patient.getListOfMedicalTests().get(i);
                        //if(!mt.getResult().isEmpty())
                        //{
                        Object [] row = new Object[3];
                        row[0] = mt.getDate();
                        row[1]=mt;
                        row[2]=mt.getResult();
                        dtm.addRow(row);
                        //patient.getListOfMedicalTests().remove(mt);
                       // }
                    }
                    
    }
    public void populateVitalSigns()
    {
        DefaultTableModel model = (DefaultTableModel) vitalSignsTable.getModel();
                    model.setRowCount(0);
                    for(int i=patient.getMedicalData().getListOfVitalSigns().size()-1;i>=0;i--)
                    { 
                        VitalSigns vs = patient.getMedicalData().getListOfVitalSigns().get(i);
                        Object[] row = new Object[6];
                        row[0] = vs.getDate();
                        row[1] = vs.getPluseRate();
                        row[2] = vs.getTemp();
                        row[3] = vs.getBp();
                        row[4] = vs.getRespirationRate();
                        row[5] = vs.getD().getName();
                        model.addRow(row);    
                    }
    }
    public void populateworkrequestable()
    {
        //populate workrequest
        DefaultTableModel dtm1 = (DefaultTableModel) testRequestJTable.getModel();
        dtm1.setRowCount(0);
        for(WorkRequest work : account.getWorkQueue().getWorkRequestList())
        {
            if((work instanceof Lab4DocWQ) && (!work.getStatus().equals("Received")))
            {
                Lab4DocWQ ldwq = (Lab4DocWQ) work;
                if(ldwq.getPatientId().equals(patient.getID()))
                {
                    Object [] row = new Object[4];
                    row[0] = ldwq.getMessage();
                    row[1] = ldwq.getReceiver();
                    row[2] = ldwq;
                    String result = ldwq.getMedicalTest().getResult();
                    row[3] = result == null ? "Waiting" : result;
                    dtm1.addRow(row);
                }
            }
        }
    }
    
    public void populatetable(PatientDisease pd)
    {
        DefaultTableModel model = (DefaultTableModel) diseaseTable.getModel();
        model.setRowCount(0);
        for(int i=pd.getListOfTreatment().size()-1;i>=0;i--)
        {
            Treatment t = pd.getListOfTreatment().get(i);
            Object[] row = new Object[4];
            row[0] = t;
            row[1] = t.getDoctor().getName();
            row[2] = t.getDoctor().getPhNum();
            row[3] = t.getComments();
            model.addRow(row);
        }
        descTextArea.setText("");
    }
    public void populateDisease()
    {
        for (PatientDisease pd : patient.getMedicalData().getListOfDisease())
                    {
                        if (pd.getName().equals("Aids"))
                        {
                            aidsRadioButton.setSelected(true);
                            aids=pd;
                            shaidsTextField.setText(pd.getShortDescription());
                            ddAidesTextField23.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Heart Disease"))
                        {
                            heartAttackRadioButton.setSelected(true);
                            heart=pd;
                            shHeartTextField.setText(pd.getShortDescription());
                            ddHeartTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Paralysis"))
                        {
                            paralysisRadioButton.setSelected(true);
                            paralysis=pd;
                            shParaTextField.setText(pd.getShortDescription());
                            ddParaTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Diabetes"))
                        {
                            diabetesRadioButton.setSelected(true);
                            diabetes=pd;
                            shDiaTextField.setText(pd.getShortDescription());
                            ddDiaTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Bone Cancer"))
                        {
                            boneCancerRadioButton.setSelected(true);
                            bone=pd;
                            shBoneTextField.setText(pd.getShortDescription());
                            ddBoneTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Breast Cancer"))
                        {
                            breastRadioButton.setSelected(true);
                            breast=pd;
                            shBreastTextField.setText(pd.getShortDescription());
                            ddBreastTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Brain Tumor"))
                        {
                            brainRadioButton.setSelected(true);
                            brain=pd;
                            shBrainTextField.setText(pd.getShortDescription());
                            ddBrainTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Gastric Cancer"))
                        {
                            gastricRadioButton.setSelected(true);
                            gastric=pd;
                            shGasTextField.setText(pd.getShortDescription());
                            ddGasTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Liver Cancer"))
                        {
                            liverRadioButton.setSelected(true);
                            liver=pd;
                            shLiverTextField.setText(pd.getShortDescription());
                            ddLiverTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Lung Cancer"))
                        {
                            lungRadioButton.setSelected(true);
                            lung=pd;
                            shLungTextField.setText(pd.getShortDescription());
                            ddLungTextField.setText(pd.getDetectedDate());
                        }
                        //diseaseComboBox.addItem(pd); 
                    }
    }
    public void populatetable()
    {
        DefaultTableModel model = (DefaultTableModel) diseaseTable.getModel();
        model.setRowCount(0);
        for(PatientDisease pd : patient.getMedicalData().getListOfDisease())
        {
            for(int i=pd.getListOfTreatment().size()-1;i>=0;i--)
            {
                Treatment t = pd.getListOfTreatment().get(i);
                Object[] row = new Object[4];
                row[0] = t;
                row[1] = t.getDoctor().getName();
                row[2] = t.getDoctor().getPhNum();
                row[3] = t.getComments();
                model.addRow(row);
            }
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

        jTextField6 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        stateTextField = new javax.swing.JTextField();
        homePhNumTextField = new javax.swing.JTextField();
        phNumTextField = new javax.swing.JTextField();
        cityTextField = new javax.swing.JTextField();
        streetTextField = new javax.swing.JTextField();
        aptNoTextField = new javax.swing.JTextField();
        countryTextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        zipcodeTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        patientIdTextField = new javax.swing.JTextField();
        loadButton = new javax.swing.JButton();
        basicSaveButton = new javax.swing.JButton();
        maleRadioButton1 = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        bloodGroupComboBox = new javax.swing.JComboBox<>();
        backjButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        autismRadioButton = new javax.swing.JRadioButton();
        chronicRadioButton = new javax.swing.JRadioButton();
        hearingRadioButton = new javax.swing.JRadioButton();
        intellectRadioButton = new javax.swing.JRadioButton();
        dyslxRadioButton = new javax.swing.JRadioButton();
        dyscalRadioButton = new javax.swing.JRadioButton();
        epilepsyRadioButton = new javax.swing.JRadioButton();
        spinaRadioButton = new javax.swing.JRadioButton();
        downRadioButton = new javax.swing.JRadioButton();
        cerebRadioButton = new javax.swing.JRadioButton();
        depressionRadioButton = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        medicalTestTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        testRequestJTable = new javax.swing.JTable(){
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component c = super.prepareRenderer(renderer, row, col);
                Lab4DocWQ p = (Lab4DocWQ) getValueAt(row, 2);
                if ("Complete".equals(p.getStatus())) {
                    c.setBackground(Color.RED);
                    c.setForeground(Color.BLACK);
                } else {
                    c.setBackground(super.getBackground());
                    c.setForeground(super.getForeground());
                }
                return c;
            }
        };
        jLabel30 = new javax.swing.JLabel();
        testTextField = new javax.swing.JTextField();
        reqTestButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        aidsRadioButton = new javax.swing.JRadioButton();
        boneCancerRadioButton = new javax.swing.JRadioButton();
        heartAttackRadioButton = new javax.swing.JRadioButton();
        paralysisRadioButton = new javax.swing.JRadioButton();
        diabetesRadioButton = new javax.swing.JRadioButton();
        breastRadioButton = new javax.swing.JRadioButton();
        brainRadioButton = new javax.swing.JRadioButton();
        gastricRadioButton = new javax.swing.JRadioButton();
        liverRadioButton = new javax.swing.JRadioButton();
        lungRadioButton = new javax.swing.JRadioButton();
        shaidsTextField = new javax.swing.JTextField();
        shHeartTextField = new javax.swing.JTextField();
        shParaTextField = new javax.swing.JTextField();
        shDiaTextField = new javax.swing.JTextField();
        shBoneTextField = new javax.swing.JTextField();
        shBreastTextField = new javax.swing.JTextField();
        shBrainTextField = new javax.swing.JTextField();
        shGasTextField = new javax.swing.JTextField();
        shLiverTextField = new javax.swing.JTextField();
        shLungTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        aidsButton = new javax.swing.JButton();
        heartButton = new javax.swing.JButton();
        paralysisButton = new javax.swing.JButton();
        boneButton = new javax.swing.JButton();
        diabetesButton = new javax.swing.JButton();
        breastButton = new javax.swing.JButton();
        brainButton = new javax.swing.JButton();
        gastricButton = new javax.swing.JButton();
        liverButton = new javax.swing.JButton();
        lungButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        diseaseTable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        descTextArea = new javax.swing.JTextArea();
        saveDescriptionButton = new javax.swing.JButton();
        viewDescButton = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        ddAidesTextField23 = new javax.swing.JTextField();
        ddHeartTextField = new javax.swing.JTextField();
        ddParaTextField = new javax.swing.JTextField();
        ddDiaTextField = new javax.swing.JTextField();
        ddBoneTextField = new javax.swing.JTextField();
        ddBreastTextField = new javax.swing.JTextField();
        ddBrainTextField = new javax.swing.JTextField();
        ddGasTextField = new javax.swing.JTextField();
        ddLiverTextField = new javax.swing.JTextField();
        ddLungTextField = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        diseaseComboBox = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        pulseTextField = new javax.swing.JTextField();
        bpTextField = new javax.swing.JTextField();
        tempTextField = new javax.swing.JTextField();
        respRateTextField = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        vitalSignsTable = new javax.swing.JTable();
        vitalSaveButton = new javax.swing.JButton();

        jTextField6.setText("jTextField3");

        jLabel2.setText("Gender");

        jLabel4.setText("Home Phone Number :");

        jLabel5.setText("Address ");

        jLabel6.setText("Cell Phone Number :");

        jLabel7.setText("Street: ");

        jLabel8.setText("Apt No.:");

        jLabel9.setText("City :");

        jLabel10.setText("State :");

        jLabel11.setText("Country :");

        jLabel13.setText("Blood Group :");

        jLabel15.setText("First Name  :");

        jLabel16.setText("Last Name  :");

        homePhNumTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homePhNumTextFieldActionPerformed(evt);
            }
        });

        phNumTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phNumTextFieldActionPerformed(evt);
            }
        });

        aptNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aptNoTextFieldActionPerformed(evt);
            }
        });

        countryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryTextFieldActionPerformed(evt);
            }
        });

        jLabel20.setText("ZIP Code :");

        zipcodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zipcodeTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Patient ID");

        patientIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientIdTextFieldActionPerformed(evt);
            }
        });

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        basicSaveButton.setText("Save");
        basicSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basicSaveButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(maleRadioButton1);
        maleRadioButton1.setText("Male");
        maleRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(femaleRadioButton);
        femaleRadioButton.setText("Female");

        bloodGroupComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backjButton1)
                        .addGap(105, 105, 105)
                        .addComponent(basicSaveButton))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(streetTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addComponent(homePhNumTextField))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(aptNoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                    .addComponent(stateTextField))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(countryTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(zipcodeTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(firstNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                            .addComponent(patientIdTextField))
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(loadButton)))
                                    .addComponent(maleRadioButton1)
                                    .addComponent(femaleRadioButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lastNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(bloodGroupComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(387, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(patientIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadButton))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(maleRadioButton1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(bloodGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(femaleRadioButton)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(homePhNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(streetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(aptNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(zipcodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(stateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(119, 119, 119)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(basicSaveButton)
                    .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Basic Details", jPanel1);

        autismRadioButton.setText("Autism");
        autismRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autismRadioButtonActionPerformed(evt);
            }
        });

        chronicRadioButton.setText("Chronic Illness");
        chronicRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chronicRadioButtonActionPerformed(evt);
            }
        });

        hearingRadioButton.setText("Hearing Loss Deafness");
        hearingRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hearingRadioButtonActionPerformed(evt);
            }
        });

        intellectRadioButton.setText("Intellectual Disability");
        intellectRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intellectRadioButtonActionPerformed(evt);
            }
        });

        dyslxRadioButton.setText("Dyslexia");
        dyslxRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dyslxRadioButtonActionPerformed(evt);
            }
        });

        dyscalRadioButton.setText("Dyscalculia");
        dyscalRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dyscalRadioButtonActionPerformed(evt);
            }
        });

        epilepsyRadioButton.setText("Epilepsy");
        epilepsyRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                epilepsyRadioButtonActionPerformed(evt);
            }
        });

        spinaRadioButton.setText("Spina Bifida");
        spinaRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spinaRadioButtonActionPerformed(evt);
            }
        });

        downRadioButton.setText("Down Syndrome");
        downRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downRadioButtonActionPerformed(evt);
            }
        });

        cerebRadioButton.setText("Cerebral Palsy");
        cerebRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerebRadioButtonActionPerformed(evt);
            }
        });

        depressionRadioButton.setText("Depression");
        depressionRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depressionRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(depressionRadioButton)
                    .addComponent(cerebRadioButton)
                    .addComponent(downRadioButton)
                    .addComponent(spinaRadioButton)
                    .addComponent(epilepsyRadioButton)
                    .addComponent(dyscalRadioButton)
                    .addComponent(dyslxRadioButton)
                    .addComponent(intellectRadioButton)
                    .addComponent(hearingRadioButton)
                    .addComponent(chronicRadioButton)
                    .addComponent(autismRadioButton))
                .addContainerGap(902, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(autismRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chronicRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hearingRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(intellectRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dyslxRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dyscalRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(epilepsyRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spinaRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(downRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cerebRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(depressionRadioButton)
                .addContainerGap(395, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Disability", jPanel4);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Health Insurance Plan");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Health Plan", "Premium", "Name of organization"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton1.setText("Claim");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Health Plan", "Premium", "Name of organization"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Selected Health Insurance Plan to be clamed");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(355, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(107, 107, 107)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(356, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel17)
                .addGap(203, 203, 203)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(242, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(91, 91, 91)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(481, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Insurance Details", jPanel3);

        medicalTestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Test Name", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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
        jScrollPane3.setViewportView(medicalTestTable);
        if (medicalTestTable.getColumnModel().getColumnCount() > 0) {
            medicalTestTable.getColumnModel().getColumn(0).setResizable(false);
            medicalTestTable.getColumnModel().getColumn(1).setResizable(false);
            medicalTestTable.getColumnModel().getColumn(2).setResizable(false);
        }

        testRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test", "Receiver", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(testRequestJTable);

        jLabel30.setText("Test");

        reqTestButton.setText("Request Test");
        reqTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqTestButtonActionPerformed(evt);
            }
        });

        doneButton.setText("Received");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        delButton.setText("Delete Request");
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(doneButton)
                        .addGap(84, 84, 84)
                        .addComponent(delButton))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(testTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(reqTestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                        .addComponent(jScrollPane7)))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(testTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reqTestButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doneButton)
                    .addComponent(delButton))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Medical Tests", jPanel5);

        aidsRadioButton.setText("AIDS");
        aidsRadioButton.setEnabled(false);
        aidsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aidsRadioButtonActionPerformed(evt);
            }
        });

        boneCancerRadioButton.setText("Bone Cancer");
        boneCancerRadioButton.setEnabled(false);

        heartAttackRadioButton.setText("Heart");
        heartAttackRadioButton.setEnabled(false);

        paralysisRadioButton.setText("Paralysis");
        paralysisRadioButton.setEnabled(false);

        diabetesRadioButton.setText("Diabetes");
        diabetesRadioButton.setEnabled(false);

        breastRadioButton.setText("Breast Cancer");
        breastRadioButton.setEnabled(false);

        brainRadioButton.setText("Brain Tumor");
        brainRadioButton.setEnabled(false);

        gastricRadioButton.setText("Gastric Cancer");
        gastricRadioButton.setEnabled(false);

        liverRadioButton.setText("Liver Cancer");
        liverRadioButton.setEnabled(false);

        lungRadioButton.setText("Lung Cancer");
        lungRadioButton.setEnabled(false);

        jLabel21.setText("Short Description");

        aidsButton.setText("Details");
        aidsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aidsButtonActionPerformed(evt);
            }
        });

        heartButton.setText("Details");
        heartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heartButtonActionPerformed(evt);
            }
        });

        paralysisButton.setText("Details");
        paralysisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paralysisButtonActionPerformed(evt);
            }
        });

        boneButton.setText("Details");
        boneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boneButtonActionPerformed(evt);
            }
        });

        diabetesButton.setText("Details");
        diabetesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diabetesButtonActionPerformed(evt);
            }
        });

        breastButton.setText("Details");
        breastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breastButtonActionPerformed(evt);
            }
        });

        brainButton.setText("Details");
        brainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brainButtonActionPerformed(evt);
            }
        });

        gastricButton.setText("Details");
        gastricButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gastricButtonActionPerformed(evt);
            }
        });

        liverButton.setText("Details");
        liverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liverButtonActionPerformed(evt);
            }
        });

        lungButton.setText("Details");
        lungButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lungButtonActionPerformed(evt);
            }
        });

        diseaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Doctor", "Contact Num", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(diseaseTable);
        if (diseaseTable.getColumnModel().getColumnCount() > 0) {
            diseaseTable.getColumnModel().getColumn(0).setResizable(false);
            diseaseTable.getColumnModel().getColumn(1).setResizable(false);
            diseaseTable.getColumnModel().getColumn(2).setResizable(false);
            diseaseTable.getColumnModel().getColumn(3).setResizable(false);
        }

        descTextArea.setColumns(20);
        descTextArea.setRows(5);
        jScrollPane5.setViewportView(descTextArea);

        saveDescriptionButton.setText("Add Description");
        saveDescriptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDescriptionButtonActionPerformed(evt);
            }
        });

        viewDescButton.setText("View Description");
        viewDescButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDescButtonActionPerformed(evt);
            }
        });

        jLabel22.setText("View");

        jLabel23.setText("Description");

        ddAidesTextField23.setEnabled(false);
        ddAidesTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddAidesTextField23ActionPerformed(evt);
            }
        });

        ddHeartTextField.setEnabled(false);

        ddParaTextField.setEnabled(false);

        ddDiaTextField.setEnabled(false);

        ddBoneTextField.setEnabled(false);

        ddBreastTextField.setEnabled(false);

        ddBrainTextField.setEnabled(false);
        ddBrainTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddBrainTextFieldActionPerformed(evt);
            }
        });

        ddGasTextField.setEnabled(false);

        ddLiverTextField.setEnabled(false);

        ddLungTextField.setEnabled(false);

        jLabel28.setText("Detected Date");

        diseaseComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel29.setText("Disease");

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(viewDescButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(aidsRadioButton)
                                    .addComponent(heartAttackRadioButton))
                                .addGap(67, 67, 67)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel21)
                                    .addComponent(shaidsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                    .addComponent(shHeartTextField)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(paralysisRadioButton)
                                .addGap(53, 53, 53)
                                .addComponent(shParaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(diabetesRadioButton)
                                .addGap(53, 53, 53)
                                .addComponent(shDiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(boneCancerRadioButton)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(lungRadioButton)
                                    .addGap(35, 35, 35)
                                    .addComponent(shLungTextField))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(liverRadioButton)
                                    .addGap(35, 35, 35)
                                    .addComponent(shLiverTextField))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(gastricRadioButton)
                                    .addGap(25, 25, 25)
                                    .addComponent(shGasTextField))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(brainRadioButton)
                                    .addGap(37, 37, 37)
                                    .addComponent(shBrainTextField))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(breastRadioButton)
                                    .addGap(27, 27, 27)
                                    .addComponent(shBreastTextField))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGap(120, 120, 120)
                                    .addComponent(shBoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ddGasTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                .addComponent(ddLiverTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ddLungTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ddBrainTextField, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(ddDiaTextField)
                            .addComponent(ddBreastTextField)
                            .addComponent(ddAidesTextField23)
                            .addComponent(ddBoneTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ddParaTextField)
                            .addComponent(ddHeartTextField))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(paralysisButton)
                            .addComponent(heartButton)
                            .addComponent(aidsButton)
                            .addComponent(diabetesButton)
                            .addComponent(boneButton)
                            .addComponent(breastButton)
                            .addComponent(brainButton)
                            .addComponent(gastricButton)
                            .addComponent(liverButton)
                            .addComponent(lungButton))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(8, 8, 8)
                                .addComponent(diseaseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(saveDescriptionButton))
                            .addComponent(jScrollPane5))))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aidsRadioButton)
                            .addComponent(shaidsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ddAidesTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aidsButton))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(heartAttackRadioButton)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(shHeartTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ddHeartTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(heartButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(paralysisRadioButton)
                            .addComponent(shParaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ddParaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paralysisButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(shDiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ddDiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(diabetesButton))
                            .addComponent(diabetesRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boneCancerRadioButton)
                            .addComponent(shBoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ddBoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boneButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(breastRadioButton)
                            .addComponent(shBreastTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ddBreastTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(breastButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(brainRadioButton)
                            .addComponent(shBrainTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ddBrainTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brainButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gastricRadioButton)
                            .addComponent(shGasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ddGasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gastricButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(liverRadioButton)
                            .addComponent(shLiverTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ddLiverTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(liverButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lungRadioButton)
                            .addComponent(shLungTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ddLungTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lungButton)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveDescriptionButton)
                            .addComponent(diseaseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewDescButton)
                    .addComponent(resetButton))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Critical Details", jPanel2);

        jLabel24.setText("Pluse Rate");

        jLabel25.setText("Bloop Pressure");

        jLabel26.setText("Temperature");

        jLabel27.setText("Respiration Rate");

        vitalSignsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Pluse Rate", "Temperature", "Blood Prureess", "Respiration Rate", "Doctor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(vitalSignsTable);

        vitalSaveButton.setText("Save");
        vitalSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vitalSaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vitalSaveButton)
                            .addComponent(respRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tempTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pulseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(pulseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(bpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(tempTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(respRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vitalSaveButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("VitalSigns", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ddBrainTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddBrainTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddBrainTextFieldActionPerformed

    private void chronicRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chronicRadioButtonActionPerformed
        // TODO add your handling code here:
        if(patient!=null)
        {
            int j=0;
            //Disability disability;
            if(chronicRadioButton.isSelected())
            {
                 for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.ChronicIllness)
                     {
                         j=1;
                         //disability=d;
                         break;
                     }
                 }
                 if (j==0)
                 {
                     patient.getMedicalData().getListOfDisability().add(new Disability(Disability.DisabilityType.ChronicIllness));
                 }
            }
            else
            {
                for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.ChronicIllness)
                     {
                         patient.getMedicalData().getListOfDisability().remove(d);
                     }
                 }
            }        
        }
    }//GEN-LAST:event_chronicRadioButtonActionPerformed

    private void aidsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aidsButtonActionPerformed
        // TODO add your handling code here:
        if(patient==null)
            return;
        if(aids==null)
        {
            JOptionPane.showMessageDialog(null, "Patient doesnt have aids disease");
            /*if(shaidsTextField.getText().isEmpty() || descTextArea.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "Please Enter short description of the disease and treatment details in description field");
            else
            {
                JOptionPane.showMessageDialog(null, "Adding Aids to medical record of patient");
                aidsRadioButton.setSelected(true);
                PatientDisease pd = new PatientDisease();
                pd.setName("Aids");
                Treatment t = new Treatment();
                t.setDoctor(doctor);
                t.setComments(descTextArea.getText());
                pd.getListOfTreatment().add(t);
                patient.getMedicalData().getListOfDisease().add(pd);
            }*/
        }
        else
        {
            populatetable(aids);
            aidsButton.setEnabled(false);
            heartButton.setEnabled(false);
            paralysisButton.setEnabled(false);
            diabetesButton.setEnabled(false);
            boneButton.setEnabled(false);
            breastButton.setEnabled(false);
            brainButton.setEnabled(false);
            lungButton.setEnabled(false);
            liverButton.setEnabled(false);
            gastricButton.setEnabled(false);
            diseaseComboBox.setSelectedItem("Aids");
        
        }
        descTextArea.setText("");
    }//GEN-LAST:event_aidsButtonActionPerformed

    private void heartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heartButtonActionPerformed
        // TODO add your handling code here:
        if(patient==null)
            return;
        if(heart==null)
        {
            JOptionPane.showMessageDialog(null, "Patient doesnt have heart disease");
        }
        else
        {
            populatetable(heart);
            aidsButton.setEnabled(false);
            heartButton.setEnabled(false);
            paralysisButton.setEnabled(false);
            diabetesButton.setEnabled(false);
            boneButton.setEnabled(false);
            breastButton.setEnabled(false);
            brainButton.setEnabled(false);
            lungButton.setEnabled(false);
            liverButton.setEnabled(false);
            gastricButton.setEnabled(false);
        diseaseComboBox.setSelectedItem("Heart Disease");
        }
        descTextArea.setText("");
    }//GEN-LAST:event_heartButtonActionPerformed

    private void paralysisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paralysisButtonActionPerformed
        // TODO add your handling code here:
        if(patient==null)
            return;
        if(paralysis==null)
        {
            JOptionPane.showMessageDialog(null, "Patient doesnt have paralysis");
        }
        else
        {
            populatetable(paralysis);
            aidsButton.setEnabled(false);
            heartButton.setEnabled(false);
            paralysisButton.setEnabled(false);
            diabetesButton.setEnabled(false);
            boneButton.setEnabled(false);
            breastButton.setEnabled(false);
            brainButton.setEnabled(false);
            lungButton.setEnabled(false);
            liverButton.setEnabled(false);
            gastricButton.setEnabled(false);
            diseaseComboBox.setSelectedItem("Paralysis");
        }
        descTextArea.setText("");
    }//GEN-LAST:event_paralysisButtonActionPerformed

    private void diabetesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diabetesButtonActionPerformed
        // TODO add your handling code here:
        if(patient==null)
            return;
        if(diabetes==null)
        {
            JOptionPane.showMessageDialog(null, "Patient doesnt have diabetes");
        }
        else
        {
            populatetable(diabetes);
            aidsButton.setEnabled(false);
            heartButton.setEnabled(false);
            paralysisButton.setEnabled(false);
            diabetesButton.setEnabled(false);
            boneButton.setEnabled(false);
            breastButton.setEnabled(false);
            brainButton.setEnabled(false);
            lungButton.setEnabled(false);
            liverButton.setEnabled(false);
            gastricButton.setEnabled(false);
            diseaseComboBox.setSelectedItem("Diabetes");
        }
        descTextArea.setText("");
    }//GEN-LAST:event_diabetesButtonActionPerformed

    private void boneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boneButtonActionPerformed
        // TODO add your handling code here:
        if(patient==null)
            return;
        if(bone==null)
        {
            JOptionPane.showMessageDialog(null, "Patient doesnt have bone cancer");
        }
        else
        {
            populatetable(bone);
            aidsButton.setEnabled(false);
            heartButton.setEnabled(false);
            paralysisButton.setEnabled(false);
            diabetesButton.setEnabled(false);
            boneButton.setEnabled(false);
            breastButton.setEnabled(false);
            brainButton.setEnabled(false);
            lungButton.setEnabled(false);
            liverButton.setEnabled(false);
            gastricButton.setEnabled(false);
            diseaseComboBox.setSelectedItem("Bone Cancer");
        
        }
        descTextArea.setText("");
    }//GEN-LAST:event_boneButtonActionPerformed

    private void breastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breastButtonActionPerformed
        // TODO add your handling code here:
        if(patient==null)
            return;
        if(breast==null)
        {
            JOptionPane.showMessageDialog(null, "Patient doesnt have breast cancer");
        }
        else
        {
            populatetable(breast);
            aidsButton.setEnabled(false);
            heartButton.setEnabled(false);
            paralysisButton.setEnabled(false);
            diabetesButton.setEnabled(false);
            boneButton.setEnabled(false);
            breastButton.setEnabled(false);
            brainButton.setEnabled(false);
            lungButton.setEnabled(false);
            liverButton.setEnabled(false);
            gastricButton.setEnabled(false);
            diseaseComboBox.setSelectedItem("Brain Tumor");
        
        }
        descTextArea.setText("");
    }//GEN-LAST:event_breastButtonActionPerformed

    private void brainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brainButtonActionPerformed
        // TODO add your handling code here:
        if(patient==null)
            return;
        if(brain==null)
        {
            JOptionPane.showMessageDialog(null, "Patient doesnt have brain tumor");
        }
        else
        {
            populatetable(brain);
            aidsButton.setEnabled(false);
            heartButton.setEnabled(false);
            paralysisButton.setEnabled(false);
            diabetesButton.setEnabled(false);
            boneButton.setEnabled(false);
            breastButton.setEnabled(false);
            brainButton.setEnabled(false);
            lungButton.setEnabled(false);
            liverButton.setEnabled(false);
            gastricButton.setEnabled(false);
            diseaseComboBox.setSelectedItem("Breast Cancer");
        }
        descTextArea.setText("");
    }//GEN-LAST:event_brainButtonActionPerformed

    private void gastricButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gastricButtonActionPerformed
        // TODO add your handling code here:
        if(patient==null)
            return;
        if(gastric==null)
        {
            JOptionPane.showMessageDialog(null, "Patient doesnt have brain gastric cancer");
        }
        else
        {
            populatetable(gastric);
            aidsButton.setEnabled(false);
            heartButton.setEnabled(false);
            paralysisButton.setEnabled(false);
            diabetesButton.setEnabled(false);
            boneButton.setEnabled(false);
            breastButton.setEnabled(false);
            brainButton.setEnabled(false);
            lungButton.setEnabled(false);
            liverButton.setEnabled(false);
            gastricButton.setEnabled(false);
            diseaseComboBox.setSelectedItem("Gastric Cancer");
        }
        descTextArea.setText("");
    }//GEN-LAST:event_gastricButtonActionPerformed

    private void liverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liverButtonActionPerformed
        // TODO add your handling code here:
        if(patient==null)
            return;
        if(liver==null)
        {
            JOptionPane.showMessageDialog(null, "Patient doesnt have liver cancer");
        }
        else
        {
            populatetable(liver);
            aidsButton.setEnabled(false);
            heartButton.setEnabled(false);
            paralysisButton.setEnabled(false);
            diabetesButton.setEnabled(false);
            boneButton.setEnabled(false);
            breastButton.setEnabled(false);
            brainButton.setEnabled(false);
            lungButton.setEnabled(false);
            liverButton.setEnabled(false);
            gastricButton.setEnabled(false);
            diseaseComboBox.setSelectedItem("Liver Cancer");
        }
        descTextArea.setText("");
    }//GEN-LAST:event_liverButtonActionPerformed

    private void lungButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lungButtonActionPerformed
        // TODO add your handling code here:
        if(patient==null)
            return;
        if(lung==null)
        {
            JOptionPane.showMessageDialog(null, "Patient doesnt have lung cancer");
        }
        else
        {
            populatetable(lung);
            aidsButton.setEnabled(false);
            heartButton.setEnabled(false);
            paralysisButton.setEnabled(false);
            diabetesButton.setEnabled(false);
            boneButton.setEnabled(false);
            breastButton.setEnabled(false);
            brainButton.setEnabled(false);
            lungButton.setEnabled(false);
            liverButton.setEnabled(false);
            gastricButton.setEnabled(false);
            diseaseComboBox.setSelectedItem("Lung Cancer");
        }
        descTextArea.setText("");
    }//GEN-LAST:event_lungButtonActionPerformed

    private void saveDescriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDescriptionButtonActionPerformed
        // TODO add your handling code here:
        if(patient==null)
            return;
        if(diseaseComboBox.getSelectedItem()==null)
            JOptionPane.showMessageDialog(null, "please select a disease before adding description", "Error", 0);
        else
        {
            int t=0;
            PatientDisease pd=null;
            for(PatientDisease patientDisease : patient.getMedicalData().getListOfDisease())
            {
                if(patientDisease.getName().equals(String.valueOf(diseaseComboBox.getSelectedItem())))
                {
                    pd=patientDisease;
                    t=1;
                    break;
                }
            }
            if(t==0)
            {
                pd = new PatientDisease();
                pd.setName(String.valueOf(diseaseComboBox.getSelectedItem()));
                patient.getMedicalData().getListOfDisease().add(pd);
            }
            if (pd.getName().equals("Aids"))
            {
                if(shaidsTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter short description of the detected disease");
                    return;
                }
                else
                    pd.setShortDescription(shaidsTextField.getText());
            }
            else if (pd.getName().equals("Heart Disease"))
            {
                if(shHeartTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter short description of the detected disease");
                    return;
                }
                else
                    pd.setShortDescription(shHeartTextField.getText());
            }
            else if (pd.getName().equals("Paralysis"))
            {
                if(shParaTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter short description of the detected disease");
                    return;
                }
                else
                    pd.setShortDescription(shParaTextField.getText());
            }
            else if (pd.getName().equals("Diabetes"))
            {
                if(shDiaTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter short description of the detected disease");
                    return;
                }
                else
                    pd.setShortDescription(shDiaTextField.getText());
            }
            else if (pd.getName().equals("Bone Cancer"))
            {
                if(shBoneTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter short description of the detected disease");
                    return;
                }
                else
                    pd.setShortDescription(shBoneTextField.getText());
            }
            else if (pd.getName().equals("Breast Cancer"))
            {
                if(shBreastTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter short description of the detected disease");
                    return;
                }
                else
                    pd.setShortDescription(shBreastTextField.getText());
            }
            else if (pd.getName().equals("Brain Tumor"))
            {
                if(shBrainTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter short description of the detected disease");
                    return;
                }
                else
                    pd.setShortDescription(shBrainTextField.getText());
            }
            else if (pd.getName().equals("Gastric Cancer"))
            {
                if(shGasTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter short description of the detected disease");
                    return;
                }
                else
                    pd.setShortDescription(shGasTextField.getText());
            }
            else if (pd.getName().equals("Liver Cancer"))
            {
                if(shLiverTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter short description of the detected disease");
                    return;
                }
                else
                    pd.setShortDescription(shLiverTextField.getText());
            }
            else if (pd.getName().equals("Lung Cancer"))
            {
                if(shLungTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter short description of the detected disease");
                    return;
                }
                else
                    pd.setShortDescription(shLungTextField.getText());
            }
            Treatment treatment=new Treatment();
            treatment.setDoctor(doctor);
            treatment.setComments(descTextArea.getText());
            pd.getListOfTreatment().add(treatment);
            populateDisease();
            populatetable(pd);
            descTextArea.setText("");
           // loadButtonActionPerformed(java.awt.event.ActionEvent evt);
        }
    }//GEN-LAST:event_saveDescriptionButtonActionPerformed

    private void autismRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autismRadioButtonActionPerformed
        // TODO add your handling code here:
        if(patient!=null)
        {
            int j=0;
            //Disability disability;
            if(autismRadioButton.isSelected())
            {
                 for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.Autism)
                     {
                         j=1;
                         //disability=d;
                         break;
                     }
                 }
                 if (j==0)
                 {
                     patient.getMedicalData().getListOfDisability().add(new Disability(Disability.DisabilityType.Autism));
                 }
            }
            else
            {
                for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.Autism)
                     {
                         patient.getMedicalData().getListOfDisability().remove(d);
                     }
                 }
            }        
        }
    }//GEN-LAST:event_autismRadioButtonActionPerformed

    private void hearingRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hearingRadioButtonActionPerformed
        // TODO add your handling code here:
        if(patient!=null)
        {
            int j=0;
            //Disability disability;
            if(hearingRadioButton.isSelected())
            {
                 for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.HearingLossAndDeafness)
                     {
                         j=1;
                         //disability=d;
                         break;
                     }
                 }
                 if (j==0)
                 {
                     patient.getMedicalData().getListOfDisability().add(new Disability(Disability.DisabilityType.HearingLossAndDeafness));
                 }
            }
            else
            {
                for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.HearingLossAndDeafness)
                     {
                         patient.getMedicalData().getListOfDisability().remove(d);
                     }
                 }
            }        
        }
    }//GEN-LAST:event_hearingRadioButtonActionPerformed

    private void intellectRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intellectRadioButtonActionPerformed
        // TODO add your handling code here:
        if(patient!=null)
        {
            int j=0;
            //Disability disability;
            if(intellectRadioButton.isSelected())
            {
                 for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.IntellectualDisability)
                     {
                         j=1;
                         //disability=d;
                         break;
                     }
                 }
                 if (j==0)
                 {
                     patient.getMedicalData().getListOfDisability().add(new Disability(Disability.DisabilityType.IntellectualDisability));
                 }
            }
            else
            {
                for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.IntellectualDisability)
                     {
                         patient.getMedicalData().getListOfDisability().remove(d);
                     }
                 }
            }        
        }
    }//GEN-LAST:event_intellectRadioButtonActionPerformed

    private void dyslxRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dyslxRadioButtonActionPerformed
        // TODO add your handling code here:
        if(patient!=null)
        {
            int j=0;
            //Disability disability;
            if(dyslxRadioButton.isSelected())
            {
                 for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.Dyslexia)
                     {
                         j=1;
                         //disability=d;
                         break;
                     }
                 }
                 if (j==0)
                 {
                     patient.getMedicalData().getListOfDisability().add(new Disability(Disability.DisabilityType.Dyslexia));
                 }
            }
            else
            {
                for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.Dyslexia)
                     {
                         patient.getMedicalData().getListOfDisability().remove(d);
                     }
                 }
            }        
        }
    }//GEN-LAST:event_dyslxRadioButtonActionPerformed

    private void dyscalRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dyscalRadioButtonActionPerformed
        // TODO add your handling code here:
        if(patient!=null)
        {
            int j=0;
            //Disability disability;
            if(dyscalRadioButton.isSelected())
            {
                 for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.Dyscalculia)
                     {
                         j=1;
                         //disability=d;
                         break;
                     }
                 }
                 if (j==0)
                 {
                     patient.getMedicalData().getListOfDisability().add(new Disability(Disability.DisabilityType.Dyscalculia));
                 }
            }
            else
            {
                for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.Dyscalculia)
                     {
                         patient.getMedicalData().getListOfDisability().remove(d);
                     }
                 }
            }        
        }
    }//GEN-LAST:event_dyscalRadioButtonActionPerformed

    private void epilepsyRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_epilepsyRadioButtonActionPerformed
        // TODO add your handling code here:
        if(patient!=null)
        {
            int j=0;
            //Disability disability;
            if(epilepsyRadioButton.isSelected())
            {
                 for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.Epilepsy)
                     {
                         j=1;
                         //disability=d;
                         break;
                     }
                 }
                 if (j==0)
                 {
                     patient.getMedicalData().getListOfDisability().add(new Disability(Disability.DisabilityType.Epilepsy));
                 }
            }
            else
            {
                for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.Epilepsy)
                     {
                         patient.getMedicalData().getListOfDisability().remove(d);
                     }
                 }
            }        
        }
    }//GEN-LAST:event_epilepsyRadioButtonActionPerformed

    private void spinaRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spinaRadioButtonActionPerformed
        // TODO add your handling code here:
        if(patient!=null)
        {
            int j=0;
            //Disability disability;
            if(spinaRadioButton.isSelected())
            {
                 for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.SpinaBifida)
                     {
                         j=1;
                         //disability=d;
                         break;
                     }
                 }
                 if (j==0)
                 {
                     patient.getMedicalData().getListOfDisability().add(new Disability(Disability.DisabilityType.SpinaBifida));
                 }
            }
            else
            {
                for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.SpinaBifida)
                     {
                         patient.getMedicalData().getListOfDisability().remove(d);
                     }
                 }
            }        
        }
    }//GEN-LAST:event_spinaRadioButtonActionPerformed

    private void downRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downRadioButtonActionPerformed
        // TODO add your handling code here:
        if(patient!=null)
        {
            int j=0;
            //Disability disability;
            if(downRadioButton.isSelected())
            {
                 for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.DownSyndrome)
                     {
                         j=1;
                         //disability=d;
                         break;
                     }
                 }
                 if (j==0)
                 {
                     patient.getMedicalData().getListOfDisability().add(new Disability(Disability.DisabilityType.DownSyndrome));
                 }
            }
            else
            {
                for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.DownSyndrome)
                     {
                         patient.getMedicalData().getListOfDisability().remove(d);
                     }
                 }
            }        
        }
    }//GEN-LAST:event_downRadioButtonActionPerformed

    private void cerebRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerebRadioButtonActionPerformed
        // TODO add your handling code here:
        if(patient!=null)
        {
            int j=0;
            //Disability disability;
            if(cerebRadioButton.isSelected())
            {
                 for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.CerebralPalsy)
                     {
                         j=1;
                         //disability=d;
                         break;
                     }
                 }
                 if (j==0)
                 {
                     patient.getMedicalData().getListOfDisability().add(new Disability(Disability.DisabilityType.CerebralPalsy));
                 }
            }
            else
            {
                for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.CerebralPalsy)
                     {
                         patient.getMedicalData().getListOfDisability().remove(d);
                     }
                 }
            }        
        }
    }//GEN-LAST:event_cerebRadioButtonActionPerformed

    private void depressionRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depressionRadioButtonActionPerformed
        // TODO add your handling code here:
        if(patient!=null)
        {
            int j=0;
            //Disability disability;
            if(depressionRadioButton.isSelected())
            {
                 for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.Depression)
                     {
                         j=1;
                         //disability=d;
                         break;
                     }
                 }
                 if (j==0)
                 {
                     patient.getMedicalData().getListOfDisability().add(new Disability(Disability.DisabilityType.Depression));
                 }
            }
            else
            {
                for(Disability d : patient.getMedicalData().getListOfDisability())
                 {
                     if(d.getDisabilityType()==Disability.DisabilityType.Depression)
                     {
                         patient.getMedicalData().getListOfDisability().remove(d);
                     }
                 }
            }        
        }
    }//GEN-LAST:event_depressionRadioButtonActionPerformed

    private void vitalSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vitalSaveButtonActionPerformed
        // TODO add your handling code here:
        if(patient==null)
            return;
        if(tempTextField.getText().isEmpty() || pulseTextField.getText().isEmpty() || bpTextField.getText().isEmpty() || respRateTextField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "please enter all the fields", "Error", 0);
        }
        else
        {
            try
            {
                VitalSigns vs = new VitalSigns();
                vs.setBp(Float.parseFloat(bpTextField.getText()));
                vs.setTemp(Float.parseFloat(tempTextField.getText()));
                vs.setRespirationRate(Float.parseFloat(respRateTextField.getText()));
                vs.setPluseRate(Float.parseFloat(pulseTextField.getText()));
                vs.setD(doctor);
                patient.getMedicalData().getListOfVitalSigns().add(vs);
                populateVitalSigns();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "please enter numeric values in all the fields", "Error", 0);
            }
        }
    }//GEN-LAST:event_vitalSaveButtonActionPerformed

    private void viewDescButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDescButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = diseaseTable.getSelectedRow();
        if (selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null, "Please select a row ", "Warning", JOptionPane.WARNING_MESSAGE);
        } 
        else 
        {

            Treatment p = (Treatment) diseaseTable.getValueAt(selectedRow, 0);
            descTextArea.setText(p.getComments());
            saveDescriptionButton.setEnabled(false);
            diseaseComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_viewDescButtonActionPerformed

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = testRequestJTable.getSelectedRow();
        if (selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null, "Please select a row ", "Warning", JOptionPane.WARNING_MESSAGE);
        } 
        else 
        {

            Lab4DocWQ ldwq = (Lab4DocWQ) testRequestJTable.getValueAt(selectedRow, 2);
            if(ldwq.getStatus().equals("Complete"))
            {
                MedicalTest mt = ldwq.getMedicalTest();
                patient.getListOfMedicalTests().add(mt);
                ldwq.setStatus("Received");
            }
            else
                JOptionPane.showMessageDialog(null, "The request must be completed ", "Warning", 2);
            populateworkrequestable();
            populateMedicalTest();
        }
    
    }//GEN-LAST:event_doneButtonActionPerformed

    private void aidsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aidsRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aidsRadioButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        bloodGroupComboBox.removeAllItems();
        bloodGroupComboBox.addItem("A");
        bloodGroupComboBox.addItem("B");
        bloodGroupComboBox.addItem("AB");
        bloodGroupComboBox.addItem("O");
        descTextArea.setText("");
        saveDescriptionButton.setEnabled(true);
        diseaseComboBox.setEnabled(true);
        aidsButton.setEnabled(true);
        heartButton.setEnabled(true);
            paralysisButton.setEnabled(true);
            diabetesButton.setEnabled(true);
            boneButton.setEnabled(true);
            breastButton.setEnabled(true);
            brainButton.setEnabled(true);
            lungButton.setEnabled(true);
            liverButton.setEnabled(true);
            gastricButton.setEnabled(true);
            diseaseComboBox.removeAllItems();
        diseaseComboBox.addItem("Aids");
        diseaseComboBox.addItem("Heart Disease");
        diseaseComboBox.addItem("Paralysis");
        diseaseComboBox.addItem("Diabetes");
        diseaseComboBox.addItem("Bone Cancer");
        diseaseComboBox.addItem("Brain Tumor");
        diseaseComboBox.addItem("Breast Cancer");
        diseaseComboBox.addItem("Gastric Cancer");
        diseaseComboBox.addItem("Liver Cancer");
        diseaseComboBox.addItem("Lung Cancer");
        populateDisease();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void ddAidesTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddAidesTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddAidesTextField23ActionPerformed

    private void reqTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqTestButtonActionPerformed
        // TODO add your handling code here:
        if(testTextField.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Please enter the test to be carried out", "Error", 0);
        else
        {
            Lab4DocWQ lab4DocWQ = new Lab4DocWQ();
            MedicalTest mt = new MedicalTest();
            mt.setName(testTextField.getText());
            lab4DocWQ.setMedicalTest(mt);
            lab4DocWQ.setMessage(testTextField.getText());
            lab4DocWQ.setPatientId(patient.getID());
            lab4DocWQ.setSender(account);
            lab4DocWQ.setStatus("Requested");
            Organization org = null;
            Enterprise ent = null;
            for (Enterprise e1 : enterprise.getNetwork().getEnterpriseDirectory().getEnterpriseList()){
                if (e1 instanceof LabEnterprise){
                    ent = e1;
                    for(Organization o1: ent.getOrganizationDirectory().getOrganizationList())
                    {
                        if(o1 instanceof LabAssistantOrganization)
                        {
                            org = o1;
                            break;
                        }
                    }
                    break;
                }
            }
            if (org!=null){
                org.getWorkQueue().getWorkRequestList().add(lab4DocWQ);
            account.getWorkQueue().getWorkRequestList().add(lab4DocWQ);
            }
            populateworkrequestable();
            
        }
    }//GEN-LAST:event_reqTestButtonActionPerformed

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow= testRequestJTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select the row to delete the account", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{

            WorkRequest p=(WorkRequest) testRequestJTable.getValueAt(selectedRow, 2);

            // s.getWorkQueue().getWorkRequestList().remove(p);
            organization.getWorkQueue().getWorkRequestList().remove(p);
            account.getWorkQueue().getWorkRequestList().remove(p);
            //business.getWorkQueue().getWorkRequestList().remove(p);
            //him.getWorkQueue().getWorkRequestList().remove(p);
            JOptionPane.showMessageDialog(null, "You have successfully deleted the test request");
            populateworkrequestable();
        }
    }//GEN-LAST:event_delButtonActionPerformed

    private void basicSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basicSaveButtonActionPerformed
        // TODO add your handling code here:
        
        if(patientIdTextField.getText().isEmpty() || firstNameTextField.getText().isEmpty() || lastNameTextField.getText().isEmpty()
                || streetTextField.getText().isEmpty() || aptNoTextField.getText().isEmpty() 
                || cityTextField.getText().isEmpty() || stateTextField.getText().isEmpty() || countryTextField.getText().isEmpty()
                || zipcodeTextField.getText().isEmpty())
        JOptionPane.showMessageDialog(null, "Please Fill all the details", "Error", 0);
        else
        {
            if(business.getPatientDirectory().checkPatientId(patientIdTextField.getText()))
            {
                Patient p =business.getPatientDirectory().addPatient();
                p.setAptNo(aptNoTextField.getText());
                p.setStreet(streetTextField.getText());
                p.setState(stateTextField.getText());
                p.setZipcode(zipcodeTextField.getText());
                p.setBloodGroup(String.valueOf(bloodGroupComboBox.getSelectedItem()));
                p.setCity(cityTextField.getText());
                p.setCountry(countryTextField.getText());
                // p.setDob(dobTextField.getText());
                p.setFirstname(firstNameTextField.getText());
                if(maleRadioButton1.isSelected())
                    p.setGender("M");
                else if (femaleRadioButton.isSelected())
                    p.setGender("F");
                p.setHomePhNum(homePhNumTextField.getText());
                p.setID(patientIdTextField.getText());
                p.setLastName(lastNameTextField.getText());
                p.setPhNum(phNumTextField.getText());
                loadButton.setEnabled(false);
                basicSaveButton.setEnabled(false);
            }
            else
            JOptionPane.showMessageDialog(null, "Patient Id already assigned to some Patient,press load to see details of the given id or enter another ID", TOOL_TIP_TEXT_KEY, HEIGHT);
        }
    }//GEN-LAST:event_basicSaveButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        // TODO add your handling code here:
        int temp=0;
        if (patientIdTextField.getText().isEmpty())
        JOptionPane.showMessageDialog(null, "Please enter the id", "Error", 0);
        else
        {
            //diseaseComboBox.removeAllItems();
            for(Patient p : business.getPatientDirectory().getListOfPatient())
            {
                if(p.getID().equals(patientIdTextField.getText()))
                {
                    patient=p;
                    firstNameTextField.setText(p.getFirstname());
                    lastNameTextField.setText(p.getLastName());
                    if(p.getGender().equals("M"))
                        maleRadioButton1.setSelected(true);
                    else 
                        femaleRadioButton.setSelected(true);
                    phNumTextField.setText(p.getPhNum());
                    homePhNumTextField.setText(p.getHomePhNum());
                    //dobTextField.setText(p.getDob());
                    bloodGroupComboBox.setSelectedItem(p.getBloodGroup());
                    aptNoTextField.setText(p.getAptNo());
                    streetTextField.setText(p.getStreet());
                    cityTextField.setText(p.getCity());
                    stateTextField.setText(p.getState());
                    countryTextField.setText(p.getCountry());
                    zipcodeTextField.setText(p.getZipcode());

                    for(Disability d : p.getMedicalData().getListOfDisability())
                    {
                        if(d.getDisabilityType()!=null)
                        switch (d.getDisabilityType()) {
                            case Autism:
                            autismRadioButton.setSelected(true);
                            break;
                            case CerebralPalsy:
                            cerebRadioButton.setSelected(true);
                            break;
                            case ChronicIllness:
                            chronicRadioButton.setSelected(true);
                            break;
                            case Depression:
                            depressionRadioButton.setSelected(true);
                            break;
                            case DownSyndrome:
                            downRadioButton.setSelected(true);
                            break;
                            case Dyscalculia:
                            dyscalRadioButton.setSelected(true);
                            break;
                            case Dyslexia:
                            dyslxRadioButton.setSelected(true);
                            break;
                            case Epilepsy:
                            epilepsyRadioButton.setSelected(true);
                            break;
                            case HearingLossAndDeafness:
                            hearingRadioButton.setSelected(true);
                            break;
                            case IntellectualDisability:
                            intellectRadioButton.setSelected(true);
                            break;
                            case SpinaBifida:
                            spinaRadioButton.setSelected(true);
                            break;
                            default:
                            break;
                        }
                    }
                    /*for (PatientDisease pd : p.getMedicalData().getListOfDisease())
                    {
                        if (pd.getName().equals("Aids"))
                        {
                            aidsRadioButton.setSelected(true);
                            aids=pd;
                            shaidsTextField.setText(pd.getShortDescription());
                            ddAidesTextField23.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Heart Disease"))
                        {
                            heartAttackRadioButton.setSelected(true);
                            heart=pd;
                            shHeartTextField.setText(pd.getShortDescription());
                            ddHeartTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Paralysis"))
                        {
                            paralysisRadioButton.setSelected(true);
                            paralysis=pd;
                            shParaTextField.setText(pd.getShortDescription());
                            ddParaTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Diabetes"))
                        {
                            diabetesRadioButton.setSelected(true);
                            diabetes=pd;
                            shDiaTextField.setText(pd.getShortDescription());
                            ddDiaTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Bone Cancer"))
                        {
                            boneCancerRadioButton.setSelected(true);
                            bone=pd;
                            shBoneTextField.setText(pd.getShortDescription());
                            ddBoneTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Breast Cancer"))
                        {
                            breastRadioButton.setSelected(true);
                            breast=pd;
                            shBreastTextField.setText(pd.getShortDescription());
                            ddBreastTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Brain Tumor"))
                        {
                            brainRadioButton.setSelected(true);
                            brain=pd;
                            shBrainTextField.setText(pd.getShortDescription());
                            ddBrainTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Gastric Cancer"))
                        {
                            gastricRadioButton.setSelected(true);
                            gastric=pd;
                            shGasTextField.setText(pd.getShortDescription());
                            ddGasTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Liver Cancer"))
                        {
                            liverRadioButton.setSelected(true);
                            liver=pd;
                            shLiverTextField.setText(pd.getShortDescription());
                            ddLiverTextField.setText(pd.getDetectedDate());
                        }
                        else if (pd.getName().equals("Lung Cancer"))
                        {
                            lungRadioButton.setSelected(true);
                            lung=pd;
                            shLungTextField.setText(pd.getShortDescription());
                            ddLungTextField.setText(pd.getDetectedDate());
                        }
                        //diseaseComboBox.addItem(pd);
                    }*/
                    populatetable();
                    populateDisease();
                    populateVitalSigns();
                    populateMedicalTest();
                    temp=1;
                    populateworkrequestable();
                    basicSaveButton.setEnabled(false);
                    loadButton.setEnabled(false);
                }
            }
            if(temp==0)
            JOptionPane.showMessageDialog(null, "Invalid Patient Id", "Error", 0);
        }
    }//GEN-LAST:event_loadButtonActionPerformed

    private void patientIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientIdTextFieldActionPerformed

    private void zipcodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zipcodeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zipcodeTextFieldActionPerformed

    private void countryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryTextFieldActionPerformed

    private void aptNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aptNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aptNoTextFieldActionPerformed

    private void phNumTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phNumTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phNumTextFieldActionPerformed

    private void homePhNumTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homePhNumTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homePhNumTextFieldActionPerformed

    private void maleRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleRadioButton1ActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aidsButton;
    private javax.swing.JRadioButton aidsRadioButton;
    private javax.swing.JTextField aptNoTextField;
    private javax.swing.JRadioButton autismRadioButton;
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton basicSaveButton;
    private javax.swing.JComboBox<String> bloodGroupComboBox;
    private javax.swing.JButton boneButton;
    private javax.swing.JRadioButton boneCancerRadioButton;
    private javax.swing.JTextField bpTextField;
    private javax.swing.JButton brainButton;
    private javax.swing.JRadioButton brainRadioButton;
    private javax.swing.JButton breastButton;
    private javax.swing.JRadioButton breastRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cerebRadioButton;
    private javax.swing.JRadioButton chronicRadioButton;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JTextField countryTextField;
    private javax.swing.JTextField ddAidesTextField23;
    private javax.swing.JTextField ddBoneTextField;
    private javax.swing.JTextField ddBrainTextField;
    private javax.swing.JTextField ddBreastTextField;
    private javax.swing.JTextField ddDiaTextField;
    private javax.swing.JTextField ddGasTextField;
    private javax.swing.JTextField ddHeartTextField;
    private javax.swing.JTextField ddLiverTextField;
    private javax.swing.JTextField ddLungTextField;
    private javax.swing.JTextField ddParaTextField;
    private javax.swing.JButton delButton;
    private javax.swing.JRadioButton depressionRadioButton;
    private javax.swing.JTextArea descTextArea;
    private javax.swing.JButton diabetesButton;
    private javax.swing.JRadioButton diabetesRadioButton;
    private javax.swing.JComboBox diseaseComboBox;
    private javax.swing.JTable diseaseTable;
    private javax.swing.JButton doneButton;
    private javax.swing.JRadioButton downRadioButton;
    private javax.swing.JRadioButton dyscalRadioButton;
    private javax.swing.JRadioButton dyslxRadioButton;
    private javax.swing.JRadioButton epilepsyRadioButton;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JButton gastricButton;
    private javax.swing.JRadioButton gastricRadioButton;
    private javax.swing.JRadioButton hearingRadioButton;
    private javax.swing.JRadioButton heartAttackRadioButton;
    private javax.swing.JButton heartButton;
    private javax.swing.JTextField homePhNumTextField;
    private javax.swing.JRadioButton intellectRadioButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton liverButton;
    private javax.swing.JRadioButton liverRadioButton;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton lungButton;
    private javax.swing.JRadioButton lungRadioButton;
    private javax.swing.JRadioButton maleRadioButton1;
    private javax.swing.JTable medicalTestTable;
    private javax.swing.JButton paralysisButton;
    private javax.swing.JRadioButton paralysisRadioButton;
    private javax.swing.JTextField patientIdTextField;
    private javax.swing.JTextField phNumTextField;
    private javax.swing.JTextField pulseTextField;
    private javax.swing.JButton reqTestButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextField respRateTextField;
    private javax.swing.JButton saveDescriptionButton;
    private javax.swing.JTextField shBoneTextField;
    private javax.swing.JTextField shBrainTextField;
    private javax.swing.JTextField shBreastTextField;
    private javax.swing.JTextField shDiaTextField;
    private javax.swing.JTextField shGasTextField;
    private javax.swing.JTextField shHeartTextField;
    private javax.swing.JTextField shLiverTextField;
    private javax.swing.JTextField shLungTextField;
    private javax.swing.JTextField shParaTextField;
    private javax.swing.JTextField shaidsTextField;
    private javax.swing.JRadioButton spinaRadioButton;
    private javax.swing.JTextField stateTextField;
    private javax.swing.JTextField streetTextField;
    private javax.swing.JTextField tempTextField;
    private javax.swing.JTable testRequestJTable;
    private javax.swing.JTextField testTextField;
    private javax.swing.JButton viewDescButton;
    private javax.swing.JButton vitalSaveButton;
    private javax.swing.JTable vitalSignsTable;
    private javax.swing.JTextField zipcodeTextField;
    // End of variables declaration//GEN-END:variables
}
