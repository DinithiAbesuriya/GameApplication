/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Achievements;

/**
 *
 * @author dinithi
 */
import AllGames.GameSelection;
import Database.DBConnection;
import Database.DBFetchDataEmojiGame;
import Database.DBFetchDataSmileGame;
import javax.swing.ImageIcon;
public class Rank extends javax.swing.JFrame {
public String gameplayed,username;

    /**
     * Creates new form Rank
     */
    public Rank() {
        initComponents();
        ImageIcon ii1 = new ImageIcon("gamepictures/AchievemnetsImages/LeaderBoard.png");
        lablebackground.setIcon(ii1);
        
        ImageIcon ii12 = new ImageIcon("gamepictures/AchievemnetsImages/leaderboardbtn.png");
        cont.setIcon(ii12);
       
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lable1st = new javax.swing.JLabel();
        lable2nd = new javax.swing.JLabel();
        lable3rd = new javax.swing.JLabel();
        lableyourrank = new javax.swing.JLabel();
        lableyourrank1 = new javax.swing.JLabel();
        cont = new javax.swing.JButton();
        lablebackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lable1st.setFont(new java.awt.Font("Lucida Grande", 3, 48)); // NOI18N
        jPanel1.add(lable1st, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 200, 70));

        lable2nd.setFont(new java.awt.Font("Lucida Grande", 3, 48)); // NOI18N
        jPanel1.add(lable2nd, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 210, 70));

        lable3rd.setFont(new java.awt.Font("Lucida Grande", 3, 48)); // NOI18N
        jPanel1.add(lable3rd, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 210, 80));

        lableyourrank.setFont(new java.awt.Font("American Typewriter", 3, 80)); // NOI18N
        lableyourrank.setForeground(new java.awt.Color(255, 255, 51));
        lableyourrank.setText("Place");
        jPanel1.add(lableyourrank, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 220, 130));

        lableyourrank1.setFont(new java.awt.Font("American Typewriter", 3, 80)); // NOI18N
        lableyourrank1.setForeground(new java.awt.Color(255, 255, 51));
        jPanel1.add(lableyourrank1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, 220, 130));

        cont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contActionPerformed(evt);
            }
        });
        jPanel1.add(cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 340, 140));
        jPanel1.add(lablebackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1140, 780));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contActionPerformed
        // TODO add your handling code here:
        dispose();
        GameSelection gs=new GameSelection();
        gs.setVisible(true);
        gs.lableuser.setText(username);
    }//GEN-LAST:event_contActionPerformed

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
            java.util.logging.Logger.getLogger(Rank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rank().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cont;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lable1st;
    public javax.swing.JLabel lable2nd;
    public javax.swing.JLabel lable3rd;
    private javax.swing.JLabel lablebackground;
    private javax.swing.JLabel lableyourrank;
    public javax.swing.JLabel lableyourrank1;
    // End of variables declaration//GEN-END:variables
}
