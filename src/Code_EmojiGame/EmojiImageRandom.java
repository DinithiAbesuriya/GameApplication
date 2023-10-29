/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code_EmojiGame;
import Database.DBFetchDataEmojiGame;
/**
 *
 * @author dinithi
 */
public class EmojiImageRandom {
    DBFetchDataEmojiGame de=new DBFetchDataEmojiGame();
    
    public int RandomImageLevel1()
    {
        //Math.random()*(max-min))+min
        int r=(int) (Math.random() * (2-0)+0);
        
        return r;
    }
    public int RandomImageLevel2()
    {
        //Math.random()*(max-min))+min
        int r=(int) (Math.random() * (4-2)+2);
        
        return r;
    }
    public int RandomImageLevel3()
    {
        //Math.random()*(max-min))+min
        int r=(int) (Math.random() * (2-0)+0);
        
        return r;
    }
    public int RandomImageLevel4()
    {
        //Math.random()*(max-min))+min
        int r=(int) (Math.random() * (2-0)+0);
        
        return r;
    }
}
