package at.nejo.StrategyGame;

import at.nejo.StrategyGame.Abilities.*;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.List;

public class GameVariables {

     public static Image backgroundImg;
     public static Image frozenImg;
     public static AngelCodeFont font;
     public static AngelCodeFont font2;


     public static Character player1 = null;
     public static Character player2 = null;
     public static Character currentPlayer = null;
     public static Character opponentPlayer = null;


     public static FireBallAbility fireBallAbility = new FireBallAbility(10,"testdata/fireBallAbilityImg.png",true);
     public static HealAbility healAbility = new HealAbility(-20,"testdata/healAbilityImg.png",false);
     public static SnowBallAbility snowBallAbility = new SnowBallAbility(5,"testdata/snowBallAbilityImg.png",true);
     public static SoilWallAbility soilWallAbility = new SoilWallAbility(0,"testdata/soilWallAbilityImg.png",true,50);
     public static WaterWaveAbility waterWaveAbility = new WaterWaveAbility(15,"testdata/waterWaveImg.png",true);
     public static GiantRockAbility giantRockAbility = new GiantRockAbility(20,"testdata/giantRockAbilityImg.png",true);



    public static final Character fireMan = new Character("Pablo",100, Character.TYPE.FIRE,"testdata/fireCharacterImg.png",30,720,fireBallAbility,healAbility);
    public static final Character iceMan = new Character("Cryo",120, Character.TYPE.ICE,"testdata/waterCharacterImg.png",530,720,snowBallAbility,waterWaveAbility);
    public static final Character earthMan = new Character("Muhammand",150,Character.TYPE.EARTH,"testdata/earthManImg.png",1030,720,soilWallAbility,giantRockAbility);
    public static final Character lightingMan = new Character("Cid",80,Character.TYPE.LIGHTNING,"testdata/lightingCharacterImg.png",1530,720,fireBallAbility,fireBallAbility);
   // public static final Character waterMan = new Character("Muhammad",90,Character.TYPE.WATER,"testdata/waterCharacterImg.png",1250,1100,fireBallAbility,fireBallAbility);
   // public static final Character windMan = new Character("Mehmet",110,Character.TYPE.WIND,"testdata/windCharacterImg.png",1550,1100,fireBallAbility,fireBallAbility);



    public static List<Content> contents = new ArrayList<Content>();




    static {

        contents.add(fireMan);
        contents.add(iceMan);
        contents.add(earthMan);
        contents.add(lightingMan);



        try {
            backgroundImg = new Image("testdata/backgroundImg_strategyGame.jpg");
            font =  new AngelCodeFont("testdata/hiero.fnt","testdata/hiero.png");
            font2 = new AngelCodeFont("testdata/demo2.fnt","testdata/demo2_00.tga");
            frozenImg = new Image("testdata/frozenImg.png");
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean isColliding(float x, float y, Content b) {

        return x < b.getX() + b.getWidth() &&
                x  > b.getX() &&
                y < b.getY() + b.getHeight() &&
                y > b.getY();
    }


    public static boolean isCollidingAbilityCharacter(Ability a, Character b) {

        return a.getX() < b.getX() + b.getWidth()/2 &&
                a.getX() + a.getWidth()/2 > b.getX() &&
                a.getY() < b.getY() + b.getHeight() &&
                a.getY() + a.getHeight() + 300 > b.getY();
    }

    public static boolean isCollidingAbilityAbility(Ability a, Ability b) {

        return a.getX()  < b.getX() + b.getWidth()/2.4 &&
                a.getX()  > b.getX() &&
                a.getY() < b.getY() + b.getHeight() &&
                a.getY() + a.getHeight() > b.getY();
    }


}
