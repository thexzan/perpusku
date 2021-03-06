/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author xzan
 */
public class view_menu extends javax.swing.JFrame {

    /**
     * Creates new form view_menu
     */
    public view_menu() {
        initComponents();
        setLocationRelativeTo(this);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                view_login x = new view_login();
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

        btn_logout = new javax.swing.JLabel();
        btn_buku = new javax.swing.JLabel();
        btn_anggota = new javax.swing.JLabel();
        btn_laporan = new javax.swing.JLabel();
        btn_sirkulasi = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_logout.png"))); // NOI18N
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_logoutMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_logoutMouseEntered(evt);
            }
        });
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 71, -1, -1));

        btn_buku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_buku.png"))); // NOI18N
        btn_buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_bukuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_bukuMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_bukuMouseEntered(evt);
            }
        });
        getContentPane().add(btn_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 179, -1, -1));

        btn_anggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_anggota.png"))); // NOI18N
        btn_anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_anggotaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_anggotaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_anggotaMouseEntered(evt);
            }
        });
        getContentPane().add(btn_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 179, -1, -1));

        btn_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_laporan.png"))); // NOI18N
        btn_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_laporanMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_laporanMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_laporanMouseEntered(evt);
            }
        });
        getContentPane().add(btn_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 312, -1, -1));

        btn_sirkulasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_sirkulasi.png"))); // NOI18N
        btn_sirkulasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_sirkulasiMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_sirkulasiMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_sirkulasiMouseEntered(evt);
            }
        });
        getContentPane().add(btn_sirkulasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 312, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_menu.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_bukuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bukuMouseEntered
        btn_buku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_buku_hover.png")));
    }//GEN-LAST:event_btn_bukuMouseEntered

    private void btn_bukuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bukuMouseExited
        btn_buku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_buku.png")));
    }//GEN-LAST:event_btn_bukuMouseExited

    private void btn_sirkulasiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sirkulasiMouseExited
        btn_sirkulasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_sirkulasi.png")));
    }//GEN-LAST:event_btn_sirkulasiMouseExited

    private void btn_sirkulasiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sirkulasiMouseEntered
        btn_sirkulasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_sirkulasi_hover.png")));
    }//GEN-LAST:event_btn_sirkulasiMouseEntered

    private void btn_anggotaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_anggotaMouseExited
        btn_anggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_anggota.png")));
    }//GEN-LAST:event_btn_anggotaMouseExited

    private void btn_anggotaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_anggotaMouseEntered
        btn_anggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_anggota_hover.png")));
    }//GEN-LAST:event_btn_anggotaMouseEntered

    private void btn_laporanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanMouseExited
        btn_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_laporan.png")));
    }//GEN-LAST:event_btn_laporanMouseExited

    private void btn_laporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanMouseEntered
        btn_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_laporan_hover.png")));
    }//GEN-LAST:event_btn_laporanMouseEntered

    private void btn_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseExited
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_logout.png")));
    }//GEN-LAST:event_btn_logoutMouseExited

    private void btn_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseEntered
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_logout_hover.png")));
    }//GEN-LAST:event_btn_logoutMouseEntered

    private void btn_bukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bukuMouseClicked
        view_buku x = new view_buku();
        x.setVisible(true);
    }//GEN-LAST:event_btn_bukuMouseClicked

    private void btn_anggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_anggotaMouseClicked
        view_anggota x = new view_anggota();
        x.setVisible(true);
    }//GEN-LAST:event_btn_anggotaMouseClicked

    private void btn_sirkulasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sirkulasiMouseClicked
        view_peminjaman x = new view_peminjaman();
        x.setVisible(true);
    }//GEN-LAST:event_btn_sirkulasiMouseClicked

    private void btn_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanMouseClicked
        view_report x = new view_report();
        x.setVisible(true);
    }//GEN-LAST:event_btn_laporanMouseClicked

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        view_login x = new view_login();
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(view_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btn_anggota;
    private javax.swing.JLabel btn_buku;
    private javax.swing.JLabel btn_laporan;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel btn_sirkulasi;
    // End of variables declaration//GEN-END:variables
}
