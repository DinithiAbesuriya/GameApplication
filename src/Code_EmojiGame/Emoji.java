/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code_EmojiGame;

/**
 *
 * @author dinithi
 */
public class Emoji {
    private int id;
    private String image;
    private String solution;
    private String level;

    public Emoji(int id,String image, String solution) {
        this.id = id;
        this.image = image;
        this.solution = solution;
        //this.level=level;
    }

    public int getId() {
        return id;
    }
    public String getImage() {
        return image;
    }

    public String getSolution() {
        return solution;
    }

    public String getLevel() {
        return level;
    }

    
    
    
    
}
