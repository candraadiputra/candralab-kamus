/*
 * Login.java
 *
 */

package id.web.candra.kamus.db;
import java.sql.*;
/**
 *
 * @author Riyan
 */
public class Login {
    private String driver = "com.mysql.jdbc.Driver";
    private String url= "jdbc:mysql://localhost/koreadb";

    private String username;
    private String password;
    private boolean isOK = false;
   // private StatusLogin st;
    private java.sql.Connection conn;

    
    public Login() {
        this.username="";
        this.password="";
    }
    
    public Login(String user, String passwd ) {
        this.username=user;
        this.password=passwd;         
    }
    
    @Override
    protected void finalize() { 
        conn = null; 
    }
     
    public boolean cekLogin() {
        String query="Select * from login where nama='"+username+"' and passwd='"+password+"'";
        try {
            Class.forName(driver).newInstance();
            conn = java.sql.DriverManager.getConnection(url,"root","root");
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            if(rs.next()) {
               isOK=true;
            
          
            } else {
               isOK=false;
            //  st.setStatus(false);
            }
        } catch (Exception e) {
            System.out.println(e);
           isOK = false;
        }
        return isOK;
    }
    
    public void closeConnDB(){
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Proses menutup koneksi database GAGAL!" + e);
        }
        conn = null;     
    }
    
    public java.sql.Connection getConnDB() { 
        return this.conn; 
    }
    
    public boolean getIsOK() { 
        return this.isOK; 
    }
}


