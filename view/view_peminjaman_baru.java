/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import entity.ent_peminjaman;
import factory.factory;
import interfaces.int_peminjaman;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 * @author xzan
 */
public class view_peminjaman_baru extends javax.swing.JFrame {

    private int baris;
    private int id_peminjaman;
    private String action;
    private boolean status;
    private DefaultTableModel model;
    private final String[] tabelHeader;
    private final int_peminjaman peminjamanDAO;
    private List<ent_peminjaman> listData;
    private ent_peminjaman a;

    public int id_anggota, id_buku, jml_buku = 0;
    public String xnama, xtelpon, xalamat, judul, kategori;

    public view_peminjaman_baru() {
        initComponents();
        setLocationRelativeTo(null);

        peminjamanDAO = factory.getPeminjamanDA0();
        tabelHeader = new String[]{"ID", "Judul", "Kategori"};
        model = new DefaultTableModel(null, tabelHeader);
        tabel.setModel(model);

        nama.setEnabled(false);
        telpon.setEnabled(false);
        alamat.setEditable(false);

        tabel.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabel.getColumnModel().getColumn(2).setPreferredWidth(80);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_add_buku = new javax.swing.JLabel();
        btn_save = new javax.swing.JLabel();
        btn_people = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JLabel();
        tbl_anggota = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        nama = new javax.swing.JTextField();
        telpon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 450));
        setResizable(false);
        setSize(new java.awt.Dimension(640, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_add_buku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_detail.png"))); // NOI18N
        btn_add_buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_bukuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_add_bukuMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_add_bukuMouseEntered(evt);
            }
        });
        getContentPane().add(btn_add_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 456, 60, -1));

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

        btn_people.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_people.png"))); // NOI18N
        btn_people.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_peopleMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_peopleMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_peopleMouseEntered(evt);
            }
        });
        getContentPane().add(btn_people, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 266, 60, -1));

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

        getContentPane().add(tbl_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 480, 100));

        nama.setBackground(new Color(0,0,0,0));
        nama.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        nama.setForeground(new java.awt.Color(0, 0, 0));
        nama.setBorder(null);
        nama.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        nama.setSelectionColor(new java.awt.Color(0, 122, 255));
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 200, 220, 30));

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
        alamat.setForeground(new java.awt.Color(0, 0, 0));
        alamat.setRows(5);
        alamat.setBorder(null);
        alamat.setSelectionColor(new java.awt.Color(0, 122, 255));
        jScrollPane1.setViewportView(alamat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 230, 100));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_peminjaman_baru.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_bukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_bukuMouseClicked
        if (jml_buku < 3) {
            view_pilih_buku x = new view_pilih_buku(null, true);
            x.pinjam = this;
            x.setVisible(true);

            model.addRow(new Object[]{
                id_buku, judul, kategori
            });
        } else {
            JOptionPane.showMessageDialog(null, "Maksimal Pinjam 3");
        }
        jml_buku = tabel.getRowCount();
        System.out.print(jml_buku);
    }//GEN-LAST:event_btn_add_bukuMouseClicked

    private void btn_add_bukuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_bukuMouseExited
        btn_add_buku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_detail.png")));
    }//GEN-LAST:event_btn_add_bukuMouseExited

    private void btn_add_bukuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_bukuMouseEntered
        btn_add_buku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_detail_hover.png")));
    }//GEN-LAST:event_btn_add_bukuMouseEntered

    private void btn_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseClicked
        int row = tabel.getRowCount();
        if (row > 0 && !nama.equals("")) {
            a = new ent_peminjaman();
            a.setId_anggota(id_anggota);

            status = peminjamanDAO.insert(a);

            if (status == false) {
                JOptionPane.showMessageDialog(null, "Data gagal disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                for (int i = 0; i < row; i++) {

                    a.setId_buku(Integer.parseInt(model.getValueAt(i, 0).toString()));
                    System.out.println("Buku ID = " + a.getId_buku());
                    peminjamanDAO.insertDetail(a);
                }
            }

            view_peminjaman v = new view_peminjaman();
            v.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Silakan diisi dengan benar", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_saveMouseClicked

    private void btn_saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseExited
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_save.png")));
    }//GEN-LAST:event_btn_saveMouseExited

    private void btn_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseEntered
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_save_hover.png")));
    }//GEN-LAST:event_btn_saveMouseEntered

    private void btn_peopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_peopleMouseClicked
        view_pilih_peminjam x = new view_pilih_peminjam(null, true);
        x.pinjam = this;
        x.setVisible(true);
        nama.setText(xnama);
        alamat.setText(xalamat);
        telpon.setText(xtelpon);
    }//GEN-LAST:event_btn_peopleMouseClicked

    private void btn_peopleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_peopleMouseExited
        btn_people.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_people.png")));
    }//GEN-LAST:event_btn_peopleMouseExited

    private void btn_peopleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_peopleMouseEntered
        btn_people.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_people_hover.png")));
    }//GEN-LAST:event_btn_peopleMouseEntered

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        int row = tabel.getSelectedRow();
        model.removeRow(row);
        jml_buku = jml_buku - 1;
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_hapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseExited
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png")));
    }//GEN-LAST:event_btn_hapusMouseExited

    private void btn_hapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseEntered
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete_hover.png")));
    }//GEN-LAST:event_btn_hapusMouseEntered

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
            java.util.logging.Logger.getLogger(view_peminjaman_baru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_peminjaman_baru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_peminjaman_baru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_peminjaman_baru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new view_peminjaman_baru().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btn_add_buku;
    private javax.swing.JLabel btn_hapus;
    private javax.swing.JLabel btn_people;
    private javax.swing.JLabel btn_save;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nama;
    private javax.swing.JTable tabel;
    private javax.swing.JScrollPane tbl_anggota;
    private javax.swing.JTextField telpon;
    // End of variables declaration//GEN-END:variables
}
