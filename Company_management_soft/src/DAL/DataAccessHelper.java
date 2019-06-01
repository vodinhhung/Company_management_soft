package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccessHelper {
    
    Connection conn;
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=NhanSu;integratedSecurity=false";

    public void getConnection() { 
        
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(connectionURL ,"sa" , "0000");
        } catch (ClassNotFoundException e) {
            System.out.println("Fail connection 1");
        } catch (SQLException e) {
            System.out.println("Fail connection 2");
        }
    }
    
    public void getClose(){
        try {
            conn.close();
        } catch (SQLException ex) {
            
        }
       
    }
    
}
