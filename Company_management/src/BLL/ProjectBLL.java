
package BLL;

import DAL.ProjectDAL;
import java.util.ArrayList;
import subClass.Project;

public class ProjectBLL {
    ProjectDAL dal = new ProjectDAL();
    public ArrayList<Project> getByID(int id){
        return dal.getByID(id);
    }
    
    public ArrayList<Project> getAll(){
        return dal.getALL();
    }
    
    public boolean addData(Project pr){
        return dal.addData(pr);
    }

    public boolean deleteData(String prId){
        return dal.deleteData(prId);
    }
    
    public boolean updateData(Project pr){
        return dal.updateData(pr);
    }
    
}
