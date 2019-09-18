package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPersonalInformation = new javax.swing.JButton();
        btnDepartment = new javax.swing.JButton();
        btnProject = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("H&H COMPANY");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 70, 372, 58);

        btnPersonalInformation.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPersonalInformation.setText("Employee Information");
        btnPersonalInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalInformationActionPerformed(evt);
            }
        });
        jPanel1.add(btnPersonalInformation);
        btnPersonalInformation.setBounds(120, 220, 410, 90);

        btnDepartment.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDepartment.setText("Department");
        btnDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartmentActionPerformed(evt);
            }
        });
        jPanel1.add(btnDepartment);
        btnDepartment.setBounds(330, 330, 200, 100);

        btnProject.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnProject.setText("Project");
        btnProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProjectActionPerformed(evt);
            }
        });
        jPanel1.add(btnProject);
        btnProject.setBounds(120, 330, 180, 100);

        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout.png"))); // NOI18N
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout);
        btnLogout.setBounds(20, 490, 50, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 990, 540);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPersonalInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalInformationActionPerformed
        
         EmployeeGUI a= new EmployeeGUI();
         this.dispose();
            a.setVisible(true);
    }//GEN-LAST:event_btnPersonalInformationActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        
        try {
            String sql = "DELETE FROM LuuTaiKhoan";
            String dbURL = "jdbc:sqlserver://localhost;databaseName=Media;user=sa;password=0000";
            Connection conn = DriverManager.getConnection(dbURL);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        } catch (Exception e) {
        }
        
        Login lg = new Login();
        this.dispose();
        lg.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartmentActionPerformed
        
        DepartmentGUI de = new DepartmentGUI();
        this.dispose();
        de.setVisible(true);
    }//GEN-LAST:event_btnDepartmentActionPerformed

    private void btnProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProjectActionPerformed
        
        ProjectGUI pr = new ProjectGUI();
        this.dispose();
        pr.setVisible(true);
    }//GEN-LAST:event_btnProjectActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDepartment;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPersonalInformation;
    private javax.swing.JButton btnProject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
