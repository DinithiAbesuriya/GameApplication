/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_EmojiGame;

/**
 *
 * @author dinithi
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Code_EmojiGame.Emoji;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Code_EmojiGame.EmojiImageRandom;

import GUI_SmileGame.FailedGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import Database.DBFetchDataEmojiGame;
import java.sql.ResultSet;

import GUI_SmileGame.SmilePuzzleGametest3;

public class EmojiGametest3 extends javax.swing.JFrame {
    Emoji EmojiList[];
    int index;
    int randomfirst;
    int nextrandom;
    EmojiImageRandom e;
    String image,lifeimage;
    int firstcount,currentnum,level,randomimage,noOfQuestions,levelachieved,selectedlevel;
    int countofgames,score,scorenow,currentscore;
    Timer timeinMins;
    ResultSet res,levelResultSet,scoreResultSet,currentResultSet,res2,reslevelachieved,resselectedlevel;
    String username;
    String user1;
    
   // String user1String;;
   //  String user1String;
    
    
    int response,lifecount,currentlevelselected;
    DBFetchDataEmojiGame data;

    /**
     * Creates new form EmojiGame
     */
    public EmojiGametest3() {
       
        
      
        initComponents();
        username=null;
        username = lableuseremojigame1.getText();
        
        JOptionPane.showMessageDialog(rootPane, "username: "+username);
        EmojiList = new Emoji[4];
        data=new DBFetchDataEmojiGame();
        e=new EmojiImageRandom();
        lifecount=3;
        image="";
        randomimage=0;
        readData();
        
       // int levelrandom = levelrandom();
        JOptionPane.showMessageDialog(rootPane, "currentlevel: "+data.getcurrentlevel(username));
          try {
         JOptionPane.showMessageDialog(rootPane, "currentlevel: "+data.getcurrentlevel(username).next());
      
            if(data.getcurrentlevel(username).next())
            {
                int levelrandom=data.getcurrentlevel(username).getInt("current level");
                JOptionPane.showMessageDialog(rootPane, "currentlevel: "+levelrandom);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmojiGametest3.class.getName()).log(Level.SEVERE, null, ex);
        }
        randomfirst=e.RandomImageLevel1();
        //randomfirst=levelrandom();
        JOptionPane.showMessageDialog(rootPane, "randonfirst value: "+randomfirst);
        nextrandom=randomfirst;
        currentnum=randomfirst;
        JOptionPane.showMessageDialog(rootPane, "nextfirst value: "+nextrandom);
        JOptionPane.showMessageDialog(rootPane, "current value: "+currentnum);
        firstcount=0;
        countofgames=0;
        System.out.println(randomfirst);
        EmojiImage(randomfirst);
        
        score=0;
        currentscore=0;
       
        level=0;
        
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
public void readData() {
        try {
             index = 0;
            FileReader fr = new FileReader("emojis.txt");
            
            BufferedReader br = new BufferedReader(fr);
            
            String details[];
            String line = br.readLine();
            
            while (line != null) {
                details = line.split(",");
               // EmojiList[index++] = new Emoji(details[0].trim(),details[1].trim(),details[2].trim());
                
                line = br.readLine();
                JOptionPane.showMessageDialog(rootPane, line);
            }
            br.close();
        } catch (IOException e1) {
            System.out.println("Error in File reading!!!");
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(rootPane, "error: "+e2);
            System.out.println("Error in processing!!!");
        }
    }
public void EmojiImage(int num)
{
  
       
            image=EmojiList[num].getImage();
            ImageIcon ii = new ImageIcon(image);
	    lblicon.setIcon(ii);
        
}

 int m=0;
    int s=0;
        public void gametimerforMins()
        {
            m++;
            lbltimemin.setText(String.valueOf(m));
            if(m==20)
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
                     scorenow=Integer.parseInt(lblscoreemoji.getText());
                     JOptionPane.showMessageDialog(rootPane, "SCORENOW: "+scorenow);
                     
                     int currentscore=0;
                   
                        
                           res=data.getcurrentscoreemoji(username);
                           JOptionPane.showMessageDialog(rootPane, "res: "+res);
                    try {
                        if(res.next())
                        {
                            currentscore=res.getInt("score");
                            JOptionPane.showMessageDialog(rootPane, "SCORENOW: "+currentscore);
                            
                            JOptionPane.showMessageDialog(rootPane, "res:"+currentscore);
                            //Login l=new Login();
                            //l.setVisible(false);
                            s=scorenow+currentscore;
                            data.updatescore(username, s);
                            WonGameEmoji wg=new WonGameEmoji();
                            wg.setVisible(true);
                           
                            //else
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(EmojiGametest3.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                           
                        
                    
                    
                 }
                 else{
                     JOptionPane.showMessageDialog(rootPane, "NO");
                 }
                
            }
        }
        String user1String=username;
 public int levelrandom()
        {
            
      
        try {
           

             JOptionPane.showMessageDialog(rootPane, "user1: "+user1String);

            currentResultSet=data.getcurrentlevel(user1String);
            JOptionPane.showMessageDialog(rootPane, "current: "+currentResultSet);
           JOptionPane.showMessageDialog(rootPane, "Boolean: "+currentResultSet.next());
           
            if(currentResultSet.next())
            {
                JOptionPane.showMessageDialog(rootPane, "next current: ");
               currentlevelselected=currentResultSet.getInt("current level");
               JOptionPane.showMessageDialog(rootPane, "currentlevel: "+currentlevelselected);
                switch (currentlevelselected) {
                    case 1:
                        randomimage=e.RandomImageLevel1();
                        break;
                    case 2:
                        randomimage=e.RandomImageLevel2();
                        JOptionPane.showMessageDialog(rootPane, "random image: "+randomimage);
                        break;
                    case 3:
                        randomimage=e.RandomImageLevel3();
                        break;
                    default:
                        randomimage=e.RandomImageLevel4();
                        break;
                }
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmojiGametest3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return randomimage;
        }

         public void Timeup()
        {
           
               // currentGame = myGame.nextGame(); 
			//ImageIcon ii = new ImageIcon(currentGame);
			//lablegame.setIcon(ii);
                       
                        
                        /**
                         * 
                         * time is set back to zero after user gets correct answer
                         */
           
                   // nextrandom=e.RandomImageLevel1();
                    JOptionPane.showMessageDialog(rootPane, "Tome up nxt: "+nextrandom);
                    JOptionPane.showMessageDialog(rootPane, "Currentnum Tome up nxt: "+currentnum);

                     while(nextrandom==currentnum){
                    
                        
                        currentnum=e.RandomImageLevel1();
                        
                        JOptionPane.showMessageDialog(rootPane, "if Tome up nxt: "+currentnum);
                        
                        
                    
                    }
                      EmojiImage(currentnum);
                        m=0;
                        timeinMins.start();
                        gametimerforMins();
                        nextrandom=currentnum;
                        
                    
                  
        }
        public void Life(int c)
        {
            for(int i=3;i>=1;i--)
            {
            if(c==i)
            {
                
               lifeimage="/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/EmojiApiImages/LifeImages/"+i+"life.png";
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
        public int getlevel()
        {
             username = lableuseremojigame1.getText();

            JOptionPane.showMessageDialog(rootPane, "USERNAME: " + username);

            res2 = data.getselectedlevel(username);
            try {
                if (res2.next()) {
                    noOfQuestions = res2.getInt("current level");
                    JOptionPane.showMessageDialog(rootPane, "No of Questions:" + noOfQuestions);
                }
                //noOfQuestions=gl.getNumberOfQuestion(username);
                //JOptionPane.showMessageDialog(rootPane, "No of Questions:"+noOfQuestions);
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(lblicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 690, 360));
        jPanel1.add(txtanswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 620, 290, 80));

        jButton1.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/EmojiApiImages/Button/btnsubmit.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 620, 210, 80));

        lblscoreemoji.setFont(new java.awt.Font("Malayalam MN", 1, 24)); // NOI18N
        jPanel1.add(lblscoreemoji, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 110, 50));

        LifeIcon.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/EmojiApiImages/LifeImages/4life.png")); // NOI18N
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

        lableuserlogo1.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/userlogo.png")); // NOI18N
        jPanel1.add(lableuserlogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 60, 40));

        lableuseremojigame1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jPanel1.add(lableuseremojigame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 170, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/EmojiApiImages/BackgroundImage/background.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -20, 1170, 790));

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
        // for(int i=0;i<2;i++)
        
        
        String answer=txtanswer.getText();
        String solution="";
        if(firstcount!=1)
        {
            solution=EmojiList[randomfirst].getSolution();
            JOptionPane.showMessageDialog(rootPane, "solution:"+solution);
        }
        else{
            solution=EmojiList[nextrandom].getSolution();
            JOptionPane.showMessageDialog(rootPane, "solution:"+solution);
        }
        JOptionPane.showMessageDialog(rootPane, "SOLUTOION"+solution);
        if (answer.equalsIgnoreCase(solution)) {
                 JOptionPane.showMessageDialog(rootPane, "YEAH!");
         
            int level=0;
            level=getlevel();
            JOptionPane.showMessageDialog(rootPane, "LEVEL: "+level);
            countofgames++;
            if(level==countofgames)
            {
                timeinMins.stop();
                reslevelachieved=data.getLevel(username);
                resselectedlevel=data.getselectedlevel(username);
                try {
                    if(reslevelachieved.next())
                    {
                       levelachieved=reslevelachieved.getInt("levelachieved");
                       JOptionPane.showMessageDialog(rootPane, "LEVEL ACHIEVED: "+levelachieved);
                    }
                    if(resselectedlevel.next())
                    {
                        selectedlevel=resselectedlevel.getInt("current level");
                        JOptionPane.showMessageDialog(rootPane, "Selected level: "+selectedlevel);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(SmilePuzzleGametest3.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(levelachieved==4)
                {
                data.updatelevelachieved(username, 4);
                }
                else{
                if(levelachieved==selectedlevel)
                {
                data.updatelevelachieved(username, levelachieved+1);
                }
                    
                }
                dispose();
                WonGameEmoji wg=new WonGameEmoji();
                wg.user=username;
                wg.lblfinalscore.setText(""+score);
                wg.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "no");
        }

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
            java.util.logging.Logger.getLogger(EmojiGametest3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmojiGametest3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmojiGametest3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmojiGametest3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new EmojiGametest3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel LifeIcon;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lableuseremojigame1;
    private javax.swing.JLabel lableuserlogo1;
    public javax.swing.JLabel lblicon;
    private javax.swing.JLabel lblscoreemoji;
    public javax.swing.JLabel lbltimemin;
    public javax.swing.JLabel lifecountvalue;
    private javax.swing.JTextField txtanswer;
    // End of variables declaration//GEN-END:variables
}
