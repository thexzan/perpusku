/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.ent_anggota;
import entity.ent_buku;
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
    private List<ent_buku> listBuku;
    private List<ent_anggota> listAnggota;
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
                listBuku = new ArrayList<>();

                while (data.next()) {
                    ent_buku x = new ent_buku();

                    x.setJudul(data.getString("judul"));
                    x.setKategori(data.getString("kategori"));
                    listBuku.add(x);
                }
                data.close();

                return listBuku;
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
            ps.setInt(1, cari);
            listAnggota = new ArrayList<>();

            status = db.execute(ps, true);
            if (status) {
                data = db.get_hasil();
                while (data.next()) {
                    ent_anggota x = new ent_anggota();

                    x.setNama(data.getString("nama"));
                    x.setTelpon(data.getString("telpon"));
                    x.setAlamat(data.getString("alamat"));
                    listAnggota.add(x);
                }
                data.close();
                return listAnggota;
            }

            ent_anggota x = new ent_anggota();
            System.out.print(x.getNama());
        } catch (SQLException e) {
            System.out.println("QUERY GET ANGGOTA SALAH = " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

}
