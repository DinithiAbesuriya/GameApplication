/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Start_GUI;

/**
 *
 * @author dinithi
 */
import GUI_UserValidation.*;
import javax.swing.ImageIcon;
public class Start2 extends javax.swing.JFrame {

    /**
     * Creates new form Start_GUI
     */
    public Start2() {
        initComponents();
        ImageIcon ii = new ImageIcon("gamepictures/Screenshot 2023-03-01 at 20.34.38 Medium.jpeg");
        signup_btn.setIcon(ii);
        ImageIcon ii1 = new ImageIcon("gamepictures/loginedited.png");
        login_btn.setIcon(ii1);
        ImageIcon ii2 = new ImageIcon("gamepictures/aircraft icon Small.jpeg");
        middle_image.setIcon(ii2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        start_background = new javax.swing.JPanel();
        login_btn = new javax.swing.JButton();
        signup_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        middle_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 51, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        start_background.setBackground(new java.awt.Color(158, 90, 255));
        start_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });
        start_background.add(login_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 99, 420, 540));

        signup_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_btnActionPerformed(evt);
            }
        });
        start_background.add(signup_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 420, 550));

        jLabel3.setText("jLabel3");
        start_background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 600, -1, -1));

        jLabel4.setText("jLabel4");
        start_background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 500, -1, -1));

        jLabel5.setText("jLabel5");
        start_background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 580, -1, -1));
        start_background.add(middle_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 300, 300));

        getContentPane().add(start_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signup_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_btnActionPerformed
        // TODO add your handling code here:
        dispose();
       SignUp_TEST l=new SignUp_TEST();
        l.setVisible(true);
    }//GEN-LAST:event_signup_btnActionPerformed

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        // TODO add your handling code here:
        dispose();
        Login l=new Login();
        l.setVisible(true);
    }//GEN-LAST:event_login_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Start2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton login_btn;
    private javax.swing.JLabel middle_image;
    private javax.swing.JButton signup_btn;
    private javax.swing.JPanel start_background;
    // End of variables declaration//GEN-END:variables
}
