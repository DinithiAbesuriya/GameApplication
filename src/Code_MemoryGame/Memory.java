/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code_MemoryGame;

/**
 *
 * @author dinithi
 */
public class Memory {
    private int id;
    private String image;
    private int matchingid;
    private int matchingtitile1;
    private int matchingtitile2;

    public Memory(int id, String image, int matchingid, int matchingtitile1, int matchingtitile2) {
        this.id = id;
        this.image = image;
        this.matchingid = matchingid;
        this.matchingtitile1 = matchingtitile1;
        this.matchingtitile2 = matchingtitile2;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public int getMatchingid() {
        return matchingid;
    }

    public int getMatchingtitile1() {
        return matchingtitile1;
    }

    public int getMatchingtitile2() {
        return matchingtitile2;
    }

   

   
    
}
