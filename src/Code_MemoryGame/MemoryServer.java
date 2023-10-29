/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code_MemoryGame;

import com.mysql.cj.util.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author dinithi
 */
public class MemoryServer {
   Memory theList[]=theList=new Memory[6];
   int i;
   Memory m;
  // public void getMemory() throws IOException
  // {
       
   public Memory getgame() throws IOException {
   int begin=2,end=124; 
    int length,length2,length3,id=0,matchid=0,matchingtitle1=0,matchingtitle2=0;
            String quest=null,solution=null,image=null;
    
 
   for(int i=0;i<6;i++)
   {
       
       
             JSONParser jsonp=new JSONParser();
            // String smileapi = "http://localhost:8080/api/emojigame/getrandom1";
            URL url=null;
       try {
           url = new URL("http://localhost:8080/api/memorygame/getrandom2/getrandom3");
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
//Memory m=new Memory(id[0], image[0], matchid[0], matchingtitle1[0], matchingtitle1[0]);
                
                
                
         
     
               
           m= new Memory(id, image, matchid, matchingtitle1, matchingtitle2); 
                
            
   
    } 
   }
   return m;
 }
}
    
    

