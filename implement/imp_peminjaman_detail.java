/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import interfaces.int_peminjaman_detail;
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
public class imp_peminjaman_detail implements int_peminjaman_detail {

    private String query;
    private final db db;
    private boolean status;
    private ResultSet data;
    private ArrayList<ArrayList<String>> listPeminjaman;
    private ArrayList<String> listAnggota;
    private PreparedStatement ps;

    public imp_peminjaman_detail() {
        db = new db();
        db.connect();
    }

    @Override
    public List get_buku(int cari) {
        try {
            ps = db.connect().prepareStatement("select judul,kategori from detail_peminjaman d join buku b on b.id = d.id_buku where id_peminjaman = ?");
            ps.setInt(1, cari);

            status = db.execute(ps, true);
            if (status) {
                data = db.get_hasil();
                listPeminjaman =new ArrayList<ArrayList<String>>();

                while (data.next()) {
                     ArrayList<String> x = new ArrayList<String>();
                   
                    x.add(data.getString("judul"));
                    x.add(data.getString("kategori"));
                    listPeminjaman.add(x);
                }
                data.close();
                
                return listPeminjaman;
            }
        } catch (SQLException e) {
            System.out.println("QUERY GET BUKU SALAH = " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    @Override
    public List get_peminjam(int cari) {
         try {
            ps = db.connect().prepareStatement("select nama,telpon,alamat from  detail_peminjaman d join peminjaman p on p.id = d.id_peminjaman join anggota a on a.id = p.id_anggota where id_peminjaman = ? group by id_peminjaman");
            ps.setInt(1,cari);

            status = db.execute(ps, true);
            if (status) {
                data = db.get_hasil();
                listAnggota =new ArrayList<String>();

                while (data.next()) {                   
                    listAnggota.add(data.getString("nama"));
                    listAnggota.add(data.getString("telpon"));
                    listAnggota.add(data.getString("alamat"));
                }
                data.close();
                return listAnggota;
                
                
                
            }
        } catch (SQLException e) {
            System.out.println("QUERY GET ANGGOTA SALAH = " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

}
