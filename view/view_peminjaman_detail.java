/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.ent_anggota;
import entity.ent_buku;
import entity.ent_peminjaman;
import java.awt.Color;
import factory.factory;
import interfaces.int_peminjaman;
import interfaces.int_peminjaman_detail;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 * @author xzan
 */
public class view_peminjaman_detail extends javax.swing.JFrame {

    private int baris;
    private int id_anggota;
    private String action;
    private boolean status;
    private DefaultTableModel model;
    private String[] tabelHeader;
    private int_peminjaman_detail peminjamanDetailDAO;
    private int_peminjaman peminjamanDAO;
    private List<ent_buku> listBuku;
    private List<ent_anggota> Anggota;
    private List<ent_peminjaman> Peminjaman;
    public int id_peminjaman;

    private void refresh_table() {
        listBuku = peminjamanDetailDAO.get_buku(id_peminjaman);
        model = (DefaultTableModel) tabel.getModel();
        model.setRowCount(0);

        listBuku.forEach((data) -> {
            model.addRow(new Object[]{
                data.getJudul(),
                data.getKategori()
            });
        });

        if (tabel.getRowCount() > 0) {
            baris = tabel.getRowCount() - 1;
            tabel.setRowSelectionInterval(baris, baris);
            action = "";
        }

    }

    private void table_setting() {
        peminjamanDetailDAO = factory.getPeminjamanDetailDA0();
        tabelHeader = new String[]{"Judul", "Kategori"};
        model = new DefaultTableModel(null, tabelHeader);
        tabel.setModel(model);
    }

    public view_peminjaman_detail() {
        System.out.print("You can't run this directly!");
        System.exit(1);
    }

    public view_peminjaman_detail(int a) {
        // a INI KIRIMAN DARI FORM SEBELUMNYA
        this.id_peminjaman = a;
        initComponents();
        nama.setEnabled(false);
        telpon.setEnabled(false);
        alamat.setEditable(false);
        denda.setEnabled(false);
        tanggal.setEnabled(false);
        kembali.setEnabled(false);
        setLocationRelativeTo(this);
        table_setting();
        refresh_table();

        Anggota = peminjamanDetailDAO.get_peminjam(id_peminjaman);
        Peminjaman = peminjamanDetailDAO.get_data_peminjaman(id_peminjaman);

        nama.setText(Anggota.get(0).getNama());
        telpon.setText(Anggota.get(0).getTelpon());
        alamat.setText(Anggota.get(0).getAlamat());

        // MENGUBAH FORMAT TANGGAL BIAR MUDAH DIBACA
        String tanggal_pinjam = Peminjaman.get(0).getTanggal();
        LocalDateTime tanggal_pinjam_parsed = LocalDateTime.parse(tanggal_pinjam, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
        String tanggal_pinjam_terformat = tanggal_pinjam_parsed.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yy"));

        String tanggal_kembali = Peminjaman.get(0).getTanggal_kembali();
        String tanggal_kembali_terformat = "";
        String denda_total = String.valueOf(Peminjaman.get(0).getDenda());

        // CEK TANGGAL KEMBALI ISINYA ADA GAK
        // KALAU GAK ADA BERARTI BELUM KEMBALI
        if (tanggal_kembali == null) {
            // DAPATKAN TANGGAL HARI INI
            LocalDateTime hari_ini = LocalDateTime.now();
            // HITUNG PERBEDAAN TANGGAL PINJAM DAN TANGGAL HARI INI DENGAN CHRONOUNIT
            int total_jumlah_hari = (int) ChronoUnit.DAYS.between(tanggal_pinjam_parsed, hari_ini);

            // KALAU TOTAL PEMINJAMAN UDAH LEBIH DARI 7 HARI MAKA STATUSNYA TERLAMBAT
            if (total_jumlah_hari > 7) {
                int terlambat = total_jumlah_hari - 7;
                tanggal_kembali_terformat = "Terlambat " + terlambat + " hari";
            } else {
                tanggal_kembali_terformat = "AKTIF";
            }
        } else {
            // KALAU SUDAH KEMBALI MAKA TINGGAL PARSE TANGGAL KEMBALI DARI DATABASE
            LocalDateTime tanggal_kembali_parsed = LocalDateTime.parse(tanggal_kembali, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
            tanggal_kembali_terformat = tanggal_kembali_parsed.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yy"));
        }

        tanggal.setText(tanggal_pinjam_terformat);
        kembali.setText(tanggal_kembali_terformat);
        denda.setText("Rp. " + String.valueOf(Peminjaman.get(0).getDenda()));

        if (Peminjaman.get(0).getStatus().equals("selesai")) {
            btn_kembali.setVisible(false);
            btn_delete.setVisible(false);
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                view_peminjaman x = new view_peminjaman();
                x.setVisible(true);
                dispose();
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_close = new javax.swing.JLabel();
        tbl_anggota = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        tanggal = new javax.swing.JTextField();
        btn_kembali = new javax.swing.JLabel();
        btn_delete = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        kembali = new javax.swing.JTextField();
        denda = new javax.swing.JTextField();
        telpon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 660));
        setResizable(false);
        setSize(new java.awt.Dimension(640, 660));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_back.png"))); // NOI18N
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_closeMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_closeMouseEntered(evt);
            }
        });
        getContentPane().add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 186, 60, -1));

        tbl_anggota.setBackground(new java.awt.Color(102, 255, 102));
        tbl_anggota.setBorder(null);
        tbl_anggota.setForeground(new java.awt.Color(204, 51, 255));
        tbl_anggota.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        tbl_anggota.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tabel.setForeground(new java.awt.Color(51, 51, 51));
        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.setPreferredSize(new java.awt.Dimension(480, 190));
        tabel.setSelectionBackground(new java.awt.Color(0, 122, 255));
        tabel.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_anggota.setViewportView(tabel);

        getContentPane().add(tbl_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 480, 80));

        tanggal.setBackground(new Color(0,0,0,0));
        tanggal.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        tanggal.setForeground(new java.awt.Color(0, 0, 0));
        tanggal.setBorder(null);
        tanggal.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        tanggal.setSelectionColor(new java.awt.Color(0, 122, 255));
        getContentPane().add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 505, 220, 30));

        btn_kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_kembali.png"))); // NOI18N
        btn_kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kembaliMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_kembaliMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_kembaliMouseEntered(evt);
            }
        });
        getContentPane().add(btn_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 346, 60, -1));

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png"))); // NOI18N
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_deleteMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_deleteMouseEntered(evt);
            }
        });
        getContentPane().add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 266, 60, -1));

        nama.setBackground(new Color(0,0,0,0));
        nama.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        nama.setForeground(new java.awt.Color(0, 0, 0));
        nama.setBorder(null);
        nama.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        nama.setSelectionColor(new java.awt.Color(0, 122, 255));
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 200, 220, 30));

        kembali.setBackground(new Color(0,0,0,0));
        kembali.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        kembali.setForeground(new java.awt.Color(0, 0, 0));
        kembali.setBorder(null);
        kembali.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        kembali.setSelectionColor(new java.awt.Color(0, 122, 255));
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 575, 220, 30));

        denda.setBackground(new Color(0,0,0,0));
        denda.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        denda.setForeground(new java.awt.Color(0, 0, 0));
        denda.setBorder(null);
        denda.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        denda.setSelectionColor(new java.awt.Color(0, 122, 255));
        getContentPane().add(denda, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 505, 220, 30));

        telpon.setBackground(new Color(0,0,0,0));
        telpon.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        telpon.setForeground(new java.awt.Color(0, 0, 0));
        telpon.setBorder(null);
        telpon.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        telpon.setSelectionColor(new java.awt.Color(0, 122, 255));
        getContentPane().add(telpon, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 268, 220, 30));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        alamat.setBackground(new java.awt.Color(255, 255, 255));
        alamat.setColumns(20);
        alamat.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        alamat.setForeground(new java.awt.Color(91, 91, 95));
        alamat.setRows(5);
        alamat.setBorder(null);
        alamat.setSelectionColor(new java.awt.Color(0, 122, 255));
        jScrollPane1.setViewportView(alamat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 230, 100));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_peminjaman_detail_2.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseExited
        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_back.png")));
    }//GEN-LAST:event_btn_closeMouseExited

    private void btn_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseEntered
        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_back_hover.png")));
    }//GEN-LAST:event_btn_closeMouseEntered

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        view_peminjaman x = new view_peminjaman();
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_closeMouseClicked

    private void btn_kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kembaliMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Yakin sudah kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            status = peminjamanDetailDAO.kembali(id_peminjaman);

            if (status == false) {
                JOptionPane.showMessageDialog(null, "Gagal Mengembalikan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "SUKSES Pengembalian Selesai!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                view_peminjaman x = new view_peminjaman();
                x.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_btn_kembaliMouseClicked

    private void btn_kembaliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kembaliMouseExited
        btn_kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_kembali.png")));
    }//GEN-LAST:event_btn_kembaliMouseExited

    private void btn_kembaliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kembaliMouseEntered
        btn_kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_kembali_hover.png")));
    }//GEN-LAST:event_btn_kembaliMouseEntered

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            status = peminjamanDetailDAO.delete(id_peminjaman);

            if (status == false) {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                view_peminjaman x = new view_peminjaman();
                x.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void btn_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseExited
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png")));
    }//GEN-LAST:event_btn_deleteMouseExited

    private void btn_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseEntered
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete_hover.png")));
    }//GEN-LAST:event_btn_deleteMouseEntered

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
            java.util.logging.Logger.getLogger(view_peminjaman_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_peminjaman_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_peminjaman_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_peminjaman_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_peminjaman_detail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btn_close;
    private javax.swing.JLabel btn_delete;
    private javax.swing.JLabel btn_kembali;
    private javax.swing.JTextField denda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kembali;
    private javax.swing.JTextField nama;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tanggal;
    private javax.swing.JScrollPane tbl_anggota;
    private javax.swing.JTextField telpon;
    // End of variables declaration//GEN-END:variables
}
