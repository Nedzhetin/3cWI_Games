package at.nejo.StrategyGame;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameVariables {


     public static Image backgroundImg;

     public  static Character player1 = null;
     public  static Character player2 = null;


    public static final Character fireMan = new Character("Pablo",100, Character.TYPE.FIRE,"testdata/fireCharacterImg.png",50,1100);
    public static final Character iceMan = new Character("Cryo",120, Character.TYPE.ICE,"testdata/iceCharacterImg.png",350,1100);
    public static final Character earthMan = new Character("Muhammand",150,Character.TYPE.EARTH,"testdata/earthManImg.png",650,1100);
    public static final Character lightingMan = new Character("Cid",80,Character.TYPE.LIGHTING,"testdata/lightingCharacterImg.png",950,1100);
    public static final Character waterMan = new Character("Muhammad",90,Character.TYPE.WATER,"testdata/waterCharacterImg.png",1250,1100);
    public static final Character windMan = new Character("Mehmet",110,Character.TYPE.WIND,"testdata/windCharacterImg.png",1550,1100);


    public static List<Content> contents = new ArrayList<Content>();




    static {

        contents.add(fireMan);
        contents.add(iceMan);
        contents.add(earthMan);
        contents.add(lightingMan);
        contents.add(waterMan);
        contents.add(windMan);

        try {
            backgroundImg = new Image("testdata/backgroundImg_strategyGame.jpg");
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
    }


}
