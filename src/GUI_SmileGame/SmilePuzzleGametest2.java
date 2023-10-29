/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package GUI_SmileGame;

/**
 *
 * @author dinithi
 */
import Code_SmileGame.GameEngine;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import Database.DBConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Database.DBFetchDataSmileGame;
public class SmilePuzzleGametest2 extends javax.swing.JFrame {
   
    String player;
    GameEngine myGame;
    URL currentGame;
    Timer timeinMins,timeinSecs;
    int response;
    DBConnection db;
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet res;
    Integer lifecount;
    String lifeimage;
    DBFetchDataSmileGame fetchdata;

    

    /**
     * Creates new form SmilePuzzleGame
     */
    public SmilePuzzleGametest2() {
        initComponents();
       
	myGame = null;
	currentGame = null;
        myGame = new GameEngine(player);
        //When game is started the icon of lable is changed to first level image
        currentGame = myGame.nextGame();
	ImageIcon ii = new ImageIcon(currentGame);
        lablegame.setIcon(ii);
        
        lifeimage=null;
        
        db=new DBConnection();
        con=db.getConnection();
        fetchdata=new DBFetchDataSmileGame();
        //JOptionPane.showMessageDialog(rootPane, "con: "+con);
        lifecount=3;
        
        
      
       
        /**
         * Timer ActionListener()
         * 
         */
        
        timeinMins=new Timer(1000,new ActionListener() {//1000 is one secound
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
    int m=0;
    int s=0;
        public void gametimerforMins()
        {
            m++;
            lbltimemin.setText(String.valueOf(m));
            if(m==30)
            {
                ImageIcon jImage = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/TIMES UP!!.png");
                //Object[] options={"Try Again!!!","Go to another Game"};
                //JOptionPane.showMessageDialog(null,"","Times Up",JOptionPane.INFORMATION_MESSAGE,jImage);
                JOptionPane.showMessageDialog(this,"","",JOptionPane.INFORMATION_MESSAGE,jImage);
                response= JOptionPane.showConfirmDialog(this,"Do you want try again!!!","Times Up",JOptionPane.YES_NO_OPTION);
                 if(response==JOptionPane.YES_OPTION){
                    Timeup();
                    
                    JOptionPane.showMessageDialog(rootPane, "Life: "+lifecount);
                     Life(lifecount);
                     lifecount--;
                }
                 else if(response==JOptionPane.NO_OPTION){
                     int score = myGame.getScore(); 
                     String username=lableusersmilegame1.getText();
                     int currentscore=0;
                    try {
                        
                           ResultSet res=fetchdata.getcurrentscoresmile(username);
                           if(res.next())
                           {
                            currentscore=res.getInt("smilegamescore");
                            JOptionPane.showMessageDialog(rootPane, "res:"+currentscore);
                           //Login l=new Login();
                           //l.setVisible(false);
                           s=score+currentscore;
                           preparedStatement=con.prepareStatement("UPDATE `scoreBoard` SET `smilegamescore`=? WHERE `username`=?");
                           preparedStatement.setInt(1,s);
                           preparedStatement.setString(2, username);
                            preparedStatement.executeUpdate();
                            WonGameSmile wg=new WonGameSmile();
                            wg.setVisible(true);
                           }
                           else{
                               preparedStatement=con.prepareStatement("INSERT INTO `scoreBoard`(`smilegamescore`, `username`) VALUES (?,?)");
                                preparedStatement.setInt(1, score);
                                 JOptionPane.showMessageDialog(rootPane, "Current score"+score);
                                preparedStatement.setString(2, username);
                                preparedStatement.executeUpdate();
                                WonGameSmile wg=new WonGameSmile();
                                wg.setVisible(true);
                           }
                        
                    } catch (SQLException ex) {
                      //  Logger.geSmilePuzzleGametest2zleGame2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                 }
                 else{
                     JOptionPane.showMessageDialog(rootPane, "NO");
                 }
                
            }
        }
        
        
        public void Timeup()
        {
           
                currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			lablegame.setIcon(ii);
                       
                        
                        /**
                         * 
                         * time is set back to zero after user gets correct answer
                         */
                        m=0;
                        timeinMins.start();
                        gametimerforMins();
                        
        }
        public void Life(int c)
        {
            for(int i=3;i>=1;i--)
            {
            if(c==i)
            {
               lifeimage="/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/"+i+"LIFE.png";
               JOptionPane.showMessageDialog(rootPane,lifeimage);
               ImageIcon ii = new ImageIcon(lifeimage);
               //JOptionPane.showMessageDialog(rootPane, "/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/"+i+"LIFE.pnc");
               LifeIcon.setIcon(ii);
               lifecountvalue.setText(String.valueOf(i));
               
            }
            if(c==0)
            {
              ImageIcon jImage = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/GAME OVER!!.png");
             
                JOptionPane.showMessageDialog(this,"","",JOptionPane.INFORMATION_MESSAGE,jImage);
                dispose();
                timeinMins.stop();
                gametimerforMins();
                FailedGame fg=new FailedGame();
                fg.setVisible(true);
                
            }
            }
        }
        
        public void getcurrentscore()
        {
            
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        lablegame = new javax.swing.JLabel();
        lblscore = new javax.swing.JLabel();
        lbltimemin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbltime0 = new javax.swing.JLabel();
        lableusersmilegame1 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        lableuserlogo1 = new javax.swing.JLabel();
        LifeIcon = new javax.swing.JLabel();
        lifecountvalue = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lableuserlogo = new javax.swing.JLabel();
        lablesmilegame = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/1(1)BUTTON.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 560, 90, 80));

        jButton2.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/2button(1).png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 560, 80, 80));

        jButton3.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/3button.png")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 560, 80, 70));

        jButton4.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/4button.png")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, 80, 70));

        jButton5.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/5button.png")); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 560, 80, 70));

        jButton6.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/6button.png")); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 560, 80, 70));

        jButton9.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/9button.png")); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 640, 80, 80));

        jButton8.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/8button.png")); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 650, 80, 80));

        jButton7.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/7button.png")); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 650, 80, 70));
        jPanel1.add(lablegame, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 690, 380));

        lblscore.setFont(new java.awt.Font("Luminari", 1, 36)); // NOI18N
        lblscore.setForeground(new java.awt.Color(51, 51, 255));
        jPanel1.add(lblscore, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 100, 50));

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

        jButton10.setText("jButton10");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 570, 130, 70));

        lableuserlogo1.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/userlogo.png")); // NOI18N
        jPanel1.add(lableuserlogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 60, 40));

        LifeIcon.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/4LIFE.png")); // NOI18N
        jPanel1.add(LifeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 70));

        lifecountvalue.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        lifecountvalue.setForeground(new java.awt.Color(204, 51, 0));
        lifecountvalue.setText("4");
        jPanel1.add(lifecountvalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 50));

        jButton11.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/exit.png")); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 620, 190, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/smilepuzzlebackground.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1090, 810));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 740));

        lableuserlogo.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/userlogo.png")); // NOI18N
        getContentPane().add(lableuserlogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 60, 50));
        getContentPane().add(lablesmilegame, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 140, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int solution = 1;
                //check solution 
		boolean correct = myGame.checkSolution(currentGame, solution);
                 int score = myGame.getScore(); 
                JOptionPane.showMessageDialog(rootPane, "Answer:"+correct);
                if (correct) {
			JOptionPane.showMessageDialog(rootPane,"YEAH!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			lablegame.setIcon(ii);
                        lblscore.setText(""+score);
                        
                        /**
                         * 
                         * time is set back to zero after user gets correct answer
                         */
                        m=0;
                        timeinMins.start();
                        gametimerforMins();
                        
                        
                        
			
		} else { 
			System.out.println("Not Correct"); 
                        JOptionPane.showMessageDialog(rootPane,"NOOOO!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
		}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int solution = 2;
                //check solution 
		boolean correct = myGame.checkSolution(currentGame, solution);
                 int score = myGame.getScore(); 
                JOptionPane.showMessageDialog(rootPane, "Answer:"+correct);
                if (correct) {
			JOptionPane.showMessageDialog(rootPane,"YEAH!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			lablegame.setIcon(ii);
                        lblscore.setText(""+score);
                        m=0;
                         timeinMins.start();
                        gametimerforMins();
                        
			
		} else { 
			System.out.println("Not Correct"); 
                        JOptionPane.showMessageDialog(rootPane,"NOOOO!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
		}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // TODO add your handling code here:
        int solution = 3;
                //check solution 
		boolean correct = myGame.checkSolution(currentGame, solution);
                 int score = myGame.getScore(); 
                JOptionPane.showMessageDialog(rootPane, "Answer:"+correct);
                if (correct) {
			JOptionPane.showMessageDialog(rootPane,"YEAH!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			lablegame.setIcon(ii);
                        lblscore.setText(""+score);
                        m=0;
                         timeinMins.start();
                        gametimerforMins();
			
		} else { 
			System.out.println("Not Correct"); 
                        JOptionPane.showMessageDialog(rootPane,"NOOOO!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
		}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        // TODO add your handling code here:
        int solution = 4;
                //check solution 
		boolean correct = myGame.checkSolution(currentGame, solution);
                 int score = myGame.getScore(); 
                JOptionPane.showMessageDialog(rootPane, "Answer:"+correct);
                if (correct) {
			JOptionPane.showMessageDialog(rootPane,"YEAH!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			lablegame.setIcon(ii);
                        lblscore.setText(""+score);
                        m=0;
                         timeinMins.start();
                        gametimerforMins();
                        
			
		} else { 
			System.out.println("Not Correct"); 
                        JOptionPane.showMessageDialog(rootPane,"NOOOO!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
		}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int solution = 5;
                //check solution 
		boolean correct = myGame.checkSolution(currentGame, solution);
                 int score = myGame.getScore(); 
                JOptionPane.showMessageDialog(rootPane, "Answer:"+correct);
                if (correct) {
			JOptionPane.showMessageDialog(rootPane,"YEAH!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			lablegame.setIcon(ii);
                        lblscore.setText(""+score);
                        m=0;
                         timeinMins.start();
                        gametimerforMins();
			
		} else { 
			System.out.println("Not Correct"); 
                        JOptionPane.showMessageDialog(rootPane,"NOOOO!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
		}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int solution = 6;
                //check solution 
		boolean correct = myGame.checkSolution(currentGame, solution);
                 int score = myGame.getScore(); 
                JOptionPane.showMessageDialog(rootPane, "Answer:"+correct);
                if (correct) {
			JOptionPane.showMessageDialog(rootPane,"YEAH!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			lablegame.setIcon(ii);
                        lblscore.setText(""+score);
                        m=0;
                         timeinMins.start();
                        gametimerforMins();
			
		} else { 
			System.out.println("Not Correct"); 
                        JOptionPane.showMessageDialog(rootPane,"NOOOO!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
		}
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int solution = 7;
                //check solution 
		boolean correct = myGame.checkSolution(currentGame, solution);
                 int score = myGame.getScore(); 
                JOptionPane.showMessageDialog(rootPane, "Answer:"+correct);
                if (correct) {
			JOptionPane.showMessageDialog(rootPane,"YEAH!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			lablegame.setIcon(ii);
                        lblscore.setText(""+score);
                        
                        m=0;
                         timeinMins.start();
                        gametimerforMins();
			
		} else { 
			System.out.println("Not Correct"); 
                        JOptionPane.showMessageDialog(rootPane,"NOOOO!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
		}
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int solution = 8;
                //check solution 
		boolean correct = myGame.checkSolution(currentGame, solution);
                 int score = myGame.getScore(); 
                JOptionPane.showMessageDialog(rootPane, "Answer:"+correct);
                if (correct) {
			JOptionPane.showMessageDialog(rootPane,"YEAH!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			lablegame.setIcon(ii);
                        lblscore.setText(""+score);
                         
                        m=0;
                        timeinMins.start();
                        gametimerforMins();
			
		} else { 
			System.out.println("Not Correct"); 
                        JOptionPane.showMessageDialog(rootPane,"NOOOO!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
		}
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int solution = 9;
                //check solution 
		boolean correct = myGame.checkSolution(currentGame, solution);
                 int score = myGame.getScore(); 
                JOptionPane.showMessageDialog(rootPane, "Answer:"+correct);
                if (correct) {
			JOptionPane.showMessageDialog(rootPane,"YEAH!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			lablegame.setIcon(ii);
                        lblscore.setText(""+score);
                        
                        m=0;
                         timeinMins.start();
                        gametimerforMins();
			
		} else { 
			System.out.println("Not Correct"); 
                        JOptionPane.showMessageDialog(rootPane,"NOOOO!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
		}
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        int solution=0;
        boolean correct = myGame.checkSolution(currentGame, solution);
                 int score = myGame.getScore(); 
                JOptionPane.showMessageDialog(rootPane, "Answer:"+correct);
                if (correct) {
			JOptionPane.showMessageDialog(rootPane,"YEAH!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			lablegame.setIcon(ii);
                        lblscore.setText(""+score);
                        
                        m=0;
                         timeinMins.start();
                        gametimerforMins();
			
		} else { 
			System.out.println("Not Correct"); 
                        JOptionPane.showMessageDialog(rootPane,"NOOOO!");
                        JOptionPane.showMessageDialog(rootPane, "Path"+currentGame);
		}
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        //String username=lableusersmilegame1.getText();
         //int score = myGame.getScore(); 
         //s=score+currentscore;
                           //preparedStatement=con.prepareStatement("UPDATE `scoreBoard` SET `smilegamescore`=? WHERE `username`=?");
                          // preparedStatement.setInt(1,s);
                          // preparedStatement.setString(2, username);
                          //  preparedStatement.executeUpdate();
    }//GEN-LAST:event_jButton11ActionPerformed
public void iniComponents(String player)
{
   
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
            java.util.logging.Logger.getLogger(SmilePuzzleGametest2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SmilePuzzleGametest2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SmilePuzzleGametest2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SmilePuzzleGametest2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(() -> {
            new SmilePuzzleGametest2().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LifeIcon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
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
