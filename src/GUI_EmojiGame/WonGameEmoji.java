/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_EmojiGame;

/**
 *
 * @author dinithi
 */
import GUI_EmojiGame.*;
import Achievements.CoinsEarnedGUI;
import Code_EmojiGame.CoinsEarnedEmoji;
import Code_SmileGame.CoinsEarned;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Database.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WonGameEmoji extends javax.swing.JFrame {
CoinsEarnedGUI ce;
CoinsEarnedEmoji coins;
int coins_value;
String user;
int currentscore,updatedscore,earnedscore,currentcoins,updatedcoins,earnedcoins;
DBConnection db;
Connection con;
PreparedStatement preparedStatement;
ResultSet res,res1;
DBFetchDataEmojiGame data;


    /**
     * Creates new form WonGame
     */
    WonGameEmoji() {
        initComponents();
        ce=new CoinsEarnedGUI();
        coins=new CoinsEarnedEmoji();
        db=new DBConnection();
        con=db.getConnection();
        data=new DBFetchDataEmojiGame();
        
        
       
        
       
        
        
        
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
        lblfinalscore = new javax.swing.JLabel();
        continuebtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblfinalscore.setFont(new java.awt.Font("Damascus", 1, 70)); // NOI18N
        getContentPane().add(lblfinalscore, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 520, 200, 100));

        continuebtn.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/AchievemnetsImages/wonbtn.png")); // NOI18N
        continuebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuebtnActionPerformed(evt);
            }
        });
        getContentPane().add(continuebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 240, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/score board(winning).png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1250, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void continuebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuebtnActionPerformed
   
    try {
        // TODO add your handling code here:
        earnedscore=Integer.parseInt(lblfinalscore.getText());
        JOptionPane.showMessageDialog(rootPane, "score earned"+earnedscore);
        JOptionPane.showMessageDialog(rootPane, "User"+user);
        coins_value=coins.getcoinsearned(user);
        JOptionPane.showMessageDialog(rootPane, "Coins earned: "+coins_value);
        res=data.getcurrentscoreemoji(user);
        res1=data.getcurrentcoinemoji(user);
        JOptionPane.showMessageDialog(rootPane, "res: "+res);

        if(res.next())
        {
            currentscore=res.getInt("score");
            JOptionPane.showMessageDialog(rootPane, "current score: "+currentscore);
            updatedscore=currentscore+earnedscore;
            JOptionPane.showMessageDialog(rootPane, "updated score: "+updatedscore);
            data.updatecurrentscore(user, updatedscore);
            
            
        }
        if(res1.next())
        {
            currentcoins=res1.getInt("coins");
            JOptionPane.showMessageDialog(rootPane, "current coins: "+currentcoins);
            updatedcoins=currentcoins+coins_value;
            JOptionPane.showMessageDialog(rootPane, "updated score: "+updatedcoins);
            data.updatecurrentcoins(user, updatedcoins);
            
            
            
        }
        
       
        dispose();
        
        ce.setVisible(true);
        ce.lablecoins.setText(""+coins_value);
        ce.gameplayed="EmojiGame";
        ce.username=user;
    } catch (SQLException ex) {
        Logger.getLogger(WonGameEmoji.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }//GEN-LAST:event_continuebtnActionPerformed

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
            java.util.logging.Logger.getLogger(WonGameEmoji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WonGameEmoji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WonGameEmoji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WonGameEmoji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //</editor-fold>
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
           
       public void run() {
               
               new WonGameEmoji().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblfinalscore;
    // End of variables declaration//GEN-END:variables
}
