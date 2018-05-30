/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.ent_buku;
import interfaces.int_buku;
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
    private db db;
    private boolean status;
    private ResultSet data_buku;
    private List<ent_buku> listBuku;

    public imp_buku() {
        db = new db();
        db.connect();
    }

    @Override
    public boolean insertBuku(ent_buku b) {
        status = false;
        query = "INSERT INTO buku VALUES (NULL,'"+b.getJudul()+"','"+b.getKategori()+"','"+b.getPenerbit()+"','"+b.getStok()+"')";
        status = db.exe(query, false);
        return status;
    }

    @Override
    public boolean updateBuku(ent_buku b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteBuku(String judul) {
        status = false;
        query = "DELETE FROM buku WHERE judul ='"+judul+"'";
        status = db.exe(query, false);
        return status;
    }
    
    @Override
    public List getBuku(String cari) {
        query = "SELECT * FROM buku WHERE judul like '%" + cari + "%' or kategori like '%" + cari + "%' or penerbit like '%" + cari + "%' order by id";
        status = db.exe(query, true);
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
