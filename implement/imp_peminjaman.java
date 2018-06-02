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
    private List<ent_peminjaman> listPeminjaman;
    private PreparedStatement ps;

    public imp_peminjaman() {
        db = new db();
        db.connect();
    }

    @Override
    public List get(String cari) {
        try {
            ps = db.connect().prepareStatement("select id,id_anggota,tanggal,status from peminjaman where id like ?");
            ps.setString(1, "%" + cari + "%");

            status = db.execute(ps, true);
            if (status) {
                data = db.get_hasil();
                listPeminjaman = new ArrayList<>();

                while (data.next()) {
                    ent_peminjaman x = new ent_peminjaman();
                    
                    x.setId(data.getInt(1));
                    x.setId_anggota(data.getInt(2));
                    x.setTanggal(data.getString(3));
                    x.setStatus(data.getString(4));
//                    x.setTanggal_kembali(data.getString(5));
//                    x.setDenda(data.getInt(6));
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
