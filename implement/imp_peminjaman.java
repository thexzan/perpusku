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
            ps = db.connect().prepareStatement("call daftar_peminjaman(?)");
            ps.setString(1, "%" + cari + "%");

            status = db.execute(ps, true);
            if (status) {
                data = db.get_hasil();
                listPeminjaman = new ArrayList<>();

                while (data.next()) {
                    ent_peminjaman x = new ent_peminjaman();

                    x.setId(data.getInt("id_peminjaman"));
                    x.setNama(data.getString("nama"));
                    x.setTelpon(data.getString("telpon"));
                    x.setJumlah_buku(data.getInt("jumlah_buku"));
                    x.setTanggal(data.getString("tanggal"));
                    x.setTanggal_kembali(data.getString("tanggal_kembali"));
                    x.setStatus(data.getString("status"));
                    x.setDenda(data.getInt("denda"));

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

    @Override
    public int get_insert_id() {
        int id = 0;
        try {
            ps = db.connect().prepareStatement("SELECT id from peminjaman order by id desc limit 1");
            status = db.execute(ps, true);
            if (status) {
                data = db.get_hasil();
                while (data.next()) {

                    id = data.getInt("id");
                }
                data.close();
                
            }
        } catch (SQLException e) {
            System.out.println("QUERY SELECT SALAH = " + e.getMessage());
            System.exit(0);
        }
        return id;
    }
    
    @Override
    public boolean insert(ent_peminjaman x) {
        status = false;
        try {
            ps = db.connect().prepareStatement("INSERT INTO peminjaman (id_anggota) VALUES ( ? )");
            ps.setInt(1, x.getId_anggota());

            status = db.execute(ps, false);
        } catch (SQLException e) {
            System.out.println("QUERY INSERT SALAH = " + e.getMessage());
            System.exit(0);
        }
        return status;
    }

    @Override
    public boolean insertDetail(ent_peminjaman x) {
        status = false;
        int id_peminjaman = this.get_insert_id();
        try {
            ps = db.connect().prepareStatement("INSERT INTO detail_peminjaman VALUES (?, ?)");
            ps.setInt(1, id_peminjaman);
            ps.setInt(2, x.getId_buku());

            status = db.execute(ps, false);
        } catch (SQLException e) {
            System.out.println("QUERY INSERT DETAIL SALAH = " + e.getMessage());
            System.exit(0);
        }
        return status;
    }

    

}
