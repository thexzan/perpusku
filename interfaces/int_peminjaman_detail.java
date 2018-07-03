/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import entity.ent_peminjaman;
import java.util.List;

/**
 *
 * @author xzan
 */
public interface int_peminjaman_detail {
    List get_buku(int cari);
    List get_peminjam(int cari);
    List get_data_peminjaman(int cari);
    boolean kembali(int id);
    boolean delete(int id_peminjaman);
}
