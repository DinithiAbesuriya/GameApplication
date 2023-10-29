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

/**
 *
 * @author dinithi
 */
public class DBFetchDataMemoryGame {
    DBConnection db=new DBConnection();
    Connection con=db.getConnection();
    PreparedStatement preparedStatement;
    ResultSet res1;
    ResultSet res2;
    ResultSet res3;
     public ResultSet getall()
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT * FROM `MemoryGame`");
           // preparedStatement.setString(1, username);
             res1=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataMemoryGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res1;
                    
       
    }
      public ResultSet getmax()
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT `username`,MAX(`score`) AS Max_Score FROM `MemoryGame` ");
           // preparedStatement.setString(1, username);
             res1=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataMemoryGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res1;
                    
       
    }
      public ResultSet getmin()
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT `username`,MIN(`score`) AS Min_Score FROM `MemoryGame` ");
           // preparedStatement.setString(1, username);
             res1=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataMemoryGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res1;
                    
       
    }
        public ResultSet getcoins(String username)
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT `coins` FROM `MemoryGame` WHERE `username`=?");
            preparedStatement.setString(1, username);
            res1=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataMemoryGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res1;
                    
       
    }
        public ResultSet getno_rows()
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT COUNT(`username`) as count_rows FROM `MemoryGame`");
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
            preparedStatement=con.prepareStatement("SELECT `username` FROM `MemoryGame` ORDER BY `score` DESC");
           // preparedStatement.setString(1, username);
             res1=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataMemoryGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res1;
                    
       
    }
    public ResultSet getcurrentscoresmile(String username)
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT `score` FROM `MemoryGame` WHERE `username`=? ");
            preparedStatement.setString(1, username);
             res1=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataMemoryGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res1;
                    
       
    }
    public ResultSet getcurrentcoinssmile(String username)
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT `coins` FROM `MemoryGame` WHERE `username`=? ");
            preparedStatement.setString(1, username);
             res1=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataMemoryGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res1;
                    
       
    }
    
     public ResultSet getlevel(String username)
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT `levelachieved` FROM `MemoryGame` WHERE `username`=? ");
            preparedStatement.setString(1, username);
             res2=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataMemoryGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res2;
                    
       
    }
      public ResultSet getselectedlevel(String username)
    {
        

        try {
            preparedStatement=con.prepareStatement("SELECT `current level` FROM `MemoryGame` WHERE `username`=? ");
            preparedStatement.setString(1, username);
             res2=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataMemoryGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res2;
                    
       
    }
     public void updatecurrentlevel(String username,int currentlevel)
    {
        try {
            preparedStatement=con.prepareStatement("UPDATE `MemoryGame` SET `current level`=? WHERE `username`=? ");
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
            preparedStatement=con.prepareStatement("UPDATE `MemoryGame` SET `levelachieved`=? WHERE `username`=? ");
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
            preparedStatement=con.prepareStatement("UPDATE `MemoryGame` SET `score`=?  WHERE `username`=? ");
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
            preparedStatement=con.prepareStatement("UPDATE `MemoryGame` SET `coins`=?  WHERE `username`=? ");
            preparedStatement.setInt(1, coins);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBFetchDataEmojiGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
