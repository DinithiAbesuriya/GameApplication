/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code_SmileGame;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;


/**
 *
 * @author dinithi
 */
public class GameServer {
    
	/** 
	 * Basic utility method to read string for URL. 
	 */

	private static String readUrl(String urlString) {
		
	    try {

	        URL url = new URL(urlString);
	        InputStream inputStream = url.openStream();
	              
	        // Choose anyone of https://stackoverflow.com/questions/309424/how-do-i-read-convert-an-inputstream-into-a-string-in-java
	        // to convert InputStream to String.
	        ByteArrayOutputStream result = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = inputStream.read(buffer)) != -1) {
	            result.write(buffer, 0, length);
	        }	  
	        return result.toString("UTF-8");
	        
	    } catch (Exception e) {
	        System.out.println("An Error occured: "+e.toString());
	        e.printStackTrace();
	        return null; 
	    }

	}

	
	
	
	/**
	 * Retrieves a game for any positive number less than 1000.
	 * 
	 * @param i
	 * @return a random game.
	 * @throws MalformedURLException
	 */
        /**
         * API 
         * @return
         * @throws MalformedURLException 
         */
	public Game getRandomGame() throws MalformedURLException {
		String smileapi = "https://marcconrad.com/uob/smile/api.php?out=csv";
		String dataraw = readUrl(smileapi); 
		String[] data = dataraw.split(","); 
		
		URL quest = new URL(data[0]); 
                System.out.print(quest);
		int solution  = Integer.parseInt(data[1]);  
		System.out.print(solution);
		return new Game(quest, solution);
	}
    
}
