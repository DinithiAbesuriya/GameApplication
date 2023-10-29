/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Achievements;

import Database.DBConnection;
import Database.DBFetchDataEmojiGame;
import Database.DBFetchDataMemoryGame;
import Database.DBFetchDataSmileGame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author dinithi
 */

public class CoinsEarnedGUI extends javax.swing.JFrame {
Rank r;
public String gameplayed;
DBConnection db;
Connection con;
PreparedStatement preparedStatement;
ResultSet res,res1;
DBFetchDataEmojiGame data;
DBFetchDataSmileGame data1;
DBFetchDataMemoryGame data2;
AllocatingRank ar;
int max_score;
public String userPlace1,username;


    /** Creates new form CoinsEarned */
    public CoinsEarnedGUI() {
        initComponents();
        ImageIcon ii1 = new ImageIcon("gamepictures/AchievemnetsImages/coinsboard.png");
        lablebackground.setIcon(ii1);
        
        ImageIcon ii12 = new ImageIcon("gamepictures/AchievemnetsImages/continuebtn.png");
        contiunue.setIcon(ii12);
        r=new Rank();
        db=new DBConnection();
        con=db.getConnection();
        data=new DBFetchDataEmojiGame();
        data1=new DBFetchDataSmileGame();
        data2=new DBFetchDataMemoryGame();
        ar=new AllocatingRank();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        contiunue = new javax.swing.JButton();
        lablecoins = new javax.swing.JLabel();
        lablebackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1156, 0, -1, 103));

        contiunue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contiunueActionPerformed(evt);
            }
        });
        getContentPane().add(contiunue, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 360, 210, 90));

        lablecoins.setFont(new java.awt.Font("Lucida Grande", 3, 55)); // NOI18N
        getContentPane().add(lablecoins, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, 200, 80));
        getContentPane().add(lablebackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contiunueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contiunueActionPerformed
    try {
        // TODO add your handling code here:
        dispose();
        JOptionPane.showMessageDialog(rootPane, "Game palyed: "+gameplayed);
        switch (gameplayed) {
            case "SmileGame":
                res=data1.getmax();
                break;
            case "EmojiGame":
                res=data.getmax();
                break;
            case "MemoryGame":
                res=data2.getmax();
                break;
            default:
                break;
        }
       // res=data1.getmax();
        if(res.next())
        {
            max_score=res.getInt("Max_Score");
            userPlace1=res.getString("username");
            r.lable1st.setText(userPlace1);
            
        }
        //ar.getres(gameplayed);
        String user2=ar.user2rd(gameplayed);
        JOptionPane.showMessageDialog(rootPane, "user 2nd: "+user2);
        r.lable2nd.setText(user2);
        String user3=ar.user3rd(gameplayed);
        r.lable3rd.setText(user3);
        JOptionPane.showMessageDialog(rootPane, "user 3nd: "+user3);
        //max_score=ar.getRank(gameplayed);
        JOptionPane.showMessageDialog(rootPane, "MAX SCORE: "+max_score);
        int currentuserplace=ar.currentuserplace(username);
        JOptionPane.showMessageDialog(rootPane, "cuurent place : "+currentuserplace);
        
        r.lableyourrank1.setText(""+currentuserplace);
        r.username=username;
        r.setVisible(true);
        
    } catch (SQLException ex) {
        Logger.getLogger(CoinsEarnedGUI.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_contiunueActionPerformed

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
            java.util.logging.Logger.getLogger(CoinsEarnedGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoinsEarnedGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoinsEarnedGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoinsEarnedGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoinsEarnedGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton contiunue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lablebackground;
    public javax.swing.JLabel lablecoins;
    // End of variables declaration//GEN-END:variables

}
