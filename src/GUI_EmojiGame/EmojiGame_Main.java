/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_EmojiGame;

/**
 *
 * @author dinithi
 */
import Code_EmojiGame.Emoji;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Code_EmojiGame.EmojiImageRandom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import Database.DBFetchDataEmojiGame;
import java.sql.ResultSet;
import Code_EmojiGame.EmojiEngine;
import GUI_SmileGame.SmilePuzzleGametest3;


public class EmojiGame_Main extends javax.swing.JFrame {

    Emoji EmojiList[];
    int noOfQuestions, index;
    int randomfirst;
    int nextrandom;
    EmojiImageRandom e;
    String image, lifeimage;
    int firstcount, currentnum, level, randomimage, levelachieved, selectedlevel;
    int countofgames, score, scorenow, currentscore;
    Timer timeinMins;
    ResultSet res, levelResultSet, scoreResultSet, currentResultSet, res2, reslevelachieved, resselectedlevel;
    String username;
    String user1;
    EmojiEngine myGame;
    String currentGame, player;
    FailedGameEmoji fg;

    // String user1String;;
    //  String user1String;
    int response, lifecount, currentlevelselected;
    DBFetchDataEmojiGame data;

    /**
     * Creates new form EmojiGame
     */
    public EmojiGame_Main() {

        initComponents();

        ImageIcon ii1 = new ImageIcon("gamepictures/EmojiApiImages/BackgroundImage/background.png");
        lablebackground.setIcon(ii1);
        
        ImageIcon ii12 = new ImageIcon("gamepictures/EmojiApiImages/LifeImages/4life.png");
        LifeIcon.setIcon(ii12);
       
        ImageIcon ii13 = new ImageIcon("gamepictures/EmojiApiImages/Button/btnsubmit.png");
        jButton1.setIcon(ii13);
        
        
        ImageIcon ii15 = new ImageIcon("gamepictures/EmojiApiImages/Button/userlogo.png");
        lableuserlogo1.setIcon(ii15);
        ImageIcon ii14 = new ImageIcon("gamepictures/exitemoji.png");
        exit_btn.setIcon(ii14);
       
        myGame = null;
        myGame = new EmojiEngine(player);
        currentGame = null;
        /**
         * When game is started the icon of lable is changed to first game image
         */
        currentGame = myGame.nextGame();
        System.out.println("CURRENT GAME = " + currentGame);
        ImageIcon ii = new ImageIcon(currentGame);
        lblicon.setIcon(ii);

        data = new DBFetchDataEmojiGame();

        lifecount = 3;
        image = "";

        firstcount = 0;
        countofgames = 0;
        score = 0;
        currentscore = 0;
        level = 0;
        fg = new FailedGameEmoji();

        
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

    public void EmojiImage(int num) {

        image = EmojiList[num].getImage();
        ImageIcon ii = new ImageIcon(image);
        lblicon.setIcon(ii);

    }

    int m = 30;
    int s = 0;

    public void gametimerforMins() {
        m--;
        lbltimemin.setText(String.valueOf(m));
        if (m == 0) {
            /**
             * After time is up a Joption Confirm Dialog is promoted giving a Times up picture 
             */
            ImageIcon jImage = new ImageIcon("gamepictures/TIMES UP!!.png");
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
                /**
                 * Check
                 * JOptionPane.showMessageDialog(rootPane, "Life: " + lifecount);
                 */
                
                /**
                 * Change Life count lable 
                 */
                Life(lifecount);
                lifecount--;
            } else if (response == JOptionPane.NO_OPTION) {
                int score = myGame.getScore();
                String username = lableuseremojigame1.getText();
                int currentscore = 0;
                /**
                 *When response is no a Joption  Dialog is promoted with Game over picture 
                 */
                ImageIcon jImage1 = new ImageIcon("gamepictures/GAME OVER!!.png");
                JOptionPane.showMessageDialog(this, "", "", JOptionPane.INFORMATION_MESSAGE, jImage1);
                /**
                 * Time stop
                 */
                timeinMins.stop();
                /**
                 * Dispose current JFrame Form
                 * Redirect to Falied Game GUI
                 */
                gametimerforMins();
                dispose();
                username = lableuseremojigame1.getText();
                fg.user = username;
                fg.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(rootPane, "NO");
            }

        }
    }

    String user1String = username;

    public int levelrandom() {

        try {

            JOptionPane.showMessageDialog(rootPane, "user1: " + user1String);

            currentResultSet = data.getcurrentlevel(user1String);
            JOptionPane.showMessageDialog(rootPane, "current: " + currentResultSet);
            JOptionPane.showMessageDialog(rootPane, "Boolean: " + currentResultSet.next());

            if (currentResultSet.next()) {
                JOptionPane.showMessageDialog(rootPane, "next current: ");
                currentlevelselected = currentResultSet.getInt("current level");
                JOptionPane.showMessageDialog(rootPane, "currentlevel: " + currentlevelselected);
                switch (currentlevelselected) {
                    case 1:
                        randomimage = e.RandomImageLevel1();
                        break;
                    case 2:
                        randomimage = e.RandomImageLevel2();
                        JOptionPane.showMessageDialog(rootPane, "random image: " + randomimage);
                        break;
                    case 3:
                        randomimage = e.RandomImageLevel3();
                        break;
                    default:
                        randomimage = e.RandomImageLevel4();
                        break;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmojiGame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return randomimage;
    }

    public void Timeup() {
        /**
         * Change game question when time up and user wants to try again/user got the correct answer
        */
        currentGame = myGame.nextGame();
        ImageIcon ii = new ImageIcon(currentGame);
        lblicon.setIcon(ii);

        /**
         *
         * time is set back to thirty after user gets correct answer
         */
        m = 80;
        timeinMins.start();
        gametimerforMins();

    }

    public void Life(int c) {
        for (int i = 3; i >= 1; i--) {
            /**
             * If user life count is not equals 0
             */
            if (c == i) {
                /**
                 *Change Life Icon picture
                 */
                lifeimage = "/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/EmojiApiImages/LifeImages/" + i + "life.png";
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
                 */
                ImageIcon jImage = new ImageIcon("gamepictures/GAME OVER!!.png");

                JOptionPane.showMessageDialog(this, "", "", JOptionPane.INFORMATION_MESSAGE, jImage);
                dispose();
                timeinMins.stop();
                gametimerforMins();
                username = lableuseremojigame1.getText();
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
        username = lableuseremojigame1.getText();

        JOptionPane.showMessageDialog(rootPane, "USERNAME: " + username);

        res2 = data.getselectedlevel(username);
        try {
            if (res2.next()) {
                noOfQuestions = res2.getInt("current level");
                JOptionPane.showMessageDialog(rootPane, "No of Questions:" + noOfQuestions);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SmilePuzzleGametest3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noOfQuestions;
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
        lblicon = new javax.swing.JLabel();
        txtanswer = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblscoreemoji = new javax.swing.JLabel();
        LifeIcon = new javax.swing.JLabel();
        lifecountvalue = new javax.swing.JLabel();
        lbltimemin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lableuserlogo1 = new javax.swing.JLabel();
        lableuseremojigame1 = new javax.swing.JLabel();
        exit_btn = new javax.swing.JButton();
        lablebackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(lblicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 690, 360));
        jPanel1.add(txtanswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 610, 290, 80));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 690, 210, 60));

        lblscoreemoji.setFont(new java.awt.Font("Malayalam MN", 1, 24)); // NOI18N
        lblscoreemoji.setText("0");
        jPanel1.add(lblscoreemoji, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 110, 50));
        jPanel1.add(LifeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, 70));

        lifecountvalue.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        lifecountvalue.setForeground(new java.awt.Color(204, 51, 0));
        lifecountvalue.setText("4");
        jPanel1.add(lifecountvalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 50, 60));

        lbltimemin.setFont(new java.awt.Font("Malayalam Sangam MN", 1, 48)); // NOI18N
        jPanel1.add(lbltimemin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 60, 60));

        jLabel3.setFont(new java.awt.Font("Malayalam Sangam MN", 1, 48)); // NOI18N
        jLabel3.setText("00 : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, 60));
        jPanel1.add(lableuserlogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 60, 40));

        lableuseremojigame1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jPanel1.add(lableuseremojigame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 170, 30));
        jPanel1.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 610, 220, 100));
        jPanel1.add(lablebackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -20, 1170, 790));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String solution = txtanswer.getText();
         /**
         * GET Solution for the question
         */
        boolean correct = myGame.checkSolution(currentGame, solution);
        int score = myGame.getScore();

        JOptionPane.showMessageDialog(rootPane, "Answer:" + correct);
        System.out.println("Correct " + correct);
        String answer = txtanswer.getText();
        if (correct) {
            JOptionPane.showMessageDialog(rootPane, "YEAH!");
            int level = 0;
            level = getlevel();
            JOptionPane.showMessageDialog(rootPane, "LEVEL: " + level);
            countofgames++;
            /**
             * If All the questions answered based on the level selected 
             */
            
            if (level == countofgames) {

                timeinMins.stop();
                reslevelachieved = data.getLevel(username);
                resselectedlevel = data.getselectedlevel(username);
                try {
                    if (reslevelachieved.next()) {
                        levelachieved = reslevelachieved.getInt("levelachieved");
                        JOptionPane.showMessageDialog(rootPane, "LEVEL ACHIEVED: " + levelachieved);
                    }
                    if (resselectedlevel.next()) {
                        selectedlevel = resselectedlevel.getInt("current level");
                        JOptionPane.showMessageDialog(rootPane, "Selected level: " + selectedlevel);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SmilePuzzleGametest3.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (levelachieved == 4) {
                    data.updatelevelachieved(username, 4);
                } else {

                    if (levelachieved == selectedlevel) {
                        data.updatelevelachieved(username, levelachieved + 1);
                    }

                }
                dispose();
                WonGameEmoji wg = new WonGameEmoji();
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
                lblicon.setIcon(ii);
                lblscoreemoji.setText("" + score);
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

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EmojiGame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmojiGame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmojiGame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmojiGame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new EmojiGame_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel LifeIcon;
    private javax.swing.JButton exit_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lablebackground;
    public javax.swing.JLabel lableuseremojigame1;
    private javax.swing.JLabel lableuserlogo1;
    public javax.swing.JLabel lblicon;
    private javax.swing.JLabel lblscoreemoji;
    public javax.swing.JLabel lbltimemin;
    public javax.swing.JLabel lifecountvalue;
    private javax.swing.JTextField txtanswer;
    // End of variables declaration//GEN-END:variables
}
