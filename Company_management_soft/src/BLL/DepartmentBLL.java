package BLL;

import DAL.DepartmentDAL;
import java.util.ArrayList;
import subClass.Department;

public class DepartmentBLL {
    DepartmentDAL dal = new DepartmentDAL();
    public ArrayList<Department> getByID(int id){
        return dal.getByID(id);
    }
    
    public ArrayList<Department> getAll(){
        return dal.getALL();
    }
    
    public boolean addData(Department dep){
        return dal.addData(dep);
    }

    public boolean deleteData(String depId){
        return dal.deleteData(depId);
    }
    
    public boolean updateData(Department dep){
        return dal.updateData(dep);
    }
}
