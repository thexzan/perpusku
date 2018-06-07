/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import entity.ent_buku;
import java.util.List;

/**
 *
 * @author xzan
 */
public interface int_buku {
    boolean insert(ent_buku b);
    boolean update(ent_buku b);
    boolean delete(String judul);
    List get_all(String cari);
    List get_available(String cari);
}
