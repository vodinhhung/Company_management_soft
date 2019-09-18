package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import subClass.Project;

public class ProjectDAL extends DataAccessHelper{
    private final String GET_BY_ID = "select * from DuAn where MaDuAn = ?";
    private final String GET_ALL = "select * from DuAn";
    private final String ADD_DATA = "insert into DuAn (TenDuAn, MaDuAn, Link) values (?,?,?)";
    private final String DELETE_DATA = "delete from DuAn where MaDuAn=? "; 
    private final String UPDATE_DATA = " update DuAn set TenDuAn=?, Link=? where MaDuAn=?";
    
    public ArrayList<Project> getByID(int id){
        ArrayList<Project> objs = new ArrayList<>();
        try { 
            getConnection();
            PreparedStatement ps= conn.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!=null && rs.next()) {
                Project item = new Project();
                item.setPrID(rs.getInt("MaDuAn"));
                item.setPrName(rs.getString("TenDuAn"));
                item.setLink((rs.getString("Link")));
                objs.add(item);
            
            } 
        
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<Project> getALL() {
        ArrayList<Project> objs = new ArrayList<>();
        try { 
            getConnection();
            PreparedStatement ps= conn.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while (rs.next()){
                    Project item = new Project();
                    item.setPrName(rs.getString("TenDuAn"));
                    item.setPrID(rs.getInt("MaDuAn"));
                    item.setLink((rs.getString("Link")));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean addData(Project pr){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = conn.prepareStatement(ADD_DATA);
            
            ps.setString(1, pr.getPrName());
            ps.setInt(2, pr.getPrID());
            ps.setString(3, pr.getLink());
            
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
    
    public boolean deleteData ( String prId ) {
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE_DATA);
            ps.setString(1, prId);
            
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
    
    public boolean updateData(Project pr){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_DATA);
            
            ps.setString(1, pr.getPrName());
            ps.setString(2, pr.getLink());
            ps.setInt(3, pr.getPrID());
            
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
