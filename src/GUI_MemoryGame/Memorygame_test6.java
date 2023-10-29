/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_MemoryGame;

import javax.swing.ImageIcon;
import Code_MemoryGame.Memory;
import Code_MemoryGame.MemoryEngine;
import Code_MemoryGame.MemoryServer;
import com.sun.tools.javac.util.ArrayUtils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author dinithi
 */
public class Memorygame_test6 extends javax.swing.JFrame {
    int id,matchingtitle1,matchingtitle2,matchid,lifecount,count_correctanswer,currentlevel;
    String player,image,username;
     Memory theList[];
     MemoryEngine myGame;
     int matchcount=-1;
     int selected[],check1,check2;
     int m1,m2,sam;
     String titleselected[];
     Timer timeinMins;
     int response,noOfQuestions,countofgames,levelachieved,selectedlevel;
     FailedGame fg;
     String lifeimage;
     String currenttitle;
    public Memorygame_test6() {
        initComponents();
        lifecount=3;
        
        lifeimage=null;
        count_correctanswer=0;
        currentlevel=2;
        ImageIcon ii=firstquestion();
        title1.setIcon(ii);
        title2.setIcon(ii);
        title3.setIcon(ii);
        title4.setIcon(ii);
        title5.setIcon(ii);
        title6.setIcon(ii);
        title7.setIcon(ii);
        title8.setIcon(ii);
        title9.setIcon(ii);
        title10.setIcon(ii);
        title11.setIcon(ii);
        title12.setIcon(ii);
        
        
       // MemoryServer m=new MemoryServer();
       // MemoryEngine m2=new MemoryEngine(player);
        
        theList=new Memory[6];
        selected=new int[2];
        titleselected=new String[2];
        title1.setEnabled(true);
        title2.setEnabled(true);
        title3.setEnabled(true);
        title4.setEnabled(true);
        title5.setEnabled(true);
        title6.setEnabled(true);
        title7.setEnabled(true);
        title8.setEnabled(true);
        title9.setEnabled(true);
        title10.setEnabled(true);
        title11.setEnabled(true);
        title12.setEnabled(true);
        
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
        try {
            getgame();
        } catch (IOException ex) {
            Logger.getLogger(Memorygame_test6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int m=0;
    int s=0;
        public void gametimerforMins()
        {
            m++;
            lbltimemin.setText(String.valueOf(m));
            if(m==100)
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
                     String username=lableusermemorygame1.getText();
                     int currentscore = 0;
                     ImageIcon jImage1 = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/GAME OVER!!.png");
                     JOptionPane.showMessageDialog(this, "", "", JOptionPane.INFORMATION_MESSAGE, jImage1);

                     timeinMins.stop();
                     gametimerforMins();
                     dispose();
                     username = lableusermemorygame1.getText();
                     fg.user = username;
                     fg.setVisible(true);
                    
                    }
                 else{
                     JOptionPane.showMessageDialog(rootPane, "NO");
                 }
                
            }
        }
        
        
        public void Timeup()
        {
           
            ImageIcon ii = firstquestion();
            title1.setIcon(ii);
            title2.setIcon(ii);
            title3.setIcon(ii);
            title4.setIcon(ii);
            title5.setIcon(ii);
            title6.setIcon(ii);
            title7.setIcon(ii);
            title8.setIcon(ii);
            title9.setIcon(ii);
            title10.setIcon(ii);
            title11.setIcon(ii);
            title12.setIcon(ii);
            title1.setEnabled(true);
            title2.setEnabled(true);
            title3.setEnabled(true);
            title4.setEnabled(true);
            title5.setEnabled(true);
            title6.setEnabled(true);
            title7.setEnabled(true);
            title8.setEnabled(true);
            title9.setEnabled(true);
            title10.setEnabled(true);
            title11.setEnabled(true);
            title12.setEnabled(true);
            

                        
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
                
                timeinMins.stop();
                gametimerforMins();
                dispose();
                username = lableusermemorygame1.getText();
                fg.user=username;
                fg.setVisible(true);
                
            }
            }
        }
        
 public void getgame() throws IOException {
   int begin=2,end=124; 
    int length,length2,length3,id=0,matchid=0,matchingtitle1=0,matchingtitle2=0;
            String quest=null,solution=null,image=null;
    
 
   for(int i=0;i<6;i++)
   {
       
       
             JSONParser jsonp=new JSONParser();
            // String smileapi = "http://localhost:8080/api/emojigame/getrandom1";
            URL url=null;
       try {
           url = new URL("http://localhost:8080/api/memorygame/getrandom4");
       } catch (MalformedURLException ex) {
           Logger.getLogger(MemoryServer.class.getName()).log(Level.SEVERE, null, ex);
       }
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            //int i=0;
            
            while ((line = reader.readLine()) != null){
                System.out.println("Line: "+line);
                length=line.length();
                
                String line2=line.substring(1, length-1);
               System.out.println("line 2 : "+line2);
               String result;
           
                // String line3=line.substring(2, 124);
                
                 String line3=line.substring(begin, end);
                  System.out.println("BEG:"+begin);
                   System.out.println("end:"+end);
                 begin=end+3;
                 end=begin+122;
                  System.out.println("Data Split:"+line3);
                  String id1[]=line3.split(",");
                   System.out.println("ID Split:"+id1[0]);
                   id=Integer.parseInt(id1[0].trim());
                   image=id1[1];
                   matchid=Integer.parseInt(id1[2].trim());
                   matchingtitle1=Integer.parseInt(id1[3].trim());
                   matchingtitle2=Integer.parseInt(id1[4].trim());
                   System.out.println("ID Split:"+id1[1]);
                   System.out.println("ID Split:"+id1[2]);
                   System.out.println("ID Split:"+id1[3]);
                   System.out.println("ID Split:"+id1[4]);
                
                
                
         
     
               
          theList[i]= new Memory(id, image, matchid, matchingtitle1, matchingtitle2); 
                
              
   
    } 
   }
 }
 
 public String getmatching(int id)
 {
      String imagereturn=null;
       // try {
           
            
      //      getgame();
            
            for(int i=0;i<6;i++)
            {
                matchingtitle1 = theList[i].getMatchingtitile1();
                 System.out.println("ID "+matchingtitle1);
                matchingtitle2 = theList[i].getMatchingtitile2();
                 System.out.println("ID2 "+matchingtitle2);
                image = theList[i].getImage();
                matchid=theList[i].getMatchingid();
                if(matchingtitle1==id||matchingtitle2==id)
                {
                    System.out.println("ID MATCH");
                    imagereturn=image;
                }
            }
           
      //  } catch (IOException ex) {
      //      Logger.getLogger(Level1_testlevelsadded.class.getName()).log(Level.SEVERE, null, ex);
       // }
         return imagereturn;
 }
 public int getMatchTitle1(String checkimage)
 {
     int match=0;
       // try {
           
            
        //    getgame();
            
            for(int i=0;i<6;i++)
            {
                matchingtitle1 = theList[i].getMatchingtitile1();
                System.out.println("ID "+matchingtitle1);
                matchingtitle2 = theList[i].getMatchingtitile2();
                 System.out.println("ID2 "+matchingtitle2);
                image = theList[i].getImage();
                matchid=theList[i].getMatchingid();
                if(image.equals(checkimage))
                {
                   
                    match=matchingtitle1;
                }
            }
           
     //   } catch (IOException ex) {
     //       Logger.getLogger(Level1_testlevelsadded.class.getName()).log(Level.SEVERE, null, ex);
     //   }
        
            
           
       
         return match;
 }
 public int getMatchTitle2(String checkimage)
 {
     int match=0;
      //  try {
           
            
       //     getgame();
            
            for(int i=0;i<6;i++)
            {
                matchingtitle1 = theList[i].getMatchingtitile1();
                System.out.println("ID "+matchingtitle1);
                matchingtitle2 = theList[i].getMatchingtitile2();
                 System.out.println("ID2 "+matchingtitle2);
                image = theList[i].getImage();
                matchid=theList[i].getMatchingid();
                if(image.equals(checkimage))
                {
                   
                    match=matchingtitle2;
                }
            }
           
     //   } catch (IOException ex) {
      //      Logger.getLogger(Level1_testlevelsadded.class.getName()).log(Level.SEVERE, null, ex);
     //   }
        
            
           
       
         return match;
 }
 int match=0;
     int id2;
 public int getMatchId(String checkimage)
 {
     
      //  try {
           
            
      //      getgame();
            
            for(int i=0;i<6;i++)
            {
                matchingtitle1 = theList[i].getMatchingtitile1();
                System.out.println("ID "+matchingtitle1);
                matchingtitle2 = theList[i].getMatchingtitile2();
                 System.out.println("ID2 "+matchingtitle2);
                image = theList[i].getImage();
                id2=theList[i].getMatchingid();
                if(image.equals(checkimage))
                {
                   
                    match=id2;
                    JOptionPane.showMessageDialog(rootPane, "mATCH ID: "+id2);
                    JOptionPane.showMessageDialog(rootPane, "title1: "+matchingtitle1);
                                        JOptionPane.showMessageDialog(rootPane, "title2: "+matchingtitle2);

                }
            }
           
     //   } catch (IOException ex) {
     //       Logger.getLogger(Level1_testlevelsadded.class.getName()).log(Level.SEVERE, null, ex);
     //   }
        
            
           
       
         return match;
 }
 public void getmatchingtitle()
 {
     String t1=titleselected[0];
     JOptionPane.showMessageDialog(rootPane, "T1: "+t1);
     String t2=titleselected[1];
          JOptionPane.showMessageDialog(rootPane, "T2: "+t2);

     if(t1.equals("title1")||t2.equals("title1"))
     {
         title1.setText("");
         title1.setBackground(Color.black);
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/correctpic.png");
         title1.setIcon(ii);
     }
     if(t1.equals("title2")||t2.equals("title2"))
     {
         title2.setText("");
         title2.setBackground(Color.black);
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/correctpic.png");
         title2.setIcon(ii);
     }
    if(t1.equals("title3")||t2.equals("title3"))
     {
         title3.setText("");
         title3.setBackground(Color.black);
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/correctpic.png");
         title3.setIcon(ii);
     }
     if(t1.equals("title4")||t2.equals("title4"))
     {
         title4.setText("");
         title4.setBackground(Color.black);
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/correctpic.png");
         title4.setIcon(ii);
     }
     if(t1.equals("title5")||t2.equals("title5"))
     {
         title5.setText("");
         title5.setBackground(Color.black);
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/correctpic.png");
         title5.setIcon(ii);
     }
      if(t1.equals("title6")||t2.equals("title6"))
     {
         title6.setText("");
         title6.setBackground(Color.black);
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/correctpic.png");
         title6.setIcon(ii);
     }
      if(t1.equals("title7")||t2.equals("title7"))
     {
         title7.setText("");
         title7.setBackground(Color.black);
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/correctpic.png");
         title7.setIcon(ii);
     }
      if(t1.equals("title8")||t2.equals("title8"))
     {
         title8.setText("");
         title8.setBackground(Color.black);
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/correctpic.png");
         title8.setIcon(ii);
     }
      if(t1.equals("title9")||t2.equals("title9"))
     {
         title9.setText("");
         title9.setBackground(Color.black);
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/correctpic.png");
         title9.setIcon(ii);
     }
      if(t1.equals("title10")||t2.equals("title10"))
     {
         title10.setText("");
         title10.setBackground(Color.black);
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/correctpic.png");
         title10.setIcon(ii);
     }
      if(t1.equals("title11")||t2.equals("title11"))
     {
         title11.setText("");
         title11.setBackground(Color.black);
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/correctpic.png");
         title11.setIcon(ii);
     }
      if(t1.equals("title12")||t2.equals("title12"))
     {
         title12.setText("");
         title12.setBackground(Color.black);
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/correctpic.png");
         title12.setIcon(ii);
     }
     else{
         System.err.println("ERROR");
 }
 }
 public ImageIcon firstquestion()
 {
     return new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/question.png");
 }
      public void changeback()
 {
     String t1=titleselected[0];
     JOptionPane.showMessageDialog(rootPane, "T1: "+t1);
     String t2=titleselected[1];
          JOptionPane.showMessageDialog(rootPane, "T2: "+t2);

     if(t1.equals("title1")||t2.equals("title1"))
     {
         title1.setText("");
         title1.setBackground(Color.black);
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/question.png");
         title1.setIcon(ii);
         
        
         
     }
     if(t1.equals("title2")||t2.equals("title2"))
     {
         title2.setText("");
         title2.setBackground(Color.black);
        
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/question.png");
         title2.setIcon(ii);
              }
    if(t1.equals("title3")||t2.equals("title3"))
     {
         title3.setText("");
        
         title3.setBackground(Color.black);
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/question.png");
         title3.setIcon(ii);
         
     }
     if(t1.equals("title4")||t2.equals("title4"))
     {
         title4.setText("");
         title4.setBackground(Color.black);
         
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/question.png");
         title4.setIcon(ii);
         
     }
     if(t1.equals("title5")||t2.equals("title5"))
     {
         title5.setText("");
         title5.setBackground(Color.black);
         
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/question.png");
         title5.setIcon(ii);
        
     }
      if(t1.equals("title6")||t2.equals("title6"))
     {
         title6.setText("");
         title6.setBackground(Color.black);
         
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/question.png");
         title6.setIcon(ii);
         
     }
      if(t1.equals("title7")||t2.equals("title7"))
     {
         title7.setText("");
         title7.setBackground(Color.black);
         
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/question.png");
         title7.setIcon(ii);
         
     }
      if(t1.equals("title8")||t2.equals("title8"))
     {
         title8.setText("");
         title8.setBackground(Color.black);
         
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/question.png");
         title8.setIcon(ii);
         
     }
      if(t1.equals("title9")||t2.equals("title9"))
     {
         title9.setText("");
         title9.setBackground(Color.black);
         
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/question.png");
         title9.setIcon(ii);
         
     }
      if(t1.equals("title10")||t2.equals("title10"))
     {
         title10.setText("");
         title10.setBackground(Color.black);
         
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/question.png");
         title10.setIcon(ii);
         
     }
      if(t1.equals("title11")||t2.equals("title11"))
     {
         title11.setText("");
         title11.setBackground(Color.black);
         
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/question.png");
         title11.setIcon(ii);
         
         
     }
      if(t1.equals("title12")||t2.equals("title12"))
     {
         title12.setText("");
         title12.setBackground(Color.black);
        
         ImageIcon ii = new ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGamePics/TitleImage/question.png");
         title12.setIcon(ii);
         
     }
     else{
         System.err.println("ERROR");
 }
 }
  public JButton disablebutton()
 {
     String t1=titleselected[0];
     JOptionPane.showMessageDialog(rootPane, "T1: "+t1);
     
     if (t1.equals("title1") ) {

         return title1;
     }
     if (t1.equals("title2") ) {
         return title2;
     }
     if (t1.equals("title3")) {
         return title3;
     }
     if (t1.equals("title4") ) {
       return title4;

     }
     if (t1.equals("title5")) {
        return title5;

     }
     if (t1.equals("title6")) {
         return title6;

     }
      if(t1.equals("title7"))
     {
         return title7;
         
     }
      if(t1.equals("title8"))
     {
         return title8;
         
     }
      if(t1.equals("title9"))
     {
         return title9;
     }
      if(t1.equals("title10"))
     {
        return title10;
         
     }
      if(t1.equals("title11"))
     {
         return title11;
         
     }
      if(t1.equals("title12"))
     {
         return title12;
         
     }
     else{
         System.err.println("ERROR");
 }
    return null;
     
     
 }
  public JButton disablebutton1()
 {
     
     String t2=titleselected[1];
     JOptionPane.showMessageDialog(rootPane, "T2: "+t2);

     if (t2.equals("title1")) {

         return title1;
     }
     if (t2.equals("title2")) {
         return title2;
     }
     if (t2.equals("title3")) {
         return title3;
     }
     if (t2.equals("title4")) {
       return title4;

     }
     if (t2.equals("title5")) {
        return title5;

     }
     if (t2.equals("title6")) {
         return title6;

     }
      if(t2.equals("title7"))
     {
         return title7;
         
     }
      if(t2.equals("title8"))
     {
         return title8;
         
     }
      if(t2.equals("title9"))
     {
         return title9;
     }
      if(t2.equals("title10"))
     {
        return title10;
         
     }
      if(t2.equals("title11"))
     {
         return title11;
         
     }
      if(t2.equals("title12"))
     {
         return title12;
         
     }
     else{
         System.err.println("ERROR");
 }
    return null;
     
     
 }
  public void start()
  {
      ImageIcon ii = firstquestion();
            title1.setIcon(ii);
            title2.setIcon(ii);
            title3.setIcon(ii);
            title4.setIcon(ii);
            title5.setIcon(ii);
            title6.setIcon(ii);
            title7.setIcon(ii);
            title8.setIcon(ii);
            title9.setIcon(ii);
            title10.setIcon(ii);
            title11.setIcon(ii);
            title12.setIcon(ii);
            title1.setEnabled(true);
            title2.setEnabled(true);
            title3.setEnabled(true);
            title4.setEnabled(true);
            title5.setEnabled(true);
            title6.setEnabled(true);
            title7.setEnabled(true);
            title8.setEnabled(true);
            title9.setEnabled(true);
            title10.setEnabled(true);
            title11.setEnabled(true);
            title12.setEnabled(true);
            
  }
  public void changelevel() throws IOException
  {
      if(count_correctanswer==6)
      {
          
          
          if(currentlevel==1)
          {
              
          }
          else if(currentlevel==2)
          {
              getgame();
              start();
          }
          else if(currentlevel==3)
          {
              getgame();
              start();
          }
          else if(currentlevel==4)
          {
              getgame();
              start();
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
        title1 = new javax.swing.JButton();
        title2 = new javax.swing.JButton();
        title3 = new javax.swing.JButton();
        title4 = new javax.swing.JButton();
        title5 = new javax.swing.JButton();
        title6 = new javax.swing.JButton();
        title7 = new javax.swing.JButton();
        title8 = new javax.swing.JButton();
        title9 = new javax.swing.JButton();
        title10 = new javax.swing.JButton();
        title11 = new javax.swing.JButton();
        title12 = new javax.swing.JButton();
        lbltimemin = new javax.swing.JLabel();
        lbltime0 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblscore = new javax.swing.JLabel();
        lableuserlogo1 = new javax.swing.JLabel();
        lableusermemorygame1 = new javax.swing.JLabel();
        lifecountvalue = new javax.swing.JLabel();
        LifeIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title1.setBackground(new java.awt.Color(255, 255, 255));
        title1.setFont(new java.awt.Font("Malayalam MN", 1, 48)); // NOI18N
        title1.setEnabled(false);
        title1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title1ActionPerformed(evt);
            }
        });
        jPanel1.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 140, 130));

        title2.setEnabled(false);
        title2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title2ActionPerformed(evt);
            }
        });
        jPanel1.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 130, 130));

        title3.setBackground(new java.awt.Color(255, 255, 255));
        title3.setEnabled(false);
        title3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title3ActionPerformed(evt);
            }
        });
        jPanel1.add(title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 140, 130));

        title4.setBackground(new java.awt.Color(255, 255, 255));
        title4.setEnabled(false);
        title4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title4ActionPerformed(evt);
            }
        });
        jPanel1.add(title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 130, 130));

        title5.setBackground(new java.awt.Color(255, 255, 255));
        title5.setEnabled(false);
        title5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title5ActionPerformed(evt);
            }
        });
        jPanel1.add(title5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 130, 130));

        title6.setBackground(new java.awt.Color(255, 255, 255));
        title6.setEnabled(false);
        title6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title6ActionPerformed(evt);
            }
        });
        jPanel1.add(title6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 140, 130));

        title7.setBackground(new java.awt.Color(255, 255, 255));
        title7.setEnabled(false);
        title7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title7ActionPerformed(evt);
            }
        });
        jPanel1.add(title7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 130, 130));

        title8.setBackground(new java.awt.Color(255, 255, 255));
        title8.setEnabled(false);
        title8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title8ActionPerformed(evt);
            }
        });
        jPanel1.add(title8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 130, 130));

        title9.setBackground(new java.awt.Color(255, 255, 255));
        title9.setEnabled(false);
        title9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title9ActionPerformed(evt);
            }
        });
        jPanel1.add(title9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 140, 130));

        title10.setBackground(new java.awt.Color(255, 255, 255));
        title10.setEnabled(false);
        title10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title10ActionPerformed(evt);
            }
        });
        jPanel1.add(title10, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 529, 130, 130));

        title11.setBackground(new java.awt.Color(255, 255, 255));
        title11.setEnabled(false);
        title11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title11ActionPerformed(evt);
            }
        });
        jPanel1.add(title11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 530, 130, 130));

        title12.setBackground(new java.awt.Color(255, 255, 255));
        title12.setEnabled(false);
        title12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title12ActionPerformed(evt);
            }
        });
        jPanel1.add(title12, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 530, 140, 130));

        lbltimemin.setFont(new java.awt.Font("Luminari", 1, 48)); // NOI18N
        jPanel1.add(lbltimemin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 70, 70));

        lbltime0.setFont(new java.awt.Font("Luminari", 1, 48)); // NOI18N
        lbltime0.setText("00");
        jPanel1.add(lbltime0, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 70, 70));

        jLabel2.setFont(new java.awt.Font("Luminari", 1, 48)); // NOI18N
        jLabel2.setText(":");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 20, 60));

        lblscore.setFont(new java.awt.Font("Luminari", 1, 48)); // NOI18N
        jPanel1.add(lblscore, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 100, 50));

        lableuserlogo1.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/userlogo.png")); // NOI18N
        jPanel1.add(lableuserlogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 60, 40));

        lableusermemorygame1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jPanel1.add(lableusermemorygame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 170, 30));

        lifecountvalue.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        lifecountvalue.setForeground(new java.awt.Color(204, 51, 0));
        lifecountvalue.setText("4");
        jPanel1.add(lifecountvalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 50));

        LifeIcon.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/4LIFE.png")); // NOI18N
        jPanel1.add(LifeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/dinithi/Desktop/3rd Year 1st Semester/CIS/Assignment/gamepictures/MemoryGame.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 960, 810));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void title1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title1ActionPerformed
        // TODO add your handling code here:
       
        id=1;
        currenttitle="title1";
        
       
      
                    String image=getmatching(1);
                     System.out.println("IMAGE: "+image);
                     m1=getMatchTitle1(image);
                     JOptionPane.showMessageDialog(rootPane, "m1 = "+m1);
                     
                     m2=getMatchTitle2(image);
                     JOptionPane.showMessageDialog(rootPane, "m2 = "+m2);
                    title1.setText("");
                    ImageIcon ii = new ImageIcon(image);
                    title1.setIcon(ii);
                    matchcount++;
                    JOptionPane.showMessageDialog(rootPane, "count = "+matchcount);
                   int matchid=getMatchId(image);
                   JOptionPane.showMessageDialog(rootPane, "match id = "+matchid);
                    selected[matchcount]=matchid;
                     JOptionPane.showMessageDialog(rootPane, "selected id = "+selected[matchcount]);
                    titleselected[matchcount]="title1";
                   
                   if (matchcount == 1) {
                        
                        check1 = selected[0];
                        check2 = selected[1];
                        if(check1==check2)
                        {
                            getmatchingtitle();
                            JButton btn=disablebutton();
                            btn.setEnabled(false);
                            JOptionPane.showMessageDialog(rootPane, "btn= "+btn);
                            JButton btn2=disablebutton1();
                            JOptionPane.showMessageDialog(rootPane, "btn2= "+btn2);
                            btn2.setEnabled(false);
                            count_correctanswer++;
                          //  try {
                          //      changelevel();
                          //  } catch (IOException ex) {
                          //      Logger.getLogger(Level1_testlevelsadded.class.getName()).log(Level.SEVERE, null, ex);
                          //  }
                            matchcount=-1;
                            
                            
                        }
                        else{
                            changeback();
                           //title1.setText("?"); 
                           matchcount=-1;
                           
                           
                        }

                     }
                  
                    
        
    }//GEN-LAST:event_title1ActionPerformed

    private void title12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title12ActionPerformed
        // TODO add your handling code here:
         String image=getmatching(12);
                     System.out.println("IMAGE: "+image);
                    title12.setText("");
                    ImageIcon ii = new ImageIcon(image);
                    title12.setIcon(ii);
                    matchcount++;
                   int matchid=getMatchId(image);
                   
                    selected[matchcount]=matchid;
                    JOptionPane.showMessageDialog(rootPane, "count = "+matchcount);
                    JOptionPane.showMessageDialog(rootPane, "selected id = "+selected[matchcount]);
                     JOptionPane.showMessageDialog(rootPane, "match id = "+matchid);
                    titleselected[matchcount]="title12";
                   if (matchcount == 1) {

                        check1 = selected[0];
                        check2 = selected[1];
                        if(check1==check2)
                        {
                            getmatchingtitle();
                            JButton btn=disablebutton();
                            btn.setEnabled(false);
                            JOptionPane.showMessageDialog(rootPane, "btn= "+btn);
                            JButton btn2=disablebutton1();
                            JOptionPane.showMessageDialog(rootPane, "btn2= "+btn2);
                            btn2.setEnabled(false);
                            count_correctanswer++;
                            
                            matchcount=-1;
                            
                            
                        }
                        else{
                            changeback();
                           //title1.setText("?"); 
                           matchcount=-1;
                           
                           
                        }

                     }
                    
    }//GEN-LAST:event_title12ActionPerformed

    private void title2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title2ActionPerformed
        // TODO add your handling code here:
         String image=getmatching(2);
                     System.out.println("IMAGE: "+image);
                    title2.setText("");
                    ImageIcon ii = new ImageIcon(image);
                    title2.setIcon(ii);
                    matchcount++;
                   int matchid=getMatchId(image);
                    selected[matchcount]=matchid;
                    JOptionPane.showMessageDialog(rootPane, "count = "+matchcount);
                    JOptionPane.showMessageDialog(rootPane, "selected id = "+selected[matchcount]);
                     JOptionPane.showMessageDialog(rootPane, "match id = "+matchid);
                    titleselected[matchcount]="title2";
                    if (matchcount == 1) {

                        check1 = selected[0];
                        check2 = selected[1];
                        if(check1==check2)
                        {
                            getmatchingtitle();
                            JButton btn=disablebutton();
                            btn.setEnabled(false);
                            JOptionPane.showMessageDialog(rootPane, "btn= "+btn);
                            JButton btn2=disablebutton1();
                            JOptionPane.showMessageDialog(rootPane, "btn2= "+btn2);
                            btn2.setEnabled(false);
                            count_correctanswer++;
                            
                            matchcount=-1;
                            
                            
                        }
                        else{
                            changeback();
                           //title1.setText("?"); 
                           matchcount=-1;
                           
                           
                        }

                     }
                    
    }//GEN-LAST:event_title2ActionPerformed

    private void title3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title3ActionPerformed
        // TODO add your handling code here:
      String image=getmatching(3);
                     System.out.println("IMAGE: "+image);
                    title3.setText("");
                    ImageIcon ii = new ImageIcon(image);
                    title3.setIcon(ii);
                    matchcount++;
                   int matchid=getMatchId(image);
                    selected[matchcount]=matchid;
                    JOptionPane.showMessageDialog(rootPane, "count = "+matchcount);
                    JOptionPane.showMessageDialog(rootPane, "selected id = "+selected[matchcount]);
                     JOptionPane.showMessageDialog(rootPane, "match id = "+matchid);
                    titleselected[matchcount]="title3";
                    if (matchcount == 1) {

                        check1 = selected[0];
                        check2 = selected[1];
                        if(check1==check2)
                        {
                            getmatchingtitle();
                            JButton btn=disablebutton();
                            btn.setEnabled(false);
                            JOptionPane.showMessageDialog(rootPane, "btn= "+btn);
                            JButton btn2=disablebutton1();
                            JOptionPane.showMessageDialog(rootPane, "btn2= "+btn2);
                            btn2.setEnabled(false);
                            count_correctanswer++;
                            
                            matchcount=-1;
                            
                            
                        }
                        else{
                            changeback();
                           //title1.setText("?"); 
                           matchcount=-1;
                           
                           
                        }

                     }
                    
                        
    }//GEN-LAST:event_title3ActionPerformed

    private void title4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title4ActionPerformed
        // TODO add your handling code here:
         String image=getmatching(4);
                     System.out.println("IMAGE: "+image);
                    title4.setText("");
                    ImageIcon ii = new ImageIcon(image);
                    title4.setIcon(ii);
                     matchcount++;
                   int matchid=getMatchId(image);
                    selected[matchcount]=matchid;
                    JOptionPane.showMessageDialog(rootPane, "count = "+matchcount);
                    JOptionPane.showMessageDialog(rootPane, "selected id = "+selected[matchcount]);
                     JOptionPane.showMessageDialog(rootPane, "match id = "+matchid);
                    titleselected[matchcount]="title4";
                   if (matchcount == 1) {

                        check1 = selected[0];
                        check2 = selected[1];
                        if(check1==check2)
                        {
                            getmatchingtitle();
                            JButton btn=disablebutton();
                            btn.setEnabled(false);
                            JOptionPane.showMessageDialog(rootPane, "btn= "+btn);
                            JButton btn2=disablebutton1();
                            JOptionPane.showMessageDialog(rootPane, "btn2= "+btn2);
                            btn2.setEnabled(false);
                            count_correctanswer++;
                            
                            matchcount=-1;
                            
                            
                        }
                        else{
                            changeback();
                           //title1.setText("?"); 
                           matchcount=-1;
                           
                           
                        }

                     }
                    
                    
    }//GEN-LAST:event_title4ActionPerformed

    private void title5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title5ActionPerformed
        // TODO add your handling code here:
        String image=getmatching(5);
                     System.out.println("IMAGE: "+image);
                    title5.setText("");
                    ImageIcon ii = new ImageIcon(image);
                    title5.setIcon(ii);
                     matchcount++;
                   int matchid=getMatchId(image);
                    selected[matchcount]=matchid;
                    JOptionPane.showMessageDialog(rootPane, "count = "+matchcount);
                    JOptionPane.showMessageDialog(rootPane, "selected id = "+selected[matchcount]);
                     JOptionPane.showMessageDialog(rootPane, "match id = "+matchid);
                    titleselected[matchcount]="title5";
                    if (matchcount == 1) {

                        check1 = selected[0];
                        check2 = selected[1];
                        if(check1==check2)
                        {
                            getmatchingtitle();
                            JButton btn=disablebutton();
                            btn.setEnabled(false);
                            JOptionPane.showMessageDialog(rootPane, "btn= "+btn);
                            JButton btn2=disablebutton1();
                            JOptionPane.showMessageDialog(rootPane, "btn2= "+btn2);
                            btn2.setEnabled(false);
                            count_correctanswer++;
                            
                            matchcount=-1;
                            
                            
                        }
                        else{
                            changeback();
                           //title1.setText("?"); 
                           matchcount=-1;
                           
                           
                        }

                     }
                    
                    
    }//GEN-LAST:event_title5ActionPerformed

    private void title6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title6ActionPerformed
        // TODO add your handling code here:
         String image=getmatching(6);
                     System.out.println("IMAGE: "+image);
                    title6.setText("");
                    ImageIcon ii = new ImageIcon(image);
                    title6.setIcon(ii);
                     matchcount++;
                   int matchid=getMatchId(image);
                    selected[matchcount]=matchid;
                    JOptionPane.showMessageDialog(rootPane, "count = "+matchcount);
                    JOptionPane.showMessageDialog(rootPane, "selected id = "+selected[matchcount]);
                     JOptionPane.showMessageDialog(rootPane, "match id = "+matchid);
                    titleselected[matchcount]="title6";
                   if (matchcount == 1) {

                        check1 = selected[0];
                        check2 = selected[1];
                        if(check1==check2)
                        {
                            getmatchingtitle();
                            JButton btn=disablebutton();
                            btn.setEnabled(false);
                            JOptionPane.showMessageDialog(rootPane, "btn= "+btn);
                            JButton btn2=disablebutton1();
                            JOptionPane.showMessageDialog(rootPane, "btn2= "+btn2);
                            btn2.setEnabled(false);
                            count_correctanswer++;
                           
                            matchcount=-1;
                            
                            
                        }
                        else{
                            changeback();
                           //title1.setText("?"); 
                           matchcount=-1;
                           
                           
                        }

                     }
                    
                    
    }//GEN-LAST:event_title6ActionPerformed

    private void title7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title7ActionPerformed
        // TODO add your handling code here:
      String image=getmatching(7);
                     System.out.println("IMAGE: "+image);
                    title7.setText("");
                    ImageIcon ii = new ImageIcon(image);
                    title7.setIcon(ii);
                     matchcount++;
                   int matchid=getMatchId(image);
                    selected[matchcount]=matchid;
                    JOptionPane.showMessageDialog(rootPane, "count = "+matchcount);
                    JOptionPane.showMessageDialog(rootPane, "selected id = "+selected[matchcount]);
                     JOptionPane.showMessageDialog(rootPane, "match id = "+matchid);
                    titleselected[matchcount]="title7";
                   if (matchcount == 1) {

                        check1 = selected[0];
                        check2 = selected[1];
                        if(check1==check2)
                        {
                            getmatchingtitle();
                            JButton btn=disablebutton();
                            btn.setEnabled(false);
                            JOptionPane.showMessageDialog(rootPane, "btn= "+btn);
                            JButton btn2=disablebutton1();
                            JOptionPane.showMessageDialog(rootPane, "btn2= "+btn2);
                            btn2.setEnabled(false);
                            count_correctanswer++;
                            
                            matchcount=-1;
                            
                            
                        }
                        else{
                            changeback();
                           //title1.setText("?"); 
                           matchcount=-1;
                           
                           
                        }

                     }
                    
                    
    }//GEN-LAST:event_title7ActionPerformed

    private void title8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title8ActionPerformed
        // TODO add your handling code here:
         String image=getmatching(8);
                     System.out.println("IMAGE: "+image);
                    title8.setText("");
                    ImageIcon ii = new ImageIcon(image);
                    title8.setIcon(ii);
                     matchcount++;
                   int matchid=getMatchId(image);
                    selected[matchcount]=matchid;
                    JOptionPane.showMessageDialog(rootPane, "count = "+matchcount);
                    JOptionPane.showMessageDialog(rootPane, "selected id = "+selected[matchcount]);
                     JOptionPane.showMessageDialog(rootPane, "match id = "+matchid);
                    titleselected[matchcount]="title8";
                    if (matchcount == 1) {

                        check1 = selected[0];
                        check2 = selected[1];
                        if(check1==check2)
                        {
                            getmatchingtitle();
                            JButton btn=disablebutton();
                            btn.setEnabled(false);
                            JOptionPane.showMessageDialog(rootPane, "btn= "+btn);
                            JButton btn2=disablebutton1();
                            JOptionPane.showMessageDialog(rootPane, "btn2= "+btn2);
                            btn2.setEnabled(false);
                            count_correctanswer++;
                            
                            matchcount=-1;
                            
                            
                        }
                        else{
                            changeback();
                           //title1.setText("?"); 
                           matchcount=-1;
                           
                           
                        }

                     }
                    
    }//GEN-LAST:event_title8ActionPerformed

    private void title9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title9ActionPerformed
        // TODO add your handling code here:
         String image=getmatching(9);
                     System.out.println("IMAGE: "+image);
                    title9.setText("");
                    ImageIcon ii = new ImageIcon(image);
                    title9.setIcon(ii);
                     matchcount++;
                   int matchid=getMatchId(image);
                    selected[matchcount]=matchid;
                    JOptionPane.showMessageDialog(rootPane, "count = "+matchcount);
                    JOptionPane.showMessageDialog(rootPane, "selected id = "+selected[matchcount]);
                     JOptionPane.showMessageDialog(rootPane, "match id = "+matchid);
                    titleselected[matchcount]="title9";
                     if (matchcount == 1) {

                        check1 = selected[0];
                        check2 = selected[1];
                        if(check1==check2)
                        {
                            getmatchingtitle();
                            JButton btn=disablebutton();
                            btn.setEnabled(false);
                            JOptionPane.showMessageDialog(rootPane, "btn= "+btn);
                            JButton btn2=disablebutton1();
                            JOptionPane.showMessageDialog(rootPane, "btn2= "+btn2);
                            btn2.setEnabled(false);
                            count_correctanswer++;
                            
                            matchcount=-1;
                            
                            
                        }
                        else{
                            changeback();
                           //title1.setText("?"); 
                           matchcount=-1;
                           
                           
                        }

                     }
                    
                    
    }//GEN-LAST:event_title9ActionPerformed

    private void title10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title10ActionPerformed
        // TODO add your handling code here:
        String image=getmatching(10);
                     System.out.println("IMAGE: "+image);
                    title10.setText("");
                    ImageIcon ii = new ImageIcon(image);
                    title10.setIcon(ii);
                     matchcount++;
                   int matchid=getMatchId(image);
                    selected[matchcount]=matchid;
                    JOptionPane.showMessageDialog(rootPane, "count = "+matchcount);
                    JOptionPane.showMessageDialog(rootPane, "selected id = "+selected[matchcount]);
                     JOptionPane.showMessageDialog(rootPane, "match id = "+matchid);
                    titleselected[matchcount]="title10";
                   if (matchcount == 1) {

                        check1 = selected[0];
                        check2 = selected[1];
                        if(check1==check2)
                        {
                            getmatchingtitle();
                            JButton btn=disablebutton();
                            btn.setEnabled(false);
                            JOptionPane.showMessageDialog(rootPane, "btn= "+btn);
                            JButton btn2=disablebutton1();
                            JOptionPane.showMessageDialog(rootPane, "btn2= "+btn2);
                            btn2.setEnabled(false);
                            count_correctanswer++;
                            
                            matchcount=-1;
                            
                            
                        }
                        else{
                            changeback();
                           //title1.setText("?"); 
                           matchcount=-1;
                           
                           
                        }

                     }
                    
                    
    }//GEN-LAST:event_title10ActionPerformed

    private void title11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title11ActionPerformed
        // TODO add your handling code here:
        String image=getmatching(11);
                     System.out.println("IMAGE: "+image);
                    title11.setText("");
                    ImageIcon ii = new ImageIcon(image);
                    title11.setIcon(ii);
                     matchcount++;
                   int matchid=getMatchId(image);
                    selected[matchcount]=matchid;
                    JOptionPane.showMessageDialog(rootPane, "count = "+matchcount);
                    JOptionPane.showMessageDialog(rootPane, "selected id = "+selected[matchcount]);
                     JOptionPane.showMessageDialog(rootPane, "match id = "+matchid);
                    titleselected[matchcount]="title11";
                   if (matchcount == 1) {

                        check1 = selected[0];
                        check2 = selected[1];
                        if(check1==check2)
                        {
                            getmatchingtitle();
                            JButton btn=disablebutton();
                            btn.setEnabled(false);
                            JOptionPane.showMessageDialog(rootPane, "btn= "+btn);
                            JButton btn2=disablebutton1();
                            JOptionPane.showMessageDialog(rootPane, "btn2= "+btn2);
                            btn2.setEnabled(false);
                            count_correctanswer++;
                           
                            matchcount=-1;
                            
                            
                        }
                        else{
                            changeback();
                           //title1.setText("?"); 
                           matchcount=-1;
                           
                           
                        }

                     }
                    
                    
    }//GEN-LAST:event_title11ActionPerformed

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
            java.util.logging.Logger.getLogger(Memorygame_test6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Memorygame_test6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Memorygame_test6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Memorygame_test6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Memorygame_test6().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LifeIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lableuserlogo1;
    public javax.swing.JLabel lableusermemorygame1;
    private javax.swing.JLabel lblscore;
    private javax.swing.JLabel lbltime0;
    private javax.swing.JLabel lbltimemin;
    private javax.swing.JLabel lifecountvalue;
    private javax.swing.JButton title1;
    private javax.swing.JButton title10;
    private javax.swing.JButton title11;
    private javax.swing.JButton title12;
    private javax.swing.JButton title2;
    private javax.swing.JButton title3;
    private javax.swing.JButton title4;
    private javax.swing.JButton title5;
    private javax.swing.JButton title6;
    private javax.swing.JButton title7;
    private javax.swing.JButton title8;
    private javax.swing.JButton title9;
    // End of variables declaration//GEN-END:variables
}
