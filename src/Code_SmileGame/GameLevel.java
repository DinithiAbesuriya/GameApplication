/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code_SmileGame;
import Database.DBFetchDataSmileGame;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author dinithi
 */
public class GameLevel {
    DBFetchDataSmileGame data=new DBFetchDataSmileGame();
    
    ResultSet res;
    int l=0,answer=0;
    public int getNumberOfQuestion(String username)
    {
        
        try {
            res=data.getselectedlevel(username);
            JOptionPane.showMessageDialog(null, "res noofq: "+res);
            
            if(res.next())
            {
               l=res.getInt(username);
               JOptionPane.showMessageDialog(null, "noofq: "+l);
               answer=l;
                System.out.println("Answer for no of q: "+answer);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameLevel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answer;
    }
    
}
