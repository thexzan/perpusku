/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.ent_login;
import interfaces.int_login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import koneksi.db;

/**
 *
 * @author xzan
 */
public class imp_login implements int_login {

    private final db db;

    // METHOD CONSTRUCTIOR
    public imp_login() {
        db = new db();
        db.connect();
    }

    public boolean cek_login(ent_login e) {
        boolean status = false;
        try {
            // MENGGUNAKAN PARAMETERIZED QUERY UNTUK MEMISAHKAN QUERY
            // DENGAN DATA DARI USER ( DATA TIDAK TERPERCAYA )
            PreparedStatement ps = db.connect().prepareStatement("select * from admin where username = ? and password = md5(?)");
            // MEMASUKAN DATA DARI USER KE MASING-MASING PARAM
            ps.setString(1, e.getUsername());
            ps.setString(2, e.getPassword());
            
            db.execute(ps, true);
            ResultSet rs = db.get_hasil();
            // CEK HASIL TERAKHIR
            rs.last();
            
            // JIKA JUMLAH BARISNYA TEPAT 1 MAKA 
            // BENAR ADA USER DENGAN USERNAME DAN PASSWORD SEPERTI YANG DIINPUTKAN USER
            if (rs.getRow() == 1) {
                // UBAH STATUS MENJADI TRUE / BERHASIL LOGIN
                status = true;
            }
        } catch (SQLException er) {
            System.out.println("QUERY LOGIN SALAH = " + er.getMessage());
            System.exit(0);
        }
        return status;

    }
}
