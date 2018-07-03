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
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 * @author xzan
 */
public class view_pilih_buku extends javax.swing.JDialog {

    private int baris;
    private String action;
    private boolean status;
    private DefaultTableModel model;
    private final String[] tabelHeader;
    private final int_buku bukuDAO;
    private List<ent_buku> listBuku;
    public view_peminjaman_baru pinjam = null;

    public String judul, kategori;
    public int id_buku;

    private void refresh_table() {
        listBuku = bukuDAO.get_available(cari.getText());
        model = (DefaultTableModel) tabel.getModel();
        model.setRowCount(0);

        for (ent_buku data : listBuku) {
            model.addRow(new Object[]{
                data.getId(),
                data.getJudul(),
                data.getKategori()
            });
        }

        if (tabel.getRowCount() > 0) {
            baris = tabel.getRowCount() - 1;
            tabel.setRowSelectionInterval(baris, baris);
            action = "";
        }

    }

    public view_pilih_buku(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        bukuDAO = factory.getBukuDA0();
        tabelHeader = new String[]{"ID", "Judul", "Kategori"};
        model = new DefaultTableModel(null, tabelHeader);
        tabel.setModel(model);

        tabel.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            baris = tabel.getSelectedRow();
            if (baris >= 0) {
                id_buku = Integer.parseInt(model.getValueAt(baris, 0).toString());
                judul = model.getValueAt(baris, 1).toString();
                kategori = model.getValueAt(baris, 2).toString();
            }
        });

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

        btn_save = new javax.swing.JLabel();
        tbl_anggota = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        cari = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 510));
        setResizable(false);
        setSize(new java.awt.Dimension(640, 510));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_pilih.png"))); // NOI18N
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

        getContentPane().add(tbl_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 275, 480, 190));

        cari.setBackground(new Color(0,0,0,0));
        cari.setFont(new java.awt.Font("Osaka", 0, 18)); // NOI18N
        cari.setForeground(new java.awt.Color(51, 51, 51));
        cari.setBorder(null);
        cari.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        cari.setSelectionColor(new java.awt.Color(0, 84, 129));
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 190, 420, 40));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_pilih_buku.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseExited
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_pilih.png")));
    }//GEN-LAST:event_btn_saveMouseExited

    private void btn_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseEntered
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_pilih_hover.png")));
    }//GEN-LAST:event_btn_saveMouseEntered

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        refresh_table();
    }//GEN-LAST:event_cariKeyReleased

    private void btn_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseClicked
        pinjam.id_buku = id_buku;
        pinjam.judul = judul;
        pinjam.kategori = kategori;
        this.dispose();
    }//GEN-LAST:event_btn_saveMouseClicked

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
            java.util.logging.Logger.getLogger(view_pilih_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_pilih_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_pilih_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_pilih_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                view_pilih_buku dialog = new view_pilih_buku(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btn_save;
    private javax.swing.JTextField cari;
    private javax.swing.JTable tabel;
    private javax.swing.JScrollPane tbl_anggota;
    // End of variables declaration//GEN-END:variables
}
