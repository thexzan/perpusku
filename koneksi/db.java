package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class db {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public Connection connect() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    String url = "jdbc:mysql://localhost:3306/perpusku";
                    conn = DriverManager.getConnection(url, "root", "root");
                    System.out.println("Koneksi Sukses");
                } catch (SQLException se) {
                    System.out.println("Koneksi gagal " + se);
                    System.exit(0);
                }
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class tidak ditemukan " + cnfe);
                System.exit(0);
            }
        }
        return conn;
    }

    public ResultSet get_hasil() {
        return rs;
    }

    public boolean exe(String query, boolean kategori) {
        try {
            ps = conn.prepareStatement(query);
            if (kategori) {
                rs = ps.executeQuery(); //select
            } else {
                ps.executeUpdate(); //insert, update, delete
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        new db().connect();
    }
}
