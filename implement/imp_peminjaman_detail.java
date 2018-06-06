/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.ent_anggota;
import entity.ent_buku;
import entity.ent_peminjaman;
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
    private List<ent_peminjaman> listPeminjaman;
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
            ps = db.connect().prepareStatement("select nama,telpon,alamat from detail_peminjaman d join peminjaman p on p.id = d.id_peminjaman join anggota a on a.id = p.id_anggota where id_peminjaman = ? group by id_peminjaman");
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

        } catch (SQLException e) {
            System.out.println("QUERY GET ANGGOTA SALAH = " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    @Override
    public List get_data_peminjaman(int cari) {
        try {
            ps = db.connect().prepareStatement("call data_peminjaman(?)");
            ps.setInt(1, cari);
            listPeminjaman = new ArrayList<>();

            status = db.execute(ps, true);
            if (status) {
                data = db.get_hasil();
                while (data.next()) {
                    ent_peminjaman x = new ent_peminjaman();

                    x.setTanggal(data.getString("tanggal"));
                    x.setTanggal_kembali(data.getString("tanggal_kembali"));
                    x.setDenda(data.getInt("denda"));
                    x.setStatus(data.getString("status"));
                    listPeminjaman.add(x);
                }
                data.close();
                return listPeminjaman;
            }

        } catch (SQLException e) {
            System.out.println("QUERY GET DATA PEMINJAMAN SALAH = " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    @Override
    public boolean kembali(int b) {
        status = false;
        try {
            ps = db.connect().prepareStatement("UPDATE peminjaman SET status = 'selesai', tanggal_kembali = now(), denda = if(tanggal_kembali != \"0000-00-00 00:00:00\" AND status != \"aktif\" AND datediff(tanggal_kembali,tanggal)> 7,(datediff(tanggal_kembali,tanggal)*500),denda) WHERE id = ?");
            ps.setInt(1, b);

            status = db.execute(ps, false);
        } catch (SQLException e) {
            System.out.println("QUERY PENGEMBALIAN BUKU SALAH = " + e.getMessage());
            System.exit(0);
        }
        return status;
    }

    
    @Override
    public boolean delete(int id_peminjaman) {
        status = false;
        try {
            ps = db.connect().prepareStatement("DELETE FROM peminjaman WHERE id = ?");
            ps.setInt(1, id_peminjaman);

            status = db.execute(ps, false);
        } catch (SQLException e) {
            System.out.println("QUERY DELETE PEMINJAMAN SALAH = " + e.getMessage());
            System.exit(0);
        }
        return status;
    }
}
