/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Database.DBConnection;


/**
 *
 * @author dinithi
 */
public class DBFetchDataEmojiGame {
    int response;
    DBConnection db=new DBConnection();
    Connection con=db.getConnection();
    PreparedStatement preparedStatement;
    ResultSet res1;
    ResultSet res2;
    ResultSet res3;
    
    public ResultSet getLevel(String username)
    {
        

        try {
            
            preparedStatement=con.prepareStatement("SELECT `levelachieved` FROM `EmojiGame` WHERE `username`=? ");
            preparedStatement.setString(1, username);
             res1=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataEmojiGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res1;
                    
       
    }
    public ResultSet getcurrentscoreemoji(String username)
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT `score` FROM `EmojiGame` WHERE `username`=? ");
            preparedStatement.setString(1, username);
             res2=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataSmileGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res2;
                    
       
    }
     public ResultSet getcurrentcoinemoji(String username)
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT `coins` FROM `EmojiGame` WHERE `username`=? ");
            preparedStatement.setString(1, username);
             res1=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataSmileGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res1;
                    
       
    }
     public ResultSet getcurrentlevel(String username)
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT `current level` FROM `EmojiGame` WHERE `username`=? ");
            preparedStatement.setString(1, username);
             res2=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataSmileGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res2;
                    
       
    }
       public ResultSet getselectedlevel(String username)
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT `current level` FROM `EmojiGame` WHERE `username`=? ");
            preparedStatement.setString(1, username);
             res2=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataSmileGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res2;
                    
       
    }
      public ResultSet getmax()
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT `username`,MAX(`score`) AS Max_Score FROM `EmojiGame` ");
           // preparedStatement.setString(1, username);
             res1=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataSmileGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res1;
                    
       
    }
       public ResultSet getmin()
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT `username`,MIN(`score`) AS Min_Score FROM `EmojiGame` ");
           // preparedStatement.setString(1, username);
             res1=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataSmileGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res1;
                    
       
    }
        public ResultSet getno_rows()
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT COUNT(`username`) as count_rows FROM `EmojiGame`");
           // preparedStatement.setString(1, username);
             res1=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataMemoryGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res1;
                    
       
    }
    public ResultSet getORDER()
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT `username` FROM `EmojiGame` ORDER BY `score` DESC");
           // preparedStatement.setString(1, username);
             res1=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataSmileGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res1;
                    
       
    }
    public void updatescore(String username,int score)
    {
        try {
            preparedStatement=con.prepareStatement("UPDATE `EmojiGame` SET `score`=? WHERE `username`=? ");
            preparedStatement.setInt(1, score);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataEmojiGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertscore(String username,int score)
    {
        try {
            preparedStatement=con.prepareStatement("UPDATE `EmojiGame` SET `score`=? WHERE `username`=? ");
            preparedStatement.setInt(1, score);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataEmojiGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updatelevel(String username,int level)
    {
        try {
            preparedStatement=con.prepareStatement("UPDATE `EmojiGame` SET `levelachieved`=? WHERE `username`=? ");
            preparedStatement.setInt(1, level);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataEmojiGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void updatecurrentlevel(String username,int currentlevel)
    {
        try {
            preparedStatement=con.prepareStatement("UPDATE `EmojiGame` SET `current level`=? WHERE `username`=? ");
            preparedStatement.setInt(1, currentlevel);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataEmojiGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void updatelevelachieved(String username,int levelachieved )
    {
        try {
            preparedStatement=con.prepareStatement("UPDATE `EmojiGame` SET `levelachieved`=? WHERE `username`=? ");
            preparedStatement.setInt(1, levelachieved);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataEmojiGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         public void updatecurrentscore(String username,int score)
    {
        try {
            preparedStatement=con.prepareStatement("UPDATE `EmojiGame` SET `score`=?  WHERE `username`=? ");
            preparedStatement.setInt(1, score);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataEmojiGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
             public void updatecurrentcoins(String username,int coins)
    {
        try {
            preparedStatement=con.prepareStatement("UPDATE `EmojiGame` SET `coins`=?  WHERE `username`=? ");
            preparedStatement.setInt(1, coins);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataEmojiGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

