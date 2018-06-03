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
public interface int_peminjaman {
    List get(String cari);
    int get_insert_id();
    boolean insert(ent_peminjaman x);
    boolean insertDetail(ent_peminjaman x);
}
