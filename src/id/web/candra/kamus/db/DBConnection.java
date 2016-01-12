/*
 * Kelas untuk melakukan koneksi database mysql
 *
 */
package id.web.candra.kamus.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private String url = "jdbc:mysql://localhost:3306/koreadb";
    //nama database="koreadb"
    private String dbName = "koreadb";/* nama database */
    private String host = "localhost:3306";
    private String userName = "root";
    private String password = "root";
    private Connection connection = null;
    private static DBConnection myConn = null;

    public DBConnection() {
        /* mengecek apakah library ada  */
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException ex) {
            System.out.println(ex);
        } catch (IllegalAccessException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    /* mengecek apakah sudah ada instantce koneksi
     * jika belum ada, maka buat koneksibaru,
     * jika membuat koneksi baru gagal, tampilkan error
     */
    public static DBConnection getInstance() {
        DBConnection conn = null;
        try {
            if (myConn == null) {
                myConn = new DBConnection();
                conn = myConn;
            } else if (myConn.getConnection().isClosed()) {
                myConn = new DBConnection();
                conn = myConn;
            } else {
                conn = myConn;
            }
            return conn;
        } catch (SQLException ex) {
            return new DBConnection();
        }
    }

    //methodeuntuk menutup koneksi
    public void closeConnection() throws SQLException {
        this.connection.close();
    }
    /*kode untuk mendapatkan  koneksi ke server
    parameter di ambil dari variable kelas
     * yaitu, url, usrname dan passwod
     */

    public Connection getConnection() throws SQLException {
        if (this.connection == null) {
            this.connection = DriverManager.getConnection(getUrl(), getUserName(), getPassword());
        }
        return this.connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

// <editor-fold defaultstate="collapsed" desc=" Get Set ">
    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        String urlNew = "jdbc:mysql://" + getHost() + "/" + getDbName();
        this.url = urlNew;
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
// </editor-fold>
}
