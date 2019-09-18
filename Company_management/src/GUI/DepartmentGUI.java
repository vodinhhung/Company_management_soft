package GUI;

import BLL.DepartmentBLL;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import subClass.Department;

public class DepartmentGUI extends javax.swing.JFrame {

    private String ID;
    private final String dbURL = "jdbc:sqlserver://localhost;databaseName=NhanSu;integratedSecurity=false;user=sa;password=0000";
    
    DepartmentBLL depBLL = new DepartmentBLL();
    ArrayList<Department> listDEP = new ArrayList<>();
    
    DefaultTableModel model;
    
    public DepartmentGUI() {
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
        
        bidingDep();
        model = (DefaultTableModel) tblDep.getModel();

    }
    
    
    public void bidingDep() {
        listDEP = depBLL.getAll();
        Vector clums = new Vector();
        clums.add("DepName");
        clums.add("DepID");
        
        
        Vector data = new Vector();
        for ( Department dep : listDEP) {
            Vector row = new Vector();
            
            row.add(dep.getDepName());
            row.add(dep.getDepID());
            
            data.add(row);
        
        }
        
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        tblDep.setModel(dtm);    
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDep = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textDepID = new javax.swing.JTextField();
        textDepName = new javax.swing.JTextField();
        btnAddNew = new javax.swing.JButton();
        btnUpDate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jlabel4 = new javax.swing.JLabel();
        textPersonalID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("DEPARTMENT");

        tblDep.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDep);

        jLabel2.setText("DepID");

        jLabel3.setText("DepName");

        textDepID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDepIDActionPerformed(evt);
            }
        });

        textDepName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDepNameActionPerformed(evt);
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

        jlabel4.setText("PersonalID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(textPersonalID, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textDepName, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textDepID, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(45, 45, 45)))
                        .addGap(34, 34, 34))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(324, 324, 324))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textDepID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textDepName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(138, 138, 138)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpDate, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textPersonalID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        // TODO add your handling code here:
        
        if(textPersonalID.getText().equals("manager")){
            int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to add new dep?", " Add dep", JOptionPane.YES_NO_OPTION);
            if (x==0){
                String DepID = textDepID.getText();
                String DepName = textDepName.getText();

                Department dep = new Department();
                dep.setDepName(DepName);
                dep.setDepID(Integer.parseInt(DepID));

                if(depBLL.addData(dep)) {
                    JOptionPane.showMessageDialog(this, "Add new dep successfully!");
                    bidingDep();
                }else{
                    JOptionPane.showMessageDialog(this, "Add new dep fail!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "You aren't allowed to add a new department");
        }
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
       
        Main m = new Main();
        this.dispose();
        m.setVisible(true);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        if(textPersonalID.getText().equals("manager")){
            int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete dep?", " Delete dep", JOptionPane.YES_NO_OPTION);
            
            if(x==0){
                if (tblDep.getSelectedRow() != -1){
                    int row = tblDep.getSelectedRow();
                    listDEP = depBLL.getAll();

                    if(depBLL.deleteData(Integer.toString(listDEP.get(row).getDepID()))) {
                        JOptionPane.showMessageDialog(this, "Delete dep successfully!");
                        bidingDep();
                    }else{
                        JOptionPane.showMessageDialog(this, "Delete dep fail!");
                    }

                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "You aren't allowed to delete an existing department");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void textDepIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDepIDActionPerformed

    }//GEN-LAST:event_textDepIDActionPerformed

    private void tblDepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepMouseClicked
        
        textDepID.setText("");
        textDepName.setText("");
        
        DefaultTableModel dm = (DefaultTableModel)tblDep.getModel();
        
        textDepName.setText(model.getValueAt(tblDep.getSelectedRow(), 0).toString());
        textDepID.setText(model.getValueAt(tblDep.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tblDepMouseClicked

    private void btnUpDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpDateActionPerformed
        
        int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to update dep?", " Update dep", JOptionPane.YES_NO_OPTION);
        if(x==0){
            listDEP = depBLL.getAll();
            String DepID = textDepID.getText();
            String DepName = textDepName.getText();
            int row = tblDep.getSelectedRow();
            Department dep = new Department();
            dep.setDepName(DepName);
            dep.setDepID(listDEP.get(row).getDepID());

            if(depBLL.updateData(dep)) {
                JOptionPane.showMessageDialog(this, "Update new dep successfully!");
                bidingDep();
            }else{
                JOptionPane.showMessageDialog(this, "Update new dep fail!");
            }
        }
    }//GEN-LAST:event_btnUpDateActionPerformed

    private void textDepNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDepNameActionPerformed
        
    }//GEN-LAST:event_textDepNameActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        
        textDepID.setText("");
        textDepName.setText("");
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
            java.util.logging.Logger.getLogger(DepartmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepartmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepartmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepartmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartmentGUI().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JTable tblDep;
    private javax.swing.JTextField textDepID;
    private javax.swing.JTextField textDepName;
    private javax.swing.JTextField textPersonalID;
    // End of variables declaration//GEN-END:variables
}
