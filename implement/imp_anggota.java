/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.ent_anggota;
import interfaces.int_anggota;
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
public class imp_anggota implements int_anggota {

    private String query;
    private final db db;
    private boolean status;
    private ResultSet data_anggota;
    private List<ent_anggota> listAnggota;
    private PreparedStatement ps;

    public imp_anggota() {
        db = new db();
        db.connect();
    }

    @Override
    public boolean insert(ent_anggota a) {
        status = false;
        try {
            ps = db.connect().prepareStatement("INSERT INTO anggota VALUES (NULL,?,?,?)");
            ps.setString(1, a.getNama());
            ps.setString(2, a.getTelpon());
            ps.setString(3, a.getAlamat());

            status = db.execute(ps, false);
        } catch (SQLException e) {
            System.out.println("QUERY INSERT SALAH = " + e.getMessage());
            System.exit(0);
        }
        return status;
    }

    @Override
    public boolean update(ent_anggota a) {
        status = false;
        try {
            ps = db.connect().prepareStatement("UPDATE anggota SET nama=?,telpon=?,alamat=? WHERE id=?");
            ps.setString(1, a.getNama());
            ps.setString(2, a.getTelpon());
            ps.setString(3, a.getAlamat());
            ps.setInt(4, a.getId());

            status = db.execute(ps, false);
        } catch (SQLException e) {
            System.out.println("QUERY UPDATE SALAH = " + e.getMessage());
            System.exit(0);
        }
        return status;
    }

    @Override
    public boolean delete(int id) {
        status = false;
        try {
            ps = db.connect().prepareStatement("DELETE FROM anggota WHERE id = ?");
            ps.setInt(1, id);

            status = db.execute(ps, false);
        } catch (SQLException e) {
            System.out.println("QUERY DELETE SALAH = " + e.getMessage());
            System.exit(0);
        }
        return status;
    }

    @Override
    public List get(String cari) {
        try {
            ps = db.connect().prepareStatement("SELECT * FROM anggota WHERE nama like ? or alamat like ? or telpon like ? order by id");
            ps.setString(1, "%" + cari + "%");
            ps.setString(2, "%" + cari + "%");
            ps.setString(3, "%" + cari + "%");

            status = db.execute(ps, true);
            if (status) {
                data_anggota = db.get_hasil();
                listAnggota = new ArrayList<>();

                while (data_anggota.next()) {
                    ent_anggota b = new ent_anggota();
                    b.setId(data_anggota.getInt(1));
                    b.setNama(data_anggota.getString(2));
                    b.setTelpon(data_anggota.getString(3));
                    b.setAlamat(data_anggota.getString(4));
                    listAnggota.add(b);
                }
                data_anggota.close();
                return listAnggota;
            }
        } catch (SQLException e) {
            System.out.println("QUERY SELECT SALAH = " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

}
