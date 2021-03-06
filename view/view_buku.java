/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import entity.ent_buku;
import factory.factory;
import interfaces.int_buku;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 * @author xzan
 */
public class view_buku extends javax.swing.JFrame {

    private int baris;
    private String action;
    private boolean status;
    private DefaultTableModel model;
    private final String[] tabelHeader;
    private final int_buku bukuDAO;
    private List<ent_buku> listBuku;
    private ent_buku b;

    // METHOD UNTUK ENABLE DISABLE EDITING PADA TEKS FIELD
    private void enable_text(boolean status) {
        stok.setEnabled(status);
        tbl_buku.setEnabled(!status);
        penerbit.setEnabled(status);
        kategori.setEnabled(status);
        
        cari.setEnabled(!status);
        cari.setEditable(!status);
        judul.setEnabled(false);
    }

    // METHOD UNTUK MENGUBAH TOMBOL YANG TAMPIL
    private void default_button(boolean status) {
        btn_tambah.setVisible(status);
        btn_edit.setVisible(status);
        btn_hapus.setVisible(status);
        btn_refresh.setVisible(status);

        btn_save.setVisible(!status);
        btn_cancel.setVisible(!status);
    }

    // METHOD UNTUK MENGOSONGKAN TEKS FIELD
    private void clear_text() {
        judul.setText("");
        kategori.setText("");
        penerbit.setText("");
        stok.setText("");
        cari.setText("");
    }

    // METHOD UNTUK MENGAMBIL DATA DARI DATABASE
    private void refresh_table() {
        listBuku = bukuDAO.get_all(cari.getText());
        model = (DefaultTableModel) tbl_buku.getModel();
        model.setRowCount(0);

        // PERULANGAN UNTUK MENGISI TABEL
        for (ent_buku data : listBuku) {
            model.addRow(new Object[]{
                data.getJudul(),
                data.getKategori(),
                data.getPenerbit(),
                data.getStok()
            });
        }

        // KALAU TABEL ADA ISINYA ,
        // MAKA PILIH BARIS PALING BAWAH
        if (tbl_buku.getRowCount() > 0) {
            baris = tbl_buku.getRowCount() - 1;
            tbl_buku.setRowSelectionInterval(baris, baris);
            action = "";
        }

    }

    public view_buku() {
        initComponents();
 
        setLocationRelativeTo(null);
        enable_text(false);
        judul.setEnabled(false);
        btn_cancel.setVisible(false);
        btn_save.setVisible(false);

        bukuDAO = factory.getBukuDA0();
        
        // SET JUDUL MASING-MASING KOLOM PADA TABLE
        tabelHeader = new String[]{"Judul", "Kategori", "Penerbit", "Stok"};
        model = new DefaultTableModel(null, tabelHeader);
        tbl_buku.setModel(model);
        
        // MEMASANG LISTENER AGAR PROGRAM MENGETAHUI
        // BARIS MANA YANG SEDANG DIPILIH OLEH USER
        tbl_buku.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            baris = tbl_buku.getSelectedRow();
            if (baris >= 0) {
                judul.setText(model.getValueAt(baris, 0).toString());
                kategori.setText(model.getValueAt(baris, 1).toString());
                penerbit.setText(model.getValueAt(baris, 2).toString());
                stok.setText(model.getValueAt(baris, 3).toString());
            }
        });
        
        // MENGATUR LEBAR MASING-MASING KOLOM PADA TABEL
        tbl_buku.getColumnModel().getColumn(0).setPreferredWidth(180);
        tbl_buku.getColumnModel().getColumn(1).setPreferredWidth(120);
        tbl_buku.getColumnModel().getColumn(2).setPreferredWidth(140);
        tbl_buku.getColumnModel().getColumn(3).setPreferredWidth(40);

        refresh_table();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kategori = new javax.swing.JTextField();
        stok = new javax.swing.JTextField();
        btn_save = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JLabel();
        btn_edit = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JLabel();
        tbl_anggota = new javax.swing.JScrollPane();
        tbl_buku = new javax.swing.JTable();
        judul = new javax.swing.JTextField();
        penerbit = new javax.swing.JTextField();
        cari = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 620));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kategori.setBackground(new Color(0,0,0,0));
        kategori.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        kategori.setForeground(new java.awt.Color(0, 0, 0));
        kategori.setBorder(null);
        kategori.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        kategori.setSelectionColor(new java.awt.Color(0, 122, 255));
        getContentPane().add(kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 450, 220, 30));

        stok.setBackground(new Color(0,0,0,0));
        stok.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        stok.setForeground(new java.awt.Color(0, 0, 0));
        stok.setBorder(null);
        stok.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        stok.setSelectionColor(new java.awt.Color(0, 122, 255));
        getContentPane().add(stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 518, 220, 30));

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_save.png"))); // NOI18N
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_saveMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_saveMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_saveMouseEntered(evt);
            }
        });
        getContentPane().add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 186, 60, -1));

        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_tambah.png"))); // NOI18N
        btn_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambahMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_tambahMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_tambahMouseEntered(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 186, 60, -1));

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_cancel.png"))); // NOI18N
        btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelMouseEntered(evt);
            }
        });
        getContentPane().add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 266, 60, -1));

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_edit.png"))); // NOI18N
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editMouseEntered(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 266, 60, -1));

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_refresh.png"))); // NOI18N
        btn_refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_refreshMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_refreshMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_refreshMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_refreshMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_refreshMouseEntered(evt);
            }
        });
        getContentPane().add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 426, 60, -1));

        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png"))); // NOI18N
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_hapusMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_hapusMouseEntered(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 346, 60, -1));

        tbl_anggota.setBackground(new java.awt.Color(102, 255, 102));
        tbl_anggota.setBorder(null);
        tbl_anggota.setForeground(new java.awt.Color(204, 51, 255));
        tbl_anggota.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        tbl_anggota.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tbl_buku.setForeground(new java.awt.Color(51, 51, 51));
        tbl_buku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"TEST", "TEST", null, null},
                {"TEST", "TEST", null, null},
                {"TEST", "TEST", null, null},
                {null, "TEST", null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_buku.setPreferredSize(new java.awt.Dimension(480, 190));
        tbl_buku.setSelectionBackground(new java.awt.Color(0, 122, 255));
        tbl_buku.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_anggota.setViewportView(tbl_buku);

        getContentPane().add(tbl_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 480, 205));

        judul.setBackground(new Color(0,0,0,0));
        judul.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        judul.setForeground(new java.awt.Color(0, 0, 0));
        judul.setBorder(null);
        judul.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        judul.setSelectionColor(new java.awt.Color(0, 122, 255));
        getContentPane().add(judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 450, 220, 30));

        penerbit.setBackground(new Color(0,0,0,0));
        penerbit.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        penerbit.setForeground(new java.awt.Color(0, 0, 0));
        penerbit.setBorder(null);
        penerbit.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        penerbit.setSelectionColor(new java.awt.Color(0, 122, 255));
        getContentPane().add(penerbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 518, 220, 30));

        cari.setBackground(new Color(0,0,0,0));
        cari.setFont(new java.awt.Font("Osaka", 0, 18)); // NOI18N
        cari.setForeground(new java.awt.Color(255, 255, 255));
        cari.setBorder(null);
        cari.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        cari.setSelectionColor(new java.awt.Color(0, 84, 129));
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 80, 165, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_bubku.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseExited
        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_tambah.png")));
    }//GEN-LAST:event_btn_tambahMouseExited

    private void btn_tambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseEntered
        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_tambah_hover.png")));
    }//GEN-LAST:event_btn_tambahMouseEntered

    private void btn_hapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseExited
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png")));
    }//GEN-LAST:event_btn_hapusMouseExited

    private void btn_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseExited
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_edit.png")));
    }//GEN-LAST:event_btn_editMouseExited

    private void btn_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseEntered
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_edit_hover.png")));
    }//GEN-LAST:event_btn_editMouseEntered

    private void btn_hapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseEntered
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete_hover.png")));
    }//GEN-LAST:event_btn_hapusMouseEntered

    private void btn_refreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshMouseExited
        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_refresh.png")));
    }//GEN-LAST:event_btn_refreshMouseExited

    private void btn_refreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshMouseEntered
        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_refresh_hover.png")));
    }//GEN-LAST:event_btn_refreshMouseEntered

    private void btn_saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseExited
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_save.png")));
    }//GEN-LAST:event_btn_saveMouseExited

    private void btn_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseEntered
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_save_hover.png")));
    }//GEN-LAST:event_btn_saveMouseEntered

    private void btn_cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseExited
        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_cancel.png")));
    }//GEN-LAST:event_btn_cancelMouseExited

    private void btn_cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseEntered
        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_cancel_hover.png")));
    }//GEN-LAST:event_btn_cancelMouseEntered

    private void btn_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseClicked
        default_button(false);
        enable_text(true);
        clear_text();
        // KARENA MAU MELAKUKAN TAMBAH BERARTI ACTION KITA ISI INSERT
        action = "INSERT";

        judul.setEnabled(true);
        judul.setEditable(true);
        judul.requestFocus();
    }//GEN-LAST:event_btn_tambahMouseClicked

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        default_button(false);
        enable_text(true);
        // KARENA MAU MELAKUKAN EDIT BERARTI ACTION KITA ISI UPDATE
        action = "UPDATE";
        kategori.requestFocus();
    }//GEN-LAST:event_btn_editMouseClicked

    private void btn_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseClicked
        // TAMPILKAN KONFIRMASI
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin Cancel?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // JIKA SETUJU MAKA MASUK SINI
            default_button(true);
            enable_text(false);
            refresh_table();
        }
    }//GEN-LAST:event_btn_cancelMouseClicked

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        // SAAT MENGETIK DI TEKS FIELD PENCARIAN
        // MAKA SETIAP SATU HURUF YANG DIKETIK AKAN MELAKUKAN REFERSH TABLE
        // SEHINGGA TIDAK PERLU TOMBOL CARI
        refresh_table();
    }//GEN-LAST:event_cariKeyReleased

    private void btn_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseClicked
        // MEMASUKAN DATA KE ENTITY BUKU
        b = new ent_buku();
        b.setJudul(judul.getText());
        b.setKategori(kategori.getText());
        b.setPenerbit(penerbit.getText());

        // MENGGUNAKAN TRY CATCH
        // KARENA STOK HARUS DI ISI DENGAN ANGKA
        try {
            // JIKA STOK BENAR TERISI ANGKA MAKA MASUK SINI
            
            b.setStok(Integer.parseInt(stok.getText()));
            
            // CEK APAKAH SEMUA SUDAH DIISI 
            if (b.getJudul().equals("") || b.getPenerbit().equals("") || b.getKategori().equals("")) {
                // JIKA ADA YANG BELUM DIISI MAKA SURUH NGISI
                JOptionPane.showMessageDialog(null, "Silakan isi semua kolom");
            } else {
                // JIKA SUDAH DIISI SEMUA MASUK SINI
                // CEK APAKAH ACTIONNYA INSERT ATAU UPDATE
                if (action.equalsIgnoreCase("INSERT")) {
                    status = bukuDAO.insert(b);
                } else {
                    status = bukuDAO.update(b);
                }
                if (!status) {
                    JOptionPane.showMessageDialog(null, "Data gagal disimpan","Informasi", JOptionPane.INFORMATION_MESSAGE);
                }
                refresh_table();
                enable_text(false);
                default_button(true);
            }

        } catch (NumberFormatException e) {
            // KALAU STOK DIISI SELAIN ANGKA MAKA MASUK SINI TAMPILKAN PESAN
            JOptionPane.showMessageDialog(null, "isi STOK dengan ANGKA");
        }
    }//GEN-LAST:event_btn_saveMouseClicked

    private void btn_refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshMouseClicked
        cari.setText("");
        refresh_table();
    }//GEN-LAST:event_btn_refreshMouseClicked

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        // KONFIRMASI DULU SEBELUM BENAR-BENAR MENGHAPUS DATA
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // JIKA SETUJU MAKA DATA AKAN DI HAPUS
            status = bukuDAO.delete(judul.getText());

            if (!status) {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        refresh_table();
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_refreshMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshMousePressed
       btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_refresh_pressed.png")));
    }//GEN-LAST:event_btn_refreshMousePressed

    private void btn_refreshMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshMouseReleased
       btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_refresh_hover.png")));
    }//GEN-LAST:event_btn_refreshMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(view_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_buku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btn_cancel;
    private javax.swing.JLabel btn_edit;
    private javax.swing.JLabel btn_hapus;
    private javax.swing.JLabel btn_refresh;
    private javax.swing.JLabel btn_save;
    private javax.swing.JLabel btn_tambah;
    private javax.swing.JTextField cari;
    private javax.swing.JTextField judul;
    private javax.swing.JTextField kategori;
    private javax.swing.JTextField penerbit;
    private javax.swing.JTextField stok;
    private javax.swing.JScrollPane tbl_anggota;
    private javax.swing.JTable tbl_buku;
    // End of variables declaration//GEN-END:variables
}
