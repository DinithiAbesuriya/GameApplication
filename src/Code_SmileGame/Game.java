/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code_SmileGame;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author dinithi
 */
public class Game {
    URL location = null; 
	int solution = -1;
	/**
	 * Location of the game and what is the solution to the game.
	 * @param location
	 * @param solution
	 */
	public Game(URL location, int solution) {
		super();
		this.location = location;
		this.solution = solution;
	}
	/**
	 * The location of the game. 
	 * @return the location of the game.
	 */
	public URL getLocation() {
		return location;
	}

	/**
	 * @return The solution of the game.
	 */
	public int getSolution() {
		return solution;
	}
	
	
	
}
