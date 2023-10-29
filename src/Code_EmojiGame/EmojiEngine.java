/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code_EmojiGame;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dinithi
 */
public class EmojiEngine {
    Emoji current=null;
    int score = 0; 
    EmojiServer theGames = new EmojiServer();
     String thePlayer = null;
    public EmojiEngine(String player) {
		thePlayer = player;
	}
    public String nextGame() {		
			
        try {
            current = theGames.getEmojiGame();
            System.out.println("Current in engine= "+current);
        } catch (IOException ex) {
            Logger.getLogger(EmojiEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
				return current.getImage(); 
			
			
			} 
		
	
    public boolean checkSolution(String game, String i) {
		if (i.equalsIgnoreCase(current.getSolution())) {
			score++; 
			return true;
		} else {
			return false;
		}
	}
    public int getScore() {
		return score;
	}

}
