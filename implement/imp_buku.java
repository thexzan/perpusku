/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.ent_buku;
import interfaces.int_buku;
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
public class imp_buku implements int_buku {

    private String query;
    private final db db;
    private boolean status;
    private ResultSet data_buku;
    private List<ent_buku> listBuku;
    private PreparedStatement ps;

    public imp_buku() {
        db = new db();
        db.connect();
    }

    @Override
    public boolean insert(ent_buku b) {
        status = false;
        try {
            ps = db.connect().prepareStatement("INSERT INTO buku VALUES (NULL,?,?,?)");
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getKategori());
            ps.setString(3, b.getPenerbit());
            ps.setInt(4, b.getStok());
        } catch (SQLException e) {
            System.out.println("QUERY SALAH = " + e.getMessage());
            System.exit(0);
        }
        status = db.exe(ps, false);
        return status;
    }

    @Override
    public boolean update(ent_buku b) {
        status = false;
        try {
            ps = db.connect().prepareStatement("UPDATE buku SET judul=?,kategori=?,penerbit=?,stok=? WHERE judul=?");
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getKategori());
            ps.setString(3, b.getPenerbit());
            ps.setInt(4, b.getStok());
            ps.setString(5, b.getJudul());
        } catch (SQLException e) {
            System.out.println("QUERY SALAH = " + e.getMessage());
            System.exit(0);
        }
        status = db.exe(ps, false);
        return status;
    }

    @Override
    public boolean delete(String judul) {
        status = false;
        try {
            ps = db.connect().prepareStatement("DELETE FROM buku WHERE judul = ?");
            ps.setString(1, judul);
        } catch (SQLException e) {
            System.out.println("QUERY SALAH = " + e.getMessage());
            System.exit(0);
        }
        status = db.exe(ps, false);
        return status;
    }

    @Override
    public List get(String cari) {
        try {
            ps = db.connect().prepareStatement("SELECT * FROM buku WHERE judul like ? or kategori like ? or penerbit like ? order by id");
            ps.setString(1, "%" + cari + "%");
            ps.setString(2, "%" + cari + "%");
            ps.setString(3, "%" + cari + "%");
        } catch (SQLException e) {
            System.out.println("QUERY SALAH = " + e.getMessage());
            System.exit(0);
        }
        status = db.exe(ps, true);
        if (status) {
            data_buku = db.get_hasil();
            listBuku = new ArrayList<>();
            try {
                while (data_buku.next()) {
                    ent_buku b = new ent_buku();
                    b.setId(data_buku.getInt(1));
                    b.setJudul(data_buku.getString(2));
                    b.setKategori(data_buku.getString(3));
                    b.setPenerbit(data_buku.getString(4));
                    b.setStok(data_buku.getInt(5));
                    listBuku.add(b);
                }
                data_buku.close();
                return listBuku;
            } catch (SQLException e) {
                return null;
            }
        }
        return null;
    }

}
