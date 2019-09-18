package GUI;

import BLL.ProjectBLL;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import subClass.Project;

public class ProjectGUI extends javax.swing.JFrame {

    private String ID;
    private final String dbURL = "jdbc:sqlserver://localhost;databaseName=NhanSu;integratedSecurity=false;user=sa;password=0000";
    
    ProjectBLL prBLL = new ProjectBLL();
    ArrayList<Project> listPR = new ArrayList<>();
    
    DefaultTableModel model;
    
    
    public ProjectGUI() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
        try {
            String sql = "SELECT * FROM LuuNhanVien";
            Connection conn = DriverManager.getConnection(dbURL);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
             
            while (rs.next()) {
                ID = rs.getString("MaNhanVien");
            }
        } catch (Exception e) {
        }
        textPersonalID.setText(ID);
        
        bidingPr();
        
        model = (DefaultTableModel) tblPr.getModel();
    }
    
    
    public void bidingPr() {
        listPR = prBLL.getAll();
        Vector clums = new Vector();
        clums.add("PrName");
        clums.add("PrID");
        clums.add("Working Link");
        
        
        Vector data = new Vector();
        for ( Project pr : listPR) {
            Vector row = new Vector();
            
            row.add(pr.getPrName());
            row.add(pr.getPrID());
            row.add(pr.getLink());
            
            data.add(row);
        
        }
        
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        tblPr.setModel(dtm);
        
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPr = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textPrID = new javax.swing.JTextField();
        textPrName = new javax.swing.JTextField();
        btnAddNew = new javax.swing.JButton();
        btnUpDate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textLink = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textPersonalID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("PROJECT");

        tblPr.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPrMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPr);

        jLabel2.setText("Project ID");

        jLabel3.setText("Project Name");

        textPrName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPrNameActionPerformed(evt);
            }
        });

        btnAddNew.setText("AddNew");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        btnUpDate.setText("UpDate");
        btnUpDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpDateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel4.setText("Working Link");

        jLabel5.setText("Personal ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(133, 133, 133)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(114, 114, 114)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(86, 86, 86)
                            .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textLink, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(textPrID, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(textPrName, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(textPersonalID, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(445, 445, 445)
                        .addComponent(jLabel1)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPersonalID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPrID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPrName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textLink, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textPrNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPrNameActionPerformed

    }//GEN-LAST:event_textPrNameActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(textPersonalID.getText().equals("manager")){
            int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete project?", " Delete project", JOptionPane.YES_NO_OPTION);
            if(x==0){
                if (tblPr.getSelectedRow() != -1){
                    int row = tblPr.getSelectedRow();
                    listPR = prBLL.getAll();

                    if(prBLL.deleteData(Integer.toString(listPR.get(row).getPrID()))) {
                        JOptionPane.showMessageDialog(this, "Delete project successfully!");
                        bidingPr();
                    }else{
                        JOptionPane.showMessageDialog(this, "Delete project fail!");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "You aren't allowed to delete an existing project");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        
        Main m = new Main();
        this.dispose();
        m.setVisible(true);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        
        if(textPersonalID.getText().equals("manager")){
            int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to add new project?", " Add project", JOptionPane.YES_NO_OPTION);
            if(x==0){
                String PrID = textPrID.getText();
                String PrName = textPrName.getText();
                String PrLink = textLink.getText();

                Project pr = new Project();
                pr.setPrName(PrName);
                pr.setPrID(Integer.parseInt(PrID));
                pr.setLink(PrLink);

                if(prBLL.addData(pr)) {
                    JOptionPane.showMessageDialog(this, "Add new project successfully!");
                    bidingPr();
                }else{
                    JOptionPane.showMessageDialog(this, "Add new project fail!");
                }
            }
        } else{
            JOptionPane.showMessageDialog(this, "You aren't allowed to add a new project");
        }
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void tblPrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrMouseClicked
        
        textPrID.setText("");
        textPrName.setText("");
        textLink.setText("");
        
        DefaultTableModel dm = (DefaultTableModel)tblPr.getModel();
        
        textPrName.setText(model.getValueAt(tblPr.getSelectedRow(), 0).toString());
        textPrID.setText(model.getValueAt(tblPr.getSelectedRow(), 1).toString());
        textLink.setText(model.getValueAt(tblPr.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tblPrMouseClicked

    private void btnUpDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpDateActionPerformed
        
        int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to update project?", " Update project", JOptionPane.YES_NO_OPTION);
        if(x==0){
            listPR = prBLL.getAll();
            String PrID = textPrID.getText();
            String PrName = textPrName.getText();
            String PrLink = textLink.getText();

            int row = tblPr.getSelectedRow();
            Project pr = new Project();
            pr.setPrName(PrName);
            pr.setPrID(Integer.parseInt(PrID)); // Day la cho toi co gang sua nhuwng chua sua duoc!!
            pr.setLink(PrLink);

            if(prBLL.updateData(pr)) {
                JOptionPane.showMessageDialog(this, "Update new projectt successfully!");
                bidingPr();
            }else{
                JOptionPane.showMessageDialog(this, "Update new project fail!");
            }
        }
    }//GEN-LAST:event_btnUpDateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        textPrID.setText("");
        textPrName.setText("");
        textLink.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnUpDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPr;
    private javax.swing.JTextField textLink;
    private javax.swing.JTextField textPersonalID;
    private javax.swing.JTextField textPrID;
    private javax.swing.JTextField textPrName;
    // End of variables declaration//GEN-END:variables
}
