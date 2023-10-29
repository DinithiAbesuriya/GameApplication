/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author dinithi
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.crypto.dsig.SignatureMethod;
//import java.sql.Connection;
//import java.sql.DriverManager;

public class DBConnection {
   
    static Connection c;
         
      public Connection getConnection() {
            try {
             
             String user="root";
             String password="";
             String url="jdbc:mysql://localhost:3306/gameApplication";
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection(url,user,password);
            if(c!=null)
            {
                System.out.print("Successful Connection");
                System.out.print(""+c);
              
        
            }
            else{
                System.out.print("Not Successful Connection");
            }
            
              
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          return c;
    } 
    
    
    
   
       
    
    
    
}
