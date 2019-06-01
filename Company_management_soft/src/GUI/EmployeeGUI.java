package GUI;

import BLL.DepartmentBLL;
import BLL.EmployeeBLL;
import BLL.ProjectBLL;
import static java.awt.Component.TOP_ALIGNMENT;
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
import subClass.Department;
import subClass.Employee;
import subClass.Project;

public class EmployeeGUI extends javax.swing.JFrame {
    
    private String ID;
    private final String dbURL = "jdbc:sqlserver://localhost;databaseName=NhanSu;integratedSecurity=false;user=sa;password=0000";
    
    
    EmployeeBLL empBLL = new EmployeeBLL();
    ArrayList<Employee> listEMP = new ArrayList<>();
    
    DepartmentBLL depBLL = new DepartmentBLL();
    ArrayList<Department> listDEP = new ArrayList<>();
    
    ProjectBLL prBLL = new ProjectBLL();
    ArrayList<Project> listPR = new ArrayList<>();
    
    DefaultTableModel model;
    
    public EmployeeGUI() {
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
        
        Biding();
        bidingDep();
        bidingPr();
        
        model = (DefaultTableModel) tblEmp.getModel();
    }
    
    public void bidingDep() {
        listDEP = depBLL.getAll();
        for ( Department d : listDEP) {
            cbxDep.addItem(d.getDepName());
        }
    
    }
    
    public void bidingPr() {
        listPR = prBLL.getAll();
        for ( Project pr : listPR) {
            cbxPr.addItem(pr.getPrName());
        }
    }
    
    public void Biding() {
        listEMP = empBLL.getALL();
        Vector clums = new Vector();
        clums.add("ID");
        clums.add("Password");
        clums.add("FullName");
        clums.add("DateOfBirth");
        clums.add("Address");
        clums.add("Gender");
        clums.add("PhoneNumber");
        clums.add("Salary");
        clums.add("DateOfBirth");
        clums.add("Department");
        clums.add("Project");
        
        Vector data = new Vector();
        for ( Employee emp : listEMP) {
            Vector row = new Vector();
            
            row.add(emp.getEmpID());
            row.add(emp.getPassword());
            row.add(emp.getFullName());
            row.add(emp.getDateOfBirth());
            row.add(emp.getAddress());
            row.add(emp.getGender());
            row.add(emp.getPhoneNumber());
            row.add(emp.getSalary());
            row.add(emp.getDateOfBirth());
            
            listDEP = depBLL.getByID(emp.getDepID());
            if (listDEP.size()>0) {
                row.add(listDEP.get(0).getDepName());
            } else {
                row.add("is empty");
            }
            listPR = prBLL.getByID(emp.getPrID());
            if (listPR.size()>0) {
                row.add(listPR.get(0).getPrName());
            } else {
                row.add("is empty");
            }
            
            data.add(row);
        
        }
        
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        tblEmp.setModel(dtm);
    
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmp = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        textPassword = new javax.swing.JTextField();
        textFullName = new javax.swing.JTextField();
        textAddress = new javax.swing.JTextField();
        textGender = new javax.swing.JTextField();
        textPhoneNumber = new javax.swing.JTextField();
        textSalary = new javax.swing.JTextField();
        textDateOfBirth = new javax.swing.JTextField();
        cbxDep = new javax.swing.JComboBox<>();
        cbxPr = new javax.swing.JComboBox<>();
        btnAddNew = new javax.swing.JButton();
        btnUpDate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        textPersonalID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblEmp.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmp);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Employee Information");

        jLabel2.setText("ID");

        jLabel3.setText("Pass");

        jLabel4.setText("FullName");

        jLabel5.setText("Address");

        jLabel6.setText("Gender");

        jLabel7.setText("PhoneNumber");

        jLabel8.setText("Salary");

        jLabel9.setText("DateOfBirth");

        jLabel10.setText("Department");

        jLabel11.setText("Project");

        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
            }
        });

        textGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textGenderActionPerformed(evt);
            }
        });

        textPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPhoneNumberActionPerformed(evt);
            }
        });

        textSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSalaryActionPerformed(evt);
            }
        });

        cbxDep.setToolTipText("");
        cbxDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDepActionPerformed(evt);
            }
        });

        cbxPr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPrActionPerformed(evt);
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

        jLabel12.setText("Personal ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(textPersonalID, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 904, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(textFullName, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                            .addComponent(textPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textID, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textAddress))
                                        .addGap(77, 77, 77)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel9))
                                                .addGap(47, 47, 47)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textGender, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel7)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAddNew)
                                        .addGap(52, 52, 52)
                                        .addComponent(btnUpDate)
                                        .addGap(43, 43, 43)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnReturn, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxDep, 0, 236, Short.MAX_VALUE)
                                    .addComponent(cbxPr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(364, 364, 364))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)
                            .addComponent(cbxPr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(textSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(textAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textPersonalID, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textGenderActionPerformed
        
    }//GEN-LAST:event_textGenderActionPerformed

    private void textPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPhoneNumberActionPerformed
        
    }//GEN-LAST:event_textPhoneNumberActionPerformed

    private void cbxDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDepActionPerformed
        
    }//GEN-LAST:event_cbxDepActionPerformed

    private void btnUpDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpDateActionPerformed
        
        if(textPersonalID.getText().equals(textID.getText())){
        
            int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to update emp?", " Update emp", JOptionPane.YES_NO_OPTION);

            if(x==0){
                listEMP = empBLL.getALL();
                listDEP = depBLL.getAll();
                listPR = prBLL.getAll();
                String ID = textID.getText();
                String Password = textPassword.getText();
                String FullName = textFullName.getText();
                String Address = textAddress.getText();
                String Gender = textGender.getText();
                String PhoneNumber = textPhoneNumber.getText();
                String Salary = textSalary.getText();
                String DateOfBirth = textDateOfBirth.getText();

                int row = tblEmp.getSelectedRow();
                int rowDep = cbxDep.getSelectedIndex();
                int rowPr = cbxPr.getSelectedIndex();

                int idDep = listDEP.get(rowDep).getDepID();
                int idPr = listPR.get(rowPr).getPrID();

                Employee emp = new Employee();
                emp.setEmpID(listEMP.get(row).getEmpID());
                emp.setPassword(Password);
                emp.setFullName(FullName);
                emp.setAddress(Address);
                emp.setGender(Gender);
                emp.setPhoneNumber(PhoneNumber);
                emp.setSalary(Float.parseFloat(Salary));
                emp.setDateOfBirth(DateOfBirth);
                emp.setDepID(idDep);
                emp.setPrID(idPr);

                if(empBLL.updateData(emp)) {
                    JOptionPane.showMessageDialog(this, "Update new emp successfully!");
                    Biding();
                }else{
                    JOptionPane.showMessageDialog(this, "Update new emp fail!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "You aren't allowed to change the information of this employee");
        }
    }//GEN-LAST:event_btnUpDateActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        
        Main m = new Main();
        this.dispose();
        m.setVisible(true);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        
        if(textPersonalID.getText().equals("manager")){
            int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to add new emp?", " Add emp", JOptionPane.YES_NO_OPTION);
            if(x==0){
                listDEP = depBLL.getAll();
                listPR = prBLL.getAll();

                String ID = textID.getText();
                String Password = textPassword.getText();
                String FullName = textFullName.getText();
                String Address = textAddress.getText();
                String Gender = textGender.getText();
                String PhoneNumber = textPhoneNumber.getText();
                String Salary = textSalary.getText();
                String DateOfBirth = textDateOfBirth.getText();

                int rowDep = cbxDep.getSelectedIndex();
                int rowPr = cbxPr.getSelectedIndex();

                int idDep = listDEP.get(rowDep).getDepID();
                int idPr = listPR.get(rowPr).getPrID();

                Employee emp = new Employee();
                emp.setEmpID(ID);
                emp.setPassword(Password);
                emp.setFullName(FullName);
                emp.setAddress(Address);
                emp.setGender(Gender);
                emp.setPhoneNumber(PhoneNumber);
                emp.setSalary(Float.parseFloat(Salary));
                emp.setDateOfBirth(DateOfBirth);
                emp.setDepID(idDep);
                emp.setPrID(idPr);

                if(empBLL.addData(emp)) {
                    JOptionPane.showMessageDialog(this, "Add new emp successfully!");
                    Biding();
                }else{
                    JOptionPane.showMessageDialog(this, "Add new emp fail!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "You aren't allowed to add a new employee");
        }
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        if(textPersonalID.getText().equals("manager")){
            int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete emp?", " Delete emp", JOptionPane.YES_NO_OPTION);
            if(x==0){
                if (tblEmp.getSelectedRow() != -1){
                    int row = tblEmp.getSelectedRow();
                    listEMP = empBLL.getALL();

                    if(empBLL.deleteData(listEMP.get(row).getEmpID())) {
                        JOptionPane.showMessageDialog(this, "Delete emp successfully!");
                        Biding();
                    }else{
                        JOptionPane.showMessageDialog(this, "Delete emp fail!");
                    }
                }
            }
        }else {
                JOptionPane.showMessageDialog(this, "You aren't allowed to delete an employee!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpMouseClicked
        
        textID.setText("");
        textPassword.setText("");
        textFullName.setText("");
        textDateOfBirth.setText("");
        textAddress.setText("");
        textGender.setText("");
        textPhoneNumber.setText("");
        textSalary.setText("");
        
        DefaultTableModel dm = (DefaultTableModel)tblEmp.getModel();
       
        textID.setText(model.getValueAt(tblEmp.getSelectedRow(), 0).toString());
        textPassword.setText(model.getValueAt(tblEmp.getSelectedRow(), 1).toString());
        textFullName.setText(model.getValueAt(tblEmp.getSelectedRow(), 2).toString());
        textDateOfBirth.setText(model.getValueAt(tblEmp.getSelectedRow(), 3).toString());
        textAddress.setText(model.getValueAt(tblEmp.getSelectedRow(), 4).toString());
        textGender.setText(model.getValueAt(tblEmp.getSelectedRow(), 5).toString());
        textPhoneNumber.setText(model.getValueAt(tblEmp.getSelectedRow(), 6).toString());
        textSalary.setText(model.getValueAt(tblEmp.getSelectedRow(), 7).toString());
        
            
        int row = tblEmp.getSelectedRow();
        listDEP = depBLL.getByID(listEMP.get(row).getDepID());
        if (listDEP.size() > 0) {
            cbxDep.setSelectedItem(listDEP.get(0).getDepName());
        } else {
            cbxDep.setSelectedIndex(0);
            }
        
        listPR = prBLL.getByID(listEMP.get(row).getPrID());
        if (listPR.size() > 0) {
            cbxPr.setSelectedItem(listPR.get(0).getPrName());
        } else {
            cbxPr.setSelectedIndex(0);
        } 
    }//GEN-LAST:event_tblEmpMouseClicked

    private void cbxPrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPrActionPerformed
       
    }//GEN-LAST:event_cbxPrActionPerformed

    private void textSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSalaryActionPerformed
       
    }//GEN-LAST:event_textSalaryActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        
        textID.setText("");
        textPassword.setText("");
        textFullName.setText("");
        textDateOfBirth.setText("");
        textAddress.setText("");
        textGender.setText("");
        textPhoneNumber.setText("");
        textSalary.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        
    }//GEN-LAST:event_textIDActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnUpDate;
    private javax.swing.JComboBox<String> cbxDep;
    private javax.swing.JComboBox<String> cbxPr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmp;
    private javax.swing.JTextField textAddress;
    private javax.swing.JTextField textDateOfBirth;
    private javax.swing.JTextField textFullName;
    private javax.swing.JTextField textGender;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textPassword;
    private javax.swing.JTextField textPersonalID;
    private javax.swing.JTextField textPhoneNumber;
    private javax.swing.JTextField textSalary;
    // End of variables declaration//GEN-END:variables
}
