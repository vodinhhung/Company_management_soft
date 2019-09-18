package BLL;

import DAL.EmployeeDAL;
import java.util.ArrayList;
import subClass.Employee;


public class EmployeeBLL {
    EmployeeDAL dal = new EmployeeDAL();
    public boolean getLogin(String id, String pass){
        return dal.getLogin(id, pass);
    }
    
    public ArrayList<Employee> getALL(){
        return dal.getALL();
    }
    
    public boolean addData(Employee emp){
        return dal.addData(emp);
    }
    
    public boolean deleteData( String id){
        return dal.deleteData(id);
    }
    
    public boolean updateData(Employee emp){
        return dal.updateData(emp);
    }
}
