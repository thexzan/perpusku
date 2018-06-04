/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import entity.ent_login;
import factory.factory;
import interfaces.int_login;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 * @author xzan
 */
public class view_login extends javax.swing.JFrame {

    private int baris;
    private String action;
    private boolean status;
    private DefaultTableModel model;
    private final int_login loginDAO;
    private ent_login x;

    public view_login() {
        initComponents();
        setLocationRelativeTo(null);
        username.requestFocus();
        loginDAO = factory.getLoginDA0();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_login = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(400, 415));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_login.png"))); // NOI18N
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_loginMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_loginMouseEntered(evt);
            }
        });
        getContentPane().add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 318, 60, -1));

        username.setBackground(new Color(0,0,0,0));
        username.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        username.setForeground(new java.awt.Color(0, 0, 0));
        username.setBorder(null);
        username.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        username.setSelectionColor(new java.awt.Color(0, 122, 255));
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 199, 220, 30));

        password.setBackground(new Color(0,0,0,0));
        password.setFont(new java.awt.Font("Osaka", 0, 20)); // NOI18N
        password.setForeground(new java.awt.Color(0, 0, 0));
        password.setBorder(null);
        password.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        password.setSelectionColor(new java.awt.Color(0, 122, 255));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 269, 220, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_login.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseExited
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_login.png")));
    }//GEN-LAST:event_btn_loginMouseExited

    private void btn_loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseEntered
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_login_hover.png")));
    }//GEN-LAST:event_btn_loginMouseEntered

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        x = new ent_login();
        x.setUsername(username.getText());
        x.setPassword(password.getText());
        boolean login = loginDAO.cek_login(x);
        
        if (login){
            this.dispose();
            System.out.print("YESSS LOGIN");
//            new view().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Username / Password Tidak Cocok!");
        } 
    }//GEN-LAST:event_btn_loginMouseClicked

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
            java.util.logging.Logger.getLogger(view_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel btn_login;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}