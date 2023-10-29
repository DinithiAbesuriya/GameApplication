/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_MemoryGame;

import GUI_SmileGame.*;
import AllGames.GameSelection;
import javax.swing.JOptionPane;
import Database.*;
import Levels.AllLevelunlocked;
import Levels.Level1unlocked;
import Levels.Level2unlocked;
import Levels.Level3unlocked;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author dinithi
 */
public class FailedGame extends javax.swing.JFrame {
    public String user;
    int level;
    DBConnection db;
    Connection con;
    ResultSet Level,Coins;
    DBFetchDataMemoryGame data;
    int coins;

    /**
     * Creates new form FailedGame
     */
    public FailedGame() {
        initComponents();
         ImageIcon ii = new ImageIcon("gamepictures/failed.png");
        lablebackground.setIcon(ii);
       
        ImageIcon ii1 = new ImageIcon("gamepictures/gameoption.png");
        gameoption.setIcon(ii1);
        ImageIcon ii2 = new ImageIcon("gamepictures/retry.png");
        retry_btn.setIcon(ii2);
        db=new DBConnection();
        con=db.getConnection();
        /*
        *Fetch data from MemoryGame Table
        */
        data=new DBFetchDataMemoryGame();
        coins=0;
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
        retry_btn = new javax.swing.JButton();
        gameoption = new javax.swing.JButton();
        lablebackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        retry_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retry_btnActionPerformed(evt);
            }
        });
        jPanel1.add(retry_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 550, 130, 140));

        gameoption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameoptionActionPerformed(evt);
            }
        });
        jPanel1.add(gameoption, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 560, 140, 120));
        jPanel1.add(lablebackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 1370, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retry_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retry_btnActionPerformed
        try {
            // TODO add your handling code here:
            
            Level=data.getlevel(user);
            JOptionPane.showMessageDialog(rootPane, "LEVEL : "+Level);
            
            JOptionPane.showMessageDialog(rootPane, "user : "+user);
            //import to put.next() if not result won't work
            if(Level.next()){
                level=Level.getInt("levelachieved");
                JOptionPane.showMessageDialog(rootPane, "level: "+level);
                JOptionPane.showMessageDialog(rootPane, "gone");
            }
            Coins=data.getcoins(user);
            if (Coins.next()) {
                coins = Coins.getInt("coins");
                JOptionPane.showMessageDialog(rootPane, "coins: " + coins);
                /**
                 * Check
                 * JOptionPane.showMessageDialog(rootPane, "coins: " + coins);
                 */
                
            }
            dispose();
            String game="MemoryGame";
             switch (level) {
                /**
                 * If Level achieved is 1
                 */
                case 1: {
                    
                    Level1unlocked l2 = new Level1unlocked();
                    l2.lbluser.setText(user);
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
                    l2.lbluser.setText(user);
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
                    l2.lbluser.setText(user);
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
                    l2.lbluser.setText(user);
                    l2.lblcoins.setText("" + coins);
                    l2.game=game;
                    l2.setVisible(true);
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FailedGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_retry_btnActionPerformed

    private void gameoptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameoptionActionPerformed
        // TODO add your handling code here:
        dispose();
        GameSelection gs=new GameSelection();
        gs.lableuser.setText(user);
        gs.setVisible(true);
        
    }//GEN-LAST:event_gameoptionActionPerformed

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
            java.util.logging.Logger.getLogger(FailedGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FailedGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FailedGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FailedGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FailedGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gameoption;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lablebackground;
    private javax.swing.JButton retry_btn;
    // End of variables declaration//GEN-END:variables
}
