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

    // METHOD CONSTRUCTOR
    public imp_buku() {
        // MEMANGGIL CLASS DATABASE
        db = new db();
        db.connect();
    }

    @Override
    public boolean insert(ent_buku b) {
        status = false;
        try {
            ps = db.connect().prepareStatement("INSERT INTO buku VALUES (NULL,?,?,?,?)");
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getKategori());
            ps.setString(3, b.getPenerbit());
            ps.setInt(4, b.getStok());

            status = db.execute(ps, false);
        } catch (SQLException e) {
            System.out.println("QUERY INSERT SALAH = " + e.getMessage());
            System.exit(0);
        }
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

            status = db.execute(ps, false);
        } catch (SQLException e) {
            System.out.println("QUERY UPDATE SALAH = " + e.getMessage());
            System.exit(0);
        }
        return status;
    }

    @Override
    public boolean delete(String judul) {
        status = false;
        try {
            ps = db.connect().prepareStatement("DELETE FROM buku WHERE judul = ?");
            ps.setString(1, judul);

            status = db.execute(ps, false);
        } catch (SQLException e) {
            System.out.println("QUERY DELETE SALAH = " + e.getMessage());
            System.exit(0);
        }
        return status;
    }
    
    private List get(String type,String cari){
        String query = null;
        
        if (type.equalsIgnoreCase("ALL")) {
            query = "SELECT * FROM buku WHERE judul like ? or kategori like ? or penerbit like ? order by id";
        }else if(type.equalsIgnoreCase("AVAILABLE")){
            query = "SELECT * FROM buku b where (judul like ? or kategori like ? or penerbit like ?) and b.stok > (select count(p.id) from peminjaman p join detail_peminjaman d on d.id_peminjaman = p.id where status = 'aktif' and id_buku = b.id)";
        }
        
        try {
            ps = db.connect().prepareStatement(query);
            ps.setString(1, "%" + cari + "%");
            ps.setString(2, "%" + cari + "%");
            ps.setString(3, "%" + cari + "%");

            status = db.execute(ps, true);
            if (status) {
                data_buku = db.get_hasil();
                listBuku = new ArrayList<>();

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
            }
        } catch (SQLException e) {
            System.out.println("QUERY SELECT BUKU SALAH = " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    @Override
    public List get_all(String cari) {
        return this.get("ALL", cari);
    }
    
    @Override
    public List get_available(String cari) {
        return this.get("AVAILABLE", cari);
    }

}
