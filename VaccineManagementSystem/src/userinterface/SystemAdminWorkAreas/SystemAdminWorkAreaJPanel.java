/*
 * AdminWorkAreaJPanel.java
 *
 * Created on October 10, 2008, 8:50 AM
 */
package userinterface.SystemAdminWorkAreas;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import userinterface.SystemAdminWorkAreas.ManageVaccineDirectoryJPanel;
import userinterface.SystemAdminWorkAreas.ManageDiseaseDirectoryJPanel;
import userinterface.SystemAdminWorkAreas.ManageDiseaseDirectoryJPanel;

/**
 *
 * @author JAGTAP
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    EcoSystem system;

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;

        populateTree();
    }

    public void populateTree() {
        
        DefaultTreeModel model = (DefaultTreeModel) JTree.getModel();

        
        
        ArrayList<Network> networkList = system.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        Network network;
        Enterprise enterprise;
        Organization organization;

        DefaultMutableTreeNode networks = new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);

        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        for (int i = 0; i < networkList.size(); i++) {
            network = networkList.get(i);
            networkNode = new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);

            enterpriseList = network.getEnterpriseDirectory().getEnterpriseList();

            for (int j = 0; j < enterpriseList.size(); j++) {
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);

                organizationList = enterprise.getOrganizationDirectory().getOrganizationList();
                for (int k = 0; k < organizationList.size(); k++) {
                    organization = organizationList.get(k);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }

        model.reload();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        manageNetworkJButton = new javax.swing.JButton();
        manageAdminJButton = new javax.swing.JButton();
        manageEnterpriseJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        selectedNodeJLabel = new javax.swing.JLabel();
        btnVaccine = new javax.swing.JButton();
        btnDisease = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTree = new javax.swing.JTree();

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(150);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageNetworkJButton.setText("Manage Network");
        manageNetworkJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageNetworkJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(manageNetworkJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 102, 179, -1));

        manageAdminJButton.setText("Manage Enterprise Admin");
        manageAdminJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAdminJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(manageAdminJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        manageEnterpriseJButton.setText("Manage Enterprise");
        manageEnterpriseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnterpriseJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(manageEnterpriseJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 179, -1));

        jLabel1.setText("Selected Node:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 36, -1, -1));

        selectedNodeJLabel.setText("<view_selected_node>");
        jPanel1.add(selectedNodeJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 36, -1, -1));

        btnVaccine.setText("Manage Vaccine Catalog");
        btnVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaccineActionPerformed(evt);
            }
        });
        jPanel1.add(btnVaccine, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 180, -1));

        btnDisease.setText("Manage Disease Catalog");
        btnDisease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiseaseActionPerformed(evt);
            }
        });
        jPanel1.add(btnDisease, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 180, -1));

        jSplitPane1.setRightComponent(jPanel1);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("System");
        JTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        JTree.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                valueChangedAction(evt);
            }
        });
        jScrollPane1.setViewportView(JTree);

        jPanel2.add(jScrollPane1);

        jSplitPane1.setLeftComponent(jPanel2);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void manageEnterpriseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnterpriseJButtonActionPerformed

        ManageEnterpriseJPanel manageEnterpriseJPanel = new ManageEnterpriseJPanel(userProcessContainer, system);
        userProcessContainer.add("manageEnterpriseJPanel", manageEnterpriseJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEnterpriseJButtonActionPerformed

    private void manageAdminJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAdminJButtonActionPerformed
        // TODO add your handling code here:
        ManageEnterpriseAdminJPanel manageEnterpriseAdminJPanel = new ManageEnterpriseAdminJPanel(userProcessContainer, system);
        userProcessContainer.add("manageEnterpriseAdminJPanel", manageEnterpriseAdminJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageAdminJButtonActionPerformed

    private void manageNetworkJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageNetworkJButtonActionPerformed
        ManageNetworkJPanel manageNetworkJPanel = new ManageNetworkJPanel(userProcessContainer, system);
        userProcessContainer.add("manageNetworkJPanel", manageNetworkJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageNetworkJButtonActionPerformed

    private void valueChangedAction(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_valueChangedAction
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) JTree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            selectedNodeJLabel.setText(selectedNode.toString());
        }

    }//GEN-LAST:event_valueChangedAction

    private void btnVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaccineActionPerformed
        // TODO add your handling code here:
        ManageVaccineDirectoryJPanel manageNetworkJPanel = new ManageVaccineDirectoryJPanel(userProcessContainer, system);
        userProcessContainer.add("ManageVaccineDirectoryJPanel", manageNetworkJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnVaccineActionPerformed

    private void btnDiseaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiseaseActionPerformed
        // TODO add your handling code here:
         ManageDiseaseDirectoryJPanel manageNetworkJPanel = new ManageDiseaseDirectoryJPanel(userProcessContainer, system);
        userProcessContainer.add("ManageDiseaseDirectoryJPanel", manageNetworkJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnDiseaseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree JTree;
    private javax.swing.JButton btnDisease;
    private javax.swing.JButton btnVaccine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton manageAdminJButton;
    private javax.swing.JButton manageEnterpriseJButton;
    private javax.swing.JButton manageNetworkJButton;
    private javax.swing.JLabel selectedNodeJLabel;
    // End of variables declaration//GEN-END:variables
}
