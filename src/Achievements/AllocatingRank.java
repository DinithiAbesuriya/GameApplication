/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import javax.swing.JOptionPane;

/**
 *
 * @author dinithi
 */
public class AllocatingRank {
DBConnection db=new DBConnection();;
Connection con=db.getConnection();
PreparedStatement preparedStatement;
ResultSet res,res1,res2,res3,res4;
DBFetchDataEmojiGame data=new DBFetchDataEmojiGame();
DBFetchDataSmileGame data1=new DBFetchDataSmileGame();
DBFetchDataMemoryGame data2=new DBFetchDataMemoryGame();
int max_Scores=0,min_Scores=0,current_score=0,rows=0,finalplace=0,i=1;
String userplace2,userplace3,place,game;


public void getres(String gameplayed)
{
    switch (gameplayed) {
        case "SmileGame":
            res=data1.getmax();
            res1=data1.getmin();
            res3=data1.getORDER();
            res4=data1.getno_rows();
            break;
        case "EmojiGame":
            res=data.getmax();
            res1=data.getmin();
            res3=data.getORDER();
            res4=data.getno_rows();
            break;
        case "MemoryGame":
            res=data2.getmax();
            res1=data2.getmin();
            res3=data2.getORDER();
            res4=data2.getno_rows();
            break;
        default:
            break;
    }
}
public String user2rd(String gameplayed)
{
   //
    game=gameplayed;
    getres(gameplayed);
        try {
            //res=data1.getmax();
           // res1=data1.getmin();
           // res3=data1.getORDER();
            if(res.next())
            {
                max_Scores=res.getInt("Max_Score");
                
                
            }
            if(res1.next())
            {
                min_Scores=res1.getInt("Min_Score");
            
                
             }
           
            if(res3.next())
            {
            
                res3.next();
                
                userplace2=res3.getString("username");
               
                
            
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(AllocatingRank.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
      
    return  userplace2;
}
public String user3rd(String gameplayed)
{
     getres(gameplayed);
    try {
       
        if(res3.next())
        {
            
            res3.next();
            res3.next();
            userplace3=res3.getString("username");
            

            
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(AllocatingRank.class.getName()).log(Level.SEVERE, null, ex);
    }
    return userplace3;
}
public int currentuserplace(String username)
{
     getres(game);
    try {
       // res4=data1.getno_rows();
        if(res4.next())
            {
              rows=res4.getInt("count_rows");
                System.out.println("rows: "+rows);
           }
        //res3=data1.getORDER();
        if(res3.next())
        {
            place=res3.getString("username");
             System.out.println("plcae: "+place);
        }
        
        while(i<=rows)
        {
            
            
            if(place.equals(username))
            {
                System.out.println("Equals: "+place);
                finalplace=i;
                System.out.println("Final place: "+i);
                i=rows+1;

            }
            else{
                i++;
                res3.next();
                place=res3.getString("username");
            }
            
            
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(AllocatingRank.class.getName()).log(Level.SEVERE, null, ex);
    }
    return finalplace;
}
        
      
    
}
