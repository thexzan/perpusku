/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.JTableHeader;
/**
 * 
 *
 * @author xzan
 */
public class view_anggota extends javax.swing.JFrame {

    /**
     * Creates new form view_anggota
     */
    public view_anggota() {
        initComponents();
//        btn_edit.setVisible(false);
//        btn_tambah.setVisible(false);
          btn_cancel.setVisible(false);
          btn_save.setVisible(false);
        
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
        btn_tambah = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JLabel();
        btn_edit = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JLabel();
        tbl_anggota = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        nama = new javax.swing.JTextField();
        telpon = new javax.swing.JTextField();
        alamat = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        cari = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(640, 620));
        setMinimumSize(new java.awt.Dimension(640, 620));
        setPreferredSize(new java.awt.Dimension(640, 620));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_save.png"))); // NOI18N
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_saveMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_saveMouseEntered(evt);
            }
        });
        getContentPane().add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 186, 60, -1));

        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_tambah.png"))); // NOI18N
        btn_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_tambahMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_tambahMouseEntered(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 186, 60, -1));

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_cancel.png"))); // NOI18N
        btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelMouseEntered(evt);
            }
        });
        getContentPane().add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 266, 60, -1));

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_edit.png"))); // NOI18N
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editMouseEntered(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 266, 60, -1));

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_refresh.png"))); // NOI18N
        btn_refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_refreshMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_refreshMouseEntered(evt);
            }
        });
        getContentPane().add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 426, 60, -1));

        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png"))); // NOI18N
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_hapusMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_hapusMouseEntered(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 346, 60, -1));

        tbl_anggota.setBackground(new java.awt.Color(102, 255, 102));
        tbl_anggota.setBorder(null);
        tbl_anggota.setForeground(new java.awt.Color(204, 51, 255));

        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setSelectionBackground(new java.awt.Color(0, 122, 255));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_anggota.setViewportView(jTable1);

        getContentPane().add(tbl_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 480, 205));

        nama.setBackground(new Color(0,0,0,0));
        nama.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        nama.setForeground(new java.awt.Color(128, 128, 128));
        nama.setBorder(null);
        nama.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        nama.setSelectionColor(new java.awt.Color(0, 122, 255));
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 450, 220, 30));

        telpon.setBackground(new Color(0,0,0,0));
        telpon.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        telpon.setForeground(new java.awt.Color(128, 128, 128));
        telpon.setBorder(null);
        telpon.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        telpon.setSelectionColor(new java.awt.Color(0, 122, 255));
        getContentPane().add(telpon, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 518, 220, 30));

        alamat.setBackground(new java.awt.Color(255, 51, 51));
        alamat.setBorder(null);
        alamat.setForeground(new java.awt.Color(102, 204, 0));
        alamat.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        alamat.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(128, 128, 128));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jTextArea1.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jTextArea1.setSelectionColor(new java.awt.Color(0, 122, 255));
        alamat.setViewportView(jTextArea1);

        getContentPane().add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 450, 230, 100));

        cari.setBackground(new Color(0,0,0,0));
        cari.setFont(new java.awt.Font("Osaka", 0, 18)); // NOI18N
        cari.setForeground(new java.awt.Color(255, 255, 255));
        cari.setBorder(null);
        cari.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        cari.setSelectionColor(new java.awt.Color(0, 84, 129));
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 80, 165, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_anggota.png"))); // NOI18N
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
            java.util.logging.Logger.getLogger(view_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_anggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane alamat;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btn_cancel;
    private javax.swing.JLabel btn_edit;
    private javax.swing.JLabel btn_hapus;
    private javax.swing.JLabel btn_refresh;
    private javax.swing.JLabel btn_save;
    private javax.swing.JLabel btn_tambah;
    private javax.swing.JTextField cari;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField nama;
    private javax.swing.JScrollPane tbl_anggota;
    private javax.swing.JTextField telpon;
    // End of variables declaration//GEN-END:variables
}
