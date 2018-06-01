/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.ent_anggota;
import java.util.List;

/**
 *
 * @author xzan
 */
public interface int_anggota {

    boolean insert(ent_anggota a);
    boolean update(ent_anggota a);
    boolean delete(int id);
    List get(String cari);
}
