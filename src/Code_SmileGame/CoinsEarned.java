/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code_SmileGame;

/**
 *
 * @author dinithi
 */
import Database.DBConnection;
import Database.DBFetchDataSmileGame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CoinsEarned {
    DBConnection db=new DBConnection();
    Connection con=db.getConnection();
    PreparedStatement preparedStatement;
    ResultSet res,res1;
    DBFetchDataSmileGame ds=new DBFetchDataSmileGame();
    int level,coins;

   public int getcoinsearned(String username)
   {
       res=ds.getselectedlevel(username);
        try {
            if(res.next())
            {
               level=res.getInt("current level");
                System.out.println("Level in coins earned: "+level);
                switch (level) {
                    case 1:
                        coins=coins+100;
                        break;
                    case 2:
                        coins=coins+200;
                        break;
                    case 3:
                        coins=coins+300;
                        break;
                    case 4:
                        coins=coins+400;
                        break;
                    default:
                        break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoinsEarned.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coins;
   }
    
    
}
