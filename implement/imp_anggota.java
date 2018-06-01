/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.ent_anggota;
import interfaces.int_anggota;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import koneksi.db;

/**
 *
 * @author xzan
 */
public class imp_anggota implements int_anggota{
    
    private String query;
    private final db db;
    private boolean status;
    private ResultSet data_anggota;
    private List<ent_anggota> listAnggota;

    public imp_anggota() {
        db = new db();
        db.connect();
    }
    
    @Override
    public boolean insert(ent_anggota a) {
        status = false;
        query = "INSERT INTO anggota VALUES (NULL,'"+a.getNama()+"','"+a.getTelpon()+"','"+a.getAlamat()+"')";
        status = db.exe(query, false);
        return status;
    }

    @Override
    public boolean update(ent_anggota a) {
        status = false;
        query = "UPDATE anggota SET nama='"+a.getNama()+"',telpon='"+a.getTelpon()+"',alamat='"+a.getAlamat()+"' WHERE id='"+a.getId()+"'";
        status = db.exe(query, false);
        return status;
    }

    @Override
    public boolean delete(int id) {
        status = false;
        query = "DELETE FROM anggota WHERE id ='"+id+"'";
        status = db.exe(query, false);
        return status;
    }

    @Override
    public List get(String cari) {
        query = "SELECT * FROM anggota WHERE nama like '%" + cari + "%' or alamat like '%" + cari + "%' or telpon like '%" + cari + "%' order by id";
        status = db.exe(query, true);
        if (status) {
            data_anggota = db.get_hasil();
            listAnggota = new ArrayList<>();
            try {
                while (data_anggota.next()) {
                    ent_anggota a = new ent_anggota();
                    a.setId(data_anggota.getInt(1));
                    a.setNama(data_anggota.getString(2));
                    a.setTelpon(data_anggota.getString(3));
                    a.setAlamat(data_anggota.getString(4));
                    listAnggota.add(a);
                }
                data_anggota.close();
                return listAnggota;
            } catch (SQLException e) {
                return null;
            }
        }
        return null;
    }
    
}
