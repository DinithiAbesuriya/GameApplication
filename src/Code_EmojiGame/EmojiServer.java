/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code_EmojiGame;

import Code_SmileGame.Game;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dinithi
 */
public class EmojiServer {
    
    public Emoji getEmojiGame() throws IOException {
        int length,length2,length3,id=0;
            String quest=null,solution=null;
        try {
            
            // String smileapi = "http://localhost:8080/api/emojigame/getrandom1";
            URL url = new URL("http://localhost:8080/api/emojigame/getrandom1");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println("Line: "+line);
                length=line.length();
                // System.out.println("Length: "+length);
                String line2=line.substring(1, length-1);
                System.out.println("line 2 : "+line2);
                
                
                String[] data = line2.split(",");
                String[] temp=data[2].split(":");
                String[] temp2=data[1].split(":");
                String[] temp3=data[0].split(":");
                //System.out.println("Data Split:"+data[1]);
                length3=temp[1].length();
                length2=temp2[1].length();
                //id=Integer.parseInt(temp3[1]);
                System.out.print("id= "+id);
                quest = temp[1].substring(1,length3-1); 
                System.out.print("QUEST= "+quest);
                solution  = temp2[1].substring(1,length2-1);
                System.out.print(solution);
                
                
                
              
               
          
                
            }    
        } catch (MalformedURLException ex) {	
            Logger.getLogger(EmojiServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Emoji(id,quest,solution);
    }
}
   
       // System.out.println("API: "+smileapi);
        
       
     
    
    
  
    
    

