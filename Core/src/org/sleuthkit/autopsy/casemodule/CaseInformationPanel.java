/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sleuthkit.autopsy.casemodule;

import java.util.Map;
import org.openide.util.NbBundle.Messages;

/**
 *
 * @author oliver
 */
public class CaseInformationPanel extends javax.swing.JPanel {

    /**
     * Creates new form CaseInformationPanel
     */
    public CaseInformationPanel() {
        initComponents();
        customizeComponents();
    }
    
    @Messages({"CaseInformationPanel.caseDetails.header=Case Details"})
    private void customizeComponents() {
        try {
            Case currentCase = Case.getCurrentCase();
            String crDate = currentCase.getCreatedDate();
            String caseDir = currentCase.getCaseDirectory();
            
            // put the image paths information into hashmap
            Map<Long, String> imgPaths = Case.getImagePaths(currentCase.getSleuthkitCase());
            CasePropertiesForm cpf = new CasePropertiesForm(currentCase, crDate, caseDir, imgPaths);
            cpf.setSize(cpf.getPreferredSize());
            this.tabbedPane.addTab(Bundle.CaseInformationPanel_caseDetails_header(), cpf);
        } catch (CaseMetadata.CaseMetadataException ex) {
            //TOLOG
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
        tabbedPane = new javax.swing.JTabbedPane();

        tabbedPane.setPreferredSize(new java.awt.Dimension(420, 200));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
