/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AllGames;



import Database.DBConnection;
import Database.DBFetchDataEmojiGame;
import Database.DBFetchDataMemoryGame;
import Database.DBFetchDataSmileGame;
import java.sql.*;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Levels.*;
import javax.swing.ImageIcon;

/**
 *
 * @author dinithi
 */
public class GameSelection extends javax.swing.JFrame {
    DBConnection db;
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet res;
    DBFetchDataEmojiGame data;
    DBFetchDataSmileGame data1;
    DBFetchDataMemoryGame data2;
    ResultSet Level,Level1,Level2,Coins;
    int l,slevel,coins;
    
   
    /**
     * Creates new form GameSelection
     */
    public GameSelection() {
        initComponents();
        ImageIcon ii1 = new ImageIcon("gamepictures/Play.png");
        lablebackground.setIcon(ii1);
        
        ImageIcon ii12 = new ImageIcon("gamepictures/smilebtn.png");
        smilegamebtn.setIcon(ii12);
        
        ImageIcon ii13 = new ImageIcon("gamepictures/titlebtn.png");
        memorygamebtn.setIcon(ii13);
        
        ImageIcon ii14 = new ImageIcon("gamepictures/emojibtn.png");
        emojigamebtn.setIcon(ii14);
        /*
        *Database Connection
         */
        db = new DBConnection();
        con = db.getConnection();
        /*
        *Fetch data from for each table 
        */
        data = new DBFetchDataEmojiGame();
        data1 = new DBFetchDataSmileGame();
        data2 = new DBFetchDataMemoryGame();
        l = 0;
        slevel = 0;
    }
    /**
     * Function to determine which Level JFrame Form to redirect 
     * @param slevel
     * @param username
     * @param game
     * @param coins
     */
   
    public void redirect(int slevel,String username,String game,int coins)
    {
         switch (slevel) {
                /**
                 * If Level achieved is 1
                 */
                case 1: {
                    
                    Level1unlocked l2 = new Level1unlocked();
                    l2.lbluser.setText(username);
                    l2.lblcoins.setText("" + coins);
                    l2.game=game;
                    l2.setVisible(true);
                    break;
                }
                /**
                 * If Level achieved is 2
                 */
                case 2: {
                    Level2unlocked l2 = new Level2unlocked();
                    l2.lbluser.setText(username);
                    l2.lblcoins.setText("" + coins);
                    l2.game=game;
                    l2.setVisible(true);
                    break;
                }
                /**
                 * If Level achieved is 3
                 */
                case 3: {
                    Level3unlocked l2 = new Level3unlocked();
                    l2.lbluser.setText(username);
                    l2.lblcoins.setText("" + coins);
                    l2.game=game;
                    l2.setVisible(true);
                    break;
                }
                /**
                 * If Level achieved is 4
                 */
                default: {
                    AllLevelunlocked l2 = new AllLevelunlocked();
                    l2.lbluser.setText(username);
                    l2.lblcoins.setText("" + coins);
                    l2.game=game;
                    l2.setVisible(true);
                    break;
                }
            }
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
        smilegamebtn = new javax.swing.JButton();
        emojigamebtn = new javax.swing.JButton();
        lableuser = new javax.swing.JLabel();
        memorygamebtn = new javax.swing.JButton();
        lablebackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        smilegamebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smilegamebtnActionPerformed(evt);
            }
        });
        jPanel1.add(smilegamebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 180, 60));

        emojigamebtn.setText("jButton1");
        emojigamebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emojigamebtnActionPerformed(evt);
            }
        });
        jPanel1.add(emojigamebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 490, 160, 60));

        lableuser.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lableuser.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lableuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 20, 140, 50));

        memorygamebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memorygamebtnActionPerformed(evt);
            }
        });
        jPanel1.add(memorygamebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 490, 180, 60));
        jPanel1.add(lablebackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1320, 760));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void smilegamebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smilegamebtnActionPerformed
        // TODO add your handling code here:
        
        try {
           
            
            /**
             * Dispose current JFrame Form after the button click
             */
            dispose();
            
            /**
             * Get username of logged in user 
             */
            String username = lableuser.getText();
            
            /**
             * Get level currently achieved by user from database for Smile Game
             */
            Level1 = data1.getlevel(username);
          
            if (Level1.next()) {
                slevel = Level1.getInt("levelachieved");
                JOptionPane.showMessageDialog(rootPane, "start next()");

                JOptionPane.showMessageDialog(rootPane, "level: " + slevel);
                JOptionPane.showMessageDialog(rootPane, "gone");
            }
            /**
             * Get coins currently earned by user from database for Smile Game
             */
             Coins=data1.getcoins(username);
            if (Coins.next()) {
                coins = Coins.getInt("coins");
                /**
                 * Check
                 * JOptionPane.showMessageDialog(rootPane, "coins: " + coins);
                 */
                
            }
            
             /**
             * Based on level achieved by user, redirect to the particular 
             * Level achieved JFrame Form using redirect() function
             */
             redirect(slevel, username,"SmileGame",coins);
             
             
             /**
             * Check 
             * JOptionPane.showMessageDialog(rootPane, "usernameSMILE: " + username);
             * JOptionPane.showMessageDialog(rootPane, "LEVEL1smile : " + Level1);
             */
             
        } catch (SQLException ex) {
            Logger.getLogger(GameSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_smilegamebtnActionPerformed

    private void emojigamebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emojigamebtnActionPerformed
        try {
            // TODO add your handling code here:
            
            /**
             * Dispose current JFrame Form after the button click
             */
            dispose();
            /**
             * Get username of logged in user 
             */
            String username = lableuser.getText();

             /**
             * Get level currently achieved by user from database for Emoji Game
             */
            Level = data.getLevel(username);
            
            if (Level.next()) {
                slevel = Level.getInt("levelachieved");
                /**
                 * Check
                 * JOptionPane.showMessageDialog(rootPane, "level: " + l);
                 * JOptionPane.showMessageDialog(rootPane, "gone");
                 */
                
            }
            /**
             * Get coins currently earned by user from database for Emoji Game
             */
            Coins=data.getcurrentcoinemoji(username);
            if (Coins.next()) {
                coins = Coins.getInt("coins");
                /**
                 * Check
                 * JOptionPane.showMessageDialog(rootPane, "coins: " + coins);
                 */
                
            }
            
            /**
             * Based on level achieved by user, redirect to the particular 
             * Level achieved JFrame Form using redirect() function
             */
             redirect(slevel, username,"EmojiGame",coins);
             
              /**
             * Check 
             * JOptionPane.showMessageDialog(rootPane, "usernameSMILE: " + username);
             * JOptionPane.showMessageDialog(rootPane, "LEVEL1smile : " + Level1);
             */
             
        } catch (SQLException ex) {
            Logger.getLogger(GameSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_emojigamebtnActionPerformed

    private void memorygamebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memorygamebtnActionPerformed
        // TODO add your handling code here:
        try {
            /**
             * Dispose current JFrame Form after the button click
             */
            dispose();
            
            /**
             * Get username of logged in user 
             */
            String username = lableuser.getText();
            
             /**
             * Get level currently achieved by user from database for Memory Game
             */
            Level2 = data2.getlevel(username);

            if (Level2.next()) {
                slevel = Level2.getInt("levelachieved");
                JOptionPane.showMessageDialog(rootPane, "level: " + l);
                JOptionPane.showMessageDialog(rootPane, "gone");

            }
            /**
             * Get coins currently earned by user from database for Memory Game
             */
             Coins=data2.getcoins(username);
            if (Coins.next()) {
                coins = Coins.getInt("coins");
                
                /**
                 * Check
                 * JOptionPane.showMessageDialog(rootPane, "coins: " + coins);
                 */
                
            }
            redirect(slevel, username,"MemoryGame",coins);
        } catch (SQLException ex) {
            Logger.getLogger(GameSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_memorygamebtnActionPerformed

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
            java.util.logging.Logger.getLogger(GameSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameSelection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton emojigamebtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lablebackground;
    public javax.swing.JLabel lableuser;
    private javax.swing.JButton memorygamebtn;
    private javax.swing.JButton smilegamebtn;
    // End of variables declaration//GEN-END:variables
}
