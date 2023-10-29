/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code_MemoryGame;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dinithi
 */
public class MemoryEngine {
    Memory current=null;
     Memory theList[]=new Memory[0];; 
    int score = 0,i=0; 
    MemoryServer theGames = new MemoryServer();
     String thePlayer = null;
     
    public MemoryEngine(String player) {
		thePlayer = player;
	}
    
 // public String nextGame() {		
			
        
     //   try {
     //       current = theGames.getMemory();
     //   } catch (IOException ex) {
     //       Logger.getLogger(MemoryEngine.class.getName()).log(Level.SEVERE, null, ex);
     //   }
       //     System.out.println("Current in engine= "+current);
       
	//			return current.getImage(); 
			
			
		//	} 
		
	
   
   
    public int getScore() {
		return score;
	}
}
