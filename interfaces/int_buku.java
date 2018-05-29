/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
//import entity.ent_buku;
import java.util.List;

/**
 *
 * @author xzan
 */
public interface int_buku {
//    boolean insertBuku (ent_buku b);
//    boolean updateBuku (ent_buku b);
//    boolean deleteBuku (int id);
    List getBuku(String cari);
}
