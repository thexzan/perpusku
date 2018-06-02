/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.ent_peminjaman;
import interfaces.int_peminjaman;
import java.sql.PreparedStatement;
import koneksi.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xzan
 */
public class imp_peminjaman implements int_peminjaman {

    private String query;
    private final db db;
    private boolean status;
    private ResultSet data;
    private ArrayList<ArrayList<String>> listPeminjaman;
    private PreparedStatement ps;

    public imp_peminjaman() {
        db = new db();
        db.connect();
    }

    @Override
    public List get(String cari) {
        try {
            ps = db.connect().prepareStatement("call daftar_peminjaman3(?)");
            ps.setString(1, "%" + cari + "%");

            status = db.execute(ps, true);
            if (status) {
                data = db.get_hasil();
                listPeminjaman =new ArrayList<ArrayList<String>>();

                while (data.next()) {
                     ArrayList<String> x = new ArrayList<String>();
                    
                    x.add(String.valueOf(data.getInt("id_peminjaman")));
                    x.add(data.getString("nama"));
                    x.add(data.getString("telpon"));
                    x.add(data.getString("tanggal"));
                    x.add(data.getString("status"));
                    listPeminjaman.add(x);
                }
                data.close();
                return listPeminjaman;
            }
        } catch (SQLException e) {
            System.out.println("QUERY SELECT SALAH = " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

}
