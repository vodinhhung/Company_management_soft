package DAL;

//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import subClass.Employee;

public class EmployeeDAL extends DataAccessHelper{
    
    private final String GET_LOGIN = " select * from NhanVien where MaNhanVien=? and MatKhau=?";
    private final String GET_ALL = "select * from NhanVien";
    private final String ADD_DATA = "insert into NhanVien (MaNhanVien, MatKhau, HoTen, NgaySinh, DiaChi, GioiTinh, SoDienThoai, "
            + "Luong, MaPhongBan, MaDuAn) values(?,?,?,?,?,?,?,?,?,?)";
    private final String DELETE_DATA = "delete from NhanVien where MaNhanVien=? ";
    private final String UPDATE_DATA = " update NhanVien set MatKhau=?, HoTen=?, NgaySinh=?, DiaChi=?, GioiTinh=?,"
            + " SoDienThoai=?, Luong=?, MaPhongBan=?, MaDuAn=? where MaNhanVien=?";
    
    public boolean getLogin(String id, String pass){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = conn.prepareStatement(GET_LOGIN);
            PreparedStatement pst1;
            ps.setString(1,id);
            ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                
                String sql1 = "INSERT INTO LuuNhanVien (MaNhanVien) VALUES ('" + id + "')";
                pst1 = conn.prepareStatement(sql1);
                pst1.execute();
                
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        return check;
    }
    
    public ArrayList<Employee> getALL() {
        ArrayList<Employee> objs = new ArrayList<>();
        try { 
            getConnection();
            PreparedStatement ps= conn.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while (rs.next()){
                    Employee item = new Employee();
                    item.setEmpID(rs.getString("MaNhanVien"));
                    item.setPassword(rs.getString("MatKhau"));
                    item.setFullName(rs.getString("HoTen"));
                    item.setDateOfBirth(rs.getString("NgaySinh"));
                    item.setAddress(rs.getString("DiaChi"));
                    item.setGender(rs.getString("GioiTinh"));
                    item.setPhoneNumber(rs.getString("SoDienThoai"));
                    item.setSalary(rs.getFloat("Luong"));
                    item.setDepID(rs.getInt("MaPhongBan"));
                    item.setPrID(rs.getInt("MaDuAn"));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean addData(Employee emp){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = conn.prepareStatement(ADD_DATA);
            ps.setString(1, emp.getEmpID());
            ps.setString(2, emp.getPassword());
            ps.setString(3, emp.getFullName());
            ps.setString(4, emp.getDateOfBirth());
            ps.setString(5, emp.getAddress());
            ps.setString(6, emp.getGender());
            ps.setString(7, emp.getPhoneNumber());
            ps.setFloat(8, emp.getSalary());
            ps.setInt(9, emp.getDepID());
            ps.setInt(10, emp.getPrID());
            
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
    
    public boolean deleteData ( String id ) {
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE_DATA);
            ps.setString(1, id);
            
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
    
    public boolean updateData(Employee emp){
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_DATA);
           
            ps.setString(1, emp.getPassword());
            ps.setString(2, emp.getFullName());
            ps.setString(3, emp.getDateOfBirth());
            ps.setString(4, emp.getAddress());
            ps.setString(5, emp.getGender());
            ps.setString(6, emp.getPhoneNumber());
            ps.setFloat(7, emp.getSalary());
            ps.setInt(8, emp.getDepID());
            ps.setInt(9, emp.getPrID());
            ps.setString(10, emp.getEmpID());
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
