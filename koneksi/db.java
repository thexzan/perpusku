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
                    String url = "jdbc:mysql://localhost:3306/perpusku";
                    conn = DriverManager.getConnection(url, "root", "root");
                    System.out.println("KONEKSI SUKSES");
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

    public boolean exe(PreparedStatement ps, boolean status) {
        try {
            if (status) {
                rs = ps.executeQuery(); //select
            } else {
                ps.executeUpdate(); //insert, update, delete
            }
            return true;
        }catch(SQLException e) {
            System.out.println("QUERY SALAH = " + e.getMessage());
            System.exit(0);
            return false;
        }
    }

    public static void main(String[] args) {
        new db().connect();
    }
}
