package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class db {

    private Connection conn;
    private ResultSet rs;

    public Connection connect() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    // ZERO DATE TIME BEHAVIOR = NULL 
                    // BERGUNA UNTUK MENGATASI DATA TANGGAL DARI MYSQL YANG BERUBA - 0000-00-00 00:00:00
                    // AKAN DIUBAH MENJADI NULL
                    String url = "jdbc:mysql://localhost:3306/perpusku?zeroDateTimeBehavior=convertToNull";
                    conn = DriverManager.getConnection(url, "root", "root");
                } catch (SQLException se) {
                    System.out.println("KONEKSI GAGAL = " + se.getMessage());
                    System.exit(0);
                }
            } catch (ClassNotFoundException cnfe) {
                System.out.println("CLASS TIDAK DITEMUKAN = " + cnfe.getMessage());
                System.exit(0);
            }
        }
        return conn;
    }

    public ResultSet get_hasil() {
        return rs;
    }
    
    // METHODE EXECUTE MELEMPAR EXCEPTION
    // SEHINGGA PEMANGGILNYA HARUS MENGGUNAKAN TRY-CATCH
    // HAL INI BERGUNA AGAR ERROR DAPAT DIANALISA PADA MASING-MASING PEMANGGIL
    public boolean execute(PreparedStatement ps, boolean status) throws SQLException {
        if (status) {
            // KARENA SELECT MENGHASILKAN RESULTSET
            // MAKA TAMPUNG RESULTSET-NYA
            rs = ps.executeQuery();
        } else {
            // SELAIN ITU ( INSERT,UPDATE,DELETE )
            // TIDAK ADA YANG PERLU DITAMPUNG
            ps.executeUpdate();
        }
        return true;
    }

    public static void main(String[] args) {
        new db().connect();
    }
}
