
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import subClass.Department;

public class DepartmentDAL extends DataAccessHelper {
    
    private final String GET_BY_ID = "select * from PhongBan where MaPhongBan = ?";
    private final String GET_ALL = "select * from PhongBan";
    private final String ADD_DATA = "insert into PhongBan (TenPhongBan, MaPhongBan) values (?,?)";
    private final String DELETE_DATA = "delete from PhongBan where MaPhongBan=? ";     
    private final String UPDATE_DATA = " update PhongBan set TenPhongBan=? where MaPhongBan=?";
           
    
    public ArrayList<Department> getByID(int id){
        ArrayList<Department> objs = new ArrayList<>();
        try { 
            getConnection();
            PreparedStatement ps= conn.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!=null && rs.next()) {
                Department item = new Department();
                item.setDepName(rs.getString("TenPhongBan"));
                item.setDepID(rs.getInt("MaPhongBan"));
                objs.add(item);
            
            } 
        
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<Department> getALL() {
        ArrayList<Department> objs = new ArrayList<>();
        try { 
            getConnection();
            PreparedStatement ps= conn.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while (rs.next()){
                    Department item = new Department();
                    item.setDepName(rs.getString("TenPhongBan"));
                    item.setDepID(rs.getInt("MaPhongBan"));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean addData(Department dep){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = conn.prepareStatement(ADD_DATA);
            
            ps.setString(1, dep.getDepName());
            ps.setInt(2, dep.getDepID());
            
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        return check;
    }

    public boolean deleteData ( String depId ) {
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE_DATA);
            ps.setString(1, depId);
            
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        return check;
    }
    
    public boolean updateData(Department dep){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_DATA);
            
            ps.setString(1, dep.getDepName());
            ps.setInt(2, dep.getDepID());
            
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        return check;
    }
    
}
