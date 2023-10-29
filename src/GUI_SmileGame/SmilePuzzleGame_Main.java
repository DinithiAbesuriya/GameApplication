/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package GUI_SmileGame;

/**
 *
 * @author dinithi
 */
import Code_SmileGame.*;
import Achievements.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import Database.DBConnection;
import Database.DBFetchDataSmileGame;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SmilePuzzleGame_Main extends javax.swing.JFrame {
   
    String player,username;
    GameEngine myGame;
    URL currentGame;
    Timer timeinMins,timeinSecs;
    int response,noOfQuestions,countofgames,levelachieved,selectedlevel;
    DBConnection db;
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet res,res1,res2,reslevelachieved,resselectedlevel;
    Integer lifecount;
    String lifeimage;
    CoinsEarnedGUI ce;
    WonGameSmile wg;
    FailedGame fg;
    GameLevel gl;
    DBFetchDataSmileGame data;
    

    

    /**
     * Creates new form SmilePuzzleGame
     */
    public SmilePuzzleGame_Main() {
        initComponents();
        ImageIcon ii = new ImageIcon("gamepictures/smilepuzzlebackground.png");
        game_background.setIcon(ii);
        ImageIcon ii1 = new ImageIcon("gamepictures/0.png");
        btn_0.setIcon(ii1);
        ImageIcon ii6 = new ImageIcon("gamepictures/1(1)BUTTON.png");
        btn_1.setIcon(ii6);
        ImageIcon ii3 = new ImageIcon("gamepictures/2button(1).png");
        btn_2.setIcon(ii3);
        ImageIcon ii4 = new ImageIcon("gamepictures/3button.png");
        btn_3.setIcon(ii4);
        ImageIcon ii7 = new ImageIcon("gamepictures/4button.png");
        btn_4.setIcon(ii7);
        ImageIcon ii8 = new ImageIcon("gamepictures/5button.png");
        btn_5.setIcon(ii8);
        ImageIcon ii5 = new ImageIcon("gamepictures/6button.png");
        btn_6.setIcon(ii5);
        ImageIcon ii2 = new ImageIcon("gamepictures/7button.png");
        btn_7.setIcon(ii2);
        ImageIcon ii9 = new ImageIcon("gamepictures/8button.png");
        btn_8.setIcon(ii9);
        ImageIcon ii10 = new ImageIcon("gamepictures/9button.png");
        btn_9.setIcon(ii10);
        ImageIcon ii11 = new ImageIcon("gamepictures/AchievemnetsImages/exitbtn.png");
        btnexit.setIcon(ii11);
        
        ImageIcon ii12 = new ImageIcon("gamepictures/4LIFE.png");
        LifeIcon.setIcon(ii12);
        ImageIcon ii13 = new ImageIcon("gamepictures/userlogo.png");
        lableuserlogo1.setIcon(ii13);
        
       
	myGame = null;
	currentGame = null;
        myGame = new GameEngine(player);
        /**
         * When game is started the icon of lable is changed to first game image
         */
        currentGame = myGame.nextGame();
	ImageIcon i2 = new ImageIcon(currentGame);
        lablegame.setIcon(i2);
        
        lifeimage=null;
        fg=new FailedGame();
        
        /**
         * Database Connection
         */
        db=new DBConnection();
        con=db.getConnection();
        
        /**
         * Life Count
         */
        lifecount=3;
        ce=new CoinsEarnedGUI();
        wg=new WonGameSmile();
        noOfQuestions=0;
        gl=new GameLevel();
        data=new DBFetchDataSmileGame();
        countofgames=0;
       

        
        
      
         /**
         * Timer ActionListener()
         *
         */
        timeinMins = new Timer(1000, new ActionListener() {//1000 is one secound
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                gametimerforMins();
            }
        });

        /**
         * Timer start
         *
         */
        timeinMins.start();


       
       
    }
    int m=30;
    int s=0;
      public void gametimerforMins() {
        m--;
        lbltimemin.setText(String.valueOf(m));
        if (m == 0) {
            /**
             * After time is up a Joption Confirm Dialog is promoted giving a Times up picture 
             */
            ImageIcon jImage = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/TIMES UP!!.png");
            JOptionPane.showMessageDialog(this, "", "", JOptionPane.INFORMATION_MESSAGE, jImage);
            response = JOptionPane.showConfirmDialog(this, "Do you want try again!!!", "Times Up", JOptionPane.YES_NO_OPTION);
            /**
             * Checking Response
             * 
             */
            if (response == JOptionPane.YES_OPTION) {
                /**
                 * Change to another Question
                 */
                Timeup();
                JOptionPane.showMessageDialog(rootPane, "Life: " + lifecount);
                /**
                 * Change Life count lable 
                 */
                Life(lifecount);
                lifecount--;
            } else if (response == JOptionPane.NO_OPTION) {
                int score = myGame.getScore();
                
                String username = lableusersmilegame1.getText();
                int currentscore = 0;
                /**
                 *When response is no a Joption  Dialog is promoted with Game over picture 
                 */
                ImageIcon jImage1 = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/GAME OVER!!.png");
                JOptionPane.showMessageDialog(this, "", "", JOptionPane.INFORMATION_MESSAGE, jImage1);
                /**
                 * Time stop
                 */
                timeinMins.stop();
                gametimerforMins();
                /**
                 * Dispose current JFrame Form
                 * Redirect to Falied Game GUI
                 */
                dispose();
                username = lableusersmilegame1.getText();
                fg.user = username;
                fg.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(rootPane, "NO");
            }

        }
    }

    public void Timeup() {

        /**
         * Change game question when time up and user wants to try again/user got the correct answer
        */
        currentGame = myGame.nextGame();
        ImageIcon ii = new ImageIcon(currentGame);
        lablegame.setIcon(ii);

        /**
         *
         * time is set back to thirty after user gets correct answer
         * 
         */
        m = 30;
        timeinMins.start();
        gametimerforMins();

    }
/**
 * Life function to check number of life left/
 * if life count is finish
 * @param c 
 */
    public void Life(int c) {
        for (int i = 3; i >= 1; i--) {
            /**
             * If user life count is not equals 0
             */
            if (c == i) {
                /**
                 *Change Life Icon picture
                 */
                lifeimage = "gamepictures/" + i + "LIFE.png";
                JOptionPane.showMessageDialog(rootPane, lifeimage);
                ImageIcon ii = new ImageIcon(lifeimage);
                //JOptionPane.showMessageDialog(rootPane, "/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/"+i+"LIFE.pnc");
                LifeIcon.setIcon(ii);
                lifecountvalue.setText(String.valueOf(i));

            }
            /**
             * If user life count is  equals 0
             */
            if (c == 0) {
                /**
                 *Change Life Icon to game over Picture
                 * /Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment
                 */
                ImageIcon jImage = new ImageIcon("gamepictures/GAME OVER!!.png");
                JOptionPane.showMessageDialog(this, "", "", JOptionPane.INFORMATION_MESSAGE, jImage);

                timeinMins.stop();
                gametimerforMins();
                dispose();
                username = lableusersmilegame1.getText();
                fg.user = username;
                fg.setVisible(true);

            }
        }
    }
/**
 * Based on level selected to play determine the number of question that user has to play
 * @return noOfQuestion
 */
    public int getlevel() {
        username = lableusersmilegame1.getText();

        JOptionPane.showMessageDialog(rootPane, "USERNAME: " + username);

        res2 = data.getselectedlevel(username);
        try {
            if (res2.next()) {
                noOfQuestions = res2.getInt("current level");
                JOptionPane.showMessageDialog(rootPane, "No of Questions:" + noOfQuestions);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SmilePuzzleGame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noOfQuestions;
    }
    public void afterbuttonclick(int solution)
    {
        /**
         * GET Solution for the question
         */
        boolean correct = myGame.checkSolution(currentGame, solution);
        int score = myGame.getScore();
        
       
        if (correct) {
            JOptionPane.showMessageDialog(rootPane, "YEAH!!!");

            int level = 0;
            level = getlevel();
            
            countofgames++;
            /**
             * If All the questions answered based on the level selected 
             */
            if (level == countofgames) {
                timeinMins.stop();
                reslevelachieved = data.getlevel(username);
                resselectedlevel = data.getselectedlevel(username);
                try {
                    if (reslevelachieved.next()) {
                        levelachieved = reslevelachieved.getInt("levelachieved");

                    }
                    if (resselectedlevel.next()) {
                        selectedlevel = resselectedlevel.getInt("current level");

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(SmilePuzzleGame_Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (levelachieved == 4) {
                    data.updatelevelachieved(username, 4);
                } else {
                    if (levelachieved == selectedlevel) {
                        data.updatelevelachieved(username, levelachieved + 1);
                    }

                }
                timeinMins.stop();;
                gametimerforMins();
                dispose();
                WonGameSmile wg = new WonGameSmile();
                wg.user = username;
                wg.lblfinalscore.setText("" + score);
                wg.setVisible(true);
                
            } 
            /**
             * If more questions to do for selected level
             * change to the new question
             */
            else {
                
                currentGame = myGame.nextGame();
                ImageIcon ii = new ImageIcon(currentGame);
                lablegame.setIcon(ii);
                lblscore.setText("" + score);
                /**
                 *
                 * time is set back to thirty after user gets correct answer
                 */
                m = 30;
                timeinMins.start();
                gametimerforMins();
            }

        } else {
            System.out.println("Not Correct");
            JOptionPane.showMessageDialog(rootPane, "NOOOO!");
            //JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
        }
        /**Check
         * JOptionPane.showMessageDialog(rootPane, "Answer:" + correct);
         * JOptionPane.showMessageDialog(rootPane, "LEVEL: " + level);
         * JOptionPane.showMessageDialog(rootPane, "LEVEL ACHIEVED: " + levelachieved);
         * JOptionPane.showMessageDialog(rootPane, "Selected level: " + selectedlevel);
         */
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
        btn_1 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_9 = new javax.swing.JButton();
        btn_8 = new javax.swing.JButton();
        btn_7 = new javax.swing.JButton();
        lablegame = new javax.swing.JLabel();
        lblscore = new javax.swing.JLabel();
        lbltimemin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbltime0 = new javax.swing.JLabel();
        lableusersmilegame1 = new javax.swing.JLabel();
        btn_0 = new javax.swing.JButton();
        lableuserlogo1 = new javax.swing.JLabel();
        LifeIcon = new javax.swing.JLabel();
        lifecountvalue = new javax.swing.JLabel();
        btnexit = new javax.swing.JButton();
        game_background = new javax.swing.JLabel();
        lableuserlogo = new javax.swing.JLabel();
        lablesmilegame = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 560, 90, 80));

        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 560, 80, 80));

        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 560, 80, 70));

        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, 80, 70));

        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 560, 80, 70));

        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 560, 80, 70));

        btn_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_9ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 640, 80, 80));

        btn_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_8ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 650, 80, 80));

        btn_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_7ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 650, 80, 70));
        jPanel1.add(lablegame, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 690, 380));

        lblscore.setFont(new java.awt.Font("Luminari", 1, 48)); // NOI18N
        lblscore.setText("0");
        jPanel1.add(lblscore, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 100, 50));

        lbltimemin.setFont(new java.awt.Font("Luminari", 1, 48)); // NOI18N
        jPanel1.add(lbltimemin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 70, 70));

        jLabel2.setFont(new java.awt.Font("Luminari", 1, 48)); // NOI18N
        jLabel2.setText(":");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 20, 60));

        lbltime0.setFont(new java.awt.Font("Luminari", 1, 48)); // NOI18N
        lbltime0.setText("00");
        jPanel1.add(lbltime0, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 70, 70));

        lableusersmilegame1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jPanel1.add(lableusersmilegame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 170, 30));

        btn_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_0ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 560, 80, 80));
        jPanel1.add(lableuserlogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 60, 40));
        jPanel1.add(LifeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 70));

        lifecountvalue.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        lifecountvalue.setForeground(new java.awt.Color(204, 51, 0));
        lifecountvalue.setText("4");
        jPanel1.add(lifecountvalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 50));

        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        jPanel1.add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 630, 220, 90));
        jPanel1.add(game_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1090, 810));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 740));

        lableuserlogo.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/userlogo.png")); // NOI18N
        getContentPane().add(lableuserlogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 60, 50));
        getContentPane().add(lablesmilegame, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 140, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
        // TODO add your handling code here:
        int solution = 1;
        afterbuttonclick(solution);
    }//GEN-LAST:event_btn_1ActionPerformed

    private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
        // TODO add your handling code here:
        int solution = 2;
        afterbuttonclick(solution);
    }//GEN-LAST:event_btn_2ActionPerformed

    private void btn_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3ActionPerformed

        // TODO add your handling code here:
        int solution = 3;
        afterbuttonclick(solution);
    }//GEN-LAST:event_btn_3ActionPerformed

    private void btn_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4ActionPerformed

        // TODO add your handling code here:
        int solution = 4;
        afterbuttonclick(solution);
    }//GEN-LAST:event_btn_4ActionPerformed

    private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
        // TODO add your handling code here:
        int solution = 5;
        afterbuttonclick(solution);
    }//GEN-LAST:event_btn_5ActionPerformed

    private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
        // TODO add your handling code here:
        int solution = 6;
        afterbuttonclick(solution);
    }//GEN-LAST:event_btn_6ActionPerformed

    private void btn_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_7ActionPerformed
        // TODO add your handling code here:
        int solution = 7;
       afterbuttonclick(solution);
    }//GEN-LAST:event_btn_7ActionPerformed

    private void btn_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_8ActionPerformed
        // TODO add your handling code here:
        int solution = 8;
        afterbuttonclick(solution);
    }//GEN-LAST:event_btn_8ActionPerformed

    private void btn_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_9ActionPerformed
        // TODO add your handling code here:
        int solution = 9;
        afterbuttonclick(solution);
    }//GEN-LAST:event_btn_9ActionPerformed

    private void btn_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_0ActionPerformed
        // TODO add your handling code here:
        int solution = 0;
       afterbuttonclick(solution);
    }//GEN-LAST:event_btn_0ActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed

        
        
        int score1 = myGame.getScore();
        String username1 = lableusersmilegame1.getText();
        int currentscore1 = 0;
       
        int level = 0;
        level = getlevel();
        JOptionPane.showMessageDialog(rootPane, "LEVEL: " + level);
        countofgames++;

        timeinMins.stop();
        dispose();
        fg.user = username1;
        fg.level = level;
        fg.setVisible(true);

       

    }//GEN-LAST:event_btnexitActionPerformed
    public void iniComponents(String player) {

    }

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
            java.util.logging.Logger.getLogger(SmilePuzzleGame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SmilePuzzleGame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SmilePuzzleGame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SmilePuzzleGame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new SmilePuzzleGame_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LifeIcon;
    private javax.swing.JButton btn_0;
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton btnexit;
    private javax.swing.JLabel game_background;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lablegame;
    public javax.swing.JLabel lablesmilegame;
    private javax.swing.JLabel lableuserlogo;
    private javax.swing.JLabel lableuserlogo1;
    public javax.swing.JLabel lableusersmilegame1;
    private javax.swing.JLabel lblscore;
    private javax.swing.JLabel lbltime0;
    private javax.swing.JLabel lbltimemin;
    private javax.swing.JLabel lifecountvalue;
    // End of variables declaration//GEN-END:variables
}
